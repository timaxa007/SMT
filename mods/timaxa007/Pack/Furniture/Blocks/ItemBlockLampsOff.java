package mods.timaxa007.Pack.Furniture.Blocks;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockLampsOff extends ItemMultiTextureTile{
public ItemBlockLampsOff(int id) {
super(id, PackFurniture.proxy.block_lamps_off, GetColors.getNameColors);
}

}