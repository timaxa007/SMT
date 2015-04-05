package timaxa007.module.status_player;

import java.io.File;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.module.api.IModuleClass;
import timaxa007.module.status_player.util.ItemStatusPlayer;
import timaxa007.module.status_player.util.MessageStatusPlayer;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

public class ModuleStatusPlayer implements IModuleClass {

	public static final String MODID = "status_player";
	public static final String MODNAME = "StatusPlayer";
	public static final String VERSION = "0.2a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static Item upgradeWeight;

	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleStatusPlayer.MODNAME + ", version: " + ModuleStatusPlayer.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/tms/module", ModuleStatusPlayer.MODID + ".cfg"));
		cfg.load();

		cfg.save();

		upgradeWeight = new ItemStatusPlayer();
		GameRegistry.registerItem(upgradeWeight, "ItemStatusPlayer");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(ModuleStatusPlayer.MODID);
		network.registerMessage(MessageStatusPlayer.Handler.class, MessageStatusPlayer.class, 0, Side.CLIENT);

	}

}
