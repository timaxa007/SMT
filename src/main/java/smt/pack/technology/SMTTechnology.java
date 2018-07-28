package smt.pack.technology;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import smt.pack.technology.api.SMTTechnologyItems;
import smt.pack.technology.registry.TelephoneCommunications;

@Mod(modid = SMTTechnology.MODID, name = SMTTechnology.NAME, version = SMTTechnology.VERSION, useMetadata = true)
public final class SMTTechnology {

	public static final String
	MODID = "smt_technology",
	NAME = "SMT: Technology",
	VERSION = "0.001";

	@Mod.Instance(MODID) public static SMTTechnology instance;
	@Mod.Metadata(MODID) public static ModMetadata metadata;

	@cpw.mods.fml.common.SidedProxy(modId = MODID, serverSide = "smt.pack.technology.Proxy", clientSide = "smt.pack.technology.client.Proxy")
	public static Proxy proxy;

	public static final smt.pack.technology.config.Config config = new smt.pack.technology.config.Config();
	public static final smt.pack.technology.block.Blocks block = new smt.pack.technology.block.Blocks();
	public static final smt.pack.technology.item.Items item = new smt.pack.technology.item.Items();
	public static final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

	public static final CreativeTabs tabTechnology = new CreativeTabs("tab_technology") {
		@Override public net.minecraft.item.Item getTabIconItem() {return item.itemsTechnology;}

		@SideOnly(Side.CLIENT)
		@Override
		public void displayAllReleventItems(java.util.List list) {
			if (!SMTTechnologyItems.hasItems()) {
				super.displayAllReleventItems(list);
				return;
			} else for (java.util.Map.Entry<String, net.minecraft.item.ItemStack> entry : SMTTechnologyItems.getMapItems().entrySet())
				list.add(entry.getValue());
		}
	};

	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		metadata = metadata(event.getModMetadata());
		config.main(event.getModConfigurationDirectory());
		smt.pack.technology.event.Events.init();
		block.init();
		item.init();
		smt.pack.technology.tile.TileEntites.init();
		smt.pack.technology.tile.machine.ListElectricMachines.init();
		smt.pack.technology.entity.Entites.init();
		smt.pack.technology.network.RegisterMessage.init(network);
		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(cpw.mods.fml.common.event.FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
		proxy.init();
	}

	@Mod.EventHandler
	public void postInit(cpw.mods.fml.common.event.FMLPostInitializationEvent event) {
		smt.pack.technology.recipes.ListRecipes.init();
		proxy.postInit();
	}

	@Mod.EventHandler
	public void serverStarting(cpw.mods.fml.common.event.FMLServerStartingEvent event) {
		TelephoneCommunications.INSTANCE.load();
	}

	@Mod.EventHandler
	public void serverStopping(cpw.mods.fml.common.event.FMLServerStoppingEvent event) {
		TelephoneCommunications.INSTANCE.save();
	}

	public ModMetadata metadata(ModMetadata metadata) {
		metadata.authorList = Lists.newArrayList("timaxa007");
		metadata.description = "SMT: Technology.";
		metadata.logoFile = "/smt_technology_logo.png";
		metadata.autogenerated = false;
		return metadata;
	}

}
