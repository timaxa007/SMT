package mods.timaxa007.pack.mining.blocks;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;

public class ItemBlockSandCB extends ItemMultiTexture {

public ItemBlockSandCB(Block id) {
super(id, PackMining.proxy.blockSand, BlockSandCB.sandType);
}

}