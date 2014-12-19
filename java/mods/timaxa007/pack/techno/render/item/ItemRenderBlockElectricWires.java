package mods.timaxa007.pack.techno.render.item;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.techno.render.block.BlockRenderElectricWires;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderBlockElectricWires implements IItemRenderer {

	@Override
	public boolean handleRenderType(ItemStack is, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
		if (type == type.INVENTORY) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack is, Object... data) {

		NBTTagCompound tag = is.getTagCompound();

		int typ = 0;
		int siz = 1;
		int clr = 0xFFFFFF;

		if (tag != null) {
			if (tag.hasKey("Type")) typ = tag.getInteger("Type");
			if (tag.hasKey("Size")) siz = tag.getInteger("Size");
		}

		double s_p = (double) 1 / 16;
		double ss_p = (double) s_p * siz;
		double ss_p_p_i = 8.0D + ss_p * 16;
		double ss_p_m_i = 8.0D - ss_p * 16;
		double ss_p_p = 0.5D + ss_p;
		double ss_p_m = 0.5D - ss_p;

		if (type == type.INVENTORY) {
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			Tessellator tessellator = Tessellator.instance;

			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation((String)TileTexture.texTest01[typ][0], (String)TileTexture.texTest01[typ][1]));

			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(ss_p_m_i, ss_p_p_i, 1.0D, ss_p_m, ss_p_p);
			tessellator.addVertexWithUV(ss_p_p_i, ss_p_p_i, 1.0D, ss_p_p, ss_p_p);
			tessellator.addVertexWithUV(ss_p_p_i, ss_p_m_i, 1.0D, ss_p_p, ss_p_m);
			tessellator.addVertexWithUV(ss_p_m_i, ss_p_m_i, 1.0D, ss_p_m, ss_p_m);
			tessellator.draw();
			//--------------------------------------------------
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/gold_block.png"));

			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(16.0D, ss_p_m_i + 1.0D, 0.0D, 1.0D, ss_p_p);
			tessellator.addVertexWithUV(0.0D, ss_p_m_i + 1.0D, 0.0D, 0.0D, ss_p_p);
			tessellator.addVertexWithUV(0.0D, ss_p_p_i - 1.0D, 0.0D, 0.0D, ss_p_m);
			tessellator.addVertexWithUV(16.0D, ss_p_p_i - 1.0D, 0.0D, 1.0D, ss_p_m);
			tessellator.draw();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();

		} else {

			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glDisable(GL11.GL_LIGHTING);

			//--------------------------------------------------
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation((String)TileTexture.texTest01[typ][0], (String)TileTexture.texTest01[typ][1]));

			BlockRenderElectricWires.addBox(ss_p_p, 1.0D, ss_p_p, ss_p_m, ss_p_p, ss_p_m);
			BlockRenderElectricWires.addBox(ss_p_p, ss_p_m, ss_p_p, ss_p_m, 0.0D, ss_p_m);
			BlockRenderElectricWires.addBox(1.0D, ss_p_p, ss_p_p, ss_p_p, ss_p_m, ss_p_m);
			BlockRenderElectricWires.addBox(ss_p_p, ss_p_p, 1.0D, ss_p_m, ss_p_m, ss_p_p);
			BlockRenderElectricWires.addBox(ss_p_m, ss_p_p, ss_p_p, 0.0D, ss_p_m, ss_p_m);
			BlockRenderElectricWires.addBox(ss_p_p, ss_p_p, ss_p_m, ss_p_m, ss_p_m, 0.0D);
			//--------------------------------------------------
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/gold_block.png"));

			BlockRenderElectricWires.addBox(ss_p_p - s_p, 1.0D + s_p, ss_p_p - s_p, ss_p_m + s_p, ss_p_p - s_p, ss_p_m + s_p);
			BlockRenderElectricWires.addBox(ss_p_p - s_p, ss_p_m + s_p, ss_p_p - s_p, ss_p_m + s_p, 0.0D - s_p, ss_p_m + s_p);
			BlockRenderElectricWires.addBox(1.0D + s_p, ss_p_p - s_p, ss_p_p - s_p, ss_p_p - s_p, ss_p_m + s_p, ss_p_m + s_p);
			BlockRenderElectricWires.addBox(ss_p_p - s_p, ss_p_p - s_p, 1.0D + s_p, ss_p_m + s_p, ss_p_m + s_p, ss_p_p - s_p);
			BlockRenderElectricWires.addBox(ss_p_m + s_p, ss_p_p - s_p, ss_p_p - s_p, 0.0D - s_p, ss_p_m, ss_p_m + s_p);
			BlockRenderElectricWires.addBox(ss_p_p - s_p, ss_p_p - s_p, ss_p_m + s_p, ss_p_m + s_p, ss_p_m + s_p, 0.0D - s_p);
			//--------------------------------------------------

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
		//--------------------------------------------------
	}

}
