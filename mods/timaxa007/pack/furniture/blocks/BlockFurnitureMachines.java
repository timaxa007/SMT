package mods.timaxa007.pack.furniture.blocks;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TEFurnitureMachines;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFurnitureMachines extends BlockContainer {

public BlockFurnitureMachines(int id) {
super(id, Material.rock);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setHardness(1.0F);
setResistance(3.5F);
setTextureName("stone");
setUnlocalizedName("furniture.machines");
}

@Override
public TileEntity createNewTileEntity(World world) {return new TEFurnitureMachines();}

public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEFurnitureMachines) {

int l=MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
((TEFurnitureMachines)te).setRot(l);

if (tag!=null) {
((TEFurnitureMachines)te).setTypes(tag.getInteger("Type"));
} else {
((TEFurnitureMachines)te).setTypes(0);
}

if (is.hasDisplayName()) {
((TEFurnitureMachines)te).setGuiDisplayName(is.getDisplayName());
}

}
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
TileEntity te = world.getBlockTileEntity(x, y, z);
//if (!world.isRemote) {return false;}
if (player.isSneaking()) {return false;}
if (te != null && te instanceof TEFurnitureMachines) {
player.openGui(PackFurniture.instance, PackFurniture.proxy.guiFurnitureMachines, world, x, y, z);
return true;
}
return false;
}

}