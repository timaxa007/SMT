package mods.timaxa007.pack.furniture.block;

import java.util.List;

import mods.timaxa007.lib.Option;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.lwjgl.input.Keyboard;

public class ItemBlockBoxParticles extends ItemBlock {

	public ItemBlockBoxParticles(Block id) {
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {
				if (tag.hasKey("Type")) list.add("Type: " + tag.getInteger("Type") + ".");
			}
		} else {
			list.add(Option.prshift);
		}
	}

}
