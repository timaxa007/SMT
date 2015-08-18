package timaxa007.pack.furniture.recipe;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import timaxa007.pack.conjoint.lib.RemoveRecipe;
import timaxa007.pack.furniture.PackFurniture;

public class Recipes_Furniture {

	public static void list() {

		Item[] list_remove_vanila_door = new Item[] {
				Items.wooden_door, 
				Items.iron_door
		};

		RemoveRecipe.removeItem(list_remove_vanila_door);

	}

	private static ItemStack setTagCnstorBlock(int par1, int par2, int par3) {
		ItemStack is = new ItemStack(PackFurniture.block.cnstor_block, par3, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("Type", par1);
		nbt.setInteger("Color", par2);
		is.setTagCompound(nbt);
		return is;
	}

	private static ItemStack setTagAirBush(int par1) {
		ItemStack is = new ItemStack(PackFurniture.item.tool_airbrush, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("ColorHex", par1);
		is.setTagCompound(nbt);
		return is;
	}

}
