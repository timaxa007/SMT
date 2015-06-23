package timaxa007.module.information;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.NodeModule.ModuleNode;
import timaxa007.smt.util.UtilSMT;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@ModuleNode(moduleTag = ModuleInformation.MODID, moduleName = ModuleInformation.MODNAME, moduleVersion = ModuleInformation.VERSION)
/**@author timaxa007**/
public class ModuleInformation implements IModuleClass {

	public static final String MODID = "information";
	public static final String MODNAME = "Information";
	public static final String VERSION = "0.002";

	public static Logger log;
	//public static SimpleNetworkWrapper network;

	public static Block block_information;
	public static Item item_information;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleInformation.MODNAME + ", build: " + ModuleInformation.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/smt/module", ModuleInformation.MODID + ".cfg"));
		cfg.load();

		cfg.save();

		//network = NetworkRegistry.INSTANCE.newSimpleChannel(ModuleInformation.MODID);
		//network.registerMessage(MessageStatusPlayer.Handler.class, MessageStatusPlayer.class, 0, Side.CLIENT);

		block_information = new BlockInformation("block_information");
		UtilSMT.UtilBlock.RegBlock(block_information);

		item_information = new ItemInformation("item_information");
		UtilSMT.UtilItem.RegItem(item_information);

	}

}
