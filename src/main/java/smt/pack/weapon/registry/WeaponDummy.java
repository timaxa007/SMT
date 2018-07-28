package smt.pack.weapon.registry;

public class WeaponDummy {

	public String name, description, shooting, reloading;
	public int delay_fire, delay_reload;//in ticks
	public FireMode[] mode_fire;
	public String[] ammunition;

	public Weapon toWeapon() {
		return new Weapon(name, description, shooting, reloading, delay_fire, delay_reload, mode_fire, ammunition);
	}

}
