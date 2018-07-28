package smt.pack.cookery.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.cookery.SMTCookery;
import smt.pack.cookery.inventory.GuiID;
import smt.pack.cookery.tile.TileEntityGrill;

public class BlockGrill extends Block implements ITileEntityProvider {

	public BlockGrill() {
		super(Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityGrill();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityGrill) {
			TileEntityGrill te = (TileEntityGrill)tile;
			SMTCookery.proxy.openGui(GuiID.GRILL, player, x, y, z);
			return true;
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block_old, int metadata_old) {
		if (world.getTileEntity(x, y, z) instanceof TileEntityGrill) {
			TileEntityGrill tileEntityGrill = (TileEntityGrill)world.getTileEntity(x, y, z);
			for (int i1 = 0; i1 < tileEntityGrill.getSizeInventory(); ++i1) {
				ItemStack itemstack = tileEntityGrill.getStackInSlot(i1);
				if (itemstack != null)
					dropBlockAsItem(world, x, y, z, itemstack);
			}
		}
		super.breakBlock(world, x, y, z, block_old, metadata_old);
	}

}
