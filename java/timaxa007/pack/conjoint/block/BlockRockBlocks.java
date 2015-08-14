package timaxa007.pack.conjoint.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.conjoint.PackConjoint;
import timaxa007.pack.conjoint.object.ModifiedBlock;

public class BlockRockBlocks extends ModifiedBlock {

	public BlockRockBlocks(String tag) {
		super(tag, Material.rock);
		setCreativeTab(PackConjoint.tab_conjoint);
		setBlockTextureName("stone");
	}

	//RenderingRegistry.instance().renderWorldBlock(renderer, world, x, y, z, block, modelId);
	
	public int getRenderType() {
		return PackConjoint.render.rock_blocks_renderID;
	}

}
