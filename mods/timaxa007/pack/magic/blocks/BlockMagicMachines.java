package mods.timaxa007.pack.magic.blocks;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.pack.magic.te.TEMagicMachines;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMagicMachines extends BlockContainer{

public BlockMagicMachines() {
super(Material.rock);
setCreativeTab(PackMagic.proxy.tabMagicPack);
setHardness(0.5F);
setResistance(1.0F);
setBlockTextureName("planks_oak");
setBlockName("magic.machines");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEMagicMachines();}

public void onBlockPlacedBy(World wrd, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te=wrd.getTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if((te!=null)&&(te instanceof TEMagicMachines)) {

int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
((TEMagicMachines)te).setRot(l);;

if(tag!=null) {
((TEMagicMachines)te).setTypes(tag.getInteger("Type"));;
}else{
((TEMagicMachines)te).setTypes(0);
}

if(is.hasDisplayName()) {
((TEMagicMachines)te).setGuiDisplayName(is.getDisplayName());
}

}
}

public boolean onBlockActivated(World wrd, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
TileEntity te=wrd.getTileEntity(x, y, z);
//if(!wrd.isRemote) {return false;}
if(player.isSneaking()) {return false;}
if(te!=null&&te instanceof TEMagicMachines) {
player.openGui(PackMagic.instance, PackMagic.proxy.guiMagicMachines, wrd, x, y, z);
return true;
}
return false;
}

}
