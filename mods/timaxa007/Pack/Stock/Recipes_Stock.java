package mods.timaxa007.Pack.Stock;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes_Stock {

public static void list() {

GameRegistry.addRecipe(addTagCake(PackStock.proxy.block_cakes, "Standart"), new Object[]{
"SGS", "WVW", 'W', Item.wheat, 'S', Item.sugar, 'V', Item.bucketMilk, 'G', Item.egg});

GameRegistry.addRecipe(addTagCake(PackStock.proxy.block_cakes, "Fruity"), new Object[]{
"III", "SGS", "WVW", 'W', Item.wheat, 'S', Item.sugar, 'V', Item.bucketMilk, 'G', Item.egg, 'I', Item.melon});

GameRegistry.addRecipe(addTagCake(PackStock.proxy.block_cakes, "Berry"), new Object[]{
"III", "SGS", "WVW", 'W', Item.wheat, 'S', Item.sugar, 'V', Item.bucketMilk, 'G', Item.egg, 'I', Item.cookie});

GameRegistry.addRecipe(addTagCake(PackStock.proxy.block_cakes, "Vegetable"), new Object[]{
"III", "SGS", "WVW", 'W', Item.wheat, 'S', Item.sugar, 'V', Item.bucketMilk, 'G', Item.egg, 'I', Block.pumpkin});

GameRegistry.addRecipe(addTagCake(PackStock.proxy.block_cakes, "Meat"), new Object[]{
"III", "SGS", "WVW", 'W', Item.wheat, 'S', Item.sugar, 'V', Item.bucketMilk, 'G', Item.egg, 'I', Item.porkRaw});

}

private static ItemStack addTagCake(Block par1, String par2) {
ItemStack is = new ItemStack(par1, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setString("Type", par2);
is.setTagCompound(tag);
return is;
}

}
