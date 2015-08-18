package timaxa007.gui.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import timaxa007.gui.container.EntityLivingChestContainer;
import timaxa007.pack.magic.entity.EntityLivingChest;
//GuiChest
public class EntityLivingChestGui extends GuiContainer {

	private static final ResourceLocation field_147017_u = new ResourceLocation("textures/gui/container/generic_54.png");

	private EntityPlayer player;
	private EntityLivingChest entity;
	private int inventoryRows;

	public EntityLivingChestGui(EntityPlayer playerp, EntityLivingChest entityp) {
		super(new EntityLivingChestContainer(playerp, entityp));
		player = playerp;
		entity = entityp;
		allowUserInput = false;
		short short1 = 222;
		int i = short1 - 108;
		inventoryRows = entity.inventory.getSizeInventory() / 9;
		ySize = i + inventoryRows * 18;
	}

	public void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		fontRendererObj.drawString(StatCollector.translateToLocal(entity.inventory.getInventoryName()), 8, 6, 4210752);
		fontRendererObj.drawString(StatCollector.translateToLocal(player.inventory.getInventoryName()), 8, ySize - 96 + 2, 4210752);
	}
	@Override
	public void drawGuiContainerBackgroundLayer(float f1, int i2, int i3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(field_147017_u);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, inventoryRows * 18 + 17);
		drawTexturedModalRect(k, l + inventoryRows * 18 + 17, 0, 126, xSize, 96);
	}

}
