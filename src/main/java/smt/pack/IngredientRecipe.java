package smt.pack;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IngredientRecipe {

	final ItemStack ingredient;
	boolean isMatchMetadata, isMatchNBT;

	public IngredientRecipe(final Object ingredient) {
		if (ingredient == null) throw new NullPointerException("Ingredient is null.");
		else if (ingredient instanceof ItemStack) this.ingredient = (ItemStack)ingredient;
		else if (ingredient instanceof Block) this.ingredient = new ItemStack((Block)ingredient);
		else if (ingredient instanceof Item) this.ingredient = new ItemStack((Item)ingredient);
		else if (ingredient instanceof IngredientRecipe) this.ingredient = ((IngredientRecipe)ingredient).getIngredient();
		else throw new RuntimeException("No suitable ingredient.");
		isMatchMetadata = this.ingredient.getHasSubtypes();
		isMatchNBT = this.ingredient.hasTagCompound();
	}

	public IngredientRecipe setMatchMetadata(boolean isMatchMetadata) {
		this.isMatchMetadata = isMatchMetadata;
		return this;
	}

	public IngredientRecipe setMatchNBT(boolean isMatchNBT) {
		this.isMatchNBT = isMatchNBT;
		return this;
	}

	public ItemStack getIngredient() {
		return ingredient;
	}

	public boolean isMatchMetadata() {
		return isMatchMetadata;
	}

	public boolean isMatchNBT() {
		return isMatchNBT;
	}

	public boolean isMatchIngredient(ItemStack itemStack) {
		return (ingredient != null && itemStack != null ? 
					ingredient.getItem() == itemStack.getItem() &&
					(isMatchMetadata() ? ingredient.getItemDamage() == itemStack.getItemDamage() : true) &&
					(isMatchNBT() ? ItemStack.areItemStackTagsEqual(ingredient, itemStack) : true) &&
					0 <= itemStack.stackSize - ingredient.stackSize
					: ingredient == null && itemStack == null ? true : false);
	}

	@Override
	public String toString() {
		if (ingredient != null)
			return getClass().getName() + "(" + ingredient.stackSize + "x" + ingredient.getItem().getUnlocalizedName() + "@" + ingredient.getItemDamage() + ")";
		else return super.toString();
	}

}
