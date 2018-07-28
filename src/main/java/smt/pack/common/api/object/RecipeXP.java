package smt.pack.common.api.object;

import net.minecraft.item.ItemStack;
import smt.pack.IngredientRecipe;

public class RecipeXP extends Recipe {

	final int xp;

	public RecipeXP(final IngredientRecipe input, final ItemStack output, final int time, final int xp) {
		super(input, output, time);
		this.xp = xp;
	}

	public RecipeXP(final IngredientRecipe input, final ItemStack[] output, final int time, final int xp) {
		super(input, output, time);
		this.xp = xp;
	}

	public int getXP() {
		return xp;
	}

}
