package smt.pack.privacy;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class XRay {

	private static Minecraft mc = Minecraft.getMinecraft();
	public static ArrayList<Block> renderBlocks = new ArrayList<Block>();
	public static HashMap<Block, ResourceLocation> textureBlocks = new HashMap<Block, ResourceLocation>();

	public XRay() {
		addRenderBlocks();
		remormTextures();
	}

	public static void addRenderBlocks() {
		renderBlocks.add(Blocks.diamond_ore);
		renderBlocks.add(Blocks.iron_ore);
		renderBlocks.add(Blocks.gold_ore);
		renderBlocks.add(Blocks.coal_ore);
		renderBlocks.add(Blocks.lapis_ore);
		renderBlocks.add(Blocks.redstone_ore);
		renderBlocks.add(Blocks.lit_redstone_ore);
		renderBlocks.add(Blocks.emerald_ore);
		renderBlocks.add(Blocks.quartz_ore);
	}

	public static void remormTextures() {
		for (Block block : renderBlocks)
			textureBlocks.put(block, getLocationFrom(block.getIcon(0, 0).getIconName()));
	}

	public static ResourceLocation getLocationFrom(String name) {
		int i = name.lastIndexOf(':');
		if (i != -1) {
			String modid = name.substring(0, i);
			return new ResourceLocation(modid, "textures/blocks/" + name + ".png");
		} else return new ResourceLocation("minecraft", "textures/blocks/" + name + ".png");

	}

}
