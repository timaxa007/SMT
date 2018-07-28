package smt.pack.technology.client.render;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import smt.pack.technology.SMTTechnology;
import smt.pack.technology.client.render.entity.*;
import smt.pack.technology.client.render.item.*;
import smt.pack.technology.client.render.tile.*;
import smt.pack.technology.entity.*;
import smt.pack.technology.tile.*;

public class ListRender {

	public static void preInit() {

	}

	public static final void init() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlocksTechnology.class, new RenederTileEntityBlocksTechnology());

		RenderingRegistry.registerEntityRenderingHandler(EntityLightningBolt2.class, new RenderLightningBolt2());

		MinecraftForgeClient.registerItemRenderer(SMTTechnology.item.electricScanner, new ItemRenderElectricScanner());
	}

	public static void postInit() {

	}

}
