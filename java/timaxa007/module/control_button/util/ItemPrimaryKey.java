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
	public void onReloadTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	/**@param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onReloadClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onChargeTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	/**@param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onChargeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	/**@param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onModeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onActionTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	/**@param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onActionClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeInTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	/**@param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onModeInClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeOutTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	/**@param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onModeOutClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
}
