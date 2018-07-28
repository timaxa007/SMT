package smt.pack.decorative.client.render.tile;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import smt.pack.common.SMTCommon;
import smt.pack.common.client.UtilModel;
import smt.pack.decorative.tile.TileEntityModelView;

public class RenederTileEntityModelView extends TileEntitySpecialRenderer {

	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(SMTCommon.MODID, "model/teapod.obj"));
	static final Tessellator tessellator = Tessellator.instance;
	static final Minecraft mc = Minecraft.getMinecraft();

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		render((TileEntityModelView)tile, x, y, z, parTick);
	}

	private void render(TileEntityModelView tile, double x, double y, double z, float parTick) {
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		if (tile != null) {

			if (tile.translateX != 0 || tile.translateY != 0 || tile.translateZ != 0)
				GL11.glTranslatef(tile.translateX, tile.translateY, tile.translateZ);

			if (tile.rotateX != 0) GL11.glRotatef(tile.rotateX, 1, 0, 0);
			if (tile.rotateY != 0) GL11.glRotatef(tile.rotateY, 0, 1, 0);
			if (tile.rotateZ != 0) GL11.glRotatef(tile.rotateZ, 0, 0, 1);

			if (tile.scaleX != 1 || tile.scaleY != 1 || tile.scaleZ != 1)
				GL11.glScalef(tile.scaleX, tile.scaleY, tile.scaleZ);

			IIcon icon = Blocks.emerald_block.getIcon(0, 0);
			//GL11.glDisable(GL11.GL_CULL_FACE);
			//GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
			bindTexture(TextureMap.locationBlocksTexture);
			UtilModel.renderAllOnIcon((WavefrontObject)model, icon, tessellator);
			//GL11.glEnable(GL11.GL_CULL_FACE);
			//GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
		}
		GL11.glDisable(GL11.GL_BLEND);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();

		double x_fix = -(mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * parTick);
		double y_fix = -(mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * parTick);
		double z_fix = -(mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * parTick);

		GL11.glPushMatrix();
		GL11.glTranslated(x_fix, y_fix, z_fix);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(0.25F, 0.65F, 0.9F, 0.25F);
		UtilModel.box(tessellator, tile.getRenderBoundingBox());
		GL11.glColor4f(0F, 0.25F, 1F, 0.5F);
		UtilModel.lines(tile.getRenderBoundingBox());
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();

	}

}
