package mods.timaxa007.Pack.Stock.Blocks;

import mods.timaxa007.Pack.Stock.PackStock;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockHealing extends ItemMultiTextureTile{
public ItemBlockHealing(int id) {
super(id, PackStock.proxy.block_healing, BlockHealing.healingTypes);
}

}
