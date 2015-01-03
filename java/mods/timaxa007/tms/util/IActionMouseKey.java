package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IActionMouseKey {

	public void onLeftClick(ItemStack is, World world, EntityPlayer player, boolean isPress);//1
	public void onRightClick(ItemStack is, World world, EntityPlayer player, boolean isPress);//2
	public void onLeftClickTick(ItemStack is, World world, EntityPlayer player);//3
	public void onRightClickTick(ItemStack is, World world, EntityPlayer player);//4

}
