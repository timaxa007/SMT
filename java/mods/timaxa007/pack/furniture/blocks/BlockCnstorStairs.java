package mods.timaxa007.pack.furniture.blocks;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCnstorStairs extends Block implements ITileEntityProvider {

public BlockCnstorStairs() {
super(Material.glass);
setCreativeTab(PackFurniture.proxy.tab_furniture_pack);
setHardness(1.0F);
setResistance(3.5F);
setLightOpacity(0);
setStepSound(soundTypeWood);
setBlockTextureName("timaxa007:" + "woodFrame");
setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
setBlockName("cnstor.stairs");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return null;}

}
