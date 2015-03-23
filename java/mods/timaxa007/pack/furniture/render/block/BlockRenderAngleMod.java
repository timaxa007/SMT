package mods.timaxa007.pack.furniture.render.block;

import mods.timaxa007.pack.furniture.tile.TileEntityAngleMod;
import mods.timaxa007.tms.lib.AddTextureModel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderAngleMod extends TileEntitySpecialRenderer {
	private static final IModelCustom mdl0_1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/triangle01_1.obj"));
	private static final IModelCustom mdl1_l = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/triangle_left.obj"));
	private static final IModelCustom mdl1_r = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/triangle_right.obj"));
	private static final IModelCustom mdl1_1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/angle_side.obj"));
	private static final IModelCustom mdlS = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_side.obj"));
	private static final IModelCustom mdlT = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_top.obj"));
	private static final IModelCustom mdlB = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_bottom.obj"));

	public BlockRenderAngleMod() {

	}

	public void renderTileEntityAt(TileEntity te, double d1, double d2, double d3, float f) {
		renderTileEntity((TileEntityAngleMod)te, d1, d2, d3, f);
	}

	private void renderTileEntity(TileEntityAngleMod te, double d1, double d2, double d3, float f) {
		//int meta = te.getBlockMetadata();
		int tex = te.getType();
		int mdl = te.getSize();
		int rot = te.getRotation();
		boolean uper = te.getUPing();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(AddTextureModel.list[0].getTexture());
		mdl1_l.renderAll();
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(AddTextureModel.list[0].getTexture());
		mdl1_r.renderAll();
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(AddTextureModel.list[0].getTexture());
		mdl1_1.renderAll();
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(0F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(AddTextureModel.list[0].getTexture());
		mdlS.renderAll();
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		//GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(AddTextureModel.list[0].getTexture());
		if (!uper) {
			mdlB.renderAll();
		} else {
			mdlT.renderAll();
		}
		GL11.glPopMatrix();
		//--------------------------------

	}

}
