package mods.timaxa007.pack.furniture.items;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPaintCan extends Item{
@SideOnly(Side.CLIENT) private IIcon iconArray;
@SideOnly(Side.CLIENT) private IIcon theIIcon;
public static final String[] paintCanColorType=new String[]{
"PaintCanBlack", 
"PaintCanBlue", 
"PaintCanBrown", 
"PaintCanCyan", 
"PaintCanGray", 
"PaintCanGreen", 
"PaintCanLightBlue", 
"PaintCanLightGray", 
"PaintCanLightGreen", 
"PaintCanMagenta", 
"PaintCanOrange", 
"PaintCanPink", 
"PaintCanPurple", 
"PaintCanRed", 
"PaintCanWhite", 
"PaintCanYellow"
};

public ItemPaintCan() {
super();
this.setMaxStackSize(1);
this.setMaxDamage(15);
this.setCreativeTab(PackMining.proxy.tab_tools_pack);
this.setUnlocalizedName("ItemPaintCan");
}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if(tag != null) {
int i=MathHelper.clamp_int(tag.getInteger("Color"), 0, (paintCanColorType.length-1));
return super.getUnlocalizedName()+"."+paintCanColorType[i];
}else{
return super.getUnlocalizedName();
}
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
	if(tag!=null) {
	list.add(Option.getText("Color")+": "+Option.GetColors(tag.getInteger("Color"), "a")+".");
	}else{
	list.add(Option.getText("Color")+": Empty.");
	}
list.add(Option.getText("Type")+": Tool / Brush.");
}else{
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(addTag(new ItemStack(PackFurniture.proxy.item_paint_can), j));}
list.add(new ItemStack(PackFurniture.proxy.item_paint_can, 1, 0));
}

private static ItemStack addTag(ItemStack par1, int par2) {
ItemStack is=par1;
NBTTagCompound tag=new NBTTagCompound();
tag.setInteger("Color", par2);
//tag.setInteger("HexColor", GetColors.getHexColors[par2]);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamage(int par1) {return this.iconArray;}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int renderPass) {
NBTTagCompound tag = is.getTagCompound();
if(renderPass==0) {
return 16777215;
}else{

if(tag==null) {return 16777215;}
else{return GetColors.getHexColors[tag.getInteger("Color")];}

}
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
return par2 > 0 ? (par2==0 ? this.iconArray : this.theIIcon) : super.getIconFromDamageForRenderPass(par1, par2);
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
this.theIIcon=ir.registerIcon("timaxa007:"+"colors/"+"paint_can"+"_overlay");
this.iconArray=ir.registerIcon("timaxa007:"+"colors/"+"paint_can");
}

}
