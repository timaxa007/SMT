package mods.timaxa007.pack.magic.items;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRandomItem extends Item {

public ItemRandomItem() {
super(id);
setHasSubtypes(true);
setMaxDamage(0);
setCreativeTab(PackMagic.proxy.tabMagicPack);
setTextureName("random_items");
setUnlocalizedName("random_items");
}

public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {

ItemStack[] testminmax = new ItemStack[] {
new ItemStack(Item.stick, 1, 0), 
new ItemStack(Item.appleRed, 1, 0), 
new ItemStack(Item.arrow, 1, 0), 
new ItemStack(Item.axeWood, 1, 0), 
new ItemStack(Item.hoeWood, 1, 0), 
new ItemStack(Block.wood, 1, 0), 
new ItemStack(Block.wood, 1, 1), 
new ItemStack(Block.wood, 1, 2), 
new ItemStack(Block.wood, 1, 3), 
new ItemStack(Block.dirt, 1, 0), 
new ItemStack(Item.redstone, 1, 0)
};

for (int i = 0; i <= 1;) {
int isrt = world.rand.nextInt(testminmax.length);
if (world.rand.nextInt(100) == 0) {
player.dropPlayerItem(testminmax[isrt]);
++i;
--is.stackSize;
break;
}
}

return is;
}

}
