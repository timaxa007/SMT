package mods.timaxa007.pack.furniture.item;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.lib.ActionModel;
import mods.timaxa007.tms.util.ModifiedItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemsFurniture extends ModifiedItem {

	public ItemsFurniture(String tag) {
		super(tag);
		setCreativeTab(PackFurniture.tab_furniture);
		setTextureName("timaxa007:icon/furniture");
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		if (!world.isRemote) player.addChatMessage(new ChatComponentText("F - " + ActionModel.rotation_model_8sides_invert(player)));
		return is;
	}

}
