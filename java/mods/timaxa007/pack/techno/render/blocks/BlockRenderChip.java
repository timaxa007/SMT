package mods.timaxa007.pack.techno.render.blocks;

import mods.timaxa007.pack.techno.tile.TileEntityChip;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderChip extends TileEntitySpecialRenderer{
	private static final IModelCustom mdl1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/chip01.obj"));

	public BlockRenderChip() {
		
	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityChip)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityChip te, double dx, double dy, double dz, float f) {
		int rot = te.getRotation();
		//int tmdl = tileEntity.getSize();
		int tex = te.getType();
		//int rot = 2;
		//int tex = 0;

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

		bindTexture(new ResourceLocation("minecraft", "textures/blocks/comparator_off.png"));
		mdl1.renderPart("base");
		bindTexture(new ResourceLocation("minecraft", "textures/blocks/redstone_block.png"));
		mdl1.renderPart("chip");
		bindTexture(new ResourceLocation("minecraft", "textures/blocks/iron_block.png"));
		mdl1.renderPart("leg_l1");
		mdl1.renderPart("leg_l2");
		mdl1.renderPart("leg_l3");
		mdl1.renderPart("leg_l4");
		mdl1.renderPart("leg_l5");
		mdl1.renderPart("leg_r1");
		mdl1.renderPart("leg_r2");
		mdl1.renderPart("leg_r3");
		mdl1.renderPart("leg_r4");
		mdl1.renderPart("leg_r5");

		GL11.glPopMatrix();
	}

}
