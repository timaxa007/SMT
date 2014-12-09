package mods.timaxa007.Pack.Furniture.Blocks;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockLampsOnInvert extends ItemMultiTextureTile{
public ItemBlockLampsOnInvert(int id) {
super(id, PackFurniture.proxy.block_lamps_on_invert, GetColors.getNameColors);
}

}
