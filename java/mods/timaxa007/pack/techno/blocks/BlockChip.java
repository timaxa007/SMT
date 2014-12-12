package mods.timaxa007.pack.techno.blocks;

import java.util.List;

import mods.timaxa007.pack.techno.PackTechno;
import mods.timaxa007.pack.techno.te.TEChip;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockChip extends BlockContainer{
/*
private static boolean keepFurnaceInventory;
private final Random furnaceRand=new Random();
private boolean isActive;
*/
public BlockChip() {
super(Material.iron);
setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
setCreativeTab(PackTechno.proxy.tab_techno_pack);
setHardness(0.5F);
setResistance(1.0F);
setBlockTextureName("iron_block");
setBlockName("electric.chip");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEChip();}

public int getRenderType() {return -1;}
public boolean renderAsNormalBlock() {return false;}
public boolean isOpaqueCube() {return false;}
public int idPicked(World wrd, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World wrd, int x, int y, int z) {
TileEntity te=wrd.getTileEntity(x, y, z);
if((te!=null)&&(te instanceof TEChip)) {
return addTag(((TEChip)te).getTypes());
}
return addTag(0);
}
/*
@Override
public boolean onBlockActivated(World wrd, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
TileEntity te=wrd.getTileEntity(x, y, z);
//if(!wrd.isRemote) {return false;}
if(player.isSneaking()) {return false;}
if((te!=null)&&(te instanceof TEChip)) {
player.openGui(PackTechno.instance, (blockID-2000), wrd, x, y, z);
return true;
}
return false;
}
*/
/*
public void breakBlock(World wrd, int x, int y, int z, int blkid, int blkmeta) {
if(!keepFurnaceInventory) {
TEChip tileentityfurnace=(TEChip)wrd.getTileEntity(x, y, z);

if(tileentityfurnace!=null) {
for(int j1=0;j1 < tileentityfurnace.getSizeInventory();++j1) {
ItemStack itemstack=tileentityfurnace.getStackInSlot(j1);

if(itemstack!=null) {
float f=furnaceRand.nextFloat()*0.8F+0.1F;
float f1=furnaceRand.nextFloat()*0.8F+0.1F;
float f2=furnaceRand.nextFloat()*0.8F+0.1F;

while (itemstack.stackSize>0) {
int k1=furnaceRand.nextInt(21)+10;

if(k1>itemstack.stackSize) {k1=itemstack.stackSize;}

itemstack.stackSize-=k1;
EntityItem entityitem=new EntityItem(wrd, (double)((float)x+f), (double)((float)y+f1), (double)((float)z+f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

if(itemstack.hasTagCompound()) {
entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
}

float f3=0.05F;
entityitem.motionX=(double)((float)furnaceRand.nextGaussian()*f3);
entityitem.motionY=(double)((float)furnaceRand.nextGaussian()*f3+0.2F);
entityitem.motionZ=(double)((float)furnaceRand.nextGaussian()*f3);
wrd.spawnEntityInWorld(entityitem);
}
}
}

wrd.func_96440_m(x, y, z, blkid);
}
}

super.breakBlock(wrd, x, y, z, blkid, blkmeta);
}
*/

public void onEntityCollidedWithBlock(World wrd, int x, int y, int z, Entity entity) {
TileEntity te=wrd.getTileEntity(x, y, z);
if((te!=null)&&(te instanceof TEChip)) {
if(((TEChip)te).getRotation()==0) {entity.motionZ+=0.1D;}
else if(((TEChip)te).getRotation()==1) {entity.motionX-=0.1D;}
else if(((TEChip)te).getRotation()==3) {entity.motionX+=0.1D;}
else if(((TEChip)te).getRotation()==2) {entity.motionZ-=0.1D;}
else{}
}

entity.motionX*=0.5D;
entity.motionZ*=0.5D;

}

@Override
public void onBlockPlacedBy(World wrd, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te=wrd.getTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if((te!=null)&&(te instanceof TEChip)) {

int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
((TEChip)te).setRotation(l);

if(tag!=null) {

if(tag.hasKey("Type")) {
((TEChip)te).setType(tag.getInteger("Type"));
}else{
((TEChip)te).setType(0);
}
}else{
((TEChip)te).setType(0);
}

}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
//for(int j=0;j<TileTexture.tt01.length;++j) {
int j=0;
list.add(addTag(j));
//}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is=new ItemStack(PackTechno.proxy.block_chip, 1, 0);
NBTTagCompound tag=new NBTTagCompound();
tag.setInteger("Type", par1);
is.setTagCompound(tag);
return is;
}

}
