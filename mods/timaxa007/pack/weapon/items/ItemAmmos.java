package mods.timaxa007.pack.weapon.items;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.weapon.PackWeapon;
import mods.timaxa007.pack.weapon.lib.AmmoFor;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAmmos extends Item {

@SideOnly(Side.CLIENT) private Icon[] icon_tex;
@SideOnly(Side.CLIENT) private Icon[] icon_ovl;

public ItemAmmos(int id) {
super(id);
setMaxStackSize(1);
setCreativeTab(PackWeapon.proxy.tabWeaponPack);
setTextureName("timaxa007:item_ammos");
setUnlocalizedName("item_ammos");
}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("AmmoID")) {
return "ammo." + AmmoFor.ammo_list[tag.getInteger("AmmoID")].getName();
}
return super.getUnlocalizedName();
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
if (tag != null) {

if (tag.hasKey("AmmoID")) {
list.add("AmmoID: " + tag.getInteger("AmmoID") + ".");
}

}
} else {
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for (int i = 0; i < AmmoFor.ammo_list.length; i++) {
if (AmmoFor.ammo_list[i] != null) {
list.add(addTag(i));
}
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackWeapon.proxy.item_ammos, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("AmmoID", par1);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

public Icon getIcon(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("AmmoID")) {
if (pass == 0) {
return icon_tex[tag.getInteger("AmmoID")];
} else {
return icon_ovl[tag.getInteger("AmmoID")];
}
} else {
return itemIcon;
}
}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("AmmoID")) {
if (pass == 0) {
return AmmoFor.ammo_list[tag.getInteger("AmmoID")].getColor1();
} else {
return AmmoFor.ammo_list[tag.getInteger("AmmoID")].getColor2();
}
} else {
return 16777215;
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
super.registerIcons(ir);
itemIcon = ir.registerIcon("timaxa007:" + "ammos");
icon_tex = new Icon[AmmoFor.ammo_list.length];
icon_ovl = new Icon[AmmoFor.ammo_list.length];
for (int i = 0; i < AmmoFor.ammo_list.length; i++) {
/*if (AmmoFor.ammo_list[i] != null) {
icon_tex[i] = ir.registerIcon("timaxa007:" + "ammos/" + AmmoFor.ammo_list[i].getTexture1Name());
	if (AmmoFor.ammo_list[i].getTexture2Name() == AmmoFor.ammo_list[i].getTexture1Name()) {
	icon_ovl[i] = ir.registerIcon("timaxa007:" + "empty");
	} else {
	icon_ovl[i] = ir.registerIcon("timaxa007:" + "ammos/" + AmmoFor.ammo_list[i].getTexture2Name());
	}
} else {*/
icon_tex[i] = itemIcon;
icon_ovl[i] = itemIcon;
//}
}
}

}
