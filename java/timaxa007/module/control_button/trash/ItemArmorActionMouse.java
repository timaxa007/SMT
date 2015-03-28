package timaxa007.module.control_button.trash;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.module.control_button.api.IActionMouse;
import timaxa007.tms.util.ModifiedItemArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**For example.**/@Deprecated
public class ItemArmorActionMouse extends ModifiedItemArmor implements IActionMouse {
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public static boolean isLeftClick;

	@SideOnly(Side.CLIENT)
	public static boolean isRightClick;
	//--------------------------------------------------------------------------------------------------------------
	public ItemArmorActionMouse(String tag, ItemArmor.ArmorMaterial material, int render_id, int armor_type) {
		super(tag, material, render_id, armor_type);
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onLeftClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isLeftClick = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onRightClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isRightClick = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
}
