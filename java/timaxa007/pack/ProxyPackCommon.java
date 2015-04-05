package timaxa007.pack;

import timaxa007.pack.api.IProxyPackCommon;

public class ProxyPackCommon {

	public static IProxyPackCommon 
	furniture,
	item,
	magic,
	mining,
	stock,
	techno,
	weapon;

	public void preInit() {

		verificationPackCommon();

		if (furniture != null) furniture.preInit();
		if (item != null) item.preInit();
		if (magic != null) magic.preInit();
		if (mining != null) mining.preInit();
		if (stock != null) stock.preInit();
		if (techno != null) techno.preInit();
		if (weapon != null) weapon.preInit();

	}

	public void init() {

		if (furniture != null) furniture.init();
		if (item != null) item.init();
		if (magic != null) magic.init();
		if (mining != null) mining.init();
		if (stock != null) stock.init();
		if (techno != null) techno.init();
		if (weapon != null) weapon.init();

	}

	public void postInit() {

		if (furniture != null) furniture.postInit();
		if (item != null) item.postInit();
		if (magic != null) magic.postInit();
		if (mining != null) mining.postInit();
		if (stock != null) stock.postInit();
		if (techno != null) techno.postInit();
		if (weapon != null) weapon.postInit();

	}

	public static void verificationPackCommon() {

		if (NodePack.isPackFurniture)
			furniture = checkPackCommon(NodePack.PATH + ".furniture.ProxyCommon");

		if (NodePack.isPackItems)
			item = checkPackCommon(NodePack.PATH + ".item.ProxyCommon");

		if (NodePack.isPackMagic)
			magic = checkPackCommon(NodePack.PATH + ".magic.ProxyCommon");

		if (NodePack.isPackMining)
			mining = checkPackCommon(NodePack.PATH + ".mining.ProxyCommon");

		if (NodePack.isPackStock)
			stock = checkPackCommon(NodePack.PATH + ".stock.ProxyCommon");

		if (NodePack.isPackTechno)
			techno = checkPackCommon(NodePack.PATH + ".techno.ProxyCommon");

		if (NodePack.isPackWeapons)
			weapon = checkPackCommon(NodePack.PATH + ".weapon.ProxyCommon");

	}

	public static IProxyPackCommon checkPackCommon(String node) {
		try {return (IProxyPackCommon)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}
