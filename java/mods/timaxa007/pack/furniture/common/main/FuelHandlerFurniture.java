package mods.timaxa007.pack.furniture.common.main;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandlerFurniture implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		//if (fuel.getItem() == core.blockWoodColors) {return 200;}
		return 0;
	}

}
