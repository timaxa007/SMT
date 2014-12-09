package mods.timaxa007.Pack.Magic;

import mods.timaxa007.Lib.GetColors;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes_Magic{

public static void list() {

GameRegistry.addShapelessRecipe(testTagAdd(0, "Red"), new Object[]{Item.redstone, Item.cookie});
GameRegistry.addShapelessRecipe(testTagAdd(0, "Ded"), new Object[]{Item.redstone, Item.carrot});
GameRegistry.addShapelessRecipe(testTagAdd(1, "Did"), new Object[]{Item.gunpowder, Item.cookie});
GameRegistry.addShapelessRecipe(testTagAdd(1, "Ded"), new Object[]{Item.gunpowder, Item.carrot});

}

public static ItemStack testTagAdd(int par1, String par2) {
ItemStack is=new ItemStack(PackMagic.proxy.blockSlims, 1, par1);
NBTTagCompound tag=new NBTTagCompound();
tag.setString("Color", par2);
is.setTagCompound(tag);
return is;
}

}
