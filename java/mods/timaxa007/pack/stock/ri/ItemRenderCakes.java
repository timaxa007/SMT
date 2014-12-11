package mods.timaxa007.pack.stock.ri;

import mods.timaxa007.lib.GetColors;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderCakes implements IItemRenderer{
private IModelCustom mdl1;
private IModelCustom mdl2;

public ItemRenderCakes() {
mdl1=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/cake5.obj"));
mdl2=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/cake7.obj"));
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
int amt=12;
boolean mdlnew=false;

if(tag!=null) {
if(tag.hasKey("Type")) {tex=tag.getInteger("Type");}
if(tag.hasKey("Amount")) {amt=tag.getInteger("Amount");}
}

GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(tex) {
case 48:GL11.glColor4f(0.1F, 0.1F, 0.1F, 1.0F);break;
case 49:GL11.glColor4f(0.0F, 0.0F, 255.0F, 1.0F);break;
case 50:GL11.glColor4f(1.0F, 0.5F, 0.0F, 1.0F);break;
case 51:GL11.glColor4f(0.0F, 0.5F, 0.5F, 1.0F);break;
case 52:GL11.glColor4f(0.25F, 0.25F, 0.25F, 1.0F);break;
case 53:GL11.glColor4f(0.0F, 0.5F, 0.0F, 1.0F);break;
case 54:GL11.glColor4f(0.0F, 1.0F, 1.0F, 1.0F);break;
case 55:GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);break;
case 56:GL11.glColor4f(0.0F, 0.5F, 0.0F, 1.0F);break;
case 57:GL11.glColor4f(1.0F, 0.0F, 1.0F, 1.0F);break;
case 58:GL11.glColor4f(1.0F, 0.5F, 0.0F, 1.0F);break;
case 59:GL11.glColor4f(1.0F, 0.5F, 0.5F, 1.0F);break;
case 60:GL11.glColor4f(0.5F, 0.0F, 1.0F, 1.0F);break;
case 61:GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);break;
case 62:GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);break;
case 63:GL11.glColor4f(1.0F, 1.0F, 0.0F, 1.0F);break;
default:GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);break;
}

String gtp="textures/"+"blocks/"+"food/"+"cake/";
switch(tex) {
case 0:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cake_bottom.png"));break;
case 1:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cake_top.png"));break;
case 2:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeChocolate_top.png"));break;
case 3:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeChocolate_top.png"));break;
case 4:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeFruit_top.png"));break;
case 5:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeBerry_top.png"));break;
case 6:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeVegetables_top.png"));break;
case 7:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMeat_top.png"));break;
case 8:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomBrown_top.png"));break;
case 9:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomBrown_top.png"));break;
case 10:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomRed_top.png"));break;
case 11:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomRed_top.png"));break;
case 12:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMelon_top.png"));break;
case 13:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMelon_top.png"));break;
case 14:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakePumpkin_top.png"));break;
case 15:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakePumpkin_top.png"));break;
case 16:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeCreeper_top.png"));break;
case 17:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeCreeper_top.png"));break;
case 18:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSkeleton_top.png"));break;
case 19:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSkeleton_top.png"));break;
case 20:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeEnderman_top.png"));break;
case 21:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeEnderman_top.png"));break;
case 22:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSkeletonWither_top.png"));break;
case 23:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSkeletonWither_top.png"));break;
case 24:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeZombie_top.png"));break;
case 25:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeZombie_top.png"));break;
case 26:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSlime_top.png"));break;
case 27:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSlime_top.png"));break;
case 32:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[0]+"_top.png"));break;
case 33:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[1]+"_top.png"));break;
case 34:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[2]+"_top.png"));break;
case 35:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[3]+"_top.png"));break;
case 36:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[4]+"_top.png"));break;
case 37:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[5]+"_top.png"));break;
case 38:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[6]+"_top.png"));break;
case 39:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[7]+"_top.png"));break;
case 40:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[8]+"_top.png"));break;
case 41:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[9]+"_top.png"));break;
case 42:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[10]+"_top.png"));break;
case 43:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[11]+"_top.png"));break;
case 44:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[12]+"_top.png"));break;
case 45:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[13]+"_top.png"));break;
case 46:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[14]+"_top.png"));break;
case 47:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelle_"+GetColors.getNameColors[15]+"_top.png"));break;
default:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cake_top.png"));break;
}

if(!mdlnew) {
if(amt>=12) {this.mdl1.renderPart("part12_top");}
if(amt>=11) {this.mdl1.renderPart("part11_top");}
if(amt>=10) {this.mdl1.renderPart("part10_top");}
if(amt>=9) {this.mdl1.renderPart("part09_top");}
if(amt>=8) {this.mdl1.renderPart("part08_top");}
if(amt>=7) {this.mdl1.renderPart("part07_top");}
if(amt>=6) {this.mdl1.renderPart("part06_top");}
if(amt>=5) {this.mdl1.renderPart("part05_top");}
if(amt>=4) {this.mdl1.renderPart("part04_top");}
if(amt>=3) {this.mdl1.renderPart("part03_top");}
if(amt>=2) {this.mdl1.renderPart("part02_top");}
if(amt>=1) {this.mdl1.renderPart("part01_top");}
}else{
if(amt>=14) {this.mdl2.renderPart("top14");}
if(amt>=13) {this.mdl2.renderPart("top13");}
if(amt>=12) {this.mdl2.renderPart("top12");}
if(amt>=11) {this.mdl2.renderPart("top11");}
if(amt>=10) {this.mdl2.renderPart("top10");}
if(amt>=9) {this.mdl2.renderPart("top09");}
if(amt>=8) {this.mdl2.renderPart("top08");}
if(amt>=7) {this.mdl2.renderPart("top07");}
if(amt>=6) {this.mdl2.renderPart("top06");}
if(amt>=5) {this.mdl2.renderPart("top05");}
if(amt>=4) {this.mdl2.renderPart("top04");}
if(amt>=3) {this.mdl2.renderPart("top03");}
if(amt>=2) {this.mdl2.renderPart("top02");}
if(amt>=1) {this.mdl2.renderPart("top01");}
}

switch(tex) {
case 0:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cake_bottom.png"));break;
case 3:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeChocolate_bottom.png"));break;
case 4:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeFruit_bottom.png"));break;
case 5:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeBerry_bottom.png"));break;
case 6:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeVegetables_bottom.png"));break;
case 9:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroom_bottom.png"));break;
case 11:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroom_bottom.png"));break;
case 13:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMelon_bottom.png"));break;
case 15:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakePumpkin_bottom.png"));break;
case 17:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeGray_bottom.png"));break;
case 19:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeWhite_bottom.png"));break;
case 21:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeBlack_bottom.png"));break;
case 23:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeBlack_bottom.png"));break;
case 25:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeZombie_bottom.png"));break;
case 27:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSlime_top.png"));break;
default:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cake_bottom.png"));break;
}

if(!mdlnew) {
if(amt>=12) {this.mdl1.renderPart("part12_bottom");}
if(amt>=11) {this.mdl1.renderPart("part11_bottom");}
if(amt>=10) {this.mdl1.renderPart("part10_bottom");}
if(amt>=9) {this.mdl1.renderPart("part09_bottom");}
if(amt>=8) {this.mdl1.renderPart("part08_bottom");}
if(amt>=7) {this.mdl1.renderPart("part07_bottom");}
if(amt>=6) {this.mdl1.renderPart("part06_bottom");}
if(amt>=5) {this.mdl1.renderPart("part05_bottom");}
if(amt>=4) {this.mdl1.renderPart("part04_bottom");}
if(amt>=3) {this.mdl1.renderPart("part03_bottom");}
if(amt>=2) {this.mdl1.renderPart("part02_bottom");}
if(amt>=1) {this.mdl1.renderPart("part01_bottom");}
}else{
if(amt>=14) {this.mdl2.renderPart("bottom14");}
if(amt>=13) {this.mdl2.renderPart("bottom13");}
if(amt>=12) {this.mdl2.renderPart("bottom12");}
if(amt>=11) {this.mdl2.renderPart("bottom11");}
if(amt>=10) {this.mdl2.renderPart("bottom10");}
if(amt>=9) {this.mdl2.renderPart("bottom09");}
if(amt>=8) {this.mdl2.renderPart("bottom08");}
if(amt>=7) {this.mdl2.renderPart("bottom07");}
if(amt>=6) {this.mdl2.renderPart("bottom06");}
if(amt>=5) {this.mdl2.renderPart("bottom05");}
if(amt>=4) {this.mdl2.renderPart("bottom04");}
if(amt>=3) {this.mdl2.renderPart("bottom03");}
if(amt>=2) {this.mdl2.renderPart("bottom02");}
if(amt>=1) {this.mdl2.renderPart("bottom01");}
}

switch(tex) {
case 0:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cake1_side.png"));break;
case 1:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cake_side.png"));break;
case 2:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeChocolate_side.png"));break;
case 3:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeChocolate2_side.png"));break;
case 4:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeFruit_side.png"));break;
case 5:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeBerry_side.png"));break;
case 6:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeVegetables_side.png"));break;
case 7:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMeat_side.png"));break;
case 8:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomBrown_side.png"));break;
case 9:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomBrown2_side.png"));break;
case 10:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomRed_side.png"));break;
case 11:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomRed2_side.png"));break;
case 12:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMelon_side.png"));break;
case 13:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMelon2_side.png"));break;
case 14:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakePumpkin_side.png"));break;
case 15:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakePumpkin2_side.png"));break;
case 16:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeCreeper_side.png"));break;
case 17:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeCreeper2_side.png"));break;
case 18:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSkeleton_side.png"));break;
case 19:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSkeleton2_side.png"));break;
case 20:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeEnderman_side.png"));break;
case 21:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeEnderman2_side.png"));break;
case 22:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeEnderman_side.png"));break;
case 23:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeEnderman2_side.png"));break;
case 24:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeZombie_side.png"));break;
case 25:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeZombie2_side.png"));break;
case 26:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSlime_side.png"));break;
case 27:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSlime2_side.png"));break;
case 32:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[0]+"_side.png"));break;
case 33:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[1]+"_side.png"));break;
case 34:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[2]+"_side.png"));break;
case 35:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[3]+"_side.png"));break;
case 36:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[4]+"_side.png"));break;
case 37:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[5]+"_side.png"));break;
case 38:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[6]+"_side.png"));break;
case 39:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[7]+"_side.png"));break;
case 40:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[8]+"_side.png"));break;
case 41:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[9]+"_side.png"));break;
case 42:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[10]+"_side.png"));break;
case 43:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[11]+"_side.png"));break;
case 44:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[12]+"_side.png"));break;
case 45:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[13]+"_side.png"));break;
case 46:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[14]+"_side.png"));break;
case 47:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeJelly_"+GetColors.getNameColors[15]+"_side.png"));break;
default:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cake_side.png"));break;
}

if(!mdlnew) {
if(amt>=12) {this.mdl1.renderPart("part12_side");}
if(amt>=11) {this.mdl1.renderPart("part11_side");}
if(amt>=10) {this.mdl1.renderPart("part10_side");}
if(amt>=9) {this.mdl1.renderPart("part09_side");}
if(amt>=8) {this.mdl1.renderPart("part08_side");}
if(amt>=7) {this.mdl1.renderPart("part07_side");}
if(amt>=6) {this.mdl1.renderPart("part06_side");}
if(amt>=5) {this.mdl1.renderPart("part05_side");}
if(amt>=4) {this.mdl1.renderPart("part04_side");}
if(amt>=3) {this.mdl1.renderPart("part03_side");}
if(amt>=2) {this.mdl1.renderPart("part02_side");}
if(amt>=1) {this.mdl1.renderPart("part01_side");}
}else{
if(amt>=14) {this.mdl2.renderPart("side14");}
if(amt>=13) {this.mdl2.renderPart("side13");}
if(amt>=12) {this.mdl2.renderPart("side12");}
if(amt>=11) {this.mdl2.renderPart("side11");}
if(amt>=10) {this.mdl2.renderPart("side10");}
if(amt>=9) {this.mdl2.renderPart("side09");}
if(amt>=8) {this.mdl2.renderPart("side08");}
if(amt>=7) {this.mdl2.renderPart("side07");}
if(amt>=6) {this.mdl2.renderPart("side06");}
if(amt>=5) {this.mdl2.renderPart("side05");}
if(amt>=4) {this.mdl2.renderPart("side04");}
if(amt>=3) {this.mdl2.renderPart("side03");}
if(amt>=2) {this.mdl2.renderPart("side02");}
if(amt>=1) {this.mdl2.renderPart("side01");}
}

switch(tex) {
case 0:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cake1_inner.png"));break;
case 1:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cake_inner.png"));break;
case 2:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeChocolate_inner.png"));break;
case 3:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeChocolate2_inner.png"));break;
case 4:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeFruit_inner.png"));break;
case 5:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeBerry_inner.png"));break;
case 6:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeVegetables_inner.png"));break;
case 7:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMeat_inner.png"));break;
case 8:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomBrown_inner.png"));break;
case 9:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomBrown2_inner.png"));break;
case 10:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomRed_inner.png"));break;
case 11:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMushroomRed2_inner.png"));break;
case 12:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMelon_inner.png"));break;
case 13:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeMelon2_inner.png"));break;
case 14:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakePumpkin_inner.png"));break;
case 15:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakePumpkin2_inner.png"));break;
case 16:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeCreeper_inner.png"));break;
case 17:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeCreeper2_inner.png"));break;
case 18:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSkeleton_inner.png"));break;
case 19:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSkeleton2_inner.png"));break;
case 20:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeEnderman_inner.png"));break;
case 21:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeBlack_inner.png"));break;
case 22:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeEnderman_inner.png"));break;
case 23:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeBlack_inner.png"));break;
case 24:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeZombie_inner.png"));break;
case 25:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeZombie2_inner.png"));break;
case 26:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSlime_inner.png"));break;
case 27:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cakeSlime2_inner.png"));break;
default:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", gtp+"cake_inner.png"));break;
}

if(!mdlnew) {
if(amt>=12) {this.mdl1.renderPart("part12_inner");}
if(amt>=11) {this.mdl1.renderPart("part11_inner");}
if(amt>=10) {this.mdl1.renderPart("part10_inner");}
if(amt>=9) {this.mdl1.renderPart("part09_inner");}
if(amt>=8) {this.mdl1.renderPart("part08_inner");}
if(amt>=7) {this.mdl1.renderPart("part07_inner");}
if(amt>=6) {this.mdl1.renderPart("part06_inner");}
if(amt>=5) {this.mdl1.renderPart("part05_inner");}
if(amt>=4) {this.mdl1.renderPart("part04_inner");}
if(amt>=3) {this.mdl1.renderPart("part03_inner");}
if(amt>=2) {this.mdl1.renderPart("part02_inner");}
if(amt>=1) {this.mdl1.renderPart("part01_inner");}
}else{
if(amt>=14) {this.mdl2.renderPart("inner14");}
if(amt>=13) {this.mdl2.renderPart("inner13");}
if(amt>=12) {this.mdl2.renderPart("inner12");}
if(amt>=11) {this.mdl2.renderPart("inner11");}
if(amt>=10) {this.mdl2.renderPart("inner10");}
if(amt>=9) {this.mdl2.renderPart("inner09");}
if(amt>=8) {this.mdl2.renderPart("inner08");}
if(amt>=7) {this.mdl2.renderPart("inner07");}
if(amt>=6) {this.mdl2.renderPart("inner06");}
if(amt>=5) {this.mdl2.renderPart("inner05");}
if(amt>=4) {this.mdl2.renderPart("inner04");}
if(amt>=3) {this.mdl2.renderPart("inner03");}
if(amt>=2) {this.mdl2.renderPart("inner02");}
if(amt>=1) {this.mdl2.renderPart("inner01");}
}

GL11.glPopMatrix();

}

}