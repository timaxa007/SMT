package timaxa007.module.fluids.util;


public class ListFluidType {

	public static FluidType
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

	public static FluidType[] list;

	public static void init() {

		fluid = new FluidType("fluid");
		liquid = new FluidType("liquid").setIgniter(-8);
		air = new FluidType("air").setIgniter(1);
		gas = new FluidType("gas").setIgniter(10);
		smoke = new FluidType("smoke").setIgniter(-1);
		oil = new FluidType("oil").setIgniter(3);
		magic = new FluidType("magic").setIgniter(0);
		energy = new FluidType("energy").setIgniter(0);
		molten = new FluidType("molten").setIgniter(0);
		dust = new FluidType("dust").setIgniter(0);

		list = new FluidType[] {
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

		RegistryFluids.registerFluidType(list);
	}

}
