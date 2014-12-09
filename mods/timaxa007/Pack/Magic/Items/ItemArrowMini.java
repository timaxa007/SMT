package mods.timaxa007.Pack.Magic.Items;

import mods.timaxa007.Pack.Magic.PackMagic;
import net.minecraft.item.Item;

public class ItemArrowMini extends Item {

public ItemArrowMini(int id) {
super(id);
setCreativeTab(PackMagic.proxy.tabMagicPack);
setTextureName("arrow");
setUnlocalizedName("arrow_mini");
}

}
