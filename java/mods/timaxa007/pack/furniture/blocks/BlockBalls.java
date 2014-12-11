package mods.timaxa007.pack.furniture.blocks;

import java.util.ArrayList;
import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TEBalls;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBalls extends BlockContainer{

public BlockBalls() {
super(Material.circuits);
setHardness(0.5F);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setBlockTextureName("planks_oak");
setBlockName("balls");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEBalls();}
public int getRenderType() {return -1;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase el, ItemStack is) {
TileEntity te = world.getTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if( te != null && te instanceof TEBalls) {

int l=MathHelper.floor_double((double)(el.rotationYaw*4.0F/360.0F)+0.5D)&3;
((TEBalls)te).setRot(l);

if (tag != null) {
((TEBalls)te).setAmount(tag.getInteger("Amount"));
((TEBalls)te).setTypes(tag.getInteger("Type"));
} else {
((TEBalls)te).setAmount(8);
((TEBalls)te).setTypes(0);
}

}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(addTag(j));}
list.add(new ItemStack(id, 1, 0));
}

public static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackFurniture.proxy.block_balls, 1, par1);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Amount", 8);
tag.setInteger("Type", par1);
is.setTagCompound(tag);
return is;
}
/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block_balls, 1, metadata));
return ret;
}
*/
public void registerBlockIcons(IIconRegister ir) {
blockIcon = ir.registerIcon("glass");
}

}
