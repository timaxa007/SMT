package smt.pack.weapon.registry;

import javax.annotation.Nonnull;

public class Bullet {

	final String name, description;
	final int damage;
	final float size, speed, weight;
	final String[] effects;

	public Bullet(final String name, final String description,
			final int damage, final float size, final float speed, final float weight, final String[] effects) {
		this.name = name;
		this.description = description;
		this.damage = damage;
		this.size = size;
		this.speed = speed;
		this.weight = weight;
		this.effects = effects;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getDamage() {
		return damage;
	}

	public float getSize() {
		return size;
	}

	public float getSpeed() {
		return speed;
	}

	public float getWeight() {
		return weight;
	}

	public String[] getEffects() {
		return effects;
	}

}
