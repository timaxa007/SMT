package mods.timaxa007.pack.stock.block;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.stock.lib.FoodForBlock;
import mods.timaxa007.tms.Core;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.lwjgl.input.Keyboard;

public class ItemBlockFoods extends ItemBlock {

	public ItemBlockFoods(Block id) {
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID"))
			return "food." + FoodForBlock.list[FoodForBlock.getID_tag(tag.getString("NameID"))].getName();
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {
				list.add("Type: " + FoodForBlock.list[FoodForBlock.getID_tag(tag.getString("NameID"))].getType() + ".");
				if (Core.show_tip_info_testing) {
					if (tag.hasKey("NameID")) list.add("Tag: " + tag.getString("NameID") + ".");
					if (tag.hasKey("Color1")) list.add("Color1: " + tag.getInteger("Color1") + ".");
					if (tag.hasKey("Color2")) list.add("Color2: " + tag.getInteger("Color2") + ".");
				}
			}
		} else list.add(Option.prshift);
	}

}
