package mods.timaxa007.pack.furniture.ri;

import mods.timaxa007.lib.TileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderArmChair implements IItemRenderer {
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

public ItemRenderArmChair() {
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

@Override
public boolean handleRenderType(ItemStack is, ItemRenderType type) {
return true;
}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
return true;
}

@Override
public void renderItem(ItemRenderType type, ItemStack is, Object... data) {
NBTTagCompound tag = is.getTagCompound();
int tex=0;
int tmdl=0;

if(tag!=null) {
if(tag.hasKey("Type")) {tex=tag.getInteger("Type");}
if(tag.hasKey("Size")) {tmdl=tag.getInteger("Size");}
}

GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));

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
