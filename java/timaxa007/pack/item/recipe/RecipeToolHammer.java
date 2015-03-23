package timaxa007.pack.item.recipe;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.item.ItemsFurniture;
import timaxa007.pack.item.item.ToolHammer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipeToolHammer implements IRecipe {

	@Override
	public boolean matches(InventoryCrafting ic, World world) {

		ItemStack ic1 = ic.getStackInSlot(1);
		ItemStack ic4 = ic.getStackInSlot(4);
		ItemStack ic7 = ic.getStackInSlot(7);

		if (ic1 != null && ic1.getItem() instanceof ToolHammer && 
				ic4 != null && ic4.getItem() instanceof ItemsFurniture) {
			return true;
		}
		else if (ic4 != null && ic4.getItem() instanceof ToolHammer && 
				ic7 != null && ic7.getItem() instanceof ItemsFurniture) {
			return true;
		}
		else return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting ic) {

		ItemStack ic1 = ic.getStackInSlot(1);
		ItemStack ic4 = ic.getStackInSlot(4);
		ItemStack ic7 = ic.getStackInSlot(7);

		if (ic1 != null && ic1.getItem() instanceof ToolHammer && 
				ic4 != null && ic4.getItem() instanceof ItemsFurniture) {
			//ic1.setItemDamage(ic4.getItemDamage() + 1);
			//--ic7.stackSize;
			return new ItemStack(PackFurniture.proxy.item.items_for_furniture, 1, 0);
		}
		else if (ic4 != null && ic4.getItem() instanceof ToolHammer && 
				ic7 != null && ic7.getItem() instanceof ItemsFurniture) {
			//ic4.setItemDamage(ic4.getItemDamage() + 1);
			//--ic7.stackSize;
			return new ItemStack(PackFurniture.proxy.item.items_for_furniture, 1, 0);
		}
		else return null;
	}

	@Override
	public int getRecipeSize() {
		return 2;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}

}
