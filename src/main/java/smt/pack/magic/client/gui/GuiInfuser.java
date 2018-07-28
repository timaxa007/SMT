package smt.pack.magic.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import smt.pack.common.inventory.InventoryItemStorage;
import smt.pack.magic.tile.TileEntityInfuser;

public class GuiInfuser extends net.minecraft.client.gui.inventory.GuiContainer {

	private static final ResourceLocation field_147017_u = new ResourceLocation("textures/gui/container/generic_54.png");
	private int inventoryRows;
	private InventoryPlayer inv_p;
	final TileEntityInfuser tile;

	public GuiInfuser(final EntityPlayer player, final TileEntityInfuser tile) {
		super(new smt.pack.magic.inventory.ContainerInfuser(player, tile));
		inv_p = player.inventory;
		this.tile = tile;
		inventoryRows = tile.getSizeInventory() / 9;
		short short1 = 222;
		int i = short1 - 108;
		ySize = i + inventoryRows * 18;
	}

	@Override
	public void drawGuiContainerForegroundLayer(int i1, int i2) {
		if (tile != null) fontRendererObj.drawString(
				(tile.hasCustomInventoryName() ? tile.getInventoryName() : StatCollector.translateToLocal("inventory.backpack.name")), 8, 6, 4210752);
		if (inv_p != null) fontRendererObj.drawString(
				StatCollector.translateToLocal("container.inventory"), 8, inventoryRows * 18 + 19, 4210752);
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float i1, int i2, int i3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(field_147017_u);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, inventoryRows * 18 + 17);
		drawTexturedModalRect(k, l + inventoryRows * 18 + 17, 0, 126, xSize, 96);
	}

}
