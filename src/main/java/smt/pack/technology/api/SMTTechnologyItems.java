package smt.pack.technology.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class SMTTechnologyItems {

	private static final HashMap<String, ItemStack> items = new HashMap<String, ItemStack>();

	public static final boolean addItem(@Nonnull String name, @Nonnull ItemStack item) {
		if (name == null || item == null) return false;
		//if (find(name) != null) return false;
		if (items.put(name, item) != null) return true;
		return false;
	}

	public static final boolean hasItems() {
		return !items.isEmpty();
	}

	public static final ItemStack getItem(String name) {
		if (name == null) return null;

		Iterator iterator = Item.itemRegistry.iterator();

		while (iterator.hasNext()) {
			Item item = (Item)iterator.next();

			if (item == null) continue;

			if (item.getUnlocalizedName().equals(name)) return new ItemStack(item);
		}

		return null;
	}

	public static final @Nullable String getName(@Nonnull ItemStack item) {
		if (item == null) return null;

		for (Map.Entry<String, ItemStack> entry : items.entrySet())
			if (entry.getValue() == item) return entry.getKey();
			else if (ItemStack.areItemStacksEqual(entry.getValue(), item)) return entry.getKey();

		return null;
	}

	public static final @Nonnull HashMap<String, ItemStack> getMapItems() {
		return items;
	}

}
