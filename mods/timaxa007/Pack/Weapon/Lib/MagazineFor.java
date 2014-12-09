package mods.timaxa007.Pack.Weapon.Lib;

import net.minecraft.util.StatCollector;

/**
* @author timaxa007
* @param 
* @param 
* @param 
*/
public class MagazineFor {

public static final MagazineFor[] magazine_list = new MagazineFor[1024];

public static final MagazineFor magazine_empty = new MagazineFor(0);

public int magazineID;
public String tagID;
private String name;
private String type;

private int color_hex1;
private int color_hex2;
private float temperature;
private float temperature_min;
private float temperature_max;

//@SideOnly(Side.CLIENT) protected Icon icon_magazine;
protected String texture1Name;
protected String texture2Name;

private AmmoFor bullet;
private int size;

public MagazineFor() {
magazine_list[nextID()] = this;
magazineID = nextID();
}

public MagazineFor(int id) {
magazine_list[id] = this;
magazineID = id;
}

public MagazineFor(String str) {
checkTagID(str);//OFF
magazine_list[nextID()] = this;
magazineID = nextID();
tagID = str;
}

public MagazineFor(int id, String str) {
checkTagID(str);//OFF
magazine_list[id] = this;
magazineID = id;
tagID = str;
}

public static int nextID() {
for (int i = 0; i < magazine_list.length; i++) {
if (magazine_list[i] == null) {return i;}
}
return magazine_list.length-1;
}

public static boolean hasTagID(String str) {
for (int i = 0; i < magazine_list.length; i++) {
if (str.equalsIgnoreCase(magazine_list[i].tagID)) {
return true;
}
}
return false;
}

public static int getID_tag(String str) {
for (int i = 0; i < magazine_list.length; i++) {
if (str.equalsIgnoreCase(magazine_list[i].tagID)) {return i;}
}
return 0;
}

private void checkTagID(String str) {
for (int i = 0; i < magazine_list.length; i++) {
if (magazine_list[i] != null && magazine_list[i].tagID == str) {
System.out.println("!Duplicate: " + str);
}
}
}

public MagazineFor setName(String str) {name = str;return this;}
public String getName() {return name == null ? "unnamed" : name;}
public String getLocalizedName() {return StatCollector.translateToLocal("magazine." + getName() + ".name");}

public MagazineFor setType(String str) {type = str;return this;}
public String getType() {return type == null ? "untype" : type;}
public String getLocalizedType() {return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");}

public MagazineFor setColors(int i) {color_hex1 = i;color_hex2 = i;return this;}
public MagazineFor setColors(int i1, int i2) {color_hex1 = i1;color_hex2 = i2;return this;}

public MagazineFor setColor1(int i) {color_hex1 = i;return this;}
public int getColor1() {return color_hex1 == 0 ? 0xFFFFFF : color_hex1;}

public MagazineFor setColor2(int i) {color_hex2 = i;return this;}
public int getColor2() {return color_hex2 == 0 ? 0xFFFFFF : color_hex2;}

public MagazineFor setTemperatures(float temp, float temp_min, float temp_max) {
temperature = temp;
temperature_min = temp_min;
temperature_max = temp_max;
return this;
}

public MagazineFor setTemperature(float f) {temperature = f;return this;}
public float getTemperature() {return temperature == 0 ? 0.0F : temperature;}

public MagazineFor setTemperatureMin(float f) {temperature_min = f;return this;}
public float getTemperatureMin() {return temperature_min == 0 ? 0.0F : temperature_min;}

public MagazineFor setTemperatureMax(float f) {temperature_max = f;return this;}
public float getTemperatureMax() {return temperature_max == 0 ? 0.0F : temperature_max;}

public MagazineFor setTextures(String str) {texture1Name = str;texture2Name = str + "_overlay";return this;}
public MagazineFor setTextures(String str1, String str2) {texture1Name = str1;texture2Name = str2;return this;}

public MagazineFor setTexture1(String str) {texture1Name = str;return this;}
public String getTexture1() {return texture1Name == null ? getName() : texture1Name;}

public MagazineFor setTexture2(String str) {texture2Name = str;return this;}
public String getTexture2() {return texture2Name == null ? getTexture1() : texture2Name;}

public MagazineFor setSize(int i) {size = i;return this;}
public int getSize() {return size;}

public MagazineFor setBullet(AmmoFor a) {bullet = a;return this;}
public AmmoFor getBullet() {return bullet;}

/*
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
icon_magazine = ir.registerIcon("timaxa007:" + getTextureName());
}
*/
}
