package mods.timaxa007.pack.furniture.render.block;

import mods.timaxa007.pack.furniture.render.model.ModelCandle;
import mods.timaxa007.pack.furniture.tile.TECandle;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BlockRenderCandle extends TileEntitySpecialRenderer {
	private static final ModelCandle model = new ModelCandle();

	public BlockRenderCandle() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTE((TECandle)te, dx, dy, dz, f);
	}

	private void renderTE(TECandle te, double dx, double dy, double dz, float f) {
		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.525F, 1.5F, 0.475F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

		switch(te.getBlockMetadata()) {
		case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_black.png"));break;
		case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_blue.png"));break;
		case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_brown.png"));break;
		case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_cyan.png"));break;
		case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_gray.png"));break;
		case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_green.png"));break;
		case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_light_blue.png"));break;
		case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_light_gray.png"));break;
		case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_light_green.png"));break;
		case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_magenta.png"));break;
		case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_orange.png"));break;
		case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_pink.png"));break;
		case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_purple.png"));break;
		case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_red.png"));break;
		case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_white.png"));break;
		case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_yellow.png"));break;
		default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_red.png"));break;
		}

		model.render();
		GL11.glPopMatrix();
	}

}
