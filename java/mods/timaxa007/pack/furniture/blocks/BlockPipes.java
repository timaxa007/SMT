package mods.timaxa007.pack.furniture.blocks;

import java.util.List;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TEPipes;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPipes extends BlockContainer {

public BlockPipes() {
super(Material.glass);
setCreativeTab(PackFurniture.proxy.tab_furniture_pack);
setBlockTextureName("glass");
setBlockName("pipes");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEPipes();}

public int getRenderType() {return PackFurniture.proxy.render_block_pipes_modelID;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}
public int idPicked(World wrd, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEPipes) {
return addTag(((TEPipes)te).getType(), ((TEPipes)te).getSize(), ((TEPipes)te).getColor());
} else {
return addTag(0, 0, 0xFFFFFF);
}
}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEPipes) {
/*
int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
((TEJar01)te).setRot(l);
*/
if (tag != null) {
((TEPipes)te).setType(tag.getInteger("Type"));
((TEPipes)te).setSize(tag.getInteger("Size"));
((TEPipes)te).setColor(tag.getInteger("Color"));
} else {
((TEPipes)te).setType(0);
((TEPipes)te).setSize(0);
((TEPipes)te).setColor(0xFFFFFF);
}

}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for (int j = 0; j < TileTexture.texTest01.length; ++j) {
list.add(addTag(j, 1, 0xFFFFFF));
list.add(addTag(j, 2, 0xFFFFFF));
list.add(addTag(j, 3, 0xFFFFFF));
list.add(addTag(j, 4, 0xFFFFFF));
list.add(addTag(j, 5, 0xFFFFFF));
list.add(addTag(j, 6, 0xFFFFFF));
list.add(addTag(j, 7, 0xFFFFFF));
list.add(addTag(j, 8, 0xFFFFFF));
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1, int par2, int par3) {
ItemStack is = new ItemStack(PackFurniture.proxy.block_pipes, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Type", par1);
tag.setInteger("Size", par2);
tag.setInteger("Color", par3);
is.setTagCompound(tag);
return is;
}

}
