package smt.pack.technology.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import smt.pack.technology.registry.FurnaceMobile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FurnaceContainer extends Container {

	private FurnaceMobile fm;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;

	public FurnaceContainer(EntityPlayer player, FurnaceMobile fm) {
		this.fm = fm;
		addSlotToContainer(new Slot(fm, 0, 56, 17));
		addSlotToContainer(new Slot(fm, 1, 56, 53));
		addSlotToContainer(new SlotFurnace(player, fm, 2, 116, 35));
		int i;

		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i) {
			addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting ic) {
		super.addCraftingToCrafters(ic);
		ic.sendProgressBarUpdate(this, 0, fm.furnaceCookTime);
		ic.sendProgressBarUpdate(this, 1, fm.furnaceBurnTime);
		ic.sendProgressBarUpdate(this, 2, fm.currentItemBurnTime);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting)crafters.get(i);

			if (lastCookTime != fm.furnaceCookTime) {
				icrafting.sendProgressBarUpdate(this, 0, fm.furnaceCookTime);
			}

			if (lastBurnTime != fm.furnaceBurnTime) {
				icrafting.sendProgressBarUpdate(this, 1, fm.furnaceBurnTime);
			}

			if (lastItemBurnTime != fm.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, fm.currentItemBurnTime);
			}
		}

		lastCookTime = fm.furnaceCookTime;
		lastBurnTime = fm.furnaceBurnTime;
		lastItemBurnTime = fm.currentItemBurnTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int p_75137_1_, int p_75137_2_) {
		if (p_75137_1_ == 0) {
			fm.furnaceCookTime = p_75137_2_;
		}

		if (p_75137_1_ == 1) {
			fm.furnaceBurnTime = p_75137_2_;
		}

		if (p_75137_1_ == 2) {
			fm.currentItemBurnTime = p_75137_2_;
		}
	}

	public boolean canInteractWith(EntityPlayer player) {
		return fm.isUseableByPlayer(player);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer player, int slot_i) {
		ItemStack itemstack = null;
		Slot slot = (Slot)inventorySlots.get(slot_i);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (slot_i == 2) {
				if (!mergeItemStack(itemstack1, 3, 39, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (slot_i != 1 && slot_i != 0) {
				if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
					if (!mergeItemStack(itemstack1, 0, 1, false)) {
						return null;
					}
				} else if (TileEntityFurnace.isItemFuel(itemstack1)) {
					if (!mergeItemStack(itemstack1, 1, 2, false)) {
						return null;
					}
				} else if (slot_i >= 3 && slot_i < 30) {
					if (!mergeItemStack(itemstack1, 30, 39, false)) {
						return null;
					}
				} else if (slot_i >= 30 && slot_i < 39 && !mergeItemStack(itemstack1, 3, 30, false)) {
					return null;
				}
			} else if (!mergeItemStack(itemstack1, 3, 39, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack)null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(player, itemstack1);
		}

		return itemstack;
	}

}
