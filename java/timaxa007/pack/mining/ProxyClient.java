package timaxa007.pack.mining;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackClient;
import timaxa007.pack.mining.block.OreOres;
import timaxa007.pack.mining.event.EventMiningClient;
import timaxa007.pack.mining.render.RenderMain;
import timaxa007.smt.lib.AddTextureModel;
import timaxa007.smt.util.UtilRender;

public class ProxyClient implements IProxyPackClient {

	@Override
	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventMiningClient());

	}

	@Override
	public void init() {

		UtilRender.mergerImg("dirt_appa",
				AddTextureModel.get("minecraft_dirt").getTexture(), 
				new ResourceLocation("timaxa007", 
						"textures/blocks/ore/" + OreOres.type_ore[0] + "_overlay.png"),
						0x0000FF
				);

		UtilRender.mergerImg("stone_gem_l",
				AddTextureModel.get("minecraft_stone").getTexture(), 
				new ResourceLocation("timaxa007", 
						"textures/blocks/ore/" + OreOres.type_ore[15] + "_overlay.png"),
						0x4488FF
				);

		UtilRender.mergerImg("cb_mtl",
				AddTextureModel.get("minecraft_cobblestone").getTexture(), 
				new ResourceLocation("timaxa007", 
						"textures/blocks/ore/" + OreOres.type_ore[13] + "_overlay.png"),
						0xAA9999
				);

		RenderMain.init();

	}

	@Override
	public void postInit() {

	}

}
