package mods.timaxa007.Pack.Furniture.Blocks;

import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCnstorStairs extends Block implements ITileEntityProvider {

public BlockCnstorStairs(int id) {
super(id, Material.glass);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setHardness(1.0F);
setResistance(3.5F);
setLightOpacity(0);
setStepSound(soundWoodFootstep);
setTextureName("timaxa007:" + "woodFrame");
setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
setUnlocalizedName("cnstor.stairs");
}

@Override
public TileEntity createNewTileEntity(World world) {return null;}

}
