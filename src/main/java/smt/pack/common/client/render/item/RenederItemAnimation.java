package smt.pack.common.client.render.item;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import smt.pack.common.client.UtilModel;
import smt.pack.common.item.ItemAnimation;
import smt.pack.weapon.SMTWeapon;

public class RenederItemAnimation implements IItemRenderer {

	public static final IModelCustom modelPistol = AdvancedModelLoader.loadModel(new ResourceLocation(SMTWeapon.MODID, "models/pistol.obj"));
	public static final IModelCustom modelAmmo = AdvancedModelLoader.loadModel(new ResourceLocation(SMTWeapon.MODID, "models/ammo.obj"));

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {
		ItemAnimation itemAnim = (ItemAnimation)itemStack.getItem();

		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glScalef(2F, 2F, 2F);
		if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
			GL11.glRotatef(45F + 90F, 0, 1, 0);
		else if (type == ItemRenderType.INVENTORY);
		else
			GL11.glRotatef(45F - 180F, 0, 1, 0);
/*
		if (itemAnim.ammoR != null) {
			itemAnim.ammoR.render();
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glColor3f(1F, 0F, 0F);
			UtilModel.box(Tessellator.instance, -0.0625, -0.0625, -0.0625, 0.0625, 0.0625, 0.0625);
			GL11.glColor3f(1F, 1F, 1F);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}
		
		if (type == ItemRenderType.EQUIPPED_FIRST_PERSON && itemAnim.aim != null) {
			itemAnim.aim.render();
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glColor3f(1F, 0F, 0F);
			UtilModel.box(Tessellator.instance, -0.0625, -0.0625, -0.0625, 0.0625, 0.0625, 0.0625);
			GL11.glColor3f(1F, 1F, 1F);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}
		if (itemAnim.main != null) {
			itemAnim.main.render();
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glColor3f(1F, 0F, 0F);
			UtilModel.box(Tessellator.instance, -0.0625, -0.0625, -0.0625, 0.0625, 0.0625, 0.0625);
			GL11.glColor3f(1F, 1F, 1F);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}
*/
		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		Tessellator tessellator = Tessellator.instance;
		UtilModel.renderPartOnIcon((WavefrontObject)modelPistol, "body", Blocks.planks.getIcon(2, 0), tessellator);
/*
		GL11.glPushMatrix();
		if (itemAnim.end != null) {
			itemAnim.end.render();
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glColor3f(1F, 0F, 0F);
			UtilModel.box(Tessellator.instance, -0.0625, -0.0625, -0.0625, 0.0625, 0.0625, 0.0625);
			GL11.glColor3f(1F, 1F, 1F);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}
*/
		UtilModel.renderPartOnIcon((WavefrontObject)modelPistol, "end", Blocks.iron_block.getIcon(2, 0), tessellator);
		GL11.glPopMatrix();

		UtilModel.renderPartOnIcon((WavefrontObject)modelPistol, "start", Blocks.anvil.getIcon(2, 0), tessellator);
/*
		GL11.glPushMatrix();
		if (itemAnim.ammo != null) {
			itemAnim.ammo.render();
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glColor3f(1F, 0F, 0F);
			UtilModel.box(Tessellator.instance, -0.0625, -0.0625, -0.0625, 0.0625, 0.0625, 0.0625);
			GL11.glColor3f(1F, 1F, 1F);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}
*/
		UtilModel.renderAllOnIcon((WavefrontObject)modelAmmo, Blocks.iron_block.getIcon(2, 0), tessellator);
		GL11.glPopMatrix();

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();

	}

}
