package smt.pack.common.api;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public final class RegisteredItems {
	
	private static final HashMap<String, ItemStack> items = new HashMap<String, ItemStack>();
	
	public static final ItemStack add(final String name, final ItemStack item) {
		return items.put(name, item);
	}

	public static final ItemStack get(final String name) {
		return items.get(name);
	}

	public static final HashMap<String, ItemStack> get() {
		return items;
	}

}
