package smt.pack.phytology.world;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import smt.pack.phytology.SMTPhytology;

public class WorldGenTwoTree extends WorldGenerator {

	static byte[][][] structural_layers = new byte[][][]{
		{
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
			{0, 2, 0},
			{2, 1, 2},
			{0, 2, 0}
		},{
			{2}
		},{
			{3}
		}
	};

	static byte[][] blocks_stone_bricks = new byte[][]{

		{-2, 0, -2},
		{-2, 0, -1},
		{-2, 0, 0},
		{-2, 0, 1},
		{-2, 0, 2},

		//{-2, 0, -2},
		{-1, 0, -2},
		{0, 0, -2},
		{1, 0, -2},
		{2, 0, -2},

		//{2, 0, -2},
		{2, 0, -1},
		{2, 0, 0},
		{2, 0, 1},
		{2, 0, 2},

		//{2, 0, 2},
		{1, 0, 2},
		{0, 0, 2},
		{-1, 0, 2}
		//{-2, 0, 2}
	};

	int
	x_min = 0,
	y_min = 0,
	z_min = 0,
	x_max = 0,
	y_max = 0,
	z_max = 0;

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {

		for (int j = 0; j < structural_layers.length; ++j) {
			for (int k = 0; k < structural_layers[j].length; ++k) {
				for (int l = 0; l < structural_layers[j][k].length; ++l) {

					int px1 = k - (structural_layers[j].length / 2);
					int pz1 = l - (structural_layers[j][k].length / 2);

					int
					x2 = x + px1,
					y2 = y + j,
					z2 = z + pz1;

					check(x2, y2, z2);

					switch(structural_layers[j][k][l]){
					case 1:
						world.setBlock(x2, y2, z2, SMTPhytology.block.log, 1, 3);
						break;
					case 2:
						if (world.getBlock(x2, y2, z2).isReplaceable(world, x2, y2, z2))
							world.setBlock(x2, y2, z2, SMTPhytology.block.leaves, 1, 3);
						break;
					case 3:
						Entity entity = new EntityCow(world);
						entity.setPosition(x2 + 0.5, y2 + 0.5, z2 + 0.5);
						if (!world.isRemote)
							world.spawnEntityInWorld(entity);
						break;
					default:continue;
					}

				}
			}
		}

		for (int i = 0; i < blocks_stone_bricks.length; ++i) {

			int
			x2 = x + blocks_stone_bricks[i][0],
			y2 = y + blocks_stone_bricks[i][1],
			z2 = z + blocks_stone_bricks[i][2];

			check(x2, y2, z2);

			world.setBlock(x2, y2, z2, Blocks.stonebrick, 0, 3);
		}

		return true;
	}

	void check(int x, int y, int z) {
		x_min = Math.min(x_min, x);
		y_min = Math.min(y_min, y);
		z_min = Math.min(z_min, z);
		x_max = Math.max(x_max, x);
		y_max = Math.max(y_max, y);
		z_max = Math.max(z_max, z);
	}

	public AxisAlignedBB getBoundingBox() {//new
		return AxisAlignedBB.getBoundingBox(x_min, y_min, z_min, x_max + 1, y_max + 1, z_max + 1);
	}

}
