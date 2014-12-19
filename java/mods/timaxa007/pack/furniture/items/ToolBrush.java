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
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolBrush extends Item{
@SideOnly(Side.CLIENT) private IIcon iconArray;
@SideOnly(Side.CLIENT) private IIcon theIcon;
public static final String[] brushColorType = new String[]{
"BrushBlack", 
"BrushBlue", 
"BrushBrown", 
"BrushCyan", 
"BrushGray", 
"BrushGreen", 
"BrushLightBlue", 
"BrushLightGray", 
"BrushLightGreen", 
"BrushMagenta", 
"BrushOrange", 
"BrushPink", 
"BrushPurple", 
"BrushRed", 
"BrushWhite", 
"BrushYellow"
};

public ToolBrush() {
super();
setCreativeTab(PackMining.proxy.tab_tools);
setMaxStackSize(1);
setMaxDamage(8);
setTextureName("timaxa007:colors/tool_brush");
setUnlocalizedName("tool_brush");
}

public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
if (!player.canPlayerEdit(x, y, z, meta, is)) {
return false;
}
else {
return false;
}
}

@SideOnly(Side.CLIENT)
public boolean isFull3D() {
return true;
}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null) {
int i = MathHelper.clamp_int(tag.getInteger("Color"), 0, (brushColorType.length-1));
return super.getUnlocalizedName() + "." + brushColorType[i];
} else {
return super.getUnlocalizedName();
}
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
	if (tag != null) {
	list.add(Option.getText("Color")+": "+Option.GetColors(tag.getInteger("Color"), "a")+".");
	} else {
	list.add(Option.getText("Color")+": Empty.");
	}
list.add(Option.getText("Type")+": Tool / Brush.");
} else {
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(Item id, CreativeTabs table, List list) {
for (byte j = 0; j < 16; ++j) {list.add(addTag(j));}
list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackFurniture.proxy.tool_brush, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Color", par1);
//tag.setInteger("HexColor", GetColors.getHexColors[par2]);
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
if (renderPass==0) {
return 16777215;
} else {
if (tag==null) {return 16777215;}
else {return GetColors.getHexColors[tag.getInteger("Color")];}
}
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
return par2>0?(par2==0?iconArray:theIcon):super.getIconFromDamageForRenderPass(par1, par2);
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
itemIcon = ir.registerIcon("timaxa007:colors/tool_brush");
theIcon=ir.registerIcon("timaxa007:"+"colors/"+"tool_brush"+"_overlay");
iconArray=ir.registerIcon("timaxa007:"+"colors/"+"tool_brush");
}

}
