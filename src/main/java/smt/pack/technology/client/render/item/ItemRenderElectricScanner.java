package smt.pack.technology.client.render.item;

import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import smt.pack.common.client.UtilModel;
import smt.pack.technology.SMTTechnology;

public class ItemRenderElectricScanner implements IItemRenderer {

	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(SMTTechnology.MODID, "model/detector.obj"));
	private static Tessellator tessellator = Tessellator.instance;

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if (data.length > 1) {
			if (data[1] instanceof EntityClientPlayerMP) {
			EntityClientPlayerMP player = (EntityClientPlayerMP)data[1];
			//System.out.println(player.getCommandSenderName());
			}
		}
		GL11.glPushMatrix();
		if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
			GL11.glTranslatef(0.5F, 1.0F, 0.5F);
			GL11.glRotatef(65F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-25F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(65F, 0.0F, 0.0F, 1.0F);
		}
		GL11.glScalef(1.5F, 1.5F, 1.5F);

		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		UtilModel.renderPartOnIcon((WavefrontObject)model, "body", Blocks.anvil.getIcon(0, 0), tessellator);
		UtilModel.renderPartOnIcon((WavefrontObject)model, "switch", Blocks.planks.getIcon(0, 0), tessellator);

		GL11.glPushMatrix();
		GL11.glRotatef(-90F, 1F, 0F, 0F);//Поворот текста
		GL11.glTranslated(0.0D, 0.40D, 0.125D);//Перемещение текста
		GL11.glScalef(0.005F, -0.005F, -0.005F);//Размер текста
		FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
		String[] names = {
				"Test text 1.",
				"Test text 2.",
				EnumChatFormatting.OBFUSCATED + "Test text 3."
		};
		//RenderHelper.disableStandardItemLighting();
		for (int i = 0; i < names.length; ++i)
			fontrenderer.drawString(names[i], -fontrenderer.getStringWidth(names[i]) / 2, 0 + i * 13, 0xFFFF00);
		//RenderHelper.enableStandardItemLighting();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();

		GL11.glPopMatrix();
	}

}
