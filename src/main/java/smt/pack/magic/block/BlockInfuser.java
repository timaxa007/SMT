package smt.pack.magic.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.decorative.tile.TileEntityStand;
import smt.pack.magic.tile.TileEntityInfuser;

public class BlockInfuser extends Block implements net.minecraft.block.ITileEntityProvider {

	public BlockInfuser() {
		super(Material.rock);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityInfuser();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityInfuser) {
			TileEntityInfuser te = (TileEntityInfuser)tile;
			//SMTMagic.proxy.openGui(GuiID.INFUSER, player, x, y, z);
			if (!world.isRemote)
			te.onBlockActivated();
			return true;
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

}
