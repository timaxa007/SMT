package timaxa007.pack.magic.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderMagicSword implements IItemRenderer {
	private static final IModelCustom modelp1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/weaponSword.obj"));

	public ItemRenderMagicSword() {

	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type) {
		case EQUIPPED: return true;
		default: return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type) {
		case EQUIPPED: {
			GL11.glPushMatrix();

			GL11.glRotatef(90F, 1F, 0F, 0F);
			GL11.glRotatef(45F + 180F, 0F, 1F, 0F);
			GL11.glRotatef(0F, 0F, 0F, 1F);

			boolean isFirstPirson=true;
			if (data[1] != null && data[1] instanceof EntityPlayer) {
				if (!((EntityPlayer)data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && !((Minecraft.getMinecraft().currentScreen instanceof GuiInventory || Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F))); {
					GL11.glTranslatef(-0.0F, -0.0F, -0.0F);
				}
			} else {
				isFirstPirson = true;
			}
			GL11.glTranslatef(-0.7F, -0.0F, -0.6F);

			float scl=1.5F;
			GL11.glScalef(scl, scl, scl);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "obj/" + "weaponSword.png"));
			modelp1.renderAll();
			GL11.glPopMatrix();

		}
		default:
			break;
		}
	}

}
