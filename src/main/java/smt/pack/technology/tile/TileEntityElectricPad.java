package smt.pack.technology.tile;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.AxisAlignedBB;
import smt.pack.technology.api.IElectricItem;
import smt.pack.technology.api.object.TileEntityElectricDummy;

public class TileEntityElectricPad extends TileEntityElectricDummy {

	//private IInventory inventoryMain = new InventoryBasic("InventoryTeleport", false, 1);
	private int energy;
	private int energyMax;

	public TileEntityElectricPad() {
		energy = 500;
		energyMax = 1000;//Tier I
	}

	@Override
	public void updateEntity() {

		int addCharge = 50;

		if (canWork()) {
			AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)xCoord, (double)yCoord, (double)zCoord, (double)(xCoord + 1), (double)(yCoord + 1), (double)(zCoord + 1)).expand(0.1D, 0.1D, 0.1D);
			List list = worldObj.getEntitiesWithinAABB(Entity.class, axisalignedbb);
			Iterator iterator = list.iterator();
			Entity entity;

			while (iterator.hasNext()) {
				entity = (Entity)iterator.next();

				if (entity instanceof EntityItem) {
					EntityItem ei = (EntityItem)entity;
					ItemStack itemStack = ei.getEntityItem();
					if (canWork(-addCharge) && charge(itemStack, addCharge)) break; else continue;
					//break;
				}

				if (entity instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer)entity;
					for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
						ItemStack slot = player.inventory.getStackInSlot(i);
						if (canWork(-addCharge) && charge(slot, addCharge)) break; else continue;
					}
					//break;
				}

			}

		}

	}

	public boolean charge(ItemStack itemStack, int i) {
		if (i == 0) return false;
		if (itemStack != null && itemStack.getItem() instanceof IElectricItem) {
			IElectricItem ie = (IElectricItem)itemStack.getItem();
			boolean plus = ie.getEnergyMax(itemStack) >= ie.getEnergy(itemStack) + i;
			boolean minus = 0 <= ie.getEnergy(itemStack) + i;
			if (ie.isCharging(itemStack) && i >= 0 ? plus : minus) {
				ie.addEnergy(itemStack, i);
				addEnergy(-i);
				return true;
			}
		}
		return false;
	}

	public boolean canWork() {
		return canWork(0);
	}

	public boolean canWork(int i) {
		boolean plus = energyMax >= energy + i;
		boolean minus = 0 <= energy + i;
		return i == 0 ? (plus && minus) : i > 0 ? plus : minus;
	}

	@Override
	public int getRateMax() {
		return 10;
	}

	@Override
	public boolean isCharging() {
		return true;
	}

	@Override
	public boolean isDischarging() {
		return false;
	}

	/*
	public IInventory getInventory() {
		return inventoryMain;
	}
	 */
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		//inventoryMain = ActionInventory.readFromNBT(nbt, inventoryMain);

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		//ActionInventory.writeToNBT(nbt, inventoryMain);

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
