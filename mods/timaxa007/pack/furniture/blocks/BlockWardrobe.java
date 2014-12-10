package mods.timaxa007.pack.furniture.blocks;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TEWardrobe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWardrobe extends BlockContainer{

public BlockWardrobe() {
super(Material.wood);
setHardness(0.5F);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setBlockTextureName("planks_oak");
setBlockName("wardrobes");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEWardrobe();}
public int getRenderType() {return -1;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}
public int idPicked(World wrd, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World wrd, int x, int y, int z) {
TileEntity te=wrd.getTileEntity(x, y, z);
int retre=0;
if((te!=null)&&(te instanceof TEWardrobe)) {
retre=((TEWardrobe)te).getType();
}
return addTag(0, retre);
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {

//for(int j=0;j<TileTexture.getTexturesConstructionCount;++j) {
//for(byte i=0;i<16;++i) {
int j=0;

list.add(addTag(0, j));
//list.add(addTag(1, j));
//list.add(addTag(2, j));
//list.add(addTag(3, j));
//list.add(addTag(4, j));
//list.add(addTag(5, j));
//list.add(addTag(6, j));
//list.add(addTag(7, j));
//list.add(addTag(8, j));
//list.add(addTag(9, j));
//list.add(addTag(10, j));
//list.add(addTag(11, j));
//}
//}
//list.add(new ItemStack(PackFurniture.blockCnstorBlock, 1, 0));
}

private static ItemStack addTag(int par1, int par2) {
ItemStack is=new ItemStack(PackFurniture.proxy.block_wardrobe, 1, par1);
NBTTagCompound tag=new NBTTagCompound();
tag.setInteger("Type", par2);
is.setTagCompound(tag);
return is;
}

}
