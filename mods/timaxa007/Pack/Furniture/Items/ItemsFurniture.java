package mods.timaxa007.Pack.Furniture.Items;

import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.item.Item;

public class ItemsFurniture extends Item {

public ItemsFurniture(int id) {
super(id);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setUnlocalizedName("items_furniture");
}

}
