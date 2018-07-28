package smt.module;

import smt.module.basic.ModuleLoader;

public class ListModules {

	public static final void init() {
		ModuleLoader.registerModule("smt.module.survivaltabs.ModuleSurvivalTabs");
		ModuleLoader.registerModule("smt.module.craft.ModuleCraft");
	}

}
