package mods.timaxa007.tms;

import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class ProxyClient extends ProxyServer {

    @Override
    public void initialize() {
        super.initialize();
        if(Core.debug) FMLLog.log(Core.MODID, Level.DEBUG, "Successful initialized client part.");
    }
}
