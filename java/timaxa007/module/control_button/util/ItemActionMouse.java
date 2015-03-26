package timaxa007.module.control_button.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.tms.util.ModifiedItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemActionMouse extends ModifiedItem {
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public static boolean isLeftClick;

	@SideOnly(Side.CLIENT)
	public static boolean isRightClick;
	//--------------------------------------------------------------------------------------------------------------
	public ItemActionMouse(String tag) {
		super(tag);
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onLeftClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	/**@param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onRightClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	/**@param is - ItemStack is taken from player's active slot hand,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
}
