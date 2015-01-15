package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemActionSecondaryKey extends ItemFixReg implements IActionKeySecondary {

	public ItemActionSecondaryKey(String tag) {
		super(tag);
	}

	public boolean isUse;
	public boolean isYawRight;
	public boolean isUp;
	public boolean isYawLeft;
	public boolean isMoveRight;
	public boolean isStop;
	public boolean isMoveLeft;
	public boolean isUse2;
	public boolean isDown;
	public boolean isUse1;

	@Override
	public void onUse1Tick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onUse1Tick");
	}

	@Override
	public void onDownTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onDownTick");
	}

	@Override
	public void onUse2Tick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onUse2Tick");
	}

	@Override
	public void onMoveLeftTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onMoveLeftTick");
	}

	@Override
	public void onStopTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onStopTick");
	}

	@Override
	public void onMoveRightTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onMoveRightTick");
	}

	@Override
	public void onYawLeftTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onYawLeftTick");
	}

	@Override
	public void onUpTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onUpTick");
	}

	@Override
	public void onYawRightTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onYawRightTick");
	}

	@Override
	public void onUseTick(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_system_info_testing) System.out.println("onUseTick");
	}

	@Override
	public void onUse(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onUse");
	}

	@Override
	public void onYawRight(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onYawRight");
	}

	@Override
	public void onUp(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onUp");
	}

	@Override
	public void onYawLeft(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onYawLeft");
	}

	@Override
	public void onMoveRight(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onMoveRight");
	}

	@Override
	public void onStop(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onStop");
	}

	@Override
	public void onMoveLeft(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onMoveLeft");
	}

	@Override
	public void onUse2(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onUse2");
	}

	@Override
	public void onDown(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onDown");
	}

	@Override
	public void onUse1(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (Core.show_system_info_testing) System.out.println("onUse1");
	}

}
