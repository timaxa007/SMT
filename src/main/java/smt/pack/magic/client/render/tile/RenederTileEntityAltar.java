package smt.pack.magic.client.render.tile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import smt.pack.UtilBlock;
import smt.pack.magic.tile.TileEntityAltar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenederTileEntityAltar extends TileEntitySpecialRenderer {

	private static Minecraft mc = Minecraft.getMinecraft();

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		render2((TileEntityAltar)tile, x, y, z, parTick);
	}

	private void render(TileEntityAltar tile, double x, double y, double z, float parTick) {
		Tessellator tessellator = Tessellator.instance;
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_CULL_FACE);

		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(255.0F, 0.0F, 0.0F, 0.5F);
		tessellator.addVertex(-0.25D, 0D, -0.25D);
		tessellator.addVertex(-0.25D, 0D, 0.25D);
		tessellator.addVertex(0.25D, 0D, 0.25D);
		tessellator.addVertex(0.25D, 0D, -0.25D);
		tessellator.draw();
		GL11.glPopMatrix();

		if (tile.list_use != null && tile.list_use.size() > 0)
			for (int i = 0; i < tile.list_use.size(); ++i) {
				UtilBlock.BlockPosState bps = tile.list_use.get(i);
				UtilBlock.BlockPosState bps2 = tile.list_use.get((i == tile.list_use.size() - 1 ? 0 : i + 1));
				//System.out.println("bps " + i);
				//System.out.println("bps " + bps.getBlockPos().x + ", " + bps.getBlockPos().y + ", " + bps.getBlockPos().z + ".");
				GL11.glPushMatrix();
				GL11.glTranslatef(
						(float)((double)bps.getBlockPos().x - TileEntityRendererDispatcher.staticPlayerX) + 0.5F, 
						(float)((double)bps.getBlockPos().y - TileEntityRendererDispatcher.staticPlayerY) + 1.25F, 
						(float)((double)bps.getBlockPos().z - TileEntityRendererDispatcher.staticPlayerZ) + 0.5F);
				//GL11.glRotatef(-mc.thePlayer.rotationYaw + 180F, 0.0F, 1.0F, 0.0F);
				//GL11.glRotatef(-mc.thePlayer.rotationPitch + 90F, 1.0F, 0.0F, 0.0F);

				GL11.glBegin(GL11.GL_LINES);
				GL11.glVertex3d(0D, 0D, 0D);//a - 1
				GL11.glVertex3d((double)-(bps.getBlockPos().x - bps2.getBlockPos().x),
						(double)-(bps.getBlockPos().y - bps2.getBlockPos().y),
						(double)-(bps.getBlockPos().z - bps2.getBlockPos().z));//b - 2
				GL11.glEnd();

				tessellator.startDrawingQuads();
				tessellator.setColorRGBA_F(255.0F, 0.0F, 0.0F, 0.5F);
				tessellator.addVertex(-0.25D, 0D, -0.25D);
				tessellator.addVertex(-0.25D, 0D, 0.25D);
				tessellator.addVertex(0.25D, 0D, 0.25D);
				tessellator.addVertex(0.25D, 0D, -0.25D);
				tessellator.draw();
				/*
				tessellator.startDrawingQuads();

				tessellator.setColorRGBA_F(255.0F, 0.0F, 0.0F, 0.5F);
				tessellator.addVertex(-0.25D, 0D, -0.25D);
				tessellator.addVertex(-0.25D, 0D, 0.25D);
				tessellator.addVertex((double)-(bps.getBlockPos().x - bps2.getBlockPos().x) + 0.25D,
						(double)-(bps.getBlockPos().y - bps2.getBlockPos().y),
						(double)-(bps.getBlockPos().z - bps2.getBlockPos().z) + 0.25D);
				tessellator.addVertex((double)-(bps.getBlockPos().x - bps2.getBlockPos().x) + 0.25D,
						(double)-(bps.getBlockPos().y - bps2.getBlockPos().y),
						(double)-(bps.getBlockPos().z - bps2.getBlockPos().z) + -0.25D);
				tessellator.draw();
				 */
				GL11.glPopMatrix();
			}

		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glPopMatrix();
	}

	private void render2(TileEntityAltar tile, double x, double y, double z, float parTick) {
		Tessellator tessellator = Tessellator.instance;
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslated(x, y, z);

		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(255.0F, 0.0F, 0.0F, 0.5F);
		tessellator.addVertex(-0.25D, 0D, -0.25D);
		tessellator.addVertex(-0.25D, 0D, 0.25D);
		tessellator.addVertex(0.25D, 0D, 0.25D);
		tessellator.addVertex(0.25D, 0D, -0.25D);
		tessellator.draw();
		GL11.glPopMatrix();

		if (tile.list_use != null && tile.list_use.size() > 0)
			for (int i = 0; i < tile.list_use.size(); ++i) {
				UtilBlock.BlockPosState bps = tile.list_use.get(i);
				//UtilBlock.BlockPosState bps2 = tile.list_use.get((i == tile.list_use.size() - 1 ? 0 : i + 1));

				GL11.glBegin(GL11.GL_LINES);
				GL11.glVertex3f(0.5F, 1.25F, 0.5F);//a - 1
				GL11.glVertex3f((float)((double)bps.getBlockPos().x - TileEntityRendererDispatcher.staticPlayerX - x) + 0.5F, 
						(float)((double)bps.getBlockPos().y - TileEntityRendererDispatcher.staticPlayerY - y) + 1.25F, 
						(float)((double)bps.getBlockPos().z - TileEntityRendererDispatcher.staticPlayerZ - z) + 0.5F);//b - 2
				GL11.glEnd();
				/*
				tessellator.startDrawingQuads();
				tessellator.setColorRGBA_F(255.0F, 0.0F, 0.0F, 0.5F);
				tessellator.addVertex(-0.25D, 0D, -0.25D);
				tessellator.addVertex(-0.25D, 0D, 0.25D);
				tessellator.addVertex(0.25D, 0D, 0.25D);
				tessellator.addVertex(0.25D, 0D, -0.25D);
				tessellator.draw();
				 */
			}

		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glPopMatrix();
	}

}
