package mods.timaxa007.lib;

import net.minecraft.block.Block;
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

public AddTextureModel() {
id = getNextID();
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
if (list == null) {return i;}
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

public AddTextureModel setBlock(String mod_id, Block block) {
custom_mod = mod_id;
this.block = block;
return this;
}

public AddTextureModel setTextureName(String str) {
texture = str;
return this;
}
/**This texture is other MOD or use another path.**/
public AddTextureModel setTextureName(String mod_id, String str) {
custom_mod = mod_id;
texture = str;
return this;
}
/**This texture to folder block is other MOD or use another path.**/
public AddTextureModel setBlockTextureName(String mod_id, String str) {
custom_mod = mod_id;
texture = tb + str;
return this;
}

public ResourceLocation getTexture() {
int side = 0;int meta = 0;
if (texture != null || texture != "") return new ResourceLocation(custom_mod != null ? custom_mod : "timaxa007", texture);
if (block != null) new ResourceLocation(block.getIcon(side, meta).getIconName());
System.out.println("Error in getTexture for AddTextureModel.");
//return new ResourceLocation(block.getIcon(side, meta).getIconName());
return null;
}

public String getTextureName() {
int side = 0;int meta = 0;
if (texture != null || texture != "") return texture;
if (block != null) return block.getIcon(side, meta).getIconName();
System.out.println("Error in getTextureName for AddTextureModel.");
return null;
}

public ResourceLocation getTexture(Block block) {
int side = 0;int meta = 0;
if (block != null) {
return new ResourceLocation(block.getIcon(side, meta).getIconName());
}
return null;
}

}
