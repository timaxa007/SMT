package mods.timaxa007.pack.stock.render.item;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderFoods implements IItemRenderer {

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

		NBTTagCompound tag = is.getTagCompound();

		String nameID = null;
		int color1 = 0xFFFFFF;
		int color2 = 0xFFFFFF;

		if (tag != null) {
			if (tag.hasKey("NameID")) nameID = tag.getString("NameID");
			if (tag.hasKey("Color1")) color1 = tag.getInteger("Color1");
			if (tag.hasKey("Color2")) color2 = tag.getInteger("Color2");
		}

	}

}
