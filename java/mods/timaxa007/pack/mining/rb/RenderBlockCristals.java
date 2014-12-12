package mods.timaxa007.pack.mining.rb;

import mods.timaxa007.pack.mining.te.TECristals;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class RenderBlockCristals extends TileEntitySpecialRenderer {
private IModelCustom model1;
private IModelCustom model2;
private IModelCustom model3;

public RenderBlockCristals() {
model1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/cristal01.obj"));
model2 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/cristal02.obj"));
model3 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/cristal03.obj"));
}

@Override
public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
renderTE((TECristals)te, dx, dy, dz, f);
}

private void renderTE(TECristals te, double dx, double dy, double dz, float f) {
int typ = 0;
int crl = 0xFFFFFF;
int siz = 1;

if (te != null) {
typ = te.getType();
crl = te.getColor();
siz = te.getSize();
}

//--------------------------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
float red = (float)(crl >> 16 & 255) / 255.0F;
float green = (float)(crl >> 8 & 255) / 255.0F;
float blue = (float)(crl >> 0 & 255) / 255.0F;
GL11.glColor3f(red, green, blue);
GL11.glScalef(1.0F/(float)siz, 1.0F/(float)siz, 1.0F/(float)siz);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/water.png"));
switch(typ) {
case 0:model1.renderAll();break;
case 1:model2.renderAll();break;
case 2:model3.renderAll();break;
default:model1.renderAll();break;
}
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------------------------
}

}
