package timaxa007.pack.stock.config;

import java.io.File;

import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import timaxa007.pack.stock.PackStock;
import timaxa007.smt.Config;

public class ConfigStock {
	//--------------------------------------------------------------------------------------------------------------
	public static String is_drop_vanilla_flowers;
	public static String is_difficulty_level_plants;
	//--------------------------------------------------------------------------------------------------------------
	public static void main() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackStock.MODID, "main.cfg"));
		cfg.load();
		//----------------------------------------------------------------------------------------------------------
		PackStock.block.stock_machines_be = cfg.get("block", "stock_machines", true).getBoolean();
		PackStock.block.plants_be = cfg.get("block", "plants", true).getBoolean();
		PackStock.block.foods_be = cfg.get("block", "foods", true).getBoolean();
		PackStock.block.apiary_be = cfg.get("block", "apiary", true).getBoolean();
		PackStock.block.petalled_be = cfg.get("block", "petalled", true).getBoolean();
		//----------------------------------------------------------------------------------------------------------
		PackStock.item.items_for_stock_be = cfg.get("item", "items_for_stock", true).getBoolean();
		PackStock.item.plants_be = cfg.get("item", "plants", true).getBoolean();
		PackStock.item.nature_product_be = cfg.get("item", "nature_product", true).getBoolean();
		PackStock.item.foods_be = cfg.get("item", "foods", true).getBoolean();
		PackStock.item.drinks_be = cfg.get("item", "drinks", true).getBoolean();
		PackStock.item.medicals_be = cfg.get("item", "medicals", true).getBoolean();
		PackStock.item.honeycombs_be = cfg.get("item", "honeycombs", true).getBoolean();
		PackStock.item.bee_products_be = cfg.get("item", "bee_products", true).getBoolean();
		PackStock.item.bees_be = cfg.get("item", "bees", true).getBoolean();
		PackStock.item.petals_be = cfg.get("item", "petals", true).getBoolean();
		PackStock.item.fuel_jetpack_be = cfg.get("item", "fuel_jetpack", true).getBoolean();
		//PackStock.item.food_dog_be = cfg.get("item", "food_dog", true).getBoolean();
		//----------------------------------------------------------------------------------------------------------
		cfg.save();
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void plants() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackStock.MODID, "plants.cfg"));
		cfg.load();

		is_difficulty_level_plants = Config.getProperty(cfg, "config", "difficulty_level", 
				"The difficulty level on Plants.\n"
						+ "<auto> - difficulty of the game on difficulty of World.\n"
						+ "<peaceful> - disabled: resistance to weeds and protection from trampling.\n"
						+ "<easy> - disabled: protection from trampling.\n"
						+ "<normal> - everything should work fine.\n"
						+ "<hard> - difficulty hard - twice as slow growing.\n", 
				"normal");

		cfg.save();
	}

	public static enum typeDifficulty {PEACEFUL,EASY,NORMAL,HARD,OTHER}
	public static typeDifficulty getTypeDifficulty(String str, World world) {
		str.toLowerCase();
		if (str.equals("auto")) {
			if (world.difficultySetting == EnumDifficulty.PEACEFUL) return typeDifficulty.PEACEFUL;
			else if (world.difficultySetting == EnumDifficulty.EASY) return typeDifficulty.EASY;
			else if (world.difficultySetting == EnumDifficulty.NORMAL) return typeDifficulty.NORMAL;
			else if (world.difficultySetting == EnumDifficulty.HARD) return typeDifficulty.HARD;
			else return typeDifficulty.OTHER;
		}
		else if (str.equals("peaceful")) return typeDifficulty.PEACEFUL;
		else if (str.equals("easy")) return typeDifficulty.EASY;
		else if (str.equals("normal")) return typeDifficulty.NORMAL;
		else if (str.equals("hard")) return typeDifficulty.HARD;
		else return typeDifficulty.OTHER;
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void drop_vanilla_flowers() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackStock.MODID, "drop_vanilla_flowers.cfg"));
		cfg.load();

		is_drop_vanilla_flowers = Config.getProperty(cfg, "config", "what_is_to_drop_of_vanilla_flowers", 
				"What is to drop of vanilla flowers?\n"
						+ "<default> - do not change drop in vanilla flowers.\n"
						+ "<vanilla_dye> - drop vanilla dye (not from the recipe, but in the recipe)-[with plus].\n"
						+ "<petals> - drop petals this mod, if there is [item.petals_be == true].", 
				"default");

		cfg.save();
	}

	public static enum typeDropVanillaFlowers {DEFAULT,VANILLA_DYE,PETALS,OTHER;}
	public static typeDropVanillaFlowers getDropVanillaFlowers() {
		if (is_drop_vanilla_flowers.equals("default")) return typeDropVanillaFlowers.DEFAULT;
		else if (is_drop_vanilla_flowers.equals("vanilla_dye")) return typeDropVanillaFlowers.VANILLA_DYE;
		else if (is_drop_vanilla_flowers.equals("petals") && PackStock.item.petals_be) return typeDropVanillaFlowers.PETALS;
		else return typeDropVanillaFlowers.OTHER;
	}
	//--------------------------------------------------------------------------------------------------------------
}
