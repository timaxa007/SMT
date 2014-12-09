package mods.timaxa007.Pack.Mining;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes_Mining{

public static void list() {
//GameRegistry.addRecipe(new ShapedOreRecipe(Item.bucketEmpty, new Object[]{"T T", " C ", 'C', "ignotCopper", 'T', "ignotTin"}));
/*
for(byte i=0;i<16;++i) {
GameRegistry.addRecipe(addTagTool(new ItemStack(PackMining.toolSword, 1, 0), i), new Object[]{"M", "M", "S", 'S', Item.stick, 'M', new ItemStack(PackMining.itemMetals, 1, i+48)});
GameRegistry.addRecipe(addTagTool(new ItemStack(PackMining.toolAxe, 1, 0), i), new Object[]{"MM", "MS", " S", 'S', Item.stick, 'M', new ItemStack(PackMining.itemMetals, 1, i+48)});
GameRegistry.addRecipe(addTagTool(new ItemStack(PackMining.toolAxe, 1, 0), i), new Object[]{"MM", "SM", "S ", 'S', Item.stick, 'M', new ItemStack(PackMining.itemMetals, 1, i+48)});
GameRegistry.addRecipe(addTagTool(new ItemStack(PackMining.toolPickaxe, 1, 0), i), new Object[]{"MMM", " S ", " S ", 'S', Item.stick, 'M', new ItemStack(PackMining.itemMetals, 1, i+48)});
GameRegistry.addRecipe(addTagTool(new ItemStack(PackMining.toolShovel, 1, 0), i), new Object[]{"M", "S", "S", 'S', Item.stick, 'M', new ItemStack(PackMining.itemMetals, 1, i+48)});
GameRegistry.addRecipe(addTagTool(new ItemStack(PackMining.toolHoe, 1, 0), i), new Object[]{"MM", " S", " S", 'S', Item.stick, 'M', new ItemStack(PackMining.itemMetals, 1, i+48)});
GameRegistry.addRecipe(addTagTool(new ItemStack(PackMining.toolHoe, 1, 0), i), new Object[]{"MM", "S ", "S ", 'S', Item.stick, 'M', new ItemStack(PackMining.itemMetals, 1, i+48)});
}
*/
}

private static ItemStack addTag(ItemStack par1, int par2) {
ItemStack is=par1;
NBTTagCompound tag=new NBTTagCompound();
tag.setInteger("Color", par2);
//tag.setInteger("HexColor", GetColors.getHexColors[par2]);
is.setTagCompound(tag);
return is;
}

}
