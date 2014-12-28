package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IActionKeySecondary {

	public void onUse(ItemStack is, World world, EntityPlayer player);//3
	public void onYawRight(ItemStack is, World world, EntityPlayer player);//4
	public void onUp(ItemStack is, World world, EntityPlayer player);//5
	public void onYawLeft(ItemStack is, World world, EntityPlayer player);//6
	public void onMoveRight(ItemStack is, World world, EntityPlayer player);//7
	public void onStop(ItemStack is, World world, EntityPlayer player);//8
	public void onMoveLeft(ItemStack is, World world, EntityPlayer player);//9
	public void onUse2(ItemStack is, World world, EntityPlayer player);//10
	public void onDown(ItemStack is, World world, EntityPlayer player);//11
	public void onUse1(ItemStack is, World world, EntityPlayer player);//12

}
