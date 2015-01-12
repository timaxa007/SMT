package mods.timaxa007.pack.mining;

import mods.timaxa007.pack.mining.block.BlockList;
import mods.timaxa007.pack.mining.event.EventMining;
import mods.timaxa007.pack.mining.item.ItemList;
import mods.timaxa007.pack.mining.lib.ListMining;
import mods.timaxa007.pack.mining.recipe.Recipes_Mining;
import mods.timaxa007.pack.mining.render.RenderMain;
import mods.timaxa007.pack.mining.world.Generator_Mining;
import mods.timaxa007.tms.util.IProxy;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyCommon implements IProxy {

	public static BlockList block;
	public static ItemList item;
	public static RenderMain render;

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

		block.preInit();
		item.preInit();
		render.preInit();

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

	public void init() {

	}

}
