package mods.timaxa007.Pack.Furniture.RenderBlocks;

import mods.timaxa007.Lib.TileTexture;
import mods.timaxa007.Pack.Furniture.TE.TECnstorFence;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderCnstorFence extends TileEntitySpecialRenderer{
private IModelCustom model;

public BlockRenderCnstorFence() {
model=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/fence01.obj");
}

public void renderTileEntityAt(TileEntity te, double d1, double d2, double d3, float f) {
this.renderTE((TECnstorFence)te, d1, d2, d3, f);
}

public void renderTE(TECnstorFence te, double d1, double d2, double d3, float f) {
//int tex=tileEntity.getBlockMetadata();
//te.worldObj.getBlockTileEntity(par1, par2, par3)
int tex=te.getTypes();
boolean sN=te.getStepN();
boolean sS=te.getStepS();
boolean sE=te.getStepE();
boolean sW=te.getStepW();

GL11.glPushMatrix();
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
/*
if(sN&&sS&&!sE&&!sW) {
this.model.renderPart("plank_c_2");
this.model.renderPart("plank_c_3");
}else if(!sN&&!sS&&sE&&sW) {
this.model.renderPart("plank_c_1");
this.model.renderPart("plank_c_4");
}else{this.model.renderPart("pillar");}
*/
//f((sN&&sS&&!sE&&!sW)||(!sN&&!sS&&sE&&sW)) {;}else{
this.model.renderPart("pillar");
//}


if(sN) {
/*
this.model.renderPart("stick_up_1");
this.model.renderPart("stick_down_1");

this.model.renderPart("plank_1_1");
this.model.renderPart("plank_1_2");
*/
this.model.renderPart("wall_1");
}

if(sE) {
/*
this.model.renderPart("stick_up_2");
this.model.renderPart("stick_down_2");

this.model.renderPart("plank_2_1");
this.model.renderPart("plank_2_2");
*/
this.model.renderPart("wall_2");
}

if(sW) {
/*
this.model.renderPart("stick_up_3");
this.model.renderPart("stick_down_3");

this.model.renderPart("plank_3_1");
this.model.renderPart("plank_3_2");
*/
this.model.renderPart("wall_3");
}

if(sS) {
/*
this.model.renderPart("stick_up_4");
this.model.renderPart("stick_down_4");

this.model.renderPart("plank_4_1");
this.model.renderPart("plank_4_2");
*/
this.model.renderPart("wall_4");
}

GL11.glPopMatrix();

}

}
