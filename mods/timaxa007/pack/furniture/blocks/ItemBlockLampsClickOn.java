package mods.timaxa007.pack.furniture.blocks;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockLampsClickOn extends ItemMultiTextureTile{
public ItemBlockLampsClickOn(int id) {
super(id, PackFurniture.proxy.block_lamps_click_on, GetColors.getNameColors);
}

}