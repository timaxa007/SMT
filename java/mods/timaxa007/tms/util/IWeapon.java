package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IWeapon {
	//Correct to fire tick.
	public void onLeftClickTick(ItemStack is, World world, EntityPlayer player);
	public void onRightClickTick(ItemStack is, World world, EntityPlayer player);
	public void onLeftClick(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onRightClick(ItemStack is, World world, EntityPlayer player, boolean isPress);

	public void onReload(ItemStack is, World world, EntityPlayer player);//0
	public void onCharge(ItemStack is, World world, EntityPlayer player);//1
	public void onMode(ItemStack is, World world, EntityPlayer player);//2

}
