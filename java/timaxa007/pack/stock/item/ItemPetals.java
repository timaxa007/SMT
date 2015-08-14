package timaxa007.pack.stock.item;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.lib.ReceivingNutriment;
import timaxa007.pack.conjoint.object.ModifiedItem;

public class ItemPetals extends ModifiedItem {

	public ItemPetals(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_plant);
		setHasSubtypes(true);
		setMaxDamage(0);
		//setMaxStackSize(1);
		setTextureName("timaxa007:petals");
	}

	public static ItemStack addNBT(String tag) {
		ItemStack is = new ItemStack(PackStock.item.petals);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Petal", tag);
		is.setTagCompound(nbt);
		return is;
	}

}
