package timaxa007.pack.mining;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.mining.block.ListBlock;
import timaxa007.pack.mining.event.EventMining;
import timaxa007.pack.mining.item.ListItem;
import timaxa007.pack.mining.lib.ListMining;
import timaxa007.pack.mining.packet.RegisterMessage;
import timaxa007.pack.mining.recipe.Recipes_Mining;
import timaxa007.pack.mining.render.RenderMain;
import timaxa007.pack.mining.world.Generator_Mining;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;

public class PackMining implements IPackClass {

	public static final String MODID = "miningpack";
	public static final String MODNAME = "PackMining";
	public static final String VERSION = "0.1a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	public static BiomeGenBase biome_test;
	public static BiomeGenBase biome_hot;

	public static int world_dim_mining_id;
	public static int world_dim_only_day_id;
	public static int world_dim_only_night_id;

	public static CreativeTabs tab_mining = new CreativeTabs("tab_mining") {
		public Item getTabIconItem() {
			return PackMining.item.items_for_mining;
		}
	};
	public static CreativeTabs tab_tools = new CreativeTabs("tab_tools") {
		public Item getTabIconItem() {
			return PackMining.item.items_for_mining;
		}
	};

	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackMining.MODNAME + ".");

		Configuration cfg = new Configuration(new File("./config/tms/pack", PackMining.MODID + ".cfg"));
		cfg.load();

		world_dim_mining_id = cfg.get("world", "dimension_mining_id", 30).getInt();
		world_dim_only_day_id = cfg.get("world", "dimension_only_day_id", 31).getInt();
		world_dim_only_night_id = cfg.get("world", "dimension_only_night_id", 32).getInt();

		block.ore_rock_ores_be = cfg.get("block", "ore_rock_ores", true).getBoolean(true);
		block.ore_nether_ores_be = cfg.get("block", "ore_nether_ores", true).getBoolean(true);
		block.ore_ender_ores_be = cfg.get("block", "ore_ender_ores", true).getBoolean(true);
		block.cristals_be = cfg.get("block", "cristals", true).getBoolean(true);

		item.items_for_mining_be = cfg.get("item", "items_for_mining", true).getBoolean(true);

		cfg.save();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackMining.MODID);
		RegisterMessage.init(network);

		new ListMining();

		block.preInit();
		item.preInit();

		//OreDictionary.registerOre("ignotCopper", new ItemStack(itemMetals, 1, 64));

		//ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(itemMetals, 1, 64), 10, 70, 2));

		GameRegistry.registerWorldGenerator(new Generator_Mining(), 0);
		/*
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

		MinecraftForge.EVENT_BUS.register(new EventMining());

	}

}
