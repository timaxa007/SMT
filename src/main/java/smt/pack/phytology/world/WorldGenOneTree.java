package smt.pack.phytology.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import smt.pack.phytology.SMTPhytology;

public class WorldGenOneTree extends WorldGenerator {

	static byte[][][] structural_layers = new byte[][][] {
			{
				{1}
			},{
				{1}
			},{
				{1}
			},{
				{1}
			},{
				{2, 2, 2},
				{2, 1, 2},
				{2, 2, 2}
			},{
				{2, 2, 2},
				{2, 1, 2},
				{2, 2, 2}
			},{
				{0, 2, 0},
				{2, 1, 2},
				{0, 2, 0}
			},{
				{0, 2, 0},
				{2, 1, 2},
				{0, 2, 0}
			},{
				{2}
			}
	};

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		for (int py = 0; py < structural_layers.length; ++py) {
			for (int px = 0; px < structural_layers[py].length; ++px) {
				for (int pz = 0; pz < structural_layers[py][px].length; ++pz) {

					int px2 = px - (structural_layers[py].length / 2);
					int pz2 = pz - (structural_layers[py][px].length / 2);

					switch(structural_layers[py][px][pz]){
					case 1:
						world.setBlock(x + px2, y + py, z + pz2, SMTPhytology.block.log, 0, 3);
						break;
					case 2:
						if (world.getBlock(x + px2, y + py, z + pz2).isReplaceable(world, x + px2, y + py, z + pz2))
							world.setBlock(x + px2, y + py, z + pz2, SMTPhytology.block.leaves, 0, 3);
						break;
					default:continue;
					}

				}
			}
		}
		return true;
	}

}
