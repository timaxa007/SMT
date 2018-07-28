package smt.pack.phytology.block;

import static cpw.mods.fml.relauncher.Side.CLIENT;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import smt.pack.phytology.world.WorldGenOneTree;
import smt.pack.phytology.world.WorldGenTwoTree;

/**Класс ItemBlock, для этого класса, обязательно использовать.**/
public class BlockSapling extends BlockBush implements IGrowable {

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
	/*
	@SideOnly(CLIENT)
	private IIcon[] icons = new IIcon[names.length];
	 */
	public BlockSapling() {
		super(Material.plants);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		if (!world.isRemote) {
			super.updateTick(world, x, y, z, random);

			//Если для этого блока будет свет 9 и больше, и рандомом от 0 о 6 будет равняться 0, то ...
			if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0)
				//будет выполнен метод saplingGrowTree.
				saplingGrowTree(world, x, y, z, random);
		}
	}

	/**Наш метод, в котором будет выстраиваться структура дерева.**/
	public void saplingGrowTree(World world, int x, int y, int z, Random random) {
		//Если эвентом будет отменён рост этого саженца, то дальше не будет выполняться.
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, random, x, y, z)) return;
		int l = world.getBlockMetadata(x, y, z);
		WorldGenerator gen = null;

		//По определённой метадате будет выбран объект WorldGenerator'а.
		switch (l) {
		case 0:
			gen = new WorldGenOneTree();
			break;
		case 1:
			gen = new WorldGenTwoTree();
			break;

		default:break;
		}

		//Если в локальной переменной gen если не null, то будет выполнен метод generate от объекта WorldGenerator.
		if (gen != null) gen.generate(world, random, x, y, z);

	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@SideOnly(CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < names.length; ++i)
			list.add(new ItemStack(item, 1, i));
	}
	/**
	 * Gets the block's texture. Args: side, meta
	 */
	/*
	@SideOnly(CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata) {
		if (metadata < 0 || metadata >= icons.length) metadata = 0;
		return icons[metadata];
	}
	 */
	/*
	@SideOnly(CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister ir) {
		for (int i = 0; i < icons.length; ++i) {
			icons[i] = ir.registerIcon(getTextureName() + "_" + names[i]);
		}
	}
	 */
	@Override
	/**Можно-ли использовать костную муку.**/
	public boolean func_149851_a(World world, int x, int y, int z, boolean p_149851_5_) {
		return true;
	}

	@Override
	/**Будет-ли использован метод func_149853_b.**/
	public boolean func_149852_a(World world, Random random, int x, int y, int z) {
		return (double)world.rand.nextFloat() < 0.45D;
	}

	@Override
	/**Если func_149851_a и func_149852_a будут true, то будет сработает этот метод.**/
	public void func_149853_b(World world, Random random, int x, int y, int z) {
		saplingGrowTree(world, x, y, z, random);
	}

}
