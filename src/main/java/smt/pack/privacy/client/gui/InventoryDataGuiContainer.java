package smt.pack.privacy.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import smt.pack.privacy.registry.InventoryData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class InventoryDataGuiContainer extends net.minecraft.client.gui.inventory.GuiContainer {

	private static final ResourceLocation textures = new ResourceLocation("textures/gui/container/generic_54.png");
	private InventoryData.InventotyDummy inventoty_dummy;
	private int inventoryRows;

	public InventoryDataGuiContainer(EntityPlayer player) {
		super(new smt.pack.privacy.inventory.InventoryDataContainer(player));
		InventoryData inventory_data = InventoryData.createOrLoad(player.worldObj);
		this.inventoty_dummy = inventory_data.getInventory(inventory_data.temp);
		this.allowUserInput = false;
		short short1 = 222;
		int i = short1 - 108;
		this.inventoryRows = inventoty_dummy.getInventory().getSizeInventory() / 9;
		this.ySize = i + this.inventoryRows * 18;
	}

	@Override
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = "";
		if (inventoty_dummy != null) {
		}
		fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float parTick, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(textures);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
		this.drawTexturedModalRect(k, l + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
		if (inventoty_dummy != null) {
		}
	}

}
