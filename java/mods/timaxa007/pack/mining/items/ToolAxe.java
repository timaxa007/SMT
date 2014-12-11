package mods.timaxa007.pack.mining.items;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolAxe extends Item{
@SideOnly(Side.CLIENT) private IIcon iconArray;
@SideOnly(Side.CLIENT) private IIcon theIIcon;

//private final EnumToolMaterial toolMaterial;

public ToolAxe() {
super();
//toolMaterial=EnumToolMaterial.IRON;
maxStackSize=1;
setMaxDamage(ToolMaterial.IRON.getMaxUses());
setCreativeTab(PackMining.proxy.tabToolsPack);
setUnlocalizedName("tool.axe");
}

public float getStrVsBlock(ItemStack is, Block blk) {
if(blk==Blocks.web) {
return 15.0F;
}else if(blk==Blocks.stonebrick) {
return 5.0F;
}else{
Material material=blk.getMaterial();
return material!=Material.plants&&material!=Material.vine&&material!=Material.coral&& material!=Material.leaves&&material!=Material.gourd?1.0F:1.5F;
}
}

public boolean hitEntity(ItemStack is, EntityLivingBase entity1, EntityLivingBase entity2) {
is.damageItem(1, entity2);
return true;
}
/*
public boolean onBlockDestroyed(ItemStack is, World wrd, int par3, int x, int y, int z, EntityLivingBase entity) {
if((double)Block.blocksList[par3].getBlockHardness(wrd, x, y, z)!=0.0D) {
is.damageItem((int)(Block.blocksList[par3].getBlockHardness(wrd, x, y, z)*10), entity);
return true;
}else{
//is.damageItem(1, entity);
return false;
}
//return false;
}
*/
@SideOnly(Side.CLIENT)
public boolean isFull3D() {return true;}

public EnumAction getItemUseAction(ItemStack is) {return EnumAction.block;}

public int getMaxItemUseDuration(ItemStack is) {return 72000;}

public ItemStack onItemRightClick(ItemStack is, World wrd, EntityPlayer player) {
player.setItemInUse(is, getMaxItemUseDuration(is));
return is;
}

public boolean canHarvestBlock(Block blk) {
if(blk==Blocks.web) {return true;}
if(blk==Blocks.stonebrick) {return true;}
return false;
}

public int getItemEnchantability() {
return 10;
}
/*
public String getToolMaterialName() {
return "none";
}
*/
/*
public boolean getIsRepairable(ItemStack is1, ItemStack is2) {
return toolMaterial.getToolCraftingMaterial()==is2.getItem()?true:super.getIsRepairable(is1, is2);
}
*/
/*
public Multimap getItemAttributeModifiers() {
Multimap multimap=super.getItemAttributeModifiers();
multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Modifier", (double)6.0F, 0));
return multimap;
}
*/
public int getMaxDamage(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if(tag!=null&&tag.hasKey("Color")) {
return ((tag.getInteger("Color")+1)*100);
}else{
return getMaxDamage();
}
//return getMaxDamage();
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)||Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
if(tag!=null) {
if(tag.hasKey("Color")) {list.add(Option.getText("Material")+": "+Option.GetColors(tag.getInteger("Color"), "a")+".");}
}
list.add(Option.getText("Type")+": Tool / Hammer.");
}else{
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(addTag(j));}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is=new ItemStack(PackMining.proxy.toolAxe);
NBTTagCompound tag=new NBTTagCompound();
tag.setInteger("Color", par1);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamage(int par1) {return iconArray;}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int renderPass) {
NBTTagCompound tag = is.getTagCompound();
if(renderPass==0) {
return 16777215;
}else{

if(tag==null) {
return 16777215;
}else{
return GetColors.getHexColors[tag.getInteger("Color")];
}

}
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
return par2>0?(par2==0?iconArray:theIIcon):super.getIconFromDamageForRenderPass(par1, par2);
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
theIIcon=ir.registerIcon("timaxa007:"+"tool/"+"axeMetals_overlay");
iconArray=ir.registerIcon("timaxa007:"+"tool/"+"axeHandle");
}


}