package timaxa007.module.effect.util;


public class ListEffects {

	public static Effects[] list;

	public static Effects
	effect_move_fast,
	effect_move_slow,

	effect_mining_fast,
	effect_mining_slow,

	effect_digging_fast,
	effect_digging_slow,

	effect_chopping_fast,
	effect_chopping_slow,

	effect_trimming_fast,
	effect_trimming_slow,

	effect_strength_high,
	effect_strength_low,

	effect_damage,
	effect_protection_damage,
	effect_resistance_damage,

	effect_poison,
	effect_protection_poison,
	effect_resistance_poison,

	effect_jump,
	effect_confusion,
	effect_regeneration,
	effect_resistance_fire,
	effect_water_breathing,
	effect_invisibility,

	effect_blindness,
	effect_night_vision,

	effect_hunger,
	effect_weakness,
	effect_wither,
	effect_potion_health_boost,
	effect_potion_absoption,
	effect_potion_health
	;

	public static void init() {

		effect_move_fast = new Effects("move_fast");
		effect_move_slow = new Effects("move_slow");

		effect_mining_fast = new Effects("mining_fast");
		effect_mining_slow = new Effects("mining_slow");

		effect_digging_fast = new Effects("digging_fast");
		effect_digging_slow = new Effects("digging_slow");

		effect_chopping_fast = new Effects("chopping_fast");
		effect_chopping_slow = new Effects("chopping_slow");

		effect_trimming_fast = new Effects("trimming_fast");
		effect_trimming_slow = new Effects("trimming_slow");

		effect_strength_high = new Effects("strength_high");
		effect_strength_low = new Effects("strength_low");

		effect_damage = new Effects("damage");
		effect_protection_damage = new Effects("protection_damage");
		effect_resistance_damage = new Effects("resistance_damage");

		effect_poison = new Effects("poison");
		effect_protection_poison = new Effects("protection_poison");
		effect_resistance_poison = new Effects("resistance_poison");

		effect_jump = new Effects("jump");
		effect_confusion = new Effects("confusion");
		effect_regeneration = new Effects("regeneration");
		effect_resistance_fire = new Effects("resistance_fire");
		effect_water_breathing = new Effects("water_breathing");
		effect_invisibility = new Effects("invisibility");

		effect_blindness = new Effects("blindness");
		effect_night_vision = new Effects("night_vision");

		effect_hunger = new Effects("hunger");
		effect_weakness = new Effects("weakness");
		effect_wither = new Effects("wither");
		effect_potion_health_boost = new Effects("potion_health_boost");
		effect_potion_absoption = new Effects("potion_absoption");
		effect_potion_health = new Effects("potion_health");

		list = new Effects[] {
				effect_move_fast,
				effect_move_slow,

				effect_mining_fast,
				effect_mining_slow,

				effect_digging_fast,
				effect_digging_slow,

				effect_chopping_fast,
				effect_chopping_slow,

				effect_trimming_fast,
				effect_trimming_slow,

				effect_strength_high,
				effect_strength_low,

				effect_damage,
				effect_protection_damage,
				effect_resistance_damage,

				effect_poison,
				effect_protection_poison,
				effect_resistance_poison,

				effect_jump,
				effect_confusion,
				effect_regeneration,
				effect_resistance_fire,
				effect_water_breathing,
				effect_invisibility,

				effect_blindness,
				effect_night_vision,

				effect_hunger,
				effect_weakness,
				effect_wither,
				effect_potion_health_boost,
				effect_potion_absoption,
				effect_potion_health
		};

		for (Effects effect : list) RegistryEffects.registerEffect(effect);
		
	}

}
