package smt.pack.weapon.registry;

import javax.annotation.Nonnull;

public class Weapon {

	final String name, description, shooting, reloading;
	final int delay_fire, delay_reload;//in ticks
	final FireMode[] mode_fire;
	final String[] ammunition;

	public Weapon(final String name, final String description, final String shooting, final String reloading,
			final int delay_fire, final int delay_reload, final FireMode[] mode_fire, final String[] ammunition) {
		this.name = name;
		this.description = description;
		this.shooting = shooting;
		this.reloading = reloading;
		this.delay_fire = delay_fire;
		this.delay_reload = delay_reload;
		this.mode_fire = mode_fire;
		this.ammunition = ammunition;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getDelayFire() {
		return delay_fire;
	}

	public int getDelayReload() {
		return delay_reload;
	}

	public FireMode[] getModeFire() {
		return mode_fire;
	}

	public String[] getAmmunition() {
		return ammunition;
	}

}
