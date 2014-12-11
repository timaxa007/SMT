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

public class ItemRenderBoxParticles implements IItemRenderer{
private IModelCustom model;

public ItemRenderBoxParticles() {
model=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/boxparticle.obj"));
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

this.model.renderAll();

GL11.glPopMatrix();

}

}