package timaxa007.pack.furniture.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.item.ItemStorage;
import timaxa007.smt.lib.RemoveRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Recipes_Furniture {

	public static void list() {
		
		Item[] list_remove_vanila_door = new Item[] {
				Items.wooden_door, 
				Items.iron_door
		};
		
		RemoveRecipe.removeItem(list_remove_vanila_door);

		GameRegistry.addRecipe(ItemStorage.addNBT(PackFurniture.item.storage, ItemStorage.size_storage.SIZE1), new Object[]{
			"SLS", "LSL", 'L', Items.leather, 'S', Items.string});

		GameRegistry.addRecipe(ItemStorage.addNBT(PackFurniture.item.storage, ItemStorage.size_storage.SIZE2), new Object[]{
			"SSS", "L L", "LCL", 'L', Items.leather, 'S', Items.string, 'C', Blocks.carpet});

		GameRegistry.addRecipe(ItemStorage.addNBT(PackFurniture.item.storage, ItemStorage.size_storage.SIZE3), new Object[]{
			"LSL", "SWS", "LLL", 'L', Items.leather, 'W', Blocks.wool, 'S', Items.string});

		GameRegistry.addRecipe(ItemStorage.addNBT(PackFurniture.item.storage, ItemStorage.size_storage.SIZE4), new Object[]{
			"LLL", "WCW", "LLL", 'L', Items.leather, 'W', Blocks.carpet, 'C', Blocks.chest});

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
