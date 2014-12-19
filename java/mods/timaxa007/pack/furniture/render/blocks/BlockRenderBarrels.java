package mods.timaxa007.pack.furniture.render.blocks;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.tile.TileEntityBarrels;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderBarrels extends TileEntitySpecialRenderer {
	private static final IModelCustom mdlB = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/barrel_cone.obj"));
	private static final IModelCustom mdlP = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/barrel_top.obj"));
	private static final IModelCustom mdlCD = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/barrel_cap_down.obj"));

	public BlockRenderBarrels() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityBarrels)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityBarrels te, double dx, double dy, double dz, float f) {
		//int meta = te.getBlockMetadata();
		//int rot = te.getRotation();
		int texB = te.getTypeB();
		int texP = te.getTypeP();
		int texCD = te.getTypeCD();
		boolean lie = te.getLie();
		int rot = 2;

		GL11.glPushMatrix();
		if (lie) {
			GL11.glTranslatef((float)dx+0.5F, (float)dy+0.5F, (float)dz+1.0F);
			GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
		} else {
			GL11.glTranslatef((float)dx+0.5F, (float)dy, (float)dz+0.5F);
			GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		}
		GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
		mdlB.renderAll();
		GL11.glPopMatrix();

		if (texP>0) {
			GL11.glPushMatrix();
			if (lie) {
				GL11.glTranslatef((float)dx+0.5F, (float)dy+0.5F, (float)dz+(1.0F-0.9375F));
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
			} else {
				GL11.glTranslatef((float)dx+0.5F, (float)dy+0.9375F, (float)dz+0.5F);
				GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
			}
			GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
			bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
			mdlP.renderAll();
			GL11.glPopMatrix();
		}

		GL11.glPushMatrix();
		if (lie) {
			GL11.glTranslatef((float)dx+0.5F, (float)dy+0.5F, (float)dz+1.0F);
			GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
		} else {
			GL11.glTranslatef((float)dx+0.5F, (float)dy, (float)dz+0.5F);
			GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		}
		GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
		mdlCD.renderAll();
		GL11.glPopMatrix();

	}

}
