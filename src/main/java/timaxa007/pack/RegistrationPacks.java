package timaxa007.pack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RegistrationPacks {

	public static boolean
	isPackCommon,
	isPackDecorative,
	isPackPlayer,
	isPackCookery,
	isPackGeology,
	isPackMedicine,
	isPackMeteorology,
	isPackPhytology,
	isPackTechnology,
	isPackTheurgy,
	isPackZoology
	;

	public static boolean
	disablePackCommon,
	disablePackDecorative,
	disablePackPlayer,
	disablePackCookery,
	disablePackGeology,
	disablePackMedicine,
	disablePackMeteorology,
	disablePackPhytology,
	disablePackTechnology,
	disablePackTheurgy,
	disablePackZoology
	;

	public static void verificationMain() {
		if (!disablePackCommon) isPackCommon = PackHelper.addPackMain("timaxa007.pack.common.PackCommon");
		if (!disablePackDecorative) isPackCommon = PackHelper.addPackMain("timaxa007.pack.decorative.PackDecorative");
		if (!disablePackPlayer) isPackPlayer = PackHelper.addPackMain("timaxa007.pack.player.PackPlayer");
		if (!disablePackCookery) isPackCookery = PackHelper.addPackMain("timaxa007.pack.cookery.PackCookery");
		if (!disablePackGeology) isPackGeology = PackHelper.addPackMain("timaxa007.pack.geology.PackGeology");
		if (!disablePackMedicine) isPackMedicine = PackHelper.addPackMain("timaxa007.pack.medicine.PackMedicine");
		if (!disablePackMeteorology) isPackMeteorology = PackHelper.addPackMain("timaxa007.pack.meteorology.PackMeteorology");
		if (!disablePackPhytology) isPackPhytology = PackHelper.addPackMain("timaxa007.pack.phytology.PackPhytology");
		if (!disablePackTechnology) isPackTechnology = PackHelper.addPackMain("timaxa007.pack.technology.PackTechnology");
		if (!disablePackTheurgy) isPackTheurgy = PackHelper.addPackMain("timaxa007.pack.theurgy.PackTheurgy");
		if (!disablePackZoology) isPackZoology = PackHelper.addPackMain("timaxa007.pack.zoology.PackZoology");
	}

	public static void verificationCommon() {
		if (isPackCommon) PackHelper.addPackCommon("timaxa007.pack.common.ProxyCommon");
		if (isPackDecorative) PackHelper.addPackCommon("timaxa007.pack.decorative.ProxyCommon");
		if (isPackPlayer) PackHelper.addPackCommon("timaxa007.pack.player.ProxyCommon");
		if (isPackCookery) PackHelper.addPackCommon("timaxa007.pack.cookery.ProxyCommon");
		if (isPackGeology) PackHelper.addPackCommon("timaxa007.pack.geology.ProxyCommon");
		if (isPackMedicine) PackHelper.addPackCommon("timaxa007.pack.medicine.ProxyCommon");
		if (isPackMeteorology) PackHelper.addPackCommon("timaxa007.pack.meteorology.ProxyCommon");
		if (isPackPhytology) PackHelper.addPackCommon("timaxa007.pack.phytology.ProxyCommon");
		if (isPackTechnology) PackHelper.addPackCommon("timaxa007.pack.technology.ProxyCommon");
		if (isPackTheurgy) PackHelper.addPackCommon("timaxa007.pack.theurgy.ProxyCommon");
		if (isPackZoology) PackHelper.addPackCommon("timaxa007.pack.zoology.ProxyCommon");
	}

	@SideOnly(Side.CLIENT)
	public static void verificationClient() {
		if (isPackCommon) PackHelper.addPackClient("timaxa007.pack.common.ProxyClient");
		if (isPackDecorative) PackHelper.addPackClient("timaxa007.pack.decorative.ProxyClient");
		if (isPackPlayer) PackHelper.addPackClient("timaxa007.pack.player.ProxyClient");
		if (isPackCookery) PackHelper.addPackClient("timaxa007.pack.cookery.ProxyClient");
		if (isPackGeology) PackHelper.addPackClient("timaxa007.pack.geology.ProxyClient");
		if (isPackMedicine) PackHelper.addPackClient("timaxa007.pack.medicine.ProxyClient");
		if (isPackMeteorology) PackHelper.addPackClient("timaxa007.pack.meteorology.ProxyClient");
		if (isPackPhytology) PackHelper.addPackClient("timaxa007.pack.phytology.ProxyClient");
		if (isPackTechnology) PackHelper.addPackClient("timaxa007.pack.technology.ProxyClient");
		if (isPackTheurgy) PackHelper.addPackClient("timaxa007.pack.theurgy.ProxyClient");
		if (isPackZoology) PackHelper.addPackClient("timaxa007.pack.zoology.ProxyClient");
	}

}
