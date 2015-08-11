package timaxa007.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import timaxa007.api.IItemStorage;

public class StorageSlot extends Slot {

	public StorageSlot(IInventory inv, int id, int x, int y) {
		super(inv, id, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack is) {

		if (is != null) {
			//-----------------------------------------------------
			if (is.getItem() instanceof IItemStorage) return false;
			//-----------------------------------------------------
			// No - implements, Yes - extends
			//--forestry--"forestry.storage.items.ItemBackpack"
			try {if (Class.forName("forestry.core.items.ItemInventoried").isInstance(is.getItem())) return false;} catch(Exception e) {}
			//railcraft - он добавляет рюкзак с помощью forestry, так что не знаю.
			try {if (Class.forName("mods.railcraft.common.plugins.forestry.BaseBackpack").isInstance(is.getItem())) return false;} catch(Exception e) {}
			//Ранец не хранит в себе, он просто как апгрейд для игрока, но всё-же добавил. Скоро будет опциональна, как и всё другое.
			try {if (Class.forName("tconstruct.armor.items.Knapsack").isInstance(is.getItem())) return false;} catch(Exception e) {}
			//Дальше, просто по-поиску из import'ов
			try {if (Class.forName("de.eydamos.backpack.item.ItemBackpackBase").isInstance(is.getItem())) return false;} catch(Exception e) {}
			//-----------------------------------------------------
		}
		return super.isItemValid(is);
	}

}
