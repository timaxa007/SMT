package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemActionMouse extends ItemFixReg {
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public boolean isLeftClick;

	@SideOnly(Side.CLIENT)
	public boolean isRightClick;
	//--------------------------------------------------------------------------------------------------------------
	public ItemActionMouse(String tag) {
		super(tag);
	}
	//--------------------------------------------------------------------------------------------------------------
	/**Return boolean: <b>true</b> - working method onLeftClickTick (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onLeftClickTickClient(ItemStack is, World world, EntityPlayer player) {
		return false;
	}

	/**Return boolean: <b>true</b> - working method onLeftClick (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onLeftClickTick(ItemStack is, World world, EntityPlayer player) {

	}

	public void onLeftClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	/**Return boolean: <b>true</b> - working method onRightClickTick (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onRightClickTickClient(ItemStack is, World world, EntityPlayer player) {
		return false;
	}

	/**Return boolean: <b>true</b> - working method onRightClick (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onRightClickTick(ItemStack is, World world, EntityPlayer player) {

	}

	public void onRightClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
}
