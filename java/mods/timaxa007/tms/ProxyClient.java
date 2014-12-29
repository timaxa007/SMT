package mods.timaxa007.tms;

import mods.timaxa007.tms.util.EventClientTMS;
import mods.timaxa007.tms.util.EventKey;
import mods.timaxa007.tms.util.EventTick;
import mods.timaxa007.tms.util.RegKey;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;

public class ProxyClient extends ProxyServer {

	public void preInitialize() {
		super.preInitialize();

		RegKey.preInt();

		MinecraftForge.EVENT_BUS.register(new EventClientTMS());
		FMLCommonHandler.instance().bus().register(new EventKey());
		FMLCommonHandler.instance().bus().register(new EventTick());
	}

	@Override
	public void initialize() {
		super.initialize();

		if (Core.debug) FMLLog.log(Core.MODID, Level.DEBUG, "Successful initialized client part.");

	}

}
