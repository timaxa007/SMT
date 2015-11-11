package smt.core.network;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import smt.core.SMTContainer;

import java.io.*;

/**
 * Network manager with involved serialization and serialization
 * Credits to anti344, thanks for part of implementation
 * @see smt.core.network.IPacket
 * @author Dragon2488
 */
public class NetworkManager {

	/*
	 * Channel name, can't be null or empty
	 * Used for channel identification
	 */
	private final String channelName;

	/*
	 * FMLEventChannel, used to handle network
	 * events and send packets
	 */
	private FMLEventChannel channel;

	/*
	 * Constructs new NetworkManager with given channel name
	 * @param channelName channel name, can't be null or empty
	 */
	public NetworkManager(String channelName){
		this.channelName = channelName;
		channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(channelName);
		channel.register(this);

	}

	/*
	 * Converts fml proxy packet to our executable packet
	 * @param proxy fml proxy source packet
	 * @return dump packet on error, otherwise converted packet
	 */
	private IPacket proxyToPacket(FMLProxyPacket proxy){
		try{
			ByteBuf buf = proxy.payload();
			byte[] bytes = buf.readBytes(buf.readShort()).array();
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
			IPacket packet = (IPacket)ois.readObject();
			ois.close();
			return packet;
		}catch(Exception exception){
			SMTContainer.log.error("Invalid packet received!", exception);
			return new DumpPacket();
		}
	}

	/*
	 * Converts our packet to fml proxy packet
	 * @param packet our source packet
	 * @return empty packet on error, otherwise converted packet
	 */
	private FMLProxyPacket packetToProxy(IPacket packet){
		try{
			PacketBuffer buf = new PacketBuffer(Unpooled.buffer());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(packet);
			oos.close();
			buf.writeShort(baos.size()).writeBytes(baos.toByteArray());
			return new FMLProxyPacket(buf, channelName);
		}catch(Exception exception){
			SMTContainer.log.error("Invalid packet wrote!", exception);
			return new FMLProxyPacket(new PacketBuffer(Unpooled.EMPTY_BUFFER), channelName);
		}
	}

	/*
	 * Handle and execute client-received packets
	 */
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void receivedOnClient(FMLNetworkEvent.ClientCustomPacketEvent event){
		proxyToPacket(event.packet).execute(event.side());
	}

	/*
	 * Handle and execute server-received packets
	 */
	@SubscribeEvent
	public void receivedOnServer(FMLNetworkEvent.ServerCustomPacketEvent event){
		proxyToPacket(event.packet).execute(event.side());
	}

	/**
	 * Sends packet from client to server
	 * @param packet packet to send
	 */
	@SideOnly(Side.CLIENT)
	public void sendToServer(IPacket packet){
		channel.sendToServer(packetToProxy(packet));
	}

	/**
	 * Sends packet from server to all clients
	 * @param packet packet to send
	 */
	public void sendToClients(IPacket packet){
		channel.sendToAll(packetToProxy(packet));
	}

	/**
	 * Sends packet from server to player
	 * @param packet packet to send
	 * @param player player
	 */
	public void sendToPlayer(IPacket packet, EntityPlayerMP player){
		channel.sendTo(packetToProxy(packet), player);
	}

	/**
	 * Sends packet from server to all clients in radius
	 * @param packet packet to send
	 * @param x center x
	 * @param y center y
	 * @param z center z
	 * @param range range to send
	 * @param dim dimension id
	 */
	public void sendToArea(IPacket packet, Double x, Double y, Double z, Double range, int dim){
		channel.sendToAllAround(packetToProxy(packet), new NetworkRegistry.TargetPoint(dim, x, y, z, range));
	}

	/**
	 * Sends packet from server to all players in dimension
	 * @param packet packet to send
	 * @param id dimension id
	 */
	public void sendToDimension(IPacket packet, int id){
		channel.sendToDimension(packetToProxy(packet), id);
	}

}