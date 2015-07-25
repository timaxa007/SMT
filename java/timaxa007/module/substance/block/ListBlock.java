package timaxa007.module.substance.block;

import net.minecraft.block.Block;
import timaxa007.smt.util.UtilSMT;

public class ListBlock {

	public static boolean
	substance_fake_water_be,
	substance_fake_water_flowing_be,
	substance_fake_lava_be,
	substance_fake_lava_flowing_be
	;

	public static Block
	substance_fake_water,
	substance_fake_water_flowing,
	substance_fake_lava,
	substance_fake_lava_flowing
	;

	public static Block[] list_block;

	public static Class[] list_te;

	public static void preInit() {

		if (substance_fake_water_be) {
			substance_fake_water = new BlockSubstanceFakeWaterStatic("substance_fake_water").setLightOpacity(3).setBlockTextureName("water_still");
		}
		if (substance_fake_water_flowing_be) {
			substance_fake_water_flowing = new BlockSubstanceFakeWaterDynamic("substance_fake_water_flowing").setLightOpacity(3).setBlockTextureName("water_flow");
		}
		if (substance_fake_lava_be) {
			substance_fake_lava = new BlockSubstanceFakeLavaStatic("substance_fake_lava").setLightLevel(1.0F).setBlockTextureName("lava_still");
		}
		if (substance_fake_lava_flowing_be) {
			substance_fake_lava_flowing = new BlockSubstanceFakeLavaDynamic("substance_fake_lava_flowing").setLightLevel(1.0F).setBlockTextureName("lava_flow");
		}

		list_block = new Block[] {
				substance_fake_water,
				substance_fake_water_flowing,
				substance_fake_lava,
				substance_fake_lava_flowing
		};

		UtilSMT.UtilBlock.RegBlock(list_block);

	}

}
