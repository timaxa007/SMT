package mods.timaxa007.pack.magic.blocks;

import mods.timaxa007.pack.magic.tile.TEMagicCauldron;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMagicCauldron extends Block implements ITileEntityProvider {

	public BlockMagicCauldron() {
		super(Material.iron);
		setBlockTextureName("iron_block");
		setBlockName("magic_cauldron");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TEMagicCauldron();
	}

}
