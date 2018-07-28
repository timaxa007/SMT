package smt.pack.common.client.render.tile;

import java.util.Iterator;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.DestroyBlockProgress;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;

import org.lwjgl.opengl.GL11;

import smt.pack.common.SMTCommon;
import smt.pack.common.client.UtilModel;
import smt.pack.common.tile.TileEntityCommonTest;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class RenederTileEntityCommonTest extends TileEntitySpecialRenderer {

	Map damagedBlocks = null;
	IIcon[] destroyBlockIcons = null;

	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(SMTCommon.MODID, "model/teapod.obj"));

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		render((TileEntityCommonTest)tile, x, y, z, parTick);
	}

	private void render(TileEntityCommonTest tile, double x, double y, double z, float parTick) {
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);

		if (tile != null) {

			ItemStack displayStack = tile.getDisplayItem();

			if (displayStack != null) {

				Item item = displayStack.getItem();

				if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
					//int metadata = item.getMetadata(displayStack.getItemDamage());
					IIcon icon = item.getIconFromDamage(displayStack.getItemDamage());//For testing and debag

					//ItemBlock ib = (ItemBlock)displayStack.getItem();
					//Block block = Block.getBlockFromItem(item);
					// 0 - ForgeDirection.UP.flag
					//IIcon blockIcon = block.getIcon(2, metadata);
					//IIcon blockWorldIcon = block.getIcon(tile.getWorldObj(), tile.xCoord, tile.yCoord, tile.zCoord, 2);

					bindTexture(TextureMap.locationBlocksTexture);
					Tessellator tessellator = Tessellator.instance;
					//
					GL11.glPushMatrix();
					GL11.glPolygonOffset(-3.0F, -3.0F);
					GL11.glEnable(GL11.GL_POLYGON_OFFSET_FILL);
					GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
					GL11.glEnable(GL11.GL_ALPHA_TEST);

					damagedBlocks = ReflectionHelper.getPrivateValue(RenderGlobal.class, Minecraft.getMinecraft().renderGlobal, "O", "field_72738_E", "damagedBlocks");
					destroyBlockIcons = ReflectionHelper.getPrivateValue(RenderGlobal.class, Minecraft.getMinecraft().renderGlobal, "Q", "field_94141_F", "destroyBlockIcons");

					Iterator iterator = damagedBlocks.values().iterator();

					while (iterator.hasNext()) {
						DestroyBlockProgress destroyblockprogress = (DestroyBlockProgress)iterator.next();
						int bx = destroyblockprogress.getPartialBlockX();
						int by = destroyblockprogress.getPartialBlockY();
						int bz = destroyblockprogress.getPartialBlockZ();
						if (tile.xCoord == bx && tile.yCoord == by && tile.zCoord == bz) {
							UtilModel.renderAllOnIcon((WavefrontObject)model, destroyBlockIcons[destroyblockprogress.getPartialBlockDamage()], tessellator);
							break;
						}
					}

					GL11.glDisable(GL11.GL_ALPHA_TEST);
					GL11.glPolygonOffset(0.0F, 0.0F);
					GL11.glDisable(GL11.GL_POLYGON_OFFSET_FILL);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glDepthMask(true);
					GL11.glPopMatrix();
					//
					UtilModel.renderAllOnIcon((WavefrontObject)model, icon, tessellator);

				}

			}
		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}

}
