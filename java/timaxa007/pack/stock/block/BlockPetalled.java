package timaxa007.pack.stock.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.pack.stock.tile.TileEntityPetalled;
import timaxa007.tms.util.ModifiedBlock;

public class BlockPetalled extends ModifiedBlock implements ITileEntityProvider {

	public BlockPetalled(String tag) {
		super(tag, Material.plants);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityPetalled();
	}

}
