package mods.timaxa007.pack.weapon.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerModifyWeapons extends Container {

	public ContainerModifyWeapons(EntityPlayer player) {
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
