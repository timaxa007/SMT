package mods.timaxa007.pack.mining.ri;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderItemSwordBig implements IItemRenderer {

@Override
public boolean handleRenderType(ItemStack is, ItemRenderType type) {
return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
return false;
}

@Override
public void renderItem(ItemRenderType type, ItemStack is, Object... data) {
GL11.glPushMatrix();
float f = 2.0F;
/*
if (firstPerson) {
    f *= 1.75F;
    GL11.glTranslatef(-0.35F * scale, -0.125F * scale, 0.0F);
} else {
    f *= (entity instanceof EntityPlayer ? 2.0F : 1.75F);
    GL11.glTranslatef(1.0F - f, -0.125F * scale, 0.05F * scale);
}
*/
GL11.glScalef(f, f, f);
Icon icon = is.getItem().getIcon(is, 0);
Tessellator tessellator = Tessellator.instance;
ItemRenderer.renderItemIn2D(tessellator, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);
GL11.glPopMatrix();
}

}
