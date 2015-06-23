package timaxa007.pack.techno.tile;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import timaxa007.module.forbidden.api.ITileEntityOwner;
import timaxa007.smt.util.UtilSMT;
import timaxa007.smt.util.UtilString;

public class TileEntityElectricMachines extends TileEntity implements ISidedInventory, ITileEntityOwner {

	private int type;
	private int rot;
	private String owner;

	public TileEntityElectricMachines() {
		type = 0;
		rot = 0;
		owner = "";
	}

	public void setType(int i) {type = i;}
	public int getType() {return type;}

	public void setRot(int i) {rot = i;}
	public int getRot() {return rot;}

	public void setOwner(String username) {owner = username;}
	public String getOwner() {return owner;}

	public void updateEntity() {

		double d0 = 0.0625D;

		AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(
				(double)this.xCoord, (double)this.yCoord, (double)this.zCoord, 
				(double)this.xCoord + 1.0D, (double)this.yCoord + 1.0D, (double)this.zCoord + 1.0D).expand(d0, d0, d0);
		List list = this.worldObj.getEntitiesWithinAABB(Entity.class, axisalignedbb);
		Iterator iterator = list.iterator();
		Entity entity = null;

		while(iterator.hasNext()) {
			entity = (Entity)iterator.next();

			if (entity instanceof EntityItem) {
				EntityItem entity_item = (EntityItem)entity;
				ItemStack is_entity = entity_item.getEntityItem();

				if (is_entity.getItem() == Items.diamond) {
					if (is_entity.stackSize >= 3) {
						UtilSMT.UtilWorld.dropItem(this.worldObj, this.xCoord, this.yCoord, this.zCoord, new ItemStack(Items.golden_apple));
						if (!this.worldObj.isRemote) {if (is_entity.stackSize == 3) entity_item.setDead(); else is_entity.stackSize -= 3;}
						break;
					}

				}

			}

		}

	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
		if (nbt.hasKey("Rot")) rot = nbt.getInteger("Rot");
		if (nbt.hasKey("Owner")) owner = nbt.getString("Owner");

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("Type", type);
		nbt.setInteger("Rot", rot);
		if (UtilString.hasString(owner)) nbt.setString("Owner", owner);

	}

	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		return null;
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {

	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return false;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		return false;
	}

}
