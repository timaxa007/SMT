package smt.pack.technology.tile.machine;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;

public class ElectricBuilder extends ElectricMachine {

	//byte width, length, height;
	private int state = 0;
	private int time = 0;

	static byte[][][] structural_layers = new byte[][][] {
		{
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 0, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1}
		},{
			{2, 2, 2, 2, 2},
			{2, 0, 0, 0, 2},
			{2, 0, 0, 0, 2},
			{2, 0, 0, 0, 2},
			{2, 2, 0, 2, 2}
		},{
			{2, 2, 2, 2, 2},
			{2, 0, 0, 0, 2},
			{2, 0, 0, 0, 2},
			{2, 0, 0, 0, 2},
			{2, 2, 0, 2, 2}
		},{
			{2, 2, 2, 2, 2},
			{2, 0, 0, 0, 2},
			{2, 0, 0, 0, 2},
			{2, 0, 0, 0, 2},
			{2, 2, 2, 2, 2}
		},{
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1}
		}
	};

	public ElectricBuilder(smt.pack.technology.tile.TileEntityElectricMachine tile) {
		super(tile);
		state = 0;
	}

	@Override
	public void update() {
		if (tile.getWorldObj().isRemote) return;

		//System.out.println("tile - " + (tile != null));
		//System.out.println("tile.getWorldObj() - " + (tile.getWorldObj() != null));
		//System.out.println("Blocks.cobblestone - " + (Blocks.cobblestone != null));

		//tile.getWorldObj().setBlock(tile.xCoord, tile.yCoord + 1, tile.zCoord, Blocks.cobblestone, 0, 3);

		System.out.println("state " + state);
		int next = -1;
		for (int py = 0; py < structural_layers.length; ++py) {
			for (int px = 0; px < structural_layers[py].length; ++px) {
				for (int pz = 0; pz < structural_layers[py][px].length; ++pz) {
					/*
					++next;

					System.out.println("next " + next);

					if (state > next) continue;
					if (state < next) break;
					 */
					int px2 = px - (structural_layers[py].length / 2);
					int pz2 = pz - (structural_layers[py][px].length / 2);

					switch(structural_layers[py][px][pz]){
					case 1:
						tile.getWorldObj().setBlock(tile.xCoord + px2, tile.yCoord + py, tile.zCoord + pz2, Blocks.cobblestone, 0, 3);
						break;
					case 2:
						tile.getWorldObj().setBlock(tile.xCoord + px2, tile.yCoord + py, tile.zCoord + pz2, Blocks.planks, 0, 3);
						break;
					default:continue;
					}

				}
			}
		}

		if (state >= 0 && time % 20 == 0) ++state;
		++time;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {

	}

}
