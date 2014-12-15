package mods.timaxa007.pack.furniture.blocks;

import java.util.Random;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AirLight extends Block {

public AirLight() {
super(Material.air);
setCreativeTab(PackFurniture.proxy.tab_furniture);
setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
setBlockTextureName("glass");
setBlockName("air_light");
}

public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {return null;}
//public int getRenderType() {return 4;}
public int idDropped(int par1, Random random, int par3) {return 0;}
public int quantityDropped(Random random) {return 0;}
public boolean renderAsNormalBlock() {return false;}
public boolean isOpaqueCube() {return false;}

@SideOnly(Side.CLIENT)
public boolean shouldSideBeRendered(IBlockAccess block_access, int x, int y, int z, int side) {return false;}

}
