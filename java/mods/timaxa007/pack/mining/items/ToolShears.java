package mods.timaxa007.pack.mining.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolShears extends Item{
@SideOnly(Side.CLIENT) private IIcon iconArray;
@SideOnly(Side.CLIENT) private IIcon theIIcon;
public static final String[] shearsType=new String[]{
"Copper", 
"Tin", 
"Iron", 
"Gold", 
"Cassiterite", 
"Galena", 
"Bismuthinite", 
"Garnierite", 
"Malachite", 
"Magnetite", 
"Limonite", 
"Sphalerite", 
"Tetrahedrite", 
"Titanium", 
"Platinum", 
"Wolframium", 

"Onyx", 
"Sapphire", 
"brown", 
"cyan", 
"gray", 
"green", 
"Topaz", 
"Emerald", 
"magenta", 
"Amber", 
"pink", 
"Amethyst", 
"Ruby", 
"LightGray", 
"white", 
"Citrine"
};

public static final int[] shearsHexColors=new int[]{
0xFFFFFF, 	// 0 Copper
0xFFFFFF, 	// 1 Tin
0xFFAA11, 	// 2 Iron
0xFFFF00, 	// 3 Gold
0xFFFFFF, 	// 4 Cassiterite
0xFFFFFF, 	// 5 Galena
0xFFFFFF, 	// 6 Bismuthinite
0xFFFFFF, 	// 7 Garnierite
0xFFFFFF, 	// 8 Malachite
0xFFFFFF, 	// 9 Magnetite
0xFFFFFF, 	//10 Limonite
0xFFFFFF, 	//11 Sphalerite
0xFFFFFF, 	//12 Tetrahedrite
0xAABBFF, 	//13 Titanium
0xFFBB88, 	//14 Platinum
0xFFFFFF, 	//15 Wolframium

0x000000, 	// 0 Black
0x0000FF, 	// 1 Blue
0x884400, 	// 2 Brown
0x008888, 	// 3 Cyan
0x444444, 	// 4 Gray
0x008800, 	// 5 Green
0x00FFFF, 	// 6 LightBlue
0x00FF00, 	// 7 LightGreen
0xFF00FF, 	// 8 Magenta
0xFF8800, 	// 9 Orange
0xFF8888, 	//10 Pink
0x8800FF, 	//11 Purple
0xFF0000, 	//12 Red
0xBBBBBB, 	//13 LightGray
0xFFFFFF, 	//14 White
0xFFFF00	//15 Yellow
};

public ToolShears() {
super();
this.setMaxStackSize(1);
this.setMaxDamage(512);
//this.setCreativeTab(PackMining.tabMiningPack);
this.setCreativeTab(PackMining.proxy.tabToolsPack);
this.setUnlocalizedName("tool.shears");
}

public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase) {
/*if (par3 != Blocks.leaves && par3 != Blocks.web && par3 != Blocks.tallgrass && par3 != Blocks.vine && par3 != Blocks.tripWire && !(Blocks.blocksList[par3] instanceof IShearable)) {
return super.onBlockDestroyed(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLivingBase);
}
else{*/
return true;
//}
}
/*
public boolean canHarvestBlock(Block par1Block) {
return par1Block==Blocks.web || par1Block==Blocks.redstone_wire || par1Block==Blocks.trip_wire;
}

public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
return par2Block != Blocks.web && par2Block != Blocks.leaves ? (par2Block==Blocks.wool ? 5.0F : super.getStrVsBlock(par1ItemStack, par2Block)) : 15.0F;
}
*/
@Override
public boolean itemInteractionForEntity(ItemStack is, EntityPlayer player, EntityLivingBase entity) {
if(entity.worldObj.isRemote) {return false;}
if(entity instanceof IShearable) {
IShearable target=(IShearable)entity;
if(target.isShearable(is, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ)) {
ArrayList<ItemStack> drops=target.onSheared(is, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ, 
EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, is));

Random rand=new Random();
for(ItemStack stack : drops) {
EntityItem ent=entity.entityDropItem(stack, 1.0F);
ent.motionY += rand.nextFloat() * 0.05F;
ent.motionX += (rand.nextFloat()-rand.nextFloat()) * 0.1F;
ent.motionZ += (rand.nextFloat()-rand.nextFloat()) * 0.1F;
}
is.damageItem(1, entity);
}
return true;
}
return false;
}
/*
@Override
public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
if(player.worldObj.isRemote) {return false;}
int id=player.worldObj.getBlock(x, y, z);
if(Block.blocksList[id] instanceof IShearable) {
IShearable target=(IShearable)Block.blocksList[id];
if(target.isShearable(itemstack, player.worldObj, x, y, z)) {
ArrayList<ItemStack> drops=target.onSheared(itemstack, player.worldObj, x, y, z, 
EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
Random rand=new Random();

for(ItemStack stack : drops) {
float f=0.7F;
double d =(double)(rand.nextFloat() * f)+(double)(1.0F-f) * 0.5D;
double d1=(double)(rand.nextFloat() * f)+(double)(1.0F-f) * 0.5D;
double d2=(double)(rand.nextFloat() * f)+(double)(1.0F-f) * 0.5D;
EntityItem entityitem=new EntityItem(player.worldObj, (double)x+d, (double)y+d1, (double)z+d2, stack);
entityitem.delayBeforeCanPickup=10;
player.worldObj.spawnEntityInWorld(entityitem);
}

itemstack.damageItem(1, player);
player.addStat(StatList.mineBlockStatArray[id], 1);
}
}
return false;
}
*/
public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if(tag != null) {
int i=MathHelper.clamp_int(tag.getInteger("Color"), 0, (shearsType.length-1));
return super.getUnlocalizedName()+"."+shearsType[i];
}else{
return super.getUnlocalizedName();
}
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
	if(tag!=null) {
	list.add(Option.getText("Material")+": "+shearsType[tag.getInteger("Color")]+".");
	}else{
	list.add(Option.getText("Material")+": Error.");
	}
list.add(Option.getText("Type")+": Tool / Shears.");
}else{
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for(byte j=0;j<32;++j) {
list.add(addTag(j));
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is=new ItemStack(PackMining.proxy.toolShears);
NBTTagCompound tag=new NBTTagCompound();
tag.setInteger("Color", par1);
//tag.setInteger("HexColor", GetColors.getHexColors[par2]);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamage(int par1) {
return this.iconArray;
}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int renderPass) {
NBTTagCompound tag = is.getTagCompound();
if(renderPass==0) {
return 16777215;
}else{
if(tag==null) {return 16777215;}
else{return shearsHexColors[tag.getInteger("Color")];}
}
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
return par2>0?(par2==0?this.iconArray:this.theIIcon):super.getIconFromDamageForRenderPass(par1, par2);
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
this.theIIcon=ir.registerIcon("timaxa007:"+"tool/"+"shears_overlay");
this.iconArray=ir.registerIcon("timaxa007:"+"tool/"+"shears");
}

}
