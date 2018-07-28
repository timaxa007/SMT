package smt.pack.weapon.registry.shooting;

import net.minecraft.entity.player.EntityPlayer;
import smt.pack.weapon.registry.WeaponSystem;

public abstract class ShootingDummy {

	final WeaponSystem wpn_sys;
	final EntityPlayer player;
	public int delay_fire = 0;
	protected boolean isLeft;

	public ShootingDummy(final WeaponSystem wpn_sys, final EntityPlayer player) {
		this.wpn_sys = wpn_sys;
		this.player = player;
	}

	public abstract void onUpdate();
	public abstract void leftClick(boolean isLeft);
	public abstract void shot();
	public abstract void breaking();

}
