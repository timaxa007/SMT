package mods.timaxa007.pack.magic.list;

import mods.timaxa007.lib.FluidFake;
import net.minecraft.client.settings.GameSettings;

public class ListMagic {

	public static FluidFake fluid_molten_blaze = new FluidFake("molten_blaze").setName("molten_blaze").setType("Molten").setColor(0xFF7F20).setTemperatures(32.0F, 0.0F, 180.0F);
	public static FluidFake fluid_molten_ender = new FluidFake("molten_ender").setName("molten_ender").setType("Molten").setColor(0x32007F).setTemperatures(32.0F, 0.0F, 180.0F);
	public static FluidFake fluid_xp = new FluidFake("xp").setName("xp").setType("Liquid").setColor(0x00D815).setTemperatures(0.0F, -100.0F, 100.0F);

	public static FluidFake fluid_soul_mix = new FluidFake("soul_mix").setName("soul_mix").setType("Gas").setColor(0xBF9CA4).setTemperatures(30.0F, -20.0F, 80.0F);
	public static FluidFake fluid_blood_mix = new FluidFake("blood_mix").setName("blood_mix").setType("Liquid").setColor(0xBF0000).setTemperatures(30.0F, -20.0F, 80.0F);
	public static FluidFake fluid_raw_flesh_mix = new FluidFake("raw_flesh_mix").setName("raw_flesh_mix").setType("Liquid").setColor(0xBC3F2F).setTemperatures(30.0F, -20.0F, 80.0F);
	public static FluidFake fluid_dust_bone_mix = new FluidFake("dust_bone_mix").setName("bone_mix").setType("Dust").setColor(0xDEE5E5).setTemperatures(30.0F, -20.0F, 80.0F);

	public static FluidFake fluid_energy_health = new FluidFake("energy_health").setName("energy_health").setType("Energy").setColor(0xFFFFFF).setTemperatures(35.0F, 0.0F, 80.0F);
	public static FluidFake fluid_energy_mana = new FluidFake("energy_mana").setName("energy_mana").setType("Energy").setColor(0xFFFFFF).setTemperatures(35.0F, 0.0F, 80.0F);
	public static FluidFake fluid_energy_magic = new FluidFake("energy_magic").setName("energy_magic").setType("Energy").setColor(0xFFFFFF).setTemperatures(35.0F, 0.0F, 80.0F);
	public static FluidFake fluid_energy_blaze = new FluidFake("energy_blaze").setName("energy_blaze").setType("Energy").setColor(0xFF7F20).setTemperatures(35.0F, 0.0F, 80.0F);
	public static FluidFake fluid_energy_ender = new FluidFake("energy_ender").setName("energy_ender").setType("Energy").setColor(0x32007F).setTemperatures(35.0F, 0.0F, 80.0F);

	public static FluidFake fluid_molten_crystal_energy_air = new FluidFake("molten_crystal_energy_air").setName("molten_crystal_energy_air").setType("Molten").setColor(0x7FFFFF).setTemperatures(28.0F, 0.0F, 120.0F);
	public static FluidFake fluid_molten_crystal_energy_earth = new FluidFake("molten_crystal_energy_earth").setName("molten_crystal_energy_earth").setType("Molten").setColor(0xBF752F).setTemperatures(28.0F, 0.0F, 120.0F);
	public static FluidFake fluid_molten_crystal_energy_fire = new FluidFake("molten_crystal_energy_fire").setName("molten_crystal_energy_fire").setType("Molten").setColor(0xFF2000).setTemperatures(28.0F, 0.0F, 120.0F);
	public static FluidFake fluid_molten_crystal_energy_water = new FluidFake("molten_crystal_energy_water").setName("molten_crystal_energy_water").setType("Molten").setColor(0x003FFF).setTemperatures(28.0F, 0.0F, 120.0F);

	public static FluidFake fluid_energy_air = new FluidFake("energy_air").setName("energy_air").setType("Energy").setColor(0x7FFFFF).setTemperatures(35.0F, 0.0F, 80.0F);
	public static FluidFake fluid_energy_earth = new FluidFake("energy_earth").setName("energy_earth").setType("Energy").setColor(0xBF752F).setTemperatures(35.0F, 0.0F, 80.0F);
	public static FluidFake fluid_energy_fire = new FluidFake("energy_fire").setName("energy_fire").setType("Energy").setColor(0xFF2000).setTemperatures(35.0F, 0.0F, 80.0F);
	public static FluidFake fluid_energy_water = new FluidFake("energy_water").setName("energy_water").setType("Energy").setColor(0x003FFF).setTemperatures(35.0F, 0.0F, 80.0F);

	public static FluidFake fluid_potion_awkward = new FluidFake("potion_awkward").setName("potion_awkward").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_thick = new FluidFake("potion_thick").setName("potion_thick").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_mundane = new FluidFake("potion_mundane").setName("potion_mundane").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);

	public static FluidFake fluid_potion_speed = new FluidFake("potion_speed").setName("potion_speed").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_slowness = new FluidFake("potion_slowness").setName("potion_slowness").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_haste = new FluidFake("potion_haste").setName("potion_haste").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_mining_fatigue = new FluidFake("potion_mining_fatigue").setName("potion_mining_fatigue").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_strength = new FluidFake("potion_strength").setName("potion_strength").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_instant_health = new FluidFake("potion_instant_health").setName("potion_instant_health").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_instant_damage = new FluidFake("potion_instant_damage").setName("potion_instant_damage").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_jump_boost = new FluidFake("potion_jump_boost").setName("potion_jump_boost").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_nausea = new FluidFake("potion_nausea").setName("potion_nausea").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_regeneration = new FluidFake("potion_regeneration").setName("potion_regeneration").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_resistance = new FluidFake("potion_resistance").setName("potion_resistance").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_fire_resistance = new FluidFake("potion_fire_resistance").setName("potion_fire_resistance").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_water_breathing = new FluidFake("potion_water_breathing").setName("potion_water_breathing").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_invisibility = new FluidFake("potion_invisibility").setName("potion_invisibility").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_blindness = new FluidFake("potion_blindness").setName("potion_blindness").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_night_vision = new FluidFake("potion_night_vision").setName("potion_night_vision").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_hunger = new FluidFake("potion_hunger").setName("potion_hunger").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_weakness = new FluidFake("potion_weakness").setName("potion_weakness").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_poison = new FluidFake("potion_poison").setName("potion_poison").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_wither = new FluidFake("potion_wither").setName("potion_wither").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_health_boost = new FluidFake("potion_health_boost").setName("potion_health_boost").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_absorption = new FluidFake("potion_absorption").setName("potion_absorption").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_saturation = new FluidFake("potion_saturation").setName("potion_saturation").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);

	//public static FluidFake fluid_potion_regeneration = new FluidFake("potion_regeneration").setName("potion_regeneration").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_swiftness = new FluidFake("potion_swiftness").setName("potion_swiftness").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	//public static FluidFake fluid_potion_fire_resistance = new FluidFake("potion_fire_resistance").setName("potion_fire_resistance").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_healing = new FluidFake("potion_healing").setName("potion_healing").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	//public static FluidFake fluid_potion_night_vision = new FluidFake("potion_night_vision").setName("potion_night_vision").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	//public static FluidFake fluid_potion_strength = new FluidFake("potion_strength").setName("potion_strength").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_leaping = new FluidFake("potion_leaping").setName("potion_leaping").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	//public static FluidFake fluid_potion_water_breathing = new FluidFake("potion_water_breathing").setName("potion_water_breathing").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	//public static FluidFake fluid_potion_invisibility = new FluidFake("potion_invisibility").setName("potion_invisibility").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	//public static FluidFake fluid_potion_poison = new FluidFake("potion_poison").setName("potion_poison").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	//public static FluidFake fluid_potion_weakness = new FluidFake("potion_weakness").setName("potion_weakness").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	//public static FluidFake fluid_potion_slowness = new FluidFake("potion_slowness").setName("potion_slowness").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_harming = new FluidFake("potion_harming").setName("potion_harming").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);

	public static FluidFake fluid_potion_uninteresting = new FluidFake("potion_uninteresting").setName("potion_uninteresting").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_bland = new FluidFake("potion_bland").setName("potion_bland").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_clear = new FluidFake("potion_clear").setName("potion_clear").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_milky = new FluidFake("potion_milky").setName("potion_milky").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_diffuse = new FluidFake("potion_diffuse").setName("potion_diffuse").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_artless = new FluidFake("potion_artless").setName("potion_artless").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_thin = new FluidFake("potion_thin").setName("potion_thin").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_flat = new FluidFake("potion_flat").setName("potion_flat").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_bulky = new FluidFake("potion_bulky").setName("potion_bulky").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_bungling = new FluidFake("potion_bungling").setName("potion_bungling").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_buttered = new FluidFake("potion_buttered").setName("potion_buttered").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_smooth = new FluidFake("potion_smooth").setName("potion_smooth").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_suave = new FluidFake("potion_suave").setName("potion_suave").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_debonair = new FluidFake("potion_debonair").setName("potion_debonair").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_elegant = new FluidFake("potion_elegant").setName("potion_elegant").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_fancy = new FluidFake("potion_fancy").setName("potion_fancy").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_charming = new FluidFake("potion_charming").setName("potion_charming").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_dashing = new FluidFake("potion_dashing").setName("potion_dashing").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_refined = new FluidFake("potion_refined").setName("potion_refined").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_cordial = new FluidFake("potion_cordial").setName("potion_cordial").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_sparkling = new FluidFake("potion_sparkling").setName("potion_sparkling").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_potent = new FluidFake("potion_potent").setName("potion_potent").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_foul = new FluidFake("potion_foul").setName("potion_foul").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_odorless = new FluidFake("potion_odorless").setName("potion_odorless").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_rank = new FluidFake("potion_rank").setName("potion_rank").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_harsh = new FluidFake("potion_harsh").setName("potion_harsh").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_acrid = new FluidFake("potion_acrid").setName("potion_acrid").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_gross = new FluidFake("potion_gross").setName("potion_gross").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_stinky = new FluidFake("potion_stinky").setName("potion_stinky").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	public static FluidFake fluid_potion_burpy = new FluidFake("potion_burpy").setName("potion_burpy").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);
	//public static FluidFake fluid_xp = new FluidFake("xp").setName("xp").setType("Liquid").setColor(0x7FC9FF).setTemperatures(10.0F, -60.0F, 60.0F);

}
