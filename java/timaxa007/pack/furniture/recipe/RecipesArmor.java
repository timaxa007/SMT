package timaxa007.pack.furniture.recipe;

import timaxa007.pack.furniture.item.ItemsFurniture;
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
			NBTTagCompound is0nbt = is0.getTagCompound();
			NBTTagCompound is1nbt = is1.getTagCompound();
			NBTTagCompound is2nbt = is2.getTagCompound();
			NBTTagCompound is3nbt = is3.getTagCompound();
			NBTTagCompound is5nbt = is5.getTagCompound();
			if (is0.getItem() instanceof ItemsFurniture && is0nbt != null && 
					is1.getItem() instanceof ItemsFurniture && is1nbt != null && 
					is2.getItem() instanceof ItemsFurniture && is2nbt != null && 
					is3.getItem() instanceof ItemsFurniture && is3nbt != null && 
					is5.getItem() instanceof ItemsFurniture && is5nbt != null) {
				if (is0nbt.getString("NameID") == is1nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is2nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is3nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is5nbt.getString("NameID")) {

					return true;
				}
			}
		}

		if (is0 != null  && is1 == null  && is2 != null 
				&& is3 != null && is4 != null && is5 != null 
				&& is6 != null  && is7 != null  && is8 != null) {
			NBTTagCompound is0nbt = is0.getTagCompound();
			NBTTagCompound is2nbt = is2.getTagCompound();
			NBTTagCompound is3nbt = is3.getTagCompound();
			NBTTagCompound is4nbt = is4.getTagCompound();
			NBTTagCompound is5nbt = is5.getTagCompound();
			NBTTagCompound is6nbt = is6.getTagCompound();
			NBTTagCompound is7nbt = is7.getTagCompound();
			NBTTagCompound is8nbt = is8.getTagCompound();
			if (is0.getItem() instanceof ItemsFurniture && is0nbt != null && 
					is2.getItem() instanceof ItemsFurniture && is2nbt != null && 
					is3.getItem() instanceof ItemsFurniture && is3nbt != null && 
					is4.getItem() instanceof ItemsFurniture && is4nbt != null && 
					is5.getItem() instanceof ItemsFurniture && is5nbt != null && 
					is6.getItem() instanceof ItemsFurniture && is6nbt != null && 
					is7.getItem() instanceof ItemsFurniture && is7nbt != null && 
					is8.getItem() instanceof ItemsFurniture && is8nbt != null) {
				if (is0nbt.getString("NameID") == is2nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is3nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is4nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is5nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is6nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is7nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is8nbt.getString("NameID")) {

					return true;
				}
			}
		}

		if (is0 != null  && is1 != null  && is2 != null 
				&& is3 != null  && is4 == null && is5 != null 
				&& is6 != null  && is7 == null  && is8 != null ) {
			NBTTagCompound is0nbt = is0.getTagCompound();
			NBTTagCompound is1nbt = is1.getTagCompound();
			NBTTagCompound is2nbt = is2.getTagCompound();
			NBTTagCompound is3nbt = is3.getTagCompound();
			NBTTagCompound is5nbt = is5.getTagCompound();
			NBTTagCompound is6nbt = is6.getTagCompound();
			NBTTagCompound is8nbt = is8.getTagCompound();
			if (is0.getItem() instanceof ItemsFurniture && is0nbt != null && 
					is1.getItem() instanceof ItemsFurniture && is1nbt != null && 
					is2.getItem() instanceof ItemsFurniture && is2nbt != null && 
					is3.getItem() instanceof ItemsFurniture && is3nbt != null && 
					is5.getItem() instanceof ItemsFurniture && is5nbt != null && 
					is6.getItem() instanceof ItemsFurniture && is6nbt != null && 
					is8.getItem() instanceof ItemsFurniture && is8nbt != null) {
				if (is0nbt.getString("NameID") == is1nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is2nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is3nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is5nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is6nbt.getString("NameID") && 
						is0nbt.getString("NameID") == is8nbt.getString("NameID")) {

					return true;
				}
			}
		}

		if (is0 == null  && is1 == null  && is2 == null 
				&& is3 != null && is4 == null  && is5 != null 
				&& is6 != null  && is7 == null  && is8 != null) {
			NBTTagCompound is3nbt = is3.getTagCompound();
			NBTTagCompound is5nbt = is5.getTagCompound();
			NBTTagCompound is6nbt = is6.getTagCompound();
			NBTTagCompound is8nbt = is8.getTagCompound();
			if (is3.getItem() instanceof ItemsFurniture && is3nbt != null && 
					is5.getItem() instanceof ItemsFurniture && is5nbt != null && 
					is6.getItem() instanceof ItemsFurniture && is6nbt != null && 
					is8.getItem() instanceof ItemsFurniture && is8nbt != null) {
				if (is3nbt.getString("NameID") == is5nbt.getString("NameID") && 
						is3nbt.getString("NameID") == is6nbt.getString("NameID") && 
						is3nbt.getString("NameID") == is8nbt.getString("NameID")) {

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
