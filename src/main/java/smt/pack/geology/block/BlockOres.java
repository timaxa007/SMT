package smt.pack.geology.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.geology.tile.TileEntityBlockOres;

public class BlockOres extends Block implements ITileEntityProvider {

	public BlockOres() {
		super(Material.rock);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBlockOres();
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	/*
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	 */
}
