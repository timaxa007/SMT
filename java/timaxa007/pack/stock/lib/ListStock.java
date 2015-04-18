package timaxa007.pack.stock.lib;

import timaxa007.module.fluids.Fluids;

public class ListStock {

	public static final Fluids.TypeFluid vegetable_oil = new Fluids.TypeFluid("vegetable_oil");
	public static final Fluids.TypeFluid fat = new Fluids.TypeFluid("fat");
	public static final Fluids.TypeFluid sauce = new Fluids.TypeFluid("sauce");
	public static final Fluids.TypeFluid jam = new Fluids.TypeFluid("jam");
	public static final Fluids.TypeFluid jelly = new Fluids.TypeFluid("jelly");
	public static final Fluids.TypeFluid icecream = new Fluids.TypeFluid("icecream");

	public static final Fluids fluid_water_clear = new Fluids("water_clear").setName("water_clear").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_water_dirt = new Fluids("water_dirt").setName("water_dirt").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_water_salt = new Fluids("water_salt").setName("water_salt").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_water_sweet = new Fluids("water_sweet").setName("water_sweet").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_water_mineral = new Fluids("water_mineral").setName("water_mineral").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_water_reed = new Fluids("water_reed").setName("water_reed").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
/*
	public ListStock() {
		new Beef();
		FillForList.beListMeat("Beef", 0xCC291A);
		FillForList.beListMeatAnimal("Cow", 0xFF0000);
		FillForList.beListMilk("Cow", 0xFF0000);
		FillForList.beListMeatAnimal("Bull", 0xFF0000);
		FillForList.beListMeat("Veal", 0xFF0000);
		new Mutton();
		FillForList.beListMeat("Mutton", 0xE06147);
		FillForList.beListMeatAnimal("Sheep", 0xFF0000);
		FillForList.beListMilk("Sheep", 0xFF0000);
		FillForList.beListMeatAnimal("Ram", 0xFF0000);
		FillForList.beListMeat("Lamb", 0xFF0000);
		new Goat();
		FillForList.beListMeat("Goat", 0xFF0000);
		FillForList.beListMilk("Goat", 0xFF0000);
		new Pork();
		FillForList.beListMeat("Pork", 0xFF0000);
		FillForList.beListMilk("Pork", 0xFF0000);
		FillForList.beListMeatAnimal("Pig", 0xFF0000);
		new Horse();
		FillForList.beListMeat("Horse", 0xAF1400);
		FillForList.beListMilk("Horse", 0xFF0000);
		new Venison();
		FillForList.beListMeat("Venison", 0xFF0000);
		FillForList.beListMeatAnimal("Deer", 0xFF0000);
		FillForList.beListMilk("Deer", 0xFF0000);
		new Rabbit();
		FillForList.beListMeat("Rabbit", 0xFF0000);
		FillForList.beListMilk("Rabbit", 0xFF0000);
		new Bear();
		FillForList.beListMeat("Bear", 0xFF0000);
		FillForList.beListMilk("Bear", 0xFF0000);
		new Cat();
		FillForList.beListMeat("Cat", 0xFF0000);
		FillForList.beListMilk("Cat", 0xFF0000);
		new Dog();
		FillForList.beListMeat("Dog", 0xFF0000);
		FillForList.beListMilk("Dog", 0xFF0000);

		FillForList.beListMeat("Bird", 0xFF8800);
		new Chicken();
		FillForList.beListMeatBird("Chicken", 0xFFBFB2);
		new Duck();
		FillForList.beListMeatBird("Duck", 0xD8A297);
		new Turkey();
		FillForList.beListMeatBird("Turkey", 0xE59989);

		new Squid();
		FillForList.beListMeat("Squid", 0xFF0000);
		FillForList.beListMeatSeaAnimal("Squid", 0xFF0000);
		new Fish();
		FillForList.beListMeat("Fish", 0xFF0000);
		FillForList.beListMeatSeaAnimal("Fish", 0xFF0000);

		new Villager();
		new Player();
		new Zombie();
		new Skeleton();
		new Creeper();
		new Spider();
		new Blaze();
		new Enderman();

		//Cereals Crops
		new Wheat();FillForList.beListVegetable("Wheat", 0xFFFFFF);
		new Buckwheat();FillForList.beListVegetable("Buckwheat", 0xFFFFFF);
		new Millet();FillForList.beListVegetable("Millet", 0xFFFFFF);
		new Rice();FillForList.beListVegetable("Rice", 0xFFFFFF);
		new Barley();FillForList.beListVegetable("Barley", 0xFFFFFF);
		new Malt();FillForList.beListVegetable("Malt", 0xFFFFFF);
		new Rye();FillForList.beListVegetable("Rye", 0xFFFFFF);
		new Oat();FillForList.beListVegetable("Oat", 0xFFFFFF);
		new Spelt();FillForList.beListVegetable("Spelt", 0xFFFFFF);
		new Sorghum();FillForList.beListVegetable("Sorghum", 0xFFFFFF);
		new Broomcorn();FillForList.beListVegetable("Broomcorn", 0xFFFFFF);
		new Dagussa();FillForList.beListVegetable("Dagussa", 0xFFFFFF);

		new Corn();FillForList.beListVegetable("Corn", 0xFFFFFF);
		new Maize();FillForList.beListVegetable("Maize", 0xFFFFFF);
		//Legumes
		new Pea();FillForList.beListVegetable("Pea", 0xFFFFFF);
		new Bean();FillForList.beListVegetable("Bean", 0xFFFFFF);
		new Soybean();FillForList.beListVegetable("Soybean", 0xFFFFFF);
		new Lentils();FillForList.beListVegetable("Lentils", 0xFFFFFF);
		new Lupin();FillForList.beListVegetable("Lupin", 0xFFFFFF);
		new Chickpeas();FillForList.beListVegetable("Chickpeas", 0xFFFFFF);
		new Chin();FillForList.beListVegetable("Chin", 0xFFFFFF);

		new Sugarcane();FillForList.beListVegetable("Sugarcane", 0xFFFFFF);
		new Sunflower();FillForList.beListVegetable("Sunflower", 0xFFFFFF);
		new Raspberry();FillForList.beListVegetable("Raspberry", 0xFFFFFF);
		new Strawberry();FillForList.beListVegetable("Strawberry", 0xFFFFFF);
		new Blackberry();FillForList.beListVegetable("Blackberry", 0xFFFFFF);
		new Blueberry();FillForList.beListVegetable("Blueberry", 0xFFFFFF);
		new Cranberry();FillForList.beListVegetable("Cranberry", 0xFFFFFF);
		new Gooseberry();FillForList.beListVegetable("Gooseberry", 0xFFFFFF);
		new Currant();FillForList.beListVegetable("Currant", 0xFFFFFF);
		new Coffee();FillForList.beListVegetable("Coffee", 0xFFFFFF);
		new Tea();FillForList.beListVegetable("Tea", 0xFFFFFF);
		new Grape();FillForList.beListVegetable("Grape", 0xFFFFFF);
		new Pumpkin();FillForList.beListVegetable("Pumpkin", 0xFFFFFF);
		new WaterMelon();FillForList.beListVegetable("WaterMelon", 0xFFFFFF);
		new Melon();FillForList.beListVegetable("Melon", 0xFFFFFF);
		new Cantaloupe();FillForList.beListVegetable("Cantaloupe", 0xFFFFFF);
		new Eggplant();FillForList.beListVegetable("Eggplant", 0xFFFFFF);
		new Squash();FillForList.beListVegetable("Squash", 0xFFFFFF);
		new Pineapple();FillForList.beListVegetable("Pineapple", 0xFFFFFF);
		new Onion();FillForList.beListVegetable("Onion", 0xFFFFFF);
		new Garlic();FillForList.beListVegetable("Garlic", 0xFFFFFF);
		new Carrot();FillForList.beListVegetable("Carrot", 0xFFFFFF);
		new Potato();FillForList.beListVegetable("Potato", 0xFFFFFF);
		new Tomato();FillForList.beListVegetable("Tomato", 0xFFFFFF);
		new Cucumber();FillForList.beListVegetable("Cucumber", 0xFFFFFF);
		new Peppers();FillForList.beListVegetable("Peppers", 0xFFFFFF);
		new Beet();FillForList.beListVegetable("Beet", 0xFFFFFF);
		new Cabbage();FillForList.beListVegetable("Cabbage", 0xFFFFFF);
		new Turnip();FillForList.beListVegetable("Turnip", 0xFFFFFF);
		new Spinach();FillForList.beListVegetable("Spinach", 0xFFFFFF);
		new Leek();FillForList.beListVegetable("Leek", 0xFFFFFF);
		new Yam();FillForList.beListVegetable("Yam", 0xFFFFFF);
		new Asparagus();FillForList.beListVegetable("Asparagus", 0xFFFFFF);
		new Broccoli();FillForList.beListVegetable("Broccoli", 0xFFFFFF);
		new Celery();FillForList.beListVegetable("Celery", 0xFFFFFF);
		new Ginger();FillForList.beListVegetable("Ginger", 0xFFFFFF);
		new Lettuce();FillForList.beListVegetable("Lettuce", 0xFFFFFF);
		new Peanut();FillForList.beListVegetable("Peanut", 0xFFFFFF);
		new Radish();FillForList.beListVegetable("Radish", 0xFFFFFF);
		new Cauliflower();FillForList.beListVegetable("Cauliflower", 0xFFFFFF);
		new Parsnip();FillForList.beListVegetable("Parsnip", 0xFFFFFF);
		new Scallion();FillForList.beListVegetable("Scallion", 0xFFFFFF);
		new Mustard();FillForList.beListVegetable("Mustard", 0xFFFFFF);
		new Zucchini();FillForList.beListVegetable("Zucchini", 0xFFFFFF);
		new Kiwi();FillForList.beListVegetable("Kiwi", 0xFFFFFF);
		new Rhubarb();FillForList.beListVegetable("Rhubarb", 0xFFFFFF);
		new Rutabaga();FillForList.beListVegetable("Rutabaga", 0xFFFFFF);
		new Peppermint();FillForList.beListVegetable("Peppermint", 0xFFFFFF);
		new Reed();FillForList.beListVegetable("Reed", 0xFFFFFF);
		new Bamboo();FillForList.beListVegetable("Bamboo", 0xFFFFFF);
		new Seaweed();FillForList.beListVegetable("Seaweed", 0xFFFFFF);
		new Nettle();FillForList.beListVegetable("Nettle", 0xFFFFFF);
		new AloeVera();FillForList.beListVegetable("AloeVera", 0xFFFFFF);
		new Echinacea();FillForList.beListVegetable("Echinacea", 0xFFFFFF);
		new Fennel();FillForList.beListVegetable("Fennel", 0xFFFFFF);
		new Ginseng();FillForList.beListVegetable("Ginseng", 0xFFFFFF);
		new Jasmine();FillForList.beListVegetable("Jasmine", 0xFFFFFF);
		new Mandrake();FillForList.beListVegetable("Mandrake", 0xFFFFFF);
		new Rosemary();FillForList.beListVegetable("Rosemary", 0xFFFFFF);
		new Thyme();FillForList.beListVegetable("Thyme", 0xFFFFFF);
		new Turmeric();FillForList.beListVegetable("Turmeric", 0xFFFFFF);
		new Valerian();FillForList.beListVegetable("Valerian", 0xFFFFFF);

		new Apple();FillForList.beListVegetable("Apple", 0xFFFFFF);
		new Pear();FillForList.beListVegetable("Pear", 0xFFFFFF);
		new Peach();FillForList.beListVegetable("Peach", 0xFFFFFF);
		new Plum();FillForList.beListVegetable("Plum", 0xFFFFFF);
		new Orange();FillForList.beListVegetable("Orange", 0xFF6A00);
		new Lime();FillForList.beListVegetable("Lime", 0x4CFF00);
		new Lemon();FillForList.beListVegetable("Lemon", 0xFFD800);
		new Cacao();FillForList.beListVegetable("Cacao", 0x7F3300);
		new Cherry();FillForList.beListVegetable("Cherry", 0xCC1414);
		new Olive();FillForList.beListVegetable("Olive", 0xFFFFFF);
		new Avocado();FillForList.beListVegetable("Avocado", 0xFFFFFF);
		new Papaya();FillForList.beListVegetable("Papaya", 0xFFFFFF);
		new Pomegranate();FillForList.beListVegetable("Pomegranate", 0xFFFFFF);
		new Coconut();FillForList.beListVegetable("Coconut", 0xFFFFFF);
		new Banana();FillForList.beListVegetable("Banana", 0xFFFFFF);
		new Walnut();FillForList.beListVegetable("Walnut", 0xFFFFFF);
		new Nutmeg();FillForList.beListVegetable("Nutmeg", 0xFFFFFF);
		new Vanilla();FillForList.beListVegetable("Vanilla", 0xFFFFFF);
		new Starfruit();FillForList.beListVegetable("Starfruit", 0xFFFFFF);
		new Dragonfruit();FillForList.beListVegetable("Dragonfruit", 0xFFFFFF);
		new Seabuckthorn();FillForList.beListVegetable("Seabuckthorn", 0xFFFFFF);
		new Eucalyptus();FillForList.beListVegetable("Eucalyptus", 0xFFFFFF);
		new Ginko();FillForList.beListVegetable("Ginko", 0xFFFFFF);
		new Juniper();FillForList.beListVegetable("Juniper", 0xFFFFFF);
		new Myrrhae();FillForList.beListVegetable("Myrrhae", 0xFFFFFF);
		new Cinnamon();FillForList.beListVegetable("Cinnamon", 0xFFFFFF);

		new Birch();
		new Oak();
		new Spruce();
		new Pine();
		new Willow();
		new Maple();
		new Lipa();
		new Elm();
		new Larch();
		new Aspen();
		new Fir();
		new Poplar();
		new Ash();
		new Rowan();
		new Cedar();
		new Beech();
		new Chestnut();
		//Flowers
		new Tulips();FillForList.beListVegetable("Tulips", 0xFFFFFF);
		new Squill();FillForList.beListVegetable("Squill", 0xFFFFFF);
		new Carnation();FillForList.beListVegetable("Carnation", 0xFFFFFF);
		new Daisy();FillForList.beListVegetable("Daisy", 0xFFFFFF);
		new Hydrangea();FillForList.beListVegetable("Hydrangea", 0xFFFFFF);
		new Chamomile();FillForList.beListVegetable("Chamomile", 0xFFFFFF);
		new Aconite();FillForList.beListVegetable("Aconite", 0xFFFFFF);
		new Lavender();FillForList.beListVegetable("Lavender", 0xFFFFFF);
		new BlackRose();FillForList.beListVegetable("BlackRose", 0xFFFFFF);
		new Pansy();FillForList.beListVegetable("Pansy", 0xFFFFFF);
		new Dahlia();FillForList.beListVegetable("Dahlia", 0xFFFFFF);
		new Iris();FillForList.beListVegetable("Iris", 0xFFFFFF);
		new Bluebells();FillForList.beListVegetable("Bluebells", 0xFFFFFF);
		new Blowball();FillForList.beListVegetable("Blowball", 0xFFFFFF);
		new Gardenia();FillForList.beListVegetable("Gardenia", 0xFFFFFF);
		new Thistle();FillForList.beListVegetable("Thistle", 0xFFFFFF);
		new Orchid();FillForList.beListVegetable("Orchid", 0xFFFFFF);
		new Lily();FillForList.beListVegetable("Lily", 0xFFFFFF);
		new Foxglove();FillForList.beListVegetable("Foxglove", 0xFFFFFF);
		new Digitalis();FillForList.beListVegetable("Digitalis", 0xFFFFFF);
		new Peony();FillForList.beListVegetable("Peony", 0xFFFFFF);
		new Poppy();FillForList.beListVegetable("Poppy", 0xFFFFFF);
		//new Melon();//

		//Honey - cake, cookie u t.d.
	}
*/
	public static final Fluids fluid_catalyst_mix = new Fluids("catalyst_mix").setName("catalyst_mix").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_catalyst_sweet = new Fluids("catalyst_sweet").setName("catalyst_sweet").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);

	public static final Fluids fluid_ferment_mix = new Fluids("ferment_mix").setName("ferment_mix").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_ferment_sweet = new Fluids("ferment_sweet").setName("ferment_sweet").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_ferment_manure = new Fluids("ferment_manure").setName("ferment_manure").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_ferment_mineral = new Fluids("ferment_mineral").setName("ferment_mineral").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);

	public static final Fluids fluid_honey_mix = new Fluids("honey_mix").setName("honey").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_molten_chocolate = new Fluids("molten_chocolate").setName("molten_chocolate").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_molten_caramel = new Fluids("molten_caramel").setName("molten_caramel").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(32.0F);
	public static final Fluids fluid_molten_butter = new Fluids("molten_butter").setName("molten_butter").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_molten_nutella = new Fluids("molten_nutella").setName("molten_nutella").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_beer = new Fluids("beer").setName("beer").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_beer_dark = new Fluids("beer_dark").setName("beer_dark").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_beer_light = new Fluids("beer_light").setName("beer_light").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);

	public static final Fluids fluid_soy_sauce = new Fluids("soy_sauce").setName("soy_sauce").setType(sauce).setColor(0x5C2010).setTemperature(16.0F);
	public static final Fluids fluid_sauce_ketchup = new Fluids("sauce_ketchup").setName("sauce_ketchup").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_mayonnaise = new Fluids("sauce_mayonnaise").setName("sauce_mayonnaise").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_chilly = new Fluids("sauce_chilly").setName("sauce_chilly").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_hot = new Fluids("sauce_hot").setName("sauce_hot").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_tomato = new Fluids("sauce_tomato").setName("sauce_tomato").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_mustard = new Fluids("sauce_mustard").setName("sauce_mustard").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_horseradish = new Fluids("sauce_horseradish").setName("sauce_horseradish").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_sour_cream = new Fluids("sauce_sour_cream").setName("sauce_sour_cream").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_cream = new Fluids("sauce_cream").setName("sauce_cream").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_milky = new Fluids("sauce_milky").setName("sauce_milky").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_mushroom = new Fluids("sauce_mushroom").setName("sauce_mushroom").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_cheese = new Fluids("sauce_cheese").setName("sauce_cheese").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_vanilla = new Fluids("sauce_vanilla").setName("sauce_vanilla").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_chocolate = new Fluids("sauce_chocolate").setName("sauce_chocolate").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_lemon = new Fluids("sauce_lemon").setName("sauce_lemon").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_fruit = new Fluids("sauce_fruit").setName("sauce_fruit").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_sauce_berry = new Fluids("sauce_berry").setName("sauce_berry").setType(sauce).setColor(0xFFFFFF).setTemperature(16.0F);

	public static final Fluids fluid_cider = new Fluids("cider").setName("cider").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_wine = new Fluids("wine").setName("wine").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_moonshine = new Fluids("moonshine").setName("moonshine").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_vodka = new Fluids("vodka").setName("vodka").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_water_coffee = new Fluids("water_coffee").setName("water_coffee").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_water_cappuccino = new Fluids("water_cappuccino").setName("water_coffee").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_water_latte = new Fluids("water_latte").setName("water_coffee").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_water_tea = new Fluids("water_tea").setName("water_tea").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_cocoa_water = new Fluids("cocoa_water").setName("cocoa_water").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_cocoa_milk = new Fluids("cocoa_milk").setName("cocoa_milk").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_soda = new Fluids("soda").setName("soda").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_vinegar = new Fluids("vinegar").setName("vinegar").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_broth = new Fluids("broth").setName("broth").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_decoction = new Fluids("decoction").setName("decoction").setType(Fluids.TypeFluid.liquid).setColor(0xFFFFFF).setTemperature(16.0F);
	public static final Fluids fluid_condensed_milk = new Fluids("condensed_milk").setName("condensed_milk").setType(Fluids.TypeFluid.liquid).setColor(0xFFD9A5).setTemperature(16.0F);
	public static final Fluids fluid_beaten_egg = new Fluids("beaten_egg").setName("beaten_egg").setType(Fluids.TypeFluid.liquid).setColor(0xFFA9A9).setTemperature(16.0F);

	public static final Fluids fluid_sucrose = new Fluids("sucrose").setName("sucrose").setType(Fluids.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(8.0F);
	public static final Fluids fluid_glucose = new Fluids("glucose").setName("glucose").setType(Fluids.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(8.0F);
	public static final Fluids fluid_fructose = new Fluids("fructose").setName("fructose").setType(Fluids.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(8.0F);
	// glucose or fructose from fruit or berry
	public static final Fluids fluid_sugar_sand_cane = new Fluids("sugar_sand_cane").setName("sugar_sand_cane").setType(Fluids.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(8.0F);
	public static final Fluids fluid_sugar_sand_beet = new Fluids("sugar_sand_beet").setName("sugar_sand_beet").setType(Fluids.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(8.0F);
	public static final Fluids fluid_sugar_sand_maple = new Fluids("sugar_sand_maple").setName("sugar_sand_maple").setType(Fluids.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(8.0F);
	public static final Fluids fluid_sugar_sand_palm = new Fluids("sugar_sand_palm").setName("sugar_sand_palm").setType(Fluids.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(8.0F);
	public static final Fluids fluid_sugar_sand_sorghum = new Fluids("sugar_sand_sorghum").setName("sugar_sand_sorghum").setType(Fluids.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(8.0F);
	//public static final Fluids fluid_sugar_ = new Fluids("sugar_").setName("sugar_").setType(Fluids.TypeFluid.dust).setColor(0xFFFFFF).setTemperature(8.0F);
	// sugar_sand -> molten_caramel ->
	//Meat
	//Gas
	public static final Fluids fluid_gas_smoke_burned_food = new Fluids("gas_smoke_burned_food").setName("smoke_burned_food").setType(Fluids.TypeFluid.smoke).setColor(0xFFFFFF).setTemperature(18.0F);

	//Vegetable

	//Vegetable Oil 0xC2C832 - normal, 0xA7C832 - new, 0xC29332 - old.
	public static final Fluids fluid_palm_oil = new Fluids("palm_oil").setName("palm_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	//public static final Fluids fluid_cocoa_oil = new Fluids("cocoa_oil").setName("cocoa_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_coconut_oil = new Fluids("coconut_oil").setName("coconut_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_rape_oil = new Fluids("rape_oil").setName("rape_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_flax_oil = new Fluids("flax_oil").setName("flax_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_cottonseed_oil = new Fluids("cottonseed_oil").setName("cottonseed_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_apricot_oil = new Fluids("apricot_oil").setName("apricot_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_safflower_oil = new Fluids("safflower_oil").setName("safflower_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_pistachio_oil = new Fluids("pistachio_oil").setName("pistachio_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_sesame_oil = new Fluids("sesame_oil").setName("sesame_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_hemp_oil = new Fluids("hemp_oil").setName("hemp_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_cedar_oil = new Fluids("cedar_oil").setName("cedar_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_camellia_oil = new Fluids("camellia_oil").setName("camellia_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_rosehip_oil = new Fluids("rosehip_oil").setName("rosehip_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_borage_oil = new Fluids("borage_oil").setName("borage_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);
	public static final Fluids fluid_blackcurrant_oil = new Fluids("blackcurrant_oil").setName("blackcurrant_oil").setType(vegetable_oil).setColor(0xC2C832).setTemperature(16.0F);

}
