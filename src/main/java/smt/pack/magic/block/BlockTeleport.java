package smt.pack.magic.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.tile.TileEntityTeleport;

public class BlockTeleport extends Block implements ITileEntityProvider {

	public BlockTeleport() {
		super(Material.wood);
		setHardness(1.0F);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityTeleport();
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

}
