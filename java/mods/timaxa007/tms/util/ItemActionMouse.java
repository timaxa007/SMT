package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemActionMouse extends ItemFixReg {
	//--------------------------------------------------------------------------------------------------------------
	public static boolean isLeftClick;
	public static boolean isRightClick;
	//--------------------------------------------------------------------------------------------------------------
	public ItemActionMouse(String tag) {
		super(tag);
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onLeftClickTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public void onLeftClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onRightClickTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	@SideOnly(Side.CLIENT)
	public void onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public void onRightClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
}
