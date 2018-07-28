package smt.pack.weapon.registry;

public enum FireMode {

	FUSE,//safety lock
	AUTOMATIC,
	SINGLE,
	TWO,
	THREE,
	COLLECTING;

	public static FireMode getFireMode(String name) {
		if ("AUTOMATIC".equalsIgnoreCase(name)) return AUTOMATIC;
		else if ("SINGLE".equalsIgnoreCase(name)) return SINGLE;
		else if ("TWO".equalsIgnoreCase(name)) return TWO;
		else if ("THREE".equalsIgnoreCase(name)) return THREE;
		else if ("COLLECTING".equalsIgnoreCase(name)) return COLLECTING;
		else return FUSE;
	}

}
