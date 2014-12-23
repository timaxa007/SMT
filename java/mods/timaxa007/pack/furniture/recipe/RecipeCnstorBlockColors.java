package mods.timaxa007.pack.furniture.recipe;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipeCnstorBlockColors implements IRecipe {

	@Override
	public boolean matches(InventoryCrafting ic, World world) {

		for (int j = 0; j < ic.getSizeInventory(); ++j) {

			ItemStack icj = ic.getStackInSlot(j);

		}

		ItemStack cmj = ic.getStackInSlot(0);
		ItemStack cmh = ic.getStackInSlot(1);
		if (
				(cmj != null && cmj.getItem() == new ItemStack(PackFurniture.proxy.block.cnstor_block).getItem() && cmj.getTagCompound() != null) && 
				(cmh != null && cmh.getItem() == new ItemStack(PackFurniture.proxy.item.colored).getItem()) &&
				(cmj != cmh) && (cmh.getItemDamage() >= 0 && cmh.getItemDamage() < 16)
				) {
			return true;
		}

		if (
				(cmj != null && cmj.getItem() == new ItemStack(PackFurniture.proxy.block.cnstor_block).getItem() && cmj.getTagCompound() != null) && 
				(cmh != null && cmh.getItem() == new ItemStack(Items.dye).getItem()) &&
				(cmj != cmh) && (cmh.getItemDamage() >= 0 && cmh.getItemDamage() < 16)
				) {
			return true;
		}

		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting ic) {

		for (int j = 0; j < ic.getSizeInventory(); ++j) {

			ItemStack icj = ic.getStackInSlot(j);

		}

		ItemStack cmj = ic.getStackInSlot(0);
		ItemStack cmh = ic.getStackInSlot(1);
		if (
				(cmj != null && cmh != null && cmj != cmh) &&
				(cmj.getItem() == new ItemStack(PackFurniture.proxy.block.cnstor_block).getItem() && cmj.getTagCompound() != null) && 
				(cmh.getItem() == new ItemStack(PackFurniture.proxy.item.colored).getItem())
				) {
			ItemStack is = new ItemStack(PackFurniture.proxy.block.cnstor_block);
			NBTTagCompound tag = new NBTTagCompound();

			int clr1 = GetColors.getHexColors[cmh.getItemDamage()];
			float r1 = (float)(clr1 >> 16 & 255) / 255.0F;
			float g1 = (float)(clr1 >> 8 & 255) / 255.0F;
			float b1 = (float)(clr1 >> 0 & 255) / 255.0F;

			int clr2 = cmj.getTagCompound().getInteger("Color");
			float r2 = (float)(clr2 >> 16 & 255) / 255.0F;
			float g2 = (float)(clr2 >> 8 & 255) / 255.0F;
			float b2 = (float)(clr2 >> 0 & 255) / 255.0F;

			float r3 = (((r1 * 3.0F) + (r2 * 1.0F)) / 4) * 255.0F;
			float g3 = (((g1 * 3.0F) + (g2 * 1.0F)) / 4) * 255.0F;
			float b3 = (((b1 * 3.0F) + (b2 * 1.0F)) / 4) * 255.0F;

			tag.setInteger("Type", cmj.getTagCompound().getInteger("Type"));
			tag.setInteger("Color", (int)r3 << 16 | (int)g3 << 8 | (int)b3);
			;
			is.setTagCompound(tag);
			return is;
		}

		if (
				(cmj != null && cmh != null && cmj != cmh) &&
				(cmj.getItem() == new ItemStack(PackFurniture.proxy.block.cnstor_block).getItem() && cmj.getTagCompound() != null) && 
				(cmh.getItem() == new ItemStack(Items.dye).getItem())
				) {
			ItemStack is = new ItemStack(PackFurniture.proxy.block.cnstor_block);
			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger("Type", cmj.getTagCompound().getInteger("Type"));
			tag.setInteger("Color", ItemDye.field_150922_c[cmh.getItemDamage()]);
			;
			is.setTagCompound(tag);
			return is;
		}

		return null;
	}

	@Override
	public int getRecipeSize() {
		return 1;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}

}
