package mods.timaxa007.pack.furniture.blocks;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockLampsOn extends ItemMultiTextureTile{
public ItemBlockLampsOn(int id) {
super(id, PackFurniture.proxy.block_lamps_on, GetColors.getNameColors);
}

}