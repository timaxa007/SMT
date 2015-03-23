package mods.timaxa007.tms.lib;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RemoveRecipe {

	public static final void removeItem(Item item) {
		removeItem(new Item[] {item});
	}

	public static void removeItem(Item[] item) {
		List<IRecipe> list_recipe = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> iterator = list_recipe.iterator();
		while (iterator.hasNext()) {
			ItemStack is = iterator.next().getRecipeOutput();
			for (int i = 0; i < item.length; i++)
				if (item[i] != null && is != null && is.getItem() == item[i]) iterator.remove();
		}
	}

	public static final void removeBlock(Block block) {
		removeBlock(new Block[] {block});
	}

	public static void removeBlock(Block[] block) {
		List<IRecipe> list_recipe = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> iterator = list_recipe.iterator();
		while (iterator.hasNext()) {
			ItemStack is = iterator.next().getRecipeOutput();
			for (int i = 0; i < block.length; i++)
				if (block[i] != null && is != null && is.getItem() == Item.getItemFromBlock(block[i])) iterator.remove();
		}
	}

	public static final void removeItemStack(ItemStack item_stack) {
		removeItemStack(new ItemStack[] {item_stack});
	}

	public static void removeItemStack(ItemStack[] item_stack) {
		List<IRecipe> list_recipe = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> iterator = list_recipe.iterator();
		while (iterator.hasNext()) {
			ItemStack is = iterator.next().getRecipeOutput();
			for (int i = 0; i < item_stack.length; i++)
				if (item_stack[i] != null && is != null && is == item_stack[i]) iterator.remove();
		}
	}

	public static final void removeItemOnItemStack(ItemStack item_stack) {
		removeItemOnItemStack(new ItemStack[] {item_stack});
	}

	public static void removeItemOnItemStack(ItemStack[] item_stack) {
		List<IRecipe> list_recipe = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> iterator = list_recipe.iterator();
		while (iterator.hasNext()) {
			ItemStack is = iterator.next().getRecipeOutput();
			for (int i = 0; i < item_stack.length; i++)
				if (item_stack[i] != null && is != null && is.getItem() == item_stack[i].getItem()) iterator.remove();
		}
	}

}
