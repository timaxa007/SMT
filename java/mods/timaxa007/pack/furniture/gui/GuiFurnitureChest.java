package mods.timaxa007.pack.furniture.gui;

import mods.timaxa007.pack.furniture.tile.TileEntityFurnitureChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiFurnitureChest extends GuiContainer {

	private static final ResourceLocation field_147017_u = new ResourceLocation("textures/gui/container/generic_54.png");
	TileEntityFurnitureChest te;

	public GuiFurnitureChest(Container c) {
		super(c);
	}

	public GuiFurnitureChest(EntityPlayer player, TileEntityFurnitureChest te) {
		super(new ContainerFurnitureChest(player, te));
		this.te = te;
	}

	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		fontRendererObj.drawString(te.hasCustomInventoryName() ? te.getInventoryName() : I18n.format(te.getInventoryName(), new Object[0]), 8, 6, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,  int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(field_147017_u);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, 4 * 18 + 17);
		drawTexturedModalRect(k, l + 4 * 18 + 17, 0, 126, xSize, 96);
	}

}
