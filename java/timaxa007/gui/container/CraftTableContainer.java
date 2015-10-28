package timaxa007.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import timaxa007.gui.inventory.CraftTableInventory;

public class CraftTableContainer extends Container {

	private CraftTableInventory inv;
	private int numRows;
	private EntityPlayer player;

	//public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory craftResult = new InventoryCraftResult();

	public CraftTableContainer(EntityPlayer player, CraftTableInventory craftTableInventory) {
		inv = craftTableInventory;
		this.player = player;
		inv.openInventory();//Типа инициализируем открытия инвентаря
		addSlotToContainer(new SlotCrafting(player, inv, craftResult, 0, 124, 35));
		int l;
		int i1;

		for (l = 0; l < 3; ++l) {
			for (i1 = 0; i1 < 3; ++i1) {
				addSlotToContainer(new Slot(inv, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
			}
		}

		for (l = 0; l < 3; ++l) {
			for (i1 = 0; i1 < 9; ++i1) {
				addSlotToContainer(new Slot(player.inventory, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
			}
		}

		for (l = 0; l < 9; ++l) {
			addSlotToContainer(new Slot(player.inventory, l, 8 + l * 18, 142));
		}

		onCraftMatrixChanged(inv);
	}

	@Override
	public void onCraftMatrixChanged(IInventory p_75130_1_) {
		//craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(inv, player.worldObj));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return inv.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot_i) {
		ItemStack is = null;
		Slot slot = (Slot)inventorySlots.get(slot_i);

		if (slot != null && slot.getHasStack()) {
			ItemStack is1 = slot.getStack();
			is = is1.copy();

			if (slot_i == 0) {
				if (!mergeItemStack(is1, 10, 46, true)) return null;
				slot.onSlotChange(is1, is);
			} else if (slot_i >= 10 && slot_i < 37) {
				if (!mergeItemStack(is1, 37, 46, false)) return null;
			} else if (slot_i >= 37 && slot_i < 46) {
				if (!mergeItemStack(is1, 10, 37, false)) return null;
			} else if (!mergeItemStack(is1, 10, 46, false)) return null;

			if (is1.stackSize == 0) slot.putStack((ItemStack)null);
			else slot.onSlotChanged();

			if (is1.stackSize == is.stackSize) return null;

			slot.onPickupFromSlot(player, is1);
		}

		return is;
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		inv.closeInventory();//Типа инициализируем закрытия инвентаря
	}

}
