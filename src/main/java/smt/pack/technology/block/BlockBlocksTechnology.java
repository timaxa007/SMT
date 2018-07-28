package smt.pack.technology.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.technology.tile.TileEntityBlocksTechnology;

public class BlockBlocksTechnology extends Block implements ITileEntityProvider {

	public BlockBlocksTechnology() {
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityBlocksTechnology();
	}

}
