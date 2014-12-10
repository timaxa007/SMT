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
if(r != null && r.getItem()==Block.chest) iterator.remove();
if(r != null && r.getItem()==Block.furnaceIdle) iterator.remove();

if(r != null && r.getItem()==Item.shovelWood.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.shovelStone.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.shovelIron.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.shovelGold.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.shovelDiamond.getItem()) iterator.remove();

if(r != null && r.getItem()==Item.pickaxeWood.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.pickaxeStone.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.pickaxeIron.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.pickaxeGold.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.pickaxeDiamond.getItem()) iterator.remove();

if(r != null && r.getItem()==Item.axeWood.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.axeStone.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.axeIron.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.axeGold.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.axeDiamond.getItem()) iterator.remove();

if(r != null && r.getItem()==Item.swordWood.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.swordStone.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.swordIron.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.swordGold.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.swordDiamond.getItem()) iterator.remove();

if(r != null && r.getItem()==Item.hoeWood.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.hoeStone.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.hoeIron.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.hoeGold.getItem()) iterator.remove();
if(r != null && r.getItem()==Item.hoeDiamond.getItem()) iterator.remove();

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
