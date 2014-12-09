package mods.timaxa007.Pack.Furniture.RenderItems;

import mods.timaxa007.Lib.ModelT;
import mods.timaxa007.Lib.TileTexture;
import mods.timaxa007.Pack.Furniture.RenderBlocks.RenderBlockPipes;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderBlockPipes implements IItemRenderer {

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
int typ = 0;
int siz = 1;
int clr = 0xFFFFFF;

if (tag != null) {
if (tag.hasKey("Type")) {
typ = tag.getInteger("Type");
}
if (tag.hasKey("Size")) {
siz = tag.getInteger("Size");
}
}

double s_p = (double) 1 / 16;
double ss_p = (double) s_p * siz;
double ss_p_p = 0.5D + ss_p;
double ss_p_m = 0.5D - ss_p;

//--------------------------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glDisable(GL11.GL_LIGHTING);

Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation((String)TileTexture.texTest01[typ][0], (String)TileTexture.texTest01[typ][1]));

ModelT.addBox(ss_p_p, 1.0D, ss_p_p, ss_p_m, ss_p_p, ss_p_m);
ModelT.addBox(ss_p_p, ss_p_m, ss_p_p, ss_p_m, 0.0D, ss_p_m);
ModelT.addBox(1.0D, ss_p_p, ss_p_p, ss_p_p, ss_p_m, ss_p_m);
ModelT.addBox(ss_p_p, ss_p_p, 1.0D, ss_p_m, ss_p_m, ss_p_p);
ModelT.addBox(ss_p_m, ss_p_p, ss_p_p, 0.0D, ss_p_m, ss_p_m);
ModelT.addBox(ss_p_p, ss_p_p, ss_p_m, ss_p_m, ss_p_m, 0.0D);

GL11.glEnable(GL11.GL_LIGHTING);
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------------------------
}

}
