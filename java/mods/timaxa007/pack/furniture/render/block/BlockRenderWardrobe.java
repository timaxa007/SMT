package mods.timaxa007.pack.furniture.render.block;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.tile.TileEntityWardrobe;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderWardrobe extends TileEntitySpecialRenderer {
	private static final IModelCustom mdlS = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_side.obj"));
	private static final IModelCustom mdlT = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_top.obj"));
	private static final IModelCustom mdlB = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_bottom.obj"));

	public BlockRenderWardrobe() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityWardrobe)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityWardrobe te, double dx, double dy, double dz, float f) {
		int tex = te.getType();
		//int rot = te.getRotation();
		int rot = 2;

		//front
		GL11.glPushMatrix();
		GL11.glTranslatef((float)dx+0.5F, (float)dy, (float)dz+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
		mdlS.renderAll();
		GL11.glPopMatrix();

		//right
		GL11.glPushMatrix();
		GL11.glTranslatef((float)dx+0.5F, (float)dy, (float)dz+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-90F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
		mdlS.renderAll();
		GL11.glPopMatrix();

		//back
		GL11.glPushMatrix();
		GL11.glTranslatef((float)dx+0.5F, (float)dy, (float)dz+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(0F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
		mdlS.renderAll();
		GL11.glPopMatrix();

		//left
		GL11.glPushMatrix();
		GL11.glTranslatef((float)dx+0.5F, (float)dy, (float)dz+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(90F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
		mdlS.renderAll();
		GL11.glPopMatrix();

		//top
		GL11.glPushMatrix();
		GL11.glTranslatef((float)dx+0.5F, (float)dy, (float)dz+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
		mdlT.renderAll();
		GL11.glPopMatrix();

		//bottom
		GL11.glPushMatrix();
		GL11.glTranslatef((float)dx+0.5F, (float)dy, (float)dz+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
		mdlB.renderAll();
		GL11.glPopMatrix();

	}

}