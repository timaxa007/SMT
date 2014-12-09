package mods.timaxa007.pack.magic;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EventMagic {

@ForgeSubscribe
public void onEntityUpdate(LivingUpdateEvent e) {
ItemStack helmet = e.entityLiving.getCurrentItemOrArmor(4);
ItemStack chestplate = e.entityLiving.getCurrentItemOrArmor(3);
ItemStack leggings = e.entityLiving.getCurrentItemOrArmor(2);
ItemStack boots = e.entityLiving.getCurrentItemOrArmor(1);
ItemStack actHBI = e.entityLiving.getCurrentItemOrArmor(0);//active HotBar Item
ItemStack helmetI;
ItemStack chestplateI;
ItemStack leggingsI;
ItemStack bootsI;
if (helmet != null && chestplate != null && leggings != null && boots != null) {
//--------------------------------------------------------------
/*
helmetI=new ItemStack(Item.bootsIron);
chestplateI=new ItemStack(Item.legsIron);
leggingsI=new ItemStack(Item.plateIron);
bootsI=new ItemStack(Item.helmetIron);
if((boots.itemID==helmetI.itemID)&&(leggings.itemID==chestplateI.itemID)&&(chestplate.itemID==leggingsI.itemID)&&(helmet.itemID==bootsI.itemID)) {
float health=e.entityLiving.getHealth();
float baseRegen=0.2F;
float regenStreght=3;
float willRegen=baseRegen*regenStreght;
e.entityLiving.setHealth(health+willRegen);
}
*/
//--------------------------------------------------------------

helmetI = new ItemStack(PackMagic.proxy.armorMagicBoot);
chestplateI = new ItemStack(PackMagic.proxy.armorMagicLeggin);
leggingsI = new ItemStack(PackMagic.proxy.armorMagicChest);
bootsI = new ItemStack(PackMagic.proxy.armorMagicHelmet);
if (boots.itemID == helmetI.itemID && leggings.itemID == chestplateI.itemID && chestplate.itemID == leggingsI.itemID && helmet.itemID == bootsI.itemID) {

if (e.entityLiving.isSneaking()) {

}

if (e.entityLiving.isAirBorne) {

}

if (e.entityLiving.isSprinting()) {
e.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20 * 1, 3));
}

if (e.entityLiving.isEating()) {
e.entityLiving.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20 * 1, 3));
}

e.entityLiving.fallDistance = e.entityLiving.fallDistance-0.1F;
}

//--------------------------------------------------------------

}
}

@ForgeSubscribe
public void onHitEntity(LivingHurtEvent e) {
if (e.source instanceof EntityDamageSource) {

EntityDamageSource dmgSource = (EntityDamageSource) e.source;
Entity ent = dmgSource.getEntity();
if (ent instanceof EntityPlayer) {
/*
Random ran = new Random();
int ran1 = ran.nextInt(100);*/
EntityPlayer player = (EntityPlayer) ent;
ItemStack weapon = player.getCurrentEquippedItem();

if (weapon != null) {
if (weapon.getItem().itemID == Item.swordGold.itemID) {
//e.ammount=100;
}

}
}
}
}

}
