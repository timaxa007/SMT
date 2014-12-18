package mods.timaxa007.pack.mining.list;

import mods.timaxa007.lib.FluidFake;
import mods.timaxa007.pack.mining.lib.ItemForMining;
import mods.timaxa007.pack.mining.lib.OreFake;

public class ListMining {

	public static FluidFake fluid_air = new FluidFake("air").setName("air").setType("Gas").setColor(0xFFFFFF).setTemperatures(16.0F, -10.0F, 100.0F);
	public static FluidFake fluid_water = new FluidFake("water").setName("water").setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -10.0F, 100.0F);
	public static FluidFake fluid_gas_smoke = new FluidFake("gas_smoke").setName("smoke").setType("Gas").setColor(0xFFFFFF).setTemperatures(18.0F, -32.0F, 120.0F);
	public static FluidFake fluid_gas_steam = new FluidFake("gas_steam").setName("steam").setType("Gas").setColor(0xFFFFFF).setTemperatures(48.0F, 0.0F, 180.0F);

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
