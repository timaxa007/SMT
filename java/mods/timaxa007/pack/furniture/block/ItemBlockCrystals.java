package mods.timaxa007.pack.furniture.block;

import java.util.List;

import mods.timaxa007.lib.Option;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

//ItemMultiTextureTile
public class ItemBlockCrystals extends ItemBlock {

	public ItemBlockCrystals(Block id) {
		super(id);
		//super(PackFurniture.blockCrystals, GetColors.getNameColors);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			list.add(Option.getText("Material") + ": Glass.");
			list.add(Option.getText("Type") + ": Crystal.");
			list.add(Option.getText("Color") + ": "+Option.GetColors(is.getItemDamage(), "a") + ".");
		} else list.add(Option.prshift);
	}

}
