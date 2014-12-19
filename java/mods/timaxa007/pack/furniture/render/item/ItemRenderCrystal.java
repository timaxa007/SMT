package mods.timaxa007.pack.furniture.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderCrystal implements IItemRenderer {
	private static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/cristal.obj"));

	public ItemRenderCrystal() {

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
		int tex = is.getItemDamage();

		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		switch(tex) {
		case 0:GL11.glColor4f(0.1F, 0.1F, 0.1F, 0.5F);break;
		case 1:GL11.glColor4f(0.0F, 0.0F, 255.0F, 0.5F);break;
		case 2:GL11.glColor4f(1.0F, 0.5F, 0.0F, 0.5F);break;
		case 3:GL11.glColor4f(0.0F, 0.5F, 0.5F, 0.5F);break;
		case 4:GL11.glColor4f(0.25F, 0.25F, 0.25F, 0.5F);break;
		case 5:GL11.glColor4f(0.0F, 0.5F, 0.0F, 0.5F);break;
		case 6:GL11.glColor4f(0.0F, 1.0F, 1.0F, 0.5F);break;
		case 7:GL11.glColor4f(0.75F, 0.75F, 0.75F, 0.5F);break;
		case 8:GL11.glColor4f(0.0F, 0.5F, 0.0F, 0.5F);break;
		case 9:GL11.glColor4f(1.0F, 0.0F, 1.0F, 0.5F);break;
		case 10:GL11.glColor4f(1.0F, 0.5F, 0.0F, 0.5F);break;
		case 11:GL11.glColor4f(1.0F, 0.5F, 0.5F, 0.5F);break;
		case 12:GL11.glColor4f(0.5F, 0.0F, 1.0F, 0.5F);break;
		case 13:GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);break;
		case 14:GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);break;
		case 15:GL11.glColor4f(1.0F, 1.0F, 0.0F, 0.5F);break;
		default:GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);break;
		}

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/modelCristal.png"));
		model.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();

	}

}
