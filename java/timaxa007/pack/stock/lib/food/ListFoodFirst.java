package timaxa007.pack.stock.lib.food;

import timaxa007.pack.mining.lib.OreFake;
import timaxa007.pack.stock.lib.FoodForItem;

public class ListFoodFirst {
	/*---OreFake---*/
	public static OreFake ore_salt = new OreFake("ore_salt").setName("salt").setType("Rock").setColor(0xFFFFFF).setTemperatures(16.0F, -10.0F, 100.0F);
	public static OreFake ore_salted = new OreFake("ore_salted").setName("salt").setType("End").setColor(0xFFFFFF).setTemperatures(0.0F, -60.0F, 40.0F);
	public static OreFake ore_salter = new OreFake("ore_salter").setName("salt").setType("Nether").setColor(0xFFFFFF).setTemperatures(48.0F, 0.0F, 180.0F);

	/*---FoodForItem---*/
	public static FoodForItem cookie_raw = new FoodForItem("cookie_raw").setFoodStats(1, 0.2F).setName("cookie_raw").setColors(0xF1D598).setTextureFood("cookie", "O");
	public static FoodForItem cookie_cooked = new FoodForItem("cookie_cooked").setFoodStats(2, 0.2F).setName("cookie_cooked").setColors(0xE79042).setTextureFood("cookie", "O");

	public static FoodForItem cookie_chocolate_chips_raw = new FoodForItem("cookie_chocolate_chips_raw").setFoodStats(2, 0.2F).setName("cookie_chocolate_chips_raw").setColors(0xF1D598, 0x3F1800).setTextureFood("cookie", "O");
	public static FoodForItem cookie_chocolate_chips_cooked = new FoodForItem("cookie_chocolate_chips_cooked").setFoodStats(2, 0.2F).setName("cookie_chocolate_chips_cooked").setColors(0xE79042, 0x3F1800).setTextureFood("cookie", "O");
	/*
	public static FoodForItem cookie_red_raw = new FoodForItem("cookie_red_raw").setFoodStats(2, 0.2F).setName("cookie_raw").setColors(0xF1D598, 0xFF0000).setTextureFood("cookie", "O");
	public static FoodForItem cookie_red_cooked = new FoodForItem("cookie_red_cooked").setFoodStats(2, 0.2F).setName("cookie_cooked").setColors(0xE79042, 0xFF0000).setTextureFood("cookie", "O");
	public static FoodForItem cookie_green_raw = new FoodForItem("cookie_green_raw").setFoodStats(2, 0.2F).setName("cookie_raw").setColors(0xF1D598, 0x00FF00).setTextureFood("cookie", "O");
	public static FoodForItem cookie_green_cooked = new FoodForItem("cookie_green_cooked").setFoodStats(2, 0.2F).setName("cookie_cooked").setColors(0xE79042, 0x00FF00).setTextureFood("cookie", "O");
	public static FoodForItem cookie_blue_raw = new FoodForItem("cookie_blue_raw").setFoodStats(2, 0.2F).setName("cookie_raw").setColors(0xF1D598, 0x0000FF).setTextureFood("cookie", "O");
	public static FoodForItem cookie_blue_cooked = new FoodForItem("cookie_blue_cooked").setFoodStats(2, 0.2F).setName("cookie_cooked").setColors(0xE79042, 0x0000FF).setTextureFood("cookie", "O");
	 */
	public static FoodForItem cracker_raw = new FoodForItem("cracker_raw").setFoodStats(2, 0.2F).setName("cracker_raw").setColors(0xFFD57F).setTextureFood("cracker");
	public static FoodForItem cracker_fried = new FoodForItem("cracker_fried").setFoodStats(2, 0.2F).setName("cracker_fried").setColors(0xF3B420).setTextureFood("cracker");

	public static FoodForItem cupcake_01_raw = new FoodForItem("cupcake_01_raw").setFoodStats(2, 0.2F).setName("cupcake_01_raw").setColors(0xD9D481).setTextureFood("cupcake_01");
	public static FoodForItem cupcake_01_fried = new FoodForItem("cupcake_01_fried").setFoodStats(2, 0.2F).setName("cupcake_01_fried").setColors(0xBB9949).setTextureFood("cupcake_01");
	/*
	public static FoodForItem cupcake_02_raw = new FoodForItem("cupcake_02_raw").setFoodStats(2, 0.2F).setName("cupcake_02_raw").setColors(0xD9D481, 0xFF0000).setTextureFood("cupcake_02", "O");
	public static FoodForItem cupcake_02_fried = new FoodForItem("cupcake_02_fried").setFoodStats(2, 0.2F).setName("cupcake_02_fried").setColors(0xBB9949, 0xFF0000).setTextureFood("cupcake_02", "O");
	 */
	public static FoodForItem pancake_raw = new FoodForItem("pancake_raw").setFoodStats(2, 0.2F).setName("pancake_raw").setColors(0xD9D481).setTextureFood("pancake");
	public static FoodForItem pancake_fried = new FoodForItem("pancake_fried").setFoodStats(2, 0.2F).setName("pancake_fried").setColors(0xBB9949).setTextureFood("pancake");
	/*
	public static FoodForItem pancake_red = new FoodForItem("pancake_red").setFoodStats(2, 0.2F).setName("pancake_red").setColors(0xBB9949, 0x00FF00).setTextureFood("pancake", "O");
	public static FoodForItem pancake_green = new FoodForItem("pancake_green").setFoodStats(2, 0.2F).setName("pancake_green").setColors(0xBB9949, 0xFF0000).setTextureFood("pancake", "O");
	public static FoodForItem pancake_blue = new FoodForItem("pancake_blue").setFoodStats(2, 0.2F).setName("pancake_blue").setColors(0xBB9949, 0x0000FF).setTextureFood("pancake", "O");
	 */
	public static FoodForItem doughnut_raw = new FoodForItem("doughnut_raw").setFoodStats(2, 0.2F).setName("doughnut_raw").setColors(0xD9D481).setTextureFood("doughnut_raw");
	public static FoodForItem doughnut_cooked = new FoodForItem("doughnut_cooked").setFoodStats(2, 0.2F).setName("doughnut_cooked").setColors(0xBB9949).setTextureFood("doughnut_cooked");
	/*
	public static FoodForItem doughnut_cooked_red = new FoodForItem("doughnut_cooked_red").setFoodStats(2, 0.2F).setName("doughnut_cooked_red").setColors(0xBB9949, 0xFF0000).setTextureFood("doughnut_cooked", "O");
	public static FoodForItem doughnut_cooked_green = new FoodForItem("doughnut_cooked_green").setFoodStats(2, 0.2F).setName("doughnut_cooked_green").setColors(0xBB9949, 0x00FF00).setTextureFood("doughnut_cooked", "O");
	public static FoodForItem doughnut_cooked_blue = new FoodForItem("doughnut_cooked_blue").setFoodStats(2, 0.2F).setName("doughnut_cooked_blue").setColors(0xBB9949, 0x0000FF).setTextureFood("doughnut_cooked", "O");
	 */
	public static FoodForItem bun_raw = new FoodForItem("bun_raw").setFoodStats(2, 0.2F).setName("bun_raw").setColors(0xD9D481).setTextureFood("bun_raw");
	public static FoodForItem bun_cooked = new FoodForItem("bun_cooked").setFoodStats(2, 0.2F).setName("bun_cooked").setColors(0xBB9949).setTextureFood("bun_cooked");
	/*
	public static FoodForItem bun_red_raw = new FoodForItem("bun_red_raw").setFoodStats(2, 0.2F).setName("bun_red_raw").setColors(0xD9D481, 0xFF0000).setTextureFood("bun_raw", "O");
	public static FoodForItem bun_red_cooked = new FoodForItem("bun_red_cooked").setFoodStats(2, 0.2F).setName("bun_red_cooked").setColors(0xBB9949, 0xFF0000).setTextureFood("bun_cooked", "O");
	public static FoodForItem bun_green_raw = new FoodForItem("bun_green_raw").setFoodStats(2, 0.2F).setName("bun_green_raw").setColors(0xD9D481, 0x00FF00).setTextureFood("bun_raw", "O");
	public static FoodForItem bun_green_cooked = new FoodForItem("bun_green_cooked").setFoodStats(2, 0.2F).setName("bun_green_cooked").setColors(0xBB9949, 0x00FF00).setTextureFood("bun_cooked", "O");
	public static FoodForItem bun_blue_raw = new FoodForItem("bun_blue_raw").setFoodStats(2, 0.2F).setName("bun_blue_raw").setColors(0xD9D481, 0x0000FF).setTextureFood("bun_raw", "O");
	public static FoodForItem bun_blue_cooked = new FoodForItem("bun_blue_cooked").setFoodStats(2, 0.2F).setName("bun_blue_cooked").setColors(0xBB9949, 0x0000FF).setTextureFood("bun_cooked", "O");
	 */
	public static FoodForItem tortilla = new FoodForItem("tortilla").setFoodStats(2, 0.2F).setName("tortilla").setColors(0xFFFFFF).setTextureFood("tortilla");
	public static FoodForItem bond01 = new FoodForItem("bond01").setFoodStats(2, 0.2F).setName("bond01").setColors(0xFFFFFF).setTextureFood("bond01");
	public static FoodForItem bond02 = new FoodForItem("bond02").setFoodStats(2, 0.2F).setName("bond02").setColors(0xFFFFFF).setTextureFood("bond02");
	public static FoodForItem bread_loaf = new FoodForItem("bread_loaf").setFoodStats(2, 0.2F).setName("bread_loaf").setColors(0xFFFFFF).setTextureFood("bread_loaf");
	public static FoodForItem bread_long_loaf = new FoodForItem("bread_long_loaf").setFoodStats(2, 0.2F).setName("bread_long_loaf").setColors(0xFFFFFF).setTextureFood("bread_long_loaf");
	public static FoodForItem bread_rye_loaf = new FoodForItem("bread_rye_loaf").setFoodStats(2, 0.2F).setName("bread_rye_loaf").setColors(0xFFFFFF).setTextureFood("bread_rye_loaf");
	public static FoodForItem bread_rolls = new FoodForItem("bread_rolls").setFoodStats(2, 0.2F).setName("bread_rolls").setColors(0xFFFFFF).setTextureFood("bread_rolls");
	public static FoodForItem breadcrumbs = new FoodForItem("breadcrumbs").setFoodStats(2, 0.2F).setName("breadcrumbs").setColors(0xFFFFFF).setTextureFood("breadcrumbs");
	public static FoodForItem waffle = new FoodForItem("waffle").setFoodStats(2, 0.2F).setName("waffle").setColors(0xFFFFFF).setTextureFood("waffle");
	public static FoodForItem waffle_cone = new FoodForItem("waffle_cone").setFoodStats(2, 0.2F).setName("waffle_cone").setColors(0xFFFFFF).setTextureFood("waffle_cone");
	public static FoodForItem ice_small = new FoodForItem("ice_small").setFoodStats(2, 0.2F).setName("ice_small").setColors(0xFFFFFF).setTextureFood("ice_small");
	public static FoodForItem icecream_ball = new FoodForItem("icecream_ball").setFoodStats(2, 0.2F).setName("icecream_ball").setColors(0xFFFFFF).setTextureFood("icecream_ball");
	public static FoodForItem icecream_waffle_cone = new FoodForItem("icecream_waffle_cone").setFoodStats(2, 0.2F).setName("icecream_waffle_cone").setColors(0xFFFFFF).setTextureFood("icecream_waffle_cone", "O");
	public static FoodForItem icecream_stick = new FoodForItem("icecream_stick").setFoodStats(2, 0.2F).setName("icecream_stick").setColors(0xFFFFFF).setTextureFood("icecream_stick", "O");
	public static FoodForItem icecream_plate = new FoodForItem("icecream_plate").setFoodStats(2, 0.2F).setName("icecream_plate").setColors(0xFFFFFF).setTextureFood("icecream_plate", "O");
	public static FoodForItem candy01 = new FoodForItem("candy01").setFoodStats(2, 0.2F).setName("candy01").setColors(0xFFFFFF).setTextureFood("candy01");
	public static FoodForItem lolipops01 = new FoodForItem("lolipops01").setFoodStats(2, 0.2F).setName("lolipops01").setColors(0xFFFFFF).setTextureFood("lolipops01", "O");
	public static FoodForItem lolipops02 = new FoodForItem("lolipops02").setFoodStats(2, 0.2F).setName("lolipops02").setColors(0xFFFFFF).setTextureFood("lolipops02", "O");
	public static FoodForItem egg_raw = new FoodForItem("egg_raw").setFoodStats(1, 0.2F).setName("egg_raw").setColors(0xFFFFFF).setTextureFood("egg_raw");
	public static FoodForItem egg_fried = new FoodForItem("egg_fried").setFoodStats(2, 0.2F).setName("egg_fried").setColors(0xFFFFFF).setTextureFood("egg_fried");
	public static FoodForItem egg_boiled = new FoodForItem("egg_boiled").setFoodStats(2, 0.2F).setName("egg_boiled").setColors(0xFFFFFF).setTextureFood("egg_boiled");
	public static FoodForItem chocobar = new FoodForItem("chocobar").setFoodStats(2, 0.2F).setName("chocobar").setColors(0xFFFFFF).setTextureFood("chocobar");
	public static FoodForItem cheese = new FoodForItem("cheese").setFoodStats(2, 0.2F).setName("cheese").setColors(0xFFFFFF).setTextureFood("cheese");
	public static FoodForItem cheese_part = new FoodForItem("cheese_part").setFoodStats(2, 0.2F).setName("cheese_part").setColors(0xFFFFFF).setTextureFood("cheese_part");

	public static FoodForItem cocoa_powder = new FoodForItem("cocoa_powder").setFoodStats(1, 0.0F).setName("cocoa_powder").setTextureFood("cocoa_powder");
	public static FoodForItem butter = new FoodForItem("butter").setFoodStats(2, 0.2F).setName("butter").setTextureFood("butter");
	public static FoodForItem nutella = new FoodForItem("nutella").setFoodStats(2, 0.2F).setName("nutella").setColors(0xFFFFFF).setTextureFood("nutella");

	public static FoodForItem sushi = new FoodForItem("sushi").setFoodStats(2, 0.2F).setName("sushi").setColors(0xFFFFFF).setTextureFood("sushi", "O");
	public static FoodForItem sushi_roll = new FoodForItem("sushi_roll").setFoodStats(2, 0.2F).setName("sushi_roll").setColors(0xFFFFFF).setTextureFood("sushi_roll");
	public static FoodForItem roll = new FoodForItem("roll").setFoodStats(2, 0.2F).setName("roll").setColors(0xFFFFFF).setTextureFood("roll");
	public static FoodForItem roll_red = new FoodForItem("roll_red").setFoodStats(2, 0.2F).setName("roll_red").setColors(0xFFFFFF, 0xFF0000).setTextureFood("roll", "O");
	public static FoodForItem roll_green = new FoodForItem("roll_green").setFoodStats(2, 0.2F).setName("roll_green").setColors(0xFFFFFF, 0x00FF00).setTextureFood("roll");
	public static FoodForItem roll_blue = new FoodForItem("roll_blue").setFoodStats(2, 0.2F).setName("roll_blue").setColors(0xFFFFFF, 0x0000FF).setTextureFood("roll", "O");

	public static FoodForItem frankfurter_stick_raw = new FoodForItem("frankfurter_stick_raw").setFoodStats(2, 0.2F).setName("frankfurter_stick_raw").setColors(0xFFFFFF).setTextureFood("frankfurter_stick_raw");
	public static FoodForItem frankfurter_stick_fried = new FoodForItem("frankfurter_stick_fried").setFoodStats(2, 0.2F).setName("frankfurter_stick_fried").setColors(0xBE7F7F).setTextureFood("frankfurter_stick_fried");
	public static FoodForItem frankfurter_stick_boiled = new FoodForItem("frankfurter_stick_boiled").setFoodStats(2, 0.2F).setName("frankfurter_stick_boiled").setColors(0xDEBEBE).setTextureFood("frankfurter_stick_boiled");
	public static FoodForItem sausage = new FoodForItem("sausage").setFoodStats(2, 0.2F).setName("sausage").setColors(0xFFFFFF).setTextureFood("sausage");
	public static FoodForItem hotdog = new FoodForItem("hotdog").setFoodStats(2, 0.2F).setName("hotdog").setColors(0xFFFFFF).setTextureFood("hotdog");
	public static FoodForItem corndog_raw = new FoodForItem("corndog_raw").setFoodStats(2, 0.2F).setName("corndog_raw").setColors(0xFFFFFF).setTextureFood("corndog_raw");
	public static FoodForItem corndog_fried = new FoodForItem("corndog_fried").setFoodStats(2, 0.2F).setName("corndog_fried").setColors(0xFFFFFF).setTextureFood("corndog_fried");
	public static FoodForItem corndog_stick_raw = new FoodForItem("corndog_stick_raw").setFoodStats(2, 0.2F).setName("corndog_stick_raw").setColors(0xFFFFFF).setTextureFood("corndog_stick_raw");
	public static FoodForItem corndog_stick_fried = new FoodForItem("corndog_stick_fried").setFoodStats(2, 0.2F).setName("corndog_stick_fried").setColors(0xFFFFFF).setTextureFood("corndog_stick_fried");

	public static FoodForItem sandwich_beef_fried = new FoodForItem("sandwich_beef_fried").setFoodStats(2, 0.2F).setName("sandwich_beef_fried").setColors(0xFFFFFF).setTextureFood("sandwich_beef_fried");
	public static FoodForItem sandwich_carrot = new FoodForItem("sandwich_carrot").setFoodStats(2, 0.2F).setName("sandwich_carrot").setColors(0xFFFFFF).setTextureFood("sandwich_carrot");
	public static FoodForItem sandwich_chiken_fried = new FoodForItem("sandwich_chiken_fried").setFoodStats(2, 0.2F).setName("sandwich_chiken_fried").setColors(0xFFFFFF).setTextureFood("sandwich_chiken_fried");
	public static FoodForItem sandwich_fish = new FoodForItem("sandwich_fish").setFoodStats(2, 0.2F).setName("sandwich_fish").setColors(0xFFFFFF).setTextureFood("sandwich_fish");
	public static FoodForItem sandwich_porkchop_fried = new FoodForItem("sandwich_porkchop_fried").setFoodStats(2, 0.2F).setName("sandwich_porkchop_fried").setColors(0xFFFFFF).setTextureFood("sandwich_porkchop_fried");
	public static FoodForItem sandwich_potato = new FoodForItem("sandwich_potato").setFoodStats(2, 0.2F).setName("sandwich_potato").setColors(0xFFFFFF).setTextureFood("sandwich_potato");
	public static FoodForItem sandwich_rotten_flesh = new FoodForItem("sandwich_rotten_flesh").setFoodStats(2, 0.2F).setName("sandwich_rotten_flesh").setColors(0xFFFFFF).setTextureFood("sandwich_rotten_flesh");

	public static FoodForItem sandwich_dual_beef_fried = new FoodForItem("sandwich_dual_beef_fried").setFoodStats(2, 0.2F).setName("sandwich_beef_fried").setColors(0xFFFFFF).setTextureFood("sandwich_dual_beef_fried");
	public static FoodForItem sandwich_dual_carrot = new FoodForItem("sandwich_dual_carrot").setFoodStats(2, 0.2F).setName("sandwich_carrot").setColors(0xFFFFFF).setTextureFood("sandwich_dual_carrot");
	public static FoodForItem sandwich_dual_chiken_fried = new FoodForItem("sandwich_dual_chiken_fried").setFoodStats(2, 0.2F).setName("sandwich_chiken_fried").setColors(0xFFFFFF).setTextureFood("sandwich_dual_chiken_fried");
	public static FoodForItem sandwich_dual_fish = new FoodForItem("sandwich_dual_fish").setFoodStats(2, 0.2F).setName("sandwich_fish").setColors(0xFFFFFF).setTextureFood("sandwich_dual_fish");
	public static FoodForItem sandwich_dual_porkchop_fried = new FoodForItem("sandwich_dual_porkchop_fried").setFoodStats(2, 0.2F).setName("sandwich_porkchop_fried").setColors(0xFFFFFF).setTextureFood("sandwich_dual_porkchop_fried");
	public static FoodForItem sandwich_dual_potato = new FoodForItem("sandwich_dual_potato").setFoodStats(2, 0.2F).setName("sandwich_potato").setColors(0xFFFFFF).setTextureFood("sandwich_dual_potato");
	public static FoodForItem sandwich_dual_rotten_flesh = new FoodForItem("sandwich_dual_rotten_flesh").setFoodStats(2, 0.2F).setName("sandwich_rotten_flesh").setColors(0xFFFFFF).setTextureFood("sandwich_dual_rotten_flesh");

	public static FoodForItem burger = new FoodForItem("burger").setFoodStats(2, 0.3F).setName("burger").setColors(0xFFFFFF).setTextureFood("burger");
	public static FoodForItem burger_meat_beef = new FoodForItem("burger_meat_beef").setFoodStats(5, 0.5F).setName("burger_meat_beef").setColors(0xFFFFFF).setTextureFood("burger_meat_beef");
	public static FoodForItem burger_meat_chicken = new FoodForItem("burger_meat_chicken").setFoodStats(5, 0.5F).setName("burger_meat_chicken").setColors(0xFFFFFF).setTextureFood("burger_meat_chicken");
	public static FoodForItem burger_meat_mutton = new FoodForItem("burger_meat_mutton").setFoodStats(5, 0.5F).setName("burger_meat_mutton").setColors(0xFFFFFF).setTextureFood("burger_meat_mutton");
	public static FoodForItem burger_meat_goat = new FoodForItem("burger_meat_goat").setFoodStats(5, 0.5F).setName("burger_meat_goat").setColors(0xFFFFFF).setTextureFood("burger_meat_goat");
	public static FoodForItem burger_meat_pork = new FoodForItem("burger_meat_pork").setFoodStats(5, 0.5F).setName("burger_meat_pork").setColors(0xFFFFFF).setTextureFood("burger_meat_pork");
	public static FoodForItem burger_meat_horse = new FoodForItem("burger_meat_horse").setFoodStats(5, 0.5F).setName("burger_meat_horse").setColors(0xFFFFFF).setTextureFood("burger_meat_horse");
	public static FoodForItem burger_meat_squid = new FoodForItem("burger_meat_squid").setFoodStats(5, 0.5F).setName("burger_meat_squid").setColors(0xFFFFFF).setTextureFood("burger_meat_squid");
	public static FoodForItem burger_meat_fish = new FoodForItem("burger_meat_fish").setFoodStats(5, 0.5F).setName("burger_meat_fish").setColors(0xFFFFFF).setTextureFood("burger_meat_fish");
	public static FoodForItem burger_cheese = new FoodForItem("burger_cheese").setFoodStats(3, 0.35F).setName("burger_cheese").setColors(0xFFFFFF).setTextureFood("burger_cheese");
	public static FoodForItem burger_tomato = new FoodForItem("burger_tomato").setFoodStats(2, 0.3F).setName("burger_tomato").setColors(0xFFFFFF).setTextureFood("burger_tomato");
	public static FoodForItem burger_lettuce = new FoodForItem("burger_lettuce").setFoodStats(2, 0.2F).setName("burger_lettuce").setColors(0xFFFFFF).setTextureFood("burger_lettuce");

	public static FoodForItem pie_part = new FoodForItem("pie_part").setFoodStats(2, 0.2F).setName("pie_part").setColors(0xFFFFFF, 0xFFFFFF).setTextureFood("pie_part", "O");
	/*
	public static FoodForItem pie_red_part = new FoodForItem("pie_red_part").setFoodStats(2, 0.2F).setName("pie_red_part").setColors(0xFFFFFF, 0xFF0000).setTextureFood("pie_part", "O");
	public static FoodForItem pie_green_part = new FoodForItem("pie_green_part").setFoodStats(2, 0.2F).setName("pie_green_part").setColors(0xFFFFFF, 0x00FF00).setTextureFood("pie_part", "O");
	public static FoodForItem pie_blue_part = new FoodForItem("pie_blue_part").setFoodStats(2, 0.2F).setName("pie_blue_part").setColors(0xFFFFFF, 0x0000FF).setTextureFood("pie_part", "O");
	 */
	public static FoodForItem pizza_part = new FoodForItem("pizza_part").setFoodStats(2, 0.2F).setName("pizza_part").setColors(0xFFFFFF, 0xFFFFFF).setTextureFood("pizza_part", "O");
	/*
	public static FoodForItem pizza_red_part = new FoodForItem("pizza_red_part").setFoodStats(2, 0.2F).setName("pizza_red_part").setColors(0xFFFFFF, 0xFF0000).setTextureFood("pizza_part", "O");
	public static FoodForItem pizza_green_part = new FoodForItem("pizza_green_part").setFoodStats(2, 0.2F).setName("pizza_green_part").setColors(0xFFFFFF, 0x00FF00).setTextureFood("pizza_part", "O");
	public static FoodForItem pizza_blue_part = new FoodForItem("pizza_blue_part").setFoodStats(2, 0.2F).setName("pizza_blue_part").setColors(0xFFFFFF, 0x0000FF).setTextureFood("pizza_part", "O");
	 */
	public static FoodForItem sugar_stick_white = new FoodForItem("sugar_stick_white").setFoodStats(2, 0.2F).setName("sugar_stick_white").setColors(0xFFFFFF).setTextureFood("sugar_stick01", "O");
	public static FoodForItem boiled_sugar = new FoodForItem("boiled_sugar").setFoodStats(2, 0.2F).setName("boiled_sugar").setColors(0xFFFFFF).setTextureFood("boiled_sugar");
	public static FoodForItem cotton_candy = new FoodForItem("cotton_candy").setFoodStats(2, 0.2F).setName("cotton_candy").setColors(0xFFFFFF).setTextureFood("cotton_candy");
	public static FoodForItem cotton_candy_stick = new FoodForItem("cotton_candy_stick").setFoodStats(2, 0.2F).setName("cotton_candy_stick").setColors(0xFFFFFF).setTextureFood("cotton_candy_stick", "O");
	public static FoodForItem marshmallow_raw_stick = new FoodForItem("marshmallow_raw_stick").setFoodStats(2, 0.2F).setName("marshmallow_raw_stick").setColors(0xFFFFFF).setTextureFood("marshmallow_raw_stick", "O");
	public static FoodForItem marshmallow_fried_stick = new FoodForItem("marshmallow_fried_stick").setFoodStats(2, 0.2F).setName("marshmallow_fried_stick").setColors(0xCC9944).setTextureFood("marshmallow_fried_stick", "O");
	public static FoodForItem taco = new FoodForItem("taco").setFoodStats(2, 0.2F).setName("taco").setColors(0xFFFFFF).setTextureFood("taco");
	public static FoodForItem kebab = new FoodForItem("kebab").setFoodStats(2, 0.2F).setName("kebab").setColors(0xFFFFFF).setTextureFood("kebab");
	public static FoodForItem toast = new FoodForItem("toast").setFoodStats(2, 0.2F).setName("toast").setColors(0xFFFFFF).setTextureFood("toast");
	public static FoodForItem toast_butter = new FoodForItem("toast_butter").setFoodStats(2, 0.2F).setName("toast_butter").setColors(0xFFFFFF).setTextureFood("toast");
	public static FoodForItem toast_nutella = new FoodForItem("toast_nutella").setFoodStats(2, 0.2F).setName("toast_nutella").setColors(0xFFFFFF).setTextureFood("toast");
	public static FoodForItem cookie = new FoodForItem().setFoodStats(2, 0.2F).setName("cookie").setColors(0xFFFFFF).setTextureFood("cookie");
	/*
	public static FoodForItem test1 = new FoodForItem("test1").setFoodStats(2, 0.2F).setName("cookie").setColors(0xFFFFFF).setTexture("test_1", "O");
	public static FoodForItem test2 = new FoodForItem("test2").setFoodStats(2, 0.2F).setName("cookie").setColors(0xFFFFFF).setTextureFood("test_1", "O");
	 */
	/*---	---*/
}
