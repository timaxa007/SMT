package mods.timaxa007.pack.techno.rb;

import mods.timaxa007.pack.techno.te.TEChip;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderChip extends TileEntitySpecialRenderer{
private IModelCustom mdl1;

public BlockRenderChip() {
mdl1=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/chip01.obj"));
}

public void renderTileEntityAt(TileEntity te, double d1, double d2, double d3, float f) {
this.renderTE((TEChip)te, d1, d2, d3, f);
}

public void renderTE(TEChip te, double d1, double d2, double d3, float f) {
int rot=te.getRotation();
//int tmdl=tileEntity.getSize();
int tex=te.getTypes();
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

this.bindTexture(new ResourceLocation("minecraft", "textures/blocks/comparator_off.png"));
this.mdl1.renderPart("base");
this.bindTexture(new ResourceLocation("minecraft", "textures/blocks/redstone_block.png"));
this.mdl1.renderPart("chip");
this.bindTexture(new ResourceLocation("minecraft", "textures/blocks/iron_block.png"));
this.mdl1.renderPart("leg_l1");
this.mdl1.renderPart("leg_l2");
this.mdl1.renderPart("leg_l3");
this.mdl1.renderPart("leg_l4");
this.mdl1.renderPart("leg_l5");
this.mdl1.renderPart("leg_r1");
this.mdl1.renderPart("leg_r2");
this.mdl1.renderPart("leg_r3");
this.mdl1.renderPart("leg_r4");
this.mdl1.renderPart("leg_r5");

GL11.glPopMatrix();
}

}
