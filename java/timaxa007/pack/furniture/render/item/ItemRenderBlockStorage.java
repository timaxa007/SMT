package timaxa007.pack.furniture.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import timaxa007.pack.conjoint.lib.AddTextureModel;

public class ItemRenderBlockStorage implements IItemRenderer {

	private static final IModelCustom model = 
			AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/furniture/storage/storage_01.obj"));
	private static final ResourceLocation texture1 = AddTextureModel.get("minecraft_log_oak").getTexture();
	private static final ResourceLocation texture2 = AddTextureModel.get("minecraft_planks_oak").getTexture();

	public ItemRenderBlockStorage() {

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

		String tag = "";
		int rotation = 0;
		String style = "";
		String custom_name = "";

		if (nbt != null) {
			if (nbt.hasKey("Tag")) tag = nbt.getString("Tag");
			if (nbt.hasKey("Style")) style = nbt.getString("Style");
			if (is.hasDisplayName()) custom_name = is.getDisplayName();
		}

		//------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		bindTexture(texture1);
		model.renderPart("box");
		GL11.glPopMatrix();
		//------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		bindTexture(texture2);
		model.renderPart("door");
		GL11.glPopMatrix();
		//------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		bindTexture(texture2);
		model.renderPart("handler_right");
		GL11.glPopMatrix();
		//------------------------------------------
	}

	private static final void bindTexture(ResourceLocation texture) {
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	}

}
