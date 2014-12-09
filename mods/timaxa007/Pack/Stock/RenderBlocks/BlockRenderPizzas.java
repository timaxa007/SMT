package mods.timaxa007.Pack.Stock.RenderBlocks;

import mods.timaxa007.Pack.Stock.TE.TEPizza;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderPizzas extends TileEntitySpecialRenderer {
private IModelCustom model;

public BlockRenderPizzas() {
model = AdvancedModelLoader.loadModel("/assets/timaxa007/obj/pizzaPart.obj");
}

public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
renderTE((TEPizza)te, dx, dy, dz, f);
}

public void renderTE(TEPizza te, double dx, double dy, double dz, float f) {
//int tex = tileEntity.getBlockMetadata();
int tex = te.getTypes();
int amt = te.getAmount();
int rot = te.getRot();

if (amt >= 1) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza.png"));break;
}
model.renderAll();
GL11.glPopMatrix();
}

if (amt >= 2) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(0F + 45F + (90F*rot), 0.0F, 0.0F, 1.0F);
switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza.png"));break;
}
model.renderAll();
GL11.glPopMatrix();
}

if (amt >= 3) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(90F + (90F*rot), 0.0F, 0.0F, 1.0F);
switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza.png"));break;
}
model.renderAll();
GL11.glPopMatrix();
}

if (amt >= 4) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(90F + 45F + (90F*rot), 0.0F, 0.0F, 1.0F);
switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza.png"));break;
}
model.renderAll();
GL11.glPopMatrix();
}

if (amt >= 5) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(180F + (90F*rot), 0.0F, 0.0F, 1.0F);
switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza.png"));break;
}
model.renderAll();
GL11.glPopMatrix();
}

if (amt >= 6) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(180F + 45F + (90F*rot), 0.0F, 0.0F, 1.0F);
switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza.png"));break;
}
model.renderAll();
GL11.glPopMatrix();
}

if (amt >= 7) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(270F + (90F*rot), 0.0F, 0.0F, 1.0F);
switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza.png"));break;
}
model.renderAll();
GL11.glPopMatrix();
}

if (amt >= 8) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(270F + 45F + (90F*rot), 0.0F, 0.0F, 1.0F);
switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pizza.png"));break;
}
model.renderAll();
GL11.glPopMatrix();
}

}

}
