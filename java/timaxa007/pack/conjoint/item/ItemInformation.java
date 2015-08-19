package timaxa007.pack.conjoint.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.gui.HandlerGui;
import timaxa007.gui.HandlerGuiSMT;
import timaxa007.module.control_button.api.IActionMouse;
import timaxa007.pack.conjoint.PackConjoint;
import timaxa007.pack.conjoint.api.ISeeLook;
import timaxa007.pack.conjoint.object.ModifiedItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemInformation extends ModifiedItem implements ISeeLook, IActionMouse {
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT) public static boolean isLeftClick;
	@SideOnly(Side.CLIENT) public static boolean isRightClick;
	//--------------------------------------------------------------------------------------------------------------
	public ItemInformation(String tag) {
		super(tag);
		setCreativeTab(PackConjoint.tab_conjoint);
	}

	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onLeftClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isLeftClick = isPress;
		//if (!isLeftClick) HandlerGuiSMT.openGui(HandlerGuiSMT.GuiID.INFO_BOOK_CREATIVE, player, true);
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onRightClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isRightClick = isPress;
		if (!isRightClick) HandlerGuiSMT.openGui(HandlerGuiSMT.GuiID.INFO_BOOK, player/*, true*/);
	}
	//--------------------------------------------------------------------------------------------------------------
	public boolean onEntitySwing(EntityLivingBase entity, ItemStack is) {return true;}
	public boolean onLeftClickEntity(ItemStack is, EntityPlayer player, Entity entity) {return true;}
	//--------------------------------------------------------------------------------------------------------------
}