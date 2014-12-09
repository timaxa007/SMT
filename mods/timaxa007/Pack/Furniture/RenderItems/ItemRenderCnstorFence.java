package mods.timaxa007.Pack.Furniture.RenderItems;

import mods.timaxa007.Lib.TileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderCnstorFence implements IItemRenderer{
private IModelCustom model;

public ItemRenderCnstorFence() {
model=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/fence01.obj");
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
//int tex=tileEntity.getBlockMetadata();
//int tex=is.getItemDamage();
int tex=0;

if(tag!=null) {
if(tag.hasKey("Type")) {tex=tag.getInteger("Type");}
}

GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));

this.model.renderPart("pillar");/*
this.model.renderPart("stick_up_1");
this.model.renderPart("stick_down_1");
this.model.renderPart("stick_up_2");
this.model.renderPart("stick_down_2");
this.model.renderPart("stick_up_3");
this.model.renderPart("stick_down_3");
this.model.renderPart("stick_up_4");
this.model.renderPart("stick_down_4");*/

GL11.glPopMatrix();

}

}