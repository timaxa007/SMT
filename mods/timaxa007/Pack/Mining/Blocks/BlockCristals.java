package mods.timaxa007.Pack.Mining.Blocks;

import java.util.List;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Mining.PackMining;
import mods.timaxa007.Pack.Mining.TE.TEBlockCristals;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
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

public class BlockCristals extends Block implements ITileEntityProvider {

public BlockCristals(int id) {
super(id, Material.glass);
setCreativeTab(PackMining.proxy.tabMiningPack);
setHardness(0.25F);
setLightOpacity(0);
setTextureName("glass");
setUnlocalizedName("cristals");
}

@Override
public TileEntity createNewTileEntity(World world) {return new TEBlockCristals();}

public int getRenderType() {return PackMining.proxy.render_block_cristals_modelID;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}
public int idPicked(World wrd, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEBlockCristals) {
return addTag(((TEBlockCristals)te).getType(), ((TEBlockCristals)te).getColor(), ((TEBlockCristals)te).getSize());
} else {
return addTag(0, 0xFFFFFF, 1);
}
}


@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEBlockCristals) {
/*
int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
((TEBlockCristals)te).setRot(l);;
*/
if (tag != null) {
((TEBlockCristals)te).setType(tag.getInteger("Type"));
((TEBlockCristals)te).setColor(tag.getInteger("Color"));
((TEBlockCristals)te).setSize(tag.getInteger("Size"));
}else{
((TEBlockCristals)te).setType(0);
((TEBlockCristals)te).setColor(0xFFFFFF);
((TEBlockCristals)te).setSize(1);
}

}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for (int t = 0; t < 3; ++t) {
for (int c = 0; c < GetColors.getHexColors.length; ++c) {
for (int s = 1; s < 5; ++s) {
list.add(addTag(t, GetColors.getHexColors[c], s));
}
}
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1, int par2, int par3) {
ItemStack is = new ItemStack(PackMining.proxy.block_cristals, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Type", par1);
tag.setInteger("Color", par2);
tag.setInteger("Size", par3);
is.setTagCompound(tag);
return is;
}

}
