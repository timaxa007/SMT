package mods.timaxa007.Pack.Furniture.RenderBlocks;

import mods.timaxa007.Pack.Furniture.TE.TECrystals;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderCrystals extends TileEntitySpecialRenderer {
private IModelCustom model;

public BlockRenderCrystals() {
model = AdvancedModelLoader.loadModel("/assets/timaxa007/obj/cristal.obj");
}

public void renderTileEntityAt(TileEntity te, double d1, double d2, double d3, float f) {
renderTE((TECrystals)te, d1, d2, d3, f);
}

private void renderTE(TECrystals te, double d1, double d2, double d3, float f) {
//int tex = te.getBlockMetadata();
int tex = te.getTypes();
int amt = te.getAmount();
int rot = te.getRot();

GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
//GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(0F + (90F*rot), 0.0F, 0.0F, 1.0F);

switch(tex) {
case 0:GL11.glColor4f(0.1F, 0.1F, 0.1F, 0.5F);break;
case 1:GL11.glColor4f(0.0F, 0.0F, 1.0F, 0.5F);break;
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

bindTexture(new ResourceLocation("timaxa007", "textures/obj/modelCristal.png"));
model.renderAll();
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();

}

}
