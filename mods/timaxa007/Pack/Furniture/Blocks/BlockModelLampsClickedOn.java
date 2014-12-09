package mods.timaxa007.Pack.Furniture.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Furniture.PackFurniture;
import mods.timaxa007.Pack.Furniture.TE.TELampsOn;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModelLampsClickedOn extends BlockContainer{
@SideOnly(Side.CLIENT) private Icon[] iconArray;

public BlockModelLampsClickedOn(int id) {
super(id, Material.redstoneLight);
setStepSound(soundGlassFootstep);
setHardness(0.3F);
setResistance(1.0F);
setLightOpacity(1);
setLightValue(1.0F);
setTextureName("planks_oak");
setUnlocalizedName("BlockModelLampsClickOn");
}

@SideOnly(Side.CLIENT)
public Icon getIcon(int par1, int par2) {
return iconArray[par2 % iconArray.length];
}

public int quantityDropped(Random par1Random) {return 0;}
public int idDropped(int par1, Random par2Random, int par3) {return par1;}
public int damageDropped(int par1) {return par1;}

public int getRenderType() {return -1;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}

@Override
public TileEntity createNewTileEntity(World world) {return new TELampsOn();}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}

public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
int blok;
if(blockID==PackFurniture.proxy.block_model_lamps_click_on.blockID) {
blok=PackFurniture.proxy.block_model_lamps_click_off.blockID;
}else{
blok=PackFurniture.proxy.block_model_lamps_click_on.blockID;
}
for(byte j=0;j<16;++j) {
if(getDamageValue(par1World, par2, par3, par4)==j) {
par1World.setBlock(par2, par3, par4, blok, j, 0);
}
}
return true;
}

@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block_model_lamps_click_off.blockID, 1, metadata));
return ret;
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
iconArray=new Icon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"lamps/lamp_"+GetColors.getNameColors[i]+"_on");
}
}

}
