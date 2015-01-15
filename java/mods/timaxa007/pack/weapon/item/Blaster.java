package mods.timaxa007.pack.weapon.item;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.weapon.PackWeapons;
import mods.timaxa007.tms.util.ItemFixReg;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Blaster extends ItemFixReg {

	public Blaster(String tag) {
		super(tag);
		setCreativeTab(PackWeapons.tab_weapons);
		setFull3D();
	}

	public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int par4) {
		if (player.inventory.hasItem(PackFurniture.proxy.item.colored)) {
			if (!world.isRemote) {
				//EntityBlasterBullet blasterBullet = new EntityBlasterBullet(world, player, 2.0F);
				//world.spawnEntityInWorld(blasterBullet);
				player.inventory.consumeInventoryItem(PackFurniture.proxy.item.colored);
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
		if (player.inventory.hasItem(PackFurniture.proxy.item.colored)) {
			player.setItemInUse(is, getMaxItemUseDuration(is));
		}
		return is;
	}

	public void addInformation(ItemStack is, CreativeTabs tab, List list, boolean f3Enabled) {
		list.add("INFO");
		if (tab == CreativeTabs.tabBlock) list.add("ITS IN BLOCK TAB!!!");
		if (f3Enabled) list.add("HiddenINFO");
	}

	@Override
	public void registerIcons(IIconRegister ir) {
		itemIcon = ir.registerIcon("timaxa007:"+"blaster");
	}
}
