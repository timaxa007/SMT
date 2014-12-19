package mods.timaxa007.pack.furniture.recipe;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes_Armor {

	public static void list() {
		for (int i = 0; i < 16; ++i) {
			GameRegistry.addRecipe(addTagArmor(PackFurniture.proxy.armor_wool_colors_helmet, i), new Object[]{"MMM", "M M", 'M', new ItemStack(Blocks.wool, 1, GetColors.convertME_MC(i))});
			GameRegistry.addRecipe(addTagArmor(PackFurniture.proxy.armor_wool_colors_chest, i), new Object[]{"M M", "MMM", "MMM", 'M', new ItemStack(Blocks.wool, 1, GetColors.convertME_MC(i))});
			GameRegistry.addRecipe(addTagArmor(PackFurniture.proxy.armor_wool_colors_leggin, i), new Object[]{"MMM", "M M", "M M", 'M', new ItemStack(Blocks.wool, 1, GetColors.convertME_MC(i))});
			GameRegistry.addRecipe(addTagArmor(PackFurniture.proxy.armor_wool_colors_boot, i), new Object[]{"M M", "M M", 'M', new ItemStack(Blocks.wool, 1, GetColors.convertME_MC(i))});
		}

	}

	private static ItemStack addTagArmor(ItemArmor par1, int par2) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Color", par2);
		//tag.setInteger("HexColor", GetColors.getHexColors[par2]);
		is.setTagCompound(tag);
		return is;
	}

}
