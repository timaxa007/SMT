package timaxa007.module.texture_map;

import timaxa007.api.IProxyModuleCommon;
import timaxa007.module.texture_map.util.TextureMap;

public class ProxyCommon implements IProxyModuleCommon {

	public void preInit() {

	}

	public void init() {

		TextureMap.init();

	}

	public void postInit() {
		
	}

}
