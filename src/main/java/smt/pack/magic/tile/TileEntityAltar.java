package smt.pack.magic.tile;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import smt.pack.UtilBlock;

import com.google.common.collect.Lists;

public class TileEntityAltar extends TileEntity {

	public ArrayList<UtilBlock.BlockState> list_find = Lists.newArrayList();
	public ArrayList<UtilBlock.BlockPosState> list_use = Lists.newArrayList();
	private int tickReSearch = 0;
	private boolean isSearch = false;

	public TileEntityAltar() {
		list_find.add(new UtilBlock.BlockState(Blocks.beacon, 0));
		list_find.add(new UtilBlock.BlockState(Blocks.diamond_block, 0));
		list_find.add(new UtilBlock.BlockState(Blocks.emerald_block, 0));
	}

	public void updateEntity() {
		if (tickReSearch == 0) {
			searchAddBlocks(9);
		}
		++tickReSearch;
		if (tickReSearch >= 20 * 6) {
			tickReSearch = 0;
		}
	}

	public void searchAddBlocks(int radius) {
		list_use.clear();
		for (int px = xCoord - radius; px <= xCoord + radius; ++px) {
			for (int py = yCoord - radius / 2; py <= yCoord + radius; ++py) {
				for (int pz = zCoord - radius; pz <= zCoord + radius; ++pz) {
					for (int i = 0; i < list_find.size(); ++i) {
						UtilBlock.BlockState bs = list_find.get(i);
						if (bs != null &&
								!worldObj.isAirBlock(px, py, pz) &&
								worldObj.getBlock(px, py, pz) == bs.getBlock() &&
								worldObj.getBlockMetadata(px, py, pz) == bs.getMetadata()) {
							UtilBlock.BlockPosState bps = new UtilBlock.BlockPosState(
									bs, new UtilBlock.BlockPos(px, py, pz)
									);
							list_use.add(bps);
						}
					}
				}
			}
		}
	}

}
