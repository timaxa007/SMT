package smt.pack.common.api.object;

public class Recipes<R extends smt.pack.common.api.IRecipe> {

	final java.util.List<R> list = new java.util.ArrayList<R>();

	public void addRecipe(R recipe) {
		list.add(recipe);
	}

	public java.util.List<R> getRecipes() {
		return list;
	}

	public R findRecipe(net.minecraft.item.ItemStack input) {
		for (R recipe : list)
			if (recipe.ingredient().isMatchIngredient(input))
				return recipe;
		return null;
	}

}
