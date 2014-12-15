package mods.timaxa007.lib;

import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public class AddTextureModel {

public static AddTextureModel[] list = new AddTextureModel[1024];

public int id;
public String tag;
private Block block;
private String texture;
private String custom_mod;

private static String tb = "textures/blocks/";
private static String ti = "textures/items/";

public static AddTextureModel empty = new AddTextureModel(0).setTextureBlock("timaxa007", "woodFrame");

public AddTextureModel() {
id = getNextID();
list[id] = this;
tag = null;
block = null;
texture = null;
custom_mod = null;
}

public AddTextureModel(int id) {
this.id = id;
list[id] = this;
tag = null;
block = null;
texture = null;
custom_mod = null;
}

public AddTextureModel(String tag_name) {
id = getNextID();
list[id] = this;
checkTag(tag_name);//OFF
tag = tag_name;
block = null;
texture = null;
custom_mod = null;
}

private static int getNextID() {
for (int i = 0; i < list.length; ++i) {
if (list[i] == null) {return i;}
}
return list.length - 1;
}

public static boolean hasTag(String str) {
for (int i = 0; i < list.length; i++) {
if (str.equalsIgnoreCase(list[i].tag)) {
return true;
}
}
return false;
}

public static int getID_tag(String str) {
for (int i = 0; i < list.length; i++) {
if (str.equalsIgnoreCase(list[i].tag)) {return i;}
}
return 0;
}

private void checkTag(String str) {
for (int i = 0; i < list.length; i++) {
if (list[i] != null && list[i].tag == str) {
System.out.println("!Duplicate: " + str);
}
}
}

public AddTextureModel setBlock(Block block) {
this.block = block;
return this;
}

public AddTextureModel setTexture(String path) {
texture = path;
return this;
}

public AddTextureModel setTextureBlock(String path) {
texture = tb + path;
return this;
}
/**This texture is other MOD or use another path.**/
public AddTextureModel setTexture(String mod_id, String path) {
custom_mod = mod_id;
texture = path;
return this;
}
/**This texture to path block is other MOD or use another path.**/
public AddTextureModel setTextureBlock(String mod_id, String path) {
custom_mod = mod_id;
texture = tb + path;
return this;
}

public ResourceLocation getTexture() {
if (block != null) {return getBlockTextureLocation(block);}
System.out.println("getBlockTextureLocation - 2.");
return new ResourceLocation(custom_mod != null ? custom_mod : "timaxa007", texture + ".png");
//System.out.println("Error in getTexture for AddTextureModel.");
//return null;
}

public static ResourceLocation getBlockTextureLocation(Block block) {
int side = 0;int meta = 0;
IIcon icon = block.getIcon(side, meta);
//--------------------------------------------------------------------
if (icon != null) {
String iconName = icon.getIconName();
String s1 = "minecraft";
String s2 = iconName;
int i = iconName.indexOf(58);
if (i >= 0) {s2 = iconName.substring(i + 1, iconName.length());if (i > 1) {s1 = iconName.substring(0, i);}}
System.out.println("getBlockTextureLocation - 1.");
return new ResourceLocation(s1, tb + s2 + ".png");
}
//--------------------------------------------------------------------
System.out.println("getBlockTextureLocation - null.");
return null;
}

@Deprecated
public static ResourceLocation getBlockTextureLocation(Block block, int side, int metadata) throws Exception {
IIcon icon = block.getIcon(side, metadata);
if (icon != null) {
String iconName = icon.getIconName();
//--------------------------------------------------------------------
String s1 = "minecraft";
String s2 = iconName;
int i = iconName.indexOf(58);
if (i >= 0) {s2 = iconName.substring(i + 1, iconName.length());if (i > 1) {s1 = iconName.substring(0, i);}}
//--------------------------------------------------------------------
ResourceLocation res_loc = new ResourceLocation(s1, tb + s2 + ".png");
if (res_loc != null && Minecraft.getMinecraft().getResourceManager().getResource(res_loc).getInputStream() != null) {
return res_loc;
} else throw new IOException(String.format("The block %s icon isn't correct.", block));
} else throw new NullPointerException(String.format("The block %s missing icon.", block));
}

}
