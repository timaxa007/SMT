package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPrimaryKey extends ItemActionMouse {
	//--------------------------------------------------------------------------------------------------------------
	public static boolean isReload;
	public static boolean isCharge;
	public static boolean isMode;
	public static boolean isAction;
	public static boolean isModeIn;
	public static boolean isModeOut;
	//--------------------------------------------------------------------------------------------------------------
	public ItemPrimaryKey(String tag) {
		super(tag);
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onReloadTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	@SideOnly(Side.CLIENT)
	public void onReloadClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public void onReload(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onChargeTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	@SideOnly(Side.CLIENT)
	public void onChargeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public void onCharge(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public void onMode(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onActionTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	@SideOnly(Side.CLIENT)
	public void onActionClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public void onAction(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeInTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeInClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public void onModeIn(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeOutTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeOutClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public void onModeOut(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------

}
