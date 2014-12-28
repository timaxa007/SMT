package mods.timaxa007.pack.furniture.recipe;

import mods.timaxa007.pack.furniture.item.ItemsFurniture;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
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
			NBTTagCompound is0tag = is0.getTagCompound();
			NBTTagCompound is1tag = is1.getTagCompound();
			NBTTagCompound is2tag = is2.getTagCompound();
			NBTTagCompound is3tag = is3.getTagCompound();
			NBTTagCompound is5tag = is5.getTagCompound();
			if (is0.getItem() instanceof ItemsFurniture && is0tag != null && 
					is1.getItem() instanceof ItemsFurniture && is1tag != null && 
					is2.getItem() instanceof ItemsFurniture && is2tag != null && 
					is3.getItem() instanceof ItemsFurniture && is3tag != null && 
					is5.getItem() instanceof ItemsFurniture && is5tag != null) {
				if (is0tag.getString("NameID") == is1tag.getString("NameID") && 
						is0tag.getString("NameID") == is2tag.getString("NameID") && 
						is0tag.getString("NameID") == is3tag.getString("NameID") && 
						is0tag.getString("NameID") == is5tag.getString("NameID")) {

					return true;
				}
			}
		}

		if (is0 != null  && is1 == null  && is2 != null 
				&& is3 != null && is4 != null && is5 != null 
				&& is6 != null  && is7 != null  && is8 != null) {
			NBTTagCompound is0tag = is0.getTagCompound();
			NBTTagCompound is2tag = is2.getTagCompound();
			NBTTagCompound is3tag = is3.getTagCompound();
			NBTTagCompound is4tag = is4.getTagCompound();
			NBTTagCompound is5tag = is5.getTagCompound();
			NBTTagCompound is6tag = is6.getTagCompound();
			NBTTagCompound is7tag = is7.getTagCompound();
			NBTTagCompound is8tag = is8.getTagCompound();
			if (is0.getItem() instanceof ItemsFurniture && is0tag != null && 
					is2.getItem() instanceof ItemsFurniture && is2tag != null && 
					is3.getItem() instanceof ItemsFurniture && is3tag != null && 
					is4.getItem() instanceof ItemsFurniture && is4tag != null && 
					is5.getItem() instanceof ItemsFurniture && is5tag != null && 
					is6.getItem() instanceof ItemsFurniture && is6tag != null && 
					is7.getItem() instanceof ItemsFurniture && is7tag != null && 
					is8.getItem() instanceof ItemsFurniture && is8tag != null) {
				if (is0tag.getString("NameID") == is2tag.getString("NameID") && 
						is0tag.getString("NameID") == is3tag.getString("NameID") && 
						is0tag.getString("NameID") == is4tag.getString("NameID") && 
						is0tag.getString("NameID") == is5tag.getString("NameID") && 
						is0tag.getString("NameID") == is6tag.getString("NameID") && 
						is0tag.getString("NameID") == is7tag.getString("NameID") && 
						is0tag.getString("NameID") == is8tag.getString("NameID")) {

					return true;
				}
			}
		}

		if (is0 != null  && is1 != null  && is2 != null 
				&& is3 != null  && is4 == null && is5 != null 
				&& is6 != null  && is7 == null  && is8 != null ) {
			NBTTagCompound is0tag = is0.getTagCompound();
			NBTTagCompound is1tag = is1.getTagCompound();
			NBTTagCompound is2tag = is2.getTagCompound();
			NBTTagCompound is3tag = is3.getTagCompound();
			NBTTagCompound is5tag = is5.getTagCompound();
			NBTTagCompound is6tag = is6.getTagCompound();
			NBTTagCompound is8tag = is8.getTagCompound();
			if (is0.getItem() instanceof ItemsFurniture && is0tag != null && 
					is1.getItem() instanceof ItemsFurniture && is1tag != null && 
					is2.getItem() instanceof ItemsFurniture && is2tag != null && 
					is3.getItem() instanceof ItemsFurniture && is3tag != null && 
					is5.getItem() instanceof ItemsFurniture && is5tag != null && 
					is6.getItem() instanceof ItemsFurniture && is6tag != null && 
					is8.getItem() instanceof ItemsFurniture && is8tag != null) {
				if (is0tag.getString("NameID") == is1tag.getString("NameID") && 
						is0tag.getString("NameID") == is2tag.getString("NameID") && 
						is0tag.getString("NameID") == is3tag.getString("NameID") && 
						is0tag.getString("NameID") == is5tag.getString("NameID") && 
						is0tag.getString("NameID") == is6tag.getString("NameID") && 
						is0tag.getString("NameID") == is8tag.getString("NameID")) {

					return true;
				}
			}
		}

		if (is0 == null  && is1 == null  && is2 == null 
				&& is3 != null && is4 == null  && is5 != null 
				&& is6 != null  && is7 == null  && is8 != null) {
			NBTTagCompound is3tag = is3.getTagCompound();
			NBTTagCompound is5tag = is5.getTagCompound();
			NBTTagCompound is6tag = is6.getTagCompound();
			NBTTagCompound is8tag = is8.getTagCompound();
			if (is3.getItem() instanceof ItemsFurniture && is3tag != null && 
					is5.getItem() instanceof ItemsFurniture && is5tag != null && 
					is6.getItem() instanceof ItemsFurniture && is6tag != null && 
					is8.getItem() instanceof ItemsFurniture && is8tag != null) {
				if (is3tag.getString("NameID") == is5tag.getString("NameID") && 
						is3tag.getString("NameID") == is6tag.getString("NameID") && 
						is3tag.getString("NameID") == is8tag.getString("NameID")) {

					return true;
				}
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
