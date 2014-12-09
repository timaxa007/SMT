package mods.timaxa007.Pack.Furniture.RenderBlocks;

import mods.timaxa007.Lib.TileTexture;
import mods.timaxa007.Pack.Furniture.TE.TEBoxParticles;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderBoxParticles extends TileEntitySpecialRenderer{
private IModelCustom model;

public BlockRenderBoxParticles() {
model=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/boxparticle.obj");
}

public void renderTileEntityAt(TileEntity tileEntity, double d1, double d2, double d3, float f) {
this.renderTE((TEBoxParticles)tileEntity, d1, d2, d3, f);
}

public void renderTE(TEBoxParticles tileEntity, double d1, double d2, double d3, float f) {
//int tex=tileEntity.getBlockMetadata();
int tex=tileEntity.getTypes();
int rot=tileEntity.getRot();

GL11.glPushMatrix();
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

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));

this.model.renderAll();

GL11.glPopMatrix();

}

}
