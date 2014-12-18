package mods.timaxa007.lib;

@Deprecated
public class TileTexture {

private static String tb = "textures/blocks/";
private static String ti = "textures/items/";

public static String tt = tb + "woodFrame.png";

public static final Object texTest01[][] = new Object[][] {
{"timaxa007", tb + "woodFrame.png"}, 
{"minecraft", tb + "anvil_base.png"}, 
{"minecraft", tb + "bedrock.png"}, 
{"minecraft", tb + "brick.png"}, 
{"minecraft", tb + "clay.png"}, 
{"minecraft", tb + "coal_block.png"}, 
{"minecraft", tb + "coal_ore.png"}, 
{"minecraft", tb + "cobblestone.png"}, 
{"minecraft", tb + "cobblestone_mossy.png"}, 
{"minecraft", tb + "diamond_block.png"}, 
{"minecraft", tb + "diamond_ore.png"}, 
{"minecraft", tb + "dirt.png"}, 
{"minecraft", tb + "emerald_block.png"}, 
{"minecraft", tb + "emerald_ore.png"}, 
{"minecraft", tb + "end_stone.png"}, 
{"minecraft", tb + "glass.png"}, 
{"minecraft", tb + "glowstone.png"}, 
{"minecraft", tb + "gold_block.png"}, 
{"minecraft", tb + "gold_ore.png"}, 
{"minecraft", tb + "gravel.png"}, 
{"minecraft", tb + "hardened_clay.png"}, 
{"minecraft", tb + "hardened_clay_stained_black.png"}, 
{"minecraft", tb + "hardened_clay_stained_blue.png"}, 
{"minecraft", tb + "hardened_clay_stained_brown.png"}, 
{"minecraft", tb + "hardened_clay_stained_cyan.png"}, 
{"minecraft", tb + "hardened_clay_stained_gray.png"}, 
{"minecraft", tb + "hardened_clay_stained_green.png"}, 
{"minecraft", tb + "hardened_clay_stained_light_blue.png"}, 
{"minecraft", tb + "hardened_clay_stained_lime.png"}, 
{"minecraft", tb + "hardened_clay_stained_magenta.png"}, 
{"minecraft", tb + "hardened_clay_stained_orange.png"}, 
{"minecraft", tb + "hardened_clay_stained_pink.png"}, 
{"minecraft", tb + "hardened_clay_stained_purple.png"}, 
{"minecraft", tb + "hardened_clay_stained_red.png"}, 
{"minecraft", tb + "hardened_clay_stained_silver.png"}, 
{"minecraft", tb + "hardened_clay_stained_white.png"}, 
{"minecraft", tb + "hardened_clay_stained_yellow.png"}, 
{"minecraft", tb + "hay_block_side.png"}, 
{"minecraft", tb + "ice.png"}, 
{"minecraft", tb + "iron_bars.png"}, 
{"minecraft", tb + "iron_block.png"}, 
{"minecraft", tb + "iron_ore.png"}, 
{"minecraft", tb + "lapis_block.png"}, 
{"minecraft", tb + "lapis_ore.png"}, 
{"minecraft", tb + "log_birch.png"}, 
{"minecraft", tb + "log_jungle.png"}, 
{"minecraft", tb + "log_oak.png"}, 
{"minecraft", tb + "log_spruce.png"}, 
{"minecraft", tb + "melon_side.png"}, 
{"minecraft", tb + "mushroom_block_inside.png"}, 
{"minecraft", tb + "mushroom_block_skin_brown.png"}, 
{"minecraft", tb + "mushroom_block_skin_red.png"}, 
{"minecraft", tb + "mushroom_block_skin_stem.png"}, 
{"minecraft", tb + "nether_brick.png"}, 
{"minecraft", tb + "netherrack.png"}, 
{"minecraft", tb + "noteblock.png"}, 
{"minecraft", tb + "obsidian.png"}, 
{"minecraft", tb + "planks_birch.png"}, 
{"minecraft", tb + "planks_jungle.png"}, 
{"minecraft", tb + "planks_oak.png"}, 
{"minecraft", tb + "planks_spruce.png"}, 
{"minecraft", tb + "pumpkin_side.png"}, 
{"minecraft", tb + "quartz_block_bottom.png"}, 
{"minecraft", tb + "quartz_block_side.png"}, 
{"minecraft", tb + "redstone_block.png"}, 
{"minecraft", tb + "redstone_ore.png"}, 
{"minecraft", tb + "sand.png"}, 
{"minecraft", tb + "sandstone_bottom.png"}, 
{"minecraft", tb + "sandstone_top.png"}, 
{"minecraft", tb + "snow.png"}, 
{"minecraft", tb + "soul_sand.png"}, 
{"minecraft", tb + "sponge.png"}, 
{"minecraft", tb + "stone.png"}, 
{"minecraft", tb + "stone_slab_top.png"}, 
{"minecraft", tb + "stonebrick.png"}, 
{"minecraft", tb + "stonebrick_carved.png"}, 
{"minecraft", tb + "stonebrick_cracked.png"}, 
{"minecraft", tb + "stonebrick_mossy.png"}, 
{"minecraft", tb + "wool_colored_black.png"}, 
{"minecraft", tb + "wool_colored_blue.png"}, 
{"minecraft", tb + "wool_colored_brown.png"}, 
{"minecraft", tb + "wool_colored_cyan.png"}, 
{"minecraft", tb + "wool_colored_gray.png"}, 
{"minecraft", tb + "wool_colored_green.png"}, 
{"minecraft", tb + "wool_colored_light_blue.png"}, 
{"minecraft", tb + "wool_colored_lime.png"}, 
{"minecraft", tb + "wool_colored_magenta.png"}, 
{"minecraft", tb + "wool_colored_orange.png"}, 
{"minecraft", tb + "wool_colored_pink.png"}, 
{"minecraft", tb + "wool_colored_purple.png"}, 
{"minecraft", tb + "wool_colored_red.png"}, 
{"minecraft", tb + "wool_colored_silver.png"}, 
{"minecraft", tb + "wool_colored_white.png"}, 
{"minecraft", tb + "wool_colored_yellow.png"}, 
{"timaxa007", tb + "woodFrame.png"}
};

public TileTexture() {

}

public static String getTexTest01_1(int i) {
if (i <= 0) {return (String)texTest01[0][0];}
else if (i > texTest01.length) {return (String)texTest01[0][0];}
else {return (String)texTest01[i][0];}
}

public static String getTexTest01_2(int i) {
if (i <= 0) {return (String)texTest01[0][1];}
else if (i > texTest01.length) {return (String)texTest01[0][1];}
else {return (String)texTest01[i][1];}
}

}
