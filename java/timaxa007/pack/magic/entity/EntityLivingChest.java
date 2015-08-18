package timaxa007.pack.magic.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import timaxa007.gui.HandlerGuiSMT;
import timaxa007.gui.container.EntityLivingChestContainer;
import timaxa007.gui.gui.EntityLivingChestGui;
import timaxa007.gui.iinventory.InventoryEntityLivingChest;

public class EntityLivingChest extends EntityLiving implements IInvBasic {

	public InventoryEntityLivingChest inventory = new InventoryEntityLivingChest(this);

	public EntityLivingChest(World world) {
		super(world);
	}

	@Override
	public boolean interact(EntityPlayer player) {
		if (player != null) {
			if (!player.worldObj.isRemote) 
				HandlerGuiSMT.openContainer(new EntityLivingChestContainer(player, this), player);
			else
				HandlerGuiSMT.openGui(new EntityLivingChestGui(player, this));
			return true;
		}
		return false;
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);

		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		inventory.inv = new ItemStack[inventory.getSizeInventory()];

		//if (nbt.hasKey("CustomName", 8)) customName = nbt.getString("CustomName");

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < inventory.inv.length) {
				inventory.inv[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);

		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < inventory.inv.length; ++i) {
			if (inventory.inv[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				inventory.inv[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbt.setTag("Items", nbttaglist);

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		//if (hasCustomInventoryName()) nbt.setString("CustomName", customName);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	@Override
	public void onInventoryChanged(InventoryBasic ib) {

	}

}
