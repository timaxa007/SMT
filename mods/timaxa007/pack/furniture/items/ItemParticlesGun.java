package mods.timaxa007.pack.furniture.items;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemParticlesGun extends Item {

@SideOnly(Side.CLIENT) private Icon[] icon_tex;
@SideOnly(Side.CLIENT) private Icon[] icon_ovl;

public ItemParticlesGun(int id) {
super(id);
setMaxStackSize(1);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setTextureName("timaxa007:item_weapons");
setUnlocalizedName("item_weapons");
}

public void onUpdate(ItemStack is, World world, Entity par3Entity, int par4, boolean par5) {

}

public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int par4) {

}

public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
return is;
}

public EnumAction getItemUseAction(ItemStack is) {
return EnumAction.none;
}
/*
public String getUnlocalizedName(ItemStack is) {
if (tag != null && tag.hasKey("WeaponID")) {
return "weapon." + WeaponFor.weapon_list[tag.getInteger("WeaponID")].getName();
}
return super.getUnlocalizedName();
}
*/
public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
if (tag != null) {

if (tag.hasKey("WeaponID")) {
list.add("WeaponID: " + tag.getInteger("WeaponID") + ".");
}

}
} else {
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackFurniture.proxy.item_particles_gun, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("WeaponID", par1);
//tag.setInteger("AmmoID", par2);
//tag.setInteger("MagazineID", par2);
is.setTagCompound(tag);
return is;
}
/*
@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

public Icon getIcon(ItemStack is, int pass) {
if (tag != null && tag.hasKey("WeaponID")) {
if (pass == 0) {
return icon_tex[WeaponFor.weapon_list[tag.getInteger("WeaponID")].weaponID];
} else {
return icon_ovl[WeaponFor.weapon_list[tag.getInteger("WeaponID")].weaponID];
}
} else {
return itemIcon;
}
}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int pass) {
if (tag != null && tag.hasKey("WeaponID")) {
if (pass == 0) {
return WeaponFor.weapon_list[tag.getInteger("WeaponID")].getColor1();
} else {
return WeaponFor.weapon_list[tag.getInteger("WeaponID")].getColor2();
}
} else {
return 16777215;
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
super.registerIcons(ir);
itemIcon = ir.registerIcon("timaxa007:" + "weapons");
icon_tex = new Icon[WeaponFor.weapon_list.length];
icon_ovl = new Icon[WeaponFor.weapon_list.length];
for (int i = 0; i < WeaponFor.weapon_list.length; i++) {
/*if (WeaponFor.weapon_list[i] != null) {
icon_tex[i] = ir.registerIcon("timaxa007:" + "weapons/" + WeaponFor.weapon_list[i].getTexture1Name());
	if (WeaponFor.weapon_list[i].getTexture2Name() == WeaponFor.weapon_list[i].getTexture1Name()) {
	icon_ovl[i] = ir.registerIcon("timaxa007:" + "empty");
	} else {
	icon_ovl[i] = ir.registerIcon("timaxa007:" + "weapons/" + WeaponFor.weapon_list[i].getTexture2Name());
	}
} else {*/
//icon_tex[i] = itemIcon;
//icon_ovl[i] = itemIcon;
//}
//}
//}

}
