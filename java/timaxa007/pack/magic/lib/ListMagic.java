package timaxa007.pack.magic.lib;

import timaxa007.module.fluids.util.Fluid;

public class ListMagic {
/*
	public static final Fluid fluid_molten_blaze = new Fluid("molten_blaze").setName("molten_blaze").setType(Fluid.TypeFluid.molten).setColor(0xFF7F20).setTemperature(32.0F);
	public static final Fluid fluid_molten_ender = new Fluid("molten_ender").setName("molten_ender").setType(Fluid.TypeFluid.molten).setColor(0x32007F).setTemperature(32.0F);
	public static final Fluid fluid_xp = new Fluid("xp").setName("xp").setType(Fluid.TypeFluid.liquid).setColor(0x00D815).setTemperature(0.0F);

	public static final Fluid fluid_soul_mix = new Fluid("soul_mix").setName("soul_mix").setType(Fluid.TypeFluid.gas).setColor(0xBF9CA4).setTemperature(30.0F);
	public static final Fluid fluid_blood_mix = new Fluid("blood_mix").setName("blood_mix").setType(Fluid.TypeFluid.liquid).setColor(0xBF0000).setTemperature(30.0F);
	public static final Fluid fluid_raw_flesh_mix = new Fluid("raw_flesh_mix").setName("raw_flesh_mix").setType(Fluid.TypeFluid.liquid).setColor(0xBC3F2F).setTemperature(30.0F);
	public static final Fluid fluid_dust_bone_mix = new Fluid("dust_bone_mix").setName("bone_mix").setType(Fluid.TypeFluid.dust).setColor(0xDEE5E5).setTemperature(30.0F);

	public static final Fluid fluid_energy_health = new Fluid("energy_health").setName("energy_health").setType(Fluid.TypeFluid.energy).setColor(0xFFFFFF).setTemperature(35.0F);
	public static final Fluid fluid_energy_mana = new Fluid("energy_mana").setName("energy_mana").setType(Fluid.TypeFluid.energy).setColor(0xFFFFFF).setTemperature(35.0F);
	public static final Fluid fluid_energy_magic = new Fluid("energy_magic").setName("energy_magic").setType(Fluid.TypeFluid.energy).setColor(0xFFFFFF).setTemperature(35.0F);
	public static final Fluid fluid_energy_blaze = new Fluid("energy_blaze").setName("energy_blaze").setType(Fluid.TypeFluid.energy).setColor(0xFF7F20).setTemperature(35.0F);
	public static final Fluid fluid_energy_ender = new Fluid("energy_ender").setName("energy_ender").setType(Fluid.TypeFluid.energy).setColor(0x32007F).setTemperature(35.0F);

	public static final Fluid fluid_molten_crystal_energy_air = new Fluid("molten_crystal_energy_air").setName("molten_crystal_energy_air").setType(Fluid.TypeFluid.molten).setColor(0x7FFFFF).setTemperature(28.0F);
	public static final Fluid fluid_molten_crystal_energy_earth = new Fluid("molten_crystal_energy_earth").setName("molten_crystal_energy_earth").setType(Fluid.TypeFluid.molten).setColor(0xBF752F).setTemperature(28.0F);
	public static final Fluid fluid_molten_crystal_energy_fire = new Fluid("molten_crystal_energy_fire").setName("molten_crystal_energy_fire").setType(Fluid.TypeFluid.molten).setColor(0xFF2000).setTemperature(28.0F);
	public static final Fluid fluid_molten_crystal_energy_water = new Fluid("molten_crystal_energy_water").setName("molten_crystal_energy_water").setType(Fluid.TypeFluid.molten).setColor(0x003FFF).setTemperature(28.0F);

	public static final Fluid fluid_energy_air = new Fluid("energy_air").setName("energy_air").setType(Fluid.TypeFluid.energy).setColor(0x7FFFFF).setTemperature(35.0F);
	public static final Fluid fluid_energy_earth = new Fluid("energy_earth").setName("energy_earth").setType(Fluid.TypeFluid.energy).setColor(0xBF752F).setTemperature(35.0F);
	public static final Fluid fluid_energy_fire = new Fluid("energy_fire").setName("energy_fire").setType(Fluid.TypeFluid.energy).setColor(0xFF2000).setTemperature(35.0F);
	public static final Fluid fluid_energy_water = new Fluid("energy_water").setName("energy_water").setType(Fluid.TypeFluid.energy).setColor(0x003FFF).setTemperature(35.0F);

	public static final Fluid fluid_potion_awkward = new Fluid("potion_awkward").setName("potion_awkward").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_thick = new Fluid("potion_thick").setName("potion_thick").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_mundane = new Fluid("potion_mundane").setName("potion_mundane").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);

	public static final Fluid fluid_potion_speed = new Fluid("potion_speed").setName("potion_speed").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_slowness = new Fluid("potion_slowness").setName("potion_slowness").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_haste = new Fluid("potion_haste").setName("potion_haste").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_mining_fatigue = new Fluid("potion_mining_fatigue").setName("potion_mining_fatigue").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_strength = new Fluid("potion_strength").setName("potion_strength").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_instant_health = new Fluid("potion_instant_health").setName("potion_instant_health").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_instant_damage = new Fluid("potion_instant_damage").setName("potion_instant_damage").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_jump_boost = new Fluid("potion_jump_boost").setName("potion_jump_boost").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_nausea = new Fluid("potion_nausea").setName("potion_nausea").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_regeneration = new Fluid("potion_regeneration").setName("potion_regeneration").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_resistance = new Fluid("potion_resistance").setName("potion_resistance").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_fire_resistance = new Fluid("potion_fire_resistance").setName("potion_fire_resistance").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_water_breathing = new Fluid("potion_water_breathing").setName("potion_water_breathing").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_invisibility = new Fluid("potion_invisibility").setName("potion_invisibility").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_blindness = new Fluid("potion_blindness").setName("potion_blindness").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_night_vision = new Fluid("potion_night_vision").setName("potion_night_vision").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_hunger = new Fluid("potion_hunger").setName("potion_hunger").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_weakness = new Fluid("potion_weakness").setName("potion_weakness").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_poison = new Fluid("potion_poison").setName("potion_poison").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_wither = new Fluid("potion_wither").setName("potion_wither").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_health_boost = new Fluid("potion_health_boost").setName("potion_health_boost").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_absorption = new Fluid("potion_absorption").setName("potion_absorption").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_saturation = new Fluid("potion_saturation").setName("potion_saturation").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);

	//public static final Fluid fluid_potion_regeneration = new Fluid("potion_regeneration").setName("potion_regeneration").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_swiftness = new Fluid("potion_swiftness").setName("potion_swiftness").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Fluid fluid_potion_fire_resistance = new Fluid("potion_fire_resistance").setName("potion_fire_resistance").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_healing = new Fluid("potion_healing").setName("potion_healing").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Fluid fluid_potion_night_vision = new Fluid("potion_night_vision").setName("potion_night_vision").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Fluid fluid_potion_strength = new Fluid("potion_strength").setName("potion_strength").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_leaping = new Fluid("potion_leaping").setName("potion_leaping").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Fluid fluid_potion_water_breathing = new Fluid("potion_water_breathing").setName("potion_water_breathing").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Fluid fluid_potion_invisibility = new Fluid("potion_invisibility").setName("potion_invisibility").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Fluid fluid_potion_poison = new Fluid("potion_poison").setName("potion_poison").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Fluid fluid_potion_weakness = new Fluid("potion_weakness").setName("potion_weakness").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Fluid fluid_potion_slowness = new Fluid("potion_slowness").setName("potion_slowness").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_harming = new Fluid("potion_harming").setName("potion_harming").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);

	public static final Fluid fluid_potion_uninteresting = new Fluid("potion_uninteresting").setName("potion_uninteresting").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_bland = new Fluid("potion_bland").setName("potion_bland").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_clear = new Fluid("potion_clear").setName("potion_clear").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_milky = new Fluid("potion_milky").setName("potion_milky").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_diffuse = new Fluid("potion_diffuse").setName("potion_diffuse").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_artless = new Fluid("potion_artless").setName("potion_artless").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_thin = new Fluid("potion_thin").setName("potion_thin").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_flat = new Fluid("potion_flat").setName("potion_flat").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_bulky = new Fluid("potion_bulky").setName("potion_bulky").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_bungling = new Fluid("potion_bungling").setName("potion_bungling").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_buttered = new Fluid("potion_buttered").setName("potion_buttered").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_smooth = new Fluid("potion_smooth").setName("potion_smooth").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_suave = new Fluid("potion_suave").setName("potion_suave").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_debonair = new Fluid("potion_debonair").setName("potion_debonair").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_elegant = new Fluid("potion_elegant").setName("potion_elegant").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_fancy = new Fluid("potion_fancy").setName("potion_fancy").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_charming = new Fluid("potion_charming").setName("potion_charming").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_dashing = new Fluid("potion_dashing").setName("potion_dashing").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_refined = new Fluid("potion_refined").setName("potion_refined").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_cordial = new Fluid("potion_cordial").setName("potion_cordial").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_sparkling = new Fluid("potion_sparkling").setName("potion_sparkling").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_potent = new Fluid("potion_potent").setName("potion_potent").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_foul = new Fluid("potion_foul").setName("potion_foul").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_odorless = new Fluid("potion_odorless").setName("potion_odorless").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_rank = new Fluid("potion_rank").setName("potion_rank").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_harsh = new Fluid("potion_harsh").setName("potion_harsh").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_acrid = new Fluid("potion_acrid").setName("potion_acrid").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_gross = new Fluid("potion_gross").setName("potion_gross").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_stinky = new Fluid("potion_stinky").setName("potion_stinky").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	public static final Fluid fluid_potion_burpy = new Fluid("potion_burpy").setName("potion_burpy").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
	//public static final Fluid fluid_xp = new Fluid("xp").setName("xp").setType(Fluid.TypeFluid.liquid).setColor(0x7FC9FF).setTemperature(10.0F);
*/
}
