package timaxa007.module;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RegistrationModules {

	public static boolean
	isModuleColors,
	isModuleSubstance,
	isModuleCraftTable,
	isModuleDurabilityBlock
	;

	public static boolean
	disableModuleColors,
	disableModuleSubstance,
	disableModuleCraftTable,
	disableModuleDurabilityBlock
	;

	public static void verificationMain() {
		if (!disableModuleColors) isModuleColors = ModuleHelper.addModuleMain("timaxa007.module.colors.ModuleColors");
		if (!disableModuleSubstance) isModuleSubstance = ModuleHelper.addModuleMain("timaxa007.module.substance.ModuleSubstance");
		if (!disableModuleCraftTable) isModuleCraftTable = ModuleHelper.addModuleMain("timaxa007.module.craft_table.ModuleCraftTable");
		if (!disableModuleDurabilityBlock) isModuleDurabilityBlock = ModuleHelper.addModuleMain("timaxa007.module.dfb.ModuleDFB");
	}

	public static void verificationCommon() {
		if (isModuleColors) ModuleHelper.addModuleCommon("timaxa007.module.colors.ProxyCommon");
		if (isModuleSubstance) ModuleHelper.addModuleCommon("timaxa007.module.substance.ProxyCommon");
		if (isModuleCraftTable) ModuleHelper.addModuleCommon("timaxa007.module.craft_table.ProxyCommon");
		if (isModuleDurabilityBlock) ModuleHelper.addModuleCommon("timaxa007.module.dfb.ProxyCommon");
	}

	@SideOnly(Side.CLIENT)
	public static void verificationClient() {
		if (isModuleColors) ModuleHelper.addModuleClient("timaxa007.module.colors.ProxyClient");
		if (isModuleSubstance) ModuleHelper.addModuleClient("timaxa007.module.substance.ProxyClient");
		if (isModuleCraftTable) ModuleHelper.addModuleClient("timaxa007.module.craft_table.ProxyClient");
		if (isModuleDurabilityBlock) ModuleHelper.addModuleClient("timaxa007.module.dfb.ProxyClient");
	}

}
