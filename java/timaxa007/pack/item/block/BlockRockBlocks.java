package timaxa007.pack.item.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.item.PackItem;
import timaxa007.smt.object.ModifiedBlock;

public class BlockRockBlocks extends ModifiedBlock {

	public BlockRockBlocks(String tag) {
		super(tag, Material.rock);
		setCreativeTab(PackItem.tab_items);
		setBlockTextureName("stone");
	}

	//RenderingRegistry.instance().renderWorldBlock(renderer, world, x, y, z, block, modelId);
	
	public int getRenderType() {
		return PackItem.render.rock_blocks_renderID;
	}

}
