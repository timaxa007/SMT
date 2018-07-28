package smt.pack.common.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;

import org.lwjgl.opengl.GL11;

import smt.pack.common.SMTCommon;
import smt.pack.common.client.UtilModel;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenederBlockBlocksCommon implements ISimpleBlockRenderingHandler {

	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(SMTCommon.MODID, "model/teapod.obj"));
	final int id;

	public RenederBlockBlocksCommon(int block_blocks_common_renderID) {
		id = block_blocks_common_renderID;
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		int meta = world.getBlockMetadata(x, y, z);
		Tessellator tessellator = Tessellator.instance;
		IIcon icon = block.getIcon(0, meta);
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glPushMatrix();
		//renderer.renderBlockAsItem(Blocks.stone, world.getBlockMetadata(x, y, z), 1F);
		//renderer.renderStandardBlock(Blocks.stone, x, y, z);
		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		//Tessellator tessellator = Tessellator.instance;
		UtilModel.renderAllOnIcon((WavefrontObject)model, icon, tessellator);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return id;
	}

}
