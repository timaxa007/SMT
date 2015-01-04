package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemActionKeyPrimary extends Item implements IActionKeyPrimary {

	@Override
	public void onHookTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_tip_info_testing) System.out.println("onHookTick");
	}

	@Override
	public void onModeTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_tip_info_testing) System.out.println("onModeTick");
	}

	@Override
	public void onChargeTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_tip_info_testing) System.out.println("onChargeTick");
	}

	@Override
	public void onReloadTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_tip_info_testing) System.out.println("onReloadTick");
	}

	@Override
	public void onReload(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_tip_info_testing) System.out.println("onReload");
	}

	@Override
	public void onCharge(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_tip_info_testing) System.out.println("onCharge");
	}

	@Override
	public void onMode(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_tip_info_testing) System.out.println("onMode");
	}

	@Override
	public void onHook(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_tip_info_testing) System.out.println("onHook");
	}

}
