package timaxa007.smt;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Dragon2488 on 18.12.2014.
 */
public class BaseTab extends CreativeTabs {

boolean hasSearch = true;
boolean hasEffect = false;
Item display = null;
int displayMeta = 0;
ItemStack displayItemStack =null;


public BaseTab(String lable1, Item display1, int displayMeta1, boolean hasEffect1, boolean hasSearch1) {
super(lable1);
hasEffect = hasEffect1;
display = display1;
displayMeta = displayMeta1;
hasSearch = hasSearch1;
}

public BaseTab(String lable1, ItemStack displayItemStack1, boolean hasEffect1, boolean hasSearch1) {
super(lable1);
displayItemStack = displayItemStack1;
display = displayItemStack.getItem();
displayMeta = displayItemStack.getItemDamage();
hasEffect = hasEffect1;
hasSearch = hasSearch1;
}

@Override
public Item getTabIconItem() {
return display;
}

public boolean hasEffect() {
return hasEffect;
}

public int getTabIconItemMetadata() {
return displayMeta;
}

@Override
public ItemStack getIconItemStack() {
if(displayItemStack == null) {
displayItemStack = new ItemStack(getTabIconItem(), 1, getTabIconItemMetadata());
}
if(hasEffect()) displayItemStack.addEnchantment(Enchantment.flame, 1);
return displayItemStack;
}

@Override
public boolean hasSearchBar() {
return hasSearch;
}

@Override
public boolean shouldHidePlayerInventory() {
return false;
}
}

