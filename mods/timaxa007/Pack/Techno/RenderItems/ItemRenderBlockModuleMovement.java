package mods.timaxa007.Pack.Techno.RenderItems;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderBlockModuleMovement implements IItemRenderer{
private IModelCustom model;

public ItemRenderBlockModuleMovement() {
model=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/module_movement.obj");
}

@Override
public boolean handleRenderType(ItemStack is, ItemRenderType type) {return true;}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {return true;}

@Override
public void renderItem(ItemRenderType type, ItemStack is, Object... data) {
NBTTagCompound tag = is.getTagCompound();
//int tex=is.getItemDamage();
int tps=0;

if(tag!=null) {
if(tag.hasKey("Type")) {tps=tag.getInteger("Type");}
}

GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"dot_red.png"));

switch(tps) {
case 0:model.renderPart("cursor");break;
case 1:model.renderPart("move");break;
case 2:model.renderPart("jump_g");model.renderPart("jump_p");break;
default:model.renderPart("");break;
}

Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"dot_white.png"));

model.renderPart("module");

//model.renderAll();
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();

}

}
