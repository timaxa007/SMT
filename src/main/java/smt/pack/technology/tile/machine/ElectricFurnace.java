package smt.pack.technology.tile.machine;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.technology.api.RecipesTechnology;

public class ElectricFurnace extends ElectricMachine {

	static final int[] slotsTop = new int[] {0};
	static final int[] slotsBottom = new int[] {2, 1};
	static final int[] slotsSides = new int[] {1};
	InventoryBasic inventory = new InventoryBasic("InventoryElectricFurnace", false, 3);

	public smt.pack.common.api.object.Recipe currentRecipe;
	public int furnaceCookTime;
	public int furnaceBurnTime;

	String customName;

	public ElectricFurnace(smt.pack.technology.tile.TileEntityElectricMachine tile) {
		super(tile);
		furnaceCookTime = 0;
		furnaceBurnTime = 0;
	}

	@Override
	public void update() {
/*
		if (!tile.getWorldObj().isRemote) {
			ItemStack input = inventory.getStackInSlot(0);
			ItemStack output = inventory.getStackInSlot(2);
			ItemStack fuel = inventory.getStackInSlot(1);

			if (furnaceBurnTime > 0) {
				--furnaceBurnTime;
				if (furnaceCookTime > 0) --furnaceCookTime;
			}

			if (input != null && currentRecipe != null && !currentRecipe.getInput().isMatchIngredient(input))
				currentRecipe = null;

			if (input != null) {
				if (currentRecipe == null) {
					currentRecipe = RecipesTechnology.elecricFurnace.findRecipe(input);
					if (currentRecipe != null) {
						if (output == null || (ItemStack.areItemStackTagsEqual(currentRecipe.getOutput(), output) && 
								output.stackSize + currentRecipe.getOutput().stackSize <= output.getMaxStackSize())) {
							furnaceCookTime = currentRecipe.getTime();
						} else currentRecipe = null;
					}
				} else {

					if (furnaceBurnTime <= 0) {
						int burnTime = TileEntityFurnace.getItemBurnTime(fuel);
						if (burnTime != 0) {
							furnaceBurnTime = burnTime;
							--fuel.stackSize;
							if (fuel.stackSize == 0)
								inventory.setInventorySlotContents(1, fuel.getItem().getContainerItem(fuel));
						}
					}

					if (furnaceCookTime <= 0) {

						input.stackSize -= currentRecipe.getInput().getIngredient().stackSize;
						if (input.stackSize <= 0)
							inventory.setInventorySlotContents(0, null);

						if (output == null)
							inventory.setInventorySlotContents(2, currentRecipe.getOutput().copy());
						else
							output.stackSize += currentRecipe.getOutput().stackSize;
						currentRecipe = null;
					}

				}
			} else if (input == null && currentRecipe != null) {
				currentRecipe = null;
			}

		}
		*/
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {

		NBTTagList nbttaglist = nbt.getTagList("Items", NBT.TAG_COMPOUND);

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte slot = nbttagcompound1.getByte("Slot");

			if (slot >= 0 && slot < inventory.getSizeInventory())
				inventory.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(nbttagcompound1));
		}

		furnaceBurnTime = nbt.getShort("BurnTime");
		furnaceCookTime = nbt.getShort("CookTime");

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {

		nbt.setShort("BurnTime", (short)furnaceBurnTime);
		nbt.setShort("CookTime", (short)furnaceCookTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < inventory.getSizeInventory(); ++i) {
			if (inventory.getStackInSlot(i) != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				inventory.getStackInSlot(i).writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbt.setTag("Items", nbttaglist);

	}

}
