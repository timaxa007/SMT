package smt.pack.privacy;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import smt.pack.privacy.command.InventoryCommand;

@Mod(modid = SMTPrivacy.MODID, name = SMTPrivacy.NAME, version = SMTPrivacy.VERSION, useMetadata = true)
public final class SMTPrivacy {

	public static final String
	MODID = "smt_privacy",
	NAME = "SMT: Privacy",
	VERSION = "0.001";

	@Mod.Instance(MODID) public static SMTPrivacy instance;
	@Mod.Metadata(MODID) public static ModMetadata metadata;

	@cpw.mods.fml.common.SidedProxy(modId = MODID, serverSide = "smt.pack.privacy.Proxy", clientSide = "smt.pack.privacy.client.Proxy")
	public static Proxy proxy;

	public static final smt.pack.privacy.config.Config config = new smt.pack.privacy.config.Config();
	public static final smt.pack.privacy.block.Blocks block = new smt.pack.privacy.block.Blocks();
	public static final smt.pack.privacy.item.Items item = new smt.pack.privacy.item.Items();

	public static final CreativeTabs tabPrivacy = new CreativeTabs("tab_privacy") {
		@Override public net.minecraft.item.Item getTabIconItem() {return item.itemsPrivacy;}
	};

	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		metadata = metadata(event.getModMetadata());
		config.main(event.getModConfigurationDirectory());
		smt.pack.privacy.event.Events.init();
		block.init();
		item.init();
		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(cpw.mods.fml.common.event.FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
		proxy.init();
	}

	@Mod.EventHandler
	public void postInit(cpw.mods.fml.common.event.FMLPostInitializationEvent event) {
		smt.pack.privacy.recipes.ListRecipes.init();
		proxy.postInit();
	}

	@Mod.EventHandler
	public void serverStart(cpw.mods.fml.common.event.FMLServerStartingEvent event) {
		event.registerServerCommand(new InventoryCommand());
	}

	public ModMetadata metadata(ModMetadata metadata) {
		metadata.authorList = Lists.newArrayList("timaxa007");
		metadata.description = "SMT: Privacy.";
		metadata.logoFile = "/smt_privacy_logo.png";
		metadata.autogenerated = false;
		return metadata;
	}

}
