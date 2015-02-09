package mods.timaxa007.pack.techno.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderBlockChip implements IItemRenderer {
	private static final IModelCustom mdl1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/chip01.obj"));

	public ItemRenderBlockChip() {

	}

	@Override
	public boolean handleRenderType(ItemStack is, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack is, Object... data) {

		NBTTagCompound nbt = is.getTagCompound();

		int tex = 0;
		//int tmdl = 0;

		if (nbt != null) {
			if (nbt.hasKey("Type")) tex=nbt.getInteger("Type");
			//if (nbt.hasKey("Size")) tmdl=nbt.getInteger("Size");
		}

		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/comparator_off.png"));
		mdl1.renderPart("base");
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/redstone_block.png"));
		mdl1.renderPart("chip");
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/iron_block.png"));
		mdl1.renderPart("leg_l1");
		mdl1.renderPart("leg_l2");
		mdl1.renderPart("leg_l3");
		mdl1.renderPart("leg_l4");
		mdl1.renderPart("leg_l5");
		mdl1.renderPart("leg_r1");
		mdl1.renderPart("leg_r2");
		mdl1.renderPart("leg_r3");
		mdl1.renderPart("leg_r4");
		mdl1.renderPart("leg_r5");

		GL11.glPopMatrix();
	}

}
