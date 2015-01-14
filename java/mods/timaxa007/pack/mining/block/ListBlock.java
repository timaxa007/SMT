package mods.timaxa007.pack.mining.block;

import mods.timaxa007.pack.mining.tile.*;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListBlock {

	public static Block ore_rock_ores;
	public static Block ore_nether_ores;
	public static Block ore_ender_ores;
	public static Block cristals;

	public static void preInit() {

		ore_rock_ores = new OreOres().setBlockTextureName("stone");
		ore_nether_ores = new OreOres().setBlockTextureName("netherrack");
		ore_ender_ores = new OreOres().setBlockTextureName("end_stone");
		cristals = new BlockCristals();

		GameRegistry.registerBlock(ore_rock_ores, "OreRockOres");
		GameRegistry.registerBlock(ore_nether_ores, "OreNetherOres");
		GameRegistry.registerBlock(ore_ender_ores, "OreEnderOres");
		GameRegistry.registerBlock(cristals, "BlockCristals");

		GameRegistry.registerTileEntity(TileEntityCristals.class, "TileEntityCristals");
		GameRegistry.registerTileEntity(TileEntityOreOres.class, "TileEntityOreOres");

	}

}
