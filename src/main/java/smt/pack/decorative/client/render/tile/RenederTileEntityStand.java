package smt.pack.decorative.client.render.tile;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import smt.pack.common.client.UtilModel;
import smt.pack.decorative.client.model.ModelSit;
import smt.pack.decorative.tile.TileEntityStand;

public class RenederTileEntityStand extends TileEntitySpecialRenderer {

	public static final ModelSit model = new ModelSit();
	public static final ResourceLocation texture = new ResourceLocation("textures/blocks/stone_slab_top.png");
	protected RenderManager renderManager = RenderManager.instance;

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		render((TileEntityStand)tile, x, y, z, parTick);
	}

	//renderItemAndEffectIntoGUI Пытался, плохо работает.
	private void render(TileEntityStand tile, double x, double y, double z, float parTick) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslated(x, y, z);

		if (tile != null) {
			ItemStack itemstack = tile.getItemStack();
			if (itemstack != null) {

				GL11.glPushMatrix();
				GL11.glTranslatef(0.5F, 1.0625F, 0.5F);
				if (renderManager.options.fancyGraphics) {
					if (tile.age >= Short.MAX_VALUE) tile.age = 0; else tile.age += 1;
					GL11.glRotatef((((float)tile.age + parTick) / 60.0F) * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
				}
				EntityItem entityitem = new EntityItem(tile.getWorldObj(), 0.0D, 0.0D, 0.0D, itemstack);
				entityitem.hoverStart = 0.0F;
				renderManager.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
				GL11.glDisable(GL11.GL_LIGHTING);
				GL11.glColor3f(1F, 1F, 1F);
				GL11.glPopMatrix();
			}
		}

		bindTexture(texture);
		Tessellator tessellator = Tessellator.instance;
		UtilModel.boxWithUV(tessellator, 0D, 0D, 0D, 1D, 1D, 1D);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

}
