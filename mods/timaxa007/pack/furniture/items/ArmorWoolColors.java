package mods.timaxa007.pack.furniture.items;

import java.util.List;

import mods.timaxa007.lib.GetColors;
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

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorWoolColors extends ItemArmor {

public ArmorWoolColors(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
super(par2EnumArmorMaterial, par3, par4);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
}

public String getUnlocalizedName(ItemStack is) {
return super.getUnlocalizedName();
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
list.add(Option.getText("Material") + ": " + Option.getText("Wool") + ".");
list.add(Option.getText("Type") + ": " + Option.getText("Armor") + ".");
if (tag != null) {
if (tag.hasKey("Color")) {
//list.add(Option.getText("Color") + ": " + Option.GetColors(tag.getInteger("HexColor"), "a") + ".");
list.add(Option.getText("Color") + ": " + tag.getInteger("HexColor") + ".");
}
}
} else {
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(Item id, CreativeTabs table, List list) {
for (int j = 0; j < 16; ++j) {
list.add(addTag(new ItemStack(id, 1, 0), GetColors.getHexColors[j]));
}
list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(ItemStack par1, int par2) {
ItemStack is = par1;
NBTTagCompound tag = new NBTTagCompound();
//tag.setInteger("Color", par2);
tag.setInteger("HexColor", par2);
is.setTagCompound(tag);
return is;
}
/*
@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}
*/
@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("HexColor")) {
return tag.getInteger("HexColor");
} else {
return 16777215;
}
}
/*
public int getColor(ItemStack is) {
super.getColor(is);
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("HexColor")) {
return tag.getInteger("HexColor");
} else {
return 0xFF0000;
}
}
*/
public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
if (armorType != 2) {return "timaxa007:textures/armor/armor_wool_color_white_1.png";} 
else {return "timaxa007:textures/armor/armor_wool_color_white_2.png";}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
String[] typeArmor = new String[] {"helm", "chest", "leggin", "boot"};
super.registerIcons(ir);
itemIcon = ir.registerIcon("timaxa007:armor/armor_wool_" + typeArmor[armorType] +"_overlay");
}

}