package mods.timaxa007.Pack.Mining.Items;

import java.util.List;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Lib.Option;
import mods.timaxa007.Pack.Mining.PackMining;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolHammer extends Item{
@SideOnly(Side.CLIENT) private Icon iconArray;
@SideOnly(Side.CLIENT) private Icon theIcon;

//private final EnumToolMaterial toolMaterial;

public ToolHammer(int id) {
super(id);
//this.toolMaterial=EnumToolMaterial.IRON;
this.maxStackSize=1;
this.setMaxDamage(EnumToolMaterial.IRON.getMaxUses());
this.setCreativeTab(PackMining.proxy.tabToolsPack);
this.setUnlocalizedName("tool.hammer");
}

public float getStrVsBlock(ItemStack is, Block blk) {
if(blk.blockID==Block.web.blockID) {
return 15.0F;
}else if(blk.blockID==Block.stoneBrick.blockID) {
return 5.0F;
}else{
Material material=blk.blockMaterial;
return material!=Material.plants&&material!=Material.vine&&material!=Material.coral&& material!=Material.leaves&&material!=Material.pumpkin?1.0F:1.5F;
}
}

public boolean hitEntity(ItemStack is, EntityLivingBase entity1, EntityLivingBase entity2) {
is.damageItem(1, entity2);
return true;
}

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

@SideOnly(Side.CLIENT)
public boolean isFull3D() {return true;}

public EnumAction getItemUseAction(ItemStack is) {return EnumAction.block;}

public int getMaxItemUseDuration(ItemStack is) {return 72000;}

public ItemStack onItemRightClick(ItemStack is, World wrd, EntityPlayer player) {
player.setItemInUse(is, this.getMaxItemUseDuration(is));
return is;
}

public boolean canHarvestBlock(Block blk) {
if(blk.blockID==Block.web.blockID) {return true;}
if(blk.blockID==Block.stoneBrick.blockID) {return true;}
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
return this.toolMaterial.getToolCraftingMaterial()==is2.itemID?true:super.getIsRepairable(is1, is2);
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
ItemStack is=new ItemStack(PackMining.proxy.toolHammer);
NBTTagCompound tag=new NBTTagCompound();
tag.setInteger("Color", par1);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public Icon getIconFromDamage(int par1) {return this.iconArray;}

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
public Icon getIconFromDamageForRenderPass(int par1, int par2) {
return par2>0?(par2==0?this.iconArray:this.theIcon):super.getIconFromDamageForRenderPass(par1, par2);
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
super.registerIcons(ir);
this.theIcon=ir.registerIcon("timaxa007:"+"tool/"+"hammer_overlay");
this.iconArray=ir.registerIcon("timaxa007:"+"tool/"+"hammerHandle");
}

}
