package mods.timaxa007.pack.stock.blocks;

import mods.timaxa007.pack.stock.PackStock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;

public class ItemBlockHealing extends ItemMultiTexture {

public ItemBlockHealing(Block id) {
super(id, PackStock.proxy.block_healing, BlockHealing.healingTypes);
}

}
