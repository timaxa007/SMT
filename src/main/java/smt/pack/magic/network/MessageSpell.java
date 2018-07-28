package smt.pack.magic.network;

import java.util.ArrayList;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import smt.pack.magic.item.ItemSpell;
import smt.pack.magic.world.SpellInWorld;

public class MessageSpell implements IMessage {

	public MessageSpell() {}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	@Override
	public void fromBytes(ByteBuf buf) {

	}

	public static class Handler implements IMessageHandler<MessageSpell, IMessage> {

		@Override
		public IMessage onMessage(MessageSpell packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageSpell packet) {
			Minecraft mc = Minecraft.getMinecraft();

		}

		private void act(EntityPlayerMP player, MessageSpell packet) {
			ItemStack itemStack = player.getHeldItem();
			if (itemStack != null && itemStack.getItem() instanceof ItemSpell) {
				ItemSpell itemSpell = (ItemSpell)itemStack.getItem();
				if (itemStack.hasTagCompound()) {
					Block block = null;
					switch(itemStack.getTagCompound().getInteger("ModeSpell")) {
					case 0:block = Blocks.dirt;break;
					case 1:block = Blocks.stone;break;
					case 2:block = Blocks.lava;break;
					case 3:block = Blocks.water;break;
					}

					if (block == null) return;

					ArrayList<ChunkCoordinates> list = new ArrayList<ChunkCoordinates>();

					switch(MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) {
					case 0:
						for (int i = 0; i < 5*3; ++i) {
							int x = (int)player.posX - 2 + i % 5;
							int y = (int)player.posY + i / 5;
							int z = (int)player.posZ + 3;
							if (player.worldObj.isAirBlock(x, y, z)) {
								player.worldObj.setBlock(x, y, z, block, 0, 2);
								list.add(new ChunkCoordinates(x, y, z));
							}
						}
						break;
					case 2:
						for (int i = 0; i < 5*3; ++i) {
							int x = (int)player.posX - 2 + i % 5;
							int y = (int)player.posY + i / 5;
							int z = (int)player.posZ - 3;
							player.worldObj.setBlock(x, y, z, block, 0, 2);
							list.add(new ChunkCoordinates(x, y, z));
						}
						break;
					case 3:
						for (int i = 0; i < 5*3; ++i) {
							int x = (int)player.posX + 3;
							int y = (int)player.posY + i / 5;
							int z = (int)player.posZ - 2 + i % 5;
							player.worldObj.setBlock(x, y, z, block, 0, 2);
							list.add(new ChunkCoordinates(x, y, z));
						}
						break;
					case 1:
						for (int i = 0; i < 5*3; ++i) {
							int x = (int)player.posX - 3;
							int y = (int)player.posY + i / 5;
							int z = (int)player.posZ - 2 + i % 5;
							player.worldObj.setBlock(x, y, z, block, 0, 2);
							list.add(new ChunkCoordinates(x, y, z));
						}
						break;
					}

					SpellInWorld siw = SpellInWorld.get(player.worldObj);
					if (siw != null)
						System.out.println(siw.add(block, 200, list.toArray(new ChunkCoordinates[]{})) + " = " + player.worldObj.provider.dimensionId);

				}
			}
		}

	}

}
