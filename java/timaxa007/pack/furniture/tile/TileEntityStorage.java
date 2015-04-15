package timaxa007.pack.furniture.tile;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import timaxa007.pack.furniture.gui.StorageContainer;
import timaxa007.tms.util.UtilString;

public class TileEntityStorage extends TileEntity implements IInventory {

	private ItemStack[] slots_storage = new ItemStack[36];

	private static String tag;
	private static String owner;
	private static int rotation;
	private static String style;
	private static String custom_name;
	public static float rotation_door;

	public boolean adjacentChestChecked;
	public float lidAngle;
	public float prevLidAngle;
	public int numPlayersUsing;
	private int ticksSinceSync;

	public TileEntityStorage() {
		tag = "";
		owner = "";
		rotation = 0;
		style = "";
		custom_name = "";
		numPlayersUsing = 0;
		rotation_door = 0.0F;
	}

	public void updateEntity() {
		super.updateEntity();
		++ticksSinceSync;
		float f;

		if (!worldObj.isRemote && numPlayersUsing != 0 && (ticksSinceSync + xCoord + yCoord + zCoord) % 200 == 0) {
			numPlayersUsing = 0;
			f = 5.0F;
			List list = worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox((double)((float)xCoord - f), (double)((float)yCoord - f), (double)((float)zCoord - f), (double)((float)(xCoord + 1) + f), (double)((float)(yCoord + 1) + f), (double)((float)(zCoord + 1) + f)));
			Iterator iterator = list.iterator();

			while (iterator.hasNext()) {
				EntityPlayer entityplayer = (EntityPlayer)iterator.next();

				if (entityplayer.openContainer instanceof StorageContainer) {
					IInventory iinventory = ((StorageContainer)entityplayer.openContainer).getStorageInventory();

					if (iinventory == this || iinventory instanceof InventoryLargeChest && ((InventoryLargeChest)iinventory).isPartOfLargeChest(this)) {
						++numPlayersUsing;
					}
				}
			}
		}

		prevLidAngle = lidAngle;
		f = 0.1F;
		double d2;

		if (numPlayersUsing > 0 && lidAngle == 0.0F) {
			double d1 = (double)xCoord + 0.5D;
			d2 = (double)zCoord + 0.5D;

			worldObj.playSoundEffect(d1, (double)yCoord + 0.5D, d2, "random.chestopen", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
		}

		if (numPlayersUsing == 0 && lidAngle > 0.0F || numPlayersUsing > 0 && lidAngle < 1.0F) {
			float f1 = lidAngle;

			if (numPlayersUsing > 0) {
				lidAngle += f;
			} else {
				lidAngle -= f;
			}

			if (lidAngle > 1.0F) {
				lidAngle = 1.0F;
			}

			float f2 = 0.5F;

			if (lidAngle < f2 && f1 >= f2) {
				d2 = (double)xCoord + 0.5D;
				double d0 = (double)zCoord + 0.5D;

				worldObj.playSoundEffect(d2, (double)yCoord + 0.5D, d0, "random.chestclosed", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
			}

			if (lidAngle < 0.0F) {
				lidAngle = 0.0F;
			}
		}
	}

	public void setTag(String tag) {this.tag = tag;}
	public String getTag() {return tag;}

	public void setOwner(String owner) {this.owner = owner;}
	public String getOwner() {return owner;}

	public void setRotation(int rotation) {this.rotation = rotation;}
	public int getRotation() {return rotation;}

	public void setStyle(String style) {this.style = style;}
	public String getStyle() {return style;}

	public void setCustomName(String custom_name) {this.custom_name = custom_name;}
	public String getCustomName() {return custom_name;}

	//public void setNumPlayersUsing(int numPlayersUsing) {this.numPlayersUsing = numPlayersUsing;}
	public int getNumPlayersUsing() {return numPlayersUsing;}

	@Override
	public int getSizeInventory() {
		return slots_storage.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return slots_storage[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (slots_storage[i] != null) {
			ItemStack itemstack;

			if (slots_storage[i].stackSize <= j) {
				itemstack = slots_storage[i];
				slots_storage[i] = null;
				markDirty();
				return itemstack;
			} else {
				itemstack = slots_storage[i].splitStack(j);

				if (slots_storage[i].stackSize == 0)
					slots_storage[i] = null;

				markDirty();
				return itemstack;
			}
		}
		else return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (slots_storage[i] != null) {
			ItemStack itemstack = slots_storage[i];
			slots_storage[i] = null;
			return itemstack;
		} else return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack is) {
		slots_storage[i] = is;

		if (is != null && is.stackSize > this.getInventoryStackLimit())
			is.stackSize = getInventoryStackLimit();

		this.markDirty();
	}

	@Override
	public String getInventoryName() {
		return (UtilString.hasString(custom_name) ? custom_name : "storage");
	}

	@Override
	public boolean hasCustomInventoryName() {
		return UtilString.hasString(custom_name);
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {
		if (numPlayersUsing < 0) numPlayersUsing = 0;
		++numPlayersUsing;
	}

	@Override
	public void closeInventory() {
		--numPlayersUsing;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack is) {
		return true;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		slots_storage = new ItemStack[getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < slots_storage.length) {
				slots_storage[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		if (nbt.hasKey("Tag")) tag = nbt.getString("Tag");
		if (nbt.hasKey("Owner")) owner = nbt.getString("Owner");
		if (nbt.hasKey("Rotation")) rotation = (int)nbt.getByte("Rotation");
		if (nbt.hasKey("Style")) style = nbt.getString("Style");
		if (nbt.hasKey("CustomName")) custom_name = nbt.getString("CustomName");

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < slots_storage.length; ++i) {
			if (slots_storage[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				slots_storage[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbt.setTag("Items", nbttaglist);

		if (UtilString.hasString(tag)) nbt.setString("Tag", tag);
		if (UtilString.hasString(owner)) nbt.setString("Owner", owner);
		nbt.setByte("Rotation", (byte)rotation);
		if (UtilString.hasString(style)) nbt.setString("Style", style);
		if (UtilString.hasString(custom_name)) nbt.setString("CustomName", custom_name);
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
