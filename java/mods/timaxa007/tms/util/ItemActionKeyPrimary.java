package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemActionKeyPrimary extends Item implements IActionKeyPrimary {

	@Override
	public void onLeftClickTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_tip_info_testing) System.out.println("onLeftClickTick");
	}

	@Override
	public void onRightClickTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_tip_info_testing) System.out.println("onRightClickTick");
	}

	@Override
	public void onLeftClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_tip_info_testing) System.out.println("onLeftClick_" + (isPress ? "on" : "off"));
	}

	@Override
	public void onRightClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_tip_info_testing) System.out.println("onRightClick_" + (isPress ? "on" : "off"));
	}

	@Override
	public void onReload(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_tip_info_testing) System.out.println("onReload");
	}

	@Override
	public void onCharge(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_tip_info_testing) System.out.println("onCharge");
	}

	@Override
	public void onMode(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_tip_info_testing) System.out.println("onMode");
	}

}
