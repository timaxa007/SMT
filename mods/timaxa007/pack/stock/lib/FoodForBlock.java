package mods.timaxa007.pack.stock.lib;

import net.minecraft.util.StatCollector;
/**
* @author timaxa007
* @param 
* @param 
* @param 
*/
public class FoodForBlock {

public static final FoodForBlock[] food_list = new FoodForBlock[4096];

public static final FoodForBlock food_empty = new FoodForBlock(0);

public int foodID;
public String tagID;
private String name;
private String type;

private int level;
private float saturation;

private int color_hex1;
private int color_hex2;
private float temperature;
private float temperature_min;
private float temperature_max;

//@SideOnly(Side.CLIENT) protected Icon icon_food;
protected String texture1Name;
protected String texture2Name;

public FoodForBlock() {
food_list[nextID()] = this;
foodID = nextID();
color_hex1 = 0;
color_hex2 = 0;
}

public FoodForBlock(int id) {
food_list[id] = this;
foodID = id;
color_hex1 = 0;
color_hex2 = 0;
}

public FoodForBlock(String str) {
checkTagID(str);//OFF
food_list[nextID()] = this;
foodID = nextID();
tagID = str;
color_hex1 = 0;
color_hex2 = 0;
}

public FoodForBlock(int id, String str) {
checkTagID(str);//OFF
food_list[id] = this;
foodID = id;
tagID = str;
color_hex1 = 0;
color_hex2 = 0;
}

public static int nextID() {
for (int i = 0; i < food_list.length; i++) {
if (food_list[i] == null) {return i;}
}
return food_list.length - 1;
}

public static boolean hasTagID(String str) {
for (int i = 0; i < food_list.length; i++) {
if (str.equalsIgnoreCase(food_list[i].tagID)) {
return true;
}
}
return false;
}

public static int getID_tag(String str) {
for (int i = 0; i < food_list.length; i++) {
if (str.equalsIgnoreCase(food_list[i].tagID)) {return i;}
}
return 0;
}

private void checkTagID(String str) {
for (int i = 0; i < food_list.length; i++) {
if (food_list[i] != null && food_list[i].tagID == str) {
System.out.println("!Duplicate: " + str);
}
}
}

public FoodForBlock setName(String str) {name = str;return this;}
public String getName() {return name == null ? "unnamed" : name;}
public String getLocalizedName() {return StatCollector.translateToLocal("food." + getName() + ".name");}

public FoodForBlock setType(String str) {type = str;return this;}
public String getType() {return type == null ? "untype" : type;}
public String getLocalizedType() {return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");}

public FoodForBlock setFoodStats(int i, float f) {level = i;saturation = f;return this;}

public FoodForBlock setFoodLevel(int i) {level = i;return this;}
public int getFoodLevel() {return level == 0 ? 0 : level;}

public FoodForBlock setFoodSaturation(float f) {saturation = f;return this;}
public float getFoodSaturation() {return saturation == 0 ? 0.0F : saturation;}

public FoodForBlock setColors(int i) {color_hex1 = i;color_hex2 = i;return this;}
public FoodForBlock setColors(int i1, int i2) {color_hex1 = i1;color_hex2 = i2;return this;}

public FoodForBlock setColor1(int i) {color_hex1 = i;return this;}
public int getColor1() {return color_hex1 == 0 ? 0xFFFFFF : color_hex1;}

public FoodForBlock setColor2(int i) {color_hex2 = i;return this;}
public int getColor2() {return color_hex2 == 0 ? 0xFFFFFF : color_hex2;}

public FoodForBlock setTemperatures(float temp, float temp_min, float temp_max) {
temperature = temp;
temperature_min = temp_min;
temperature_max = temp_max;
return this;
}

public FoodForBlock setTemperature(float f) {temperature = f;return this;}
public float getTemperature() {return temperature == 0 ? 0.0F : temperature;}

public FoodForBlock setTemperatureMin(float f) {temperature_min = f;return this;}
public float getTemperatureMin() {return temperature_min == 0 ? 0.0F : temperature_min;}

public FoodForBlock setTemperatureMax(float f) {temperature_max = f;return this;}
public float getTemperatureMax() {return temperature_max == 0 ? 0.0F : temperature_max;}

public FoodForBlock setTextures(String str) {texture1Name = str;texture2Name = str + "_overlay";return this;}
public FoodForBlock setTextures(String str1, String str2) {texture1Name = str1;texture2Name = str2;return this;}
public FoodForBlock setTexturesFood(String str) {texture1Name = str;texture2Name = str + "_overlay";return this;}
public FoodForBlock setTexturesFood(String str1, String str2) {texture1Name = str1;texture2Name = str2;return this;}

public FoodForBlock setTexture1(String str) {texture1Name = str;return this;}
public FoodForBlock setTexture1Food(String str) {texture1Name = str;return this;}
public String getTexture1() {return texture1Name == null ? getName() : texture1Name;}

public FoodForBlock setTexture2(String str) {texture2Name = str;return this;}
public FoodForBlock setTexture2Food(String str) {texture2Name = str;return this;}
public String getTexture2() {return texture2Name == null ? getTexture1() : texture2Name;}

/*
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
icon_food = ir.registerIcon("timaxa007:" + getTextureName());
}
*/
}

