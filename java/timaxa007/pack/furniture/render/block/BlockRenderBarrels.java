package timaxa007.pack.furniture.render.block;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import timaxa007.pack.conjoint.lib.AddTextureModel;
import timaxa007.pack.furniture.tile.TileEntityBarrels;

public class BlockRenderBarrels extends TileEntitySpecialRenderer {

	private static final IModelCustom model = 
			AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/furniture/barrel_01.obj"));
	private static final ResourceLocation texture1 = AddTextureModel.get("minecraft_log_oak").getTexture();
	private static final ResourceLocation texture2 = AddTextureModel.get("minecraft_planks_oak").getTexture();
	private static final ResourceLocation texture3 = AddTextureModel.get("minecraft_iron_block").getTexture();

	public BlockRenderBarrels() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityBarrels)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityBarrels te, double dx, double dy, double dz, float f) {
		//------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		bindTexture(texture1);
		model.renderPart("body");
		GL11.glPopMatrix();
		//------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		bindTexture(texture2);
		model.renderPart("cap_up");
		GL11.glPopMatrix();
		//------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		bindTexture(texture2);
		model.renderPart("cap_down");
		GL11.glPopMatrix();
		//------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		bindTexture(texture3);
		model.renderPart("hoop_up");
		GL11.glPopMatrix();
		//------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		bindTexture(texture3);
		model.renderPart("hoop_down");
		GL11.glPopMatrix();
		//------------------------------------------
	}

}
