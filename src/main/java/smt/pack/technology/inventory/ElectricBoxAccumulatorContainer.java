package smt.pack.technology.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import smt.pack.technology.tile.TileEntityElectricBoxAccumulator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ElectricBoxAccumulatorContainer extends net.minecraft.inventory.Container {

	private TileEntityElectricBoxAccumulator te;
	private int lastEnergy;
	private int lastEnergyMax;
	private int lastTemperature;

	public ElectricBoxAccumulatorContainer(InventoryPlayer invPlayer, TileEntityElectricBoxAccumulator tile) {
		te = tile;
		if (te != null) {
			addSlotToContainer(new Slot(tile.getInventory(), 0, 8, 15));
			addSlotToContainer(new Slot(tile.getInventory(), 1, 8, 51));
		}

		int i;

		for (i = 0; i < 3; ++i) for (int j = 0; j < 9; ++j)
				addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 92 + i * 18));

		for (i = 0; i < 9; ++i)
			addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 150));

	}

	@Override
	public void addCraftingToCrafters(ICrafting ic) {
		super.addCraftingToCrafters(ic);
		ic.sendProgressBarUpdate(this, 0, te.getEnergy());
		ic.sendProgressBarUpdate(this, 1, te.getEnergyMax());;
		ic.sendProgressBarUpdate(this, 2, te.temperature);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting)crafters.get(i);

			if (lastEnergy != te.getEnergy())
				icrafting.sendProgressBarUpdate(this, 0, te.getEnergy());

			if (lastEnergyMax != te.getEnergyMax())
				icrafting.sendProgressBarUpdate(this, 1, te.getEnergyMax());

			if (lastTemperature != te.temperature)
				icrafting.sendProgressBarUpdate(this, 2, te.temperature);

		}

		lastEnergy = te.getEnergy();
		lastEnergyMax = te.getEnergyMax();
		lastTemperature = te.temperature;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int i1, int i2) {
		if (i1 == 0) te.setEnergy(i2);
		if (i1 == 1) te.setEnergyMax(i2);
		if (i1 == 2) te.temperature = i2;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return te.isUseableByPlayer(player);
	}
	/*
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot_i) {
		ItemStack itemstack = null;
		Slot slot = (Slot)inventorySlots.get(slot_i);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (slot_i == 2) {
				if (!mergeItemStack(itemstack1, 3, 39, true)) return null;
				slot.onSlotChange(itemstack1, itemstack);
			} else if (slot_i != 1 && slot_i != 0) {
				if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
					if (!mergeItemStack(itemstack1, 0, 1, false)) return null;
				}
				else if (TileEntityElectricBoxAccumulator.isItemFuel(itemstack1)) {
					if (!mergeItemStack(itemstack1, 1, 2, false)) return null;
				} else if (slot_i >= 3 && slot_i < 30) {
					if (!mergeItemStack(itemstack1, 30, 39, false)) return null;
				} else if (slot_i >= 30 && slot_i < 39 && !mergeItemStack(itemstack1, 3, 30, false)) return null;
			} else if (!mergeItemStack(itemstack1, 3, 39, false)) return null;

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack)null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize)
				return null;

			slot.onPickupFromSlot(player, itemstack1);
		}

		return itemstack;
	}
	 */
}
