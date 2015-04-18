package timaxa007.pack.mining.lib;

import timaxa007.module.fluids.Fluids;

public class ListMining {

	public static final Fluids fluid_air = new Fluids("air").setName("air").setType(Fluids.TypeFluid.air).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_water = new Fluids("water").setName("water").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_gas_smoke = new Fluids("gas_smoke").setName("smoke").setType(Fluids.TypeFluid.smoke).setColor(0xFFFFFF).setTemperature(18.0F);
	public static final Fluids fluid_gas_steam = new Fluids("gas_steam").setName("steam").setType(Fluids.TypeFluid.gas).setColor(0xFFFFFF).setTemperature(48.0F);

	public ListMining() {
	}

	private static void setOreAndItemGem(String tag, int clr) {
		new OreFake("gem_" + tag + "_large").setName("gem_" + tag + "_large").setType("Gem").setColor(clr).setTextureOre("gem_" + tag + "_large");
		new OreFake("gem_" + tag + "_medium_3").setName("gem_" + tag + "_medium_3").setType("Gem").setColor(clr).setTextureOre("gem_" + tag + "_medium_3");
		new OreFake("gem_" + tag + "_medium_2").setName("gem_" + tag + "_medium_2").setType("Gem").setColor(clr).setTextureOre("gem_" + tag + "_medium_2");
		new OreFake("gem_" + tag + "_medium").setName("gem_" + tag + "_medium").setType("Gem").setColor(clr).setTextureOre("gem_" + tag + "_medium");
		new OreFake("gem_" + tag + "_small").setName("gem_" + tag + "_small").setType("Gem").setColor(clr).setTextureOre("gem_" + tag + "_small");
		new ItemForMining("gem_" + tag + "_chipped").setName("gem_" + tag + "_chipped").setType("Gem").setColors(clr).setTextures("gem/gem_" + tag + "_chipped");
		new ItemForMining("gem_" + tag + "_flawed").setName("gem_" + tag + "_flawed").setType("Gem").setColors(clr).setTextures("gem/gem_" + tag + "_flawed");
		new ItemForMining("gem_" + tag + "_flawless").setName("gem_" + tag + "_flawless").setType("Gem").setColors(clr).setTextures("gem/gem_" + tag + "_flawless");
		new ItemForMining("gem_" + tag + "_exquisite").setName("gem_" + tag + "_exquisite").setType("Gem").setColors(clr).setTextures("gem/gem_" + tag + "_exquisite");
	}

}
