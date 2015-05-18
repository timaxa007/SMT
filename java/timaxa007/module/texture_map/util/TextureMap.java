package timaxa007.module.texture_map.util;

import java.util.HashMap;

import timaxa007.smt.util.UtilRender;
import net.minecraft.util.ResourceLocation;

public class TextureMap {

	public static HashMap<String, ResourceLocation> map;

	public static void preInit() {
		map = new HashMap<String, ResourceLocation>();
	}

	public static void init() {
		//UtilRender.mergerImage(tex1, tex2, hex);
	}

	public static void set(String name, ResourceLocation rl) {
		map.put(name, rl);
	}

	public static ResourceLocation getResourceLocation(String name) {
		return (ResourceLocation)map.get(name);
	}

}
