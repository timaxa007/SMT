package smt.pack.common.api;

public interface IRecipes {

	void addRecipe(IRecipe recipe);
	java.util.List<IRecipe> getRecipes();
	IRecipe findRecipe(net.minecraft.item.ItemStack input);

}
