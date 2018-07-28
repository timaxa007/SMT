package smt.pack.common.api;

public interface IRecipe {

	smt.pack.IngredientRecipe ingredient();
	net.minecraft.item.ItemStack[] result();
	int time();

}
