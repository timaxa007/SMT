package mods.timaxa007.pack.furniture.gui;

import mods.timaxa007.pack.furniture.inventory.InventoryBackpack;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiBackpack extends GuiContainer {
private static final ResourceLocation field_110421_t=new ResourceLocation("textures/gui/container/generic_54.png");

public GuiBackpack(EntityPlayer player) {
super(new ContainerBackpack(player));
}

@Override
protected void drawGuiContainerForegroundLayer(int par1, int par2) {
//String s=this.te.isInvNameLocalized() ? this.te.getInvName() : StatCollector.translateToLocal(this.te.getInvName());
String s="Backpack";
this.fontRenderer.drawString(s, this.xSize/2-this.fontRenderer.getStringWidth(s)/2, 6, 4210752);
this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize-96+2, 4210752);
}

@Override
protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
this.mc.getTextureManager().bindTexture(field_110421_t);
int k=(this.width-this.xSize)/2;
int l=(this.height-this.ySize)/2;
this.drawTexturedModalRect(k, l, 0, 0, this.xSize, 3*18+17);
this.drawTexturedModalRect(k, l+3*18+17, 0, 126, this.xSize, 96);
}

}
