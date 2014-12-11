package mods.timaxa007.pack.stock.lib;

import mods.timaxa007.lib.GetColors;
import net.minecraft.util.StatCollector;
/**
* @author timaxa007
* @param 
* @param 
* @param 
*/
public class FoodForItem {

public static final FoodForItem[] food_list = new FoodForItem[32767];

public static final FoodForItem food_empty = new FoodForItem(0);

public int foodID;
public String tagID;
private String name;
private String name_short;
private String type;

private int level;
private float sat;
private int spd_eat;

private float temp;
private float temp_min;
private float temp_max;

//private int pass_n = 4;
private int[] color_hex = new int[] {0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF};
private String[] texture_name = new String[] {"empty", "empty", "empty", "empty"};
private int[] clr_tmp = color_hex;
private String[] txr_tmp = texture_name;
//@SideOnly(Side.CLIENT) protected IIcon icon_food;

public FoodForItem() {
FoodForItem1();
/*food_list[nextID()] = this;
foodID = nextID();*/
}

public FoodForItem(int id) {
FoodForItem1(id);
/*food_list[id] = this;
foodID = id;*/
}

public FoodForItem(String str) {
checkTagID(str);/*OFF*/
FoodForItem1();
/*food_list[nextID()] = this;
foodID = nextID();*/
tagID = str;
}

public FoodForItem(int id, String str) {
checkTagID(str);/*OFF*/
FoodForItem1(id);
/*food_list[id] = this;
foodID = id;*/
tagID = str;
}

private void FoodForItem1() {
food_list[nextID()] = this;
foodID = nextID();
}

private void FoodForItem1(int id) {
food_list[id] = this;
foodID = id;
}

public static int nextID() {
for (int i = 0; i < food_list.length; i++) {
if (food_list[i] == null) {return i;}
}
return food_list.length - 1;
}

public static boolean hasTagID(String str) {
for (int i = 0; i < food_list.length; i++) {
if (str.equalsIgnoreCase(food_list[i].tagID)) {return true;}
}
return false;
}

public static int getID_tag(String str) {
for (int i = 0; i < food_list.length; i++) {
if (food_list[i] != null) {if (str.equalsIgnoreCase(food_list[i].tagID)) {return i;}}
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

public FoodForItem setName(String str) {name = str;return this;}
public String getName() {return name == null ? tagID == null ? "unnamed" : tagID : name;}
public String getLocalizedName() {return StatCollector.translateToLocal("food." + getName() + ".name");}

public FoodForItem setShortName(String str) {name_short = str;return this;}
public String getShortName() {return name_short == null ? "unnamed" : name_short;}
public String getLocalizedShortName() {return StatCollector.translateToLocal("food." + getShortName() + ".name");}

public FoodForItem setType(String str) {type = str;return this;}
public String getType() {return type == null ? "untype" : type;}
public String getLocalizedType() {return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");}

public FoodForItem setFoodStats(int i, float f) {level = i;sat = f;return this;}

public FoodForItem setFoodLevel(int i) {level = i;return this;}
public int getFoodLevel() {return level == 0 ? 0 : level;}

public FoodForItem setFoodSaturation(float f) {sat = f;return this;}
public float getFoodSaturation() {return sat == 0 ? 0.0F : sat;}

public FoodForItem setSpeedOfEating(int i) {spd_eat = i;return this;}
public int getSpeedOfEating() {return spd_eat == 0 ? 32 : spd_eat;}

public FoodForItem setTemperatures(float f, float f1, float f2) {temp = f;temp_min = f1;temp_max = f2;return this;}
public FoodForItem setTemperature(float f) {temp = f;return this;}
public float getTemperature() {return temp;}
public FoodForItem setTemperatureMin(float f1) {temp_min = f1;return this;}
public float getTemperatureMin() {return temp_min;}
public FoodForItem setTemperatureMax(float f2) {temp_max = f2;return this;}
public float getTemperatureMax() {return temp_max;}

public FoodForItem setColors(int[] i) {color_hex = i;return this;}
public FoodForItem setColors(int i1) {color_hex[0] = i1;return this;}
public FoodForItem setColors(int i1, int i2) {color_hex[0] = i1;color_hex[1] = i2;return this;}
//public FoodForItem setColors(int i1, int i2, int i3) {color_hex[0] = i1;color_hex[1] = i2;color_hex[2] = i3;return this;}
//public FoodForItem setColors(int i1, int i2, int i3, int i4) {color_hex[0] = i1;color_hex[1] = i2;color_hex[2] = i3;color_hex[3] = i4;return this;}

public FoodForItem setColorsMix(int[] clr1, int[] clr2) {
setColorsMix(clr1, clr2, new int[] {2, 2, 2, 2}, new boolean[] {true, true, true, true});
return this;
}

public FoodForItem setColorsMix(int[] clr1, int[] clr2, int[] p) {
setColorsMix(clr1, clr2, p, new boolean[] {true, true, true, true});
return this;
}

public FoodForItem setColorsMix(int[] clr1, int[] clr2, int[] p, boolean[] flag) {
for (int i = 0; i < color_hex.length;) {
color_hex[i] = GetColors.getColorMix(clr1[i], clr2[i], p[i], flag[i]);
}
return this;
}

public FoodForItem setColorsMix(int i, int clr1, int clr2) {
setColorsMix(i, clr1, clr2, 2, true);
return this;
}

public FoodForItem setColorsMix(int i, int clr1, int clr2, int p) {
setColorsMix(i, clr1, clr2, p, true);
return this;
}

public FoodForItem setColorsMix(int i, int clr1, int clr2, int p, boolean flag) {
if (i < color_hex.length && i >= 0) {
color_hex[i] = GetColors.getColorMix(clr1, clr2, p, flag);
}
return this;
}

public int[] getColor() {return color_hex;}
public int getColor(int i) {return i < color_hex.length && i >= 0 ? color_hex[i] : 0xFFFFFF;}//public int getColor(int i) {return color_hex[i];}

public FoodForItem setTexture(String[] str) {
for (int i = 0; i < str.length; i++) {
if (str[i] == "0" || str[i] == "foods/0") {str[i] = "empty";}
if (str[i] == "O") {str[i] = str[i - 1] + "_overlay";}
if (str[i] == "foods/O") {str[i] = "foods/" + str[i - 1] + "_overlay";}
}
texture_name = str;
return this;
}
public FoodForItem setTexture(String str1) {texture_name[0] = str1;return this;}

public FoodForItem setTexture(String str1, String str2) {
txr_tmp[0] = str1;txr_tmp[1] = str2;setTexture(txr_tmp);
/*if (str2 == "0") {str2 = "empty";}if (str2 == "O") {str2 = str1 + "_overlay";}texture_name[0] = str1;texture_name[1] = str2;*/
return this;
}

public FoodForItem setTextureFood(String[] str) {
for (int i = 0; i < str.length; i++) {
if (str[i] == "0" || str[i] == "foods/0") {str[i] = "empty";}
if (str[i] == "O") {str[i] = str[i - 1] + "_overlay";}
txr_tmp[i] = "foods/" + str[i];
}
texture_name = txr_tmp;
return this;
}
public FoodForItem setTextureFood(String str1) {setTexture("foods/" + str1);return this;}
public FoodForItem setTextureFood(String str1, String str2) {
txr_tmp[0] = "foods/" + str1;txr_tmp[1] = str2 == "O" ? "foods/" + str1 + "_overlay" : "foods/" + str2 + str2;setTexture(txr_tmp);
//setTexture("foods/" + str1, str2 == "O" ? "foods/" + str1 + "_overlay" : "foods/" + str2);
return this;
}

public String[] getTexture() {return texture_name;}
public String getTexture(int i) {return i < texture_name.length && i >= 0 ? texture_name[i] : "empty";}
/*
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
icon_food = ir.registerIcon("timaxa007:" + getTextureName());
}
*/
}

