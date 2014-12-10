package mods.timaxa007.pack.furniture.items;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorCostumes extends ItemArmor {

@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

public static String[] armor_type_name = new String[] {
"helmet", 
"shirt", 
"pants", 
"boot"
};

public ArmorCostumes(ArmorMaterial par2, int par3, int par4) {
super(par2, par3, par4);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
}

public enum costumes {
Cow(), 
Mooshroom(), 
Sheep(), 
Creeper(), 
Zombie(), 
Zombie_pigman(), 
Skeleton(), 
Wither_skeleton(), 
Blaze(), 
Enderman(), 
Spider(), 
Spider_cave(), 
NONE();

private String texture;
private boolean pass;
private int hex1;
private int hex2;

static boolean hasStrCode(String str) {
for (costumes j : costumes.values()) {
if (str.equalsIgnoreCase(j.toString())) {
return true;
}
}
return false;
}

costumes() {
texture = toString().toLowerCase();
pass = false;
hex1 = 0xFFFFFF;
hex2 = 0xFFFFFF;
}

}

public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("NameID")) {
return super.getUnlocalizedName() + "." + tag.getString("NameID").toLowerCase();
}
return super.getUnlocalizedName();
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
if (tag != null && tag.hasKey("NameID")) {
list.add("NameID: " + tag.getString("NameID") + ".");
}
} else {
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(Item id, CreativeTabs table, List list) {
for (costumes j : costumes.values()) {
list.add(addTag(id, j.toString()));
}
//list.add(new ItemStack(id, 1, 0));
}

private ItemStack addTag(Item id, String par2) {
ItemStack is = new ItemStack(id, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setString("NameID", par2);
is.setTagCompound(tag);
return is;
}

public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("NameID") && costumes.hasStrCode(tag.getString("NameID"))) {
if (armorType != 2) {
return "timaxa007:textures/armor/" + tag.getString("NameID") + "_1.png";
} else {
return "timaxa007:textures/armor/" + tag.getString("NameID") + "_2.png";
}
} else {
return "timaxa007:textures/armor/none_1.png";
}
}

public IIcon getIcon(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("NameID") && costumes.hasStrCode(tag.getString("NameID"))) {
if (pass == 0) {
return icon_tex[costumes.valueOf(tag.getString("NameID")).ordinal()];
} else {
return icon_ovl[costumes.valueOf(tag.getString("NameID")).ordinal()];
}
} else {
return itemIcon;
}
}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("NameID") && costumes.hasStrCode(tag.getString("NameID"))) {
if (pass == 0) {
return costumes.valueOf(tag.getString("NameID")).hex1;
} else {
return costumes.valueOf(tag.getString("NameID")).hex2;
}
} else {
return 16777215;
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
itemIcon = ir.registerIcon("timaxa007:" + "armor/" + "armor");
icon_tex = new IIcon[costumes.values().length];
icon_ovl = new IIcon[costumes.values().length];
for (costumes j : costumes.values()) {
icon_tex[j.ordinal()] = ir.registerIcon("timaxa007:" + "armor/" + j.texture + "_" + armorType);
if (j.pass) {
icon_ovl[j.ordinal()] = ir.registerIcon("timaxa007:" + "armor/" + j.texture + "_" + armorType + "_overlay");
} else {
icon_ovl[j.ordinal()] = ir.registerIcon("timaxa007:" + "empty");
}
}
}

}
