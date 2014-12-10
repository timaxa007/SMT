package mods.timaxa007.pack.magic.blocks;

import java.util.List;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.pack.magic.te.TEBlockLocked;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLocked extends Block implements ITileEntityProvider {

public BlockLocked() {
super(Material.iron);
setBlockUnbreakable();
setCreativeTab(PackMagic.proxy.tabMagicPack);
setBlockTextureName("planks_oak");
setBlockName("locked");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEBlockLocked();}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockLocked) {
addTag(((TEBlockLocked)te).getType());
}
return null;
}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEBlockLocked) {
if (tag != null) {
((TEBlockLocked)te).setType(tag.getInteger("Type"));
} else {
((TEBlockLocked)te).setType(0);
}
if (entity instanceof EntityPlayer) {
((TEBlockLocked)te).setOwner(((EntityPlayer)entity).getDisplayName());
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
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockLocked) {
if (player.getDisplayName().equals(((TEBlockLocked)te).getOwner())) {
//world.setBlockToAir(x, y, z);
//world.spawnEntityInWorld(new EntityItem(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, addTag(((TEBlockLocked)te).getType())));
}
}
}
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
if (world.isRemote) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockLocked) {
//player.addChatMessage("Install Block user - " + ((TEBlockLocked)te).getOwner() + ".");
return true;
}
}
return false;
}

public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEBlockLocked) {
if (player.getDisplayName().equals(((TEBlockLocked)te).getOwner())) {
System.out.println("true");
}
}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
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
