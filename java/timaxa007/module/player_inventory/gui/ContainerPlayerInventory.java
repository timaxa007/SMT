package timaxa007.module.player_inventory.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

//ContainerPlayer
public class ContainerPlayerInventory extends Container {

	private int numRows;

	public ContainerPlayerInventory() {

	}

	public ContainerPlayerInventory(EntityPlayer player) {
		int i = (this.numRows - 4) * 18;
		int j;
		int k;

		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
			}
		}

		for (j = 0; j < 9; ++j) {
			this.addSlotToContainer(new Slot(player.inventory, j, 8 + j * 18, 161 + i));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {return true;}

}
