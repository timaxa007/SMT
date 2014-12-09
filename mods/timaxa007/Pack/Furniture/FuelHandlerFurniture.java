package mods.timaxa007.Pack.Furniture;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandlerFurniture implements IFuelHandler{

@Override
public int getBurnTime(ItemStack fuel) {
//if(fuel.itemID==core.blockWoodColors.blockID) {return 200;}
return 0;
}

}
