package mods.timaxa007.pack.techno.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.timaxa007.pack.techno.PackTechno;
import mods.timaxa007.pack.techno.te.TEModuleMovement;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockModuleMovement extends BlockContainer{

public String typeModule[]= new String[]{
"Cursor", 
"Move", 
"Jump"
};

public BlockModuleMovement() {
super(Material.circuits);
setCreativeTab(PackTechno.proxy.tabTechnoPack);
setHardness(0.5F);
setResistance(0.1F);
setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
setBlockTextureName("planks_oak");
setBlockName("module.movement");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEModuleMovement();}

public int getRenderType() {return -1;}
public boolean renderAsNormalBlock() {return false;}
public boolean isOpaqueCube() {return false;}
public int idPicked(World wrd, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World wrd, int x, int y, int z) {
TileEntity te=wrd.getTileEntity(x, y, z);
if((te!=null)&&(te instanceof TEModuleMovement)) {
return addTag(((TEModuleMovement)te).getTypes());
}
return addTag(0);
}

/*
public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
float f = 0.125F;
return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
}
*/
public void onEntityCollidedWithBlock(World wrd, int x, int y, int z, Entity entity) {
TileEntity te=wrd.getTileEntity(x, y, z);
if((te!=null)&&(te instanceof TEModuleMovement)) {
if(((TEModuleMovement)te).getTypes()==0) {

if(((TEModuleMovement)te).getRot()==3) {entity.motionX+=0.1D;}
else if(((TEModuleMovement)te).getRot()==1) {entity.motionX-=0.1D;}
else if(((TEModuleMovement)te).getRot()==0) {entity.motionZ+=0.1D;}
else if(((TEModuleMovement)te).getRot()==2) {entity.motionZ-=0.1D;}
else{entity.motionY+=0.1D;}

}else if(((TEModuleMovement)te).getTypes()==1) {
//entity.motionX*=2.0D;
if(((TEModuleMovement)te).getRot()==3) {if(entity.motionX>0&&entity.motionX<3.0D) {entity.motionX*=2.1D;}}
else if(((TEModuleMovement)te).getRot()==1) {if(entity.motionX<0&&entity.motionX>-3.0D) {entity.motionX*=2.1D;}}
else if(((TEModuleMovement)te).getRot()==0) {if(entity.motionZ>0&&entity.motionZ<3.0D) {entity.motionZ*=2.1D;}}
else if(((TEModuleMovement)te).getRot()==2) {if(entity.motionZ<0&&entity.motionZ>-3.0D) {entity.motionZ*=2.1D;}}
else{entity.motionY*=0.1D;}

}else if(((TEModuleMovement)te).getTypes()==2) {

if(entity.motionY>=0.0D&&entity.motionY<10.0D) {
entity.motionY+=0.1D;
//entity.motionY*=0.1D;
}

if(((TEModuleMovement)te).getRot()==3) {
entity.motionX+=0.01D;
}
else if(((TEModuleMovement)te).getRot()==1) {
entity.motionX-=0.01D;
}
else if(((TEModuleMovement)te).getRot()==0) {
entity.motionZ+=0.01D;
}
else if(((TEModuleMovement)te).getRot()==2) {
entity.motionZ-=0.01D;
}
else{entity.motionY+=0.1D;}

}else{
entity.motionX*=0.4D;
entity.motionZ*=0.4D;
}
}
}

@Override
public boolean onBlockActivated(World wrd, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
TileEntity te=wrd.getTileEntity(x, y, z);
//if(!wrd.isRemote) {return false;}
if(player.isSneaking()) {return false;}
if((te!=null)&&(te instanceof TEModuleMovement)) {
return true;
}
return false;
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for(int j=0;j<typeModule.length;++j) {
list.add(addTag(j));
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is=new ItemStack(PackTechno.proxy.block_module_movement, 1, 0);
NBTTagCompound tag=new NBTTagCompound();
tag.setInteger("Type", par1);
is.setTagCompound(tag);
return is;
}

}
