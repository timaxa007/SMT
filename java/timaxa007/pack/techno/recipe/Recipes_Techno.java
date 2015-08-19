package timaxa007.pack.techno.recipe;

import java.util.Iterator;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes_Techno {

	public static void list() {
		/*
		Iterator<IRecipe> iterator=CraftingManager.getInstance().getRecipeList().iterator();

		while(iterator.hasNext() {
			ItemStack r=iterator.next().getRecipeOutput();
			if (r != null && r.getItem()==Blocks.chest) iterator.remove();
			if (r != null && r.getItem()==Blocks.furnaceIdle) iterator.remove();

			if (r != null && r.getItem()==Items.shovelWood.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.shovelStone.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.shovelIron.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.shovelGold.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.shovelDiamond.getItem()) iterator.remove();

			if (r != null && r.getItem()==Items.pickaxeWood.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.pickaxeStone.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.pickaxeIron.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.pickaxeGold.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.pickaxeDiamond.getItem()) iterator.remove();

			if (r != null && r.getItem()==Items.axeWood.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.axeStone.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.axeIron.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.axeGold.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.axeDiamond.getItem()) iterator.remove();

			if (r != null && r.getItem()==Items.swordWood.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.swordStone.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.swordIron.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.swordGold.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.swordDiamond.getItem()) iterator.remove();

			if (r != null && r.getItem()==Items.hoeWood.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.hoeStone.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.hoeIron.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.hoeGold.getItem()) iterator.remove();
			if (r != null && r.getItem()==Items.hoeDiamond.getItem()) iterator.remove();

		}

		GameRegistry.addRecipe(new ItemStack(Blocks.chest), 
				new Object[] {"###", "X X", "###", '#', Blocks.woodSingleSlab, 'X', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(Blocks.furnaceIdle), 
				new Object[] {"###", "X X", "###", '#', Blocks.stoneSingleSlab, 'X', Blocks.cobblestone});

		//shovel
		GameRegistry.addRecipe(new ItemStack(Items.shovelWood), 
				new Object[] {" # ", " S ", " S ", '#', Blocks.woodSingleSlab, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(Items.shovelStone), 
				new Object[] {" # ", " S ", " S ", '#', Blocks.stoneSingleSlab, 'S', Items.stick});
		//pickaxe
		GameRegistry.addRecipe(new ItemStack(Items.pickaxeWood), 
				new Object[] {"#X#", " S ", " S ", '#', Blocks.woodSingleSlab, 'X', Blocks.planks, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(Items.pickaxeStone), 
				new Object[] {"#X#", " S ", " S ", '#', Blocks.stoneSingleSlab, 'X', Blocks.cobblestone, 'S', Items.stick});
		//axe
		GameRegistry.addRecipe(new ItemStack(Items.axeWood), 
				new Object[] {"#X ", "#S ", " S ", '#', Blocks.woodSingleSlab, 'X', Blocks.planks, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(Items.axeStone), 
				new Object[] {"#X ", "#S ", " S ", '#', Blocks.stoneSingleSlab, 'X', Blocks.cobblestone, 'S', Items.stick});
		//sword
		GameRegistry.addRecipe(new ItemStack(Items.swordWood), 
				new Object[] {" # ", " # ", " S ", '#', Blocks.woodSingleSlab, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(Items.swordStone), 
				new Object[] {" # ", " # ", " S ", '#', Blocks.stoneSingleSlab, 'S', Items.stick});
		//hoe
		GameRegistry.addRecipe(new ItemStack(Items.hoeWood), 
				new Object[] {"## ", " S ", " S ", '#', Blocks.woodSingleSlab, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(Items.hoeStone), 
				new Object[] {"## ", " S ", " S ", '#', Blocks.stoneSingleSlab, 'S', Items.stick});


		//for(byte i=1;i<16;++i) {}


		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cloth, 1, GetColors.convertME_MC(i)), 
				new Object[] {new ItemStack(core.itemColored, 1, i), new ItemStack(Blocks.cloth, 1, 0)});
		 */
	}

}
