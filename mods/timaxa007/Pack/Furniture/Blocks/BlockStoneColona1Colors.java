package mods.timaxa007.Pack.Furniture.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStoneColona1Colors extends Block{
@SideOnly(Side.CLIENT) private Icon[] iconArray;
@SideOnly(Side.CLIENT) private Icon[] iconTop;
public static final String[] colona1Types=new String[]{"Black", "Blue", "Brown", "Cyan"};

public BlockStoneColona1Colors(int id) {
super(id, Material.rock);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setStepSound(soundStoneFootstep);
setTextureName("planks_oak");
setUnlocalizedName("StoneColona1Colors");
}

//public int damageDropped(int par1) {return par1 & 3;}
public static int limitToValidMetadata(int par0) {return par0 & 3;}
//public int quantityDropped(Random par1Random) {return 1;}
//public int idDropped(int par1, Random par2Random, int par3) {return PackFurniture.blockTree1.blockID;}
protected ItemStack createStackedBlock(int par1) {return new ItemStack(blockID, 1, limitToValidMetadata(par1));}

public int quantityDropped(Random par1Random) {return 0;}
public int idDropped(int par1, Random par2Random, int par3) {return par1;}
public int damageDropped(int par1) {return par1;}
public int getRenderType() {return 31;}
//public static int getBlockFromNames(int par0) {return ~par0 & 3;}

public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
byte b0=4;
int j1=b0+1;
if(par1World.checkChunksExist(par2-j1, par3-j1, par4-j1, par2+j1, par3+j1, par4+j1)) {
for(int k1=-b0;k1<=b0;++k1) {
for(int l1=-b0;l1<=b0;++l1) {
for(int i2=-b0;i2<=b0;++i2) {
int j2=par1World.getBlockId(par2+k1, par3+l1, par4+i2);
if(Block.blocksList[j2] != null) {Block.blocksList[j2].beginLeavesDecay(par1World, par2+k1, par3+l1, par4+i2);}
}
}
}
}
}

public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
int j1=par9 & 3;
byte b0=0;

switch (par5) {
case 0:
case 1:
b0=0;
break;
case 2:
case 3:
b0=8;
break;
case 4:
case 5:
b0=4;
}
return j1 | b0;
}

@SideOnly(Side.CLIENT)
public Icon getIcon(int par1, int par2) {
int k=par2 & 12;
int l=par2 & 3;
return k==0 && (par1==1 || par1==0) ? iconTop[l] : (k==4 && (par1==5 || par1==4) ? iconTop[l] : (k==8 && (par1==2 || par1==3) ? iconTop[l] : iconArray[l]));
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for(byte j=0;j<4;++j) {list.add(new ItemStack(id, 1, j));}
}

@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackFurniture.proxy.item_brick_colors.itemID, 3, metadata));
return ret;
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
iconArray=new Icon[colona1Types.length];
iconTop=new Icon[colona1Types.length];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i] = ir.registerIcon("timaxa007:" + "stone/" + "stone_colona_" + GetColors.getNameColors[i]);
iconTop[i] = ir.registerIcon("timaxa007:" + "stone/" + "stone_colona_" + GetColors.getNameColors[i] + "_top");
}
}

}
