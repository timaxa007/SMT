package smt.pack.decorative.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import smt.pack.ActionInventory;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityStand extends TileEntity {

	private IInventory inventoryMain = new InventoryBasic("InventoryStandMain", false, 1);
	@SideOnly(Side.CLIENT)
	public short age = 0;

	public TileEntityStand() {
		//if (age >= Short.MAX_VALUE) age = 0; else age += 1;
	}

	@Override
	public void updateEntity() {

	}

	public void setItemStack(ItemStack item) {
		getInventory().setInventorySlotContents(0, item);
	}

	public ItemStack getItemStack() {
		return getInventory().getStackInSlot(0);
	}

	public IInventory getInventory() {
		return inventoryMain;
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		inventoryMain = ActionInventory.readFromNBT(nbt, inventoryMain);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		ActionInventory.writeToNBT(nbt, inventoryMain);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
