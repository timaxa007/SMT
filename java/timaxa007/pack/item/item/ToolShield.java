package timaxa007.pack.item.item;

import java.util.List;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.tms.util.ModifiedItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToolShield extends ModifiedItem {

	private int damage;

	public ToolShield(String tag) {
		super(tag);
		setDamage(1);
		setMaxStackSize(1);
		setMaxDamage(1000);
		setCreativeTab(PackFurniture.tab_furniture);
	}

	public Item setDamage(int damage) {
		this.damage = damage;
		return this;
	}

	public int getDamage() {
		return damage;
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.block;
	}

	public int getMaxItemUseDuration(ItemStack is) {
		return 72000;
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		player.setItemInUse(is, getMaxItemUseDuration(is));
		is.damageItem(1, player);
		return is;
	}

	public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int par4) {

	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		list.add("Durability: " + (is.getMaxDamage() - is.getItemDamage()) + " / " + is.getMaxDamage() + ".");
	}

}