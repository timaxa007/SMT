package timaxa007.module.dfb;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import timaxa007.module.api.IModuleSMT;

public class ModuleDFB implements IModuleSMT {
	//-----------------------------------------------------------------------------------------------
	public static final String MODULE_TAG = "dfb";
	public static final String VERSION = "0.003";
	//-----------------------------------------------------------------------------------------------
	@Override
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(new File("./config/smt/module/", MODULE_TAG + ".cfg"));
		cfg.load();
		String catMain = "durability_for_block";

		int rsv_slot = cfg.get(catMain, "rsv_slot", 1, "Reserved slots.").getInt();

		for (int i = 0; i <= rsv_slot; ++i)
			DurabilityBlockHelper.add(cfg.get(catMain, "rsv_slot_" + i, "modid:block:16").getString());

		cfg.save();

	}
	//-----------------------------------------------------------------------------------------------
}
