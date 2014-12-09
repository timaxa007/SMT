package mods.timaxa007.Pack.Mining.Blocks;

import mods.timaxa007.Pack.Mining.PackMining;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockSandCB extends ItemMultiTextureTile{
public ItemBlockSandCB(int id) {
super(id, PackMining.proxy.blockSand, BlockSandCB.sandType);
}

}