package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IActionKeyPlayer {

	public void onBooster(ItemStack is, World world, EntityPlayer player);
	public void onGrab(ItemStack is, World world, EntityPlayer player);
	public void onLie(ItemStack is, World world, EntityPlayer player);

}
