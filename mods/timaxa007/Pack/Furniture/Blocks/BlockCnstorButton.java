package mods.timaxa007.Pack.Furniture.Blocks;

import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCnstorButton extends Block implements ITileEntityProvider {

public BlockCnstorButton(int id) {
super(id, Material.glass);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setHardness(1.0F);
setResistance(3.5F);
setLightOpacity(0);
setStepSound(soundWoodFootstep);
setTextureName("timaxa007:" + "woodFrame");
setUnlocalizedName("cnstor.button");
}

@Override
public TileEntity createNewTileEntity(World wrd) {return null;}

}
