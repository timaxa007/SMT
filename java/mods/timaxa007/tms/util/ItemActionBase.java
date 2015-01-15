package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemActionBase extends ItemFixReg implements IActionMouseKey, IActionKeyPrimary {

	public ItemActionBase(String tag) {
		super(tag);
	}

	public boolean isLeftClick;
	public boolean isRightClick;
	public boolean isReload;
	public boolean isCharge;
	public boolean isMode;
	public boolean isHook;
	public boolean isZoomIn;
	public boolean isZoomOut;

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

	@Override
	public void onZoomOutTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onZoomOutTick");
	}

	@Override
	public void onZoomInTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onZoomInTick");
	}

	@Override
	public void onHookTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onHookTick");
	}

	@Override
	public void onModeTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onModeTick");
	}

	@Override
	public void onChargeTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onChargeTick");
	}

	@Override
	public void onReloadTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onReloadTick");
	}

	@Override
	public void onReload(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onReload");
	}

	@Override
	public void onCharge(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onCharge");
	}

	@Override
	public void onMode(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onMode");
	}

	@Override
	public void onHook(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onHook");
	}

	@Override
	public void onZoomIn(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onZoomIn");
	}

	@Override
	public void onZoomOut(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onZoomOut");
	}

}
