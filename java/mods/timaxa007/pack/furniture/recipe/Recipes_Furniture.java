package mods.timaxa007.pack.furniture.recipe;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes_Furniture {

	public static void list() {
		//white+colored=colored|not/black;
		for (int i = 1; i < 16; ++i) {
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, GetColors.convertME_MC(i)), new Object[] {
				new ItemStack(PackFurniture.proxy.item.colored, 1, i), new ItemStack(Blocks.wool, 1, 0)});
		}
		//white+black=gray;
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, 7), new Object[] {
			new ItemStack(PackFurniture.proxy.item.colored, 1, 0), new ItemStack(Blocks.wool, 1, 0)});
		//gray+black=black;
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, 15), new Object[] {
			new ItemStack(PackFurniture.proxy.item.colored, 1, 0), new ItemStack(Blocks.wool, 1, 7)});
		//black+white=LightGray;
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, 8), new Object[] {
			new ItemStack(PackFurniture.proxy.item.colored, 1, 14), new ItemStack(Blocks.wool, 1, 15)});
		//LightGray+white=white;
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, 0), new Object[] {
			new ItemStack(PackFurniture.proxy.item.colored, 1, 14), new ItemStack(Blocks.wool, 1, 8)});
		//black+LightGray=gray;
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, 7), new Object[] {
			new ItemStack(PackFurniture.proxy.item.colored, 1, 13), new ItemStack(Blocks.wool, 1, 15)});
		//gray+white=LightGray;
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, 8), new Object[] {
			new ItemStack(PackFurniture.proxy.item.colored, 1, 14), new ItemStack(Blocks.wool, 1, 7)});
		//white+black+black=black;
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, 15), new Object[] {
			new ItemStack(PackFurniture.proxy.item.colored, 1, 0), new ItemStack(PackFurniture.proxy.item.colored, 1, 0), new ItemStack(Blocks.wool, 1, 0)});
		//white+black+gray=black;
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, 15), new Object[] {
			new ItemStack(PackFurniture.proxy.item.colored, 1, 4), new ItemStack(PackFurniture.proxy.item.colored, 1, 0), new ItemStack(Blocks.wool, 1, 0)});
		/*
		for (byte i = 0; i < 16; ++i) {
		GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block.lamps_click_off, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Blocks.glass, 'L', Items.glowstone, 'P', Blocks.lever, 'X', new ItemStack(PackFurniture.proxy.item.colored, 1, i)});
		GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block.lamps_off, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Blocks.glass, 'L', Items.glowstone, 'P', Items.redstone, 'X', new ItemStack(PackFurniture.proxy.item.colored, 1, i)});
		GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block.lamps_on_invert, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Blocks.glass, 'L', Items.glowstone, 'P', Blocks.torchRedstoneActive, 'X', new ItemStack(PackFurniture.proxy.item.colored, 1, i)});

		GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block.lamps_click_off, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Blocks.glass, 'L', Items.glowstone, 'P', Blocks.lever, 'X', new ItemStack(Items.dyePowder, 1, GetColors.convertME_MCitem(i))});
		GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block.lamps_off, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Blocks.glass, 'L', Items.glowstone, 'P', Items.redstone, 'X', new ItemStack(Items.dyePowder, 1, GetColors.convertME_MCitem(i))});
		GameRegistry.addRecipe(new ItemStack(PackFurniture.proxy.block.lamps_on_invert, 1, i), new Object[] {"GGG", "LXL", "GPG", 'G', Blocks.glass, 'L', Items.glowstone, 'P', Blocks.torchRedstoneActive, 'X', new ItemStack(Items.dyePowder, 1, GetColors.convertME_MCitem(i))});
		}
		 */
		/*
		for (byte i = 0; i < 16; ++i) {
		GameRegistry.addShapelessRecipe(new ItemStack(PackFurniture.proxy.block.brick_clay_colors, 1, i), new Object[] {
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, 32), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, 32)});
		}

		for (byte i = 0; i < 16; ++i) {
		GameRegistry.addShapelessRecipe(new ItemStack(PackFurniture.proxy.block.brick_stone_colors, 1, i), new Object[] {
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i+16), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i+16), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i+16), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i+16), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, 32), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, 32)});
		}*/
		/*
		//Colored Brick Clay
		for (byte i = 0; i < 16; ++i) {
		GameRegistry.addShapelessRecipe(new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i), new Object[] {
		new ItemStack(PackFurniture.proxy.item.colored, 1, i), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, 33)});
		}
		//Colored Brick Stone
		for (byte i = 0; i < 16; ++i) {
		GameRegistry.addShapelessRecipe(new ItemStack(PackFurniture.proxy.item.brick_colors, 1, i+16), new Object[] {
		new ItemStack(PackFurniture.proxy.item.colored, 1, i), 
		new ItemStack(PackFurniture.proxy.item.brick_colors, 1, 34)});
		}

		for (byte i = 0; i < 16; ++i) {
		GameRegistry.addShapelessRecipe(setTagAirBush(GetColors.getHexColors[i]), new Object[] {
		new ItemStack(PackFurniture.proxy.item.colored, 1, i), 
		new ItemStack(PackFurniture.proxy.tool_airbrush, 1, 0)});
		}

		for (byte i = 0; i < PackFurniture.proxy.item.filter_charcoal.getMaxDamage(); ++i) {
		GameRegistry.addShapelessRecipe(new ItemStack(Items.glassBottle), new Object[] {
		new ItemStack(PackFurniture.proxy.item.filter_charcoal, 1 , i), 
		new ItemStack(Items.potion)});
		}

		for (byte i = 1; i <= PackFurniture.proxy.item.filter_charcoal.getMaxDamage(); ++i) {
		GameRegistry.addShapelessRecipe(new ItemStack(PackFurniture.proxy.item.filter_charcoal, 1, 0), 
		new Object[] {
		new ItemStack(PackFurniture.proxy.item.filter_charcoal, 1 , i), 
		new ItemStack(Items.coal, 1 , 1)});
		}

		GameRegistry.addRecipe(setTagCnstorBlock(0, 0xFFFFFF, 6), new Object[] {
		"SWS", "WBW", "SWS", 'W', Blocks.planks, 'B', Items.stick, 'S', Items.stick});

		GameRegistry.addRecipe(setTagCnstorBlock(1, 0xFFFFFF, 4), new Object[] {
		"SWS", "WBW", "SWS", 'W', Blocks.planks, 'B', Blocks.anvil, 'S', Items.stick});

		GameRegistry.addRecipe(setTagCnstorBlock(2, 0xFFFFFF, 4), new Object[] {
		"SWS", "WBW", "SWS", 'W', Blocks.planks, 'B', Blocks.bedrock, 'S', Items.stick});

		GameRegistry.addRecipe(setTagCnstorBlock(3, 0xFFFFFF, 4), new Object[] {
		"SWS", "WBW", "SWS", 'W', Blocks.planks, 'B', Blocks.brick, 'S', Items.stick});

		GameRegistry.addRecipe(setTagCnstorBlock(4, 0xFFFFFF, 4), new Object[] {
		"SWS", "WBW", "SWS", 'W', Blocks.planks, 'B', Blocks.clay, 'S', Items.stick});
		/*
		String[] dyes = {
		"dyeBlack", 
		"dyeRed", 
		"dyeGreen", 
		"dyeBrown", 
		"dyeBlue", 
		"dyePurple", 
		"dyeCyan", 
		"dyeLightGray", 
		"dyeGray", 
		"dyePink", 
		"dyeLime", 
		"dyeYellow", 
		"dyeLightBlue", 
		"dyeMagenta", 
		"dyeOrange", 
		"dyeWhite"
		};

		for (int i = 0; i < 16; ++i) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(Items.stick, new Object[]{dyes[i], Items.stick}));
		}
		 */
		//MincerRecipes.mince().addMince(Items.bakedPotato.getItem(), 0, new ItemStack(PackFurniture.itemColored, 1, 0));

	}

	private static ItemStack setTagCnstorBlock(int par1, int par2, int par3) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.cnstor_block, par3, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Type", par1);
		tag.setInteger("Color", par2);
		is.setTagCompound(tag);
		return is;
	}

	private static ItemStack setTagAirBush(int par1) {
		ItemStack is = new ItemStack(PackFurniture.proxy.item.tool_airbrush, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("HexColor", par1);
		is.setTagCompound(tag);
		return is;
	}

}
