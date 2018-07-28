package smt.pack.cookery.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import smt.pack.IngredientRecipe;

public class RecipesGrill {

	public static final RecipesGrill instance = new RecipesGrill();
	List<Recipe> list = new ArrayList<Recipe>();

	public RecipesGrill() {
		this.addRecipe(new IngredientRecipe(Items.porkchop), new ItemStack(Items.cooked_porkchop), 15);
		this.addRecipe(new IngredientRecipe(Items.beef), new ItemStack(Items.cooked_beef), 17);
		this.addRecipe(new IngredientRecipe(Items.potato), new ItemStack(Items.baked_potato), 8);
	}

	public boolean addRecipe(IngredientRecipe input, ItemStack output) {
		return addRecipe(input, output, 20);
	}

	public boolean addRecipe(IngredientRecipe input, ItemStack output, int time) {
		if (input == null) return false;
		try {
			list.add(new Recipe(input, output, time));
			return true;
		} catch (Exception e) {}
		return false;
	}

	public Recipe findRecipe(ItemStack itemStack) {
		if (list.size() > 0)
			for (Recipe recipe : list)
				if (recipe.input.isMatchIngredient(itemStack))
					return recipe;
		return null;
	}

	public class Recipe {

		public final IngredientRecipe input;
		public final ItemStack output;
		public final int time;

		public Recipe(IngredientRecipe input, ItemStack output, int time) {
			this.input = input;
			this.output = output;
			this.time = time;
		}

	}

}
