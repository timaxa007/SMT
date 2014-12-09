package mods.timaxa007.Pack.Stock.RenderItems;

import mods.timaxa007.Pack.Stock.Model.ModelPiePar;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderPies implements IItemRenderer{
private static ModelPiePar model;

public ItemRenderPies() {
model=new ModelPiePar();
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
//int tex=tileEntity.getBlockMetadata();
/*int tex=tileEntity.getTypes();
int amt=tileEntity.getAmount();
int rot=tileEntity.getRot();*/
int tex=is.getItemDamage();
int amt=4;
int rot=2;

if(amt==4) {
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 1.5F, 0.5F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(0F+((float)(90F*rot))+90F, 0.0F, 1.0F, 0.0F);
switch(tex) {
case 0:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie1.png"));break;
case 1:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie2.png"));break;
case 2:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie3.png"));break;
case 3:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie4.png"));break;
case 4:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie5.png"));break;
case 5:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie6.png"));break;
case 6:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie7.png"));break;
case 7:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie8.png"));break;
case 8:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie9.png"));break;
case 9:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie10.png"));break;
case 10:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie11.png"));break;
case 11:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie12.png"));break;
case 12:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie13.png"));break;
case 13:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie14.png"));break;
case 14:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie15.png"));break;
case 15:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie16.png"));break;
default:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie.png"));break;
}
this.model.render();
GL11.glPopMatrix();
}

if(amt>=3) {
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 1.5F, 0.5F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(90F+((float)(90F*rot))+90F, 0.0F, 1.0F, 0.0F);
switch(tex) {
case 0:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie1.png"));break;
case 1:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie2.png"));break;
case 2:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie3.png"));break;
case 3:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie4.png"));break;
case 4:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie5.png"));break;
case 5:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie6.png"));break;
case 6:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie7.png"));break;
case 7:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie8.png"));break;
case 8:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie9.png"));break;
case 9:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie10.png"));break;
case 10:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie11.png"));break;
case 11:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie12.png"));break;
case 12:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie13.png"));break;
case 13:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie14.png"));break;
case 14:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie15.png"));break;
case 15:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie16.png"));break;
default:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie.png"));break;
}
this.model.render();
GL11.glPopMatrix();
}

if(amt>=2) {
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 1.5F, 0.5F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(180F+((float)(90F*rot))+90F, 0.0F, 1.0F, 0.0F);
switch(tex) {
case 0:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie1.png"));break;
case 1:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie2.png"));break;
case 2:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie3.png"));break;
case 3:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie4.png"));break;
case 4:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie5.png"));break;
case 5:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie6.png"));break;
case 6:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie7.png"));break;
case 7:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie8.png"));break;
case 8:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie9.png"));break;
case 9:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie10.png"));break;
case 10:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie11.png"));break;
case 11:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie12.png"));break;
case 12:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie13.png"));break;
case 13:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie14.png"));break;
case 14:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie15.png"));break;
case 15:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie16.png"));break;
default:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie.png"));break;
}
this.model.render();
GL11.glPopMatrix();
}

if(amt>=1) {
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 1.5F, 0.5F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(270F+((float)(90F*rot))+90F, 0.0F, 1.0F, 0.0F);
switch(tex) {
case 0:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie1.png"));break;
case 1:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie2.png"));break;
case 2:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie3.png"));break;
case 3:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie4.png"));break;
case 4:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie5.png"));break;
case 5:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie6.png"));break;
case 6:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie7.png"));break;
case 7:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie8.png"));break;
case 8:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie9.png"));break;
case 9:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie10.png"));break;
case 10:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie11.png"));break;
case 11:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie12.png"));break;
case 12:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie13.png"));break;
case 13:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie14.png"));break;
case 14:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie15.png"));break;
case 15:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie16.png"));break;
default:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"foods/"+"pie.png"));break;
}
this.model.render();
GL11.glPopMatrix();

}

}

}
