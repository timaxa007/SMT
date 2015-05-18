package timaxa007.pack.magic.block;

import timaxa007.pack.magic.PackMagic;
import timaxa007.pack.magic.tile.TileEntityMagicCauldron;
import timaxa007.smt.object.ModifiedBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMagicCauldron extends ModifiedBlock implements ITileEntityProvider {

	public BlockMagicCauldron(String tag) {
		super(tag, Material.iron);
		setBlockTextureName("iron_block");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityMagicCauldron();
	}

	public int getRenderType() {
		return PackMagic.render.block_magic_cauldron_modelID;
	}

}
