package timaxa007.module.weight;

import java.io.File;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.weight.util.ItemUpgradeWeight;
import timaxa007.module.weight.util.MessageWeight;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

public class ModuleWeight implements IModuleClass {

	public static final String MODID = "weight";
	public static final String MODNAME = "SystemWeight";
	public static final String VERSION = "0.013";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static Item upgradeWeight;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleWeight.MODNAME + ", build: " + ModuleWeight.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/tms/module", ModuleWeight.MODID + ".cfg"));
		cfg.load();

		cfg.save();

		upgradeWeight = new ItemUpgradeWeight();
		GameRegistry.registerItem(upgradeWeight, "ItemUpgradeWeight");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(ModuleWeight.MODID);
		network.registerMessage(MessageWeight.Handler.class, MessageWeight.class, 0, Side.CLIENT);

	}

}
