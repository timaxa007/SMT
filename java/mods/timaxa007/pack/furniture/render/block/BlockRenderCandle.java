package mods.timaxa007.pack.furniture.render.block;

import mods.timaxa007.lib.AddTextureModel;
import mods.timaxa007.pack.furniture.render.model.ModelCandle;
import mods.timaxa007.pack.furniture.render.model.ModelCandles;
import mods.timaxa007.pack.furniture.tile.TileEntityCandle;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BlockRenderCandle extends TileEntitySpecialRenderer {
	private static final ModelCandle model = new ModelCandle();
	private static final ResourceLocation texture = new ResourceLocation("timaxa007", "textures/obj/test_uw.png");

	public BlockRenderCandle() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityCandle)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityCandle te, double dx, double dy, double dz, float f) {
		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		//GL11.glTranslatef(0.525F, 1.5F, 0.475F);
		//GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

		bindTexture(texture);

		Tessellator tessellator = Tessellator.instance;
		ModelCandles.addSliceCake(tessellator, dx, dy, dz, 8, 4);
		
		//model.render();
		GL11.glPopMatrix();
	}

}
