package mods.timaxa007.pack.furniture.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TEBlockVegetableFace;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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

public class BlockVegetableFace extends Block implements ITileEntityProvider {

@SideOnly(Side.CLIENT) private IIcon[][] icon_array;
@SideOnly(Side.CLIENT) private IIcon[][] icon_face;

public static String[] type_block = new String[] {"pumpkin", "water_melon"};

public static String[] type_side = new String[] {"top", "botton", "side"};

public static String[] type_face = new String[] {
"face1", 
"face2", 
"face3", 
"face4", 
"face5", 
"face6"
};

public BlockVegetableFace() {
super(Material.pumpkin);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setHardness(0.5F);
setResistance(2.5F);
setStepSound(soundTypeWood);
setBlockTextureName("pumpkin_side");
setBlockName("block_wood_blocks");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEBlockVegetableFace();}
//public int getRenderType() {return -1;}
public int quantityDropped(Random random) {return 0;}
public boolean renderAsNormalBlock() {return false;}
public boolean isOpaqueCube() {return false;}

@SideOnly(Side.CLIENT)
public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
TileEntity te = block_access.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockVegetableFace) {
return ((TEBlockVegetableFace)te).getColorBlock();
}
return 0xFFFFFF;
}

@SideOnly(Side.CLIENT)
public IIcon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
TileEntity te = block_access.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockVegetableFace) {
if (side == 0) {
return icon_array[((TEBlockVegetableFace)te).getSubID()][1];
} else if (side == 1) {
return icon_array[((TEBlockVegetableFace)te).getSubID()][0];
} else if (side == 4) {
return icon_face[((TEBlockVegetableFace)te).getSubID()][((TEBlockVegetableFace)te).getFace()];
} else {
return icon_array[((TEBlockVegetableFace)te).getSubID()][2];
}
}
return getIcon(side, block_access.getBlockMetadata(x, y, z));
}

public int idPicked(World world, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockVegetableFace) {
return addTag(world.getBlock(x, y, z), ((TEBlockVegetableFace)te).getSubID(), ((TEBlockVegetableFace)te).getFace(), ((TEBlockVegetableFace)te).getColorBlock());
} else {
return addTag(world.getBlock(x, y, z), 0, 0, 0xFFFFFF);
}
}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEBlockVegetableFace && tag != null) {

if (tag.hasKey("SubID")) {((TEBlockVegetableFace)te).setSubID((int)tag.getByte("SubID"));} 
else {((TEBlockVegetableFace)te).setSubID(0);}

if (tag.hasKey("FaceID")) {((TEBlockVegetableFace)te).setFace((int)tag.getByte("FaceID"));} 
else {((TEBlockVegetableFace)te).setFace(0);}

if (tag.hasKey("ColorBlock")) {((TEBlockVegetableFace)te).setColorBlock(tag.getInteger("ColorBlock"));} 
else {((TEBlockVegetableFace)te).setColorBlock(0xFFFFFF);}

}
}

@Override
public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
if (!world.isRemote) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockVegetableFace && !player.capabilities.isCreativeMode) {
dropBlockAsItem_do(world, x, y, z, addTag(world.getBlock(x, y, z), ((TEBlockVegetableFace)te).getSubID(), ((TEBlockVegetableFace)te).getFace(), ((TEBlockVegetableFace)te).getColorBlock()));
world.removeBlockTileEntity(x, y, z);
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
//((TEBlockVegetableFace)te).setColorBlock(GetColors.getHexColors[current.getItemDamage()]);
((TEBlockVegetableFace)te).setColorBlock(GetColors.getColorMix(GetColors.getHexColors[current.getItemDamage()], ((TEBlockVegetableFace)te).getColorBlock()));
//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
return true;
}
//--------------------------------
else if (current.getItem() == Item.dyePowder && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
if (!player.capabilities.isCreativeMode) {--current.stackSize;}
//((TEBlockVegetableFace)te).setColorBlock(ItemDye.dyeColors[current.getItemDamage()]);
((TEBlockVegetableFace)te).setColorBlock(GetColors.getColorMix(ItemDye.dyeColors[current.getItemDamage()], ((TEBlockVegetableFace)te).getColorBlock()));
//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
return true;
}
//--------------------------------
else {return false;}
//--------------------------------
} else {return false;}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for (int i1 = 0; i1 < type_block.length; i1++) {
for (int i3 = 0; i3 < type_face.length; i3++) {
//for (int j = 0; j < 16; j++) {
int j = 14;
list.add(addTag(id, i1, i3, GetColors.getHexColors[j]));
//}
/*for (int j = 0; j < (Integer.MAX_VALUE / 1000000); j++) {//int j = 14;
list.add(addTag(id, i, (j * 1000000)));
}*/
}
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1, int par2, int par3, int par4) {
ItemStack is = new ItemStack(par1, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setByte("SubID", (byte)par2);
tag.setByte("FaceID", (byte)par3);
tag.setInteger("ColorBlock", par4);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
icon_array = new IIcon[type_block.length][type_side.length];
icon_face = new IIcon[type_block.length][type_face.length];
blockIcon = ir.registerIcon("pumpkin_side");
for (int i1 = 0; i1 < icon_array.length; ++i1) {
for (int i2 = 0; i2 < type_side.length; ++i2) {
icon_array[i1][i2] = ir.registerIcon("timaxa007:" + "germination/" + type_block[i1] + "_" + type_side[i2]);
}
for (int i3 = 0; i3 < type_face.length; ++i3) {
icon_face[i1][i3] = ir.registerIcon("timaxa007:" + "germination/" + type_block[i1] + "_" + type_face[i3] + "_off");
}
}
}

}
