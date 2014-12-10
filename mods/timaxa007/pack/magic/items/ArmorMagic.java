package mods.timaxa007.pack.magic.items;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.pack.magic.ProxyClient;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorMagic extends ItemArmor{

public ArmorMagic(int id, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
super(par2EnumArmorMaterial, par3, par4);
this.setCreativeTab(PackMagic.proxy.tabMagicPack);
}
/*
public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {
ItemStack helmet=player.getCurrentArmor(3);
ItemStack chestplate=player.getCurrentArmor(2);
ItemStack leggings=player.getCurrentArmor(1);
ItemStack boots=player.getCurrentArmor(0);
//helmet != null

if(this.itemID==PackArmor.testChest.itemID) {

if(
(helmet!=null)&&(helmet.itemID==PackArmor.testHelmet.itemID)
&&(chestplate!=null)&&(chestplate.itemID==PackArmor.testChest.itemID)
&&(leggings!=null)&&(leggings.itemID==PackArmor.testLeggin.itemID)
&&(boots!=null)&&(boots.itemID==PackArmor.testBoot.itemID)
) {
if(player.isAirBorne) {
//if((player.isJumping)&(!player.isInWater())) {player.motionY+=0.1D;}
//if(player.isSneaking()) {player.motionY=-0.1D;player.setMoveForward(1.0F);}
if(player.isSprinting()) {
//player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1, 5));
if((player.motionX<0.6D)&(player.motionX>-0.6D)) {player.motionX*=1.1D;}
if((player.motionZ<0.6D)&(player.motionZ>-0.6D)) {player.motionZ*=1.1D;}
}
}

if(player.onGround) {
if(player.isSprinting()) {
//player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1, 5));
if((player.motionX<2.7D)&(player.motionX>-2.7D)) {player.motionX*=1.5D;}
if((player.motionZ<2.7D)&(player.motionZ>-2.7D)) {player.motionZ*=1.5D;}
}
//player.noClip=true;
;
}
player.fallDistance=player.fallDistance-0.1F;
}else{}

}

}
*/
/*
@SideOnly(Side.CLIENT)
public ModelBiped getArmorModel(EntityLivingBase el, ItemStack is, int armorSlot) {
return null;
}
*/
/*
@SideOnly(Side.CLIENT)
public ModelBiped getArmorModel(EntityLivingBase el, ItemStack is, int as) {
return ProxyClient.renderTestArmorModelID;
}
*/
public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
return "timaxa007:textures/armor/arrmor_t.png";
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
if(this.itemID==PackMagic.proxy.armorMagicHelmet.itemID) {this.itemIIcon=ir.registerIcon("timaxa007:"+"armor/"+"armorMagicHelmet");}
else if(this.itemID==PackMagic.proxy.armorMagicChest.itemID) {this.itemIIcon=ir.registerIcon("timaxa007:"+"armor/"+"armorMagicChest");}
else if(this.itemID==PackMagic.proxy.armorMagicLeggin.itemID) {this.itemIIcon=ir.registerIcon("timaxa007:"+"armor/"+"armorMagicLeggin");}
else if(this.itemID==PackMagic.proxy.armorMagicBoot.itemID) {this.itemIIcon=ir.registerIcon("timaxa007:"+"armor/"+"armorMagicBoots");}
else{this.itemIIcon=ir.registerIcon("timaxa007:"+"testItem");}
}

}