package mods.timaxa007.Pack.Furniture.Blocks;

import java.util.List;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Furniture.PackFurniture;
import mods.timaxa007.Pack.Furniture.TE.TEBlockBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlocks extends Block implements ITileEntityProvider {

@SideOnly(Side.CLIENT) private Icon[] icon_array;

public static String[] type_block = new String[] {
"wood_white", 
"stone_brick_white", 
"glass_white"
};

public BlockBlocks(int id, Material mat) {
super(id, mat);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setTextureName("planks_oak");
setUnlocalizedName("block_blocks");
}

@Override
public TileEntity createNewTileEntity(World world) {return new TEBlockBlocks();}

@SideOnly(Side.CLIENT)
public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
TileEntity te = block_access.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEBlockBlocks) {
return ((TEBlockBlocks)te).getColorBlock();
}
return 0xFFFFFF;
}

@SideOnly(Side.CLIENT)
public Icon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
TileEntity te = block_access.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEBlockBlocks) {
return icon_array[((TEBlockBlocks)te).getSubID()];
}
return getIcon(side, block_access.getBlockMetadata(x, y, z));
}

public int idPicked(World world, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEBlockBlocks) {
return addTag(world.getBlockId(x, y, z), ((TEBlockBlocks)te).getSubID(), ((TEBlockBlocks)te).getColorBlock());
} else {
return addTag(world.getBlockId(x, y, z), 0, 0xFFFFFF);
}
}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEBlockBlocks && tag != null) {

if (tag.hasKey("SubID")) {((TEBlockBlocks)te).setSubID((int)tag.getByte("SubID"));} else {((TEBlockBlocks)te).setSubID(0);}

if (tag.hasKey("ColorBlock")) {((TEBlockBlocks)te).setColorBlock(tag.getInteger("ColorBlock"));} else {((TEBlockBlocks)te).setColorBlock(0xFFFFFF);}

}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for (int i = 0; i < type_block.length; i++) {
//for (int j = 0; j < 16; j++) {
int j = 14;
list.add(addTag(id, i, GetColors.getHexColors[j]));
//}
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1, int par2, int par3) {
ItemStack is = new ItemStack(par1, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setByte("SubID", (byte)par2);
tag.setInteger("ColorBlock", par3);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
icon_array = new Icon[type_block.length];
for (int i = 0; i < icon_array.length; ++i) {
icon_array[i] = ir.registerIcon("timaxa007:" + 
(
blockID == PackFurniture.proxy.block_rock_blocks.blockID ? "stone/" : 
blockID == PackFurniture.proxy.block_glass_blocks.blockID ? "glass/" :
blockID == PackFurniture.proxy.block_wood_blocks.blockID ? "wood/" :
blockID == PackFurniture.proxy.block_ground_blocks.blockID ? "ground/" :
blockID == PackFurniture.proxy.block_sand_blocks.blockID ? "sand/" :
blockID == PackFurniture.proxy.block_cloth_blocks.blockID ? "cloth/" :
blockID == PackFurniture.proxy.block_metal_blocks.blockID ? "iron/" : ""
) + type_block[i]);
}
}

}
