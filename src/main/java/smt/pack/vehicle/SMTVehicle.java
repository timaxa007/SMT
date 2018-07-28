package smt.pack.vehicle;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = SMTVehicle.MODID, name = SMTVehicle.NAME, version = SMTVehicle.VERSION, useMetadata = true)
public final class SMTVehicle {

	public static final String
	MODID = "smt_vehicle",
	NAME = "SMT: Vehicle",
	VERSION = "0.001";

	@Mod.Instance(MODID) public static SMTVehicle instance;
	@Mod.Metadata(MODID) public static ModMetadata metadata;

	@cpw.mods.fml.common.SidedProxy(modId = MODID, serverSide = "smt.pack.vehicle.Proxy", clientSide = "smt.pack.vehicle.client.Proxy")
	public static Proxy proxy;

	public static final smt.pack.vehicle.config.Config config = new smt.pack.vehicle.config.Config();
	public static final smt.pack.vehicle.block.Blocks block = new smt.pack.vehicle.block.Blocks();
	public static final smt.pack.vehicle.item.Items item = new smt.pack.vehicle.item.Items();
	public static final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

	public static final CreativeTabs tabVehicle = new CreativeTabs("tab_vehicle") {
		@Override public net.minecraft.item.Item getTabIconItem() {return item.itemsVehicle;}
	};

	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		metadata = metadata(event.getModMetadata());
		config.main(event.getModConfigurationDirectory());
		smt.pack.vehicle.event.Events.init();
		block.init();
		item.init();
		smt.pack.vehicle.tile.TileEntites.init();
		smt.pack.vehicle.entity.Entites.init();

		//smt.pack.vehicle.packet.RegisterMessage.init(network);

		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(cpw.mods.fml.common.event.FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
		proxy.init();
	}

	@Mod.EventHandler
	public void postInit(cpw.mods.fml.common.event.FMLPostInitializationEvent event) {
		proxy.postInit();
	}

	public ModMetadata metadata(ModMetadata metadata) {
		metadata.authorList = Lists.newArrayList("timaxa007");
		metadata.description = "SMT: Vehicle.";
		metadata.logoFile = "/smt_vehicle_logo.png";
		metadata.autogenerated = false;
		return metadata;
	}

}