package mods.timaxa007.pack.furniture.render.block;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.tile.TileEntityGrills;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderGrills extends TileEntitySpecialRenderer {
	private static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/grill01.obj"));

	public BlockRenderGrills() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityGrills)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityGrills te, double dx, double dy, double dz, float f) {
		//int tex = te.getBlockMetadata();
		int tex = te.getTypes();
		//int amt = te.getAmount();
		int rot = te.getRot();

		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		switch(rot) {
		case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
		case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
		case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
		case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
		default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
		}

		bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));

		model.renderPart("grill");
		model.renderPart("grid");

		GL11.glPopMatrix();

	}

}
