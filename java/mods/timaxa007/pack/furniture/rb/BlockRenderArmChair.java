package mods.timaxa007.pack.furniture.rb;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.te.TEArmChair;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderArmChair extends TileEntitySpecialRenderer{
private IModelCustom mdl1;
private IModelCustom mdl2;
private IModelCustom mdl3;
private IModelCustom mdl4;
private IModelCustom mdl5;
private IModelCustom mdl6;
private IModelCustom mdl7;
private IModelCustom mdl8;
private IModelCustom mdl9;
private IModelCustom mdl10;
private IModelCustom mdl11;
private IModelCustom mdl12;

public BlockRenderArmChair() {
mdl1=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair_center.obj"));
mdl2=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair_angle.obj"));
mdl3=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair_tri.obj"));
mdl4=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair1.obj"));
mdl5=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair1_left.obj"));
mdl6=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair1_right.obj"));
mdl7=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair2.obj"));
mdl8=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair2_left.obj"));
mdl9=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair2_right.obj"));
mdl10=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair3.obj"));
mdl11=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair3_left.obj"));
mdl12=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armchair3_right.obj"));
}

public void renderTileEntityAt(TileEntity tileEntity, double d1, double d2, double d3, float f) {
this.renderTE((TEArmChair)tileEntity, d1, d2, d3, f);
}

public void renderTE(TEArmChair tileEntity, double d1, double d2, double d3, float f) {
int rot=tileEntity.getRotation();
int tmdl=tileEntity.getSize();
int tex=tileEntity.getType();
//int rot=2;
//int tex=0;

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

switch(tmdl) {
case 0:this.mdl1.renderAll();break;
case 1:this.mdl2.renderAll();break;
case 2:this.mdl3.renderAll();break;
case 3:this.mdl4.renderAll();break;
case 4:this.mdl5.renderAll();break;
case 5:this.mdl6.renderAll();break;
case 6:this.mdl7.renderAll();break;
case 7:this.mdl8.renderAll();break;
case 8:this.mdl9.renderAll();break;
case 9:this.mdl10.renderAll();break;
case 10:this.mdl11.renderAll();break;
case 11:this.mdl12.renderAll();break;
default:this.mdl1.renderAll();break;
}

GL11.glPopMatrix();
}

}
