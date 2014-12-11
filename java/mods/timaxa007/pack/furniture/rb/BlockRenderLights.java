package mods.timaxa007.pack.furniture.rb;

import mods.timaxa007.pack.furniture.te.TELights;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class BlockRenderLights extends TileEntitySpecialRenderer {

@Override
public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
renderTE((TELights)te, dx, dy, dz,f);
}

private void renderTE(TELights te, double dx, double dy, double dz, float f) {

}

}
