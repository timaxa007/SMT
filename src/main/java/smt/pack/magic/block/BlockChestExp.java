package smt.pack.magic.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.inventory.GuiID;
import smt.pack.magic.tile.TileEntityChestExp;

public class BlockChestExp extends Block implements net.minecraft.block.ITileEntityProvider {

	public BlockChestExp() {
		super(Material.wood);
		setHardness(1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityChestExp();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityChestExp) {
			TileEntityChestExp te = (TileEntityChestExp)tile;
			SMTMagic.proxy.openGui(GuiID.CHEST_EXP, player, x, y, z);
			return true;
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

}
