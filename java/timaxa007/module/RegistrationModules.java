package timaxa007.module;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RegistrationModules {

	public static boolean
	isModuleColors,
	isModuleCraftTable,
	isModuleDurabilityBlock
	;

	public static boolean
	disableModuleColors,
	disableModuleCraftTable,
	disableModuleDurabilityBlock
	;

	public static void verificationMain() {
		if (!disableModuleColors) isModuleColors = ModuleHelper.addModuleMain("timaxa007.module.colors.ModuleColors");
		if (!disableModuleCraftTable) isModuleCraftTable = ModuleHelper.addModuleMain("timaxa007.module.craft_table.ModuleCraftTable");
		if (!disableModuleDurabilityBlock) isModuleDurabilityBlock = ModuleHelper.addModuleMain("timaxa007.module.dfb.ModuleDFB");
	}

	public static void verificationCommon() {
		if (isModuleColors) ModuleHelper.addModuleCommon("timaxa007.module.colors.ProxyCommon");
		if (isModuleCraftTable) ModuleHelper.addModuleCommon("timaxa007.module.craft_table.ProxyCommon");
		if (isModuleDurabilityBlock) ModuleHelper.addModuleCommon("timaxa007.module.dfb.ProxyCommon");
	}

	@SideOnly(Side.CLIENT)
	public static void verificationClient() {
		if (isModuleColors) ModuleHelper.addModuleClient("timaxa007.module.colors.ProxyClient");
		if (isModuleCraftTable) ModuleHelper.addModuleClient("timaxa007.module.craft_table.ProxyClient");
		if (isModuleDurabilityBlock) ModuleHelper.addModuleClient("timaxa007.module.dfb.ProxyClient");
	}

}
