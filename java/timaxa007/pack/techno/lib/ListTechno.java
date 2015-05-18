package timaxa007.pack.techno.lib;

import timaxa007.module.fluids.util.Fluid;

public class ListTechno {
/*
	public static final Fluid.TypeFluid fuel = new Fluid.TypeFluid("fuel");

	public static final Fluid fluid_energy_electric = new Fluid("energy_electric").setName("energy_electric").setType(Fluid.TypeFluid.energy).setColor(0xFFFFFF).setTemperature(35.0F);
	public static final Fluid fluid_crystal_energy = new Fluid("crystal_energy").setName("crystal_energy").setType(Fluid.TypeFluid.molten).setColor(0xFFFFFF).setTemperature(28.0F);
	public static final Fluid fluid_molten_glass = new Fluid("molten_glass").setName("molten_glass").setType(Fluid.TypeFluid.molten).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluid fluid_oil_techno = new Fluid("oil_techno").setName("oil_techno").setType(Fluid.TypeFluid.oil).setColor(0x222222).setTemperature(18.0F);
	//Fuel
	public static final Fluid fluid_fuel_techno = new Fluid("fuel_techno").setName("fuel_techno").setType(fuel).setColor(0xCC8800).setTemperature(18.0F);
	public static final Fluid fluid_fuel_coal = new Fluid("fuel_coal").setName("fuel_coal").setType(fuel).setColor(0x553300).setTemperature(18.0F);
	public static final Fluid fluid_fuel_charcoal = new Fluid("fuel_charcoal").setName("fuel_charcoal").setType(fuel).setColor(0x443300).setTemperature(18.0F);
	public static final Fluid fluid_fuel_organic = new Fluid("fuel_organic").setName("fuel_organic").setType(fuel).setColor(0xCCCC00).setTemperature(18.0F);
	public static final Fluid fluid_fuel_bio = new Fluid("fuel_bio").setName("fuel_bio").setType(fuel).setColor(0x88CC00).setTemperature(18.0F);
	public static final Fluid fluid_fuel_bio_distillation = new Fluid("fuel_bio_distillation").setName("fuel_bio_distillation").setType(fuel).setColor(0xCC9900).setTemperature(18.0F);
	//wood sawdust
	public static final Fluid fluid_dust_wood_mix = new Fluid("dust_wood_mix").setName("dust_wood_mix").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_oak = new Fluid("dust_wood_oak").setName("dust_wood_oak").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_birch = new Fluid("dust_wood_birch").setName("dust_wood_birch").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_jungle = new Fluid("dust_wood_jungle").setName("dust_wood_jungle").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_spruce = new Fluid("dust_wood_spruce").setName("dust_wood_spruce").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_coffee = new Fluid("dust_wood_coffee").setName("dust_wood_coffee").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_tea = new Fluid("dust_wood_tea").setName("dust_wood_tea").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_lemon = new Fluid("dust_wood_lemon").setName("dust_wood_lemon").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_cacao = new Fluid("dust_wood_cacao").setName("dust_wood_cacao ").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_apple = new Fluid("dust_wood_apple").setName("dust_wood_apple").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_orange = new Fluid("dust_wood_orange").setName("dust_wood_orange").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_lime = new Fluid("dust_wood_lime").setName("dust_wood_lime").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_pear = new Fluid("dust_wood_pear").setName("dust_wood_pear").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_peach = new Fluid("dust_wood_peach").setName("dust_wood_peach").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_plum = new Fluid("dust_wood_plum").setName("dust_wood_plum").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_cherry = new Fluid("dust_wood_cherry").setName("dust_wood_cherry").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_walnut = new Fluid("dust_wood_walnut").setName("dust_wood_walnut").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_nutmeg = new Fluid("dust_wood_nutmeg").setName("dust_wood_nutmeg").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_olive = new Fluid("dust_wood_olive").setName("dust_wood_olive").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_avocado = new Fluid("dust_wood_avocado").setName("dust_wood_avocado").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_mango = new Fluid("dust_wood_mango").setName("dust_wood_mango").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_papaya = new Fluid("dust_wood_papaya").setName("dust_wood_papaya").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_pomegranate = new Fluid("dust_wood_pomegranate").setName("dust_wood_pomegranate").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_vanilla = new Fluid("dust_wood_vanilla").setName("dust_wood_vanilla").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_rowan = new Fluid("dust_wood_rowan").setName("dust_wood_rowan").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_pine = new Fluid("dust_wood_pine").setName("dust_wood_pine").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_willow = new Fluid("dust_wood_willow").setName("dust_wood_willow").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_maple = new Fluid("dust_wood_maple").setName("dust_wood_maple").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_lipa = new Fluid("dust_wood_lipa").setName("dust_wood_lipa").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_elm = new Fluid("dust_wood_elm").setName("dust_wood_elm").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_larch = new Fluid("dust_wood_larch").setName("dust_wood_larch").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_aspen = new Fluid("dust_wood_aspen").setName("dust_wood_aspen").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_fir = new Fluid("dust_wood_fir").setName("dust_wood_fir").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_poplar = new Fluid("dust_wood_poplar").setName("dust_wood_poplar").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_ash = new Fluid("dust_wood_ash").setName("dust_wood_ash").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_cedar = new Fluid("dust_wood_cedar").setName("dust_wood_cedar").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_beech = new Fluid("dust_wood_beech").setName("dust_wood_beech").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_chestnut = new Fluid("dust_wood_chestnut").setName("dust_wood_chestnut").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_coconut = new Fluid("dust_wood_coconut").setName("dust_wood_coconut").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_banana = new Fluid("dust_wood_banana").setName("dust_wood_banana").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_black = new Fluid("dust_wood_colored_black").setName("dust_wood_colored_black").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_blue = new Fluid("dust_wood_colored_blue").setName("dust_wood_colored_blue").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_brown = new Fluid("dust_wood_colored_brown").setName("dust_wood_colored_brown").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_cyan = new Fluid("dust_wood_colored_cyan").setName("dust_wood_colored_cyan").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_gray = new Fluid("dust_wood_colored_gray").setName("dust_wood_colored_gray").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_green = new Fluid("dust_wood_colored_green").setName("dust_wood_colored_green").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_light_blue = new Fluid("dust_wood_colored_light_blue").setName("dust_wood_colored_light_blue").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_light_gray = new Fluid("dust_wood_colored_light_gray").setName("dust_wood_colored_light_gray").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_light_green = new Fluid("dust_wood_colored_light_green").setName("dust_wood_colored_light_green").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_magenta = new Fluid("dust_wood_colored_magenta").setName("dust_wood_colored_magenta").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_orange = new Fluid("dust_wood_colored_orange").setName("dust_wood_colored_orange").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_pink = new Fluid("dust_wood_colored_pink").setName("dust_wood_colored_pink").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_purple = new Fluid("dust_wood_colored_purple").setName("dust_wood_colored_purple").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_red = new Fluid("dust_wood_colored_red").setName("dust_wood_colored_red").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_white = new Fluid("dust_wood_colored_white").setName("dust_wood_colored_white").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	public static final Fluid fluid_dust_wood_colored_yellow = new Fluid("dust_wood_colored_yellow").setName("dust_wood_colored_yellow").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	//public static final Fluid fluid_dust_wood_ = new Fluid("dust_wood_").setName("dust_wood_").setType(Fluid.TypeFluid.dust).setColor(0xC17100).setTemperature(10.0F);
	//metal filings
	public static final Fluid fluid_dust_metal_iron = new Fluid("dust_metal_iron").setName("dust_metal_iron").setType(Fluid.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(10.0F);
	public static final Fluid fluid_dust_metal_gold = new Fluid("dust_metal_gold").setName("dust_metal_gold").setType(Fluid.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(10.0F);
	//public static final Fluid fluid_dust_metal_ = new Fluid("dust_metal_").setName("dust_metal_").setType(Fluid.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(10.0F);
*/
}
