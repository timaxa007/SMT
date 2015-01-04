package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IActionKeyPlayer {

	public void onLieTick(ItemStack is, World world, EntityPlayer player);
	public void onGrabTick(ItemStack is, World world, EntityPlayer player);
	public void onBoosterTick(ItemStack is, World world, EntityPlayer player);

	public void onBooster(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onGrab(ItemStack is, World world, EntityPlayer player, boolean isPress);
	public void onLie(ItemStack is, World world, EntityPlayer player, boolean isPress);

}
