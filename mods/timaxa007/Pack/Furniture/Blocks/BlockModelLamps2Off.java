package mods.timaxa007.Pack.Furniture.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Furniture.PackFurniture;
import mods.timaxa007.Pack.Furniture.TE.TELamps2Off;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModelLamps2Off extends BlockContainer{
@SideOnly(Side.CLIENT) private Icon[] iconArray;
private final boolean powered;

public BlockModelLamps2Off(int id) {
super(id, Material.redstoneLight);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setStepSound(soundGlassFootstep);
setHardness(0.3F);
setResistance(1.0F);
setLightOpacity(1);
powered=false;
setLightValue(0.0F);
setTextureName("planks_oak");
setUnlocalizedName("BlockModelLamps2Off");
}

@SideOnly(Side.CLIENT)
public Icon getIcon(int par1, int par2) {
return iconArray[par2 % iconArray.length];
}

public int quantityDropped(Random rdm) {return 0;}
public int idDropped(int par1, Random rdm, int par3) {return par1;}
public int damageDropped(int par1) {return par1;}

public int getRenderType() {return -1;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}

@Override
public TileEntity createNewTileEntity(World wrd) {return new TELamps2Off();}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}

public void onBlockAdded(World wrd, int x, int y, int z) {
if(!wrd.isRemote) {
if(powered&&!wrd.isBlockIndirectlyGettingPowered(x, y, z)) {
wrd.scheduleBlockUpdate(x, y, z, blockID, 4);
}
else if(!powered&&wrd.isBlockIndirectlyGettingPowered(x, y, z)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(wrd, x, y, z)==j) {wrd.setBlock(x, y, z, PackFurniture.proxy.block_model_lamps2_on.blockID, j, 2);}
}

}
}
}

public void onNeighborBlockChange(World wrd, int x, int y, int z, int par5) {
if(!wrd.isRemote) {
if(powered&&!wrd.isBlockIndirectlyGettingPowered(x, y, z)) {
wrd.scheduleBlockUpdate(x, y, z, blockID, 4);
}
else if(!powered&&wrd.isBlockIndirectlyGettingPowered(x, y, z)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(wrd, x, y, z)==j) {wrd.setBlock(x, y, z, PackFurniture.proxy.block_model_lamps2_on.blockID, j, 2);}
}

}
}
}

public void updateTick(World wrd, int x, int y, int z, Random rdm) {
if(!wrd.isRemote&&powered&&!wrd.isBlockIndirectlyGettingPowered(x, y, z)) {

for(byte j=0;j<16;++j) {
if(getDamageValue(wrd, x, y, z)==j) {wrd.setBlock(x, y, z, PackFurniture.proxy.block_model_lamps2_off.blockID, j, 2);}
}

}
}

@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int meta, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, meta, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block_model_lamps2_off.blockID, 1, meta));
return ret;
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
iconArray=new Icon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"lamps/lamp_"+GetColors.getNameColors[i]+"_off");
}
}

}
