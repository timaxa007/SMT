package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSecondaryKey extends ItemPrimaryKey {
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public static boolean isNumpad0;

	@SideOnly(Side.CLIENT)
	public static boolean isNumpad1;

	@SideOnly(Side.CLIENT)
	public static boolean isNumpad2;

	@SideOnly(Side.CLIENT)
	public static boolean isNumpad3;

	@SideOnly(Side.CLIENT)
	public static boolean isNumpad4;

	@SideOnly(Side.CLIENT)
	public static boolean isNumpad5;

	@SideOnly(Side.CLIENT)
	public static boolean isNumpad6;

	@SideOnly(Side.CLIENT)
	public static boolean isNumpad7;

	@SideOnly(Side.CLIENT)
	public static boolean isNumpad8;

	@SideOnly(Side.CLIENT)
	public static boolean isNumpad9;
	//--------------------------------------------------------------------------------------------------------------
	public ItemSecondaryKey(String tag) {
		super(tag);
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onNumpad0TickClient(EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onNumpad0.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onNumpad0Client(EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onNumpad0(EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onNumpad1TickClient(EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onNumpad1.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onNumpad1Client(EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onNumpad1(EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onNumpad2TickClient(EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onNumpad2.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onNumpad2Client(EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onNumpad2(EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onNumpad3TickClient(EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onNumpad3.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onNumpad3Client(EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onNumpad3(EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onNumpad4TickClient(EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onNumpad4.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onNumpad4Client(EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onNumpad4(EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onNumpad5TickClient(EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onNumpad5.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onNumpad5Client(EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onNumpad5(EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onNumpad6TickClient(EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onNumpad6.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onNumpad6Client(EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onNumpad6(EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onNumpad7TickClient(EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onNumpad7.
	 * @param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onNumpad7Client(EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onNumpad7(EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onNumpad8TickClient(EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onNumpad8.**/
	@SideOnly(Side.CLIENT)
	public boolean onNumpad8Client(EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onNumpad8(EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onNumpad9TickClient(EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onNumpad9.**/
	@SideOnly(Side.CLIENT)
	public boolean onNumpad9Client(EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onNumpad9(EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
}