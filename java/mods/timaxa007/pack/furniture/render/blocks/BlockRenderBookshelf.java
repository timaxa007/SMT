package mods.timaxa007.pack.furniture.render.blocks;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.tile.TileEntityBookshelf;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderBookshelf extends TileEntitySpecialRenderer {
	private static final IModelCustom mdl1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/bookshelf_side.obj"));
	private static final IModelCustom mdl2 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/bookshelf_shelf.obj"));
	private static final IModelCustom mdlB = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/book.obj"));

	public BlockRenderBookshelf() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityBookshelf)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityBookshelf te, double dx, double dy, double dz, float f) {
		int tex = te.getType();
		int rot = te.getRotation();
		//int cont = te.getCount();
		int cont = 0;
		//int rot = 2;
		float par1 = 0.0625F;
		float par2 = 0.01F;

		GL11.glPushMatrix();
		GL11.glTranslatef((float)dx+0.5F, (float)dy, (float)dz+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		switch(rot) {
		case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
		case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
		case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
		case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
		default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
		}

		bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
		mdl1.renderAll();
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glTranslatef((float)dx+0.5F, (float)dy+(par1*7), (float)dz+0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		switch(rot) {
		case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
		case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
		case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
		case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
		default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
		}

		bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
		mdl2.renderAll();
		GL11.glPopMatrix();

	}

}
