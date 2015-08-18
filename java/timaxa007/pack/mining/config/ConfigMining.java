package timaxa007.pack.mining.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import timaxa007.pack.mining.PackMining;

public class ConfigMining {
	//--------------------------------------------------------------------------------------------------------------
	public static int world_dim_mining_id;
	public static int world_dim_only_day_id;
	public static int world_dim_only_night_id;
	//--------------------------------------------------------------------------------------------------------------
	public static void main() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackMining.MODID, "main.cfg"));
		cfg.load();
		//----------------------------------------------------------------------------------------------------------
		world_dim_mining_id = cfg.get("world", "dimension_mining_id", 30).getInt();
		world_dim_only_day_id = cfg.get("world", "dimension_only_day_id", 31).getInt();
		world_dim_only_night_id = cfg.get("world", "dimension_only_night_id", 32).getInt();
		//----------------------------------------------------------------------------------------------------------
		PackMining.block.ore_rock_ores_be = cfg.get("block", "ore_rock_ores", true).getBoolean();
		PackMining.block.ore_nether_ores_be = cfg.get("block", "ore_nether_ores", true).getBoolean();
		PackMining.block.ore_ender_ores_be = cfg.get("block", "ore_ender_ores", true).getBoolean();
		PackMining.block.cristals_be = cfg.get("block", "cristals", true).getBoolean();
		//----------------------------------------------------------------------------------------------------------
		PackMining.item.items_for_mining_be = cfg.get("item", "items_for_mining", true).getBoolean();
		//----------------------------------------------------------------------------------------------------------
		cfg.save();
	}
	//--------------------------------------------------------------------------------------------------------------
}
