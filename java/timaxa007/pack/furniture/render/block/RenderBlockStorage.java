package timaxa007.pack.furniture.render.block;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import timaxa007.pack.furniture.tile.TileEntityStorage;
import timaxa007.tms.lib.AddTextureModel;

public class RenderBlockStorage extends TileEntitySpecialRenderer {

	private static final IModelCustom model = 
			AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/furniture/storage/storage_01.obj"));
	private static final ResourceLocation texture1 = AddTextureModel.get("minecraft_log_oak").getTexture();
	private static final ResourceLocation texture2 = AddTextureModel.get("minecraft_planks_oak").getTexture();

	public RenderBlockStorage() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityStorage)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityStorage te, double dx, double dy, double dz, float f) {

		String tag = "";
		String owner = "";
		int rotation = 0;
		String style = "";
		String custom_name = "";
		float rotation_door = 0.0F;

		if (te != null) {
			tag = "";
			owner = "";
			rotation = te.getRotation();
			style = "";
			rotation_door = te.rotation_door;
		}

		//------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		bindTexture(texture1);
		model.renderPart("box");
		GL11.glPopMatrix();
		//------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.0625F, 0.0F, 0.875F);
		if (te != null) {
			float f1 = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * f;
			f1 = 1.0F - f1;
			f1 = 1.0F - f1 * f1 * f1;
			GL11.glRotatef(-((f1 * (float)Math.PI / 2.0F) * 55.0F), 0.0F, 1.0F, 0.0F);
		}
		bindTexture(texture2);
		model.renderPart("door");
		GL11.glPopMatrix();
		//------------------------------------------
	}

}
