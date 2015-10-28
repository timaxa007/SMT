package timaxa007.module.craft_table;

import net.minecraftforge.common.MinecraftForge;

public class ProxyCommon implements timaxa007.module.api.IModuleCommonSMT {

	@Override
	public void preInit() {
		MinecraftForge.EVENT_BUS.register(new timaxa007.module.craft_table.event.EventCraftTable());
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

}
