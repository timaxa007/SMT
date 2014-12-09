package mods.timaxa007.Pack.Furniture.RenderBlocks;

import org.lwjgl.opengl.GL11;

import mods.timaxa007.Pack.Furniture.TE.TEMashineWater;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderBlockMashineWater extends TileEntitySpecialRenderer {
private IModelCustom model;

public RenderBlockMashineWater() {
model = AdvancedModelLoader.loadModel("/assets/timaxa007/obj/masine_water.obj");
}

@Override
public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
renderTE((TEMashineWater)te, dx, dy, dz, f);
}

private void renderTE(TEMashineWater te, double dx, double dy, double dz, float f) {
//int crl_w = 0xFFFFFF;
boolean prt = false;

if (te != null) {
//crl_w = te.getColor();
prt = te.getPart();
}

//--------------------------------------------------
if (prt) {
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, -1.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
bindTexture(new ResourceLocation("minecraft", "textures/blocks/iron_block.png"));
model.renderPart("up");
model.renderPart("filter");
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
}
//--------------------------------------------------
else {
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
bindTexture(new ResourceLocation("minecraft", "textures/blocks/iron_block.png"));
model.renderPart("down");
model.renderPart("Object01");
//model.renderPart("Object02");
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
}
//--------------------------------------------------
}

}
