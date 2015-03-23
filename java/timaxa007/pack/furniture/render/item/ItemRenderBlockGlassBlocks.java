package timaxa007.pack.furniture.render.item;

import timaxa007.pack.furniture.block.BlockGlassBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderBlockGlassBlocks implements IItemRenderer {

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

		int tex = 0;
		int clr = 0xFFFFFF;

		if (nbt != null) {
			if (nbt.hasKey("SubID")) tex = nbt.getByte("SubID");
			if (nbt.hasKey("ColorBlock")) clr = nbt.getInteger("ColorBlock");
		}

		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_LIGHTING);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/blocks/glass/" + BlockGlassBlocks.type_block[tex] + "_overlay.png"));

		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(clr);

		tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
		tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 1.0D, 0.0D);

		tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 0.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 1.0D, 1.0D);

		tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 0.0D, 0.0D);

		tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 0.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);

		tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 0.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 1.0D, 1.0D);

		tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 0.0D, 0.0D);

		tessellator.draw();

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

}
