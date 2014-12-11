package mods.timaxa007.pack.mining.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEarthCB extends Block{
@SideOnly(Side.CLIENT) private IIcon[] iconArray;
@SideOnly(Side.CLIENT) private IIcon iconEarthTop;
@SideOnly(Side.CLIENT) private IIcon iconSnowSide;
@SideOnly(Side.CLIENT) private IIcon iconEarthSideOverlay;
public static final String[] earthType=new String[]{
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

public BlockEarthCB() {
super(Material.circuits);
setStepSound(soundTypeWood);
setCreativeTab(PackMining.proxy.tabMiningPack);
setHardness(0.5F);
setResistance(10.0F);
setLightLevel(0.0F);
setLightOpacity(1);
setBlockTextureName("dirt");
setBlockName("BlockEarthCB");
}
/*
@SideOnly(Side.CLIENT)
public IIcon getIcon(int par1, int par2) {
return par1==1 ? iconEarthTop : (par1==0 ? Block.dirt.getBlockTextureFromSide(par1) : iconArray[par2 % iconArray.length]);
}

@SideOnly(Side.CLIENT)
public IIcon getIcon(int par1, int par2) {
return iconArray[par2 % iconArray.length];
}
*/
public void updateTick(World world, int par2, int par3, int par4, Random par5Random) {
if(!world.isRemote) {
if(world.getBlockLightValue(par2, par3+1, par4) < 4 && world.getBlockLightOpacity(par2, par3+1, par4) > 2) {
world.setBlock(par2, par3, par4, Blocks.dirt);
}
else if(world.getBlockLightValue(par2, par3+1, par4) >= 9) {
for(byte l=0;l<4;++l) {
int i1=par2+par5Random.nextInt(3)-1;
int j1=par3+par5Random.nextInt(5)-3;
int k1=par4+par5Random.nextInt(3)-1;
Block l1=world.getBlock(i1, j1+1, k1);

if(world.getBlock(i1, j1, k1)==Blocks.dirt && world.getBlockLightValue(i1, j1+1, k1) >= 4 && world.getBlockLightOpacity(i1, j1+1, k1) <= 2) {
world.setBlock(i1, j1, k1, PackMining.proxy.blockEarth);
}
}
}
}
}
/*
public int idDropped(int par1, Random par2Random, int par3) {
return Block.dirt.idDropped(0, par2Random, par3);
}
*/
@SideOnly(Side.CLIENT)
public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int x, int y, int z, int side) {
if(side==1) {
return iconEarthTop;
}
else if(side==0) {
return Blocks.dirt.getBlockTextureFromSide(side);
}
else{
Material material=par1IBlockAccess.getBlock(x, y, z).getMaterial();
return material != Material.snow && material != Material.craftedSnow ? blockIcon : iconSnowSide;
}
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

@SideOnly(Side.CLIENT) public static IIcon getIconSideOverlay() {return PackMining.proxy.blockEarth.iconEarthSideOverlay;}

public int quantityDropped(Random par1Random) {return 0;}
public int idDropped(int par1, Random par2Random, int par3) {return par1;}
public int damageDropped(int par1) {return par1;}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {
list.add(new ItemStack(id, 1, j));
}
}

public Block getBlock() {return PackMining.proxy.blockEarth;}
/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(getBlock(), 1, metadata));
return ret;
}
*/
/*
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister ir) {
blockIcon=ir.registerIcon("grass_side");
iconEarthTop=ir.registerIcon("grass_top");
iconSnowSide=ir.registerIcon("snow_side");
iconEarthSideOverlay=ir.registerIcon("earth_side_overlay");
}
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister ir) {
iconArray=new IIcon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"testBlock2"+GetColors.getNameColors[i]);
}
}
*/

}