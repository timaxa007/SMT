package mods.timaxa007.Pack.Furniture.Blocks;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockLampsOffInvert extends ItemMultiTextureTile{
public ItemBlockLampsOffInvert(int id) {
super(id, PackFurniture.proxy.block_lamps_off_invert, GetColors.getNameColors);
}

}