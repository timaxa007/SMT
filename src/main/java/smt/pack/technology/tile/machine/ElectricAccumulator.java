package smt.pack.technology.tile.machine;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import smt.pack.ActionInventory;
import smt.pack.technology.api.IElectricItem;

public class ElectricAccumulator extends ElectricMachine {

	private IInventory inventoryMain = new InventoryBasic("ElectricAccumulator", false, 2);

	public ElectricAccumulator(smt.pack.technology.tile.TileEntityElectricMachine tile) {
		super(tile);
	}

	@Override
	public void update() {
		//System.out.println("CLIENT " + (FMLCommonHandler.instance().getSide() == Side.CLIENT));
		if (!tile.getWorldObj().isRemote) {
			if (canWork()) {
				{
					ItemStack slot0 = inventoryMain.getStackInSlot(0);
					if (slot0 != null) {
						chargingItem(slot0);
					}
					//if (canWork(-1)) charge(slot0, 1);
				}
				{
					ItemStack slot1 = inventoryMain.getStackInSlot(1);
					if (slot1 != null) {
						dischargingItem(slot1);
					}
					//if (canWork(1)) charge(slot1, -1);
				}
			}
		}
	}

	public boolean chargingItem(ItemStack itemStack) {
		if (itemStack.getItem() instanceof IElectricItem) {
			IElectricItem ie = (IElectricItem)itemStack.getItem();
			if (ie.isCharging(itemStack)) {
				int charge = Math.min(ie.getRateMax(), tile.getEnergy().getRateMax());
				//if (ie.getEnergyMax(is) >= ie.getEnergy(is) + charge) {
				//System.out.println("chargingItem");
				if (ie.isAddEnergy(itemStack, charge) && tile.getEnergy().isAddEnergy(-charge)) {
					tile.getEnergy().addEnergy(-(charge + ie.addEnergy(itemStack, charge)));
				}
				return true;
				//}
			}
		}
		return false;
	}

	//Yeah, I need the mind inside out.
	public boolean dischargingItem(ItemStack itemStack) {
		if (itemStack.getItem() instanceof IElectricItem) {
			IElectricItem ie = (IElectricItem)itemStack.getItem();
			if (ie.isDischarging(itemStack)) {
				int charge = Math.min(ie.getRateMax(), tile.getEnergy().getRateMax());
				//if (0 <= ie.getEnergy(is) - charge) {
				//System.out.println("dischargingItem");
				if (ie.isAddEnergy(itemStack, -charge) && tile.getEnergy().isAddEnergy(charge)) {
					ie.addEnergy(itemStack, -(charge - tile.getEnergy().addEnergy(charge)));
				}
				//}
				return true;
			}
		}
		return false;
	}
	/*
	public boolean charge(ItemStack itemStack, int i) {
		if (i == 0) return false;
		if (itemStack != null && itemStack.getItem() instanceof IElectricItem) {
			IElectricItem ie = (IElectricItem)itemStack.getItem();
			boolean plus = ie.getEnergyMax(itemStack) >= ie.getEnergy(itemStack) + i;
			boolean minus = 0 <= ie.getEnergy(itemStack) + i;
			if (ie.isCharging(itemStack) && i >= 0 ? plus : minus) {
				ie.addEnergy(itemStack, i);
				addEnergy(-i);
				return true;
			}
		}
		return false;
	}
	 */
	public boolean canWork() {
		return canWork(0);
	}

	public boolean canWork(int i) {
		boolean plus = tile.getEnergy().getEnergyMax() >= tile.getEnergy().getEnergy() + i;
		boolean minus = 0 <= tile.getEnergy().getEnergy() + i;
		return i == 0 ? (plus && minus) : i > 0 ? plus : minus;
	}

	public IInventory getInventory() {
		return inventoryMain;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		inventoryMain = ActionInventory.readFromNBT(nbt, inventoryMain);

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		ActionInventory.writeToNBT(nbt, inventoryMain);

	}

}
