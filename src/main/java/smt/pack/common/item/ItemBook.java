package smt.pack.common.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import smt.pack.common.SMTCommon;
import smt.pack.common.client.gui.*;
import smt.pack.common.client.gui.creating_gui.CreatingGuiGui;

import java.util.HashMap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBook extends Item implements smt.pack.common.api.IRegisterItem {

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		Minecraft mc = Minecraft.getMinecraft();
		mc.displayGuiScreen(new CreatingGuiGui());
		//mc.displayGuiScreen(new BookGui(null));
		//mc.displayGuiScreen(new ProgressGUI(player));
		return super.onItemRightClick(itemStack, world, player);
	}

	@Override
	public String getRegisterName() {
		return "item_book";
	}

	@Override
	public void getRegisterItem(final HashMap<String, ItemStack> map) {
		map.put(getRegisterName(), new ItemStack(this));
	}

}
