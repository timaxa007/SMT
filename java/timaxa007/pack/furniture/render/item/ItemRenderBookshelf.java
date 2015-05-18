package timaxa007.pack.furniture.render.item;

import timaxa007.smt.lib.AddTextureModel;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderBookshelf implements IItemRenderer{
	private static final IModelCustom mdl1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/bookshelf_side.obj"));
	private static final IModelCustom mdl2 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/bookshelf_shelf.obj"));

	public ItemRenderBookshelf() {

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

		String tex = "";

		if (nbt != null) {
			if (nbt.hasKey("Style")) tex = nbt.getString("Style");
		}

		float par1 = 0.0625F;
		float par2 = 0.01F;

		GL11.glPushMatrix();
		GL11.glTranslatef((float)0.5F, (float)0.0F, (float)0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdl1.renderAll();
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glTranslatef((float)0.5F, (float)(par1*7), (float)0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(AddTextureModel.get(tex).getTexture());
		mdl2.renderAll();
		GL11.glPopMatrix();

	}

}
