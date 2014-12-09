package mods.timaxa007.Pack.Furniture.Blocks;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockModelLampsOn extends ItemMultiTextureTile{
public ItemBlockModelLampsOn(int id) {
super(id, PackFurniture.proxy.block_model_lamps_on, GetColors.getNameColors);
}

}
