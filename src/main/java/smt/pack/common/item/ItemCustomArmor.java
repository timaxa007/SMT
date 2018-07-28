package smt.pack.common.item;

import java.util.HashMap;

import net.minecraft.item.ItemStack;
import smt.pack.common.api.object.ItemCustomArmorDummy;

public class ItemCustomArmor extends ItemCustomArmorDummy implements smt.pack.common.api.IRegisterItem {

	public ItemCustomArmor(int armorType) {
		super(armorType);
	}
	/*
	@SideOnly(Side.CLIENT)
	private ArmorCustomModel
	acm0 = new ArmorCustomModelTest(0),
	acm1 = new ArmorCustomModelTest(1),
	acm2 = new ArmorCustomModelTest(2),
	acm3 = new ArmorCustomModelTest(3);

	@SideOnly(Side.CLIENT)
	@Override
	public ArmorCustomModel getModel(EntityLivingBase entityPlayer, ItemStack stack, int slot) {
		switch (slot) {
		case 3:return acm0;
		case 2:return acm1;
		case 1:return acm2;
		case 0:return acm3;
		case -1:return acm0;
		default:return null;
		}
	}
	 */
	@Override
	public String getRegisterName() {
		switch(this.armorType) {
		case 0:return "item_armor_helmet";
		case 1:return "item_armor_vest";
		case 2:return "item_armor_pants";
		case 3:return "item_armor_boots";
		default:return "item_armor";
		}
	}

	@Override
	public void getRegisterItem(final HashMap<String, ItemStack> map) {
		map.put(getRegisterName(), new ItemStack(this));
	}

}
