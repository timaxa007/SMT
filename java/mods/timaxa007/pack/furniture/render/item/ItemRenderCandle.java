package mods.timaxa007.pack.furniture.render.item;

import mods.timaxa007.pack.furniture.render.model.ModelCandle;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderCandle implements IItemRenderer {
	private static final ModelCandle model = new ModelCandle();

	public ItemRenderCandle() {

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
		GL11.glPushMatrix();
		GL11.glTranslatef(0.525F, 1.5F, 0.475F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

		switch(is.getItemDamage()) {
		case 0:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_black.png"));break;
		case 1:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_blue.png"));break;
		case 2:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_brown.png"));break;
		case 3:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_cyan.png"));break;
		case 4:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_gray.png"));break;
		case 5:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_green.png"));break;
		case 6:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_light_blue.png"));break;
		case 7:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_light_green.png"));break;
		case 8:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_magenta.png"));break;
		case 9:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_orange.png"));break;
		case 10:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_pink.png"));break;
		case 11:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_purple.png"));break;
		case 12:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_red.png"));break;
		case 13:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_light_gray.png"));break;
		case 14:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_white.png"));break;
		case 15:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_yellow.png"));break;
		default:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/candle/candle_red.png"));break;
		}

		model.render();
		GL11.glPopMatrix();
	}

}
