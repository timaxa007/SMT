package mods.timaxa007.Pack.Furniture.Blocks;

import java.util.List;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Furniture.PackFurniture;
import mods.timaxa007.Pack.Furniture.TE.TEJar01;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockJar01 extends Block implements ITileEntityProvider {

public BlockJar01(int id) {
super(id, Material.glass);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setHardness(0.25F);
setLightOpacity(0);
setTextureName("glass");
setUnlocalizedName("jar01");
}

@Override
public TileEntity createNewTileEntity(World world) {return new TEJar01();}

public int getRenderType() {return PackFurniture.proxy.render_block_jar01_modelID;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}
public int idPicked(World wrd, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEJar01) {
return addTag(((TEJar01)te).getColorWater());
} else {
return addTag(0xFFFFFF);
}
}


@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEJar01) {
/*
int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
((TEJar01)te).setRot(l);;
*/
if (tag != null) {
((TEJar01)te).setColorWater(tag.getInteger("ColorWater"));
}else{
((TEJar01)te).setColorWater(0xFFFFFF);
}

}
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
ItemStack current = player.getCurrentEquippedItem();
if (current != null) {
TileEntity te = world.getBlockTileEntity(x, y, z);
//--------------------------------
if (current.getItem() == PackFurniture.proxy.item_colored && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
--current.stackSize;
((TEJar01)te).setColorWater(GetColors.getHexColors[current.getItemDamage()]);
return true;
} else {
return false;
}
//--------------------------------
} else {
return false;
}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
//for (int j = 0; j < 16; ++j) {
int j = 14;
list.add(addTag(GetColors.getHexColors[j]));
//}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackFurniture.proxy.block_jar01, 1, par1);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("ColorWater", par1);
is.setTagCompound(tag);
return is;
}

}
