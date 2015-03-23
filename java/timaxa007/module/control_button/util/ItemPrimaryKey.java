package timaxa007.module.control_button.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPrimaryKey extends ItemActionMouse {
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public static boolean isReload;

	@SideOnly(Side.CLIENT)
	public static boolean isCharge;

	@SideOnly(Side.CLIENT)
	public static boolean isMode;

	@SideOnly(Side.CLIENT)
	public static boolean isAction;

	@SideOnly(Side.CLIENT)
	public static boolean isModeIn;

	@SideOnly(Side.CLIENT)
	public static boolean isModeOut;
	//--------------------------------------------------------------------------------------------------------------
	public ItemPrimaryKey(String tag) {
		super(tag);
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onReloadTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onReload.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onReloadClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onReload(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onChargeTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onCharge.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onChargeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onCharge(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onMode.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onModeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onMode(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onActionTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onAction.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onActionClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onAction(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeInTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onModeIn.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onModeInClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onModeIn(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeOutTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onModeOut.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onModeOutClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onModeOut(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
}
