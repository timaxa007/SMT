package timaxa007.module.substance.util;


public class ListSubstanceType {

	public static SubstanceType
	fluid,
	liquid,
	air,
	gas,
	smoke,
	oil,
	magic,
	energy,
	molten,
	dust
	;

	public static SubstanceType[] list;

	public static void init() {

		fluid = new SubstanceType("fluid");
		liquid = new SubstanceType("liquid").setIgniter(-8);
		air = new SubstanceType("air").setIgniter(1);
		gas = new SubstanceType("gas").setIgniter(10);
		smoke = new SubstanceType("smoke").setIgniter(-1);
		oil = new SubstanceType("oil").setIgniter(3);
		magic = new SubstanceType("magic").setIgniter(0);
		energy = new SubstanceType("energy").setIgniter(0);
		molten = new SubstanceType("molten").setIgniter(0);
		dust = new SubstanceType("dust").setIgniter(0);

		list = new SubstanceType[] {
				fluid,
				liquid,
				air,
				gas,
				smoke,
				oil,
				magic,
				energy,
				molten,
				dust
		};

		RegistrySubstance.registerSubstanceType(list);
	}

}
