package smt.pack.decorative.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockTest extends Block implements ITileEntityProvider {

	public BlockTest() {
		super(Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return (metadata == 4 ? null : null);
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return y >= world.getHeight() - 1 ? false :
			World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) &&
			super.canPlaceBlockAt(world, x, y, z) &&
			super.canPlaceBlockAt(world, x, y + 1, z);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 3);
		world.setBlock(x, y + 1, z, this, 4, 3);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
		if (metadata == 4)
			world.setBlockToAir(x, y - 1, z);
		else
			world.setBlockToAir(x, y + 1, z);
		super.breakBlock(world, x, y, z, block, metadata);
	}

}
