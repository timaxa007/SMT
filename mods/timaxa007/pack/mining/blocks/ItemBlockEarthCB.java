package mods.timaxa007.pack.mining.blocks;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockEarthCB extends ItemMultiTextureTile{
public ItemBlockEarthCB() {
super(PackMining.proxy.blockEarth, BlockEarthCB.earthType);
}

}