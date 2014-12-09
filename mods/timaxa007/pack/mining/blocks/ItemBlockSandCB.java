package mods.timaxa007.pack.mining.blocks;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockSandCB extends ItemMultiTextureTile{
public ItemBlockSandCB(int id) {
super(id, PackMining.proxy.blockSand, BlockSandCB.sandType);
}

}