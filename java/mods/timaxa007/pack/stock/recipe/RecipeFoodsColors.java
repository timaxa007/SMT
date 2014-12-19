package mods.timaxa007.pack.stock.recipe;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.stock.PackStock;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipeFoodsColors implements IRecipe {

	@Override
	public boolean matches(InventoryCrafting ic, World world) {

		//int i = 0;
		//ItemStack is = null;

		for (int j = 0; j < ic.getSizeInventory(); ++j) {
			ItemStack icj = ic.getStackInSlot(j);
		}

		ItemStack cmj = ic.getStackInSlot(0);
		ItemStack cmh = ic.getStackInSlot(1);
		if (
				(cmj != null && cmj.getItem() == new ItemStack(PackStock.proxy.item_foods).getItem() && cmj.getTagCompound() != null) && 
				(cmh != null && cmh.getItem() == new ItemStack(PackFurniture.proxy.item_colored).getItem()) &&
				(cmj != cmh) && (cmh.getItemDamage() >= 16 && cmh.getItemDamage() < 32)
				) {
			return true;
		}

		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting ic) {

		//int i = 0;
		//ItemStack is = null;

		for (int j = 0; j < ic.getSizeInventory(); ++j) {
			ItemStack icj = ic.getStackInSlot(j);
		}

		ItemStack cmj = ic.getStackInSlot(0);
		ItemStack cmh = ic.getStackInSlot(1);
		if (
				(cmj != null && cmh != null && cmj != cmh) &&
				(cmj.getItem() == new ItemStack(PackStock.proxy.item_foods).getItem() && cmj.getTagCompound() != null) && 
				(cmh.getItem() == new ItemStack(PackFurniture.proxy.item_colored).getItem())
				) {
			ItemStack is = new ItemStack(PackStock.proxy.item_foods);
			NBTTagCompound tag = new NBTTagCompound();
			tag.setString("NameID", cmj.getTagCompound().getString("NameID"));
			if (!cmj.getTagCompound().hasKey("ColorHex")) {
				tag.setInteger("ColorHex", GetColors.getHexColors[cmh.getItemDamage()-16]);
			} else {

				int clr1 = GetColors.getHexColors[cmh.getItemDamage()-16];
				int r1 = (int)(clr1 >> 16 & 255);
				int g1 = (int)(clr1 >> 8 & 255);
				int b1 = (int)(clr1 >> 0 & 255);

				int clr2 = cmj.getTagCompound().getInteger("ColorHex");
				int r2 = (int)(clr2 >> 16 & 255);
				int g2 = (int)(clr2 >> 8 & 255);
				int b2 = (int)(clr2 >> 0 & 255);

				int r3 = (((r1 * 7) + (r2 * 1)) / 8);
				int g3 = (((g1 * 7) + (g2 * 1)) / 8);
				int b3 = (((b1 * 7) + (b2 * 1)) / 8);

				tag.setInteger("ColorHex", (int)r3 << 16 | (int)g3 << 8 | (int)b3);
			}
			is.setTagCompound(tag);
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
