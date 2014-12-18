package mods.timaxa007.pack.furniture.common.blocks;

import java.util.List;

import mods.timaxa007.lib.Option;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.lwjgl.input.Keyboard;

public class ItemBlockClothBlocks extends ItemBlock {

	public ItemBlockClothBlocks(Block id) {
		super(id);
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("SubID")) {
			return super.getUnlocalizedName() + "." + BlockClothBlocks.type_block[tag.getByte("SubID")];
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {

				if (tag.hasKey("SubID")) list.add("SubID: " + tag.getByte("SubID") + ".");

				if (tag.hasKey("ColorBlock")) {
					int clr = tag.getInteger("ColorBlock");
					int r = (int)(clr >> 16 & 255);int g = (int)(clr >> 8 & 255);int b = (int)(clr >> 0 & 255);
					list.add(Option.getText("Color") + ": R - " + r + ", G - " + g + ", B - " + b + ".");
				}

			}
		} else {
			list.add(Option.prshift);
		}
	}

}
