package smt.pack.clan;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.network.NetworkRegistry;



@Mod(modid = SMTClan.MODID, name = SMTClan.NAME, version = SMTClan.VERSION, useMetadata = true)
public final class SMTClan {

	public static final String
	MODID = "smt_clan",
	NAME = "SMT: Clan",
	VERSION = "0.001";

	@Mod.Instance(MODID) public static SMTClan instance;

	//@cpw.mods.fml.common.SidedProxy(modId = MODID, serverSide = "smt.pack.clan.", clientSide = "smt.pack.clan.client.Proxy")
	//public static proxy;
	//public static final Clan clan = new Clan();
	//public static smt.pack.clan.config.Config config;
	//public static smt.pack.clan.block.ListBlocks block;
	//public static smt.pack.clan.item.ListItems item;
	public static final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
	/*
	public static final CreativeTabs tabCommon = new CreativeTabs("tab_common") {
		@Override public net.minecraft.item.Item getTabIconItem() {return item.itemsCommon;}
	};
	 */
	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		applyMetadata(event.getModMetadata());
		//config.main(event.getModConfigurationDirectory());
		//block.init();
		//item.init();
		//smt.pack.clan.tile.ListTileEntites.init();
		//Entites.init();
		smt.pack.clan.packet.RegisterMessage.init(network);

		//ListEvent.preInit();
		//proxy.preInit();
	}

	@Mod.EventHandler
	public void init(cpw.mods.fml.common.event.FMLInitializationEvent event) {
		//clan.init();
		//Events.init();
		//NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
		//proxy.init();
	}

	@Mod.EventHandler
	public void postInit(cpw.mods.fml.common.event.FMLPostInitializationEvent event) {
		//ListEvent.postInit();
		//proxy.postInit();
	}

	@Mod.EventHandler
	public void serverStarting(cpw.mods.fml.common.event.FMLServerStartingEvent event) {
		System.out.println(" ------- FMLServerStartingEvent");
		event.registerServerCommand(new ClanCommand());
		event.registerServerCommand(new PrivateMessageCommand());
		//if (!Clan.INSTANCE.isLoaded)
		//Clan.INSTANCE.load();
		//Clan2.INSTANCE.load();
		//Clan3.INSTANCE.load();
		PrivateMessage.INSTANCE.load();
	}

	@Mod.EventHandler
	public void serverStarted(cpw.mods.fml.common.event.FMLServerStartedEvent event) {
		System.out.println(" ------- FMLServerStartedEvent");
	}

	@Mod.EventHandler
	public void serverStopping(cpw.mods.fml.common.event.FMLServerStoppingEvent event) {
		System.out.println(" ------- FMLServerStoppingEvent");
		//if (Clan.INSTANCE.isLoaded)
		//Clan.INSTANCE.save();
		//Clan2.INSTANCE.save();
		//Clan3.INSTANCE.save();
		PrivateMessage.INSTANCE.save();
	}

	@Mod.EventHandler
	public void serverStopped(cpw.mods.fml.common.event.FMLServerStoppedEvent event) {
		System.out.println(" ------- FMLServerStoppedEvent");
	}

	public void applyMetadata(ModMetadata meta) {
		meta.authorList = Lists.newArrayList("timaxa007");
		meta.description = "SMT: Clan.";
		meta.logoFile = "/smt_clan_logo.png";
		meta.autogenerated = false;
	}

}
