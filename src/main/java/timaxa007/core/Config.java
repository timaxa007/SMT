package timaxa007.core;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import timaxa007.module.RegistrationModules;
import timaxa007.pack.RegistrationPacks;

public class Config {

	public static boolean isModulesLoading = false;
	public static boolean isPacksLoading = false;

	public static void main() {
		Configuration cfg = new Configuration(new File("./config/smt/" + CoreSMT.MODID, "main.cfg"));
		cfg.load();
		String catMain = "main";
		isModulesLoading = cfg.get(catMain, "isModulesLoading", true, "Loading Modules?").getBoolean();
		isPacksLoading = cfg.get(catMain, "isPacksLoading", true, "Loading Packs?").getBoolean();
		cfg.save();
	}

	public static void module() {
		Configuration cfg = new Configuration(new File("./config/smt/module/", "main.cfg"));
		cfg.load();
		String catModule = "module";
		RegistrationModules.disableModuleColors = cfg.get(catModule, "disableModuleColors", false, "Disable Module Colors?").getBoolean();
		RegistrationModules.disableModuleSubstance = cfg.get(catModule, "disableModuleSubstance", false, "Disable Module Substance?").getBoolean();
		RegistrationModules.disableModuleCraftTable = cfg.get(catModule, "disableModuleCraftTable", false, "Disable Module CraftTable?").getBoolean();
		RegistrationModules.disableModuleDurabilityBlock = cfg.get(catModule, "disableModuleDurabilityBlock", false, "Disable Module DurabilityBlock?").getBoolean();
		cfg.save();
	}

	public static void pack() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/", "main.cfg"));
		cfg.load();
		String catPack = "pack";
		RegistrationPacks.disablePackCommon = cfg.get(catPack, "disablePackCommon", false, "Disable Pack Common?").getBoolean();
		RegistrationPacks.disablePackDecorative = cfg.get(catPack, "disablePackDecorative", false, "Disable Pack Decorative?").getBoolean();
		RegistrationPacks.disablePackPlayer = cfg.get(catPack, "disablePackPlayer", false, "Disable Pack Player?").getBoolean();
		RegistrationPacks.disablePackCookery = cfg.get(catPack, "disablePackCookery", false, "Disable Pack Cookery?").getBoolean();
		RegistrationPacks.disablePackGeology = cfg.get(catPack, "disablePackGeology", false, "Disable Pack Geology?").getBoolean();
		RegistrationPacks.disablePackMedicine = cfg.get(catPack, "disablePackMedicine", false, "Disable Pack Medicine?").getBoolean();
		RegistrationPacks.disablePackMeteorology = cfg.get(catPack, "disablePackMeteorology", false, "Disable Pack Meteorology?").getBoolean();
		RegistrationPacks.disablePackPhytology = cfg.get(catPack, "disablePackPhytology", false, "Disable Pack Phytology?").getBoolean();
		RegistrationPacks.disablePackTechnology = cfg.get(catPack, "disablePackTechnology", false, "Disable Pack Technology?").getBoolean();
		RegistrationPacks.disablePackTheurgy = cfg.get(catPack, "disablePackTheurgy", false, "Disable Pack Theurgy?").getBoolean();
		RegistrationPacks.disablePackZoology = cfg.get(catPack, "disablePackZoology", false, "Disable Pack Zoology?").getBoolean();
		cfg.save();
	}

}
