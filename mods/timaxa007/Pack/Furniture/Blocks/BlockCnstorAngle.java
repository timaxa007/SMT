package mods.timaxa007.Pack.Furniture.Blocks;

import java.util.List;

import mods.timaxa007.Pack.Furniture.PackFurniture;
import mods.timaxa007.Pack.Furniture.TE.TEAngleMod;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCnstorAngle extends Block implements ITileEntityProvider {

public BlockCnstorAngle(int id) {
super(id, Material.glass);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setHardness(1.0F);
setResistance(5.0F);
setLightOpacity(0);
setStepSound(soundWoodFootstep);
setTextureName("timaxa007:" + "woodFrame");
setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
setUnlocalizedName("cnstor.angle");
}

@Override
public TileEntity createNewTileEntity(World world) {return new TEAngleMod();}
public int getRenderType() {return PackFurniture.proxy.renderBlockCnstorAngleModelID;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}
public int idPicked(World world, int x, int y, int z) {return 0;}
/*
@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEAngleMod) {

int l=MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
((TEAngleMod)te).rotation=l;

if(tag != null) {
((TEAngleMod)te).type = tag.getInteger("Type");
((TEAngleMod)te).size = tag.getInteger("Size");
((TEAngleMod)te).uping = tag.getBoolean("UPing");
}else{
((TEAngleMod)te).type = 0;
((TEAngleMod)te).size = 0;
((TEAngleMod)te).uping = false;
}

}
}
*/
@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
//for (int j = 0; j < TileTexture.consMT.length; ++j) {
//for (byte i = 0; i < 16; ++i) {
//int j=0;

list.add(addTag(0, 0));
//}
//}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1, int par2) {
ItemStack is=new ItemStack(PackFurniture.proxy.block_cnstor_angle, 1, 0);
NBTTagCompound tag=new NBTTagCompound();
tag.setInteger("Type", par2);
tag.setInteger("Size", par1);
is.setTagCompound(tag);
return is;
}

}
