package mods.timaxa007.pack.mining.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.mining.PackInfo;
import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEarthCB extends Block{
@SideOnly(Side.CLIENT) private Icon[] iconArray;
@SideOnly(Side.CLIENT) private Icon iconEarthTop;
@SideOnly(Side.CLIENT) private Icon iconSnowSide;
@SideOnly(Side.CLIENT) private Icon iconEarthSideOverlay;
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

public BlockEarthCB(int id) {
super(id, Material.circuits);
setStepSound(soundWoodFootstep);
setCreativeTab(PackMining.proxy.tabMiningPack);
setHardness(0.5F);
setResistance(10.0F);
setLightValue(0.0F);
setLightOpacity(1);
setTextureName("dirt");
setUnlocalizedName("BlockEarthCB");
}
/*
@SideOnly(Side.CLIENT)
public Icon getIcon(int par1, int par2) {
return par1==1 ? iconEarthTop : (par1==0 ? Block.dirt.getBlockTextureFromSide(par1) : iconArray[par2 % iconArray.length]);
}

@SideOnly(Side.CLIENT)
public Icon getIcon(int par1, int par2) {
return iconArray[par2 % iconArray.length];
}
*/
public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
if(!par1World.isRemote) {
if(par1World.getBlockLightValue(par2, par3+1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3+1, par4) > 2) {
par1World.setBlock(par2, par3, par4, Block.dirt.blockID);
}
else if(par1World.getBlockLightValue(par2, par3+1, par4) >= 9) {
for(byte l=0;l<4;++l) {
int i1=par2+par5Random.nextInt(3)-1;
int j1=par3+par5Random.nextInt(5)-3;
int k1=par4+par5Random.nextInt(3)-1;
int l1=par1World.getBlockId(i1, j1+1, k1);

if(par1World.getBlockId(i1, j1, k1)==Block.dirt.blockID && par1World.getBlockLightValue(i1, j1+1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1+1, k1) <= 2) {
par1World.setBlock(i1, j1, k1, PackMining.proxy.blockEarth.blockID);
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
public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int x, int y, int z, int side) {
if(side==1) {
return iconEarthTop;
}
else if(side==0) {
return Block.dirt.getBlockTextureFromSide(side);
}
else{
Material material=par1IBlockAccess.getBlockMaterial(x, y + 1, z);
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
public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
int l=0;
int i1=0;
int j1=0;

for(int k1=-1;k1<=1;++k1) {
for(int l1=-1;l1<=1;++l1) {
int i2=par1IBlockAccess.getBiomeGenForCoords(par2+l1, par4+k1).getBiomeGrassColor();
l += (i2 & 16711680) >> 16;
i1 += (i2 & 65280) >> 8;
j1 += i2 & 255;
}
}
return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
}

@SideOnly(Side.CLIENT) public static Icon getIconSideOverlay() {return PackMining.proxy.blockEarth.iconEarthSideOverlay;}

public int quantityDropped(Random par1Random) {return 0;}
public int idDropped(int par1, Random par2Random, int par3) {return par1;}
public int damageDropped(int par1) {return par1;}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {
list.add(new ItemStack(id, 1, j));
}
}

public int getBlock() {return PackMining.proxy.blockEarth.blockID;}

@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(getBlock(), 1, metadata));
return ret;
}

/*
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
blockIcon=ir.registerIcon("grass_side");
iconEarthTop=ir.registerIcon("grass_top");
iconSnowSide=ir.registerIcon("snow_side");
iconEarthSideOverlay=ir.registerIcon("earth_side_overlay");
}
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
iconArray=new Icon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"testBlock2"+GetColors.getNameColors[i]);
}
}
*/

}