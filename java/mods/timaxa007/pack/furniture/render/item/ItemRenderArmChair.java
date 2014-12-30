package mods.timaxa007.pack.furniture.render.item;

import mods.timaxa007.lib.AddTextureModel;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderArmChair implements IItemRenderer {
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

	public ItemRenderArmChair() {

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
		NBTTagCompound tag = is.getTagCompound();
		String tex = "";
		int tmdl = 0;

		if (tag != null) {
			if (tag.hasKey("Style")) tex = tag.getString("Style");
			if (tag.hasKey("Size")) tmdl = tag.getInteger("Size");
		}

		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());

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
