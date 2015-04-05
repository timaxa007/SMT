package timaxa007.pack;

import timaxa007.pack.api.IProxyPackClient;

public class ProxyPackClient extends ProxyPackCommon {

	public static IProxyPackClient 
	furniture,
	item,
	magic,
	mining,
	stock,
	techno,
	weapon;

	public void preInit() {
		super.preInit();

		verificationPackClient();

		if (furniture != null) furniture.preInit();
		if (item != null) item.preInit();
		if (magic != null) magic.preInit();
		if (mining != null) mining.preInit();
		if (stock != null) stock.preInit();
		if (techno != null) techno.preInit();
		if (weapon != null) weapon.preInit();

	}

	public void init() {
		super.init();

		if (furniture != null) furniture.init();
		if (item != null) item.init();
		if (magic != null) magic.init();
		if (mining != null) mining.init();
		if (stock != null) stock.init();
		if (techno != null) techno.init();
		if (weapon != null) weapon.init();

	}

	public void postInit() {
		super.postInit();

		if (furniture != null) furniture.postInit();
		if (item != null) item.postInit();
		if (magic != null) magic.postInit();
		if (mining != null) mining.postInit();
		if (stock != null) stock.postInit();
		if (techno != null) techno.postInit();
		if (weapon != null) weapon.postInit();

	}

	public static void verificationPackClient() {

		if (NodePack.isPackFurniture)
			furniture = checkPackClient(NodePack.PATH + ".furniture.ProxyClient");

		if (NodePack.isPackItems)
			item = checkPackClient(NodePack.PATH + ".item.ProxyClient");

		if (NodePack.isPackMagic)
			magic = checkPackClient(NodePack.PATH + ".magic.ProxyClient");

		if (NodePack.isPackMining)
			mining = checkPackClient(NodePack.PATH + ".mining.ProxyClient");

		if (NodePack.isPackStock)
			stock = checkPackClient(NodePack.PATH + ".stock.ProxyClient");

		if (NodePack.isPackTechno)
			techno = checkPackClient(NodePack.PATH + ".techno.ProxyClient");

		if (NodePack.isPackWeapons)
			weapon = checkPackClient(NodePack.PATH + ".weapon.ProxyClient");

	}

	public static IProxyPackClient checkPackClient(String node) {
		try {return (IProxyPackClient)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}
