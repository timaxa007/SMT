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

		listPackClient();

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

	public static void listPackClient() {
		//------------------------------------------------------------------------------------
		if (NodePack.isPackFurniture) {
			try {
				String node_furniture = "timaxa007.pack.furniture.ProxyClient";
				Object o_furniture = Class.forName(node_furniture).newInstance();
				furniture = (IProxyPackClient)o_furniture;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackItems) {
			try {
				String node_item = "timaxa007.pack.item.ProxyClient";
				Object o_item = Class.forName(node_item).newInstance();
				item = (IProxyPackClient)o_item;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackMagic) {
			try {
				String node_magic = "timaxa007.pack.magic.ProxyClient";
				Object o_magic = Class.forName(node_magic).newInstance();
				magic = (IProxyPackClient)o_magic;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackMining) {
			try {
				String node_mining = "timaxa007.pack.mining.ProxyClient";
				Object o_mining = Class.forName(node_mining).newInstance();
				mining = (IProxyPackClient)o_mining;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackStock) {
			try {
				String node_stock = "timaxa007.pack.stock.ProxyClient";
				Object o_stock = Class.forName(node_stock).newInstance();
				stock = (IProxyPackClient)o_stock;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackTechno) {
			try {
				String node_techno = "timaxa007.pack.techno.ProxyClient";
				Object o_techno = Class.forName(node_techno).newInstance();
				techno = (IProxyPackClient)o_techno;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackWeapons) {
			try {
				String node_weapon = "timaxa007.pack.weapon.ProxyClient";
				Object o_weapon = Class.forName(node_weapon).newInstance();
				weapon = (IProxyPackClient)o_weapon;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
	}

}
