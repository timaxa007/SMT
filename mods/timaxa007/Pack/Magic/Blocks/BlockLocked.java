package mods.timaxa007.Pack.Magic.Blocks;

import java.util.List;

import mods.timaxa007.Pack.Magic.PackMagic;
import mods.timaxa007.Pack.Magic.TE.TEBlockLocked;
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

public class BlockLocked extends Block implements ITileEntityProvider {

public BlockLocked(int id) {
super(id, Material.iron);
setBlockUnbreakable();
setCreativeTab(PackMagic.proxy.tabMagicPack);
setTextureName("planks_oak");
setUnlocalizedName("locked");
}

@Override
public TileEntity createNewTileEntity(World world) {return new TEBlockLocked();}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEBlockLocked) {
addTag(((TEBlockLocked)te).getType());
}
return null;
}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEBlockLocked) {
if (tag != null) {
((TEBlockLocked)te).setType(tag.getInteger("Type"));
((TEBlockLocked)te).setOwner(entity.getEntityName());
} else {
((TEBlockLocked)te).setType(0);
((TEBlockLocked)te).setOwner(entity.getEntityName());
}
}
}

/*
public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
super.harvestBlock(world, player, x, y, z, meta);

}
*/

public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
if (!world.isRemote) {
TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEBlockLocked) {
if (player.username.equals(((TEBlockLocked)te).getOwner())) {
world.destroyBlock(x, y, z, true);
}
}
}
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
if (world.isRemote) {
TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEBlockLocked) {
player.addChatMessage("Install Block user - " + ((TEBlockLocked)te).getOwner() + ".");
return true;
}
}
return false;
}

public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null && te instanceof TEBlockLocked) {
if (player.username.equals(((TEBlockLocked)te).getOwner())) {
System.out.println("true");
}
}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
list.add(addTag(0));
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackMagic.proxy.block_locked, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Type", par1);
is.setTagCompound(tag);
return is;
}

}
