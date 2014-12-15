package mods.timaxa007.pack.stock;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes_Stock {

public static void list() {
/*
GameRegistry.addRecipe(addTagCake(PackStock.proxy.block_cakes, "Standart"), new Object[]{
"SGS", "WVW", 'W', Items.wheat, 'S', Items.sugar, 'V', Items.milk_bucket, 'G', Items.egg});

GameRegistry.addRecipe(addTagCake(PackStock.proxy.block_cakes, "Fruity"), new Object[]{
"III", "SGS", "WVW", 'W', Items.wheat, 'S', Items.sugar, 'V', Items.milk_bucket, 'G', Items.egg, 'I', Items.melon});

GameRegistry.addRecipe(addTagCake(PackStock.proxy.block_cakes, "Berry"), new Object[]{
"III", "SGS", "WVW", 'W', Items.wheat, 'S', Items.sugar, 'V', Items.milk_bucket, 'G', Items.egg, 'I', Items.cookie});

GameRegistry.addRecipe(addTagCake(PackStock.proxy.block_cakes, "Vegetable"), new Object[]{
"III", "SGS", "WVW", 'W', Items.wheat, 'S', Items.sugar, 'V', Items.milk_bucket, 'G', Items.egg, 'I', Blocks.pumpkin});

GameRegistry.addRecipe(addTagCake(PackStock.proxy.block_cakes, "Meat"), new Object[]{
"III", "SGS", "WVW", 'W', Items.wheat, 'S', Items.sugar, 'V', Items.milk_bucket, 'G', Items.egg, 'I', Items.porkchop});
*/
}

private static ItemStack addTagCake(Block par1, String par2) {
ItemStack is = new ItemStack(par1, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setString("Type", par2);
is.setTagCompound(tag);
return is;
}

}
