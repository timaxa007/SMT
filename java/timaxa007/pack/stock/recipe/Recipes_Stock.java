package timaxa007.pack.stock.recipe;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes_Stock {

	public static void list() {
/*
		GameRegistry.addRecipe(addNBTCake(PackStock.block_cakes, "Standart"), new Object[]{
			"SGS", "WVW", 'W', Items.wheat, 'S', Items.sugar, 'V', Items.milk_bucket, 'G', Items.egg});

		GameRegistry.addRecipe(addNBTCake(PackStock.block_cakes, "Fruity"), new Object[]{
			"III", "SGS", "WVW", 'W', Items.wheat, 'S', Items.sugar, 'V', Items.milk_bucket, 'G', Items.egg, 'I', Items.melon});

		GameRegistry.addRecipe(addNBTCake(PackStock.block_cakes, "Berry"), new Object[]{
			"III", "SGS", "WVW", 'W', Items.wheat, 'S', Items.sugar, 'V', Items.milk_bucket, 'G', Items.egg, 'I', Items.cookie});

		GameRegistry.addRecipe(addNBTCake(PackStock.block_cakes, "Vegetable"), new Object[]{
			"III", "SGS", "WVW", 'W', Items.wheat, 'S', Items.sugar, 'V', Items.milk_bucket, 'G', Items.egg, 'I', Blocks.pumpkin});

		GameRegistry.addRecipe(addNBTCake(PackStock.block_cakes, "Meat"), new Object[]{
			"III", "SGS", "WVW", 'W', Items.wheat, 'S', Items.sugar, 'V', Items.milk_bucket, 'G', Items.egg, 'I', Items.porkchop});
*/
	}

	public static ItemStack addNBTCake(Block par1, String par2) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Type", par2);
		is.setTagCompound(nbt);
		return is;
	}

}
