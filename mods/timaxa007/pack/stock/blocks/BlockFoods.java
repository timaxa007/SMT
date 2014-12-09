package mods.timaxa007.pack.stock.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.pack.stock.lib.FoodForBlock;
import mods.timaxa007.pack.stock.te.TEFoods;
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

public class BlockFoods extends Block implements ITileEntityProvider {

public BlockFoods(int id) {
super(id, Material.glass);
setCreativeTab(PackStock.proxy.tabFoodPack);
setHardness(0.25F);
setResistance(0.5F);
setTextureName("planks_oak");
setUnlocalizedName("foods");
}

@Override
public TileEntity createNewTileEntity(World world) {return new TEFoods();}
public int quantityDropped(Random radom) {return 0;}
public int getRenderType() {return PackStock.proxy.render_block_foods_modelID;}
public boolean isOpaqueCube() {return false;}
//public boolean renderAsNormalBlock() {return false;}
public int idPicked(World wrd, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEFoods) {
return addTag(((TEFoods)te).getFoodID(), ((TEFoods)te).getType(), ((TEFoods)te).getColor1(), ((TEFoods)te).getColor2());
} else {
return addTag(0, 0, 0, 0);
}
}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEFoods && tag != null) {

((TEFoods)te).setRotate((int)entity.rotationYaw);
//if (!world.isRemote) {System.out.println("-r- " + (int)((entity.rotationYaw + 45F)/90));}
if (!world.isRemote) {System.out.println("-r- " + (int)((entity.rotationYaw + 22.5F)/45));}

if (tag.hasKey("FoodID")) {
((TEFoods)te).setFoodID(tag.getInteger("FoodID"));
} else {
((TEFoods)te).setFoodID(0);
}

if (tag.hasKey("Type")) {
((TEFoods)te).setType(tag.getInteger("Type"));
} else {
((TEFoods)te).setType(0);
}

if (tag.hasKey("Color1")) {
((TEFoods)te).setColor1(tag.getInteger("Color1"));
} else {
((TEFoods)te).setColor1(0);
}

if (tag.hasKey("Color2")) {
((TEFoods)te).setColor2(tag.getInteger("Color2"));
} else {
((TEFoods)te).setColor2(0);
}

}
}

@Override
public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
if (!world.isRemote) {
TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEFoods && !player.capabilities.isCreativeMode) {
dropBlockAsItem_do(world, x, y, z, addTag(((TEFoods)te).getFoodID(), ((TEFoods)te).getType(), ((TEFoods)te).getColor1(), ((TEFoods)te).getColor2()));
world.removeBlockTileEntity(x, y, z);
world.setBlockToAir(x, y, z);
}
}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for (int j = 1; j < FoodForBlock.food_list.length; ++j) {
if (FoodForBlock.food_list[j] != null) {
list.add(addTag(j, 0, FoodForBlock.food_list[j].getColor1(), FoodForBlock.food_list[j].getColor2()));
}
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1, int par2, int par3, int par4) {
ItemStack is = new ItemStack(PackStock.proxy.block_foods, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("FoodID", par1);
tag.setInteger("Type", par2);
tag.setInteger("Color1", par3);
tag.setInteger("Color2", par4);
is.setTagCompound(tag);
return is;
}

}
