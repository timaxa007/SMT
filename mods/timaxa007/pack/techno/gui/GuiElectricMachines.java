package mods.timaxa007.pack.techno.gui;

import org.lwjgl.opengl.GL11;

import mods.timaxa007.pack.techno.te.TEElectricMachines;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiElectricMachines extends GuiContainer{

private TEElectricMachines te;

public GuiElectricMachines(EntityPlayer player, TEElectricMachines te2) {
super(new ContainerElectricMachines(player, te2));
te=te2;
}

@Override
protected void drawGuiContainerForegroundLayer(int par1, int par2) {
String s=te.isInvNameLocalized()?te.getInvName():StatCollector.translateToLocal(te.getInvName());
fontRenderer.drawString(s, xSize/2-fontRenderer.getStringWidth(s)/2, 6, 4210752);
fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize-96+2, 4210752);
}

@Override
protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
mc.renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/gui/guiCran.png"));
int k=(width-xSize)/2;
int l=(height-ySize)/2;
drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
}

}
