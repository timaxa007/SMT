package mods.timaxa007.pack.furniture.common.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.common.main.PackFurniture;
import mods.timaxa007.pack.furniture.common.lib.AddBlockRock;
import mods.timaxa007.pack.furniture.common.tile.TERockBlocks;
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

public class BlockRockBlocks extends Block implements ITileEntityProvider {

@SideOnly(Side.CLIENT) private IIcon[] icon_array;

public static AddBlockRock stone_style_1 = new AddBlockRock("stone_style1").setName("stone_style1").setColor(0xFFFFFF).setTexture("stone_style_1");
public static AddBlockRock rock_style_1 = new AddBlockRock("rock_style1").setName("rock_style1").setColor(0xFFFFFF).setTexture("rock_style_1");

public static String[] type_block = new String[] {
"stone", 
"stone_smooth", 
"stone_smooth_dark", 
"stone_smooth_light", 
"stone_rush", 
"stone_smooth_slab", 
"stone_smooth_slab_v", 
"stone_brick", 
"stone_bricks", 
"stone_carved", 
"stone_chesh", 
"stone_chesh2", 
"rock", 
"rock_rush", 
"rock_smooth", 
"rock_smooth_dark", 
"rock_smooth_light", 
"brick_clay", 
"brick_new_blank", 
"rock_hell", 
"beton"
};

public BlockRockBlocks() {
super(Material.rock);
setCreativeTab(PackFurniture.proxy.tab_furniture);
setHardness(1.5F);
setResistance(10.0F);
setStepSound(soundTypeStone);
//setBlockTextureName("stone");
setBlockName("block_rock_blocks");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TERockBlocks();}
public int quantityDropped(Random random) {return 0;}

@SideOnly(Side.CLIENT)
public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
TileEntity te = block_access.getTileEntity(x, y, z);
if (te != null && te instanceof TERockBlocks) {
return ((TERockBlocks)te).getColorBlock();
}
return 0xFFFFFF;
}

@SideOnly(Side.CLIENT)
public IIcon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
TileEntity te = block_access.getTileEntity(x, y, z);
if (te != null && te instanceof TERockBlocks) {
return icon_array[((TERockBlocks)te).getSubID()];
}
return getIcon(side, block_access.getBlockMetadata(x, y, z));
}

public int idPicked(World world, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TERockBlocks) {
return addTag(world.getBlock(x, y, z), ((TERockBlocks)te).getSubID(), ((TERockBlocks)te).getColorBlock());
} else {
return addTag(world.getBlock(x, y, z), 0, 0xFFFFFF);
}
}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TERockBlocks && tag != null) {
if (tag.hasKey("SubID")) {((TERockBlocks)te).setSubID((int)tag.getByte("SubID"));} 
else {((TERockBlocks)te).setSubID(0);}
if (tag.hasKey("ColorBlock")) {((TERockBlocks)te).setColorBlock(tag.getInteger("ColorBlock"));} 
else {((TERockBlocks)te).setColorBlock(0xFFFFFF);}
}
}

@Override
public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
if (!world.isRemote) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TERockBlocks && !player.capabilities.isCreativeMode) {
dropBlockAsItem(world, x, y, z, addTag(world.getBlock(x, y, z), ((TERockBlocks)te).getSubID(), ((TERockBlocks)te).getColorBlock()));
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
//((TERockBlocks)te).setColorBlock(GetColors.getHexColors[current.getItemDamage()]);
((TERockBlocks)te).setColorBlock(GetColors.getColorMix(GetColors.getHexColors[current.getItemDamage()], ((TERockBlocks)te).getColorBlock()));
//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
return true;
}
//--------------------------------
else if (current.getItem() == Items.dye && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
if (!player.capabilities.isCreativeMode) {--current.stackSize;}
//((TERockBlocks)te).setColorBlock(ItemDye.dyeColors[current.getItemDamage()]);
((TERockBlocks)te).setColorBlock(GetColors.getColorMix(ItemDye.field_150922_c[current.getItemDamage()], ((TERockBlocks)te).getColorBlock()));
//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
return true;
}
//--------------------------------
else {
return false;
}
//--------------------------------
} else {
return false;
}
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
blockIcon = ir.registerIcon("stone");
for (int i = 0; i < icon_array.length; ++i) {
icon_array[i] = ir.registerIcon("timaxa007:" + "stone/" + type_block[i] + "_overlay");
}
}

}
