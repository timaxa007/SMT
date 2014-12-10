package mods.timaxa007.pack.furniture.blocks;

import java.util.List;

import mods.timaxa007.lib.Option;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.input.Keyboard;

//ItemMultiTextureTile
public class ItemBlockCrystals extends ItemBlock{

public ItemBlockCrystals() {
super(id);
//super(PackFurniture.blockCrystals, GetColors.getNameColors);
this.setMaxDamage(0);
this.setHasSubtypes(true);
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)||Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
list.add(Option.getText("Material")+": Glass.");
list.add(Option.getText("Type")+": Crystal.");
list.add(Option.getText("Color")+": "+Option.GetColors(is.getItemDamage(), "a")+".");
}else{
list.add(Option.prshift);
}
}

}
