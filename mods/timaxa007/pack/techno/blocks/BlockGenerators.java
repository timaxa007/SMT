package mods.timaxa007.pack.techno.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.techno.PackTechno;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGenerators extends Block{
public static final String[] generatorNames=new String[]{
"Solid", 
"Gas", 
"Liquid", 
"Solar", 
"Windmill", 
"Watermill", 
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
@SideOnly(Side.CLIENT) private IIcon[] iconArray;

public BlockGenerators() {
super(Material.iron);
setCreativeTab(PackTechno.proxy.tabTechnoPack);
setStepSound(soundMetalFootstep);
setBlockTextureName("planks_oak");
setBlockName("BlockGenerators");
}

@SideOnly(Side.CLIENT)
public IIcon getIcon(int par1, int par2) {
return iconArray[par2 % iconArray.length];
}

public int quantityDropped(Random par1Random) {return 0;}
public int idDropped(int par1, Random par2Random, int par3) {return par1;}
public int damageDropped(int par1) {return par1;}


@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}

//public int getItem() {return PackTechno.itemBrickColors.itemID;}
//public int getBlock() {return PackTechno.blockGenerators.blockID;}

@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
//ret.add(new ItemStack(getItem(), 4, metadata+16));
//ret.add(new ItemStack(getBlock(), 1, metadata));
return ret;
}
/*
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
iconArray=new IIcon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"Mashine"+generatorNames[i]);
}
}
*/
}
