package timaxa007.module.information;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.gui.HelperGui;
import timaxa007.module.control_button.api.IActionMouse;
import timaxa007.module.information.api.ISeeLook;
import timaxa007.smt.object.ModifiedItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemInformation extends ModifiedItem implements ISeeLook, IActionMouse {
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT) public static boolean isLeftClick;
	@SideOnly(Side.CLIENT) public static boolean isRightClick;
	//--------------------------------------------------------------------------------------------------------------
	public ItemInformation(String tag) {
		super(tag);
		setCreativeTab(CreativeTabs.tabMisc);
	}

	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onLeftClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isLeftClick = isPress;
		if (!isLeftClick) HelperGui.openGui(HelperGui.GuiID.INFO_BOOK, player);
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onRightClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isRightClick = isPress;
		if (!isRightClick) HelperGui.openGui(HelperGui.GuiID.INFO_BOOK, player);
	}
	//--------------------------------------------------------------------------------------------------------------
	public boolean onEntitySwing(EntityLivingBase entity, ItemStack is) {return true;}
	public boolean onLeftClickEntity(ItemStack is, EntityPlayer player, Entity entity) {return true;}
	//--------------------------------------------------------------------------------------------------------------
}
