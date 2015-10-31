package timaxa007.pack;

import static timaxa007.core.CoreSMT.log;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;

import timaxa007.pack.api.IPackClientSMT;
import timaxa007.pack.api.IPackCommonSMT;
import timaxa007.pack.api.IPackSMT;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PackHelper {
	//-----------------------------------------------------------------------------------------------
	public static List<JarFile> packs;
	private static List<IPackSMT> packs_main = new ArrayList<IPackSMT>();
	private static List<IPackCommonSMT> packs_common = new ArrayList<IPackCommonSMT>();
	//@SideOnly(Side.CLIENT)
	private static List<IPackClientSMT> packs_client = new ArrayList<IPackClientSMT>();
	//-----------------------------------------------------------------------------------------------
	/*
	public static void init() {
		find();
		load();
		end();
	}

	public static void find() {

		packs = new ArrayList<JarFile>();

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
	public static boolean addPackMain(String path) {
		IPackSMT ip = checkPackSMT(path);
		if (ip != null) {packs_main.add(ip);return true;}
		else {log.error("UnLoaded - " + path + ".");return false;}
	}

	public static boolean addPackCommon(String path) {
		IPackCommonSMT ip = checkPackCommonSMT(path);
		if (ip != null) {packs_common.add(ip);return true;}
		else {log.error("UnLoaded - " + path + ".");return false;}
	}

	//@SideOnly(Side.CLIENT)
	public static boolean addPackClient(String path) {
		IPackClientSMT ip = checkPackClientSMT(path);
		if (ip != null) {packs_client.add(ip);return true;}
		else {log.error("UnLoaded - " + path + ".");return false;}
	}

	public static IPackSMT checkPackSMT(String path) {
		try {return (IPackSMT)Class.forName(path).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	public static IPackCommonSMT checkPackCommonSMT(String path) {
		try {return (IPackCommonSMT)Class.forName(path).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	@SideOnly(Side.CLIENT)
	public static IPackClientSMT checkPackClientSMT(String path) {
		try {return (IPackClientSMT)Class.forName(path).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}
	//-----------------------------------------------------------------------------------------------
	public static void loadedMain(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		if (packs_main != null && packs_main.size() > 0)
			for (IPackSMT ip : packs_main) ip.preInit(event);
	}

	public static void loadedCommonPreInit() {
		if (packs_common != null && packs_common.size() > 0)
			for (IPackCommonSMT ip : packs_common) ip.preInit();
	}

	public static void loadedCommonInit() {
		if (packs_common != null && packs_common.size() > 0)
			for (IPackCommonSMT ip : packs_common) ip.init();
	}

	public static void loadedCommonPostInit() {
		if (packs_common != null && packs_common.size() > 0)
			for (IPackCommonSMT ip : packs_common) ip.postInit();
	}

	//@SideOnly(Side.CLIENT)
	public static void loadedClientPreInit() {
		if (packs_client != null && packs_client.size() > 0)
			for (IPackClientSMT ip : packs_client) ip.preInit();
	}

	//@SideOnly(Side.CLIENT)
	public static void loadedClientInit() {
		if (packs_client != null && packs_client.size() > 0)
			for (IPackClientSMT ip : packs_client) ip.init();
	}

	//@SideOnly(Side.CLIENT)
	public static void loadedClientPostInit() {
		if (packs_client != null && packs_client.size() > 0)
			for (IPackClientSMT ip : packs_client) ip.postInit();
	}
	//-----------------------------------------------------------------------------------------------
}
