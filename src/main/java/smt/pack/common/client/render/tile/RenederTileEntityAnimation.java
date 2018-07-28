package smt.pack.common.client.render.tile;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import smt.pack.common.SMTCommon;
import smt.pack.common.client.UtilModel;
import smt.pack.common.tile.TileEntityAnimation;

public class RenederTileEntityAnimation extends TileEntitySpecialRenderer {

	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(SMTCommon.MODID, "model/teapod.obj"));

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		render((TileEntityAnimation)tile, x, y, z, parTick);
	}

	private void render(TileEntityAnimation tile, double x, double y, double z, float parTick) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);

		if (tile != null) {
			if (tile.animation_play != null) {
				//GL11.glPushMatrix();
				tile.animation_play.render(parTick);
				GL11.glDisable(GL11.GL_TEXTURE_2D);
				GL11.glColor3f(1F, 0F, 0F);
				UtilModel.box(Tessellator.instance, -0.0625, -0.0625, -0.0625, 0.0625, 0.0625, 0.0625);
				GL11.glColor3f(1F, 1F, 1F);
				GL11.glEnable(GL11.GL_TEXTURE_2D);
				//GL11.glPopMatrix();
			}
			UtilModel.renderAllOnIcon((WavefrontObject)model, Blocks.stone.getIcon(0, 0), Tessellator.instance);
		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}

}
