package mods.timaxa007.pack.furniture.ri;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderBalls implements IItemRenderer {

private IModelCustom model;

public ItemRenderBalls() {
model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/sphere.obj"));
}

@Override
public boolean handleRenderType(ItemStack is, ItemRenderType type) {return true;}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {return true;}

@Override
public void renderItem(ItemRenderType type, ItemStack is, Object... data) {
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/diamond_block.png"));
model.renderAll();
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
}

}
