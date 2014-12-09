package mods.timaxa007.Pack.Furniture.Items;

import java.util.List;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Lib.Option;
import mods.timaxa007.Pack.Furniture.TE.TEBlockClothBlocks;
import mods.timaxa007.Pack.Furniture.TE.TEBlockGlassBlocks;
import mods.timaxa007.Pack.Furniture.TE.TEBlockGroundBlocks;
import mods.timaxa007.Pack.Furniture.TE.TEBlockMetalBlocks;
import mods.timaxa007.Pack.Furniture.TE.TEBlockRockBlocks;
import mods.timaxa007.Pack.Furniture.TE.TEBlockSandBlocks;
import mods.timaxa007.Pack.Furniture.TE.TEBlockWoodBlocks;
import mods.timaxa007.Pack.Mining.PackMining;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolAirBrush extends Item {

@SideOnly(Side.CLIENT) private Icon[] icon_tex;
@SideOnly(Side.CLIENT) private Icon[] icon_ovl;

public static final String[] airbrush_type = new String[] {
"easy", 
"normal", 
"hard"
};

public static final String[] airbrush_mode = new String[] {
"1:1", 
"1:2", 
"1:4", 
"1:8", 
"1:16", 
"radial"
};
/*
public static final String[] airbrushColorType = new String[] {
"AirBrushBlack", 
"AirBrushBlue", 
"AirBrushBrown", 
"AirBrushCyan", 
"AirBrushGray", 
"AirBrushGreen", 
"AirBrushLightBlue", 
"AirBrushLightGray", 
"AirBrushLightGreen", 
"AirBrushMagenta", 
"AirBrushOrange", 
"AirBrushPink", 
"AirBrushPurple", 
"AirBrushRed", 
"AirBrushWhite", 
"AirBrushYellow"
};
*/
public ToolAirBrush(int id) {
super(id);
setCreativeTab(PackMining.proxy.tabToolsPack);
setMaxStackSize(1);
setMaxDamage(10000);
setTextureName("timaxa007:colors/tool_airbrush");
setUnlocalizedName("tool_airbrush");
}

public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
if (!player.canPlayerEdit(x, y, z, meta, is)) {
return false;
} else {
TileEntity te = world.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("ColorHex2")) {
if (te != null && te instanceof TEBlockRockBlocks) {
((TEBlockRockBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));is.damageItem(1, player);return true;
} else if (te != null && te instanceof TEBlockGlassBlocks) {
((TEBlockGlassBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));is.damageItem(1, player);return true;
} else if (te != null && te instanceof TEBlockWoodBlocks) {
((TEBlockWoodBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));is.damageItem(1, player);return true;
} else if (te != null && te instanceof TEBlockGroundBlocks) {
((TEBlockGroundBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));is.damageItem(1, player);return true;
} else if (te != null && te instanceof TEBlockSandBlocks) {
((TEBlockSandBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));is.damageItem(1, player);return true;
} else if (te != null && te instanceof TEBlockClothBlocks) {
((TEBlockClothBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));is.damageItem(1, player);return true;
} else if (te != null && te instanceof TEBlockMetalBlocks) {
((TEBlockMetalBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));is.damageItem(1, player);return true;
} else {return false;}
} else {return false;}
/*
} else if (i1 == Block.dirt.blockID || i1 == Block.grass.blockID || i1 == Block.mycelium.blockID) {
Block block = Block.tilledField;
world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume()+1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

world.setBlock(x, y, z, block.blockID);
is.damageItem(1, player);

return true;
*/
}
}

@SideOnly(Side.CLIENT)
public boolean isFull3D() {return true;}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("Type")) {
return super.getUnlocalizedName() + "." + airbrush_type[(int)tag.getByte("Type")];
} else {
return super.getUnlocalizedName();
}
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
list.add(Option.getText("Type") + ": Tool / AirBrush.");
if (tag != null) {
if (tag.hasKey("ColorHex1")) {
list.add(Option.getText("Color") + "1: #" + tag.getInteger("ColorHex1") + ".");
} else {
list.add(Option.getText("Color") + "1: " + Option.getText("Empty") + ".");
}
if (tag.hasKey("ColorHex2")) {
list.add(Option.getText("Color") + "2: #" + tag.getInteger("ColorHex2") + ".");
} else {
list.add(Option.getText("Color") + "2: " + Option.getText("Empty") + ".");
}
//	list.add(Option.getText("Color") + ": "+Option.GetColors(tag.getInteger("Color"), "a") + ".");
}
} else {list.add(Option.prshift);}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for (int i = 0; i < airbrush_type.length; ++i) {
for (int j2 = 0; j2 < 16; ++j2) {
int j1 = 0xFFFFFF;
list.add(addTag(id, i, j1, GetColors.getHexColors[j2]));
}
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1, int par2, int par3, int par4) {
ItemStack is = new ItemStack(par1, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setByte("Type", (byte)par2);
tag.setInteger("ColorHex1", par3);
tag.setInteger("ColorHex2", par4);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

public Icon getIcon(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("Type")) {
if (pass == 0) {
return icon_tex[(int)tag.getByte("Type")];
} else {
return icon_ovl[(int)tag.getByte("Type")];
}
} else {return itemIcon;}
}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (pass == 0) {
if (tag != null && tag.hasKey("ColorHex1")) {return tag.getInteger("ColorHex1");} else {return 16777215;}
} else {
if (tag != null && tag.hasKey("ColorHex2")) {return tag.getInteger("ColorHex2");} else {return 16777215;}
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
super.registerIcons(ir);
icon_tex = new Icon[airbrush_type.length];
icon_ovl = new Icon[airbrush_type.length];
itemIcon = ir.registerIcon("timaxa007:colors/tool_airbrush");
for (int i = 0; i < airbrush_type.length; i++) {
icon_tex[i] = ir.registerIcon("timaxa007:colors/" + "tool_airbrush");
icon_ovl[i] = ir.registerIcon("timaxa007:colors/" + "tool_airbrush" + "_overlay");
}
}

}
