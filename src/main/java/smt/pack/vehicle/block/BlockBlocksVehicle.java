package smt.pack.vehicle.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBlocksVehicle extends Block implements ITileEntityProvider {

	public BlockBlocksVehicle() {
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return null;
	}

}
