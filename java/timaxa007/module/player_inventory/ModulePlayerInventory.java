package timaxa007.module.player_inventory;

import java.io.File;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.NodeModule.ModuleNode;
import timaxa007.module.player_inventory.packet.RegisterMessage;
import timaxa007.smt.util.UtilSMT;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@ModuleNode(moduleTag = ModulePlayerInventory.MODID, moduleName = ModulePlayerInventory.MODNAME, moduleVersion = ModulePlayerInventory.VERSION)
/**@author timaxa007**/
public class ModulePlayerInventory implements IModuleClass {

	public static final String MODID = "player_inventory";
	public static final String MODNAME = "PlayerInventory";
	public static final String VERSION = "0.001";

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static Item upgrade_for_inventory;

	public static String mode_inventory;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModulePlayerInventory.MODNAME + ", build: " + ModulePlayerInventory.VERSION + ".");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(ModulePlayerInventory.MODID);
		RegisterMessage.init(network);

		Configuration cfg = new Configuration(new File("./config/smt/module", ModulePlayerInventory.MODID + ".cfg"));
		cfg.load();
		mode_inventory = cfg.get("main", "mode_inventory", "default").getString();
		cfg.save();

		upgrade_for_inventory = new ItemUpgradeForInventory("upgrade_for_inventory");
		UtilSMT.UtilItem.RegItem(upgrade_for_inventory);

	}

	public static enum modeInventory {
		DEFAULT,
		STYLE1,
		NONE;
	}

	public static modeInventory getModeInventory() {
		mode_inventory.toLowerCase();
		if (mode_inventory.equals("default")) return modeInventory.DEFAULT;
		if (mode_inventory.equals("style1")) return modeInventory.STYLE1;
		else return modeInventory.NONE;
	}
}
