package timaxa007.pack.stock.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.pack.stock.tile.TileEntityStockMachines;
import timaxa007.smt.object.ModifiedBlock;


public class BlockStockMachines extends ModifiedBlock implements ITileEntityProvider {

	public BlockStockMachines(String tag) {
		super(tag, Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityStockMachines();
	}

}
