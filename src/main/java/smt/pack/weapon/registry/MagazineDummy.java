package smt.pack.weapon.registry;

public class MagazineDummy {

	public String name, description;
	public int amount;
	public String[] bullets;
	
	public final Magazine toMagazine() {
		return new Magazine(name, description, amount, bullets);
	}

}
