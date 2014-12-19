package mods.timaxa007.pack.furniture.item;

import mods.timaxa007.lib.ActionModel;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class ItemsFurniture extends Item {

public ItemsFurniture() {
super();
setCreativeTab(PackFurniture.tab_furniture);
setUnlocalizedName("items_furniture");
}

public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
if (!world.isRemote) player.addChatMessage(new ChatComponentText("F - " + ActionModel.rotation_model_8sides_invert(player)));
return is;
}

}