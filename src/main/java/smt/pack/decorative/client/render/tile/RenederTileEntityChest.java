package smt.pack.decorative.client.render.tile;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import smt.pack.decorative.SMTDecorative;
import smt.pack.decorative.tile.TileEntityChest;

public class RenederTileEntityChest extends TileEntitySpecialRenderer {

	//private ModelChest modelChest = new ModelChest();
	//public static final ModelSit model = new ModelSit();
	public static final ResourceLocation texture = new ResourceLocation(SMTDecorative.MODID, "textures/blocks/sit.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		render((TileEntityChest)tile, x, y, z, parTick);
	}

	private void render(TileEntityChest tile, double x, double y, double z, float parTick) {

	}


}
