package smt.pack.decorative.client.render.tile;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import smt.pack.common.client.UtilModel;
import smt.pack.decorative.client.event.EventsForgeClient;
import smt.pack.decorative.tile.TileEntityBlocksDecorative;

public class RenederTileEntityBlocksDecorative extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		render((TileEntityBlocksDecorative)tile, x, y, z, parTick);
	}

	private void render(TileEntityBlocksDecorative tile, double x, double y, double z, float parTick) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glDisable(GL11.GL_LIGHTING);
		bindTexture(TextureMap.locationBlocksTexture);
		Tessellator tessellator = Tessellator.instance;
		/*
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDepthMask(true);
		UtilModel.boxOnIcon(tessellator, Blocks.lava.getIcon(0, 0), 0D, 0D, 0D, 1D, 1D, 1D);
		GL11.glDisable(GL11.GL_BLEND);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_DST_COLOR, GL11.GL_SRC_COLOR);
		GL11.glDepthMask(false);
		UtilModel.boxOnIcon(tessellator, EventsForgeClient.cr7_1, 0D, 0D, 0D, 1D, 1D, 1D);
		GL11.glDisable(GL11.GL_BLEND);
		 */

		//GL11.glDepthMask(true);
		/*
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 127.0F, 1.0F);
		UtilModel.boxOnIcon(tessellator, EventsForgeClient.dust_overlay, -0.01D, -0.01D, -0.01D, 1.01D, 1.01D, 1.01D);
		GL11.glDisable(GL11.GL_BLEND);
		 */

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		UtilModel.boxOnIcon(tessellator, EventsForgeClient.dust_overlay, -0.001D, -0.001D, -0.001D, 1.001D, 1.001D, 1.001D);
		GL11.glDisable(GL11.GL_BLEND);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		UtilModel.boxOnIcon(tessellator, Blocks.lava.getIcon(0, 0), 0D, 0D, 0D, 1D, 1D, 1D);
		GL11.glDisable(GL11.GL_BLEND);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_DST_COLOR, GL11.GL_SRC_COLOR);
		UtilModel.boxOnIcon(tessellator, EventsForgeClient.cr7_1, 0D, 0D, 0D, 1D, 1D, 1D);
		GL11.glDisable(GL11.GL_BLEND);

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}

}
