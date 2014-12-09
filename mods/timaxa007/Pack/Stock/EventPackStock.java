package mods.timaxa007.Pack.Stock;

import mods.timaxa007.Pack.Stock.Items.ItemsStock;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class EventPackStock {

@ForgeSubscribe
public void onUseBonemeal(BonemealEvent event) {
/*
if (event.ID==PackStock.proxy.blockSapling1.blockID) {
if (!event.world.isRemote) {
((BlockSapling1)PackStock.proxy.blockSapling1).onTreeUp(event.world, event.X, event.Y, event.Z);
}
event.setResult(Result.ALLOW);
}
*/
}

@ForgeSubscribe
public void onUpdate(LivingUpdateEvent p) {
if (p.entityLiving instanceof EntityPlayer) {

for (int i = 0; i < ((EntityPlayer)p.entityLiving).inventory.mainInventory.length; i++) {
if (((EntityPlayer)p.entityLiving).inventory.mainInventory[i] != null && ((EntityPlayer)p.entityLiving).inventory.mainInventory[i].getItem() instanceof ItemsStock) {

if (((EntityPlayer)p.entityLiving).getActivePotionEffect(Potion.nightVision) != null) {
//((EntityPlayer)p.entityLiving).removePotionEffect(Potion.nightVision.id);
} else {
((EntityPlayer)p.entityLiving).addPotionEffect(new PotionEffect(Potion.nightVision.id, 20, 3));
}
break;
}
}

}
}

public static double rand;

@ForgeSubscribe
public void onEntityDrop(LivingDropsEvent event) {
if (event.source.getDamageType().equals("player")) {
rand = Math.random();
if(event.entityLiving instanceof EntityZombie) {

if (rand >= 0.0D && rand <= 0.25D) {
event.entityLiving.entityDropItem(new ItemStack(Item.stick.itemID, 1, 0), 0.0F);
}

if (rand >= 0.26D && rand <= 0.5D) {
event.entityLiving.entityDropItem(new ItemStack(Item.bone.itemID, 1, 0), 0.0F);
}

if (rand >= 0.51D && rand <= 0.60D) {
event.entityLiving.entityDropItem(new ItemStack(Item.leather.itemID, 1, 0), 0.0F);
}

}
}
}

@ForgeSubscribe
public void addNewBucket(FillBucketEvent event) {
if (event.current.getItem() == Item.bucketEmpty) {
if (event.world.getBlockId(event.target.blockX, event.target.blockY, event.target.blockZ) == Block.stone.blockID) {
event.result = new ItemStack(PackStock.proxy.item_drinks, 1, 0);
event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
event.setResult(Result.ALLOW);
}
}
}

@ForgeSubscribe
public void addNewBottle(PlayerInteractEvent event) {
EntityPlayer player = event.entityPlayer;
World world = player.worldObj;
ItemStack current = player.getCurrentEquippedItem();
if (player != null && world != null && event.action == event.action.RIGHT_CLICK_BLOCK) {
if (current != null && current.getItem() == Item.glassBottle && world.getBlockId(event.x, event.y, event.z) == Block.stone.blockID) {
--current.stackSize;
player.inventory.addItemStackToInventory(new ItemStack(PackStock.proxy.item_drinks, 1, 0));
event.setResult(Result.ALLOW);
}
}
}

}
