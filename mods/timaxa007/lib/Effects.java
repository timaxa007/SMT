package mods.timaxa007.lib;

import net.minecraft.util.StatCollector;
/**
* @author timaxa007
* @param 
* @param 
* @param 
*/
public class Effects {

public static final Effects[] effects_list = new Effects[2048];

public static final Effects effect_empty = new Effects(0);

public static final Effects effect_move_fast = new Effects("move_fast");
public static final Effects effect_move_slow = new Effects("move_slow");

public static final Effects effect_mining_fast = new Effects("mining_fast");
public static final Effects effect_mining_slow = new Effects("mining_slow");

public static final Effects effect_digging_fast = new Effects("digging_fast");
public static final Effects effect_digging_slow = new Effects("digging_slow");

public static final Effects effect_chopping_fast = new Effects("chopping_fast");
public static final Effects effect_chopping_slow = new Effects("chopping_slow");

public static final Effects effect_trimming_fast = new Effects("trimming_fast");
public static final Effects effect_trimming_slow = new Effects("trimming_slow");

public static final Effects effect_strength_high = new Effects("strength_high");
public static final Effects effect_strength_low = new Effects("strength_low");

public static final Effects effect_damage = new Effects("damage");
public static final Effects effect_protection_damage = new Effects("protection_damage");
public static final Effects effect_resistance_damage = new Effects("resistance_damage");

public static final Effects effect_poison = new Effects("poison");
public static final Effects effect_protection_poison = new Effects("protection_poison");
public static final Effects effect_resistance_poison = new Effects("resistance_poison");

public static final Effects effect_jump = new Effects("jump");
public static final Effects effect_confusion = new Effects("confusion");
public static final Effects effect_regeneration = new Effects("regeneration");
public static final Effects effect_resistance_fire = new Effects("resistance_fire");
public static final Effects effect_water_breathing = new Effects("water_breathing");
public static final Effects effect_invisibility = new Effects("invisibility");

public static final Effects effect_blindness = new Effects("blindness");
public static final Effects effect_night_vision = new Effects("night_vision");

public static final Effects effect_hunger = new Effects("hunger");
public static final Effects effect_weakness = new Effects("weakness");
public static final Effects effect_wither = new Effects("wither");
public static final Effects effect_potion_health_boost = new Effects("potion_health_boost");
public static final Effects effect_potion_absoption = new Effects("potion_absoption");
public static final Effects effect_potion_health = new Effects("potion_health");

public int effectID;
public String tagID;
private String name;
private String type;

private int color_hex1;
private int color_hex2;
private float temperature;
private float temperature_min;
private float temperature_max;

//@SideOnly(Side.CLIENT) protected Icon icon_effect;
protected String texture1Name;
protected String texture2Name;

public Effects() {
effects_list[nextID()] = this;
effectID = nextID();
}

public Effects(int id) {
effects_list[id] = this;
effectID = id;
}

public Effects(String str) {
effects_list[nextID()] = this;
effectID = nextID();
tagID = str;
}

public Effects(int id, String str) {
effects_list[id] = this;
effectID = id;
tagID = str;
}

public static int nextID() {
for (int i = 0; i < effects_list.length; i++) {
if (effects_list[i] == null) {
return i;
}
}
return effects_list.length - 1;
}

public static boolean hasTagID(String str) {
for (int i = 0; i < effects_list.length; i++) {
if (str.equalsIgnoreCase(effects_list[i].tagID)) {
return true;
}
}
return false;
}

public static int getID_tag(String str) {
for (int i = 0; i < effects_list.length; i++) {
if (str.equalsIgnoreCase(effects_list[i].tagID)) {return i;}
}
return 0;
}

private void checkTagID(String str) {
for (int i = 0; i < effects_list.length; i++) {
if (effects_list[i] != null && effects_list[i].tagID == str) {
System.out.println("!Duplicate: " + str);
}
}
}

public Effects setName(String str) {name = str;return this;}
public String getName() {return name == null ? tagID == null ? "unname" : tagID : name;}
public String getLocalizedName() {return StatCollector.translateToLocal("effect." + getName() + ".name");}

public Effects setType(String str) {type = str;return this;}
public String getType() {return type == null ? "untype" : type;}
public String getLocalizedType() {return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");}

public Effects setColors(int i) {color_hex1 = i;color_hex2 = i;return this;}
public Effects setColors(int i1, int i2) {color_hex1 = i1;color_hex2 = i2;return this;}

public Effects setColor1(int i) {color_hex1 = i;return this;}
public int getColor1() {return color_hex1 == 0 ? 0xFFFFFF : color_hex1;}

public Effects setColor2(int i) {color_hex2 = i;return this;}
public int getColor2() {return color_hex2 == 0 ? 0xFFFFFF : color_hex2;}

public Effects setTexture1(String str) {texture1Name = str;return this;}
public String getTexture1() {return texture1Name == null ? getName() : texture1Name;}

public Effects setTexture2(String str) {texture2Name = str;return this;}
public String getTexture2() {return texture2Name == null ? getTexture1() : texture2Name;}

/*
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
icon_effect = ir.registerIcon("timaxa007:" + getTextureName());
}
*/
}
