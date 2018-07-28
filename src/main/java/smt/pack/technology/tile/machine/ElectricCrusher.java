package smt.pack.technology.tile.machine;

import java.util.ArrayList;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.common.api.IRecipe;
import smt.pack.common.api.object.Recipe;
import smt.pack.technology.api.RecipesTechnology;

public class ElectricCrusher extends ElectricMachine {

	IInventory inventoryMain = new InventoryBasic("inventory_crasher", false, 1);
	int timeLeft = 0;
	IRecipe recipe = null;
	ArrayList<ItemStack> temp = new ArrayList<ItemStack>();

	public ElectricCrusher(smt.pack.technology.tile.TileEntityElectricMachine tile) {
		super(tile);
	}

	@Override
	public void update() {
		//if (tile != null)
		if (!tile.getWorldObj().isRemote) {
			ItemStack input = getInventory().getStackInSlot(0);

			if (input != null && recipe == null && temp.isEmpty()) {
				recipe = RecipesTechnology.elecricCrusher.findRecipe(input);
				if (recipe != null) {
					timeLeft = recipe.time();
					input.stackSize -= recipe.ingredient().getIngredient().stackSize;
					if (input.stackSize <= 0)
						getInventory().setInventorySlotContents(0, null);
				}
			}

			int speed = 1;
			if (timeLeft > 0 && tile.getEnergy().isAddEnergy(-speed)) {
				timeLeft -= speed;
				tile.getEnergy().addEnergy(-speed);
				System.out.println(tile.getEnergy().getEnergy());
			}
			else if (timeLeft <= 0 && recipe != null && temp.isEmpty()) {
				for (ItemStack output : recipe.result()) temp.add(output.copy());
				recipe = null;
			}
			if (!temp.isEmpty()) {
				if (tile.getInventoryOutput() != null)
					for (int i = 0; i < temp.size(); ++i) {
						ItemStack empty = tile.addInventoryOutput(temp.get(i));
						if (empty == null || empty.stackSize <= 0) {
						temp.remove(i);
						--i;
						}
					}
			}

		}
	}

	public IInventory getInventory() {
		return inventoryMain;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList(getInventory().getInventoryName(), NBT.TAG_COMPOUND);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte slot = nbttagcompound1.getByte("Slot");
			if (slot >= 0 && slot < getInventory().getSizeInventory())
				getInventory().setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(nbttagcompound1));
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < getInventory().getSizeInventory(); ++i) {
			if (getInventory().getStackInSlot(i) != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				getInventory().getStackInSlot(i).writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag(getInventory().getInventoryName(), nbttaglist);
	}

}
