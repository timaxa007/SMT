package smt.pack.technology.recipes;

import java.util.Map;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import smt.pack.IngredientRecipe;
import smt.pack.common.api.object.Recipe;
import smt.pack.common.api.object.RecipeXP;
import smt.pack.technology.api.RecipesTechnology;


public class ListRecipes {

	public static final void init() {

		//Map map = (Map)ReflectionHelper.getPrivateValue(FurnaceRecipes.class, FurnaceRecipes.smelting(), "smeltingList");

		for (Map.Entry<ItemStack, ItemStack> recipe : ((Map<ItemStack, ItemStack>)FurnaceRecipes.smelting().getSmeltingList()).entrySet()) {
			if (recipe.getKey() != null && (
					recipe.getKey().getItem() == Item.getItemFromBlock(Blocks.iron_ore) ||
					recipe.getKey().getItem() == Item.getItemFromBlock(Blocks.gold_ore) ||
					recipe.getKey().getItem() == Item.getItemFromBlock(Blocks.diamond_ore) ||
					recipe.getKey().getItem() == Item.getItemFromBlock(Blocks.emerald_ore)
					)) {
				FurnaceRecipes.smelting().getSmeltingList().remove(recipe.getKey());
				break;
			}
		}

		GameRegistry.addRecipe(new RecipeTest());
		GameRegistry.addRecipe(new MyRecipe());

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.clay), new Object[]{
				new ItemStack(Blocks.dirt),
				new ItemStack(Blocks.sand),
				new ItemStack(Items.water_bucket),
		});

		RecipesTechnology.elecricCrusher.addRecipe(new RecipeXP(new IngredientRecipe(Blocks.stone), new ItemStack(Blocks.cobblestone), 20, 0));
		RecipesTechnology.elecricCrusher.addRecipe(new RecipeXP(new IngredientRecipe(Blocks.cobblestone), new ItemStack(Blocks.gravel), 30, 0));
		RecipesTechnology.elecricCrusher.addRecipe(new RecipeXP(new IngredientRecipe(Blocks.sandstone), new ItemStack(Blocks.sand, 3), 10, 0));

		RecipesTechnology.elecricMacerator.addRecipe(new RecipeXP(new IngredientRecipe(Items.blaze_rod), new ItemStack(Items.blaze_powder, 3), 20, 0));
		RecipesTechnology.elecricMacerator.addRecipe(new RecipeXP(new IngredientRecipe(Items.bone), new ItemStack(Items.dye, 5, 15), 20, 0));
		RecipesTechnology.elecricMacerator.addRecipe(new RecipeXP(new IngredientRecipe(Blocks.redstone_block), new ItemStack(Items.redstone, 9), 20, 0));
		RecipesTechnology.elecricMacerator.addRecipe(new RecipeXP(new IngredientRecipe(Blocks.redstone_ore), new ItemStack(Items.redstone, 3), 20, 0));

		IngredientRecipe ingredient;

		ingredient = new IngredientRecipe(new ItemStack(Items.stick, 5));
		RecipesTechnology.elecricFurnace.addRecipe(new Recipe(ingredient, new ItemStack(Items.coal, 1, 1), 120));

		ingredient = new IngredientRecipe(new ItemStack(Items.coal, 2, 1));
		RecipesTechnology.elecricFurnace.addRecipe(new Recipe(ingredient, new ItemStack(Items.coal, 1, 0), 75));

	}

}
