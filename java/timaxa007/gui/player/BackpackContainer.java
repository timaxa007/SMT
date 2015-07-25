package timaxa007.gui.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class BackpackContainer extends Container {

	public BackpackContainer(EntityPlayer player) {

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
