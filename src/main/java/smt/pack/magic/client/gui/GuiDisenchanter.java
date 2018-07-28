package smt.pack.magic.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import smt.pack.magic.SMTMagic;
import smt.pack.magic.network.MessageActionDisench;
import smt.pack.magic.tile.TileEntityDisenchanter;

public class GuiDisenchanter extends GuiContainer {

	private static final ResourceLocation field_147017_u = new ResourceLocation("textures/gui/container/generic_54.png");
	private int inventoryRows;
	private InventoryPlayer inv_p;
	final TileEntityDisenchanter tile;

	private GuiButton
	btn_done
	;

	public GuiDisenchanter(final EntityPlayer player, final TileEntityDisenchanter tile) {
		super(new smt.pack.magic.inventory.ContainerDisenchanter(player, tile));
		inv_p = player.inventory;
		this.tile = tile;
		inventoryRows = 1;
		short short1 = 222;
		int i = short1 - 108;
		ySize = i + inventoryRows * 18;
	}

	@Override
	public void initGui() {
		super.initGui();
		buttonList.clear();
		int offsetX = (width - xSize) / 2;
		int offsetY = (height - ySize) / 2;
		/*StatCollector.translateToLocal(SMTMagic.MODID + ".button.close")*/
		buttonList.add(btn_done = new GuiButton(0, offsetX + xSize - 20, offsetY, 20, 20, "x"));
	}

	@Override
	public void actionPerformed(GuiButton button) {
		if (button.enabled) {
			switch(button.id) {
			case 0:{
				//mc.displayGuiScreen((GuiScreen)null);
				SMTMagic.network.sendToServer(new MessageActionDisench());
				break;
			}
			}
		}
	}

	@Override
	public void keyTyped(char symbol, int key) {
		if (key == 1) mc.displayGuiScreen((GuiScreen)null);
	}

	@Override
	public void drawGuiContainerForegroundLayer(int i1, int i2) {
		if (tile != null) fontRendererObj.drawString(
				(tile.hasCustomInventoryName() ? tile.getInventoryName() : StatCollector.translateToLocal("inventory.disenchanter.name")), 8, 6, 4210752);
		if (inv_p != null) fontRendererObj.drawString(
				StatCollector.translateToLocal("container.inventory"), 8, inventoryRows * 18 + 19, 4210752);
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float parTick, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(field_147017_u);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, inventoryRows * 18 + 17);
		drawTexturedModalRect(k, l + inventoryRows * 18 + 17, 0, 126, xSize, 96);

		btn_done.drawButton(mc, mouseX, mouseY);

	}

}
