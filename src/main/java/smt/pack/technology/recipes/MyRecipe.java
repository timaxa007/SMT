package smt.pack.technology.recipes;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class MyRecipe implements IRecipe {

	ItemStack output;
	final ArrayList<ItemStack> list_dust = new ArrayList<ItemStack>();
	int[] array_dust_count;

	public MyRecipe() {
		output = new ItemStack(Blocks.diamond_block);

		list_dust.add(new ItemStack(Items.glowstone_dust));
		list_dust.add(new ItemStack(Items.redstone));
		list_dust.add(new ItemStack(Items.coal, 1, 0));
		list_dust.add(new ItemStack(Items.coal, 1, 1));
		list_dust.add(new ItemStack(Items.stick));
		list_dust.add(new ItemStack(Items.string));
		list_dust.add(new ItemStack(Items.arrow));
		list_dust.add(new ItemStack(Items.gunpowder));
		list_dust.add(new ItemStack(Items.blaze_powder));
	}


	@Override
	public boolean matches(InventoryCrafting ic, World world) {
		array_dust_count = new int[list_dust.size()];

		int i = 0;
		for (int j = 0; j < ic.getSizeInventory(); ++j) {
			ItemStack itemStack = ic.getStackInSlot(j);
			if (itemStack != null && contains(itemStack)) {
				++i;
			}
		}
		if (i < 9) return false;

		for (int i2 = 0; i2 < array_dust_count.length; ++i2) {
			if (array_dust_count[i2] > 1) {
				return false;
			}
		}

		return true;
	}

	public boolean contains(ItemStack itemStack) {
		for (int i = 0; i < list_dust.size(); ++i) {
			ItemStack dust = list_dust.get(i);
			if (dust != null && dust.getItem() == itemStack.getItem() && dust.getItemDamage() == itemStack.getItemDamage()) {
				array_dust_count[i] += 1;
				return true;
			}
		}
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting ic) {
		array_dust_count = new int[list_dust.size()];

		int i = 0;
		for (int j = 0; j < ic.getSizeInventory(); ++j) {
			ItemStack itemStack = ic.getStackInSlot(j);
			if (itemStack != null && contains(itemStack)) {
				++i;
			}
		}
		if (i < 9) return null;

		for (int i2 = 0; i2 < array_dust_count.length; ++i2) {
			if (array_dust_count[i2] > 1) {
				return null;
			}
		}

		return output.copy();
	}

	@Override
	public int getRecipeSize() {
		return 9;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return output.copy();
	}

}
