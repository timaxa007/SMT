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

public class ItemRenderBookshelf implements IItemRenderer{
private IModelCustom mdl1;
private IModelCustom mdl2;

public ItemRenderBookshelf() {
mdl1=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/bookshelf_side.obj");
mdl2=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/bookshelf_shelf.obj");
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
//int tex=is.getItemDamage();
int tex=0;

if(tag!=null) {
if(tag.hasKey("Type")) {tex=tag.getInteger("Type");}
}

float par1=0.0625F;
float par2=0.01F;

GL11.glPushMatrix();
GL11.glTranslatef((float)0.5F, (float)0.0F, (float)0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
mdl1.renderAll();
GL11.glPopMatrix();

GL11.glPushMatrix();
GL11.glTranslatef((float)0.5F, (float)(par1*7), (float)0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
mdl2.renderAll();
GL11.glPopMatrix();

}

}
