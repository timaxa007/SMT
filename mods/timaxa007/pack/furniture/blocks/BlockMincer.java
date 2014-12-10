package mods.timaxa007.pack.furniture.blocks;

import java.util.Random;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TEMincer;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMincer extends BlockContainer{
private static boolean keepFurnaceInventory;
private final Random furnaceRand=new Random();
private boolean isActive;

public BlockMincer() {
super(Material.iron);
setStepSound(soundMetalFootstep);
setBlockTextureName("iron_block");
setHardness(0.5F);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setBlockName("mincer");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEMincer();}
public int getRenderType() {return -1;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}

public void onBlockPlacedBy(World wrd, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
int i1=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
wrd.setBlock(x, y, z, blockID, i1, 3);
if(is.hasDisplayName()) {((TEMincer)wrd.getTileEntity(x, y, z)).setGuiDisplayName(is.getDisplayName());
}
}

@Override
public boolean onBlockActivated(World wrd, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
TileEntity te=wrd.getTileEntity(x, y, z);
//if(!wrd.isRemote) {return false;}
if(player.isSneaking()) {return false;}
if((te!=null)&&(te instanceof TEMincer)) {
player.openGui(PackFurniture.instance, PackFurniture.proxy.guiMincer, wrd, x, y, z);
return true;
}
return false;
}

public void breakBlock(World wrd, int x, int y, int z, int blkid, int blkmeta) {
if(!keepFurnaceInventory) {
TEMincer tileentityfurnace=(TEMincer)wrd.getTileEntity(x, y, z);

if(tileentityfurnace!=null) {
for(int j1=0;j1<tileentityfurnace.getSizeInventory();++j1) {
ItemStack itemstack=tileentityfurnace.getStackInSlot(j1);

if(itemstack!=null) {
float f=furnaceRand.nextFloat()*0.8F+0.1F;
float f1=furnaceRand.nextFloat()*0.8F+0.1F;
float f2=furnaceRand.nextFloat()*0.8F+0.1F;

while (itemstack.stackSize>0) {
int k1=furnaceRand.nextInt(21)+10;

if(k1>itemstack.stackSize) {k1=itemstack.stackSize;}

itemstack.stackSize-=k1;
EntityItem entityitem=new EntityItem(wrd, (double)((float)x+f), (double)((float)y+f1), (double)((float)z+f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

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

public static void updateFurnaceBlockState(boolean par0, World wrd, int x, int y, int z) {
int l=wrd.getBlockMetadata(x, y, z);
TileEntity tileentity=wrd.getTileEntity(x, y, z);
keepFurnaceInventory=true;
/*
if(par0) {
wrd.setBlock(x, y, z, PackFurniture.blockMincer.blockID);
}
else
{
wrd.setBlock(x, y, z, PackFurniture.blockMincer.blockID);
}
 */
keepFurnaceInventory=false;
wrd.setBlockMetadataWithNotify(x, y, z, l, 2);

if(tileentity!=null) {
tileentity.validate();
wrd.setBlockTileEntity(x, y, z, tileentity);
}
}

}
