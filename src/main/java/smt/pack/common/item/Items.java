package smt.pack.common.item;

import java.util.HashSet;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.common.SMTCommon;
import smt.pack.common.api.IRegisterItem;

public final class Items {

	public static final void init() {
		final HashSet<Item> set = new HashSet<Item>();
		set.add(new ItemItemsCommon().setUnlocalizedName("items_common").setCreativeTab(SMTCommon.tabCommon));
		set.add(new ItemAnimation().setUnlocalizedName("animation").setCreativeTab(SMTCommon.tabCommon));
		set.add(new ItemSword().setUnlocalizedName("sword").setCreativeTab(SMTCommon.tabCommon).setMaxStackSize(1).setMaxDamage(1024));
		set.add(new ItemBook().setUnlocalizedName("book").setCreativeTab(SMTCommon.tabCommon));
		set.add(new ItemBackpack().setUnlocalizedName("backpack").setCreativeTab(SMTCommon.tabCommon).setMaxStackSize(1).setTextureName(SMTCommon.MODID + ":backpack"));
		set.add(new ItemCustomArmor(0).setUnlocalizedName("armor_helmet").setCreativeTab(SMTCommon.tabCommon));
		set.add(new ItemCustomArmor(1).setUnlocalizedName("armor_vest").setCreativeTab(SMTCommon.tabCommon));
		set.add(new ItemCustomArmor(2).setUnlocalizedName("armor_pants").setCreativeTab(SMTCommon.tabCommon));
		set.add(new ItemCustomArmor(3).setUnlocalizedName("armor_boots").setCreativeTab(SMTCommon.tabCommon));

		for (Item item : set) {
			if (item instanceof IRegisterItem) {
				IRegisterItem regItem = (IRegisterItem)item;
				GameRegistry.registerItem(item, regItem.getRegisterName());
				regItem.getRegisterItem(smt.pack.common.api.RegisteredItems.get());
			} else
				GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
		}
	}

}
