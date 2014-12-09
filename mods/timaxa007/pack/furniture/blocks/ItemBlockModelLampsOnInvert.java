package mods.timaxa007.pack.furniture.blocks;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockModelLampsOnInvert extends ItemMultiTextureTile{
public ItemBlockModelLampsOnInvert(int id) {
super(id, PackFurniture.proxy.block_model_lamps_on_invert, GetColors.getNameColors);
}

}
