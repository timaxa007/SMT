package mods.timaxa007.pack.furniture.blocks;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TECnstorFence;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCnstorFence extends Block implements ITileEntityProvider {

public BlockCnstorFence() {
super(Material.glass);
setCreativeTab(PackFurniture.proxy.tab_furniture);
setHardness(1.0F);
setResistance(3.5F);
setLightOpacity(0);
setStepSound(soundTypeWood);
setBlockTextureName("timaxa007:" + "woodFrame");
setBlockName("cnstor.fence");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TECnstorFence();}
public int getRenderType() {return PackFurniture.proxy.render_block_cnstor_fence_modelID;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TECnstorFence) {
return addTag(((TECnstorFence)te).getTypes());
}
return addTag(0);
}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if(te != null && te instanceof TECnstorFence) {
if(tag!=null) {
((TECnstorFence)te).setTypes(tag.getInteger("Type"));
}else{
((TECnstorFence)te).setTypes(0);
}
}
}

@Override
public void breakBlock(World world, int x, int y, int z, Block id, int meta) {}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
//for (int  j = 0; j < TileTexture.texTest01.length; ++j) {
//for (byte i = 0; i < 16; ++i) {
int j = 0;

list.add(addTag(j));
//}
//}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackFurniture.proxy.block_cnstor_fence, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Type", par1);
is.setTagCompound(tag);
return is;
}


}
