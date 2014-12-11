package mods.timaxa007.pack.furniture.rb;

import mods.timaxa007.pack.furniture.te.TECylinder;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class RenderBlockCylinder extends TileEntitySpecialRenderer {
private IModelCustom model;

public RenderBlockCylinder() {
model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/cylinder.obj"));
}

@Override
public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
renderTE((TECylinder)te, dx, dy, dz, f);
}

private void renderTE(TECylinder te, double dx, double dy, double dz, float f) {
GL11.glPushMatrix();
GL11.glDisable(GL11.GL_LIGHTING);
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
if (te != null) {
GL11.glRotatef(0F + te.rot_x, 0.0F, 1.0F, 0.0F);
GL11.glRotatef(0F + te.rot_y, 0.0F, 0.0F, 1.0F);
}
bindTexture(new ResourceLocation("minecraft", "textures/blocks/anvil_base.png"));
model.renderAll();
GL11.glEnable(GL11.GL_LIGHTING);
GL11.glPopMatrix();
}

}
