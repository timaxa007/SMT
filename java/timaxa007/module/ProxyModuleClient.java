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

	public void preInit() {
		super.preInit();

		listModuleClient();

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

	public void postInit() {
		super.postInit();

		if (control_button != null) control_button.postInit();
		if (environment != null) environment.postInit();
		if (status_player != null) status_player.postInit();
		if (weight != null) weight.postInit();
		if (effects != null) effects.postInit();
		if (colors != null) colors.postInit();

	}

	public static void listModuleClient() {
		//------------------------------------------------------------------------------------
		if (CoreModule.isNodeControlButton) {
			try {
				String node_control_button = "timaxa007.module.control_button.ProxyClient";
				Object o_control_button = Class.forName(node_control_button).newInstance();
				control_button = (IProxyModuleClient)o_control_button;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (CoreModule.isNodeEnvironment) {
			try {
				String node_environment = "timaxa007.module.environment.ProxyClient";
				Object o_environment = Class.forName(node_environment).newInstance();
				environment = (IProxyModuleClient)o_environment;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (CoreModule.isNodeStatusPlayer) {
			try {
				String node_status_player = "timaxa007.module.status_player.ProxyClient";
				Object o_status_player = Class.forName(node_status_player).newInstance();
				status_player = (IProxyModuleClient)o_status_player;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (CoreModule.isNodeWeight) {
			try {
				String node_weight = "timaxa007.module.weight.ProxyClient";
				Object o_weight = Class.forName(node_weight).newInstance();
				weight = (IProxyModuleClient)o_weight;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (CoreModule.isNodeEffect) {
			try {
				String node_effects = "timaxa007.module.effect.ProxyClient";
				Object o_effects = Class.forName(node_effects).newInstance();
				effects = (IProxyModuleClient)o_effects;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (CoreModule.isNodeColors) {
			try {
				String node_colors = "timaxa007.module.effect.ProxyClient";
				Object o_colors = Class.forName(node_colors).newInstance();
				colors = (IProxyModuleClient)o_colors;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
	}

}
