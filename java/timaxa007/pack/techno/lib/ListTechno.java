package timaxa007.pack.techno.lib;

import timaxa007.module.substance.util.Substance;
import timaxa007.module.substance.util.SubstanceType;
import timaxa007.module.substance.util.ListSubstanceType;
import timaxa007.module.substance.util.RegistrySubstance;

public class ListTechno {

	public static SubstanceType
	fuel
	;

	public static Substance
	fluid_energy_electric,
	fluid_crystal_energy,
	fluid_molten_glass,
	fluid_oil_techno,
	fluid_fuel_techno,
	fluid_fuel_coal,
	fluid_fuel_charcoal,
	fluid_fuel_organic,
	fluid_fuel_bio,
	fluid_fuel_bio_distillation,
	fluid_dust_metal_iron,
	fluid_dust_metal_gold
	;

	public static SubstanceType[] list_fluid_type;
	public static Substance[] list_fluid;

	public static void init() {

		fuel = new SubstanceType("fuel");

		fluid_energy_electric = new Substance("energy_electric").setType(ListSubstanceType.energy).setColor(0xFFFFFF).setTemperature(35.0F);
		fluid_crystal_energy = new Substance("crystal_energy").setType(ListSubstanceType.molten).setColor(0xFFFFFF).setTemperature(28.0F);
		fluid_molten_glass = new Substance("molten_glass").setType(ListSubstanceType.molten).setColor(0xFFFFFF).setTemperature(16.0F);
		fluid_oil_techno = new Substance("oil_techno").setType(ListSubstanceType.oil).setColor(0x222222).setTemperature(18.0F);
		//Fuel
		fluid_fuel_techno = new Substance("fuel_techno").setType(fuel).setColor(0xCC8800).setTemperature(18.0F);
		fluid_fuel_coal = new Substance("fuel_coal").setType(fuel).setColor(0x553300).setTemperature(18.0F);
		fluid_fuel_charcoal = new Substance("fuel_charcoal").setType(fuel).setColor(0x443300).setTemperature(18.0F);
		fluid_fuel_organic = new Substance("fuel_organic").setType(fuel).setColor(0xCCCC00).setTemperature(18.0F);
		fluid_fuel_bio = new Substance("fuel_bio").setColor(0x88CC00).setTemperature(18.0F);
		fluid_fuel_bio_distillation = new Substance("fuel_bio_distillation").setType(fuel).setColor(0xCC9900).setTemperature(18.0F);
		//wood sawdust
		//public static final Substance fluid_dust_wood_ = new Substance("dust_wood_").setType(ListSubstanceType.dust).setColor(0xC17100).setTemperature(10.0F);
		//metal filings
		fluid_dust_metal_iron = new Substance("dust_metal_iron").setType(ListSubstanceType.dust).setColor(0xFFFFFF).setTemperature(10.0F);
		fluid_dust_metal_gold = new Substance("dust_metal_gold").setType(ListSubstanceType.dust).setColor(0xFFFFFF).setTemperature(10.0F);
		//public static final Substance fluid_dust_metal_ = new Substance("dust_metal_").setName("dust_metal_").setType(ListSubstanceType.dust).setColor(0xFFFFFF).setTemperature(10.0F);

		list_fluid_type = new SubstanceType[] {
				fuel
		};

		list_fluid = new Substance[] {
				fluid_energy_electric,
				fluid_crystal_energy,
				fluid_molten_glass,
				fluid_oil_techno,
				fluid_fuel_techno,
				fluid_fuel_coal,
				fluid_fuel_charcoal,
				fluid_fuel_organic,
				fluid_fuel_bio,
				fluid_fuel_bio_distillation,
				fluid_dust_metal_iron,
				fluid_dust_metal_gold
		};

		RegistrySubstance.registerSubstanceType(list_fluid_type);
		RegistrySubstance.registerSubstance(list_fluid);

	}

}
