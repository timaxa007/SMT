package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IActionKeyPrimary {

	public void onHookTick(ItemStack is, World world, EntityPlayer player);//-4
	public void onModeTick(ItemStack is, World world, EntityPlayer player);//-3
	public void onChargeTick(ItemStack is, World world, EntityPlayer player);//-2
	public void onReloadTick(ItemStack is, World world, EntityPlayer player);//-1

	public void onReload(ItemStack is, World world, EntityPlayer player, boolean isPress);//1
	public void onCharge(ItemStack is, World world, EntityPlayer player, boolean isPress);//2
	public void onMode(ItemStack is, World world, EntityPlayer player, boolean isPress);//3
	public void onHook(ItemStack is, World world, EntityPlayer player, boolean isPress);//4

}
