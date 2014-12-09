package mods.timaxa007.pack.magic.blocks;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemOreElements extends ItemMultiTextureTile{
public ItemOreElements(int id) {
super(id, PackMagic.proxy.oreElements, OreElements.elementsNames);
}

}