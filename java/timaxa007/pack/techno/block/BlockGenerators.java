package timaxa007.pack.techno.block;

import java.util.List;

import timaxa007.pack.techno.PackTechno;
import timaxa007.pack.conjoint.object.ModifiedBlock;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGenerators extends ModifiedBlock {

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

	public BlockGenerators(String tag) {
		super(tag, Material.iron);
		setCreativeTab(PackTechno.tab_techno);
		setStepSound(soundTypeMetal);
		setBlockTextureName("planks_oak");
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < 16; ++j) {
			list.add(new ItemStack(id, 1, j));
		}
	}

}
