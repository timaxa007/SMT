package smt.pack.magic.client.render;

import smt.pack.magic.client.render.entity.RenderEntitySparkl;
import smt.pack.magic.client.render.tile.RenederTileEntityAltar;
import smt.pack.magic.client.render.tile.RenederTileEntityTeleport;
import smt.pack.magic.entity.EntitySparkl;
import smt.pack.magic.tile.TileEntityAltar;
import smt.pack.magic.tile.TileEntityTeleport;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ListRender {

	public static void preInit() {

	}

	public static final void init() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, new RenederTileEntityAltar());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTeleport.class, new RenederTileEntityTeleport());

		RenderingRegistry.registerEntityRenderingHandler(EntitySparkl.class, new RenderEntitySparkl());
	}

	public static void postInit() {

	}

}
