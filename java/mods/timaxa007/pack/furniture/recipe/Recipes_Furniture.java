package mods.timaxa007.pack.furniture.recipe;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Recipes_Furniture {

	public static void list() {

	}

	private static ItemStack setTagCnstorBlock(int par1, int par2, int par3) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.cnstor_block, par3, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("Type", par1);
		nbt.setInteger("Color", par2);
		is.setTagCompound(nbt);
		return is;
	}

	private static ItemStack setTagAirBush(int par1) {
		ItemStack is = new ItemStack(PackFurniture.proxy.item.tool_airbrush, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("HexColor", par1);
		is.setTagCompound(nbt);
		return is;
	}

}
