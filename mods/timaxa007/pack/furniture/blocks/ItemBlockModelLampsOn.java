package mods.timaxa007.pack.furniture.blocks;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockModelLampsOn extends ItemMultiTextureTile{
public ItemBlockModelLampsOn(int id) {
super(id, PackFurniture.proxy.block_model_lamps_on, GetColors.getNameColors);
}

}
