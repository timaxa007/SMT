package mods.timaxa007.Pack.Stock.RenderBlocks;

import mods.timaxa007.Pack.Stock.TE.TEFoods;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class BlockRenderFoods extends TileEntitySpecialRenderer {

@Override
public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
renderTE((TEFoods)te, dx, dy, dz, f);
}

private void renderTE(TEFoods te, double dx, double dy, double dz, float f) {

}

}
