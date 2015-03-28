package timaxa007.module.control_button.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IActionArmor {
	//--------------------------------------------------------------------------------------------------------------
	/**@param is - ItemStack is taken from player's active slot helmet,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param tick - How much tickes passed from the time you press the button, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onHelmetTickClient(ItemStack is, World world, EntityPlayer player, int tick);

	/**@param is - ItemStack is taken from player's active slot helmet,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onHelmetClient(ItemStack is, World world, EntityPlayer player, boolean isPress);
	//--------------------------------------------------------------------------------------------------------------
	/**@param is - ItemStack is taken from player's active slot chestplate,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param tick - How much tickes passed from the time you press the button, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onChestplateTickClient(ItemStack is, World world, EntityPlayer player, int tick);

	/**@param is - ItemStack is taken from player's active slot chestplate,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onChestplateClient(ItemStack is, World world, EntityPlayer player, boolean isPress);
	//--------------------------------------------------------------------------------------------------------------
	/**@param is - ItemStack is taken from player's active slot leggings,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param tick - How much tickes passed from the time you press the button, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onLeggingsTickClient(ItemStack is, World world, EntityPlayer player, int tick);

	/**@param is - ItemStack is taken from player's active slot leggings,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onLeggingsClient(ItemStack is, World world, EntityPlayer player, boolean isPress);
	//--------------------------------------------------------------------------------------------------------------
	/**@param is - ItemStack is taken from player's active slot boots,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param tick - How much tickes passed from the time you press the button, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onBootsTickClient(ItemStack is, World world, EntityPlayer player, int tick);

	/**@param is - ItemStack is taken from player's active slot boots,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public void onBootsClient(ItemStack is, World world, EntityPlayer player, boolean isPress);
	//--------------------------------------------------------------------------------------------------------------
}
