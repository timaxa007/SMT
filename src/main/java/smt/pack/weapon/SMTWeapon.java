package smt.pack.weapon;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import smt.pack.weapon.event.Events;

@Mod(modid = SMTWeapon.MODID, name = SMTWeapon.NAME, version = SMTWeapon.VERSION, useMetadata = true)
public final class SMTWeapon {

	public static final String
	MODID = "smt_weapon",
	NAME = "SMT: Weapon",
	VERSION = "0.001";

	@Mod.Instance(MODID) public static SMTWeapon instance;
	@Mod.Metadata(MODID) public static ModMetadata metadata;

	@cpw.mods.fml.common.SidedProxy(modId = MODID, serverSide = "smt.pack.weapon.Proxy", clientSide = "smt.pack.weapon.client.Proxy")
	public static Proxy proxy;

	public static final smt.pack.weapon.config.Config config = new smt.pack.weapon.config.Config();
	public static final smt.pack.weapon.block.Blocks block = new smt.pack.weapon.block.Blocks();
	public static final smt.pack.weapon.item.Items item = new smt.pack.weapon.item.Items();
	public static final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

	public static final CreativeTabs tabWeapon = new CreativeTabs("tab_weapon") {
		@Override public net.minecraft.item.Item getTabIconItem() {return item.itemsWeapon;}
	};

	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		metadata = metadata(event.getModMetadata());
		config.main(event.getModConfigurationDirectory());
		block.init();
		item.init();
		smt.pack.weapon.tile.TileEntites.init();
		smt.pack.weapon.entity.Entites.init();
		smt.pack.weapon.network.RegisterMessage.init(network);
		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(cpw.mods.fml.common.event.FMLInitializationEvent event) {
		//NetworkRegistry.INSTANCE.registerGuiHandler(instance, new smt.pack.weapon.gui.HandlerGui());
		Events.init();
		proxy.init();
	}

	@Mod.EventHandler
	public void postInit(cpw.mods.fml.common.event.FMLPostInitializationEvent event) {
		//smt.pack.weapon.recipes.ListRecipes.init();
		proxy.postInit();
	}

	public ModMetadata metadata(ModMetadata metadata) {
		metadata.authorList = Lists.newArrayList("timaxa007");
		metadata.description = "SMT: Weapon.";
		metadata.logoFile = "/smt_weapon_logo.png";
		metadata.autogenerated = false;
		return metadata;
	}

}