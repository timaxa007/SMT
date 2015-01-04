package mods.timaxa007.tms;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ProxyCommon {

	public void preInitialize() {

	}

	public void initialize() {
		if (Core.debug) FMLLog.log(Core.MODID, Level.DEBUG, "Successful initialized common part.");
	}

}
