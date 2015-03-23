package timaxa007.pack.item.recipe;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.item.PackItems;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipeArmorColor implements IRecipe {

	@Override
	public boolean matches(InventoryCrafting ic, World world) {

		ItemStack cmj = ic.getStackInSlot(0);
		ItemStack cmh = ic.getStackInSlot(1);

		if (
				(cmj != null && cmh != null && cmj != cmh) &&
				(cmj != null && cmj.getItem() == new ItemStack(PackItems.proxy.item.armor_wool_colors_helmet).getItem() && cmj.getTagCompound() != null) && 
				(cmh != null && cmh.getItem() == new ItemStack(PackFurniture.proxy.item.colored).getItem() && cmj.getTagCompound().getInteger("ColorHex") == 14)
				) {
			return true;
		}

		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting ic) {

		ItemStack cmj = ic.getStackInSlot(0);
		ItemStack cmh = ic.getStackInSlot(1);

		if (
				(cmj != null && cmh != null && cmj != cmh) &&
				(cmj.getItem() == new ItemStack(PackItems.proxy.item.armor_wool_colors_helmet).getItem() && cmj.getTagCompound() != null && cmj.getTagCompound().getInteger("ColorHex") == 14) && 
				(cmh.getItem() == new ItemStack(PackFurniture.proxy.item.colored).getItem())
				) {
			ItemStack is = new ItemStack(PackItems.proxy.item.armor_wool_colors_helmet);
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("ColorHex", cmh.getItemDamage());
			is.setTagCompound(nbt);
			return is;
		}

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
