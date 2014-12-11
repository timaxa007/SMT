package mods.timaxa007.pack.magic.blocks;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.lwjgl.input.Keyboard;

public class ItemBlockSlims extends ItemMultiTexture {
public ItemBlockSlims(Block id) {
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