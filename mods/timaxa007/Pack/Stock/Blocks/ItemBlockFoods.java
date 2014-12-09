package mods.timaxa007.Pack.Stock.Blocks;

import java.util.List;

import mods.timaxa007.Lib.Option;
import mods.timaxa007.Pack.Stock.Lib.FoodForBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.lwjgl.input.Keyboard;

public class ItemBlockFoods extends ItemBlock {

public ItemBlockFoods(int id) {
super(id);
setMaxDamage(0);
setHasSubtypes(true);
}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("FoodID")) {
return "food." + FoodForBlock.food_list[tag.getInteger("FoodID")].getName();
}
return super.getUnlocalizedName();
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
if (tag != null) {
if (tag.hasKey("FoodID")) {list.add("FoodID: " + tag.getInteger("FoodID") + ".");}
if (tag.hasKey("Type")) {list.add("Type: " + tag.getInteger("Type") + ".");}
if (tag.hasKey("Color1")) {list.add("Color1: " + tag.getInteger("Color1") + ".");}
if (tag.hasKey("Color2")) {list.add("Color2: " + tag.getInteger("Color2") + ".");}
}
} else {
list.add(Option.prshift);
}
}

}
