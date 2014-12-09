package mods.timaxa007.Pack.Furniture.RenderItems;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ItemRenderBlockCylinder implements IItemRenderer {
private IModelCustom model;

public ItemRenderBlockCylinder() {
model = AdvancedModelLoader.loadModel("/assets/timaxa007/obj/cylinder.obj");
}

@Override
public boolean handleRenderType(ItemStack item, ItemRenderType type) {
return true;
}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
return true;
}

@Override
public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/anvil_base.png"));
model.renderAll();
GL11.glPopMatrix();
}

}
