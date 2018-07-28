package smt.pack.technology.client.render.tile;

import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

public class RenederTileEntityTank extends TileEntitySpecialRenderer {

	RenderBlocks renderBlocks = RenderBlocks.getInstance();

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		//render((TileEntityTank)tile, x, y, z, parTick);
	}

	private void render(TileEntity/*Tank*/ tile, double x, double y, double z, float parTick) {

		//RenderBlocks line 657
		IIcon iicon = BlockLiquid.getLiquidIcon("water_still");
		renderBlocks.renderFaceYPos(Blocks.cauldron, (double)x, (double)((float)y - 1.0F + BlockCauldron.getRenderLiquidLevel(8)), (double)z, iicon);

	}

}
