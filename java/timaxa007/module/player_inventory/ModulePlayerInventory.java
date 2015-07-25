package timaxa007.module.player_inventory;

import java.io.File;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.NodeModule.ModuleNode;
import timaxa007.smt.util.UtilSMT;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
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

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModulePlayerInventory.MODNAME + ", build: " + ModulePlayerInventory.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/smt/module", ModulePlayerInventory.MODID + ".cfg"));
		cfg.load();

		cfg.save();
		
		upgrade_for_inventory = new ItemUpgradeForInventory("upgrade_for_inventory");
		UtilSMT.UtilItem.RegItem(upgrade_for_inventory);

	}

}
