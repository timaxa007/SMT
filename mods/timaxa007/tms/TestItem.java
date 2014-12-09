package mods.timaxa007.tms;

import net.minecraft.item.Item;

public class TestItem extends Item {
public TestItem(int id) {
super(id);
this.setCreativeTab(Core.tabTMS);
this.setTextureName("timaxa007:" + "testItem");
this.setUnlocalizedName("item_test");
}

}
