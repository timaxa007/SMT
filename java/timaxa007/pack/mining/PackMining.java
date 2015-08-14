package timaxa007.pack.mining;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.NodePack.PackNode;
import timaxa007.pack.mining.block.ListBlock;
import timaxa007.pack.mining.config.ConfigMining;
import timaxa007.pack.mining.item.ListItem;
import timaxa007.pack.mining.lib.ListMining;
import timaxa007.pack.mining.packet.RegisterMessage;
import timaxa007.pack.mining.recipe.Recipes_Mining;
import timaxa007.pack.mining.render.RenderMain;
import timaxa007.pack.mining.world.Generator_Mining;
import timaxa007.pack.mining.world.WorldSMT;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@PackNode(moduleTag = PackMining.MODID, moduleName = PackMining.MODNAME, moduleVersion = PackMining.VERSION)
/**@author timaxa007**/
public class PackMining implements IPackClass {

	public static final String MODID = "miningpack";
	public static final String MODNAME = "PackMining";
	public static final String VERSION = "0.228";

	public static final ConfigMining config = new ConfigMining();
	public static final ListBlock block = new ListBlock();
	public static final ListItem item = new ListItem();
	public static final RenderMain render = new RenderMain();
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static BiomeGenBase biome_test;
	public static BiomeGenBase biome_hot;

	public static final CreativeTabs tab_mining = new CreativeTabs("tab_mining") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackMining.item.items_for_mining;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackMining.MODNAME + ", build: " + PackMining.VERSION + ".");

		config.main();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackMining.MODID);
		RegisterMessage.init(network);

		new WorldSMT();
		new ListMining();

		block.preInit();
		item.preInit();

		Recipes_Mining.list();

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


	}

}
