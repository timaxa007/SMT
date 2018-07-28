package smt.pack.technology.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import smt.pack.technology.tile.TileEntityElectricMachine;
import smt.pack.technology.tile.machine.ElectricCrusher;

public class ElectricMachineContainer extends net.minecraft.inventory.Container {

	final TileEntityElectricMachine tile;

	public ElectricMachineContainer(EntityPlayer player, TileEntityElectricMachine tile) {
		this.tile = tile;
		//tile.openInventory();//Типа инициализируем открытия инвентаря
		int numRows = 1;

		if (tile.getElectricMachine() instanceof ElectricCrusher)
			addSlotToContainer(new Slot(((ElectricCrusher)tile.getElectricMachine()).getInventory(), 0, 8, 0));

		if (tile.getInventoryOutput() != null) {
			numRows = tile.getInventoryOutput().getSizeInventory() / 9;
			/*
			for (int id = 0; id < tile.getInventoryOutput().getSizeInventory(); ++id) {
				addSlotToContainer(new Slot(tile.getInventoryOutput(), id, 8 + (id % 9) * 18, 18 + (id / 9) * 18));
			}
			 */
		}

		int i = (numRows - 4) * 18;
		int j;
		int k;

		//Слоты инвентаря игрока
		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
			}
		}

		//Слоты хот-бара игрока
		for (j = 0; j < 9; ++j) {
			addSlotToContainer(new Slot(player.inventory, j, 8 + j * 18, 161 + i));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
