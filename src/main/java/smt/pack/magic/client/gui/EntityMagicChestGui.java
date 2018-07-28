package smt.pack.magic.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import smt.pack.magic.entity.EntityMagicChest;
import smt.pack.magic.inventory.EntityMagicChestContainer;

public class EntityMagicChestGui extends net.minecraft.client.gui.inventory.GuiContainer {

	private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
	private final EntityMagicChest entityMagicChest;

	public EntityMagicChestGui(final EntityMagicChest entityMagicChest, final EntityPlayer player) {
		super(new EntityMagicChestContainer(entityMagicChest, player));
		this.entityMagicChest = entityMagicChest;
	}

	@Override
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		if (entityMagicChest != null) {
			String s = entityMagicChest.getCommandSenderName();
			fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		}
		fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float parTick, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(furnaceGuiTextures);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);

		if (entityMagicChest != null) {
		}
	}

}
