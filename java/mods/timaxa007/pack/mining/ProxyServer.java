package mods.timaxa007.pack.mining;

import mods.timaxa007.pack.mining.blocks.*;
import mods.timaxa007.pack.mining.items.*;
import mods.timaxa007.pack.mining.list.ListMining;
import mods.timaxa007.pack.mining.te.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyServer {

	public static CreativeTabs tab_mining = new TabMining("tab_mining");
	public static CreativeTabs tab_tools = new TabTools("tab_tools");

	public static ArmorMaterial METALSMATERIAL = EnumHelper.addArmorMaterial("METALSMATERIAL", 15, new int[] {3, 7, 5, 3}, 10);
	public static ArmorMaterial GEMSMATERIAL = EnumHelper.addArmorMaterial("GEMSMATERIAL", 15, new int[] {5, 10, 7, 4}, 12);

	public static final ToolMaterial TOOLGEMS = EnumHelper.addToolMaterial("TOOLGEMS", 3, 512, 7.0F, 3, 7);
	public static final ToolMaterial TOOLMETALS = EnumHelper.addToolMaterial("TOOLMETALS", 2, 300, 6.0F, 2, 11);

	//Blocks
	public static Block ore_rock_ores;
	public static Block ore_nether_ores;
	public static Block ore_ender_ores;
	public static Block block_cristals;

	//Items
	public static Item items_for_mining;

	public static int render_block_cristals_modelID;

	public static BiomeGenBase biome_test;
	public static BiomeGenBase biome_hot;

	public static int world_dim_mining_id;
	public static int world_dim_only_day_id;
	public static int world_dim_only_night_id;

	public void preInit(FMLPreInitializationEvent event) {
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();
		/*
		world_dim_mining_id = cfg.get("configs", "world_dim_mining_id", 30).getInt();
		world_dim_only_day_id = cfg.get("configs", "world_dim_only_day_id", 31).getInt();
		world_dim_only_night_id = cfg.get("configs", "world_dim_only_night_id", 32).getInt();
		 */
		cfg.save();

		new ListMining();

		//Blocks
		ore_rock_ores = new OreOres().setBlockTextureName("stone");
		ore_nether_ores = new OreOres().setBlockTextureName("netherrack");
		ore_ender_ores = new OreOres().setBlockTextureName("end_stone");
		block_cristals = new BlockCristals();

		//Items
		items_for_mining = new ItemsMining();

		//Blocks
		GameRegistry.registerBlock(ore_rock_ores, "OreRockOres");
		GameRegistry.registerBlock(ore_nether_ores, "OreNetherOres");
		GameRegistry.registerBlock(ore_ender_ores, "OreEnderOres");
		GameRegistry.registerBlock(block_cristals, "BlockCristals");

		//Items
		GameRegistry.registerItem(items_for_mining, "ItemsMining");

		GameRegistry.registerTileEntity(TECristals.class, "TECristals");
		GameRegistry.registerTileEntity(TEOreOres.class, "TEOreOres");

		render_block_cristals_modelID = -1;

		//OreDictionary.registerOre("ignotCopper", new ItemStack(itemMetals, 1, 64));

		//ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(itemMetals, 1, 64), 10, 70, 2));
		/*
		GameRegistry.registerWorldGenerator(new Generator_Mining());
		biome_test = new BiomeTest(30);
		biome_hot = new BiomeHot(31);
		GameRegistry.addBiome(biome_test);
		GameRegistry.addBiome(biome_hot);
		 *//*
		DimensionManager.registerProviderType(world_dim_mining_id, WorldMining.class, true);
		DimensionManager.registerDimension(world_dim_mining_id, world_dim_mining_id);

		DimensionManager.registerProviderType(world_dim_only_day_id, WorldOnlyDay.class, true);
		DimensionManager.registerDimension(world_dim_only_day_id, world_dim_only_day_id);

		DimensionManager.registerProviderType(world_dim_only_night_id, WorldOnlyNight.class, true);
		DimensionManager.registerDimension(world_dim_only_night_id, world_dim_only_night_id);
		  */
		Recipes_Mining.list();

	}

	public void init() {

	}

}
