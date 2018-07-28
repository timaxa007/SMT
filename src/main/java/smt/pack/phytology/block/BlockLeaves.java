package smt.pack.phytology.block;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLeaves extends net.minecraft.block.BlockLeaves {

	public static final String[] names = new String[] {
		"1",
		"2",
		"3",
		"4",
		"5",
		"6",
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
	private static final IIcon[] icons = new IIcon[names.length];

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@Override
	public ItemStack createStackedBlock(int metadata) {
		return new ItemStack(Item.getItemFromBlock(this), 1, metadata);
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
		return ret;
	}

	@Override
	public void beginLeavesDecay(World world, int x, int y, int z) {
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z), 4);
	}

	@Override
	public IIcon getIcon(int side, int metadata) {
		if (metadata < 0 || metadata >= icons.length) metadata = 0;
		return icons[metadata];
	}

	@Override
	public String[] func_150125_e() {
		return names;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < names.length; ++i)
			list.add(new ItemStack(item, 1, i));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister ir) {
		for (int i = 0; i < icons.length; ++i)
			icons[i] = ir.registerIcon(getTextureName() + "_" + names[i]);
	}

}
