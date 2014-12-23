package mods.timaxa007.pack.furniture.recipe;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandlerFurniture implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == PackFurniture.proxy.item.items_for_furniture) return 200;
		return 0;
	}

}
