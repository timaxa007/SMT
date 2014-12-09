package mods.timaxa007.pack.furniture.gui;

import mods.timaxa007.pack.furniture.te.TEMashineWater;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiMashineWater extends GuiContainer {

public TEMashineWater te;

public GuiMashineWater(EntityPlayer player, TEMashineWater TEGrillsModel) {
super(new ContainerMashineWater(player, TEGrillsModel));
te = TEGrillsModel;
}

@Override
protected void drawGuiContainerForegroundLayer(int par1, int par2) {
//String s=te.isInvNameLocalized() ? te.getInvName() : StatCollector.translateToLocal(te.getInvName());
String s = "Mashine Water";
fontRenderer.drawString(s, xSize/2-fontRenderer.getStringWidth(s)/2, 6, 4210752);
fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize-96+2, 4210752);
fontRenderer.drawString(" IN: Empty", 55+1, 17, 0xFFFFFF);
fontRenderer.drawString("OUT: Empty", 55, 17+8, 0xFFFFFF);
fontRenderer.drawString(" 1      2      3", 55, 17+8+8+8, 0xFFFFFF);
}

@Override
protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
mc.renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/gui/tank_test3.png"));
int k=(width-xSize)/2;
int l=(height-ySize)/2;
drawTexturedModalRect(k, l, 0, 0, xSize, ySize);

drawTexturedModalRect(k+8, l+18, 176, 18, 18, 176);
drawTexturedModalRect(k+152, l+18, 176, 18, 18, 176);

int i1;
/*
if(te.isBurning()) {
i1=te.getBurnTimeRemainingScaled(12);
drawTexturedModalRect(k+56+6, l+48+6-i1, 176, 12-i1, 14, i1+2);
}

i1=te.getCookProgressScaled(18);
drawTexturedModalRect(k+115, l+44, 176, 14, i1+1, 7);
*/
}

}
