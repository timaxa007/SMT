package mods.timaxa007.pack.magic.blocks;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;

public class ItemOreElements extends ItemMultiTexture {
public ItemOreElements(Block id) {
super(id, PackMagic.proxy.oreElements, OreElements.elementsNames);
}

}