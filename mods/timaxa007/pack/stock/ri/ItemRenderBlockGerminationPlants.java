package mods.timaxa007.pack.stock.ri;

import org.lwjgl.opengl.GL11;

import mods.timaxa007.lib.ModelT;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderBlockGerminationPlants implements IItemRenderer {

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
/*
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glDisable(GL11.GL_LIGHTING);

Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/blocks/germination/0.png"));

Tessellator tessellator = Tessellator.instance;
tessellator.startDrawingQuads();

//Up
tessellator.addVertexWithUV(1.0D, 0.5D, 0.0D, 1.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 0.5D, 0.0D, 0.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 0.5D, 1.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(1.0D, 0.5D, 1.0D, 1.0D, 1.0D);
//Down
tessellator.addVertexWithUV(1.0D, 0.5D, 1.0D, 1.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 0.5D, 1.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 0.5D, 0.0D, 0.0D, 0.0D);
tessellator.addVertexWithUV(1.0D, 0.5D, 0.0D, 1.0D, 0.0D);

//-----
tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D + (slc * 4), 0.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D + (slc * 4), 1.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D + (slc * 4), 1.0D, 0.0D);
tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D + (slc * 4), 0.0D, 0.0D);

tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D + (slc * 4), 1.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D + (slc * 4), 0.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D + (slc * 4), 0.0D, 1.0D);
tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D + (slc * 4), 1.0D, 1.0D);
//---
tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D - (slc * 4), 0.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D - (slc * 4), 1.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D - (slc * 4), 1.0D, 0.0D);
tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D - (slc * 4), 0.0D, 0.0D);

tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D - (slc * 4), 1.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D - (slc * 4), 0.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D - (slc * 4), 0.0D, 1.0D);
tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D - (slc * 4), 1.0D, 1.0D);
//-----
tessellator.addVertexWithUV(0.0D + (slc * 4), 1.0D, 1.0D, 1.0D, 0.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 1.0D, 0.0D, 0.0D, 0.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 0.0D, 0.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 0.0D, 1.0D, 1.0D, 1.0D);

tessellator.addVertexWithUV(0.0D + (slc * 4), 0.0D, 1.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 0.0D, 0.0D, 1.0D, 1.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 1.0D, 0.0D, 1.0D, 0.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 1.0D, 1.0D, 0.0D, 0.0D);
//---
tessellator.addVertexWithUV(1.0D - (slc * 4), 1.0D, 1.0D, 1.0D, 0.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 1.0D, 0.0D, 0.0D, 0.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 0.0D, 0.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 0.0D, 1.0D, 1.0D, 1.0D);

tessellator.addVertexWithUV(1.0D - (slc * 4), 0.0D, 1.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 0.0D, 0.0D, 1.0D, 1.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 1.0D, 0.0D, 1.0D, 0.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 1.0D, 1.0D, 0.0D, 0.0D);

tessellator.draw();

GL11.glEnable(GL11.GL_LIGHTING);
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
*/
}

}
