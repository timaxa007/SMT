package timaxa007.module;

import timaxa007.module.api.IProxyModuleClient;

public class ProxyModuleClient extends ProxyModuleCommon {

	public static IProxyModuleClient 
	control_button,
	environment,
	status_player,
	weight,
	effects,
	colors;

	@Override
	public void preInit() {
		super.preInit();

		verificationModuleClient();

		if (control_button != null) control_button.preInit();
		if (environment != null) environment.preInit();
		if (status_player != null) status_player.preInit();
		if (weight != null) weight.preInit();
		if (effects != null) effects.preInit();
		if (colors != null) colors.preInit();

	}

	@Override
	public void init() {
		super.init();

		if (control_button != null) control_button.init();
		if (environment != null) environment.init();
		if (status_player != null) status_player.init();
		if (weight != null) weight.init();
		if (effects != null) effects.init();
		if (colors != null) colors.init();

	}

	@Override
	public void postInit() {
		super.postInit();

		if (control_button != null) control_button.postInit();
		if (environment != null) environment.postInit();
		if (status_player != null) status_player.postInit();
		if (weight != null) weight.postInit();
		if (effects != null) effects.postInit();
		if (colors != null) colors.postInit();

	}

	public static void verificationModuleClient() {

		if (NodeModule.isNodeControlButton)
			control_button = checkModuleClient(NodeModule.PATH + ".control_button.ProxyClient");

		if (NodeModule.isNodeEnvironment)
			environment = checkModuleClient(NodeModule.PATH + ".environment.ProxyClient");

		if (NodeModule.isNodeStatusPlayer)
			status_player = checkModuleClient(NodeModule.PATH + ".status_player.ProxyClient");

		if (NodeModule.isNodeWeight)
			weight = checkModuleClient(NodeModule.PATH + ".weight.ProxyClient");

		if (NodeModule.isNodeEffect)
			effects = checkModuleClient(NodeModule.PATH + ".effect.ProxyClient");

		if (NodeModule.isNodeColors)
			colors = checkModuleClient(NodeModule.PATH + ".colors.ProxyClient");

	}

	public static IProxyModuleClient checkModuleClient(String node) {
		try {return (IProxyModuleClient)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}
