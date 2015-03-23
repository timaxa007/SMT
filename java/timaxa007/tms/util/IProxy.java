package timaxa007.tms.util;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public interface IProxy {

	public void preInit(FMLPreInitializationEvent event);
	public void init();

}
