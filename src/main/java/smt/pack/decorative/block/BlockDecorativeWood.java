package smt.pack.decorative.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDecorativeWood extends Block implements ITileEntityProvider {

	public BlockDecorativeWood() {
		super(Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return null;
	}

}
