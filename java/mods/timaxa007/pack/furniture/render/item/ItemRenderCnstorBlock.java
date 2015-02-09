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

public class ItemRenderCnstorBlock implements IItemRenderer {
	private static final IModelCustom mdlS = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_side.obj"));
	private static final IModelCustom mdlT = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_top.obj"));
	private static final IModelCustom mdlB = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_bottom.obj"));

	public ItemRenderCnstorBlock() {

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
		NBTTagCompound nbt = is.getTagCompound();

		String tex = "";
		int clr = 0xFFFFFF;

		if (nbt != null) {
			if (nbt.hasKey("Type")) tex = nbt.getString("Style");
			if (nbt.hasKey("Color")) clr = nbt.getInteger("Color");
		}

		float red = (float)(clr >> 16 & 255)/255;
		float green = (float)(clr >> 8 & 255)/255;
		float blue = (float)(clr & 255)/255;
		float alfa = 1.0F;
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-90F, 0.0F, 0.0F, 1.0F);
		GL11.glColor4f(red , green , blue, alfa);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdlS.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
		GL11.glColor4f(red , green , blue, alfa);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdlS.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
		GL11.glColor4f(red , green , blue, alfa);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdlS.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glColor4f(red , green , blue, alfa);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdlS.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glColor4f(red , green , blue, alfa);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdlT.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		//--------------------------------
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glColor4f(red , green , blue, alfa);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdlB.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		//--------------------------------


	}

}
