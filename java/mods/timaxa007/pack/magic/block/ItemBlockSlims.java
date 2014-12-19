package mods.timaxa007.pack.magic.block;

import java.util.List;

import mods.timaxa007.lib.Option;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.lwjgl.input.Keyboard;

public class ItemBlockSlims extends ItemBlock {
	public ItemBlockSlims(Block id) {
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			list.add(Option.getText("Material") + ": " + Option.getText("Stone") + ".");
			list.add(Option.getText("Type") + ": " + Option.getText("Magic") + ".");
			list.add(Option.getText("Color") + ": " + Option.GetColors(is.getItemDamage(), "a") + ".");
			if (tag != null) {
				if (tag.hasKey("Color"))
					list.add(Option.getText("Tag") + ": " + tag.getString("Color") + ".");
			}
		} else {
			list.add(Option.prshift);
		}
	}

}