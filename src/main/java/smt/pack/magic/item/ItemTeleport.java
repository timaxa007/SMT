package smt.pack.magic.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.magic.SMTMagic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTeleport extends Item {

	public ItemTeleport() {
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt == null || nbt != null && (!nbt.hasKey("CordX") || !nbt.hasKey("CordZ"))) {
			ItemStack newItem = addNBT(itemStack.copy(), player.dimension, player.posX, player.posY, player.posZ);
			if (!player.inventory.addItemStackToInventory(newItem))
				player.dropPlayerItemWithRandomChoice(newItem, false);
		}
		else if (!world.isRemote && nbt.hasKey("CordX") && nbt.hasKey("CordZ")) {

			if (nbt.hasKey("DimensionId", NBT.TAG_INT)) {
				int dimId = nbt.getInteger("DimensionId");
				if (player.dimension != dimId) player.travelToDimension(dimId);
			}

			double cordX = 0D;
			double cordY = 0D;
			double cordZ = 0D;

			if (nbt.hasKey("CordX", NBT.TAG_DOUBLE))
				cordX = nbt.getDouble("CordX");
			else if (nbt.hasKey("CordX", NBT.TAG_INT))
				cordX = (double)nbt.getInteger("CordX") + 0.5D;

			if (nbt.hasKey("CordZ", NBT.TAG_DOUBLE))
				cordZ = nbt.getDouble("CordZ");
			else if (nbt.hasKey("CordZ", NBT.TAG_INT))
				cordZ = (double)nbt.getInteger("CordZ") + 0.5D;

			if (nbt.hasKey("CordY", NBT.TAG_DOUBLE))
				cordY = nbt.getDouble("CordY");
			else if (nbt.hasKey("CordY", NBT.TAG_INT))
				cordY = (double)nbt.getInteger("CordY") + 1D;
			else
				cordY = (double)world.getTopSolidOrLiquidBlock((int)cordX, (int)cordZ);

			player.setPositionAndUpdate(cordX, cordY, cordZ);
		}
		if (!player.capabilities.isCreativeMode) {
			--itemStack.stackSize;
			/*if (is.stackSize == 0)
				if (is == player.getCurrentEquippedItem())
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				else
					is = null;*/
		}
		return super.onItemRightClick(itemStack, world, player);
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null) {
			String text = "";

			if (nbt.hasKey("DimensionId", NBT.TAG_INT))
				text += "DimensionId - " + nbt.getInteger("DimensionId");
			else
				text += "This dimension";

			if (nbt.hasKey("CordX", NBT.TAG_DOUBLE))
				text += ", CordX - " + String.format("%.2f", nbt.getDouble("CordX"));
			if (nbt.hasKey("CordY", NBT.TAG_DOUBLE))
				text += ", CordY - " + String.format("%.2f", nbt.getDouble("CordY"));
			if (nbt.hasKey("CordZ", NBT.TAG_DOUBLE))
				text += ", CordZ - " + String.format("%.2f", nbt.getDouble("CordZ"));

			if (nbt.hasKey("CordX", NBT.TAG_INT))
				text += ", CordX - " + nbt.getInteger("CordX");
			if (nbt.hasKey("CordY", NBT.TAG_INT))
				text += ", CordY - " + nbt.getInteger("CordY");
			if (nbt.hasKey("CordZ", NBT.TAG_INT))
				text += ", CordZ - " + nbt.getInteger("CordZ");

			text += ".";

			list.add(text);
		} else {
			list.add("Empty scroll.");
		}
	}
	/*
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null && 
				((
						nbt.hasKey("CordX", NBT.TAG_DOUBLE) && 
						nbt.hasKey("CordY", NBT.TAG_DOUBLE) && 
						nbt.hasKey("CordZ", NBT.TAG_DOUBLE)
						) || (
								nbt.hasKey("CordX", NBT.TAG_INT) && 
								nbt.hasKey("CordY", NBT.TAG_INT) && 
								nbt.hasKey("CordZ", NBT.TAG_INT)
								))
				) {
			list.add("Write scroll.");
		} else {
			list.add("Empty scroll.");
		}
	}
	 */

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(new ItemStack(id));
		//list.add(addNBT(new ItemStack(id), 0, 0, 0, 0));
	}

	public static ItemStack addNBT(ItemStack itemStack, int dimensionId, double x, double y, double z) {
		if (itemStack == null)
			itemStack = new ItemStack(SMTMagic.item.teleport, 1, 0);
		else
			itemStack.stackSize = 1;
		NBTTagCompound nbt;
		if (itemStack.hasTagCompound())
			nbt = itemStack.getTagCompound();
		else
			nbt = new NBTTagCompound();
		nbt.setInteger("DimensionId", dimensionId);
		nbt.setDouble("CordX", x);
		nbt.setDouble("CordY", y);
		nbt.setDouble("CordZ", z);
		itemStack.setTagCompound(nbt);
		return itemStack;
	}

	public static ItemStack addNBT(ItemStack itemStack, int dimensionId, int x, int y, int z) {
		if (itemStack == null)
			itemStack = new ItemStack(SMTMagic.item.teleport, 1, 0);
		else
			itemStack.stackSize = 1;
		NBTTagCompound nbt;
		if (itemStack.hasTagCompound())
			nbt = itemStack.getTagCompound();
		else
			nbt = new NBTTagCompound();
		nbt.setInteger("DimensionId", dimensionId);
		nbt.setInteger("CordX", x);
		nbt.setInteger("CordY", y);
		nbt.setInteger("CordZ", z);
		itemStack.setTagCompound(nbt);
		return itemStack;
	}

}
