package timaxa007.module;

import timaxa007.module.api.IProxyModuleCommon;

public class ProxyModuleCommon {

	public static IProxyModuleCommon 
	control_button,
	environment,
	status_player,
	weight,
	effects,
	colors;

	public void preInit() {

		verificationModuleCommon();

		if (control_button != null) control_button.preInit();
		if (environment != null) environment.preInit();
		if (status_player != null) status_player.preInit();
		if (weight != null) weight.preInit();
		if (effects != null) effects.preInit();
		if (colors != null) colors.preInit();

	}

	public void init() {

		if (control_button != null) control_button.init();
		if (environment != null) environment.init();
		if (status_player != null) status_player.init();
		if (weight != null) weight.init();
		if (effects != null) effects.init();
		if (colors != null) colors.init();

	}

	public void postInit() {

		if (control_button != null) control_button.postInit();
		if (environment != null) environment.postInit();
		if (status_player != null) status_player.postInit();
		if (weight != null) weight.postInit();
		if (effects != null) effects.postInit();
		if (colors != null) colors.postInit();

	}

	public static void verificationModuleCommon() {

		if (NodeModule.isNodeControlButton)
			control_button = checkModuleCommon(NodeModule.PATH + ".control_button.ProxyCommon");

		if (NodeModule.isNodeEnvironment)
			environment = checkModuleCommon(NodeModule.PATH + ".environment.ProxyCommon");

		if (NodeModule.isNodeStatusPlayer)
			status_player = checkModuleCommon(NodeModule.PATH + ".status_player.ProxyCommon");

		if (NodeModule.isNodeWeight)
			weight = checkModuleCommon(NodeModule.PATH + ".weight.ProxyCommon");

		if (NodeModule.isNodeEffect)
			effects = checkModuleCommon(NodeModule.PATH + ".effect.ProxyCommon");

		if (NodeModule.isNodeColors)
			colors = checkModuleCommon(NodeModule.PATH + ".colors.ProxyCommon");

	}

	public static IProxyModuleCommon checkModuleCommon(String node) {
		try {return (IProxyModuleCommon)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}
