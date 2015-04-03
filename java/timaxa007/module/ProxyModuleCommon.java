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

		listModuleCommon();

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

	public static void listModuleCommon() {
		//------------------------------------------------------------------------------------
		if (NodeModule.isNodeControlButton) {
			try {
				String node_control_button = "timaxa007.module.control_button.ProxyCommon";
				Object o_control_button = Class.forName(node_control_button).newInstance();
				control_button = (IProxyModuleCommon)control_button;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodeModule.isNodeEnvironment) {
			try {
				String node_environment = "timaxa007.module.environment.ProxyCommon";
				Object o_environment = Class.forName(node_environment).newInstance();
				environment = (IProxyModuleCommon)environment;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodeModule.isNodeStatusPlayer) {
			try {
				String node_status_player = "timaxa007.module.status_player.ProxyCommon";
				Object o_status_player = Class.forName(node_status_player).newInstance();
				status_player = (IProxyModuleCommon)status_player;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodeModule.isNodeWeight) {
			try {
				String node_weight = "timaxa007.module.weight.ProxyCommon";
				Object o_weight = Class.forName(node_weight).newInstance();
				weight = (IProxyModuleCommon)weight;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodeModule.isNodeEffect) {
			try {
				String node_effects = "timaxa007.module.effect.ProxyCommon";
				Object o_effects = Class.forName(node_effects).newInstance();
				effects = (IProxyModuleCommon)o_effects;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodeModule.isNodeColors) {
			try {
				String node_colors = "timaxa007.module.effect.ProxyCommon";
				Object o_colors = Class.forName(node_colors).newInstance();
				colors = (IProxyModuleCommon)o_colors;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
	}

}
