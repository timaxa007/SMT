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

	public static void listPackClient() {
		//------------------------------------------------------------------------------------
		if (NodePack.isPackFurniture) {
			try {
				String node_furniture = "timaxa007.pack.furniture.ProxyCommon";
				Object o_furniture = Class.forName(node_furniture).newInstance();
				furniture = (IProxyPackCommon)o_furniture;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackItems) {
			try {
				String node_item = "timaxa007.pack.item.ProxyCommon";
				Object o_item = Class.forName(node_item).newInstance();
				item = (IProxyPackCommon)o_item;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackMagic) {
			try {
				String node_magic = "timaxa007.pack.magic.ProxyCommon";
				Object o_magic = Class.forName(node_magic).newInstance();
				magic = (IProxyPackCommon)o_magic;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackMining) {
			try {
				String node_mining = "timaxa007.pack.mining.ProxyCommon";
				Object o_mining = Class.forName(node_mining).newInstance();
				mining = (IProxyPackCommon)o_mining;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackStock) {
			try {
				String node_stock = "timaxa007.pack.stock.ProxyCommon";
				Object o_stock = Class.forName(node_stock).newInstance();
				stock = (IProxyPackCommon)o_stock;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackTechno) {
			try {
				String node_techno = "timaxa007.pack.techno.ProxyCommon";
				Object o_techno = Class.forName(node_techno).newInstance();
				techno = (IProxyPackCommon)o_techno;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (NodePack.isPackWeapons) {
			try {
				String node_weapon = "timaxa007.pack.weapon.ProxyCommon";
				Object o_weapon = Class.forName(node_weapon).newInstance();
				weapon = (IProxyPackCommon)o_weapon;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
	}

}
