package smt.pack.decorative.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDecorativeGlass extends Block implements ITileEntityProvider {

	public BlockDecorativeGlass() {
		super(Material.glass);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return null;
	}

}
