package mods.timaxa007.pack.furniture.client.render.block;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.common.tile.TECnstorFence;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderCnstorFence extends TileEntitySpecialRenderer {
	private static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/fence01.obj"));

	public BlockRenderCnstorFence() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTE((TECnstorFence)te, dx, dy, dz, f);
	}

	private void renderTE(TECnstorFence te, double dx, double dy, double dz, float f) {

		int tex = te.getTypes();
		boolean sN = te.getStepN();
		boolean sS = te.getStepS();
		boolean sE = te.getStepE();
		boolean sW = te.getStepW();

		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
		/*
		if (sN&&sS&&!sE&&!sW) {
			model.renderPart("plank_c_2");
			model.renderPart("plank_c_3");
		} else if (!sN&&!sS&&sE&&sW) {
			model.renderPart("plank_c_1");
			model.renderPart("plank_c_4");
		} else {model.renderPart("pillar");}
		 */
		//f((sN&&sS&&!sE&&!sW)||(!sN&&!sS&&sE&&sW)) {;} else {
		model.renderPart("pillar");
		//}


		if (sN) {
			/*
			model.renderPart("stick_up_1");
			model.renderPart("stick_down_1");

			model.renderPart("plank_1_1");
			model.renderPart("plank_1_2");
			 */
			model.renderPart("wall_1");
		}

		if (sE) {
			/*
			model.renderPart("stick_up_2");
			model.renderPart("stick_down_2");

			model.renderPart("plank_2_1");
			model.renderPart("plank_2_2");
			 */
			model.renderPart("wall_2");
		}

		if (sW) {
			/*
			model.renderPart("stick_up_3");
			model.renderPart("stick_down_3");

			model.renderPart("plank_3_1");
			model.renderPart("plank_3_2");
			 */
			model.renderPart("wall_3");
		}

		if (sS) {
			/*
			model.renderPart("stick_up_4");
			model.renderPart("stick_down_4");

			model.renderPart("plank_4_1");
			model.renderPart("plank_4_2");
			 */
			model.renderPart("wall_4");
		}

		GL11.glPopMatrix();

	}

}
