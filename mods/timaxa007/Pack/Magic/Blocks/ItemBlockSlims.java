package mods.timaxa007.Pack.Magic.Blocks;

import java.util.List;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Lib.Option;
import mods.timaxa007.Pack.Magic.PackMagic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemMultiTextureTile;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.input.Keyboard;

public class ItemBlockSlims extends ItemMultiTextureTile{
public ItemBlockSlims(int id) {
super(id, PackMagic.proxy.blockSlims, GetColors.getNameColors);
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
list.add(Option.getText("Material")+": "+Option.getText("Stone")+".");
list.add(Option.getText("Type")+": "+Option.getText("Magic")+".");
list.add(Option.getText("Color")+": "+Option.GetColors(is.getItemDamage(), "a")+".");
	if(tag!=null) {
	list.add(Option.getText("Tag")+": "+tag.getString("Color")+".");
	}else{;}
}else{
list.add(Option.prshift);
}
}

}