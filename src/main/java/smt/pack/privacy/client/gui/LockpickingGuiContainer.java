package smt.pack.privacy.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LockpickingGuiContainer extends net.minecraft.client.gui.inventory.GuiContainer {

	private static final ResourceLocation textures = new ResourceLocation("textures/gui/container/generic_54.png");
	private TileEntity tile;
	private int
	x_main_main,
	y_main_main,
	x_main_layer,
	y_main_layer
	;

	public LockpickingGuiContainer(TileEntity tile, EntityPlayer player) {
		super(new smt.pack.privacy.inventory.LockpickingContainer(tile, player));
		this.tile = tile;
		ySize = 114 + 6 * 18;
		x_main_main = y_main_main = x_main_layer = y_main_layer = 0;
	}

	@Override
	public void updateScreen() {
		int mouseX = Mouse.getEventX() * width / mc.displayWidth;
		int mouseY = height - Mouse.getEventY() * height / mc.displayHeight - 1;
		int offsetX = mouseX - (width / 2);
		int offsetY = mouseY - (height / 2) + (height / 4);
		float radius = 50F;
		float sin = (float)offsetX / radius;
		float cos = (float)offsetY / radius;
		//int offsetX = Mouse.getEventX() * width / mc.displayWidth;
		//int offsetY = height - Mouse.getEventY() * height / mc.displayHeight - 1;
		int button = Mouse.getEventButton();
		//System.out.println("mouseX - " + mouseX + ", mouseY - " + mouseY + ".");
		System.out.println("offsetX - " + offsetX + ", offsetY - " + offsetY + ".");
	}

	@Override
	public void drawGuiContainerForegroundLayer(int i1, int i2) {
		String s = "";
		if (tile != null) {/*
			if (tile instanceof TileEntityBlocksTechnology) {
				TileEntityBlocksTechnology te = (TileEntityBlocksTechnology)tile;
				s = te.hasCustomInventoryName() ? te.getInventoryName() : I18n.format(te.getInventoryName(), new Object[0]);
			} else if (tile instanceof IInventory) {
				IInventory te = (IInventory)tile;
				s = te.hasCustomInventoryName() ? te.getInventoryName() : I18n.format(te.getInventoryName(), new Object[0]);
			}*/
		}
		fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float f1, int i1, int i2) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(textures);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
		if (tile != null) {/*
			if (tile instanceof TileEntityBlocksTechnology) {
				TileEntityBlocksTechnology te = (TileEntityBlocksTechnology)tile;
				//drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
			}*//*else if (tile instanceof IInventory) {}*/
		}
	}

}
