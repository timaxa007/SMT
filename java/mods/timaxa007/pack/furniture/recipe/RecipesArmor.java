package mods.timaxa007.pack.furniture.recipe;

import mods.timaxa007.pack.furniture.item.ItemsFurniture;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipesArmor implements IRecipe {

	@Override
	public boolean matches(InventoryCrafting ic, World world) {
		ItemStack is0 = ic.getStackInSlot(0);
		ItemStack is1 = ic.getStackInSlot(1);
		ItemStack is2 = ic.getStackInSlot(2);
		ItemStack is3 = ic.getStackInSlot(3);
		ItemStack is4 = ic.getStackInSlot(4);
		ItemStack is5 = ic.getStackInSlot(5);
		ItemStack is6 = ic.getStackInSlot(6);
		ItemStack is7 = ic.getStackInSlot(7);
		ItemStack is8 = ic.getStackInSlot(8);

		if (is0 != null  && is1 != null  && is2 != null 
				&& is3 != null  && is4 == null  && is5 != null 
				&& is6 == null  && is7 == null  && is8 == null) {
			if (is0.getItem() instanceof ItemsFurniture && 
					is1.getItem() instanceof ItemsFurniture && 
					is2.getItem() instanceof ItemsFurniture && 
					is3.getItem() instanceof ItemsFurniture && 
					is5.getItem() instanceof ItemsFurniture ) {

				return true;
			}
		}

		if (is0 != null  && is1 == null  && is2 != null 
				&& is3 != null && is4 != null && is5 != null 
				&& is6 != null  && is7 != null  && is8 != null) {
			if (is0.getItem() instanceof ItemsFurniture && 
					is2.getItem() instanceof ItemsFurniture && 
					is3.getItem() instanceof ItemsFurniture && 
					is4.getItem() instanceof ItemsFurniture && 
					is5.getItem() instanceof ItemsFurniture && 
					is6.getItem() instanceof ItemsFurniture && 
					is7.getItem() instanceof ItemsFurniture && 
					is8.getItem() instanceof ItemsFurniture) {

				return true;
			}
		}

		if (is0 != null  && is1 != null  && is2 != null 
				&& is3 != null  && is4 == null && is5 != null 
				&& is6 != null  && is7 == null  && is8 != null ) {
			if (is0.getItem() instanceof ItemsFurniture && 
					is1.getItem() instanceof ItemsFurniture && 
					is2.getItem() instanceof ItemsFurniture && 
					is3.getItem() instanceof ItemsFurniture && 
					is5.getItem() instanceof ItemsFurniture && 
					is6.getItem() instanceof ItemsFurniture && 
					is8.getItem() instanceof ItemsFurniture) {

				return true;
			}
		}

		if (is0 == null  && is1 == null  && is2 == null 
				&& is3 != null && is4 == null  && is5 != null 
				&& is6 != null  && is7 == null  && is8 != null) {
			if (is3.getItem() instanceof ItemsFurniture && 
					is5.getItem() instanceof ItemsFurniture && 
					is6.getItem() instanceof ItemsFurniture && 
					is8.getItem() instanceof ItemsFurniture) {

				return true;
			}
		}

		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting ic) {
		return null;
	}

	@Override
	public int getRecipeSize() {
		return 9;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}

}
