package mods.timaxa007.pack.techno;

import java.util.Iterator;

import mods.timaxa007.lib.GetColors;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes_Techno{

public static void list() {

Iterator<IRecipe> iterator=CraftingManager.getInstance().getRecipeList().iterator();
while(iterator.hasNext()) {
ItemStack r=iterator.next().getRecipeOutput();
if(r != null && r.itemID==Block.chest.blockID) iterator.remove();
if(r != null && r.itemID==Block.furnaceIdle.blockID) iterator.remove();

if(r != null && r.itemID==Item.shovelWood.itemID) iterator.remove();
if(r != null && r.itemID==Item.shovelStone.itemID) iterator.remove();
if(r != null && r.itemID==Item.shovelIron.itemID) iterator.remove();
if(r != null && r.itemID==Item.shovelGold.itemID) iterator.remove();
if(r != null && r.itemID==Item.shovelDiamond.itemID) iterator.remove();

if(r != null && r.itemID==Item.pickaxeWood.itemID) iterator.remove();
if(r != null && r.itemID==Item.pickaxeStone.itemID) iterator.remove();
if(r != null && r.itemID==Item.pickaxeIron.itemID) iterator.remove();
if(r != null && r.itemID==Item.pickaxeGold.itemID) iterator.remove();
if(r != null && r.itemID==Item.pickaxeDiamond.itemID) iterator.remove();

if(r != null && r.itemID==Item.axeWood.itemID) iterator.remove();
if(r != null && r.itemID==Item.axeStone.itemID) iterator.remove();
if(r != null && r.itemID==Item.axeIron.itemID) iterator.remove();
if(r != null && r.itemID==Item.axeGold.itemID) iterator.remove();
if(r != null && r.itemID==Item.axeDiamond.itemID) iterator.remove();

if(r != null && r.itemID==Item.swordWood.itemID) iterator.remove();
if(r != null && r.itemID==Item.swordStone.itemID) iterator.remove();
if(r != null && r.itemID==Item.swordIron.itemID) iterator.remove();
if(r != null && r.itemID==Item.swordGold.itemID) iterator.remove();
if(r != null && r.itemID==Item.swordDiamond.itemID) iterator.remove();

if(r != null && r.itemID==Item.hoeWood.itemID) iterator.remove();
if(r != null && r.itemID==Item.hoeStone.itemID) iterator.remove();
if(r != null && r.itemID==Item.hoeIron.itemID) iterator.remove();
if(r != null && r.itemID==Item.hoeGold.itemID) iterator.remove();
if(r != null && r.itemID==Item.hoeDiamond.itemID) iterator.remove();

}

GameRegistry.addRecipe(new ItemStack(Block.chest), 
new Object[]{"###", "X X", "###", '#', Block.woodSingleSlab, 'X', Block.planks});
GameRegistry.addRecipe(new ItemStack(Block.furnaceIdle), 
new Object[]{"###", "X X", "###", '#', Block.stoneSingleSlab, 'X', Block.cobblestone});

//shovel
GameRegistry.addRecipe(new ItemStack(Item.shovelWood), 
new Object[]{" # ", " S ", " S ", '#', Block.woodSingleSlab, 'S', Item.stick});
GameRegistry.addRecipe(new ItemStack(Item.shovelStone), 
new Object[]{" # ", " S ", " S ", '#', Block.stoneSingleSlab, 'S', Item.stick});
//pickaxe
GameRegistry.addRecipe(new ItemStack(Item.pickaxeWood), 
new Object[]{"#X#", " S ", " S ", '#', Block.woodSingleSlab, 'X', Block.planks, 'S', Item.stick});
GameRegistry.addRecipe(new ItemStack(Item.pickaxeStone), 
new Object[]{"#X#", " S ", " S ", '#', Block.stoneSingleSlab, 'X', Block.cobblestone, 'S', Item.stick});
//axe
GameRegistry.addRecipe(new ItemStack(Item.axeWood), 
new Object[]{"#X ", "#S ", " S ", '#', Block.woodSingleSlab, 'X', Block.planks, 'S', Item.stick});
GameRegistry.addRecipe(new ItemStack(Item.axeStone), 
new Object[]{"#X ", "#S ", " S ", '#', Block.stoneSingleSlab, 'X', Block.cobblestone, 'S', Item.stick});
//sword
GameRegistry.addRecipe(new ItemStack(Item.swordWood), 
new Object[]{" # ", " # ", " S ", '#', Block.woodSingleSlab, 'S', Item.stick});
GameRegistry.addRecipe(new ItemStack(Item.swordStone), 
new Object[]{" # ", " # ", " S ", '#', Block.stoneSingleSlab, 'S', Item.stick});
//hoe
GameRegistry.addRecipe(new ItemStack(Item.hoeWood), 
new Object[]{"## ", " S ", " S ", '#', Block.woodSingleSlab, 'S', Item.stick});
GameRegistry.addRecipe(new ItemStack(Item.hoeStone), 
new Object[]{"## ", " S ", " S ", '#', Block.stoneSingleSlab, 'S', Item.stick});


//for(byte i=1;i<16;++i) {}

/*
GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 1, GetColors.convertME_MC(i)), 
new Object[]{new ItemStack(core.itemColored, 1, i), new ItemStack(Block.cloth, 1, 0)});
*/

}

}
