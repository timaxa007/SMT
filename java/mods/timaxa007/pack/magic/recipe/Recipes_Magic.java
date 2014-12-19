package mods.timaxa007.pack.magic.recipe;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes_Magic {

	public static void list() {
		//Testing - is DELETileEntity
		GameRegistry.addShapelessRecipe(testTagAdd(0, "Red"), new Object[] {Items.redstone, Items.cookie});
		GameRegistry.addShapelessRecipe(testTagAdd(0, "Ded"), new Object[] {Items.redstone, Items.carrot});
		GameRegistry.addShapelessRecipe(testTagAdd(1, "Did"), new Object[] {Items.gunpowder, Items.cookie});
		GameRegistry.addShapelessRecipe(testTagAdd(1, "Ded"), new Object[] {Items.gunpowder, Items.carrot});

	}

	public static ItemStack testTagAdd(int par1, String par2) {
		ItemStack is = new ItemStack(PackMagic.proxy.blockSlims, 1, par1);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("Color", par2);
		is.setTagCompound(tag);
		return is;
	}

}
