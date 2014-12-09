package mods.timaxa007.Pack.Mining.Blocks;

import mods.timaxa007.Pack.Mining.PackMining;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockEarthCB extends ItemMultiTextureTile{
public ItemBlockEarthCB(int id) {
super(id, PackMining.proxy.blockEarth, BlockEarthCB.earthType);
}

}