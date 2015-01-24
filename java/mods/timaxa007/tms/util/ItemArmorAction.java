package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorAction extends ItemArmorActionMouse {
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public static boolean isHelmet;

	@SideOnly(Side.CLIENT)
	public static boolean isChestplate;

	@SideOnly(Side.CLIENT)
	public static boolean isLeggings;

	@SideOnly(Side.CLIENT)
	public static boolean isBoots;
	//--------------------------------------------------------------------------------------------------------------
	public ItemArmorAction(String tag, ItemArmor.ArmorMaterial material, int render_id, int armor_type) {
		super(tag, material, render_id, armor_type);
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onHelmetTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onHelmet.
	 * @param is - ItemStack is taken from player's active slot helmet,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onHelmetClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onHelmet(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onChestplateTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onChestplate.
	 * @param is - ItemStack is taken from player's active slot chestplate,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onChestplateClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onChestplate(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onLeggingsTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onLeggings.
	 * @param is - ItemStack is taken from player's active slot leggings,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onLeggingsClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onLeggings(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onBootsTickClient(ItemStack is, World world, EntityPlayer player) {

	}

	/**@return <b>true</b> send network for work method this.onBoots.
	 * @param is - ItemStack is taken from player's active slot boots,
	 * @param world - player.worldObj,
	 * @param player - EntityPlayer which uses this <b>is</b>,
	 * @param isPress - button is pressed, setting set of keyBinds,
	 **/
	@SideOnly(Side.CLIENT)
	public boolean onBootsClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		return false;
	}

	public void onBoots(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}
	//--------------------------------------------------------------------------------------------------------------
}
