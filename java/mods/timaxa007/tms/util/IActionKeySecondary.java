package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IActionKeySecondary {

	public void onUse1Tick(ItemStack is, World world, EntityPlayer player);
	public void onDownTick(ItemStack is, World world, EntityPlayer player);
	public void onUse2Tick(ItemStack is, World world, EntityPlayer player);
	public void onMoveLeftTick(ItemStack is, World world, EntityPlayer player);
	public void onStopTick(ItemStack is, World world, EntityPlayer player);
	public void onMoveRightTick(ItemStack is, World world, EntityPlayer player);
	public void onYawLeftTick(ItemStack is, World world, EntityPlayer player);
	public void onUpTick(ItemStack is, World world, EntityPlayer player);
	public void onYawRightTick(ItemStack is, World world, EntityPlayer player);
	public void onUseTick(ItemStack is, World world, EntityPlayer player);

	public void onUse(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onYawRight(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onUp(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onYawLeft(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onMoveRight(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onStop(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onMoveLeft(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onUse2(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onDown(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onUse1(ItemStack is, World world, EntityPlayer player, boolean isPress);

}
