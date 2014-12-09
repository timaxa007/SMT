package mods.timaxa007.Pack.Magic.Lib;

import net.minecraft.util.StatCollector;
/**
* @author timaxa007
* @param 
* @param 
* @param 
*/
public class ItemForMagic {

public static final ItemForMagic[] item_list = new ItemForMagic[2048];

public static ItemForMagic item_empty = new ItemForMagic(0);

public int itemID;
public String nameID;
private String name;
private String type;

private int color_hex1;
private int color_hex2;

//@SideOnly(Side.CLIENT) protected Icon icon_item;
protected String texture1Name;
protected String texture2Name;

public ItemForMagic() {
item_list[nextID()] = this;
itemID = nextID();
}

public ItemForMagic(int id) {
item_list[id] = this;
itemID = id;
}

public ItemForMagic(String str) {
checkNameID(str);//OFF
item_list[nextID()] = this;
itemID = nextID();
nameID = str;
}

public static int nextID() {
for (int i = 0; i < item_list.length; i++) {
if (item_list[i] == null) {return i;}
}
return item_list.length - 1;
}

public static boolean hasNameID(String str) {
for (int i = 0; i < item_list.length; i++) {
if (str.equalsIgnoreCase(item_list[i].nameID)) {
return true;
}
}
return false;
}

public static int getID_name(String str) {
for (int i = 0; i < item_list.length; i++) {
if (str.equalsIgnoreCase(item_list[i].nameID)) {return i;}
}
return 0;
}

private void checkNameID(String str) {
for (int i = 0; i < item_list.length; i++) {
if (item_list[i] != null && item_list[i].nameID == str) {
System.out.println("!Duplicate: " + str);
}
}
}

public ItemForMagic setName(String str) {name = str;return this;}
public String getName() {return name == null ? "unnamed" : name;}
public String getLocalizedName() {return StatCollector.translateToLocal("item." + getName() + ".name");}

public ItemForMagic setType(String str) {type = str;return this;}
public String getType() {return type == null ? "untyped" : type;}
public String getLocalizedType() {return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");}

public ItemForMagic setColors(int i) {color_hex1 = i;color_hex2 = i;return this;}
public ItemForMagic setColors(int i1, int i2) {color_hex1 = i1;color_hex2 = i2;return this;}

public ItemForMagic setColor1(int i) {color_hex1 = i;return this;}
public int getColor1() {return color_hex1 == 0 ? 0xFFFFFF : color_hex1;}

public ItemForMagic setColor2(int i) {color_hex2 = i;return this;}
public int getColor2() {return color_hex2 == 0 ? 0xFFFFFF : color_hex2;}

public ItemForMagic setTextures(String str) {texture1Name = str;texture2Name = str + "_overlay";return this;}
public ItemForMagic setTextures(String str1, String str2) {texture1Name = str1;texture2Name = str2;return this;}

public ItemForMagic setTexture1(String str) {texture1Name = str;return this;}
public String getTexture1() {return texture1Name == null ? getName() : texture1Name;}

public ItemForMagic setTexture2(String str) {texture2Name = str;return this;}
public String getTexture2() {return texture2Name == null ? getTexture1() : texture2Name;}

/*
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
icon_item = ir.registerIcon("timaxa007:" + getTextureName());
}
*/
}

