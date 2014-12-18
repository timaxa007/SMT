package mods.timaxa007.pack.furniture.common.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.furniture.common.main.PackFurniture;
import mods.timaxa007.pack.furniture.common.tile.TECandle;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCandle extends Block implements ITileEntityProvider {

	public BlockCandle() {
		super(Material.circuits);
		setCreativeTab(PackFurniture.proxy.tab_furniture);
		setHardness(0.3F);
		setResistance(1.0F);
		setLightOpacity(0);
		float f = 0.15F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
		setBlockTextureName("snow");
		setBlockName("candle");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TECandle();
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public int getRenderType() {
		return PackFurniture.proxy.render_block_candle_modelID;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	/*
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		int l = world.getBlock(x, y, z);
		Block block = Block.blocksList[l];
		return (block == null || block.isBlockReplaceable(world, x, y, z)) && world.doesBlockHaveSolidTopSurface(x, y - 1, z);
	}
	 */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rdm) {
		int l = world.getBlockMetadata(x, y, z);
		double d0 = (double)((float)x + 0.5F);
		double d1 = (double)((float)y + 0.5F);
		double d2 = (double)((float)z + 0.5F);
		double d3 = 0.2199999988079071D;
		double d4 = 0.27000001072883606D;
		int random = rdm.nextInt(16);

		if (world.getBlock(x, y - 1, z) == Blocks.bookshelf) {

			if (random == 0) {world.spawnParticle("enchantmenttable", d0 - 0.2D, d1, d2 - 0.2D, 0.0D + 0.1D, 0.0D, 0.0D + 0.1D);}
			else if (random == 1) {world.spawnParticle("enchantmenttable", d0 - 0.2D, d1, d2 + 0.2D, 0.0D + 0.1D, 0.0D, 0.0D - 0.1D);}
			else if (random == 2) {world.spawnParticle("enchantmenttable", d0 + 0.2D, d1, d2 - 0.2D, 0.0D - 0.1D, 0.0D, 0.0D + 0.1D);}
			else if (random == 3) {world.spawnParticle("enchantmenttable", d0 + 0.2D, d1, d2 + 0.2D, 0.0D - 0.1D, 0.0D, 0.0D - 0.1D);}
			else if (random == 4) {world.spawnParticle("enchantmenttable", d0 - 0.3D, d1 + 0.2D, d2, 0.0D + 0.1D, 0.0D + 0.1D, 0.0D);}
			else if (random == 5) {world.spawnParticle("enchantmenttable", d0 + 0.3D, d1 + 0.2D, d2, 0.0D - 0.1D, 0.0D + 0.1D, 0.0D);}
			else if (random == 6) {world.spawnParticle("enchantmenttable", d0, d1 + 0.2D, d2 - 0.3D, 0.0D, 0.0D + 0.1D, 0.0D + 0.1D);}
			else if (random == 7) {world.spawnParticle("enchantmenttable", d0, d1 + 0.2D, d2 + 0.3D, 0.0D, 0.0D + 0.1D, 0.0D - 0.1D);}
			else {;}

		}

		/*
if (l == 0) {
if (random == 0) {world.spawnParticle("fireworksSpark", d0 - 0.2D, d1, d2 - 0.2D, 0.0D + 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 1) {world.spawnParticle("fireworksSpark", d0 - 0.2D, d1, d2 + 0.2D, 0.0D + 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 2) {world.spawnParticle("fireworksSpark", d0 + 0.2D, d1, d2 - 0.2D, 0.0D - 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 3) {world.spawnParticle("fireworksSpark", d0 + 0.2D, d1, d2 + 0.2D, 0.0D - 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 4) {world.spawnParticle("fireworksSpark", d0 - 0.3D, d1 + 0.2D, d2, 0.0D + 0.1D, 0.0 + 0.1D, 0.0D);}
else if (random == 5) {world.spawnParticle("fireworksSpark", d0 + 0.3D, d1 + 0.2D, d2, 0.0D - 0.1D, 0.0D + 0.1D, 0.0D);}
else if (random == 6) {world.spawnParticle("fireworksSpark", d0, d1 + 0.2D, d2 - 0.3D, 0.0D, 0.0D + 0.1D, 0.0D + 0.1D);}
else if (random == 7) {world.spawnParticle("fireworksSpark", d0, d1 + 0.2D, d2 + 0.3D, 0.0D, 0.0D + 0.1D, 0.0D - 0.1D);}
else {
world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
world.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
}
}

else if (l == 1) {
if (random == 0) {world.spawnParticle("witchFurniture", d0 - 0.2D, d1, d2 - 0.2D, 0.0D + 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 1) {world.spawnParticle("witchFurniture", d0 - 0.2D, d1, d2 + 0.2D, 0.0D + 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 2) {world.spawnParticle("witchFurniture", d0 + 0.2D, d1, d2 - 0.2D, 0.0D - 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 3) {world.spawnParticle("witchFurniture", d0 + 0.2D, d1, d2 + 0.2D, 0.0D - 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 4) {world.spawnParticle("witchFurniture", d0 - 0.3D, d1 + 0.2D, d2, 0.0D + 0.1D, 0.0 + 0.1D, 0.0D);}
else if (random == 5) {world.spawnParticle("witchFurniture", d0 + 0.3D, d1 + 0.2D, d2, 0.0D - 0.1D, 0.0D + 0.1D, 0.0D);}
else if (random == 6) {world.spawnParticle("witchFurniture", d0, d1 + 0.2D, d2 - 0.3D, 0.0D, 0.0D + 0.1D, 0.0D + 0.1D);}
else if (random == 7) {world.spawnParticle("witchFurniture", d0, d1 + 0.2D, d2 + 0.3D, 0.0D, 0.0D + 0.1D, 0.0D - 0.1D);}
world{
world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
world.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
}
}

else if (l == 2) {
if (random == 0) {world.spawnParticle("happyVillager", d0 - 0.2D, d1, d2 - 0.2D, 0.0D + 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 1) {world.spawnParticle("happyVillager", d0 - 0.2D, d1, d2 + 0.2D, 0.0D + 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 2) {world.spawnParticle("happyVillager", d0 + 0.2D, d1, d2 - 0.2D, 0.0D - 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 3) {world.spawnParticle("happyVillager", d0 + 0.2D, d1, d2 + 0.2D, 0.0D - 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 4) {world.spawnParticle("happyVillager", d0 - 0.3D, d1 + 0.2D, d2, 0.0D + 0.1D, 0.0 + 0.1D, 0.0D);}
else if (random == 5) {world.spawnParticle("happyVillager", d0 + 0.3D, d1 + 0.2D, d2, 0.0D - 0.1D, 0.0D + 0.1D, 0.0D);}
else if (random == 6) {world.spawnParticle("happyVillager", d0, d1 + 0.2D, d2 - 0.3D, 0.0D, 0.0D + 0.1D, 0.0D + 0.1D);}
else if (random == 7) {world.spawnParticle("happyVillager", d0, d1 + 0.2D, d2 + 0.3D, 0.0D, 0.0D + 0.1D, 0.0D - 0.1D);}
else {
world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
world.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
}
}

else if (l == 3) {
if (random == 0) {world.spawnParticle("enchantmenttable", d0 - 0.2D, d1, d2 - 0.2D, 0.0D + 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 1) {world.spawnParticle("enchantmenttable", d0 - 0.2D, d1, d2 + 0.2D, 0.0D + 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 2) {world.spawnParticle("enchantmenttable", d0 + 0.2D, d1, d2 - 0.2D, 0.0D - 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 3) {world.spawnParticle("enchantmenttable", d0 + 0.2D, d1, d2 + 0.2D, 0.0D - 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 4) {world.spawnParticle("enchantmenttable", d0 - 0.3D, d1 + 0.2D, d2, 0.0D + 0.1D, 0.0 + 0.1D, 0.0D);}
else if (random == 5) {world.spawnParticle("enchantmenttable", d0 + 0.3D, d1 + 0.2D, d2, 0.0D - 0.1D, 0.0D + 0.1D, 0.0D);}
else if (random == 6) {world.spawnParticle("enchantmenttable", d0, d1 + 0.2D, d2 - 0.3D, 0.0D, 0.0D + 0.1D, 0.0D + 0.1D);}
else if (random == 7) {world.spawnParticle("enchantmenttable", d0, d1 + 0.2D, d2 + 0.3D, 0.0D, 0.0D + 0.1D, 0.0D - 0.1D);}
else {
world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
world.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
}
}

else if (l == 4) {
if (random == 0) {world.spawnParticle("portal", d0 - 0.2D, d1, d2 - 0.2D, 0.0D + 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 1) {world.spawnParticle("portal", d0 - 0.2D, d1, d2 + 0.2D, 0.0D + 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 2) {world.spawnParticle("portal", d0 + 0.2D, d1, d2 - 0.2D, 0.0D - 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 3) {world.spawnParticle("portal", d0 + 0.2D, d1, d2 + 0.2D, 0.0D - 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 4) {world.spawnParticle("portal", d0 - 0.3D, d1 + 0.2D, d2, 0.0D + 0.1D, 0.0 + 0.1D, 0.0D);}
else if (random == 5) {world.spawnParticle("portal", d0 + 0.3D, d1 + 0.2D, d2, 0.0D - 0.1D, 0.0D + 0.1D, 0.0D);}
else if (random == 6) {world.spawnParticle("portal", d0, d1 + 0.2D, d2 - 0.3D, 0.0D, 0.0D + 0.1D, 0.0D + 0.1D);}
else if (random == 7) {world.spawnParticle("portal", d0, d1 + 0.2D, d2 + 0.3D, 0.0D, 0.0D + 0.1D, 0.0D - 0.1D);}
else {
world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
world.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
}
}

else if (l == 5) {
if (random == 0) {world.spawnParticle("explode", d0 - 0.2D, d1, d2 - 0.2D, 0.0D + 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 1) {world.spawnParticle("explode", d0 - 0.2D, d1, d2 + 0.2D, 0.0D + 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 2) {world.spawnParticle("explode", d0 + 0.2D, d1, d2 - 0.2D, 0.0D - 0.1D, 0.0D, 0.0D + 0.1D);}
else if (random == 3) {world.spawnParticle("explode", d0 + 0.2D, d1, d2 + 0.2D, 0.0D - 0.1D, 0.0D, 0.0D - 0.1D);}
else if (random == 4) {world.spawnParticle("explode", d0 - 0.3D, d1 + 0.2D, d2, 0.0D + 0.1D, 0.0 + 0.1D, 0.0D);}
else if (random == 5) {world.spawnParticle("explode", d0 + 0.3D, d1 + 0.2D, d2, 0.0D - 0.1D, 0.0D + 0.1D, 0.0D);}
else if (random == 6) {world.spawnParticle("explode", d0, d1 + 0.2D, d2 - 0.3D, 0.0D, 0.0D + 0.1D, 0.0D + 0.1D);}
else if (random == 7) {world.spawnParticle("explode", d0, d1 + 0.2D, d2 + 0.3D, 0.0D, 0.0D + 0.1D, 0.0D - 0.1D);}
else {
world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
world.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
}
}

else {*/
		if (this == PackFurniture.proxy.block_candle_light) {
			if (world.rand.nextInt(8) == 0) {
				world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
			if (world.rand.nextInt(2) == 0) {
				world.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
			//}
		}

	}
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (byte j = 0; j < 16; ++ j) {list.add(new ItemStack(id, 1, j));}
	}
	/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int meta, int fortune) {
ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, meta, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block_candle, 1, meta));
return ret;
}
	 */
}
