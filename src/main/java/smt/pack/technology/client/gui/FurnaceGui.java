package smt.pack.technology.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import smt.pack.technology.inventory.FurnaceContainer;
import smt.pack.technology.registry.FurnaceMobile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FurnaceGui extends GuiContainer {

	private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
	private FurnaceMobile fm;

	public FurnaceGui(EntityPlayer player, FurnaceMobile fm) {
		super(new FurnaceContainer(player, fm));
		this.fm = fm;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.fm.hasCustomInventoryName() ? this.fm.getInventoryName() : I18n.format(this.fm.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}

	public void drawGuiContainerBackgroundLayer(float parTick, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(posX, posY, 0, 0, this.xSize, this.ySize);

		if (this.fm.isBurning()) {
			int i1 = this.fm.getBurnTimeRemainingScaled(13);
			this.drawTexturedModalRect(posX + 56, posY + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
			i1 = this.fm.getCookProgressScaled(24);
			this.drawTexturedModalRect(posX + 79, posY + 34, 176, 14, i1 + 1, 16);
		}
	}

}
