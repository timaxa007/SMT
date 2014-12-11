package mods.timaxa007.pack.furniture.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.lib.AddBlockWood;
import mods.timaxa007.pack.furniture.te.TEBlockWoodBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWoodBlocks extends Block implements ITileEntityProvider {

@SideOnly(Side.CLIENT) private IIcon[] icon_array;

public static AddBlockWood plywood_style1 = new AddBlockWood("plywood_style1").setName("plywood_style1").setColor(0xFFFFFF).setTexture("plywood_style_1");
public static AddBlockWood plywood_style2 = new AddBlockWood("plywood_style2").setName("plywood_style2").setColor(0xFFFFFF).setTexture("plywood_style_2");
public static AddBlockWood plywood_style10 = new AddBlockWood("plywood_style10").setName("plywood_style10").setColor(0xFFFFFF).setTexture("plywood_style_10");
public static AddBlockWood plywood_style11 = new AddBlockWood("plywood_style11").setName("plywood_style11").setColor(0xFFFFFF).setTexture("plywood_style_11");
public static AddBlockWood plywood_style12 = new AddBlockWood("plywood_style12").setName("plywood_style12").setColor(0xFFFFFF).setTexture("plywood_style_12");
public static AddBlockWood plywood_style13 = new AddBlockWood("plywood_style13").setName("plywood_style13").setColor(0xFFFFFF).setTexture("plywood_style_13");
public static AddBlockWood plywood_style14 = new AddBlockWood("plywood_style14").setName("plywood_style14").setColor(0xFFFFFF).setTexture("plywood_style_14");
public static AddBlockWood plywood_style15 = new AddBlockWood("plywood_style15").setName("plywood_style15").setColor(0xFFFFFF).setTexture("plywood_style_15");
public static AddBlockWood plywood_style16 = new AddBlockWood("plywood_style16").setName("plywood_style16").setColor(0xFFFFFF).setTexture("plywood_style_16");
public static AddBlockWood plywood_style17 = new AddBlockWood("plywood_style17").setName("plywood_style17").setColor(0xFFFFFF).setTexture("plywood_style_17");
public static AddBlockWood plywood_style18 = new AddBlockWood("plywood_style18").setName("plywood_style18").setColor(0xFFFFFF).setTexture("plywood_style_18");
public static AddBlockWood plywood_style19 = new AddBlockWood("plywood_style19").setName("plywood_style19").setColor(0xFFFFFF).setTexture("plywood_style_19");
public static AddBlockWood plywood_style20 = new AddBlockWood("plywood_style20").setName("plywood_style20").setColor(0xFFFFFF).setTexture("plywood_style_20");
public static AddBlockWood plywood_style21 = new AddBlockWood("plywood_style21").setName("plywood_style21").setColor(0xFFFFFF).setTexture("plywood_style_21");
public static AddBlockWood plywood_style22 = new AddBlockWood("plywood_style22").setName("plywood_style22").setColor(0xFFFFFF).setTexture("plywood_style_22");
public static AddBlockWood plywood_style23 = new AddBlockWood("plywood_style23").setName("plywood_style23").setColor(0xFFFFFF).setTexture("plywood_style_23");
public static AddBlockWood plywood_style24 = new AddBlockWood("plywood_style24").setName("plywood_style24").setColor(0xFFFFFF).setTexture("plywood_style_24");
public static AddBlockWood plywood_style25 = new AddBlockWood("plywood_style25").setName("plywood_style25").setColor(0xFFFFFF).setTexture("plywood_style_25");
public static AddBlockWood plywood_style26 = new AddBlockWood("plywood_style26").setName("plywood_style26").setColor(0xFFFFFF).setTexture("plywood_style_26");
public static AddBlockWood plywood_style27 = new AddBlockWood("plywood_style27").setName("plywood_style27").setColor(0xFFFFFF).setTexture("plywood_style_27");
public static AddBlockWood plywood_style28 = new AddBlockWood("plywood_style28").setName("plywood_style28").setColor(0xFFFFFF).setTexture("plywood_style_28");
public static AddBlockWood plywood_style29 = new AddBlockWood("plywood_style29").setName("plywood_style29").setColor(0xFFFFFF).setTexture("plywood_style_29");
public static AddBlockWood plywood_style40 = new AddBlockWood("plywood_style40").setName("plywood_style40").setColor(0xFFFFFF).setTexture("plywood_style_40");
//public static AddBlockWood plywood_style41 = new AddBlockWood("plywood_style41").setName("plywood_style41").setColor(0xFFFFFF).setTexture("plywood_style_41");
public static AddBlockWood plywood_style42 = new AddBlockWood("plywood_style42").setName("plywood_style42").setColor(0xFFFFFF).setTexture("plywood_style_42");
public static AddBlockWood plywood_style43 = new AddBlockWood("plywood_style43").setName("plywood_style43").setColor(0xFFFFFF).setTexture("plywood_style_43");
public static AddBlockWood plywood_style44 = new AddBlockWood("plywood_style44").setName("plywood_style44").setColor(0xFFFFFF).setTexture("plywood_style_44");
public static AddBlockWood plywood_style45 = new AddBlockWood("plywood_style45").setName("plywood_style45").setColor(0xFFFFFF).setTexture("plywood_style_45");

public static String[] type_block = new String[] {
"plywood_style_1",		//1
"plywood_style_2",		//2
"plywood_style_10",		//3
"plywood_style_11",		//4
"plywood_style_12_a",	//5
"plywood_style_13_a",	//6
"plywood_style_14",		//7
"plywood_style_15",		//8
"plywood_style_16",		//9
"plywood_style_17",		//10
"plywood_style_18",		//11
"plywood_style_19",		//12
"plywood_style_20",		//13
"plywood_style_21",		//14
"plywood_style_22",		//15
"plywood_style_23",		//16
"plywood_style_24",		//17
"plywood_style_25",		//18
"plywood_style_26",		//19
"plywood_style_27",		//20
"plywood_style_28",		//21
"plywood_style_29",		//22
"plywood_style_40_a",	//23
"plywood_style_42_a",	//24
"plywood_style_43_a",	//25
"plywood_style_44_a",	//26
"plywood_style_45_a"	//27
};

public BlockWoodBlocks() {
super(Material.wood);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setHardness(0.75F);
setResistance(7.0F);
setStepSound(soundTypeWood);
//setBlockTextureName("wood_oak");
setBlockName("block_wood_blocks");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEBlockWoodBlocks();}
//public int getRenderType() {return -1;}
public int quantityDropped(Random random) {return 0;}
public boolean renderAsNormalBlock() {return false;}
public boolean isOpaqueCube() {return false;}

@SideOnly(Side.CLIENT)
public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
TileEntity te = block_access.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockWoodBlocks) {
return ((TEBlockWoodBlocks)te).getColorBlock();
}
return 0xFFFFFF;
}

@SideOnly(Side.CLIENT)
public IIcon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
TileEntity te = block_access.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockWoodBlocks) {
return icon_array[((TEBlockWoodBlocks)te).getSubID()];
}
return getIcon(side, block_access.getBlockMetadata(x, y, z));
}

public int idPicked(World world, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockWoodBlocks) {
return addTag(world.getBlock(x, y, z), ((TEBlockWoodBlocks)te).getSubID(), ((TEBlockWoodBlocks)te).getColorBlock());
} else {
return addTag(world.getBlock(x, y, z), 0, 0xFFFFFF);
}
}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEBlockWoodBlocks && tag != null) {
if (tag.hasKey("SubID")) {((TEBlockWoodBlocks)te).setSubID((int)tag.getByte("SubID"));} 
else {((TEBlockWoodBlocks)te).setSubID(0);}
if (tag.hasKey("ColorBlock")) {((TEBlockWoodBlocks)te).setColorBlock(tag.getInteger("ColorBlock"));} 
else {((TEBlockWoodBlocks)te).setColorBlock(0xFFFFFF);}
}
}

@Override
public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
if (!world.isRemote) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockWoodBlocks && !player.capabilities.isCreativeMode) {
dropBlockAsItem(world, x, y, z, addTag(world.getBlock(x, y, z), ((TEBlockWoodBlocks)te).getSubID(), ((TEBlockWoodBlocks)te).getColorBlock()));
world.removeTileEntity(x, y, z);
world.setBlockToAir(x, y, z);
}
}
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
ItemStack current = player.getCurrentEquippedItem();
if (current != null) {
TileEntity te = world.getTileEntity(x, y, z);
//--------------------------------
if (current.getItem() == PackFurniture.proxy.item_colored && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
if (!player.capabilities.isCreativeMode) {--current.stackSize;}
//((TEBlockWoodBlocks)te).setColorBlock(GetColors.getHexColors[current.getItemDamage()]);
((TEBlockWoodBlocks)te).setColorBlock(GetColors.getColorMix(GetColors.getHexColors[current.getItemDamage()], ((TEBlockWoodBlocks)te).getColorBlock()));
//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
return true;
}
//--------------------------------
else if (current.getItem() == Items.dye && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
if (!player.capabilities.isCreativeMode) {--current.stackSize;}
//((TEBlockWoodBlocks)te).setColorBlock(ItemDye.dyeColors[current.getItemDamage()]);
((TEBlockWoodBlocks)te).setColorBlock(GetColors.getColorMix(ItemDye.field_150922_c[current.getItemDamage()], ((TEBlockWoodBlocks)te).getColorBlock()));
//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
return true;
}
//--------------------------------
else {return false;}
//--------------------------------
} else {return false;}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
for (int i = 0; i < type_block.length; i++) {
for (int j = 0; j < 16; j++) {
//int j = 14;
list.add(addTag(id, i, GetColors.getHexColors[j]));
}
/*for (int j = 0; j < (Integer.MAX_VALUE / 1000000); j++) {//int j = 14;
list.add(addTag(id, i, (j * 1000000)));
}*/
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(Block par1, int par2, int par3) {
return addTag(Item.getItemFromBlock(par1), par2, par3);
}

private static ItemStack addTag(Item par1, int par2, int par3) {
ItemStack is = new ItemStack(par1, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setByte("SubID", (byte)par2);
tag.setInteger("ColorBlock", par3);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister ir) {
icon_array = new IIcon[type_block.length];
blockIcon = ir.registerIcon("planks_oak");
for (int i = 0; i < icon_array.length; ++i) {
icon_array[i] = ir.registerIcon("timaxa007:" + "wood/" + type_block[i] + "_overlay");
}
}

}
