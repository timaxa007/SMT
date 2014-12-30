package mods.timaxa007.pack.furniture.render.block;

import mods.timaxa007.lib.AddTextureModel;
import mods.timaxa007.pack.furniture.tile.TileEntityArmChair;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderArmChair extends TileEntitySpecialRenderer {
	private static final IModelCustom mdl1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair_center.obj"));
	private static final IModelCustom mdl2 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair_angle.obj"));
	private static final IModelCustom mdl3 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair_tri.obj"));
	private static final IModelCustom mdl4 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair1.obj"));
	private static final IModelCustom mdl5 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair1_left.obj"));
	private static final IModelCustom mdl6 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair1_right.obj"));
	private static final IModelCustom mdl7 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair2.obj"));
	private static final IModelCustom mdl8 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair2_left.obj"));
	private static final IModelCustom mdl9 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair2_right.obj"));
	private static final IModelCustom mdl10 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair3.obj"));
	private static final IModelCustom mdl11 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair3_left.obj"));
	private static final IModelCustom mdl12 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair3_right.obj"));

	public BlockRenderArmChair() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityArmChair)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityArmChair te, double dx, double dy, double dz, float f) {
		int rot = te.getRotation();
		int tmdl = te.getSize();
		String tex = te.getType();
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

		bindTexture(AddTextureModel.list[0].getTexture());

		switch(tmdl) {
		case 0:mdl1.renderAll();break;
		case 1:mdl2.renderAll();break;
		case 2:mdl3.renderAll();break;
		case 3:mdl4.renderAll();break;
		case 4:mdl5.renderAll();break;
		case 5:mdl6.renderAll();break;
		case 6:mdl7.renderAll();break;
		case 7:mdl8.renderAll();break;
		case 8:mdl9.renderAll();break;
		case 9:mdl10.renderAll();break;
		case 10:mdl11.renderAll();break;
		case 11:mdl12.renderAll();break;
		default:mdl1.renderAll();break;
		}

		GL11.glPopMatrix();
	}

}
