package mods.timaxa007.Pack.Weapon.Items;

import mods.timaxa007.Pack.Magic.Entity.EntityArrowMini;
import mods.timaxa007.Pack.Weapon.PackWeapon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MolotovCocktail extends Item {

public MolotovCocktail(int id) {
super(id);
setCreativeTab(PackWeapon.proxy.tabWeaponPack);
setTextureName("timaxa007:item_molotov_cocktail");
setUnlocalizedName("item_molotov_cocktail");
}

public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int par4) {
if (player.capabilities.isCreativeMode || player.inventory.hasItem(Item.flintAndSteel.itemID)) {

if (!player.capabilities.isCreativeMode) {
for (int i = 0; i < player.inventory.mainInventory.length; i++) {
if (player.inventory.mainInventory[i] != null) {

if (player.inventory.getStackInSlot(i).itemID == new ItemStack(Item.flintAndSteel, 1, 0).itemID && player.inventory.getStackInSlot(i).getItemDamage() != player.inventory.getStackInSlot(i).getMaxDamage()) {
player.inventory.setInventorySlotContents(i, new ItemStack(Item.flintAndSteel, 1, player.inventory.getStackInSlot(i).getItemDamage()+1));
--is.stackSize;
break;
}

if (player.inventory.getStackInSlot(i).itemID == new ItemStack(Item.flintAndSteel, 1, 0).itemID && player.inventory.getStackInSlot(i).getItemDamage() == player.inventory.getStackInSlot(i).getMaxDamage()) {
player.inventory.setInventorySlotContents(i, null);
}

}
}
}

EntityArrowMini entityarrow = new EntityArrowMini(world);
world.spawnEntityInWorld(entityarrow);
world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F/(itemRand.nextFloat()*0.4F+1.2F)+0.5F);
}
}

public ItemStack onEaten(ItemStack is, World wrd, EntityPlayer player) {return is;}

public int getMaxItemUseDuration(ItemStack is) {
return 72000;
}

public EnumAction getItemUseAction(ItemStack is) {
return EnumAction.block;
}

public ItemStack onItemRightClick(ItemStack is, World wrd, EntityPlayer player) {
if (player.capabilities.isCreativeMode || player.inventory.hasItem(Item.flintAndSteel.itemID)) {
player.setItemInUse(is, this.getMaxItemUseDuration(is));
}
return is;
}

}
