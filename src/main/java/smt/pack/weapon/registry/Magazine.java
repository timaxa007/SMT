package smt.pack.weapon.registry;

import javax.annotation.Nonnull;

public class Magazine {

	final String name, description;
	final int amount;
	final String[] bullets;

	public Magazine(final String name, final String description,
			final int amount, final String[] bullets) {
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.bullets = bullets;
	}

	@Nonnull
	public String getName() {
		return name;
	}

	@Nonnull
	public String getDescription() {
		return description;
	}

	public int getAmount() {
		return amount;
	}

	public String[] getBullets() {
		return bullets;
	}

}
