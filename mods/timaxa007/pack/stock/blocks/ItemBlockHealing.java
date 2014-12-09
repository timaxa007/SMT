package mods.timaxa007.pack.stock.blocks;

import mods.timaxa007.pack.stock.PackStock;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockHealing extends ItemMultiTextureTile{
public ItemBlockHealing(int id) {
super(id, PackStock.proxy.block_healing, BlockHealing.healingTypes);
}

}
