package timaxa007.pack.furniture.render.item;

import timaxa007.smt.lib.AddTextureModel;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderAngles implements IItemRenderer {
	private static final IModelCustom mdl0_1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/triangle01_1.obj"));
	private static final IModelCustom mdl1_l = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/triangle_left.obj"));
	private static final IModelCustom mdl1_r = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/triangle_right.obj"));
	private static final IModelCustom mdl1_1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/angle_side.obj"));
	private static final IModelCustom mdlS = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_side.obj"));
	private static final IModelCustom mdlT = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_top.obj"));
	private static final IModelCustom mdlB = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_bottom.obj"));

	public ItemRenderAngles() {

	}

	@Override
	public boolean handleRenderType(ItemStack is, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack is, Object... data) {

		String tex = "";
		int mdl = 0;
		int rot = 2;
		boolean uper = false;
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdl1_l.renderAll();
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdl1_r.renderAll();
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdl1_1.renderAll();
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(0F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdlS.renderAll();
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		//GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		if (!uper) {
			mdlB.renderAll();
		} else {
			mdlT.renderAll();
		}
		GL11.glPopMatrix();
		//--------------------------------
	}

}
