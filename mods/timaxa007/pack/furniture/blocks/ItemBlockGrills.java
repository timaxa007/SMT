package mods.timaxa007.pack.furniture.blocks;

import java.util.List;

import org.lwjgl.input.Keyboard;

import mods.timaxa007.lib.Option;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

public class ItemBlockGrills extends ItemBlock{

public ItemBlockGrills(int id) {
super(id);
this.setMaxDamage(0);
this.setHasSubtypes(true);
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)||Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
if(tag.hasKey("Type")) {list.add("Type: "+tag.getInteger("Type")+".");}
}else{
list.add(Option.prshift);
}
}

}