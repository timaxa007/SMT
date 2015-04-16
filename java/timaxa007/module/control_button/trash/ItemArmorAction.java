package timaxa007.module.control_button.trash;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.module.control_button.api.IActionArmor;
import timaxa007.tms.util.ModifiedItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**For example.**/@Deprecated
public class ItemArmorAction extends ModifiedItem implements IActionArmor {
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public static boolean isHelmetBotton;

	@SideOnly(Side.CLIENT)
	public static boolean isChestplateBotton;

	@SideOnly(Side.CLIENT)
	public static boolean isLeggingsBotton;

	@SideOnly(Side.CLIENT)
	public static boolean isBootsBotton;
	//--------------------------------------------------------------------------------------------------------------
	public ItemArmorAction(String tag) {
		super(tag);
	}

	public ItemArmorAction(String tag, ItemArmor.ArmorMaterial material, int render_id, int armor_type) {
		super(tag);
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onHelmetTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onHelmetClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isHelmetBotton = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onChestplateTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onChestplateClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isChestplateBotton = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onLeggingsTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onLeggingsClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isLeggingsBotton = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onBootsTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onBootsClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isBootsBotton = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
}
