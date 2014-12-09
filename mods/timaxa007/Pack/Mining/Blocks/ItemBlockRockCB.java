package mods.timaxa007.Pack.Mining.Blocks;

import mods.timaxa007.Pack.Mining.PackMining;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockRockCB extends ItemMultiTextureTile{
public ItemBlockRockCB(int id) {
super(id, PackMining.proxy.blockRock, BlockRockCB.rockType);
}

}