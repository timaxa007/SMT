package smt.pack.technology.client.render.tile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class RenederTileEntityStorage extends TileEntitySpecialRenderer {

	private Minecraft mc = Minecraft.getMinecraft();
	private static RenderItem itemRender = new RenderItem();

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		//render((TileEntityStorage)tile, x, y, z, parTick);
	}
	/*
	private void render(TileEntityStorage tile, double x, double y, double z, float parTick) {

	}
	 */
	private void drawItemStack(ItemStack itemStack, int x, int y, String p_146982_4_) {
		GL11.glTranslatef(0.0F, 0.0F, 32.0F);
		itemRender.zLevel = 200.0F;
		FontRenderer font = null;
		if (itemStack != null) font = itemStack.getItem().getFontRenderer(itemStack);
		if (font == null) font = mc.fontRenderer;
		itemRender.renderItemAndEffectIntoGUI(font, this.mc.getTextureManager(), itemStack, x, y);
		//itemRender.renderItemOverlayIntoGUI(font, this.mc.getTextureManager(), is, x, y - (this.draggedStack == null ? 0 : 8), p_146982_4_);
		itemRender.zLevel = 0.0F;
	}

}
