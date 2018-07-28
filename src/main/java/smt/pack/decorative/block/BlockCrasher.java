package smt.pack.decorative.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.decorative.SMTDecorative;
import smt.pack.decorative.inventory.GuiID;
import smt.pack.decorative.tile.TileEntityCrusher;

public class BlockCrasher extends Block implements ITileEntityProvider {

	public BlockCrasher() {
		super(Material.rock);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityCrusher();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityCrusher) {
			//TileEntityCrasher te = (TileEntityCrasher)tile;
			SMTDecorative.proxy.openGui(GuiID.CRASHER, player, x, y, z);
			return true;
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityCrusher) {
			TileEntityCrusher te = (TileEntityCrusher)tile;
			//if (is.hasDisplayName()) te.setInventoryName(is.getDisplayName());
		}
		//int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile != null) {
			if (tile instanceof TileEntityCrusher) {
				TileEntityCrusher te = (TileEntityCrusher)tile;
				IInventory inv = te.getInventory();
				for (int i = 0; i < inv.getSizeInventory(); ++i) {
					ItemStack itemStack = inv.getStackInSlot(i);
					if (itemStack != null) dropBlockAsItem(world, x, y, z, itemStack);
				}
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

}
