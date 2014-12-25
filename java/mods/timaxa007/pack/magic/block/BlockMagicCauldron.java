package mods.timaxa007.pack.magic.block;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.pack.magic.tile.TileEntityMagicCauldron;
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
		return new TileEntityMagicCauldron();
	}

	public int getRenderType() {
		return PackMagic.proxy.render.block_magic_cauldron_modelID;
	}

}
