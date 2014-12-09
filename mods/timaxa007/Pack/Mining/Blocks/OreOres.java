package mods.timaxa007.Pack.Mining.Blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Mining.PackMining;
import mods.timaxa007.Pack.Mining.TE.TEOreOres;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class OreOres extends Block implements ITileEntityProvider {

public static String[] type_ore = new String[] {
"appa", 
"chunk", 
"creg", 
"dust", 
"gem_large", 
"gem_med1", 
"gem_medium_2", 
"gem_medium_3", 
"gem_medium_4", 
"gem_medium", 
"gem_small", 
"gem_smalled_4", 
"lap", 
"metal_2", 
"metal", 
"shard"
};

public OreOres(int id) {
super(id, Material.rock);
setCreativeTab(PackMining.proxy.tabMiningPack);
setStepSound(soundStoneFootstep);
setHardness(1.0F);
setResistance(5.0F);
setTextureName("stone");
setUnlocalizedName("ore_ores");
}

@Override
public TileEntity createNewTileEntity(World world) {return new TEOreOres();}
//public int getRenderType() {return -1;}
//public boolean renderAsNormalBlock() {return false;}
//public boolean isOpaqueCube() {return false;}

@SideOnly(Side.CLIENT)
public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
TileEntity te = block_access.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEOreOres) {
return ((TEOreOres)te).getColorBlock();
}
return 0xFFFFFF;
}

@SideOnly(Side.CLIENT)
public Icon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
TileEntity te = block_access.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEOreOres) {
if (blockID == PackMining.proxy.ore_rock_ores.blockID) {return Block.stone.getIcon(side, block_access.getBlockMetadata(x, y, z));}
if (blockID == PackMining.proxy.ore_nether_ores.blockID) {return Block.netherrack.getIcon(side, block_access.getBlockMetadata(x, y, z));}
if (blockID == PackMining.proxy.ore_ender_ores.blockID) {return Block.whiteStone.getIcon(side, block_access.getBlockMetadata(x, y, z));}
return Block.stone.getIcon(side, block_access.getBlockMetadata(x, y, z));
}
return getIcon(side, block_access.getBlockMetadata(x, y, z));
}

public int idPicked(World world, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEOreOres) {
return addTag(world.getBlockId(x, y, z), ((TEOreOres)te).getType(), ((TEOreOres)te).getColorBlock());
} else {
return addTag(world.getBlockId(x, y, z), 0, 0xFFFFFF);
}
}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEOreOres && tag != null) {

if (tag.hasKey("Type")) {((TEOreOres)te).setType((int)tag.getByte("Type"));} else {((TEOreOres)te).setType(0);}

if (tag.hasKey("ColorBlock")) {((TEOreOres)te).setColorBlock(tag.getInteger("ColorBlock"));} else {((TEOreOres)te).setColorBlock(0xFFFFFF);}

}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for (int i = 0; i < type_ore.length; i++) {
//for (int j = 0; j < 16; j++) {
int j = 14;
list.add(addTag(id, i, GetColors.getHexColors[j]));
//}
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1, int par2, int par3) {
ItemStack is = new ItemStack(par1, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setByte("Type", (byte)par2);
tag.setInteger("ColorBlock", par3);
is.setTagCompound(tag);
return is;
}

}
