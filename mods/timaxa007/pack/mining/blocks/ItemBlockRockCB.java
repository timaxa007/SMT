package mods.timaxa007.pack.mining.blocks;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;

public class ItemBlockRockCB extends ItemMultiTexture {

public ItemBlockRockCB(Block id) {
super(id, PackMining.proxy.blockRock, BlockRockCB.rockType);
}

}