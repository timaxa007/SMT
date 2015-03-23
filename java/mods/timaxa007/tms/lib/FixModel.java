package mods.timaxa007.tms.lib;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class FixModel {

	public static void FixLight(World world, float x, float y, float z, Block block) {
		FixLight(world, (int)x, (int)y, (int)z, block);
	}

	public static void FixLight(World world, double x, double y, double z, Block block) {
		FixLight(world, (int)x, (int)y, (int)z, block);
	}

	public static void FixLight(World world, int x, int y, int z, Block block) {
		Tessellator tes = Tessellator.instance;
		float brightness = block.getLightValue(world, x, y, z);
		int sky_light = world.getLightBrightnessForSkyBlocks(x, y, z, 0);
		int fix_a = sky_light % 65536;
		int fix_b = sky_light / 65536;
		tes.setColorOpaque_F(brightness, brightness, brightness);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) fix_a,  fix_b);
	}

	public static void FixLight(World world, float x, float y, float z) {
		FixLight(world, (int)x, (int)y, (int)z);
	}

	public static void FixLight(World world, double x, double y, double z) {
		FixLight(world, (int)x, (int)y, (int)z);
	}

	public static void FixLight(World world, int x, int y, int z) {
		Tessellator tes = Tessellator.instance;
		float brightness = world.getBlockLightValue(x, y, z);
		int sky_light = world.getLightBrightnessForSkyBlocks(x, y, z, 0);
		int fix_a = sky_light % 65536;
		int fix_b = sky_light / 65536;
		tes.setColorOpaque_F(brightness, brightness, brightness);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) fix_a,  fix_b);
	}

}
