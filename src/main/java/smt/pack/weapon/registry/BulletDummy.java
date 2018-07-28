package smt.pack.weapon.registry;

import javax.annotation.Nonnull;

public class BulletDummy {

	public String name, description;
	public int damage;
	public float size, speed, weight;
	public String[] effects;
	
	public final Bullet toBullet() {
		return new Bullet(name, description, damage, size, speed, weight, effects);
	}

}
