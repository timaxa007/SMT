package smt.pack.common.api.object;

import net.minecraft.item.ItemStack;
import smt.pack.IngredientRecipe;

public class Recipe implements smt.pack.common.api.IRecipe {

	final IngredientRecipe input;
	final ItemStack[] output;
	int time;

	public Recipe(final IngredientRecipe input, final ItemStack output, final int time) {
		this.input = input;
		this.output = new ItemStack[]{output};
		this.time = time;
	}

	public Recipe(final IngredientRecipe input, final ItemStack[] output, final int time) {
		this.input = input;
		this.output = output;
		this.time = time;
	}

	@Override
	public IngredientRecipe ingredient() {
		return input;
	}

	@Override
	public ItemStack[] result() {
		return output;
	}

	@Override
	public int time() {
		return time;
	}

}
