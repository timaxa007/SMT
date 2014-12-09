package mods.timaxa007.Pack.Magic.Blocks;

import mods.timaxa007.Pack.Magic.PackMagic;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemOreElements extends ItemMultiTextureTile{
public ItemOreElements(int id) {
super(id, PackMagic.proxy.oreElements, OreElements.elementsNames);
}

}