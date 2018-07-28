package smt.pack.decorative.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.decorative.SMTDecorative;
import smt.pack.decorative.tile.TileEntityStand;

public class BlockStand extends Block implements net.minecraft.block.ITileEntityProvider {

	public BlockStand() {
		super(Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityStand();
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntityStand tile = (TileEntityStand)world.getTileEntity(x, y, z);
		if (tile != null) {
			ItemStack current = player.getCurrentEquippedItem();

			if (current != null && tile.getItemStack() == null) {
				tile.setItemStack(current);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				return true;
			}
			else if (current == null && tile.getItemStack() != null) {
				player.inventory.setInventorySlotContents(player.inventory.currentItem, tile.getItemStack());
				tile.setItemStack(null);
				return true;
			}
			else if (current != null && tile.getItemStack() != null) {
				dropBlockAsItem(world, x, y + 1, z, tile.getItemStack());
				tile.setItemStack(null);
				return true;
			}

		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
		TileEntityStand tile = (TileEntityStand)world.getTileEntity(x, y, z);
		if (tile != null && tile.getItemStack() != null) dropBlockAsItem(world, x, y, z, tile.getItemStack());
		super.breakBlock(world, x, y, z, block, metadata);
	}

}
