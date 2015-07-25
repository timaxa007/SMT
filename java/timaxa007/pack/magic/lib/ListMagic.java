package timaxa007.pack.magic.lib;

import timaxa007.module.substance.util.Substance;

public class ListMagic {
/*
	public static final Substance fluid_molten_blaze = new Substance("molten_blaze").setName("molten_blaze").setType(Substance.TypeSubstance.molten).setColor(0xFF7F20).setTemperature(32.0F);
	public static final Substance fluid_molten_ender = new Substance("molten_ender").setName("molten_ender").setType(Substance.TypeSubstance.molten).setColor(0x32007F).setTemperature(32.0F);
	public static final Substance fluid_xp = new Substance("xp").setName("xp").setType(Substance.TypeSubstance.liquid).setColor(0x00D815).setTemperature(0.0F);

	public static final Substance fluid_soul_mix = new Substance("soul_mix").setName("soul_mix").setType(Substance.TypeSubstance.gas).setColor(0xBF9CA4).setTemperature(30.0F);
	public static final Substance fluid_blood_mix = new Substance("blood_mix").setName("blood_mix").setType(Substance.TypeSubstance.liquid).setColor(0xBF0000).setTemperature(30.0F);
	public static final Substance fluid_raw_flesh_mix = new Substance("raw_flesh_mix").setName("raw_flesh_mix").setType(Substance.TypeSubstance.liquid).setColor(0xBC3F2F).setTemperature(30.0F);
	public static final Substance fluid_dust_bone_mix = new Substance("dust_bone_mix").setName("bone_mix").setType(Substance.TypeSubstance.dust).setColor(0xDEE5E5).setTemperature(30.0F);

	public static final Substance fluid_energy_health = new Substance("energy_health").setName("energy_health").setType(Substance.TypeSubstance.energy).setColor(0xFFFFFF).setTemperature(35.0F);
	public static final Substance fluid_energy_mana = new Substance("energy_mana").setName("energy_mana").setType(Substance.TypeSubstance.energy).setColor(0xFFFFFF).setTemperature(35.0F);
	public static final Substance fluid_energy_magic = new Substance("energy_magic").setName("energy_magic").setType(Substance.TypeSubstance.energy).setColor(0xFFFFFF).setTemperature(35.0F);
	public static final Substance fluid_energy_blaze = new Substance("energy_blaze").setName("energy_blaze").setType(Substance.TypeSubstance.energy).setColor(0xFF7F20).setTemperature(35.0F);
	public static final Substance fluid_energy_ender = new Substance("energy_ender").setName("energy_ender").setType(Substance.TypeSubstance.energy).setColor(0x32007F).setTemperature(35.0F);

	public static final Substance fluid_molten_crystal_energy_air = new Substance("molten_crystal_energy_air").setName("molten_crystal_energy_air").setType(Substance.TypeSubstance.molten).setColor(0x7FFFFF).setTemperature(28.0F);
	public static final Substance fluid_molten_crystal_energy_earth = new Substance("molten_crystal_energy_earth").setName("molten_crystal_energy_earth").setType(Substance.TypeSubstance.molten).setColor(0xBF752F).setTemperature(28.0F);
	public static final Substance fluid_molten_crystal_energy_fire = new Substance("molten_crystal_energy_fire").setName("molten_crystal_energy_fire").setType(Substance.TypeSubstance.molten).setColor(0xFF2000).setTemperature(28.0F);
	public static final Substance fluid_molten_crystal_energy_water = new Substance("molten_crystal_energy_water").setName("molten_crystal_energy_water").setType(Substance.TypeSubstance.molten).setColor(0x003FFF).setTemperature(28.0F);

	public static final Substance fluid_energy_air = new Substance("energy_air").setName("energy_air").setType(Substance.TypeSubstance.energy).setColor(0x7FFFFF).setTemperature(35.0F);
	public static final Substance fluid_energy_earth = new Substance("energy_earth").setName("energy_earth").setType(Substance.TypeSubstance.energy).setColor(0xBF752F).setTemperature(35.0F);
	public static final Substance fluid_energy_fire = new Substance("energy_fire").setName("energy_fire").setType(Substance.TypeSubstance.energy).setColor(0xFF2000).setTemperature(35.0F);
	public static final Substance fluid_energy_water = new Substance("energy_water").setName("energy_water").setType(Substance.TypeSubstance.energy).setColor(0x003FFF).setTemperature(35.0F);

	public static final Substance fluid_potion_awkward = new Substance("potion_awkward").setName("potion_awkward").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_thick = new Substance("potion_thick").setName("potion_thick").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_mundane = new Substance("potion_mundane").setName("potion_mundane").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);

	public static final Substance fluid_potion_speed = new Substance("potion_speed").setName("potion_speed").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_slowness = new Substance("potion_slowness").setName("potion_slowness").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_haste = new Substance("potion_haste").setName("potion_haste").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_mining_fatigue = new Substance("potion_mining_fatigue").setName("potion_mining_fatigue").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_strength = new Substance("potion_strength").setName("potion_strength").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_instant_health = new Substance("potion_instant_health").setName("potion_instant_health").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_instant_damage = new Substance("potion_instant_damage").setName("potion_instant_damage").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_jump_boost = new Substance("potion_jump_boost").setName("potion_jump_boost").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_nausea = new Substance("potion_nausea").setName("potion_nausea").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_regeneration = new Substance("potion_regeneration").setName("potion_regeneration").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_resistance = new Substance("potion_resistance").setName("potion_resistance").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_fire_resistance = new Substance("potion_fire_resistance").setName("potion_fire_resistance").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_water_breathing = new Substance("potion_water_breathing").setName("potion_water_breathing").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_invisibility = new Substance("potion_invisibility").setName("potion_invisibility").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_blindness = new Substance("potion_blindness").setName("potion_blindness").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_night_vision = new Substance("potion_night_vision").setName("potion_night_vision").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_hunger = new Substance("potion_hunger").setName("potion_hunger").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_weakness = new Substance("potion_weakness").setName("potion_weakness").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_poison = new Substance("potion_poison").setName("potion_poison").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_wither = new Substance("potion_wither").setName("potion_wither").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_health_boost = new Substance("potion_health_boost").setName("potion_health_boost").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_absorption = new Substance("potion_absorption").setName("potion_absorption").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_saturation = new Substance("potion_saturation").setName("potion_saturation").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);

	//public static final Substance fluid_potion_regeneration = new Substance("potion_regeneration").setName("potion_regeneration").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_swiftness = new Substance("potion_swiftness").setName("potion_swiftness").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Substance fluid_potion_fire_resistance = new Substance("potion_fire_resistance").setName("potion_fire_resistance").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_healing = new Substance("potion_healing").setName("potion_healing").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Substance fluid_potion_night_vision = new Substance("potion_night_vision").setName("potion_night_vision").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Substance fluid_potion_strength = new Substance("potion_strength").setName("potion_strength").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_leaping = new Substance("potion_leaping").setName("potion_leaping").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Substance fluid_potion_water_breathing = new Substance("potion_water_breathing").setName("potion_water_breathing").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Substance fluid_potion_invisibility = new Substance("potion_invisibility").setName("potion_invisibility").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Substance fluid_potion_poison = new Substance("potion_poison").setName("potion_poison").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Substance fluid_potion_weakness = new Substance("potion_weakness").setName("potion_weakness").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Substance fluid_potion_slowness = new Substance("potion_slowness").setName("potion_slowness").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_harming = new Substance("potion_harming").setName("potion_harming").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);

	public static final Substance fluid_potion_uninteresting = new Substance("potion_uninteresting").setName("potion_uninteresting").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_bland = new Substance("potion_bland").setName("potion_bland").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_clear = new Substance("potion_clear").setName("potion_clear").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_milky = new Substance("potion_milky").setName("potion_milky").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_diffuse = new Substance("potion_diffuse").setName("potion_diffuse").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_artless = new Substance("potion_artless").setName("potion_artless").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_thin = new Substance("potion_thin").setName("potion_thin").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_flat = new Substance("potion_flat").setName("potion_flat").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_bulky = new Substance("potion_bulky").setName("potion_bulky").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_bungling = new Substance("potion_bungling").setName("potion_bungling").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_buttered = new Substance("potion_buttered").setName("potion_buttered").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_smooth = new Substance("potion_smooth").setName("potion_smooth").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_suave = new Substance("potion_suave").setName("potion_suave").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_debonair = new Substance("potion_debonair").setName("potion_debonair").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_elegant = new Substance("potion_elegant").setName("potion_elegant").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_fancy = new Substance("potion_fancy").setName("potion_fancy").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_charming = new Substance("potion_charming").setName("potion_charming").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_dashing = new Substance("potion_dashing").setName("potion_dashing").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_refined = new Substance("potion_refined").setName("potion_refined").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_cordial = new Substance("potion_cordial").setName("potion_cordial").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_sparkling = new Substance("potion_sparkling").setName("potion_sparkling").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_potent = new Substance("potion_potent").setName("potion_potent").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_foul = new Substance("potion_foul").setName("potion_foul").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_odorless = new Substance("potion_odorless").setName("potion_odorless").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_rank = new Substance("potion_rank").setName("potion_rank").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_harsh = new Substance("potion_harsh").setName("potion_harsh").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_acrid = new Substance("potion_acrid").setName("potion_acrid").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_gross = new Substance("potion_gross").setName("potion_gross").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_stinky = new Substance("potion_stinky").setName("potion_stinky").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Substance fluid_potion_burpy = new Substance("potion_burpy").setName("potion_burpy").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Substance fluid_xp = new Substance("xp").setName("xp").setType(Substance.TypeSubstance.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
*/
}
