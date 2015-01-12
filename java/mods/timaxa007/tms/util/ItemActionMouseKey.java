package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemActionMouseKey extends Item implements IActionMouseKey {

	public boolean isLeftClick;
	public boolean isRightClick;

	@Override
	public void onRightClickTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onRightClickTick");
	}

	@Override
	public void onLeftClickTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onLeftClickTick");
	}

	@Override
	public void onLeftClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onLeftClick");
	}

	@Override
	public void onRightClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onRightClick");
	}

}
