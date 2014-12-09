package mods.timaxa007.Pack.Furniture.Lib;
/**
* @author timaxa007
* @param 
* @param 
* @param 
*/
public class AddBlockCloth {

public AddBlockCloth[] list = new AddBlockCloth[127];

private int id;
private String tag;
private String name;
private int color_hex;
private String texture;

public AddBlockCloth() {
list[nextID()] = this;
id = nextID();
tag = "";
color_hex = 0xFFFFFF;
texture = "";
}

public AddBlockCloth(int i) {
list[i] = this;
id = i;
tag = "";
color_hex = 0xFFFFFF;
texture = "";
}

public AddBlockCloth(int i, String str) {
checkTag(str);//OFF
list[i] = this;
id = i;
tag = str;
color_hex = 0xFFFFFF;
texture = "";
}

public AddBlockCloth(String str) {
checkTag(str);//OFF
list[nextID()] = this;
id = nextID();
tag = str;
color_hex = 0xFFFFFF;
texture = "";
}

public int nextID() {
for (int i = 0; i < list.length; i++) {
if (list[i] == null) {return i;}
}
return list.length - 1;
}

public boolean hasTag(String str) {
for (int i = 0; i < list.length; i++) {
if (str.equalsIgnoreCase(list[i].tag)) {
return true;
}
}
return false;
}

public int getID_tag(String str) {
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

public AddBlockCloth setID(int i) {id = i;return this;}
public int getID() {return id;}

public AddBlockCloth setTag(String str) {tag = str;return this;}
public String getTag() {return tag;}

public AddBlockCloth setName(String str) {name = str;return this;}
public String getName() {return name;}

public AddBlockCloth setColor(int i) {color_hex = i;return this;}
public int getColor() {return color_hex;}

public AddBlockCloth setTexture(String str) {texture = str;return this;}
public String getTexture() {return texture;}

}
