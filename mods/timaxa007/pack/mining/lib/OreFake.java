package mods.timaxa007.pack.mining.lib;

import net.minecraft.util.StatCollector;

/**
* @author timaxa007
* @param 
* @param 
* @param 
*/
public class OreFake {

public static final OreFake[] ore_list = new OreFake[4096];

public static final OreFake ore_empty = new OreFake(0);

public int oreID;
public String tagID;
private String name;
private String type;
private int color_hex;
private float temperature;
private float temperature_min;
private float temperature_max;

//@SideOnly(Side.CLIENT) protected IIcon icon_ore;
protected String textureName;

public OreFake() {
ore_list[nextID()] = this;
oreID = nextID();
}

public OreFake() {
ore_list[id] = this;
oreID = id;
}

public OreFake(String str) {
checkTagID(str);//OFF
ore_list[nextID()] = this;
oreID = nextID();
tagID = str;
}

public OreFake(int id, String str) {
checkTagID(str);//OFF
ore_list[id] = this;
oreID = id;
tagID = str;
}

public static int nextID() {
for (int i = 0; i < ore_list.length; i++) {
if (ore_list[i] == null) {
return i;
}
}
return ore_list.length - 1;
}

public static boolean hasTagID(String str) {
for (int i = 0; i < ore_list.length; i++) {
if (str.equalsIgnoreCase(ore_list[i].tagID)) {
return true;
}
}
return false;
}

public static int getID_tag(String str) {
for (int i = 0; i < ore_list.length; i++) {
if (str.equalsIgnoreCase(ore_list[i].tagID)) {return i;}
}
return 0;
}

private void checkTagID(String str) {
for (int i = 0; i < ore_list.length; i++) {
if (ore_list[i] != null && ore_list[i].tagID == str) {
System.out.println("!Duplicate: " + str);
}
}
}

public OreFake setName(String str) {name = str;return this;}
public String getName() {return name == null ? "unnamed" : name;}
public String getLocalizedName() {return StatCollector.translateToLocal("ore." + getName() + ".name");}

public OreFake setType(String str) {type = str;return this;}
public String getType() {return type == null ? "untype" : type;}
public String getLocalizedType() {return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");}

public OreFake setColor(int i) {color_hex = i;return this;}
public int getColor() {return color_hex == 0 ? 0xFFFFFF : color_hex;}

public OreFake setTemperatures(float temp, float temp_min, float temp_max) {
temperature = temp;
temperature_min = temp_min;
temperature_max = temp_max;
return this;
}

public OreFake setTemperature(float f) {temperature = f;return this;}
public float getTemperature() {return temperature == 0 ? 0.0F : temperature;}

public OreFake setTemperatureMin(float f) {temperature_min = f;return this;}
public float getTemperatureMin() {return temperature_min == 0 ? 0.0F : temperature_min;}

public OreFake setTemperatureMax(float f) {temperature_max = f;return this;}
public float getTemperatureMax() {return temperature_max == 0 ? 0.0F : temperature_max;}

public OreFake setTexture(String str) {textureName = str;return this;}
public OreFake setTextureOre(String str) {textureName = "ore/" + str;return this;}
public String getTexture() {return textureName == null ? getName() : textureName;}
/*
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
icon_ore = ir.registerIcon("timaxa007:" + getTextureName());
}
*/
}
