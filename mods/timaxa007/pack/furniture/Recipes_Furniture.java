package mods.timaxa007.pack.furniture;

import mods.timaxa007.lib.GetColors;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes_Furniture {

public static void list() {
//white+colored=colored|not/black;
for (byte i = 1; i < 16; ++i) {
GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 1, GetColors.convertME_MC(i)), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, i), new ItemStack(Block.cloth, 1, 0)});
}
//white+black=gray;
GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 1, 7), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, 0), new ItemStack(Block.cloth, 1, 0)});
//gray+black=black;
GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 1, 15), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, 0), new ItemStack(Block.cloth, 1, 7)});
//black+white=LightGray;
GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 1, 8), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, 14), new ItemStack(Block.cloth, 1, 15)});
//LightGray+white=white;
GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 1, 0), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, 14), new ItemStack(Block.cloth, 1, 8)});
//black+LightGray=gray;
GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 1, 7), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, 13), new ItemStack(Block.cloth, 1, 15)});
//gray+white=LightGray;
GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 1, 8), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, 14), new ItemStack(Block.cloth, 1, 7)});
//white+black+black=black;
GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 1, 15), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, 0), new ItemStack(PackFurniture.proxy.item_colored, 1, 0), new ItemStack(Block.cloth, 1, 0)});
//white+black+gray=black;
GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 1, 15), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, 4), new ItemStack(PackFurniture.proxy.item_colored, 1, 0), new ItemStack(Block.cloth, 1, 0)});

for (byte i = 0; i < 16; ++i) {
GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block_lamps_click_off, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Block.thinGlass, 'L', Item.glowstone, 'P', Block.lever, 'X', new ItemStack(PackFurniture.proxy.item_colored, 1, i)});
GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block_lamps_off, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Block.thinGlass, 'L', Item.glowstone, 'P', Item.redstone, 'X', new ItemStack(PackFurniture.proxy.item_colored, 1, i)});
GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block_lamps_on_invert, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Block.thinGlass, 'L', Item.glowstone, 'P', Block.torchRedstoneActive, 'X', new ItemStack(PackFurniture.proxy.item_colored, 1, i)});

GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block_lamps_click_off, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Block.thinGlass, 'L', Item.glowstone, 'P', Block.lever, 'X', new ItemStack(Item.dyePowder, 1, GetColors.convertME_MCitem(i))});
GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block_lamps_off, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Block.thinGlass, 'L', Item.glowstone, 'P', Item.redstone, 'X', new ItemStack(Item.dyePowder, 1, GetColors.convertME_MCitem(i))});
GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block_lamps_on_invert, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Block.thinGlass, 'L', Item.glowstone, 'P', Block.torchRedstoneActive, 'X', new ItemStack(Item.dyePowder, 1, GetColors.convertME_MCitem(i))});
}
/*
for (byte i = 0; i < 16; ++i) {
GameRegistry.addShapelessRecipe(new ItemStack(PackFurniture.proxy.block_brick_clay_colors, 1, i), new Object[] {
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, 32), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, 32)});
}

for (byte i = 0; i < 16; ++i) {
GameRegistry.addShapelessRecipe(new ItemStack(PackFurniture.proxy.block_brick_stone_colors, 1, i), new Object[] {
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i+16), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i+16), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i+16), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i+16), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, 32), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, 32)});
}*/
//Colored Brick Clay
for (byte i = 0; i < 16; ++i) {
GameRegistry.addShapelessRecipe(new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, i), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, 33)});
}
//Colored Brick Stone
for (byte i = 0; i < 16; ++i) {
GameRegistry.addShapelessRecipe(new ItemStack(PackFurniture.proxy.item_brick_colors, 1, i+16), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, i), 
new ItemStack(PackFurniture.proxy.item_brick_colors, 1, 34)});
}

for (byte i = 0; i < 16; ++i) {
GameRegistry.addShapelessRecipe(setTagAirBush(GetColors.getHexColors[i]), new Object[] {
new ItemStack(PackFurniture.proxy.item_colored, 1, i), 
new ItemStack(PackFurniture.proxy.tool_airbrush, 1, 0)});
}

for (byte i = 0; i < PackFurniture.proxy.item_filter_charcoal.getMaxDamage(); ++i) {
GameRegistry.addShapelessRecipe(new ItemStack(Item.glassBottle), new Object[] {
new ItemStack(PackFurniture.proxy.item_filter_charcoal, 1 , i), 
new ItemStack(Item.potion)});
}

for (byte i = 1; i <= PackFurniture.proxy.item_filter_charcoal.getMaxDamage(); ++i) {
GameRegistry.addShapelessRecipe(new ItemStack(PackFurniture.proxy.item_filter_charcoal, 1, 0), 
new Object[] {
new ItemStack(PackFurniture.proxy.item_filter_charcoal, 1 , i), 
new ItemStack(Item.coal, 1 , 1)});
}

GameRegistry.addRecipe(setTagCnstorBlock(0, 0xFFFFFF, 6), new Object[] {
"SWS", "WBW", "SWS", 'W', Block.planks, 'B', Item.stick, 'S', Item.stick});

GameRegistry.addRecipe(setTagCnstorBlock(1, 0xFFFFFF, 4), new Object[] {
"SWS", "WBW", "SWS", 'W', Block.planks, 'B', Block.anvil, 'S', Item.stick});

GameRegistry.addRecipe(setTagCnstorBlock(2, 0xFFFFFF, 4), new Object[] {
"SWS", "WBW", "SWS", 'W', Block.planks, 'B', Block.bedrock, 'S', Item.stick});

GameRegistry.addRecipe(setTagCnstorBlock(3, 0xFFFFFF, 4), new Object[] {
"SWS", "WBW", "SWS", 'W', Block.planks, 'B', Block.brick, 'S', Item.stick});

GameRegistry.addRecipe(setTagCnstorBlock(4, 0xFFFFFF, 4), new Object[] {
"SWS", "WBW", "SWS", 'W', Block.planks, 'B', Block.blockClay, 'S', Item.stick});
/*
String[] dyes = {
"dyeBlack", 
"dyeRed", 
"dyeGreen", 
"dyeBrown", 
"dyeBlue", 
"dyePurple", 
"dyeCyan", 
"dyeLightGray", 
"dyeGray", 
"dyePink", 
"dyeLime", 
"dyeYellow", 
"dyeLightBlue", 
"dyeMagenta", 
"dyeOrange", 
"dyeWhite"
};

for (int i = 0; i < 16; ++i) {
GameRegistry.addRecipe(new ShapelessOreRecipe(Item.stick, new Object[]{dyes[i], Item.stick}));
}
*/
//MincerRecipes.mince().addMince(Item.bakedPotato.itemID, 0, new ItemStack(PackFurniture.itemColored, 1, 0));

}

private static ItemStack setTagCnstorBlock(int par1, int par2, int par3) {
ItemStack is = new ItemStack(PackFurniture.proxy.block_cnstor_block, par3, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Type", par1);
tag.setInteger("Color", par2);
is.setTagCompound(tag);
return is;
}

private static ItemStack setTagAirBush(int par1) {
ItemStack is = new ItemStack(PackFurniture.proxy.tool_airbrush, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("HexColor", par1);
is.setTagCompound(tag);
return is;
}

}
