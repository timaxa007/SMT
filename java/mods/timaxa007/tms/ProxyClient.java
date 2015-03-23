package mods.timaxa007.tms;

import mods.timaxa007.tms.event.EventActionArmorKey;
import mods.timaxa007.tms.event.EventActionMouse;
import mods.timaxa007.tms.event.EventActionPrimaryKey;
import mods.timaxa007.tms.event.EventActionSecondarKey;
import mods.timaxa007.tms.event.EventClientTMS;
import mods.timaxa007.tms.util.RegKey;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;

public class ProxyClient extends ProxyCommon {

	public void preInit() {
		super.preInit();

		RegKey.preInit();

	}

	@Override
	public void init() {
		super.init();

		if (Core.debug) FMLLog.log(Core.MODID, Level.DEBUG, "Successful initialized client part.");

		MinecraftForge.EVENT_BUS.register(new EventClientTMS());
		//MinecraftForge.EVENT_BUS.register(new EventMouse());
		FMLCommonHandler.instance().bus().register(new EventActionMouse());
		FMLCommonHandler.instance().bus().register(new EventActionPrimaryKey());
		FMLCommonHandler.instance().bus().register(new EventActionSecondarKey());
		FMLCommonHandler.instance().bus().register(new EventActionArmorKey());

	}

}
