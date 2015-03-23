package timaxa007.pack.stock.lib.list;

import timaxa007.pack.stock.lib.FoodForBlock;
import timaxa007.pack.stock.lib.FoodForItem;
import timaxa007.pack.stock.lib.GerminationPlants;
import timaxa007.tms.lib.FluidFake;

public class Wheat {
	//--GerminationPlants-------------------------------------------------------------------------------------------
	public static GerminationPlants crop_wheat = new GerminationPlants("crop_wheat").setName("wheat").setType("Crop").setTexture("wheat").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	//--FoodForItem-------------------------------------------------------------------------------------------------
	//public static FoodForItem food_wheats = new FoodForItem("wheats").beListVegetable("wheat");
/*
	public static FoodForItem food_roasted_seeds_wheat = new FoodForItem("roasted_seeds_wheat").setFoodStats(1, 0.1F).setName("roasted_seeds_wheat").setColors(0xFFFFFF).setTexture("seeds_wheat");
	public static FoodForItem food_wheat_raw = new FoodForItem("wheat_raw").setFoodStats(2, 0.2F).setName("wheat_raw").setColors(0xFFFFFF).setTexture("wheat_raw");
	public static FoodForItem food_wheat_fried = new FoodForItem("wheat_fried").setFoodStats(2, 0.25F).setName("wheat_fried").setColors(0xFFFFFF).setTexture("wheat_fried");
	public static FoodForItem food_wheat_boiled = new FoodForItem("wheat_boiled").setFoodStats(2, 0.23F).setName("wheat_boiled").setColors(0xFFFFFF).setTexture("wheat_boiled");
	public static FoodForItem food_wheat_dried = new FoodForItem("wheat_dried").setFoodStats(2, 0.23F).setName("wheat_dried").setColors(0xFFFFFF).setTexture("wheat_dried");

	public static FoodForItem food_pie_wheat_raw_part = new FoodForItem("pie_wheat_raw_part").setFoodStats(2, 0.2F).setName("pie_wheat_raw_part").setColors(0xFFFFFF, 0xFF0000).setTextureFood("pie_part", "O");
	public static FoodForItem food_pie_wheat_cooked_part = new FoodForItem("pie_wheat_cooked_part").setFoodStats(2, 0.2F).setName("pie_wheat_cooked_part").setColors(0xBE7F7F, 0xFF0000).setTextureFood("pie_part", "O");
	public static FoodForItem food_pie_jam_wheat_raw_part = new FoodForItem("pie_jam_wheat_raw_part").setFoodStats(2, 0.2F).setName("pie_jam_wheat_raw_part").setColors(0xFFFFFF, 0xFF0000).setTextureFood("pie_part", "O");
	public static FoodForItem food_pie_jam_wheat_cooked_part = new FoodForItem("pie_jam_wheat_cooked_part").setFoodStats(2, 0.2F).setName("pie_jam_wheat_cooked_part").setColors(0xBE7F7F, 0xFF0000).setTextureFood("pie_part", "O");
	public static FoodForItem food_pie_jelly_wheat_raw_part = new FoodForItem("pie_jelly_wheat_raw_part").setFoodStats(2, 0.2F).setName("pie_jelly_wheat_raw_part").setColors(0xFFFFFF, 0xFF0000).setTextureFood("pie_part", "O");
	public static FoodForItem food_pie_jelly_wheat_cooked_part = new FoodForItem("pie_jelly_wheat_cooked_part").setFoodStats(2, 0.2F).setName("pie_jelly_wheat_cooked_part").setColors(0xBE7F7F, 0xFF0000).setTextureFood("pie_part", "O");

	public static FoodForItem food_pizza_wheat_raw_part = new FoodForItem("pizza_wheat_raw_part").setFoodStats(2, 0.2F).setName("pizza_wheat_raw_part").setColors(0xFFFFFF, 0xFF0000).setTextureFood("pizza_part", "O");
	public static FoodForItem food_pizza_jam_wheat_raw_part = new FoodForItem("pizza_jam_wheat_raw_part").setFoodStats(2, 0.2F).setName("pizza_jam_wheat_raw_part").setColors(0xFFFFFF, 0xFF0000).setTextureFood("pizza_part", "O");
	public static FoodForItem food_pizza_jelly_wheat_raw_part = new FoodForItem("pizza_jelly_wheat_raw_part").setFoodStats(2, 0.2F).setName("pizza_jelly_wheat_raw_part").setColors(0xFFFFFF, 0xFF0000).setTextureFood("pizza_part", "O");
	public static FoodForItem food_pizza_wheat_cooked_part = new FoodForItem("pizza_wheat_cooked_part").setFoodStats(2, 0.2F).setName("pizza_wheat_cooked_part").setColors(0xBE7F7F, 0xFF0000).setTextureFood("pizza_part", "O");
	public static FoodForItem food_pizza_jam_wheat_cooked_part = new FoodForItem("pizza_jam_wheat_cooked_part").setFoodStats(2, 0.2F).setName("pizza_jam_wheat_cooked_part").setColors(0xBE7F7F, 0xFF0000).setTextureFood("pizza_part", "O");
	public static FoodForItem food_pizza_jelly_wheat_cooked_part = new FoodForItem("pizza_jelly_wheat_cooked_part").setFoodStats(2, 0.2F).setName("pizza_jelly_wheat_cooked_part").setColors(0xBE7F7F, 0xFF0000).setTextureFood("pizza_part", "O");

	public static FoodForItem food_cookie_wheat_raw = new FoodForItem("cookie_wheat_raw").setFoodStats(1, 0.2F).setName("cookie_wheat_raw").setColors(0xF1D598, 0xFF0000).setTextureFood("cookie", "O");
	public static FoodForItem food_cookie_wheat_cooked = new FoodForItem("cookie_wheat_cooked").setFoodStats(2, 0.2F).setName("cookie_wheat_cooked").setColors(0xE79042, 0xFF0000).setTextureFood("cookie", "O");
	public static FoodForItem food_cookie_jam_wheat_raw = new FoodForItem("cookie_jam_wheat_raw").setFoodStats(1, 0.2F).setName("cookie_jam_wheat_raw").setColors(0xF1D598, 0xFF0000).setTextureFood("cookie", "O");
	public static FoodForItem food_cookie_jam_wheat_cooked = new FoodForItem("cookie_jam_wheat_cooked").setFoodStats(2, 0.2F).setName("cookie_jam_wheat_cooked").setColors(0xE79042, 0xFF0000).setTextureFood("cookie", "O");
	public static FoodForItem food_cookie_jelly_wheat_raw = new FoodForItem("cookie_jelly_wheat_raw").setFoodStats(1, 0.2F).setName("cookie_jelly_wheat_raw").setColors(0xF1D598, 0xFF0000).setTextureFood("cookie", "O");
	public static FoodForItem food_cookie_jelly_wheat_cooked = new FoodForItem("cookie_jelly_wheat_cooked").setFoodStats(2, 0.2F).setName("cookie_jelly_wheat_cooked").setColors(0xE79042, 0xFF0000).setTextureFood("cookie", "O");

	public static FoodForItem food_cupcake_wheat_raw = new FoodForItem("cupcake_wheat_raw").setFoodStats(1, 0.2F).setName("cupcake_wheat_raw").setColors(0xD9D481, 0xFF0000).setTextureFood("cupcake_02", "O");
	public static FoodForItem food_cupcake_wheat_fried = new FoodForItem("cupcake_wheat_fried").setFoodStats(2, 0.25F).setName("cupcake_wheat_fried").setColors(0xBB9949, 0xFF0000).setTextureFood("cupcake_02", "O");
	public static FoodForItem food_cupcake_jam_wheat_raw = new FoodForItem("cupcake_jam_wheat_raw").setFoodStats(1, 0.2F).setName("cupcake_jam_wheat_raw").setColors(0xD9D481, 0xFF0000).setTextureFood("cupcake_02", "O");
	public static FoodForItem food_cupcake_jam_wheat_fried = new FoodForItem("cupcake_jam_wheat_fried").setFoodStats(2, 0.25F).setName("cupcake_jam_wheat_fried").setColors(0xBB9949, 0xFF0000).setTextureFood("cupcake_02", "O");
	public static FoodForItem food_cupcake_jelly_wheat_raw = new FoodForItem("cupcake_jelly_wheat_raw").setFoodStats(1, 0.2F).setName("cupcake_jelly_wheat_raw").setColors(0xD9D481, 0xFF0000).setTextureFood("cupcake_02", "O");
	public static FoodForItem food_cupcake_jelly_wheat_fried = new FoodForItem("cupcake_jelly_wheat_fried").setFoodStats(2, 0.25F).setName("cupcake_jelly_wheat_fried").setColors(0xBB9949, 0xFF0000).setTextureFood("cupcake_02", "O");

	public static FoodForItem food_pancake_jam_wheat = new FoodForItem("pancake_jam_wheat").setFoodStats(2, 0.2F).setName("pancake_jam_wheat").setColors(0xBB9949, 0xFF0000).setTextureFood("pancake", "O");
	public static FoodForItem food_pancake_jelly_wheat = new FoodForItem("pancake_jelly_wheat").setFoodStats(2, 0.2F).setName("pancake_jelly_wheat").setColors(0xBB9949, 0xFF0000).setTextureFood("pancake", "O");

	public static FoodForItem food_doughnut_jam_wheat_cooked = new FoodForItem("doughnut_jam_wheat_cooked").setFoodStats(3, 0.3F).setName("doughnut_jam_wheat_cooked").setColors(0xBB9949, 0xFF0000).setTextureFood("doughnut_cooked", "O");
	public static FoodForItem food_doughnut_jelly_wheat_cooked = new FoodForItem("doughnut_jelly_wheat_cooked").setFoodStats(3, 0.3F).setName("doughnut_jelly_wheat_cooked").setColors(0xBB9949, 0xFF0000).setTextureFood("doughnut_cooked", "O");

	public static FoodForItem food_bun_wheat_raw = new FoodForItem("bun_wheat_raw").setFoodStats(2, 0.2F).setName("bun_wheat_raw").setColors(0xD9D481, 0xFF0000).setTextureFood("bun_raw", "O");
	public static FoodForItem food_bun_wheat_cooked = new FoodForItem("bun_wheat_cooked").setFoodStats(3, 0.3F).setName("bun_wheat_cooked").setColors(0xBB9949, 0xFF0000).setTextureFood("bun_cooked", "O");
	public static FoodForItem food_bun_jam_wheat_raw = new FoodForItem("bun_jam_wheat_raw").setFoodStats(2, 0.2F).setName("bun_jam_wheat_raw").setColors(0xD9D481, 0xFF0000).setTextureFood("bun_raw", "O");
	public static FoodForItem food_bun_jam_wheat_cooked = new FoodForItem("bun_jam_wheat_cooked").setFoodStats(3, 0.3F).setName("bun_jam_wheat_cooked").setColors(0xBB9949, 0xFF0000).setTextureFood("bun_cooked", "O");
	public static FoodForItem food_bun_jelly_wheat_raw = new FoodForItem("bun_jelly_wheat_raw").setFoodStats(2, 0.2F).setName("bun_jelly_wheat_raw").setColors(0xD9D481, 0xFF0000).setTextureFood("bun_raw", "O");
	public static FoodForItem food_bun_jelly_wheat_cooked = new FoodForItem("bun_jelly_wheat_cooked").setFoodStats(3, 0.3F).setName("bun_jelly_wheat_cooked").setColors(0xBB9949, 0xFF0000).setTextureFood("bun_cooked", "O");

	public static FoodForItem food_roll_wheat = new FoodForItem("roll_wheat").setFoodStats(1, 0.2F).setName("roll_wheat").setColors(0xFFFFFF, 0xFF0000).setTextureFood("roll", "O");
	public static FoodForItem food_roll_jam_wheat = new FoodForItem("roll_jam_wheat").setFoodStats(1, 0.2F).setName("roll_jam_wheat").setColors(0xFFFFFF, 0xFF0000).setTextureFood("roll", "O");
	public static FoodForItem food_roll_jelly_wheat = new FoodForItem("roll_jelly_wheat").setFoodStats(1, 0.2F).setName("roll_jelly_wheat").setColors(0xFFFFFF, 0xFF0000).setTextureFood("roll", "O");

	public static FoodForItem food_sandwich_jam_wheat = new FoodForItem("sandwich_jam_wheat").setFoodStats(2, 0.25F).setName("sandwich_jam_wheat").setColors(0xFFFFFF, 0xFF0000).setTextureFood("bread01", "O");
	public static FoodForItem food_sandwich_jelly_wheat = new FoodForItem("sandwich_jelly_wheat").setFoodStats(2, 0.25F).setName("sandwich_jelly_wheat").setColors(0xFFFFFF, 0xFF0000).setTextureFood("bread01", "O");
	public static FoodForItem food_sandwich_dual_jam_wheat = new FoodForItem("sandwich_dual_jam_wheat").setFoodStats(3, 0.3F).setName("sandwich_jam_wheat").setColors(0xFFFFFF, 0xFF0000).setTextureFood("sandwich_dual", "O");
	public static FoodForItem food_sandwich_dual_jelly_wheat = new FoodForItem("sandwich_dual_jelly_wheat").setFoodStats(3, 0.3F).setName("sandwich_jelly_wheat").setColors(0xFFFFFF, 0xFF0000).setTextureFood("sandwich_dual", "O");

	public static FoodForItem food_icecream_wheat_ball = new FoodForItem("icecream_wheat_ball").setFoodStats(2, 0.2F).setName("icecream_wheat_ball").setColors(0xFF0000).setTextureFood("icecream_ball");
	public static FoodForItem food_icecream_wheat_waffle_cone = new FoodForItem("icecream_wheat_waffle_cone").setFoodStats(2, 0.2F).setName("icecream_wheat_waffle_cone").setColors(0xFF0000).setTextureFood("icecream_waffle_cone", "O");
	public static FoodForItem food_icecream_wheat_stick = new FoodForItem("icecream_wheat_stick").setFoodStats(2, 0.2F).setName("icecream_wheat_stick").setColors(0xFF0000).setTextureFood("icecream_stick", "O");
	public static FoodForItem food_icecream_wheat_plate = new FoodForItem("icecream_wheat_plate").setFoodStats(2, 0.2F).setName("icecream_wheat_plate").setColors(0xFF0000).setTextureFood("icecream_plate", "O");

	public static FoodForItem food_caramel_wheat = new FoodForItem("caramel_wheat").setFoodStats(2, 0.2F).setName("caramel_wheat").setColors(0xFFFFFF).setTextureFood("caramel_wheat");
	//--FoodForBlock-----------------------------------------------------------------------------------
	public static FoodForBlock food_wheat_cake_raw = new FoodForBlock("wheat_cake_raw").setFoodStats(2, 0.2F).setType("Cake").setName("wheat_cake_raw").setColors(0xFFFFFF).setTexture1("wheat_cake");
	public static FoodForBlock food_wheat_cake_cooked = new FoodForBlock("wheat_cake_cooked").setFoodStats(2, 0.2F).setType("Cake").setName("wheat_cake_cooked").setColors(0xFFFFFF).setTexture1("wheat_cake");

	public static FoodForBlock food_wheat_pie_raw = new FoodForBlock("wheat_pie_raw").setFoodStats(2, 0.2F).setType("Pie").setName("wheat_pie_raw").setColors(0xFFFFFF).setTexture1("wheat_pie");
	public static FoodForBlock food_wheat_pie_cooked = new FoodForBlock("wheat_pie_cooked").setFoodStats(2, 0.2F).setType("Pie").setName("wheat_pie_cooked").setColors(0xFFFFFF).setTexture1("wheat_pie");

	public static FoodForBlock food_wheat_pizza_raw = new FoodForBlock("wheat_pizza_raw").setFoodStats(2, 0.2F).setType("Pizza").setName("wheat_pizza_raw").setColors(0xFFFFFF).setTexture1("wheat_pizza");
	public static FoodForBlock food_wheat_pizza_cooked = new FoodForBlock("wheat_pizza_cooked").setFoodStats(2, 0.2F).setType("Pizza").setName("wheat_pizza_cooked").setColors(0xFFFFFF).setTexture1("wheat_pizza");
*/
	//--FluidFake----------------------------------------------------------------------------------------------------
/*
	public static FluidFake fluid_wheat_decoction = new FluidFake("wheat_decoction").setName("wheat_decoction").setType("Liquid").setColorMix(0xFF0000, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
	public static FluidFake fluid_wheat_tea = new FluidFake("wheat_tea").setName("wheat_tea").setType("Liquid").setColorMix(0xFF0000, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 80.0F);
	public static FluidFake fluid_wheat_juice = new FluidFake("wheat_juice").setName("wheat_juice").setType("Liquid").setColor(0xFF0000).setTemperatures(16.0F, -16.0F, 100.0F);
	public static FluidFake fluid_wheat_juice_concentrate = new FluidFake("wheat_juice_concentrate").setName("wheat_juice_concentrate").setType("Liquid").setColor(0xFF0000).setTemperatures(16.0F, -16.0F, 100.0F);
	public static FluidFake fluid_wheat_lemonade = new FluidFake("wheat_lemonade").setName("wheat_lemonade").setType("Liquid").setColorMix(0xFF0000, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
	public static FluidFake fluid_wheat_milkshake = new FluidFake("wheat_milkshake").setName("wheat_milkshake").setType("Liquid").setColorMix(0xFF0000, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
	public static FluidFake fluid_wheat_tincture = new FluidFake("wheat_tincture").setName("wheat_tincture").setType("Liquid").setColorMix(0xFF0000, 0xAAAAFF).setTemperatures(16.0F, -16.0F, 100.0F);
	public static FluidFake fluid_wheat_sauce = new FluidFake("wheat_sauce").setName("wheat_sauce").setType("Sauce").setColor(0xFF0000).setTemperatures(16.0F, -16.0F, 100.0F);
	public static FluidFake fluid_wheat_jam = new FluidFake("wheat_jam").setName("wheat_jam").setType("Jam").setColorMix(0xFF0000, 0xBBBBBB).setTemperatures(16.0F, -16.0F, 100.0F);
	public static FluidFake fluid_wheat_jelly = new FluidFake("wheat_jelly").setName("wheat_jelly").setType("Jelly").setColorMix(0xFF0000, 0xAAAAAA).setTemperatures(16.0F, -16.0F, 100.0F);
	public static FluidFake fluid_wheat_flour = new FluidFake("wheat_flour").setName("wheat_flour").setType("Dust").setColorMix(0xFF0000, 0xFFFFFF).setTemperatures(16.0F, -16.0F, 100.0F);
	public static FluidFake fluid_wheat_oil = new FluidFake("wheat_oil").setName("wheat_oil").setType("Vegetable Oil").setColor(0xC2C832).setTemperatures(16.0F, -16.0F, 100.0F);
*/
}
