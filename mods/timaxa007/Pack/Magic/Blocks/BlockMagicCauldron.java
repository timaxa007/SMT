package mods.timaxa007.Pack.Magic.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMagicCauldron extends BlockContainer {

public BlockMagicCauldron(int id) {
super(id, Material.iron);
setTextureName("iron_block");
}

@Override
public TileEntity createNewTileEntity(World world) {return null;}

}
