package mods.timaxa007.pack.stock.list;

import mods.timaxa007.lib.FluidFake;
import mods.timaxa007.pack.stock.lib.FoodForBlock;
import mods.timaxa007.pack.stock.lib.FoodForItem;
import mods.timaxa007.pack.stock.lib.ItemForStock;

public class FillForList {

	public static final String[] cooked_name = new String[] {"raw", "boiled", "fried", "jerky", "dried", "stew"};

	public static final int[] cooked_color = new int[] {0xFFFFFF, 0xDEBEBE, 0xC43A21, 0x808080, 0xBFBFBF, 0xBF954C};

	public static void beListMeat(String tag, int hex) {
		tag = tag.toLowerCase();
		//--ItemForStock-----------------------------------------------------------------------------------------------------------------------------
		//new ItemForStock("skin_" + tag).setName("skin_" + tag).setType("Skin").setColors(0xFFFFFF).setTexture1("skin_cow");
		//new ItemForStock("leather_" + tag).setName("leather_" + tag).setType("Leather").setColors(0xEAA159).setTexture1("leather_big");
		//--FoodForItem------------------------------------------------------------------------------------------------------------------------------
		for (int i = 0; i < cooked_name.length; i++) {
			//small
			new FoodForItem("meat_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat");
			//big
			new FoodForItem("meat_" + tag + "_bone_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_bone_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_bone", "O");
			new FoodForItem("minced_meat_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("minced_meat_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_mince");
			new FoodForItem("meat_" + tag + "_cutlet_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_cutlet_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_cutlet");
			new FoodForItem("meat_" + tag + "_rissole_" + cooked_name[i]).setFoodStats(1, 0.1F).setSpeedOfEating(16).setName("meat_" + tag + "_rissole_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_rissole");
			new FoodForItem("meat_" + tag + "_meatballs_" + cooked_name[i]).setFoodStats(1, 0.1F).setName("meat_" + tag + "_meatballs_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_meatballs");
			new FoodForItem("meat_" + tag + "_cubes_" + cooked_name[i]).setFoodStats(1, 0.1F).setName("meat_" + tag + "_cubes_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_cubes");
			new FoodForItem("meat_" + tag + "_dumpling_" + cooked_name[i]).setFoodStats(1, 0.1F).setSpeedOfEating(16).setName("meat_" + tag + "_dumpling_" + cooked_name[i]).setColors(0xFFFFFF).setTextureFood("dumpling");
			new FoodForItem("frankfurter_meat_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setSpeedOfEating(16).setName("frankfurter_meat_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("frankfurter");
		}

		new FoodForItem("pie_meat_" + tag + "_raw_part").setFoodStats(2, 0.2F).setName("pie_meat_" + tag + "_raw_part").setColors(0xFFFFFF, hex).setTextureFood("pie_part", "O");
		new FoodForItem("pie_meat_" + tag + "_cooked_part").setFoodStats(2, 0.2F).setName("pie_meat_" + tag + "_cooked_part").setColors(0xBE7F7F, hex).setTextureFood("pie_part", "O");

		new FoodForItem("pizza_meat_" + tag + "_raw_part").setFoodStats(2, 0.2F).setName("pizza_meat_" + tag + "_raw_part").setColors(0xFFFFFF, hex).setTextureFood("pizza_part", "O");
		new FoodForItem("pizza_meat_" + tag + "_cooked_part").setFoodStats(2, 0.2F).setName("pizza_meat_" + tag + "_cooked_part").setColors(0xBE7F7F, hex).setTextureFood("pizza_part", "O");

		new FoodForItem("cookie_meat_" + tag + "_raw").setFoodStats(1, 0.2F).setName("cookie_meat_" + tag + "_raw").setColors(0xF1D598, hex).setTextureFood("cookie", "O");
		new FoodForItem("cookie_meat_" + tag + "_cooked").setFoodStats(2, 0.2F).setName("cookie_meat_" + tag + "_cooked").setColors(0xE79042, hex).setTextureFood("cookie", "O");

		new FoodForItem("cupcake_meat_" + tag + "_raw").setFoodStats(1, 0.2F).setName("cupcake_meat_" + tag + "_raw").setColors(0xD9D481, hex).setTextureFood("cupcake_02", "O");
		new FoodForItem("cupcake_meat_" + tag + "_fried").setFoodStats(2, 0.25F).setName("cupcake_meat_" + tag + "_fried").setColors(0xBB9949, hex).setTextureFood("cupcake_02", "O");

		new FoodForItem("pancake_meat_" + tag).setFoodStats(2, 0.2F).setName("pancake_meat_" + tag).setColors(0xBB9949, hex).setTextureFood("pancake", "O");

		new FoodForItem("doughnut_meat_" + tag + "_cooked").setFoodStats(3, 0.3F).setName("doughnut_meat_" + tag + "_cooked").setColors(0xBB9949, hex).setTextureFood("doughnut_cooked", "O");

		new FoodForItem("bun_meat_" + tag + "_raw").setFoodStats(2, 0.2F).setName("bun_meat_" + tag + "_raw").setColors(0xD9D481, hex).setTextureFood("bun_raw", "O");
		new FoodForItem("bun_meat_" + tag + "_cooked").setFoodStats(3, 0.3F).setName("bun_meat_" + tag + "_cooked").setColors(0xBB9949, hex).setTextureFood("bun_cooked", "O");

		new FoodForItem("meat_" + tag + "_patty_raw").setFoodStats(1, 0.1F).setName("meat_" + tag + "_patty_raw").setColorsMix(0, 0xCCCCCC, cooked_color[0], 3, true).setTextureFood("patty");
		new FoodForItem("meat_" + tag + "_patty_cooked").setFoodStats(1, 0.1F).setName("meat_" + tag + "_patty_cooked").setColorsMix(0, 0xCCCCCC, cooked_color[2], 3, true).setTextureFood("patty");

		new FoodForItem("roll_meat_" + tag).setFoodStats(1, 0.2F).setName("roll_meat_" + tag).setColors(0xFFFFFF, hex).setTextureFood("roll", "O");

		new FoodForItem("icecream_meat_" + tag + "_ball").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_ball").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_ball");
		new FoodForItem("icecream_meat_" + tag + "_waffle_cone").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_waffle_cone").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_waffle_cone", "O");
		new FoodForItem("icecream_meat_" + tag + "_stick").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_stick").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_stick", "O");
		new FoodForItem("icecream_meat_" + tag + "_plate").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_plate").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_plate", "O");

		new FoodForItem("sandwich_meat_" + tag).setFoodStats(2, 0.25F).setName("sandwich_meat_" + tag).setColors(0xFFFFFF, hex).setTextureFood(new String[] {"sandwich_dual_down", "meat"});
		new FoodForItem("sandwich_dual_meat_" + tag).setFoodStats(3, 0.3F).setName("sandwich_dual_meat_" + tag).setColors(0xFFFFFF, hex).setTextureFood(new String[] {"sandwich_dual_down", "meat", "sandwich_dual_up"});

		new FoodForItem("sandwich_meat_cutlet_" + tag).setFoodStats(2, 0.25F).setName("sandwich_meat_cutlet_" + tag).setColors(0xFFFFFF, hex).setTextureFood(new String[] {"sandwich_dual_down", "meat_cutlet"});
		new FoodForItem("sandwich_dual_meat_cutlet_" + tag).setFoodStats(3, 0.3F).setName("sandwich_dual_meat_cutlet_" + tag).setColors(0xFFFFFF, hex).setTextureFood(new String[] {"sandwich_dual_down", "meat_cutlet", "sandwich_dual_up"});

		//--FoodForBlock-----------------------------------------------------------------------------------------------------------------------------
		new FoodForBlock("meat_" + tag + "_cake_raw").setFoodStats(2, 0.2F).setType("Cake").setName("meat_" + tag + "_cake").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_cake");
		new FoodForBlock("meat_" + tag + "_cake_cooked").setFoodStats(2, 0.2F).setType("Cake").setName("meat_" + tag + "_cake").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_cake");

		new FoodForBlock("meat_" + tag + "_pie_raw").setFoodStats(2, 0.2F).setType("Pie").setName("meat_" + tag + "_pie").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pie");
		new FoodForBlock("meat_" + tag + "_pie_cooked").setFoodStats(2, 0.2F).setType("Pie").setName("meat_" + tag + "_pie").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pie");

		new FoodForBlock("meat_" + tag + "_pizza_raw").setFoodStats(2, 0.2F).setType("Pizza").setName("meat_" + tag + "_pizza").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pizza");
		new FoodForBlock("meat_" + tag + "_pizza_cooked").setFoodStats(2, 0.2F).setType("Pizza").setName("meat_" + tag + "_pizza").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pizza");
		//--FluidFake--------------------------------------------------------------------------------------------------------------------------------
		new FluidFake("minced_meat_" + tag + "_raw").setName("minced_meat_" + tag + "_raw").setType("Liquid").setColor(0xA53526).setTemperatures(24.0F, -16.0F, 80.0F);
		new FluidFake("broth_meat_" + tag).setName("broth_meat_" + tag).setType("Liquid").setColor(0xA53526).setTemperatures(24.0F, -16.0F, 80.0F);
		new FluidFake("meat_" + tag + "_sauce").setName("meat_" + tag + "_sauce").setType("Sauce").setColor(hex).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("fat_" + tag).setName("fat_" + tag).setType("Fat").setColorMix(0xA53526, 0xFFFFFF).setTemperatures(28.0F, 0.0F, 80.0F);
		new FluidFake("icecream_meat_" + tag).setName("icecream_meat_" + tag).setType("Icecream").setColorMix(hex, 0xAAAAAA).setTemperatures(16.0F, -16.0F, 100.0F);

		new FluidFake("soul_" + tag).setName("soul_" + tag).setType("Gas").setColor(0xBF9CA4).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("blood_" + tag).setName("blood_" + tag).setType("Liquid").setColor(0xBF0000).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("raw_flesh_" + tag).setName("raw_flesh_" + tag).setType("Liquid").setColor(0xBC3F2F).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("dust_bone_" + tag).setName("bone_" + tag).setType("Dust").setColor(0xDEE5E5).setTemperatures(30.0F, -20.0F, 80.0F);
		//-------------------------------------------------------------------------------------------------------------------------------------------
	}

	public static void beListMeatAnimal(String tag, int hex) {//, String sub_meat
		tag = tag.toLowerCase();
		//--ItemForStock-----------------------------------------------------------------------------------------------------------------------------
		new ItemForStock("skin_" + tag).setName("skin_" + tag).setType("Skin").setColors(0xFFFFFF).setTexture1("skin_cow");
		new ItemForStock("leather_" + tag).setName("leather_" + tag).setType("Leather").setColors(0xEAA159).setTexture1("leather_big");
		new ItemForStock("fur_" + tag).setName("fur_" + tag).setType("Fur").setColors(0xEAA159).setTexture1("fur");
		//--FoodForItem------------------------------------------------------------------------------------------------------------------------------
		for (int i = 0; i < cooked_name.length; i++) {
			new FoodForItem("meat_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat");
			new FoodForItem("meat_" + tag + "_bone_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_bone_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_bone", "O");
			new FoodForItem("minced_meat_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("minced_meat_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_mince");
			new FoodForItem("meat_" + tag + "_cutlet_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_cutlet_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_cutlet");
			new FoodForItem("meat_" + tag + "_rissole_" + cooked_name[i]).setFoodStats(1, 0.1F).setSpeedOfEating(16).setName("meat_" + tag + "_rissole_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_rissole");
			new FoodForItem("meat_" + tag + "_meatballs_" + cooked_name[i]).setFoodStats(1, 0.1F).setName("meat_" + tag + "_meatballs_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_meatballs");
			new FoodForItem("meat_" + tag + "_cubes_" + cooked_name[i]).setFoodStats(1, 0.1F).setName("meat_" + tag + "_cubes_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_cubes");
			new FoodForItem("meat_" + tag + "_dumpling_" + cooked_name[i]).setFoodStats(1, 0.1F).setName("meat_" + tag + "_dumpling_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_dumpling");
			new FoodForItem("frankfurter_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setSpeedOfEating(16).setName("frankfurter_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("frankfurter");
		}

		new FoodForItem("icecream_meat_" + tag + "_ball").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_ball").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_ball");
		new FoodForItem("icecream_meat_" + tag + "_waffle_cone").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_waffle_cone").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_waffle_cone", "O");
		new FoodForItem("icecream_meat_" + tag + "_stick").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_stick").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_stick", "O");
		new FoodForItem("icecream_meat_" + tag + "_plate").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_plate").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_plate", "O");

		//--FoodForBlock-----------------------------------------------------------------------------------------------------------------------------
		new FoodForBlock("meat_" + tag + "_cake_raw").setFoodStats(2, 0.2F).setType("Cake").setName("meat_" + tag + "_cake").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_cake");
		new FoodForBlock("meat_" + tag + "_cake_cooked").setFoodStats(2, 0.2F).setType("Cake").setName("meat_" + tag + "_cake").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_cake");

		new FoodForBlock("meat_" + tag + "_pie_raw").setFoodStats(2, 0.2F).setType("Pie").setName("meat_" + tag + "_pie").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pie");
		new FoodForBlock("meat_" + tag + "_pie_cooked").setFoodStats(2, 0.2F).setType("Pie").setName("meat_" + tag + "_pie").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pie");

		new FoodForBlock("meat_" + tag + "_pizza_raw").setFoodStats(2, 0.2F).setType("Pizza").setName("meat_" + tag + "_pizza").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pizza");
		new FoodForBlock("meat_" + tag + "_pizza_cooked").setFoodStats(2, 0.2F).setType("Pizza").setName("meat_" + tag + "_pizza").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pizza");
		//--FluidFake--------------------------------------------------------------------------------------------------------------------------------
		new FluidFake("minced_raw_meat_" + tag).setName("minced_raw_meat_" + tag).setType("Liquid").setColor(0xA53526).setTemperatures(24.0F, -16.0F, 80.0F);
		new FluidFake("broth_meat_" + tag).setName("broth_meat_" + tag).setType("Liquid").setColor(0xA53526).setTemperatures(24.0F, -16.0F, 80.0F);
		new FluidFake("fat_" + tag).setName("fat_" + tag).setType("Fat").setColorMix(0xA53526, 0xFFFFFF).setTemperatures(28.0F, 0.0F, 80.0F);
		new FluidFake("icecream_meat_" + tag).setName("icecream_meat_" + tag).setType("Icecream").setColorMix(hex, 0xAAAAAA).setTemperatures(16.0F, -16.0F, 100.0F);

		new FluidFake("soul_" + tag).setName("soul_" + tag).setType("Gas").setColor(0xBF9CA4).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("blood_" + tag).setName("blood_" + tag).setType("Liquid").setColor(0xBF0000).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("raw_flesh_" + tag).setName("raw_flesh_" + tag).setType("Liquid").setColor(0xBC3F2F).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("dust_bone_" + tag).setName("bone_" + tag).setType("Dust").setColor(0xDEE5E5).setTemperatures(30.0F, -20.0F, 80.0F);
		//-------------------------------------------------------------------------------------------------------------------------------------------
	}

	public static void beListMeatBird(String tag, int hex) {//, String sub_meat
		tag = tag.toLowerCase();
		//--ItemForStock-----------------------------------------------------------------------------------------------------------------------------
		new ItemForStock("skin_" + tag).setName("skin_" + tag).setType("Skin").setColors(0xFFFFFF).setTexture1("skin_cow");
		new ItemForStock("leather_" + tag).setName("leather_" + tag).setType("Leather").setColors(0xEAA159).setTexture1("leather_big");
		new ItemForStock("feather_" + tag).setName("feather_" + tag).setType("Feather").setColors(0xFFFFFF).setTexture1("feather");
		new ItemForStock("egg_" + tag).setName("egg_" + tag).setType("Egg").setColors(0xEAA159).setTexture1("egg");
		//--FoodForItem------------------------------------------------------------------------------------------------------------------------------
		for (int i = 0; i < cooked_name.length; i++) {
			new FoodForItem("meat_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat");
			new FoodForItem("meat_" + tag + "_bone_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_bone_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_bird_bone", "O");
			new FoodForItem("minced_meat_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("minced_meat_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_mince");
			new FoodForItem("meat_" + tag + "_cutlet_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_cutlet_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_cutlet");
			new FoodForItem("meat_" + tag + "_rissole_" + cooked_name[i]).setFoodStats(1, 0.1F).setSpeedOfEating(16).setName("meat_" + tag + "_rissole_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_rissole");
			new FoodForItem("meat_" + tag + "_meatballs_" + cooked_name[i]).setFoodStats(1, 0.1F).setName("meat_" + tag + "_meatballs_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_meatballs");
			new FoodForItem("meat_" + tag + "_cubes_" + cooked_name[i]).setFoodStats(1, 0.1F).setName("meat_" + tag + "_cubes_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_cubes");
			new FoodForItem("meat_" + tag + "_dumpling_" + cooked_name[i]).setFoodStats(1, 0.1F).setName("meat_" + tag + "_dumpling_" + cooked_name[i]).setColors(0xAAAAAA).setTextureFood("dumpling");
			new FoodForItem("frankfurter_meat_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setSpeedOfEating(16).setName("frankfurter_meat_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("frankfurter");
		}

		new FoodForItem("icecream_meat_" + tag + "_ball").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_ball").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_ball");
		new FoodForItem("icecream_meat_" + tag + "_waffle_cone").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_waffle_cone").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_waffle_cone", "O");
		new FoodForItem("icecream_meat_" + tag + "_stick").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_stick").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_stick", "O");
		new FoodForItem("icecream_meat_" + tag + "_plate").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_plate").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_plate", "O");

		new FoodForItem("sandwich_meat_" + tag).setFoodStats(2, 0.25F).setName("sandwich_meat_" + tag).setColors(0xFFFFFF, hex).setTextureFood(new String[] {"sandwich_dual_down", "meat"});
		new FoodForItem("sandwich_dual_meat_" + tag).setFoodStats(3, 0.3F).setName("sandwich_dual_meat_" + tag).setColors(0xFFFFFF, hex).setTextureFood(new String[] {"sandwich_dual_down", "meat", "sandwich_dual_up"});

		new FoodForItem("sandwich_meat_cutlet_" + tag).setFoodStats(2, 0.25F).setName("sandwich_meat_cutlet_" + tag).setColors(0xFFFFFF, hex).setTextureFood(new String[] {"sandwich_dual_down", "meat_cutlet"});
		new FoodForItem("sandwich_dual_meat_cutlet_" + tag).setFoodStats(3, 0.3F).setName("sandwich_dual_meat_cutlet_" + tag).setColors(0xFFFFFF, hex).setTextureFood(new String[] {"sandwich_dual_down", "meat_cutlet", "sandwich_dual_up"});

		//--FoodForBlock-----------------------------------------------------------------------------------------------------------------------------
		new FoodForBlock("meat_" + tag + "_cake_raw").setFoodStats(2, 0.2F).setType("Cake").setName("meat_" + tag + "_cake").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_cake");
		new FoodForBlock("meat_" + tag + "_cake_cooked").setFoodStats(2, 0.2F).setType("Cake").setName("meat_" + tag + "_cake").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_cake");

		new FoodForBlock("meat_" + tag + "_pie_raw").setFoodStats(2, 0.2F).setType("Pie").setName("meat_" + tag + "_pie").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pie");
		new FoodForBlock("meat_" + tag + "_pie_cooked").setFoodStats(2, 0.2F).setType("Pie").setName("meat_" + tag + "_pie").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pie");

		new FoodForBlock("meat_" + tag + "_pizza_raw").setFoodStats(2, 0.2F).setType("Pizza").setName("meat_" + tag + "_pizza").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pizza");
		new FoodForBlock("meat_" + tag + "_pizza_cooked").setFoodStats(2, 0.2F).setType("Pizza").setName("meat_" + tag + "_pizza").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pizza");
		//--FluidFake--------------------------------------------------------------------------------------------------------------------------------
		new FluidFake("minced_raw_meat_" + tag).setName("minced_raw_meat_" + tag).setType("Liquid").setColor(0xA53526).setTemperatures(24.0F, -16.0F, 80.0F);
		new FluidFake("broth_meat_" + tag).setName("broth_meat_" + tag).setType("Liquid").setColor(0xA53526).setTemperatures(24.0F, -16.0F, 80.0F);
		new FluidFake("meat_" + tag + "_sauce").setName("meat_" + tag + "_sauce").setType("Sauce").setColor(hex).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("fat_" + tag).setName("fat_" + tag).setType("Fat").setColorMix(0xA53526, 0xFFFFFF).setTemperatures(28.0F, 0.0F, 80.0F);
		new FluidFake("icecream_meat_" + tag).setName("icecream_meat_" + tag).setType("Icecream").setColorMix(hex, 0xAAAAAA).setTemperatures(16.0F, -16.0F, 100.0F);

		new FluidFake("soul_" + tag).setName("soul_" + tag).setType("Gas").setColor(0xBF9CA4).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("blood_" + tag).setName("blood_" + tag).setType("Liquid").setColor(0xBF0000).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("raw_flesh_" + tag).setName("raw_flesh_" + tag).setType("Liquid").setColor(0xBC3F2F).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("dust_bone_" + tag).setName("bone_" + tag).setType("Dust").setColor(0xDEE5E5).setTemperatures(30.0F, -20.0F, 80.0F);
		//-------------------------------------------------------------------------------------------------------------------------------------------
		//egg sendwich
	}

	public static void beListMeatSeaAnimal(String tag, int hex) {//, String sub_meat
		tag = tag.toLowerCase();
		//--ItemForStock-----------------------------------------------------------------------------------------------------------------------------
		new ItemForStock("skin_" + tag).setName("skin_" + tag).setType("Skin").setColors(0xFFFFFF).setTexture1("skin_cow");
		new ItemForStock("leather_" + tag).setName("leather_" + tag).setType("Leather").setColors(0xEAA159).setTexture1("leather_big");
		//--FoodForItem------------------------------------------------------------------------------------------------------------------------------
		for (int i = 0; i < cooked_name.length; i++) {
			new FoodForItem("meat_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat");
			new FoodForItem("meat_" + tag + "_bone_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_bone_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_bone", "O");
			new FoodForItem("minced_meat_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("minced_meat_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_mince");
			new FoodForItem("meat_" + tag + "_cutlet_" + cooked_name[i]).setFoodStats(2, 0.2F).setName("meat_" + tag + "_cutlet_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_cutlet");
			new FoodForItem("meat_" + tag + "_rissole_" + cooked_name[i]).setFoodStats(1, 0.1F).setSpeedOfEating(16).setName("meat_" + tag + "_rissole_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_rissole");
			new FoodForItem("meat_" + tag + "_meatballs_" + cooked_name[i]).setFoodStats(1, 0.1F).setName("meat_" + tag + "_meatballs_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_meatballs");
			new FoodForItem("meat_" + tag + "_cubes_" + cooked_name[i]).setFoodStats(1, 0.1F).setName("meat_" + tag + "_cubes_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_cubes");
			new FoodForItem("meat_" + tag + "_dumpling_" + cooked_name[i]).setFoodStats(1, 0.1F).setName("meat_" + tag + "_dumpling_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("meat_dumpling");
			new FoodForItem("frankfurter_" + tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setSpeedOfEating(16).setName("frankfurter_" + tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTextureFood("frankfurter");
		}

		new FoodForItem("icecream_meat_" + tag + "_ball").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_ball").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_ball");
		new FoodForItem("icecream_meat_" + tag + "_waffle_cone").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_waffle_cone").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_waffle_cone", "O");
		new FoodForItem("icecream_meat_" + tag + "_stick").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_stick").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_stick", "O");
		new FoodForItem("icecream_meat_" + tag + "_plate").setFoodStats(2, 0.2F).setName("icecream_meat_" + tag + "_plate").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_plate", "O");

		//--FoodForBlock-----------------------------------------------------------------------------------------------------------------------------
		new FoodForBlock("meat_" + tag + "_cake_raw").setFoodStats(2, 0.2F).setType("Cake").setName("meat_" + tag + "_cake").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_cake");
		new FoodForBlock("meat_" + tag + "_cake_cooked").setFoodStats(2, 0.2F).setType("Cake").setName("meat_" + tag + "_cake").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_cake");

		new FoodForBlock("meat_" + tag + "_pie_raw").setFoodStats(2, 0.2F).setType("Pie").setName("meat_" + tag + "_pie").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pie");
		new FoodForBlock("meat_" + tag + "_pie_cooked").setFoodStats(2, 0.2F).setType("Pie").setName("meat_" + tag + "_pie").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pie");

		new FoodForBlock("meat_" + tag + "_pizza_raw").setFoodStats(2, 0.2F).setType("Pizza").setName("meat_" + tag + "_pizza").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pizza");
		new FoodForBlock("meat_" + tag + "_pizza_cooked").setFoodStats(2, 0.2F).setType("Pizza").setName("meat_" + tag + "_pizza").setColors(0xFFFFFF).setTexture1("meat_" + tag + "_pizza");
		//--FluidFake--------------------------------------------------------------------------------------------------------------------------------
		new FluidFake("minced_raw_meat_" + tag).setName("minced_raw_meat_" + tag).setType("Liquid").setColor(0xA53526).setTemperatures(24.0F, -16.0F, 80.0F);
		new FluidFake("broth_meat_" + tag).setName("broth_meat_" + tag).setType("Liquid").setColor(0xA53526).setTemperatures(24.0F, -16.0F, 80.0F);
		new FluidFake("fat_" + tag).setName("fat_" + tag).setType("Fat").setColorMix(0xA53526, 0xFFFFFF).setTemperatures(28.0F, 0.0F, 80.0F);
		new FluidFake("icecream_meat_" + tag).setName("icecream_meat_" + tag).setType("Icecream").setColorMix(hex, 0xAAAAAA).setTemperatures(16.0F, -16.0F, 100.0F);

		new FluidFake("soul_" + tag).setName("soul_" + tag).setType("Gas").setColor(0xBF9CA4).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("blood_" + tag).setName("blood_" + tag).setType("Liquid").setColor(0xBF0000).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("raw_flesh_" + tag).setName("raw_flesh_" + tag).setType("Liquid").setColor(0xBC3F2F).setTemperatures(30.0F, -20.0F, 80.0F);
		new FluidFake("dust_bone_" + tag).setName("bone_" + tag).setType("Dust").setColor(0xDEE5E5).setTemperatures(30.0F, -20.0F, 80.0F);
		//-------------------------------------------------------------------------------------------------------------------------------------------
	}

	public static void beListMilk(String tag, int hex) {
		tag = tag.toLowerCase();
		//--FoodForItem------------------------------------------------------------------------------------------------------------------------------

		//--FoodForBlock-----------------------------------------------------------------------------------------------------------------------------

		//--FluidFake--------------------------------------------------------------------------------------------------------------------------------
		new FluidFake("milk_" + tag).setName("milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("cream_milk_" + tag).setName("cream_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("sour_cream_milk_" + tag).setName("sour_cream_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("cottage_cheese_milk_" + tag).setName("cottage_cheese_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("koumiss_milk_" + tag).setName("koumiss_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("cheese_milk_" + tag).setName("cheese_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("ryazhenka_milk_" + tag).setName("ryazhenka_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("buttermilk_milk_" + tag).setName("buttermilk_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("serum_milk_" + tag).setName("serum_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("varenets_milk_" + tag).setName("varenets_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("kefir_milk_" + tag).setName("kefir_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("yoghurt_milk_" + tag).setName("yoghurt_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("yogurt_milk_" + tag).setName("yogurt_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("acidophilus_milk_" + tag).setName("acidophilus_milk_" + tag).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		//-------------------------------------------------------------------------------------------------------------------------------------------
	}

	public static void beListVegetable(String tag, int hex) {
		tag = tag.toLowerCase();
		//--FoodForItem------------------------------------------------------------------------------------------------------------------------------
		new FoodForItem("roasted_seeds_" + tag).setFoodStats(1, 0.1F).setName("roasted_seeds_" + tag).setColors(0xFFFFFF).setTexture("seeds_" + tag);

		for (int i = 0; i < cooked_name.length; i++) {
			new FoodForItem(tag + "_" + cooked_name[i]).setFoodStats(2, 0.2F).setName(tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTexture(tag);
			new FoodForItem(tag + "_" + cooked_name[i]).setFoodStats(2, 0.25F).setName(tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTexture(tag);
			new FoodForItem(tag + "_" + cooked_name[i]).setFoodStats(2, 0.23F).setName(tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTexture(tag);
			new FoodForItem(tag + "_" + cooked_name[i]).setFoodStats(2, 0.23F).setName(tag + "_" + cooked_name[i]).setColorsMix(0, hex, cooked_color[i], 3, true).setTexture(tag);
		}

		new FoodForItem("pie_" + tag + "_raw_part").setFoodStats(2, 0.2F).setName("pie_" + tag + "_raw_part").setColors(0xFFFFFF, hex).setTextureFood("pie_part", "O");
		new FoodForItem("pie_" + tag + "_cooked_part").setFoodStats(2, 0.2F).setName("pie_" + tag + "_cooked_part").setColors(0xBE7F7F, hex).setTextureFood("pie_part", "O");
		new FoodForItem("pie_jam_" + tag + "_raw_part").setFoodStats(2, 0.2F).setName("pie_jam_" + tag + "_raw_part").setColors(0xFFFFFF, hex).setTextureFood("pie_part", "O");
		new FoodForItem("pie_jam_" + tag + "_cooked_part").setFoodStats(2, 0.2F).setName("pie_jam_" + tag + "_cooked_part").setColors(0xBE7F7F, hex).setTextureFood("pie_part", "O");
		new FoodForItem("pie_jelly_" + tag + "_raw_part").setFoodStats(2, 0.2F).setName("pie_jelly_" + tag + "_raw_part").setColors(0xFFFFFF, hex).setTextureFood("pie_part", "O");
		new FoodForItem("pie_jelly_" + tag + "_cooked_part").setFoodStats(2, 0.2F).setName("pie_jelly_" + tag + "_cooked_part").setColors(0xBE7F7F, hex).setTextureFood("pie_part", "O");

		new FoodForItem("pizza_" + tag + "_raw_part").setFoodStats(2, 0.2F).setName("pizza_" + tag + "_raw_part").setColors(0xFFFFFF, hex).setTextureFood("pizza_part", "O");
		new FoodForItem("pizza_jam_" + tag + "_raw_part").setFoodStats(2, 0.2F).setName("pizza_jam_" + tag + "_raw_part").setColors(0xFFFFFF, hex).setTextureFood("pizza_part", "O");
		new FoodForItem("pizza_jelly_" + tag + "_raw_part").setFoodStats(2, 0.2F).setName("pizza_jelly_" + tag + "_raw_part").setColors(0xFFFFFF, hex).setTextureFood("pizza_part", "O");
		new FoodForItem("pizza_" + tag + "_cooked_part").setFoodStats(2, 0.2F).setName("pizza_" + tag + "_cooked_part").setColors(0xBE7F7F, hex).setTextureFood("pizza_part", "O");
		new FoodForItem("pizza_jam_" + tag + "_cooked_part").setFoodStats(2, 0.2F).setName("pizza_jam_" + tag + "_cooked_part").setColors(0xBE7F7F, hex).setTextureFood("pizza_part", "O");
		new FoodForItem("pizza_jelly_" + tag + "_cooked_part").setFoodStats(2, 0.2F).setName("pizza_jelly_" + tag + "_cooked_part").setColors(0xBE7F7F, hex).setTextureFood("pizza_part", "O");

		new FoodForItem("cookie_" + tag + "_raw").setFoodStats(1, 0.2F).setName("cookie_" + tag + "_raw").setColors(0xF1D598, hex).setTextureFood("cookie", "O");
		new FoodForItem("cookie_" + tag + "_cooked").setFoodStats(2, 0.2F).setName("cookie_" + tag + "_cooked").setColors(0xE79042, hex).setTextureFood("cookie", "O");
		new FoodForItem("cookie_jam_" + tag + "_raw").setFoodStats(1, 0.2F).setName("cookie_jam_" + tag + "_raw").setColors(0xF1D598, hex).setTextureFood("cookie", "O");
		new FoodForItem("cookie_jam_" + tag + "_cooked").setFoodStats(2, 0.2F).setName("cookie_jam_" + tag + "_cooked").setColors(0xE79042, hex).setTextureFood("cookie", "O");
		new FoodForItem("cookie_jelly_" + tag + "_raw").setFoodStats(1, 0.2F).setName("cookie_jelly_" + tag + "_raw").setColors(0xF1D598, hex).setTextureFood("cookie", "O");
		new FoodForItem("cookie_jelly_" + tag + "_cooked").setFoodStats(2, 0.2F).setName("cookie_jelly_" + tag + "_cooked").setColors(0xE79042, hex).setTextureFood("cookie", "O");

		new FoodForItem("cupcake_" + tag + "_raw").setFoodStats(1, 0.2F).setName("cupcake_" + tag + "_raw").setColors(0xD9D481, hex).setTextureFood("cupcake_02", "O");
		new FoodForItem("cupcake_" + tag + "_fried").setFoodStats(2, 0.25F).setName("cupcake_" + tag + "_fried").setColors(0xBB9949, hex).setTextureFood("cupcake_02", "O");
		new FoodForItem("cupcake_jam_" + tag + "_raw").setFoodStats(1, 0.2F).setName("cupcake_jam_" + tag + "_raw").setColors(0xD9D481, hex).setTextureFood("cupcake_02", "O");
		new FoodForItem("cupcake_jam_" + tag + "_fried").setFoodStats(2, 0.25F).setName("cupcake_jam_" + tag + "_fried").setColors(0xBB9949, hex).setTextureFood("cupcake_02", "O");
		new FoodForItem("cupcake_jelly_" + tag + "_raw").setFoodStats(1, 0.2F).setName("cupcake_jelly_" + tag + "_raw").setColors(0xD9D481, hex).setTextureFood("cupcake_02", "O");
		new FoodForItem("cupcake_jelly_" + tag + "_fried").setFoodStats(2, 0.25F).setName("cupcake_jelly_" + tag + "_fried").setColors(0xBB9949, hex).setTextureFood("cupcake_02", "O");

		new FoodForItem("pancake_jam_" + tag).setFoodStats(2, 0.2F).setName("pancake_jam_" + tag).setColors(0xBB9949, hex).setTextureFood("pancake", "O");
		new FoodForItem("pancake_jelly_" + tag).setFoodStats(2, 0.2F).setName("pancake_jelly_" + tag).setColors(0xBB9949, hex).setTextureFood("pancake", "O");

		new FoodForItem("doughnut_jam_" + tag + "_cooked").setFoodStats(3, 0.3F).setName("doughnut_jam_" + tag + "_cooked").setColors(0xBB9949, hex).setTextureFood("doughnut_cooked", "O");
		new FoodForItem("doughnut_jelly_" + tag + "_cooked").setFoodStats(3, 0.3F).setName("doughnut_jelly_" + tag + "_cooked").setColors(0xBB9949, hex).setTextureFood("doughnut_cooked", "O");

		new FoodForItem("bun_" + tag + "_raw").setFoodStats(2, 0.2F).setName("bun_" + tag + "_raw").setColors(0xD9D481, hex).setTextureFood("bun_raw", "O");
		new FoodForItem("bun_" + tag + "_cooked").setFoodStats(3, 0.3F).setName("bun_" + tag + "_cooked").setColors(0xBB9949, hex).setTextureFood("bun_cooked", "O");
		new FoodForItem("bun_jam_" + tag + "_raw").setFoodStats(2, 0.2F).setName("bun_jam_" + tag + "_raw").setColors(0xD9D481, hex).setTextureFood("bun_raw", "O");
		new FoodForItem("bun_jam_" + tag + "_cooked").setFoodStats(3, 0.3F).setName("bun_jam_" + tag + "_cooked").setColors(0xBB9949, hex).setTextureFood("bun_cooked", "O");
		new FoodForItem("bun_jelly_" + tag + "_raw").setFoodStats(2, 0.2F).setName("bun_jelly_" + tag + "_raw").setColors(0xD9D481, hex).setTextureFood("bun_raw", "O");
		new FoodForItem("bun_jelly_" + tag + "_cooked").setFoodStats(3, 0.3F).setName("bun_jelly_" + tag + "_cooked").setColors(0xBB9949, hex).setTextureFood("bun_cooked", "O");

		new FoodForItem("roll_" + tag).setFoodStats(1, 0.2F).setName("roll_" + tag).setColors(0xFFFFFF, hex).setTextureFood("roll", "O");
		new FoodForItem("roll_jam_" + tag).setFoodStats(1, 0.2F).setName("roll_jam_" + tag).setColors(0xFFFFFF, hex).setTextureFood("roll", "O");
		new FoodForItem("roll_jelly_" + tag).setFoodStats(1, 0.2F).setName("roll_jelly_" + tag).setColors(0xFFFFFF, hex).setTextureFood("roll", "O");

		new FoodForItem("sandwich_jam_" + tag).setFoodStats(2, 0.25F).setName("sandwich_jam_" + tag).setColors(0xFFFFFF, hex).setTextureFood("bread01", "O");
		new FoodForItem("sandwich_jelly_" + tag).setFoodStats(2, 0.25F).setName("sandwich_jelly_" + tag).setColors(0xFFFFFF, hex).setTextureFood("bread01", "O");
		new FoodForItem("sandwich_dual_jam_" + tag).setFoodStats(3, 0.3F).setName("sandwich_jam_" + tag).setColors(0xFFFFFF, hex).setTextureFood("sandwich_dual", "O");
		new FoodForItem("sandwich_dual_jelly_" + tag).setFoodStats(3, 0.3F).setName("sandwich_jelly_" + tag).setColors(0xFFFFFF, hex).setTextureFood("sandwich_dual", "O");

		new FoodForItem("icecream_" + tag + "_ball").setFoodStats(2, 0.2F).setName("icecream_" + tag + "_ball").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_ball");
		new FoodForItem("icecream_" + tag + "_waffle_cone").setFoodStats(2, 0.2F).setName("icecream_" + tag + "_waffle_cone").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_waffle_cone", "O");
		new FoodForItem("icecream_" + tag + "_stick").setFoodStats(2, 0.2F).setName("icecream_" + tag + "_stick").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_stick", "O");
		new FoodForItem("icecream_" + tag + "_plate").setFoodStats(2, 0.2F).setName("icecream_" + tag + "_plate").setColorsMix(0, hex, 0xAAAAAA).setTextureFood("icecream_plate", "O");

		new FoodForItem("caramel_" + tag).setFoodStats(2, 0.2F).setName("caramel_" + tag).setColors(0xFFFFFF).setTextureFood("caramel_" + tag);
		//--FoodForBlock-----------------------------------------------------------------------------------------------------------------------------
		new FoodForBlock(tag + "_cake_raw").setFoodStats(2, 0.2F).setType("Cake").setName(tag + "_cake_raw").setColors(0xFFFFFF).setTexture1(tag + "_cake");
		new FoodForBlock(tag + "_cake_cooked").setFoodStats(2, 0.2F).setType("Cake").setName(tag + "_cake_cooked").setColors(0xFFFFFF).setTexture1(tag + "_cake");

		new FoodForBlock(tag + "_pie_raw").setFoodStats(2, 0.2F).setType("Pie").setName(tag + "_pie_raw").setColors(0xFFFFFF).setTexture1(tag + "_pie");
		new FoodForBlock(tag + "_pie_cooked").setFoodStats(2, 0.2F).setType("Pie").setName(tag + "_pie_cooked").setColors(0xFFFFFF).setTexture1("wheat_pie");

		new FoodForBlock(tag + "_pizza_raw").setFoodStats(2, 0.2F).setType("Pizza").setName(tag + "_pizza_raw").setColors(0xFFFFFF).setTexture1(tag + "_pizza");
		new FoodForBlock(tag + "_pizza_cooked").setFoodStats(2, 0.2F).setType("Pizza").setName(tag + "_pizza_cooked").setColors(0xFFFFFF).setTexture1(tag + "_pizza");
		//--FluidFake--------------------------------------------------------------------------------------------------------------------------------
		new FluidFake(tag + "_decoction").setName(tag + "_decoction").setType("Liquid").setColorMix(hex, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_tea").setName(tag + "_tea").setType("Liquid").setColorMix(hex, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 80.0F);
		new FluidFake(tag + "_juice").setName(tag + "_juice").setType("Liquid").setColor(hex).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_juice_concentrate").setName(tag + "_juice_concentrate").setType("Liquid").setColor(hex).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_lemonade").setName(tag + "_lemonade").setType("Liquid").setColorMix(hex, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_milkshake").setName(tag + "_milkshake").setType("Liquid").setColorMix(hex, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_tincture").setName(tag + "_tincture").setType("Liquid").setColorMix(hex, 0xAAAAFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_sauce").setName(tag + "_sauce").setType("Sauce").setColor(hex).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_jam").setName(tag + "_jam").setType("Jam").setColorMix(hex, 0xBBBBBB).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_jelly").setName(tag + "_jelly").setType("Jelly").setColorMix(hex, 0xAAAAAA).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("icecream_" + tag).setName("icecream_" + tag).setType("Icecream").setColorMix(hex, 0xAAAAAA).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_flour").setName(tag + "_flour").setType("Dust").setColorMix(hex, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_oil").setName(tag + "_oil").setType("Vegetable Oil").setColor(0xC2C832).setTemperatures(16.0F, -16.0F, 100.0F);
	}
/*
	public static void beListFlower(String tag, int hex) {
		tag = tag.toLowerCase();
		//--FoodForItem------------------------------------------------------------------------------------------------------------------------------
		new FoodForItem("roasted_seeds_" + tag).setFoodStats(1, 0.1F).setName("roasted_seeds_" + tag).setColors(0xFFFFFF).setTexture("seeds_" + tag);
		new FoodForItem(tag + "_raw").setFoodStats(2, 0.2F).setName(tag + "_raw").setColors(0xFFFFFF).setTexture(tag + "_raw");
		new FoodForItem(tag + "_fried").setFoodStats(2, 0.25F).setName(tag + "_fried").setColors(0xFFFFFF).setTexture(tag + "_fried");
		new FoodForItem(tag + "_boiled").setFoodStats(2, 0.23F).setName(tag + "_boiled").setColors(0xFFFFFF).setTexture(tag + "_boiled");
		new FoodForItem(tag + "_dried").setFoodStats(2, 0.23F).setName(tag + "_dried").setColors(0xFFFFFF).setTexture(tag + "_dried");

		//--FoodForBlock-----------------------------------------------------------------------------------------------------------------------------
		new FoodForBlock(tag + "_cake_raw").setFoodStats(2, 0.2F).setType("Cake").setName(tag + "_cake_raw").setColors(0xFFFFFF).setTexture1(tag + "_cake");
		new FoodForBlock(tag + "_cake_cooked").setFoodStats(2, 0.2F).setType("Cake").setName(tag + "_cake_cooked").setColors(0xFFFFFF).setTexture1(tag + "_cake");

		new FoodForBlock(tag + "_pie_raw").setFoodStats(2, 0.2F).setType("Pie").setName(tag + "_pie_raw").setColors(0xFFFFFF).setTexture1(tag + "_pie");
		new FoodForBlock(tag + "_pie_cooked").setFoodStats(2, 0.2F).setType("Pie").setName(tag + "_pie_cooked").setColors(0xFFFFFF).setTexture1("wheat_pie");

		new FoodForBlock(tag + "_pizza_raw").setFoodStats(2, 0.2F).setType("Pizza").setName(tag + "_pizza_raw").setColors(0xFFFFFF).setTexture1(tag + "_pizza");
		new FoodForBlock(tag + "_pizza_cooked").setFoodStats(2, 0.2F).setType("Pizza").setName(tag + "_pizza_cooked").setColors(0xFFFFFF).setTexture1(tag + "_pizza");
		//--FluidFake--------------------------------------------------------------------------------------------------------------------------------
		new FluidFake(tag + "_decoction").setName(tag + "_decoction").setType("Liquid").setColorMix(hex, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_tea").setName(tag + "_tea").setType("Liquid").setColorMix(hex, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 80.0F);
		new FluidFake(tag + "_juice").setName(tag + "_juice").setType("Liquid").setColor(hex).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_juice_concentrate").setName(tag + "_juice_concentrate").setType("Liquid").setColor(hex).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_lemonade").setName(tag + "_lemonade").setType("Liquid").setColorMix(hex, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_milkshake").setName(tag + "_milkshake").setType("Liquid").setColorMix(hex, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_tincture").setName(tag + "_tincture").setType("Liquid").setColorMix(hex, 0xAAAAFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_sauce").setName(tag + "_sauce").setType("Sauce").setColor(hex).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_jam").setName(tag + "_jam").setType("Jam").setColorMix(hex, 0xBBBBBB).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_jelly").setName(tag + "_jelly").setType("Jelly").setColorMix(hex, 0xAAAAAA).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake("icecream_" + tag).setName("icecream_" + tag).setType("Icecream").setColorMix(hex, 0xAAAAAA).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_flour").setName(tag + "_flour").setType("Dust").setColorMix(hex, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
		new FluidFake(tag + "_oil").setName(tag + "_oil").setType("Vegetable Oil").setColor(0xC2C832).setTemperatures(16.0F, -16.0F, 100.0F);
		//-------------------------------------------------------------------------------------------------------------------------------------------
	}
*/
}
