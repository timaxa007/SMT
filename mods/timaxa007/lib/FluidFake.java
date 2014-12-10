package mods.timaxa007.lib;

import net.minecraft.util.StatCollector;
/**
* @author timaxa007
* @param 
* @param 
* @param 
*/
public class FluidFake {

public static final FluidFake[] fluid_list = new FluidFake[4096];

public static final FluidFake fluid_empty = new FluidFake(0);

public int fluidID;
public String tagID;
private String name;
private String type;
private int color_hex;
private float temperature;
private float temperature_min;
private float temperature_max;

//@SideOnly(Side.CLIENT) protected IIcon icon_fluid;
protected String textureName;

public FluidFake() {
fluid_list[nextID()] = this;
fluidID = nextID();
}

public FluidFake(int id) {
fluid_list[id] = this;
fluidID = id;
}

public FluidFake(String str) {
checkTagID(str);//OFF
fluid_list[nextID()] = this;
fluidID = nextID();
tagID = str;
}

public FluidFake(int id, String str) {
checkTagID(str);//OFF
fluid_list[id] = this;
fluidID = id;
tagID = str;
}

public static int nextID() {
for (int i = 0; i < fluid_list.length; i++) {
if (fluid_list[i] == null) {return i;}
}
return fluid_list.length - 1;
}

public static boolean hasTagID(String str) {
for (int i = 0; i < fluid_list.length; i++) {
if (str.equalsIgnoreCase(fluid_list[i].tagID)) {
return true;
}
}
return false;
}

public static int getID_tag(String str) {
for (int i = 0; i < fluid_list.length; i++) {
if (str.equalsIgnoreCase(fluid_list[i].tagID)) {return i;}
}
return 0;
}

private void checkTagID(String str) {
for (int i = 0; i < fluid_list.length; i++) {
if (fluid_list[i] != null && fluid_list[i].tagID == str) {
System.out.println("!Duplicate: " + str);
}
}
}

public FluidFake setName(String str) {name = str;return this;}
public String getName() {return name == null ? "unnamed" : name;}
public String getLocalizedName() {return StatCollector.translateToLocal("fluid." + getName() + ".name");}

public FluidFake setType(String str) {type = str;return this;}
public String getType() {return type == null ? "untype" : type;}
public String getLocalizedType() {return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");}

public FluidFake setColor(int i) {color_hex = i;return this;}
public FluidFake setColorMix(int clr1, int clr2) {color_hex = GetColors.getColorMix(clr1, clr2);return this;}
public int getColor() {return color_hex == 0 ? 0xFFFFFF : color_hex;}

public FluidFake setTemperatures(float temp, float temp_min, float temp_max) {
temperature = temp;
temperature_min = temp_min;
temperature_max = temp_max;
return this;
}

public FluidFake setTemperature(float f) {temperature = f;return this;}
public float getTemperature() {return temperature == 0 ? 0.0F : temperature;}

public FluidFake setTemperatureMin(float f) {temperature_min = f;return this;}
public float getTemperatureMin() {return temperature_min == 0 ? 0.0F : temperature_min;}

public FluidFake setTemperatureMax(float f) {temperature_max = f;return this;}
public float getTemperatureMax() {return temperature_max == 0 ? 0.0F : temperature_max;}

public FluidFake setTexture(String str) {textureName = str;return this;}
public String getTexture() {return textureName == null ? getName() : textureName;}
/*
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
icon_fluid = ir.registerIcon("timaxa007:" + getTextureName());
}
*/
}

