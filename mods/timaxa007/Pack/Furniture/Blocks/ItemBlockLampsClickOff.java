package mods.timaxa007.Pack.Furniture.Blocks;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockLampsClickOff extends ItemMultiTextureTile{
public ItemBlockLampsClickOff(int id) {
super(id, PackFurniture.proxy.block_lamps_click_off, GetColors.getNameColors);
}

}