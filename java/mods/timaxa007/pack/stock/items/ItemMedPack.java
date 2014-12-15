package mods.timaxa007.pack.stock.items;

import mods.timaxa007.pack.stock.PackStock;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMedPack extends Item {

public ItemMedPack() {
super();
setCreativeTab(PackStock.proxy.tab_medical);
setHasSubtypes(true);
setMaxDamage(0);
setMaxStackSize(1);
setTextureName("timaxa007:medpack");
setUnlocalizedName("medpack");
}

public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {
if (!player.capabilities.isCreativeMode) {--is.stackSize;}
if (!world.isRemote) {
//player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(1000.0D);
}
return is;
}

public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
player.setItemInUse(is, getMaxItemUseDuration(is));
world.playSound(player.posX, player.posY, player.posZ, "timaxa007:vodka", 1.0F, 1.0F, true);
return is;
}

public int getMaxItemUseDuration(ItemStack is) {
return 64;
}

public EnumAction getItemUseAction(ItemStack is) {
return EnumAction.block;
}

}
