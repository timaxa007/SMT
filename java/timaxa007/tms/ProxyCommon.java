package timaxa007.tms;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ProxyCommon {

	public void preInit() {

	}

	public void init() {
		if (CoreTMS.debug) FMLLog.log(CoreTMS.MODID, Level.DEBUG, "Successful initialized common part.");
	}

}
