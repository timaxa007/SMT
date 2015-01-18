package mods.timaxa007.pack.item.item;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.util.ItemFixReg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToolShield extends ItemFixReg {

	public ToolShield(String tag) {
		super(tag);
		setCreativeTab(PackFurniture.tab_furniture);
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.block;
	}

	public int getMaxItemUseDuration(ItemStack is) {
		return 72000;
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		player.setItemInUse(is, getMaxItemUseDuration(is));
		return is;
	}

	public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int par4) {

	}

}
