package smt.pack.common.client.render.item;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.obj.WavefrontObject;

import org.lwjgl.opengl.GL11;

import smt.pack.common.client.UtilModel;
import smt.pack.common.client.render.tile.RenederTileEntityCommonTest;

public class RenederItemBlockBlocksCommon implements IItemRenderer {

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
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);

		if (itemStack != null) {
			Item item = itemStack.getItem();
			if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
				int metadata = item.getMetadata(itemStack.getItemDamage());
				Block block = Block.getBlockFromItem(item);
				Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
				Tessellator tessellator = Tessellator.instance;
				UtilModel.renderAllOnIcon((WavefrontObject)RenederTileEntityCommonTest.model, block.getIcon(2, metadata), tessellator);
			}
		}

		//bindTexture(texture);
		//model.renderAll();

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}

}
