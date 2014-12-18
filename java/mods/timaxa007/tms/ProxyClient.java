package mods.timaxa007.tms;

import org.apache.logging.log4j.Level;
import cpw.mods.fml.common.FMLLog;

public class ProxyClient extends ProxyServer {

	@Override
	public void initialize() {
		super.initialize();
		if (Core.debug) FMLLog.log(Core.MODID, Level.DEBUG, "Successful initialized client part.");
	}

}
