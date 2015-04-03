package timaxa007.pack.magic;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.pack.api.IProxyPackCommon;
import timaxa007.pack.magic.event.EventMana;
import timaxa007.pack.magic.lib.Spells;
import timaxa007.pack.magic.render.RenderMain;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyCommon implements IProxyPackCommon {

	@Override
	public void preInit() {

		RenderMain.preInit();

	}

	@Override
	public void init() {

		MinecraftForge.EVENT_BUS.register(new Spells.EventSpellsCommon());
		FMLCommonHandler.instance().bus().register(new EventMana.Server());

	}

	@Override
	public void postInit() {

	}

}
