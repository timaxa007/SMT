package mods.timaxa007.pack.magic.ri;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderMagicCauldron implements IItemRenderer{

@Override
public boolean handleRenderType(ItemStack item, ItemRenderType type) {return true;}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {return true;}

@Override
public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

}

}