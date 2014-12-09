package mods.timaxa007.Pack.Techno.Blocks;

import java.util.List;

import mods.timaxa007.Lib.TileTexture;
import mods.timaxa007.Pack.Techno.PackTechno;
import mods.timaxa007.Pack.Techno.TE.TEElectricWires;
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

public class BlockElectricWires extends BlockContainer {

public BlockElectricWires(int id) {
super(id, Material.glass);
setCreativeTab(PackTechno.proxy.tabTechnoPack);
setTextureName("glass");
setUnlocalizedName("wires");
}

@Override
public TileEntity createNewTileEntity(World world) {return new TEElectricWires();}

public int getRenderType() {return PackTechno.proxy.render_block_electric_wires_modelID;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}
public int idPicked(World wrd, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEElectricWires) {
return addTag(((TEElectricWires)te).getType(), ((TEElectricWires)te).getSize(), ((TEElectricWires)te).getColor());
} else {
return addTag(0, 0, 0xFFFFFF);
}
}


@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEElectricWires) {
/*
int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
((TEBlockJar01)te).setRot(l);;
*/
if (tag != null) {
((TEElectricWires)te).setType(tag.getInteger("Type"));
((TEElectricWires)te).setSize(tag.getInteger("Size"));
((TEElectricWires)te).setColor(tag.getInteger("Color"));
}else{
((TEElectricWires)te).setType(0);
((TEElectricWires)te).setSize(0);
((TEElectricWires)te).setColor(0xFFFFFF);
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
ItemStack is = new ItemStack(mods.timaxa007.Pack.Techno.PackTechno.proxy.block_electric_wires, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Type", par1);
tag.setInteger("Size", par2);
tag.setInteger("Color", par3);
is.setTagCompound(tag);
return is;
}

}
