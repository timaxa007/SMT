package smt.pack.cookery.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import smt.pack.cookery.registry.RecipesGrill;

public class TileEntityGrill extends TileEntity implements ISidedInventory {

	InventoryBasic inventory = new InventoryBasic("inventoryGrill", false, 10);
	String customName;
	RecipesGrill.Recipe[] recipe = new RecipesGrill.Recipe[9];
	int[] timeCooking = new int[9];
	int timeBurn = 0;

	public TileEntityGrill() {

	}

	public void updateEntity() {

		boolean drying = worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord) && worldObj.isDaytime() && worldObj.getLightBrightness(xCoord, yCoord + 1, zCoord) > 0.5F;

		for (int j = 0; j < 9; ++j) {
			ItemStack slot = inventory.getStackInSlot(j);
			if (slot == null) continue;
			if (recipe[j] != null) {
				if (timeCooking[j] > 0) {
					if (timeBurn > 0) --timeCooking[j];
					else {
						if (drying && worldObj.getWorldTime() % 20 == 0)
							--timeCooking[j];
					}
				}
				else {
					inventory.setInventorySlotContents(j, recipe[j].output.copy());
					recipe[j] = null;
				}
			} else {
				recipe[j] = RecipesGrill.instance.findRecipe(slot);
				if (recipe[j] != null)
					timeCooking[j] = recipe[j].time;
			}
		}

		if (timeBurn <= 0) {
			ItemStack fuelSlot = inventory.getStackInSlot(9);
			if (fuelSlot != null) {
				timeBurn = TileEntityFurnace.getItemBurnTime(fuelSlot);
				if (timeBurn > 0)
					--fuelSlot.stackSize;
				if (fuelSlot.stackSize <= 0)
					inventory.setInventorySlotContents(9, null);
			}
		} else --timeBurn;
	}

	@Override
	public int getSizeInventory() {
		return inventory.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return inventory.getStackInSlot(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int size) {
		return inventory.decrStackSize(index, size);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		return inventory.getStackInSlotOnClosing(index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack itemStack) {
		inventory.setInventorySlotContents(index, itemStack);
	}

	@Override
	public String getInventoryName() {
		return hasCustomInventoryName() ? customName : "InventoryGrill";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return customName != null || customName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack itemStack) {
		return inventory.isItemValidForSlot(index, itemStack);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStack, int side) {
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack itemStack, int side) {
		return false;
	}

}
