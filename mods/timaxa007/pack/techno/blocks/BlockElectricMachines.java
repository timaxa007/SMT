package mods.timaxa007.pack.techno.blocks;

import java.util.Random;

import mods.timaxa007.pack.techno.PackTechno;
import mods.timaxa007.pack.techno.te.TEElectricMachines;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockElectricMachines extends BlockContainer{

public BlockElectricMachines() {
super(Material.iron);
setCreativeTab(PackTechno.proxy.tabTechnoPack);
setHardness(0.5F);
setResistance(1.0F);
setBlockTextureName("planks_oak");
setBlockName("electric.Machines");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEElectricMachines();}

public void onBlockPlacedBy(World wrd, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te=wrd.getTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if((te!=null)&&(te instanceof TEElectricMachines)) {

int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
((TEElectricMachines)te).setRot(l);;

if(tag!=null) {
((TEElectricMachines)te).setTypes(tag.getInteger("Type"));;
}else{
((TEElectricMachines)te).setTypes(0);
}

if(is.hasDisplayName()) {
((TEElectricMachines)te).setGuiDisplayName(is.getDisplayName());
}

}
}

public void onNeighborBlockChange(World wrd, int x, int y, int z, int par5) {
if(!wrd.isRemote) {
if(wrd.isBlockIndirectlyGettingPowered(x, y, z)) {

desBreak(wrd, x, y, z);

}
}
}

public void updateTick(World wrd, int x, int y, int z, Random rdm) {
if(!wrd.isRemote&&!wrd.isBlockIndirectlyGettingPowered(x, y, z)) {

//desBreak(wrd, x, y, z);

}
}

private void desBreak(World wrd, int x, int y, int z) {
++x;
wrd.destroyBlock(x, y, z, true);
}

public boolean onBlockActivated(World wrd, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
TileEntity te=wrd.getTileEntity(x, y, z);
//if(!wrd.isRemote) {return false;}
if(player.isSneaking()) {return false;}
if(te!=null&&te instanceof TEElectricMachines) {
player.openGui(PackTechno.instance, PackTechno.proxy.guiElectricMachines, wrd, x, y, z);
return true;
}
return false;
}

}
