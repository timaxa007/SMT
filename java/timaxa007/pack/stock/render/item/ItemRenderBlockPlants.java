package timaxa007.pack.stock.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import timaxa007.pack.conjoint.lib.ModelT;

public class ItemRenderBlockPlants implements IItemRenderer {

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
		double slc = (double)1/16;

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glRotatef(-90.0F, 1, 0, 0);
		GL11.glTranslatef(0.0F, -1.0F, 0.0F - (float)slc);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("textures/blocks/planks_oak.png"));
		ModelT.addBox(1.0D - (slc * 11) - 0.01D, 1.0D - (slc * 4) - 0.01D, 1.0D, 0.0D + (slc * 4) + 0.01D, 0.0D + (slc * 11) + 0.01D, 0.0D);
		ModelT.addBox(1.0D - (slc * 4) - 0.01D, 1.0D - (slc * 4) - 0.01D, 1.0D, 0.0D + (slc * 11) + 0.01D, 0.0D + (slc * 11) + 0.01D, 0.0D);
		ModelT.addBox(1.0D - (slc * 11) - 0.01D, 1.0D - (slc * 11) - 0.01D, 1.0D, 0.0D + (slc * 4) + 0.01D, 0.0D + (slc * 4) + 0.01D, 0.0D);
		ModelT.addBox(1.0D - (slc * 4) - 0.01D, 1.0D - (slc * 11) - 0.01D, 1.0D, 0.0D + (slc * 11) + 0.01D, 0.0D + (slc * 4) + 0.01D, 0.0D);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
		//------------------------------------------------------------------------------------------------------
		/* Переделать, передлать. */
	}

}
