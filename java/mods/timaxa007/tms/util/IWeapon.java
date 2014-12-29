package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IWeapon {

	public void onFire(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onScope(ItemStack is, World world, EntityPlayer player, boolean isPress);

	public void onReload(ItemStack is, World world, EntityPlayer player);
	public void onCharge(ItemStack is, World world, EntityPlayer player);
	public void onMode(ItemStack is, World world, EntityPlayer player);

}
