package mods.timaxa007.Pack.Furniture.RenderItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderLights implements IItemRenderer {

@Override
public boolean handleRenderType(ItemStack is, ItemRenderType type) {return true;}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {return true;}

@Override
public void renderItem(ItemRenderType type, ItemStack is, Object... data) {

}

}
