package mods.timaxa007.pack.furniture.blocks;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockCandle extends ItemMultiTextureTile{
public ItemBlockCandle(int id) {
super(id, PackFurniture.proxy.block_candle, GetColors.getNameColors);
}

}