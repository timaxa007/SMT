package smt.pack.magic.client.event;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.mana.ManaEntity;
import smt.pack.magic.mana.Util;
import smt.pack.magic.network.MessageSpell;

public class EventsForgeClient {

	static Minecraft mc = Minecraft.getMinecraft();
	//private static final ResourceLocation texture = new ResourceLocation("dayz", "textures/items/backpack.png");
	private static final ResourceLocation textureMana = new ResourceLocation(SMTMagic.MODID, "textures/gui/mana.png");

	int xSize = 16;
	int ySize = 16;
	/*
	@SubscribeEvent
	public void mergerItem(GuiScreenEvent event) {
		if (event.gui instanceof GuiMainMenu) {
			EntityPlayer player = null;
			//player.inventory.getItemStack();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			mc.getTextureManager().bindTexture(texture);
			int posX = (event.gui.width - xSize) / 2;
			int posY = (event.gui.height - ySize) / 2;
			mc.ingameGUI.drawTexturedModalRect(posX, posY, 0, 0, xSize, ySize);
		}
	}
	 */
	@SubscribeEvent
	public void renderMana(RenderGameOverlayEvent.Post event) {
		if (!mc.playerController.shouldDrawHUD()) return;
		ManaEntity player = Util.getManaEntity(mc.thePlayer);
		if (player == null) return;
		if (player.getManaMax() == 0) return;
		switch(event.type) {
		case ALL:
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			mc.renderEngine.bindTexture(textureMana);
			int left = event.resolution.getScaledWidth() / 2 + 10;
			int top = event.resolution.getScaledHeight() - 49;
			int mana = (int)(((float)player.getMana() / (float)player.getManaMax()) * 10F);

			for (int i = 0; i < 10; ++i) {
				int x = left - i * 8 - 9;
				int y = top;
				mc.ingameGUI.drawTexturedModalRect(left + i * 8, top, 0 + (mana > i ? 0 : 7), 0, 7, 7);
			}
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
			break;
		default:break;
		}
	}

	@SubscribeEvent
	public void clickMouse(MouseEvent event) {
		if (event.buttonstate)
			switch(event.button) {
			case 0:
				SMTMagic.network.sendToServer(new MessageSpell());
				break;
			}
	}

}
