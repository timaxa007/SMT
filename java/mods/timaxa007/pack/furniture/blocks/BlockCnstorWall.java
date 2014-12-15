package mods.timaxa007.pack.furniture.blocks;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCnstorWall extends Block implements ITileEntityProvider {

public BlockCnstorWall() {
super(Material.glass);
setCreativeTab(PackFurniture.proxy.tab_furniture);
setHardness(1.0F);
setResistance(3.5F);
setLightOpacity(0);
setStepSound(soundTypeWood);
setBlockTextureName("timaxa007:" + "woodFrame");
setBlockName("cnstor.wall");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return null;}

}
