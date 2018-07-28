package smt.pack.technology.recipes;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import com.google.common.collect.Lists;

public class RecipeTest implements IRecipe {

	private final ItemStack recipeOutput = new ItemStack(Blocks.obsidian);

	public RecipeTest() {}

	@Override
	public boolean matches(InventoryCrafting ic, World world) {
		/*Items.water_bucket.setContainerItem(Items.bucket);
		Items.lava_bucket.setContainerItem(Items.bucket);
		Items.water_bucket.setContainerItem(null);
		Items.lava_bucket.setContainerItem(null);*/
		ArrayList arraylist = Lists.newArrayList(new Object[] {
				new ItemStack(Items.water_bucket),
				new ItemStack(Items.lava_bucket)
		});

		for (int i = 0; i < ic.getSizeInventory(); ++i) {
			ItemStack itemstack = ic.getStackInSlot(i);

			if (itemstack != null) {
				boolean flag = false;
				Iterator iterator = arraylist.iterator();

				while (iterator.hasNext()) {
					ItemStack itemstack1 = (ItemStack)iterator.next();

					if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage())) {
						flag = true;
						arraylist.remove(itemstack1);
						break;
					}
				}

				if (!flag) {
					return false;
				}
			}
		}

		return arraylist.isEmpty();
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting ic) {
		return recipeOutput.copy();
	}

	@Override
	public int getRecipeSize() {
		return 2;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return recipeOutput;
	}

}
