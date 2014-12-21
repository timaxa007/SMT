package mods.timaxa007.pack.furniture.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFurnitureMachines extends TileEntity {

	private int type;
	private int rotation;

	public TileEntityFurnitureMachines() {
		type = 0;
		rotation = 0;
	}

	public void setType(int i) {
		type = i;
	}

	public void setRotation(int i) {
		rotation = i;
	}

	public int getType() {
		return type;
	}

	public int getRotation() {
		return rotation;
	}

	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
