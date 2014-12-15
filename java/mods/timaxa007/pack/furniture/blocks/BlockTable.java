package mods.timaxa007.pack.furniture.blocks;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TETable;
import net.minecraft.block.BlockContainer;
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

public class BlockTable extends BlockContainer{

public BlockTable() {
super(Material.wood);
setCreativeTab(PackFurniture.proxy.tab_furniture);
setHardness(0.5F);
setBlockTextureName("planks_oak");
setBlockName("tables");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TETable();}
public int getRenderType() {return -1;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}
public int idPicked(World wrd, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World wrd, int x, int y, int z) {
TileEntity te=wrd.getTileEntity(x, y, z);
if((te!=null)&&(te instanceof TETable)) {
return addTag(0, ((TETable)te).getType(), ((TETable)te).getSize());
}
return addTag(0, 0, 0);
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {

//for(int j=0;j<TileTexture.tt01.length;++j) {
//for(byte i=0;i<16;++i) {
int j=0;

list.add(addTag(0, j, 0));
list.add(addTag(0, j, 1));
list.add(addTag(0, j, 2));
list.add(addTag(0, j, 3));
list.add(addTag(0, j, 4));
list.add(addTag(0, j, 5));
list.add(addTag(0, j, 6));
list.add(addTag(0, j, 7));
//}
//}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1, int par2, int par3) {
ItemStack is=new ItemStack(PackFurniture.proxy.block_table, 1, 0);
NBTTagCompound tag=new NBTTagCompound();
tag.setInteger("Type", par2);
tag.setInteger("Size", par3);
is.setTagCompound(tag);
return is;
}

}
