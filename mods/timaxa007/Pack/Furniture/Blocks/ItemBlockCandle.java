package mods.timaxa007.Pack.Furniture.Blocks;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockCandle extends ItemMultiTextureTile{
public ItemBlockCandle(int id) {
super(id, PackFurniture.proxy.block_candle, GetColors.getNameColors);
}

}