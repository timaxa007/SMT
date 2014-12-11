package mods.timaxa007.pack.mining.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRockCB extends Block{
@SideOnly(Side.CLIENT) private IIcon[] iconArray;
public static final String[] rockType=new String[]{
"1", 
"2", 
"3", 
"4", 
"5", 
"6", 
"7", 
"8", 
"9", 
"10", 
"11", 
"12", 
"13", 
"14", 
"15", 
"16"
};

public BlockRockCB() {
super(Material.circuits);
setStepSound(soundTypeStone);
setCreativeTab(PackMining.proxy.tabMiningPack);
setHardness(0.5F);
setResistance(1.0F);
setBlockTextureName("stone");
setBlockName("BlockRockCB");
}

@SideOnly(Side.CLIENT)
public int getBlockColor() {
double d0=0.5D;
double d1=1.0D;
return ColorizerGrass.getGrassColor(d0, d1);
}

@SideOnly(Side.CLIENT) public int getRenderColor(int par1) {return getBlockColor();}

@SideOnly(Side.CLIENT)
public int colorMultiplier(IBlockAccess par1IBlockAccess, int x, int y, int z) {
int l=0;
int i1=0;
int j1=0;

for(int k1=-1;k1<=1;++k1) {
for(int l1=-1;l1<=1;++l1) {
int i2=par1IBlockAccess.getBiomeGenForCoords(x+l1, z+k1).getBiomeGrassColor(x, y, z);
l += (i2 & 16711680) >> 16;
i1 += (i2 & 65280) >> 8;
j1 += i2 & 255;
}
}
return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
}
/*
@SideOnly(Side.CLIENT)
public IIcon getIcon(int par1, int par2) {
return iconArray[par2 % iconArray.length];
}
*/
public int quantityDropped(Random par1Random) {return 0;}
public int idDropped(int par1, Random par2Random, int par3) {return par1;}
public int damageDropped(int par1) {return par1;}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}
/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackMining.proxy.blockRock, 1, metadata));
return ret;
}
*/
/*
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister ir) {
iconArray=new IIcon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"rock");
}
}
*/
}