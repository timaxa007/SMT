package mods.timaxa007.pack.stock.block;

import mods.timaxa007.pack.stock.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListBlock {

	public static Block 
	germination_plants, 
	foods, 
	healing, 
	apiary;

	public static Block[] list_block;

	public static void preInit() {

		germination_plants = new BlockGerminationPlants("germination_plants");
		foods = new BlockFoods("foods");
		healing = new BlockHealing("healing");
		apiary = new BlockApiary("apiary");

		list_block = new Block[] {
				germination_plants, 
				foods, 
				healing, 
				apiary
		};

		for (int i = 0; i < list_block.length; i++) 
			UtilTMS.UtilBlock.RegBlock(list_block[i]);

		GameRegistry.registerTileEntity(TileEntityGerminationPlants.class, "TileEntityGerminationPlants");
		GameRegistry.registerTileEntity(TileEntityFoods.class, "TileEntityFoods");
		GameRegistry.registerTileEntity(TileEntityHealing.class, "TileEntityHealing");
		GameRegistry.registerTileEntity(TileEntityApiary.class, "TileEntityApiary");

	}

}
