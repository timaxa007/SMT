package mods.timaxa007.pack.weapon.items;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.weapon.PackWeapon;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Blaster extends Item{
public Blaster() {
super();
this.setCreativeTab(PackWeapon.proxy.tabWeaponPack);
this.setUnlocalizedName("blaster");
this.setFull3D();
}

public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int par4) {
if (player.inventory.hasItem(PackFurniture.proxy.item_colored)) {
if (!world.isRemote) {
//EntityBlasterBullet blasterBullet = new EntityBlasterBullet(world, player, 2.0F);
//world.spawnEntityInWorld(blasterBullet);
player.inventory.consumeInventoryItem(PackFurniture.proxy.item_colored);
}
}
}

public int getMaxItemUseDuration(ItemStack par1ItemStack) {
return 72000;
}

public EnumAction getItemUseAction(ItemStack par1ItemStack) {
return EnumAction.bow;
}

public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
if (player.inventory.hasItem(PackFurniture.proxy.item_colored)) {
player.setItemInUse(is, this.getMaxItemUseDuration(is));
}
return is;
}

public void addInformation(ItemStack is, CreativeTabs tab, List list, boolean f3Enabled) {
list.add("INFO");
if(tab==CreativeTabs.tabBlock)
list.add("ITS IN BLOCK TAB!!!");
if(f3Enabled)
list.add("HiddenINFO");
}

@Override
public void registerIcons(IIconRegister ir) {
this.itemIcon=ir.registerIcon("timaxa007:"+"blaster");
}
}
