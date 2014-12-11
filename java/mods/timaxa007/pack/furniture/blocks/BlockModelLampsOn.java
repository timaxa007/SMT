package mods.timaxa007.pack.furniture.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TELampsOn;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModelLampsOn extends BlockContainer{
@SideOnly(Side.CLIENT) private IIcon[] iconArray;
private final boolean powered;

public BlockModelLampsOn() {
super(Material.redstoneLight);
setStepSound(soundTypeGlass);
setHardness(0.3F);
setResistance(1.0F);
setLightOpacity(1);
powered=true;
setLightLevel(1.0F);
setBlockTextureName("planks_oak");
setBlockName("BlockModelLampsOn");
}
/*
@SideOnly(Side.CLIENT)
public IIcon getIcon(int p1, int p2) {
return iconArray[p2 % iconArray.length];
}
*/
public int quantityDropped(Random rdm) {return 0;}
public int idDropped(int p1, Random rdm, int p3) {return p1;}
public int damageDropped(int p1) {return p1;}

public int getRenderType() {return -1;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TELampsOn();}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}

public void onBlockAdded(World wrd, int x, int y, int z) {
if(!wrd.isRemote) {
if(powered&&!wrd.isBlockIndirectlyGettingPowered(x, y, z)) {
wrd.scheduleBlockUpdate(x, y, z, this, 4);
}
else if(!powered&&wrd.isBlockIndirectlyGettingPowered(x, y, z)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(wrd, x, y, z)==j) {wrd.setBlock(x, y, z, PackFurniture.proxy.block_model_lamps_on, j, 2);}
}

}
}
}

public void onNeighborBlockChange(World wrd, int x, int y, int z, int par5) {
if(!wrd.isRemote) {
if(powered&&!wrd.isBlockIndirectlyGettingPowered(x, y, z)) {
wrd.scheduleBlockUpdate(x, y, z, this, 4);
}else if(!powered&&wrd.isBlockIndirectlyGettingPowered(x, y, z)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(wrd, x, y, z)==j) {wrd.setBlock(x, y, z, PackFurniture.proxy.block_model_lamps_on, j, 2);}
}

}
}
}

public void updateTick(World wrd, int x, int y, int z, Random rdm) {
if(!wrd.isRemote&&powered&&!wrd.isBlockIndirectlyGettingPowered(x, y, z)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(wrd, x, y, z)==j) {wrd.setBlock(x, y, z, PackFurniture.proxy.block_model_lamps_off, j, 2);}
}

}
}
/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int meta, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, meta, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block_model_lamps_off, 1, meta));
return ret;
}
*/
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
iconArray=new IIcon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"lamps/lamp_"+GetColors.getNameColors[i]+"_on");
}
}

}
