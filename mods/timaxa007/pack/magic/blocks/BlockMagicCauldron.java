package mods.timaxa007.pack.magic.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMagicCauldron extends BlockContainer {

public BlockMagicCauldron() {
super(Material.iron);
setBlockTextureName("iron_block");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return null;}

}
