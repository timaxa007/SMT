package mods.timaxa007.pack.mining.blocks;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;

public class ItemBlockEarthCB extends ItemMultiTexture {

public ItemBlockEarthCB(Block id) {
super(id, PackMining.proxy.blockEarth, BlockEarthCB.earthType);
}

}