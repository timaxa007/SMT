package mods.timaxa007.Pack.Furniture.Gui;

import mods.timaxa007.Pack.Furniture.TE.TEGrills;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiGrills extends GuiContainer{

public TEGrills te;

public GuiGrills(EntityPlayer player, TEGrills teBlockGrillsModel) {
super(new ContainerGrills(player, teBlockGrillsModel));
this.te=teBlockGrillsModel;
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
this.mc.renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/gui/grill.png"));
int k=(this.width-this.xSize)/2;
int l=(this.height-this.ySize)/2;
this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
int i1;

if(this.te.isBurning()) {
i1=this.te.getBurnTimeRemainingScaled(12);
this.drawTexturedModalRect(k+56+6, l+48+6-i1, 176, 12-i1, 14, i1+2);
}

i1=this.te.getCookProgressScaled(18);
this.drawTexturedModalRect(k+115, l+44, 176, 14, i1+1, 7);

}

}
