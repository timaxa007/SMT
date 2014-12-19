package mods.timaxa007.pack.techno.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.techno.PackTechno;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGenerators extends Block {

	public static final String[] generatorNames = new String[] {
		"Solid", 
		"Gas", 
		"Liquid", 
		"Solar", 
		"Windmill", 
		"Watermill", 
		"7", 
		"8", 
		"9", 
		"10", 
		"11", 
		"12", 
		"13", 
		"14", 
		"15", 
		"16"
	};

	@SideOnly(Side.CLIENT) private IIcon[] iconArray;

	public BlockGenerators() {
		super(Material.iron);
		setCreativeTab(PackTechno.tab_techno);
		setStepSound(soundTypeMetal);
		setBlockTextureName("planks_oak");
		setBlockName("generators");
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < 16; ++j) {
			list.add(new ItemStack(id, 1, j));
		}
	}

}
