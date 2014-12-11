package mods.timaxa007.pack.furniture.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLampsInvert extends Block{
@SideOnly(Side.CLIENT) private IIcon[] iconArray;
private final boolean powered;
private final String light;

public BlockLampsInvert(boolean par2) {
super(Material.redstoneLight);
setStepSound(soundTypeGlass);
setHardness(0.3F);
setResistance(1.0F);
setLightOpacity(5);
if(par2) {
light="on";
powered=true;
setLightLevel(1.0F);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
}else{
light="off";
powered=false;
setLightLevel(0.0F);
}
setBlockTextureName("planks_oak");
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

public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}

public void onBlockAdded(World par1World, int par2, int par3, int par4) {
if(!par1World.isRemote) {
if(!powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
par1World.scheduleBlockUpdate(par2, par3, par4, this, 4);
}
else if(powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(par1World, par2, par3, par4)==j) {
par1World.setBlock(par2, par3, par4, PackFurniture.proxy.block_lamps_off_invert, j, 2);
}
}

}
}
}

public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
if(!par1World.isRemote) {
if(!powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
par1World.scheduleBlockUpdate(par2, par3, par4, this, 4);
}
else if(powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(par1World, par2, par3, par4)==j) {

par1World.setBlock(par2, par3, par4, PackFurniture.proxy.block_lamps_off_invert, j, 2);
}
}

}
}
}

public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
if(!par1World.isRemote && !powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(par1World, par2, par3, par4)==j) {
par1World.setBlock(par2, par3, par4, PackFurniture.proxy.block_lamps_on_invert, j, 2);
}
}

}
}
/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block_lamps_on_invert, 1, metadata));
return ret;
}
*/
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister ir) {
iconArray=new IIcon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"lamps/lamp_"+GetColors.getNameColors[i]+"_"+light);
}
}

}
