package mods.timaxa007.pack.furniture.gui;

import mods.timaxa007.pack.furniture.te.TEBookshelf;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiBookshelf extends GuiContainer{

public TEBookshelf te;

public GuiBookshelf(EntityPlayer player, TEBookshelf par2TEBookshelf) {
super(new ContainerBookshelf(player, par2TEBookshelf));
this.te=par2TEBookshelf;
}

@Override
protected void drawGuiContainerForegroundLayer(int par1, int par2) {
String s = this.te.isInvNameLocalized() ? this.te.getInvName() : StatCollector.translateToLocal(this.te.getInvName());
this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, -15, 4210752);
this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
}

@Override
protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
this.mc.renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/gui/bookshelf.png"));
int k=(this.width-this.xSize)/2;
int l=(this.height-this.ySize)/2;
this.drawTexturedModalRect(k, l-20, 0, 0, this.xSize, 12*18+17);
//this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
}

}
