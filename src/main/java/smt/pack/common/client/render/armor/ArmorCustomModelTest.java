package smt.pack.common.client.render.armor;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import smt.pack.common.SMTCommon;
import smt.pack.common.client.UtilModel;

public class ArmorCustomModelTest extends ArmorCustomModel {

	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(SMTCommon.MODID, "model/armor/armor_plane.obj"));
	private static Tessellator tessellator = Tessellator.instance;
	private final int partType;
	public IIcon block;

	/**armorType: 0 - head, 1 - body and arms, 2 - legs, 3 - feet.**/
	public ArmorCustomModelTest(int armorType) {
		partType = armorType;
	}

	@Override
	public void pre() {
		block = Blocks.planks.getIcon(0, 0);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
	}

	@Override
	public void post() {
		GL11.glDisable(GL11.GL_BLEND);
	}

	@Override
	public void partHead() {
		if (partType == 0) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			if (block != null)
				UtilModel.renderPartOnIcon((WavefrontObject)model, "helm", block, tessellator);
			UtilModel.renderPartOnIcon((WavefrontObject)model, "glass", Blocks.stained_glass.getIcon(2, 0), tessellator);
			/*UtilModel.boxOnIcon(tessellator, Blocks.water.getIcon(2, 0),
					AxisAlignedBB.getBoundingBox(-0.3125D, -0.0625D, -0.3125D, 0.3125D, 0.5625D, 0.3125D));*/
		}
	}

	@Override
	public void partBody() {
		if (partType == 1) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			if (block != null) {
				UtilModel.renderPartOnIcon((WavefrontObject)model, "body", block, tessellator);
				UtilModel.renderPartOnIcon((WavefrontObject)model, "plane", block, tessellator);
			}
		}
	}

	@Override
	public void partRightArm() {
		if (partType == 1) {
			GL11.glTranslatef(0.3125F, -1.375F, 0F);
			if (block != null)
				UtilModel.renderPartOnIcon((WavefrontObject)model, "right_arm", block, tessellator);
		}
	}

	@Override
	public void partLeftArm() {
		if (partType == 1) {
			GL11.glTranslatef(-0.3125F, -1.375F, 0F);
			if (block != null)
				UtilModel.renderPartOnIcon((WavefrontObject)model, "left_arm", block, tessellator);
		}
	}

	@Override
	public void partRightLeg() {
		GL11.glTranslatef(0.125F, -0.75F, 0F);
		if (partType == 2)
			if (block != null)
				UtilModel.renderPartOnIcon((WavefrontObject)model, "right_leg", block, tessellator);
		if (partType == 3)
			if (block != null)
				UtilModel.renderPartOnIcon((WavefrontObject)model, "right_boot", block, tessellator);
	}

	@Override
	public void partLeftLeg() {
		GL11.glTranslatef(-0.125F, -0.75F, 0F);
		if (partType == 2)
			if (block != null)
				UtilModel.renderPartOnIcon((WavefrontObject)model, "left_leg", block, tessellator);
		if (partType == 3)
			if (block != null)
				UtilModel.renderPartOnIcon((WavefrontObject)model, "left_boot", block, tessellator);
	}

}
