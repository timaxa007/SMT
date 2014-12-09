package mods.timaxa007.Pack.Weapon.Lib;

import net.minecraft.util.StatCollector;
/**
* @author timaxa007
* @param 
* @param 
* @param 
*/
public class ItemForWeapon {

public static final ItemForWeapon[] item_list = new ItemForWeapon[2048];

public static ItemForWeapon item_empty = new ItemForWeapon(0);

public int itemID;
public String nameID;
private String name;
private String type;

private int color_hex1;
private int color_hex2;

//@SideOnly(Side.CLIENT) protected Icon icon_item;
protected String texture1Name;
protected String texture2Name;

public ItemForWeapon() {
item_list[nextID()] = this;
itemID = nextID();
}

public ItemForWeapon(int id) {
item_list[id] = this;
itemID = id;
}

public ItemForWeapon(String str) {
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

public ItemForWeapon setName(String str) {name = str;return this;}
public String getName() {return name == null ? "unnamed" : name;}
public String getLocalizedName() {return StatCollector.translateToLocal("item." + getName() + ".name");}

public ItemForWeapon setType(String str) {type = str;return this;}
public String getType() {return type == null ? "untype" : type;}
public String getLocalizedType() {return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");}

public ItemForWeapon setColors(int i) {color_hex1 = i;color_hex2 = i;return this;}
public ItemForWeapon setColors(int i1, int i2) {color_hex1 = i1;color_hex2 = i2;return this;}

public ItemForWeapon setColor1(int i) {color_hex1 = i;return this;}
public int getColor1() {return color_hex1 == 0 ? 0xFFFFFF : color_hex1;}

public ItemForWeapon setColor2(int i) {color_hex2 = i;return this;}
public int getColor2() {return color_hex2 == 0 ? 0xFFFFFF : color_hex2;}

public ItemForWeapon setTextures(String str) {texture1Name = str;texture2Name = str + "_overlay";return this;}
public ItemForWeapon setTextures(String str1, String str2) {texture1Name = str1;texture2Name = str2;return this;}

public ItemForWeapon setTexture1(String str) {texture1Name = str;return this;}
public String getTexture1() {return texture1Name == null ? getName() : texture1Name;}

public ItemForWeapon setTexture2(String str) {texture2Name = str;return this;}
public String getTexture2() {return texture2Name == null ? getTexture1() : texture2Name;}

/*
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
icon_item = ir.registerIcon("timaxa007:" + getTextureName());
}
*/
}

