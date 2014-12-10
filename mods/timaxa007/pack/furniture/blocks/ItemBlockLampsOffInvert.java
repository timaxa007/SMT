package mods.timaxa007.pack.furniture.blocks;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockLampsOffInvert extends ItemMultiTextureTile{
public ItemBlockLampsOffInvert() {
super(PackFurniture.proxy.block_lamps_off_invert, GetColors.getNameColors);
}

}