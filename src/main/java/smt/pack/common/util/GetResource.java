package smt.pack.common.util;

import java.io.IOException;
import java.io.InputStream;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ResourceLocation;

public class GetResource {

	public static String getPath(ResourceLocation rl) {
		return "/assets/" + rl.getResourceDomain() + "/" + rl.getResourcePath();
	}

	public static InputStream getStream(ResourceLocation rl) {
		return GetResource.class.getResourceAsStream(getPath(rl));
	}

	@SideOnly(Side.CLIENT)
	public static InputStream getInputStream(ResourceLocation rl) {
		try {
			return net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(rl).getInputStream();
		} catch (IOException e) {e.printStackTrace();}
		return null;
	}

}
