package smt.pack.common.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;

import org.lwjgl.opengl.GL11;

import smt.pack.common.SMTCommon;
import smt.pack.common.client.UtilModel;

public class RenederItemSword implements IItemRenderer {

	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(SMTCommon.MODID, "model/item_sword.obj"));
	public static final ResourceLocation texture = new ResourceLocation(SMTCommon.MODID, "textures/particles/test.png");

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glScalef(2F, 2F, 2F);

		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		Tessellator tessellator = Tessellator.instance;
		UtilModel.renderPartOnIcon((WavefrontObject)model, "blade", Blocks.iron_block.getIcon(2, 0), tessellator);
		UtilModel.renderPartOnIcon((WavefrontObject)model, "merge", Blocks.planks.getIcon(2, 0), tessellator);
		UtilModel.renderPartOnIcon((WavefrontObject)model, "handler", Blocks.planks.getIcon(2, 0), tessellator);

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();

		//---------------------

		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 1.0F, 0.5F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		float f6 = 0;
		float f7 = 1;
		float f8 = 0;
		float f9 = 1;

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(0.5D, 0, 0.5D, (double)f7, (double)f9);
		tessellator.addVertexWithUV(0.5D, 0, -0.5D, (double)f7, (double)f8);
		tessellator.addVertexWithUV(-0.5D, 0, -0.5D, (double)f6, (double)f8);
		tessellator.addVertexWithUV(-0.5D, 0, 0.5D, (double)f6, (double)f9);
		tessellator.draw();

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();

	}

}
