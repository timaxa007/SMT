package mods.timaxa007.pack.furniture.blocks;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCnstorHalf extends Block implements ITileEntityProvider {

public BlockCnstorHalf(int id) {
super(id, Material.glass);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setHardness(1.0F);
setResistance(3.5F);
setLightOpacity(0);
setStepSound(soundWoodFootstep);
setTextureName("timaxa007:"+"woodFrame");
setUnlocalizedName("cnstor.half");
}

@Override
public TileEntity createNewTileEntity(World world) {return null;}

}
