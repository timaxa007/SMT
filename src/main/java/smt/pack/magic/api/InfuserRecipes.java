package smt.pack.magic.api;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import smt.pack.IngredientRecipe;

public class InfuserRecipes {

	ArrayList<Recipe> recipes = new ArrayList<Recipe>();

	public InfuserRecipes() {

		recipes.add(new Recipe(new ItemStack(Blocks.gold_ore), 180,
				new IngredientRecipe(Blocks.stone),
				new IngredientRecipe(Items.gold_ingot),
				new IngredientRecipe(Items.gold_ingot),
				new IngredientRecipe(Items.gold_ingot),
				new IngredientRecipe(Items.gold_ingot)
				));

		recipes.add(new Recipe(new ItemStack(Items.blaze_rod), 320,
				new IngredientRecipe(Items.stick),
				new IngredientRecipe(Items.blaze_powder),
				new IngredientRecipe(Items.blaze_powder),
				new IngredientRecipe(Items.blaze_powder),
				new IngredientRecipe(Items.gunpowder)
				));

	}

	public Recipe findRecipe(final ItemStack... itemStack) {
		if (recipes.isEmpty()) return null;
		for (Recipe recipe : recipes) {
			/*
			int l = 0;
			int[] m = new int[recipe.input.length];
			for (int i = 0; i < m.length; ++i) m[i] = -1;

			for (int j = 0; j < recipe.input.length; ++j) {
				for (int k = 0; k < itemStack.length; ++k) {
					if (m[j] != -1 && m[j] == k) continue;

					if ((recipe.input[j] == null && itemStack[k] == null) ||
							(recipe.input[j] != null && itemStack[k] != null && recipe.input[j].isMatchIngredient(itemStack[k]))) {
						m[j] = k;
						++l;
						break;
					}
				}
			}
			if (l == 8) return recipe;
			 */
		}
		return null;
	}

	public static class Recipe {

		public final ItemStack output;
		public final int time;
		public final IngredientRecipe input_primary;
		public final IngredientRecipe[] input_secondary = new IngredientRecipe[8];

		public Recipe(ItemStack output, int time, IngredientRecipe... input) {
			this.output = output;
			this.time = time;
			this.input_primary = input_secondary[0];
			for (int i = 1; i < input.length; ++i) {
				//if (i < this.input.length) break;
				this.input_secondary[i] = input[i];
			}
		}

	}

}
