package mods.timaxa007.pack.furniture.client.render.item;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ItemRenderBlockMashineWater implements IItemRenderer {
	private static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/masine_water.obj"));

	public ItemRenderBlockMashineWater() {

	}

	@Override
	public boolean handleRenderType(ItemStack is, ItemRenderType type) {
		return false;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack is, Object... data) {

	}

}
