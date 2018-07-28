package smt.pack.geology.client.render;

import smt.pack.geology.client.render.tile.RenederTileEntityBlockOres;
import smt.pack.geology.tile.TileEntityBlockOres;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ListRender {
	/*
	public static HashMap<String, MakeTexture> map_block = new HashMap<String, MakeTexture>();

	public static HashMap<String, MakeTexture> map_stone = new HashMap<String, MakeTexture>();

	public static HashMap<String, MakeTexture> map_carver = new HashMap<String, MakeTexture>();

	public static HashMap<String, MakeTexture> map_layer = new HashMap<String, MakeTexture>();

	public static HashMap<String, MakeTexture> map_ore_layer = new HashMap<String, MakeTexture>();
	 */
	public static void preInit() {

	}

	public static final void init() {

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockOres.class, new RenederTileEntityBlockOres());

	}

	public static void postInit() {

	}

}
