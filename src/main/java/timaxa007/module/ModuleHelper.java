package timaxa007.module;

import static timaxa007.core.CoreSMT.log;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;

import timaxa007.module.api.IModuleClientSMT;
import timaxa007.module.api.IModuleCommonSMT;
import timaxa007.module.api.IModuleSMT;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModuleHelper {
	//-----------------------------------------------------------------------------------------------
	public static List<JarFile> modules;
	private static List<IModuleSMT> modules_main = new ArrayList<IModuleSMT>();
	private static List<IModuleCommonSMT> modules_common = new ArrayList<IModuleCommonSMT>();
	//@SideOnly(Side.CLIENT)
	private static List<IModuleClientSMT> modules_client = new ArrayList<IModuleClientSMT>();
	//-----------------------------------------------------------------------------------------------
	/*
	public static void init() {
		find();
		load();
		end();
	}

	public static void find() {

		modules = new ArrayList<JarFile>();

		File dir = new File("./");
		System.out.println(dir.toString());

		for (File file : dir.listFiles()) {
			System.out.println(file.toString());
		}

		for (File file : dir.listFiles()) {
			System.out.println(file.toString());
		}

	}

	public static void load() {

	}

	public static void end() {

	}
	 */
	//-----------------------------------------------------------------------------------------------
	public static boolean addModuleMain(String path) {
		IModuleSMT im = checkModuleSMT(path);
		if (im != null) {modules_main.add(im);return true;}
		else {log.error("UnLoaded - " + path + ".");return false;}
	}

	public static boolean addModuleCommon(String path) {
		IModuleCommonSMT im = checkModuleCommonSMT(path);
		if (im != null) {modules_common.add(im);return true;}
		else {log.error("UnLoaded - " + path + ".");return false;}
	}

	@SideOnly(Side.CLIENT)
	public static boolean addModuleClient(String path) {
		IModuleClientSMT im = checkModuleClientSMT(path);
		if (im != null) {modules_client.add(im);return true;}
		else {log.error("UnLoaded - " + path + ".");return false;}
	}

	public static IModuleSMT checkModuleSMT(String path) {
		try {return (IModuleSMT)Class.forName(path).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	public static IModuleCommonSMT checkModuleCommonSMT(String path) {
		try {return (IModuleCommonSMT)Class.forName(path).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	//@SideOnly(Side.CLIENT)
	public static IModuleClientSMT checkModuleClientSMT(String path) {
		try {return (IModuleClientSMT)Class.forName(path).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}
	//-----------------------------------------------------------------------------------------------
	public static void loadedMain(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		if (modules_main != null && modules_main.size() > 0)
			for (IModuleSMT ip : modules_main) ip.preInit(event);
	}

	public static void loadedCommonPreInit() {
		if (modules_common != null && modules_common.size() > 0)
			for (IModuleCommonSMT ip : modules_common) ip.preInit();
	}

	public static void loadedCommonInit() {
		if (modules_common != null && modules_common.size() > 0)
			for (IModuleCommonSMT ip : modules_common) ip.init();
	}

	public static void loadedCommonPostInit() {
		if (modules_common != null && modules_common.size() > 0)
			for (IModuleCommonSMT ip : modules_common) ip.postInit();
	}

	//@SideOnly(Side.CLIENT)
	public static void loadedClientPreInit() {
		if (modules_client != null && modules_client.size() > 0)
			for (IModuleClientSMT ip : modules_client) ip.preInit();
	}

	//@SideOnly(Side.CLIENT)
	public static void loadedClientInit() {
		if (modules_client != null && modules_client.size() > 0)
			for (IModuleClientSMT ip : modules_client) ip.init();
	}

	//@SideOnly(Side.CLIENT)
	public static void loadedClientPostInit() {
		if (modules_client != null && modules_client.size() > 0)
			for (IModuleClientSMT ip : modules_client) ip.postInit();
	}
	//-----------------------------------------------------------------------------------------------
}
