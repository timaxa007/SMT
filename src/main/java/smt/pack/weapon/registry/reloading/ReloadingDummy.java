package smt.pack.weapon.registry.reloading;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import smt.pack.weapon.registry.WeaponSystem;

public abstract class ReloadingDummy {

	final WeaponSystem wpn_sys;
	final EntityPlayer player;
	int slotID, delay_reload;
	ItemStack temp;

	public ReloadingDummy(final WeaponSystem wpn_sys, final EntityPlayer player, final int slotID, final int delay_reload) {
		this.wpn_sys = wpn_sys;
		this.player = player;
		this.slotID = slotID;
		this.delay_reload = delay_reload;
	}

	public abstract void onUpdate();
	public abstract void finish();
	public abstract void breaking();

	public int getSlotID() {
		return slotID;
	}

	public int getDelayReload() {
		return delay_reload;
	}

}
