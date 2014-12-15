package mods.timaxa007.pack.furniture.blocks;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TEArmChair;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockArmChair extends Block implements ITileEntityProvider {

public BlockArmChair() {
super(Material.glass);
setCreativeTab(PackFurniture.proxy.tab_furniture);
setHardness(0.5F);
setResistance(2.5F);
setStepSound(soundTypeWood);
setBlockTextureName("planks_oak");
setBlockName("armchair");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEArmChair();}
public int getRenderType() {return PackFurniture.proxy.render_block_armchair_modelID;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}
public int idPicked(World world, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getTileEntity(x, y, z);
if((te != null && te instanceof TEArmChair)) {
return addTag(((TEArmChair)te).getType(), ((TEArmChair)te).getSize());
}
return addTag(0, 0);
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
//for(int j = 0; j < TileTexture.texTest01.length; ++j) {
//for(byte i=0;i<16;++i) {
int j=0;

list.add(addTag(j, 0));
list.add(addTag(j, 1));
list.add(addTag(j, 2));
list.add(addTag(j, 3));
list.add(addTag(j, 4));
list.add(addTag(j, 5));
list.add(addTag(j, 6));
list.add(addTag(j, 7));
list.add(addTag(j, 8));
list.add(addTag(j, 9));
list.add(addTag(j, 10));
list.add(addTag(j, 11));
//}
//}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1, int par2) {
ItemStack is=new ItemStack(PackFurniture.proxy.block_arm_chair, 1, 0);
NBTTagCompound tag=new NBTTagCompound();
tag.setInteger("Type", par1);
tag.setInteger("Size", par2);
is.setTagCompound(tag);
return is;
}

}
