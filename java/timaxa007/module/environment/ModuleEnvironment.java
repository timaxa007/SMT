package timaxa007.module.environment;

import java.io.File;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.environment.util.ItemEnvironment;
import timaxa007.module.environment.util.MessageEnvironment;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

/**@author timaxa007**/
public class ModuleEnvironment implements IModuleClass {

	public static final String MODID = "environment";
	public static final String MODNAME = "Environment";
	public static final String VERSION = "0.006";

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static Item upgradeWeight;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleEnvironment.MODNAME + ", build: " + ModuleEnvironment.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/SMT/module", ModuleEnvironment.MODID + ".cfg"));
		cfg.load();

		cfg.save();

		upgradeWeight = new ItemEnvironment();
		GameRegistry.registerItem(upgradeWeight, "ItemEnvironment");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(ModuleEnvironment.MODID);
		network.registerMessage(MessageEnvironment.Handler.class, MessageEnvironment.class, 0, Side.CLIENT);

	}

}
