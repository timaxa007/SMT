package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionSecondaryKey {
	//-10
	public static void onUse1Tick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onUse1Tick(current, player.worldObj, player);
		}
	}
	//-9
	public static void onDownTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onDownTick(current, player.worldObj, player);
		}
	}
	//-8
	public static void onUse2Tick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onUse2Tick(current, player.worldObj, player);
		}
	}
	//-7
	public static void onMoveLeftTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onMoveLeftTick(current, player.worldObj, player);
		}
	}
	//-6
	public static void onStopTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onStopTick(current, player.worldObj, player);
		}
	}
	//-5
	public static void onMoveRightTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onMoveRightTick(current, player.worldObj, player);
		}
	}
	//-4
	public static void onYawLeftTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onYawLeftTick(current, player.worldObj, player);
		}
	}
	//-3
	public static void onUpTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onUpTick(current, player.worldObj, player);
		}
	}
	//-2
	public static void onYawRightTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onYawRightTick(current, player.worldObj, player);
		}
	}
	//-1
	public static void onUseTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onUseTick(current, player.worldObj, player);
		}
	}
	//---------------------------------------------------------------------------------------------------------
	//1
	public static void onUse(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onUse(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionSecondaryKey)
				((ItemActionSecondaryKey)current.getItem()).isUse = buttonstate;
		}
	}
	//2
	public static void onYawRight(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onYawRight(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionSecondaryKey)
				((ItemActionSecondaryKey)current.getItem()).isYawRight = buttonstate;
		}
	}
	//3
	public static void onUp(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onUp(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionSecondaryKey)
				((ItemActionSecondaryKey)current.getItem()).isUp = buttonstate;
		}
	}
	//4
	public static void onYawLeft(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onYawLeft(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionSecondaryKey)
				((ItemActionSecondaryKey)current.getItem()).isYawLeft = buttonstate;
		}
	}
	//5
	public static void onMoveRight(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onMoveRight(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionSecondaryKey)
				((ItemActionSecondaryKey)current.getItem()).isMoveRight = buttonstate;
		}
	}
	//6
	public static void onStop(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onStop(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionSecondaryKey)
				((ItemActionSecondaryKey)current.getItem()).isStop = buttonstate;
		}
	}
	//7
	public static void onMoveLeft(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onMoveLeft(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionSecondaryKey)
				((ItemActionSecondaryKey)current.getItem()).isMoveLeft = buttonstate;
		}
	}
	//8
	public static void onUse2(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onUse2(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionSecondaryKey)
				((ItemActionSecondaryKey)current.getItem()).isUse2 = buttonstate;
		}
	}
	//9
	public static void onDown(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onDown(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionSecondaryKey)
				((ItemActionSecondaryKey)current.getItem()).isDown = buttonstate;
		}
	}
	//10
	public static void onUse1(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeySecondary)
				((IActionKeySecondary)current.getItem()).onUse1(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionSecondaryKey)
				((ItemActionSecondaryKey)current.getItem()).isUse1 = buttonstate;
		}
	}

}
