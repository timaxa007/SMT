package mods.timaxa007.pack.mining.blocks;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockRockCB extends ItemMultiTextureTile{
public ItemBlockRockCB(int id) {
super(id, PackMining.proxy.blockRock, BlockRockCB.rockType);
}

}