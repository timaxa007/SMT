package mods.timaxa007.Pack.Furniture.RenderBlocks;

import mods.timaxa007.Lib.TileTexture;
import mods.timaxa007.Pack.Furniture.PackInfo;
import mods.timaxa007.Pack.Furniture.TE.TEBookshelf;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderBookshelf extends TileEntitySpecialRenderer{
private IModelCustom mdl1;
private IModelCustom mdl2;
private IModelCustom mdlB;

public BlockRenderBookshelf() {
mdl1=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/bookshelf_side.obj");
mdl2=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/bookshelf_shelf.obj");
mdlB=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/book.obj");
}

public void renderTileEntityAt(TileEntity tileEntity, double d1, double d2, double d3, float f) {
this.renderTE((TEBookshelf)tileEntity, d1, d2, d3, f);
}

public void renderTE(TEBookshelf tileEntity, double d1, double d2, double d3, float f) {
//int meta=tileEntity.getBlockMetadata();
int tex=tileEntity.getType();
int rot=tileEntity.getRotation();
//int cont=tileEntity.getCount();
int cont=0;
//int rot=2;
float par1=0.0625F;
float par2=0.01F;

GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
mdl1.renderAll();
GL11.glPopMatrix();

GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2+(par1*7), (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
mdl2.renderAll();
GL11.glPopMatrix();

}

}
