package mods.timaxa007.pack.furniture.items;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.item.Item;

public class ItemsFurniture extends Item {

public ItemsFurniture(int id) {
super(id);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setUnlocalizedName("items_furniture");
}

}
