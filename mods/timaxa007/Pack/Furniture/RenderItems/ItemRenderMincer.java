package mods.timaxa007.Pack.Furniture.RenderItems;

import mods.timaxa007.Lib.TileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderMincer implements IItemRenderer{
private IModelCustom model;

public ItemRenderMincer() {
model=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/micer.obj");
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
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
if(type==type.EQUIPPED) {
GL11.glRotatef(15F, 0.0F, 0.0F, 1.0F);
}else if(type==type.EQUIPPED_FIRST_PERSON) {
GL11.glRotatef(-90F, 0.0F, 0.0F, 1.0F);
}else{
GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
}
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
this.model.renderAll();
GL11.glPopMatrix();
}

}
