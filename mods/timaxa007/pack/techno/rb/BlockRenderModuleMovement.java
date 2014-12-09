package mods.timaxa007.pack.techno.rb;

import mods.timaxa007.pack.techno.te.TEModuleMovement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderModuleMovement extends TileEntitySpecialRenderer{
private IModelCustom model;

public BlockRenderModuleMovement() {
model=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/module_movement.obj");
}

public void renderTileEntityAt(TileEntity tileEntity, double d1, double d2, double d3, float f) {
this.renderTE((TEModuleMovement)tileEntity, d1, d2, d3, f);
}

public void renderTE(TEModuleMovement tileEntity, double d1, double d2, double d3, float f) {
int tps=tileEntity.getTypes();
int rot=tileEntity.getRot();

GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"dot_red.png"));

switch(tps) {
case 0:model.renderPart("cursor");break;
case 1:model.renderPart("move");break;
case 2:model.renderPart("jump_g");model.renderPart("jump_p");break;
default:model.renderPart("");break;
}

bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"dot_white.png"));

model.renderPart("module");

//model.renderAll();
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();

}

}
