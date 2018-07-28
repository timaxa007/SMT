package smt.pack.magic.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.magic.tile.TileEntityAltar;

public class BlockAltar extends Block implements ITileEntityProvider {

	public BlockAltar() {
		super(Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityAltar();
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata) {
		if (world.getBlock(x, y, z) == this) {
			//addStat(betterores_getSaphireAchievment.achievement, 1);
			System.out.println("onBlockDestroyedByPlayer");
		}
	}

}
