package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPrimaryKey extends ItemActionMouse {
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public boolean isReload;

	@SideOnly(Side.CLIENT)
	public boolean isCharge;

	@SideOnly(Side.CLIENT)
	public boolean isMode;

	@SideOnly(Side.CLIENT)
	public boolean isAction;

	@SideOnly(Side.CLIENT)
	public boolean isModeIn;

	@SideOnly(Side.CLIENT)
	public boolean isModeOut;
	//--------------------------------------------------------------------------------------------------------------
	public ItemPrimaryKey(String tag) {
		super(tag);
	}
	//--------------------------------------------------------------------------------------------------------------
	/**Return boolean: <b>true</b> - working method onReloadTick (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onReloadTickClient(ItemStack is, World world, EntityPlayer player) {
		return false;
	}

	/**Return boolean: <b>true</b> - working method onReload (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onReloadClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onReloadTick(ItemStack is, World world, EntityPlayer player) {

	}

	public void onReload(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	/**Return boolean: <b>true</b> - working method onChargeTick (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onChargeTickClient(ItemStack is, World world, EntityPlayer player) {
		return false;
	}

	/**Return boolean: <b>true</b> - working method onCharge (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onChargeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onChargeTick(ItemStack is, World world, EntityPlayer player) {

	}

	public void onCharge(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	/**Return boolean: <b>true</b> - working method onModeTick (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onModeTickClient(ItemStack is, World world, EntityPlayer player) {
		return false;
	}

	/**Return boolean: <b>true</b> - working method onMode (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onModeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onModeTick(ItemStack is, World world, EntityPlayer player) {

	}

	public void onMode(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	/**Return boolean: <b>true</b> - working method onActionTick (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onActionTickClient(ItemStack is, World world, EntityPlayer player) {
		return false;
	}

	/**Return boolean: <b>true</b> - working method onAction (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onActionClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onActionTick(ItemStack is, World world, EntityPlayer player) {

	}

	public void onAction(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	/**Return boolean: <b>true</b> - working method onModeInTick (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onModeInTickClient(ItemStack is, World world, EntityPlayer player) {
		return false;
	}

	/**Return boolean: <b>true</b> - working method onModeIn (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onModeInClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onModeInTick(ItemStack is, World world, EntityPlayer player) {

	}

	public void onModeIn(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	/**Return boolean: <b>true</b> - working method onModeOutTick (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onModeOutTickClient(ItemStack is, World world, EntityPlayer player) {
		return false;
	}

	/**Return boolean: <b>true</b> - working method onModeOut (side.server) and working this method (side.client).**/
	@SideOnly(Side.CLIENT)
	public boolean onModeOutClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onModeOutTick(ItemStack is, World world, EntityPlayer player) {

	}

	public void onModeOut(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------

}
