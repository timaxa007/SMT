package mods.timaxa007.pack.magic.items;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.item.Item;

public class ItemsMagic extends Item {

public ItemsMagic(int id) {
super(id);
setCreativeTab(PackMagic.proxy.tabMagicPack);
setUnlocalizedName("items_magic");
}

}
