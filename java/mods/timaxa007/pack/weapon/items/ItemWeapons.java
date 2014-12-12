package mods.timaxa007.pack.weapon.items;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.weapon.PackWeapon;
import mods.timaxa007.pack.weapon.lib.WeaponFor;
import mods.timaxa007.tms.KeyBindingHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWeapons extends Item {

@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

public ItemWeapons() {
super();
setMaxStackSize(1);
setCreativeTab(PackWeapon.proxy.tab_weapon_pack);
setTextureName("timaxa007:item_weapons");
setUnlocalizedName("item_weapons");
}

public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {

if (entity instanceof EntityPlayer) {

ItemStack actHBI = ((EntityPlayer)entity).getCurrentEquippedItem();

if (actHBI != null && actHBI.getItem() instanceof ItemWeapons && actHBI.getTagCompound() != null) {
NBTTagCompound tag = actHBI.getTagCompound();

if (!(Minecraft.getMinecraft().currentScreen instanceof GuiScreen)) {//GuiContainer
//----------------------------------------------------------------------------------------------------------------
if (Mouse.isButtonDown(0)) {

if (actHBI.getTagCompound().hasKey("WeaponID") && actHBI.getTagCompound().hasKey("Shooted")) {
int var1 = tag.getInteger("Shooted");
int var2 = tag.getInteger("AmmoAtm");

if (var1 > 20) {var1 = 0;}
if (!Mouse.isButtonDown(0)) {var1 = 0;} else {var1++;}

if (isFire(var1, 5) && var2 > 0) {
if (!world.isRemote) {
world.playSoundAtEntity(entity, "timaxa007:ak74_shoot", 1.0F, 1.0F);
//world.spawnEntityInWorld(new EntityBullet(world, (EntityPlayer)entity, 2.0F));
} else {
System.out.println("isFire - n: " + var1);
}
tag.setInteger("AmmoAtm", var2 - 1);
}

tag.setInteger("Shooted", var1);

}

}
//----------------------------------------------------------------------------------------------------------------
/*if (Keyboard.isKeyDown(KeyBindingHandler.reload_key_bind.getKeyCode())) {
if (WeaponFor.weapon_list[tag.getInteger("WeaponID")] != null) {
if (!world.isRemote) {

} else {
System.out.println("-reload-");
}

//tag.setInteger("AmmoAtm", MagazineFor.magazine_list[tag.getInteger("MagazineID")].getSize());
tag.setInteger("AmmoAtm", 20);
}
}*/
//----------------------------------------------------------------------------------------------------------------
/*if (Keyboard.isKeyDown(KeyBindingHandler.mode_switch_key_bind.getKeyCode())) {
if (!world.isRemote) {

((EntityPlayer)entity).openGui(PackWeapon.instance, 1, world, (int)entity.posX, (int)entity.posY, (int)entity.posZ);
System.out.println("-modify-");

}
}*/
//----------------------------------------------------------------------------------------------------------------
}
actHBI.setTagCompound(tag);
}
}
}

private boolean isFire(int i, int type) {

if (type == 20) {switch(i) {default:return true;}}

if (type == 10) {
switch(i) {
case 1:return true;
case 3:return true;
case 5:return true;
case 7:return true;
case 9:return true;
case 11:return true;
case 13:return true;
case 15:return true;
case 17:return true;
case 19:return true;
default:return false;
}
}

if (type == 5) {
switch(i) {
case 1:return true;
case 5:return true;
case 9:return true;
case 13:return true;
case 17:return true;
default:return false;
}
}

if (type == 4) {
switch(i) {
case 1:return true;
case 6:return true;
case 11:return true;
case 16:return true;
default:return false;
}
}

if (type == 2) {
switch(i) {
case 1:return true;
case 11:return true;
default:return false;
}
}

if (type == 1) {
switch(i) {
case 1:return true;
default:return false;
}
}

if (type == -1) {
switch(i) {
case 18:return true;
default:return false;
}
}

return false;
}

public boolean onEntitySwing(EntityLivingBase entity, ItemStack is) {
return true;
}

public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int par4) {
NBTTagCompound tag = is.getTagCompound();
if (!world.isRemote) {
if (tag != null && tag.hasKey("Aim")) {
tag.setBoolean("Aim", false);
is.setTagCompound(tag);
System.out.println("off-scope");
}
}
}

public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
NBTTagCompound tag = is.getTagCompound();
//if (player.capabilities.isCreativeMode || player.inventory.hasItem(Item.arrow.getItem())) {
player.setItemInUse(is, getMaxItemUseDuration(is));
//}
if (!world.isRemote) {
if (tag != null && tag.hasKey("Aim")) {
tag.setBoolean("Aim", true);
is.setTagCompound(tag);
System.out.println("on-scope");
}
}
return is;
}

public int getMaxItemUseDuration(ItemStack is) {return 72000;}

public EnumAction getItemUseAction(ItemStack is) {return EnumAction.none;}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("WeaponID")) {
return "weapon." + WeaponFor.weapon_list[tag.getInteger("WeaponID")].getName();
}
return super.getUnlocalizedName();
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
if (tag != null) {

if (tag.hasKey("WeaponID")) {
list.add("WeaponID: " + tag.getInteger("WeaponID") + "/" + 
WeaponFor.weapon_list[tag.getInteger("WeaponID")].getName() + ".");
}

}
} else {
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for (int i = 0; i < WeaponFor.weapon_list.length; i++) {
if (WeaponFor.weapon_list[i] != null) {
list.add(addTag(i));
}
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackWeapon.proxy.item_weapons, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("WeaponID", par1);
tag.setBoolean("Aim", false);
tag.setInteger("Shooted", 0);

if (WeaponFor.weapon_list[par1].getMagazine() != null) {
tag.setInteger("MagazineID", WeaponFor.weapon_list[par1].getMagazine().magazineID);
tag.setInteger("AmmoAtm", WeaponFor.weapon_list[par1].getMagazine().getSize());
} 
if (WeaponFor.weapon_list[par1].getAmmo() != null) {
tag.setInteger("AmmoID", WeaponFor.weapon_list[par1].getAmmo().ammoID);
tag.setInteger("AmmoAtm", WeaponFor.weapon_list[par1].getSizeAmmo());
}

//tag.setInteger("AmmoID", WeaponFor.weapon_list[par1].getAmmo().ammoID);
/*if (WeaponFor.weapon_list[par1].getMagazine() != null) {
tag.setInteger("MagazineID", WeaponFor.weapon_list[par1].getMagazine().magazineID);
}*/
//tag.setInteger("MagazineID", par2);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

public IIcon getIcon(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("WeaponID")) {
if (pass == 0) {
return icon_tex[tag.getInteger("WeaponID")];
} else {
return icon_ovl[tag.getInteger("WeaponID")];
}
} else {
return itemIcon;
}
}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
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
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
itemIcon = ir.registerIcon("timaxa007:" + "weapons");
icon_tex = new IIcon[WeaponFor.weapon_list.length];
icon_ovl = new IIcon[WeaponFor.weapon_list.length];
for (int i = 0; i < WeaponFor.weapon_list.length; i++) {
/*if (WeaponFor.weapon_list[i] != null) {
icon_tex[i] = ir.registerIcon("timaxa007:" + "weapons/" + WeaponFor.weapon_list[i].getTexture1Name());
	if (WeaponFor.weapon_list[i].getTexture2Name() == WeaponFor.weapon_list[i].getTexture1Name()) {
	icon_ovl[i] = ir.registerIcon("timaxa007:" + "empty");
	} else {
	icon_ovl[i] = ir.registerIcon("timaxa007:" + "weapons/" + WeaponFor.weapon_list[i].getTexture2Name());
	}
} else {*/
icon_tex[i] = itemIcon;
icon_ovl[i] = itemIcon;
//}
}
}

}
