package mods.timaxa007.pack.stock.block;

import mods.timaxa007.pack.stock.tile.*;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockList {

	public static Block germination_plants;
	public static Block foods;
	public static Block healing;
	public static Block apiary;

	public static void preInit() {

		germination_plants = new BlockGerminationPlants();
		foods = new BlockFoods();
		healing = new BlockHealing();
		apiary = new BlockApiary();

		GameRegistry.registerBlock(germination_plants, "BlockGerminationPlants");
		GameRegistry.registerBlock(foods, ItemBlockFoods.class, "BlockFoods");
		GameRegistry.registerBlock(healing, "BlockHealing");
		GameRegistry.registerBlock(apiary, "BlockApiary");

		GameRegistry.registerTileEntity(TileEntityGerminationPlants.class, "TileEntityGerminationPlants");
		GameRegistry.registerTileEntity(TileEntityFoods.class, "TileEntityFoods");
		GameRegistry.registerTileEntity(TileEntityHealing.class, "TileEntityHealing");
		GameRegistry.registerTileEntity(TileEntityApiary.class, "TileEntityApiary");

	}

}
