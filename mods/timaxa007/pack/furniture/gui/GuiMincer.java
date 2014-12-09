package mods.timaxa007.pack.furniture.gui;

import mods.timaxa007.pack.furniture.te.TEMincer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiMincer extends GuiContainer{

public TEMincer te;

public GuiMincer(EntityPlayer player, TEMincer par2TEMincer) {
super(new ContainerMincer(player, par2TEMincer));
this.te=par2TEMincer;
}

@Override
protected void drawGuiContainerForegroundLayer(int par1, int par2) {
String s=this.te.isInvNameLocalized() ? this.te.getInvName() : StatCollector.translateToLocal(this.te.getInvName());
this.fontRenderer.drawString(s, this.xSize/2-this.fontRenderer.getStringWidth(s)/2, 6, 4210752);
this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize-96+2, 4210752);
}

@Override
protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
this.mc.renderEngine.bindTexture(new ResourceLocation("textures/gui/container/furnace.png"));
int k=(this.width-this.xSize)/2;
int l=(this.height-this.ySize)/2;
this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
int i1;

if (this.te.isBurning()) {
i1=this.te.getBurnTimeRemainingScaled(12);
this.drawTexturedModalRect(k+56, l+36+12-i1, 176, 12-i1, 14, i1+2);
}

i1=this.te.getCookProgressScaled(24);
this.drawTexturedModalRect(k+79, l+34, 176, 14, i1+1, 16);

}

}
