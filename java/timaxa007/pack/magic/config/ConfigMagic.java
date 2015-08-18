package timaxa007.pack.magic.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import timaxa007.pack.magic.PackMagic;

public class ConfigMagic {
	//--------------------------------------------------------------------------------------------------------------
	public static void main() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackMagic.MODID, "main.cfg"));
		cfg.load();
		//----------------------------------------------------------------------------------------------------------
		PackMagic.block.magic_machines_be = cfg.get("block", "magic_machines", true).getBoolean();
		PackMagic.block.magic_cauldron_be = cfg.get("block", "magic_cauldron", true).getBoolean();
		PackMagic.block.magic_spawner_be = cfg.get("block", "magic_spawner", true).getBoolean();
		//----------------------------------------------------------------------------------------------------------
		PackMagic.item.items_for_magic_be = cfg.get("item", "items_for_magic", true).getBoolean();
		PackMagic.item.wands_be = cfg.get("item", "wands", true).getBoolean();
		PackMagic.item.stuffs_be = cfg.get("item", "stuffs", true).getBoolean();
		PackMagic.item.teleport_be = cfg.get("item", "teleport", true).getBoolean();
		PackMagic.item.globular_be = cfg.get("item", "globular", true).getBoolean();
		PackMagic.item.magic_bag_be = cfg.get("item", "magic_bag", true).getBoolean();
		PackMagic.item.magic_wings_be = cfg.get("item", "magic_wings", true).getBoolean();
		PackMagic.item.spawner_be = cfg.get("item", "spawner", true).getBoolean();
		//----------------------------------------------------------------------------------------------------------
		cfg.save();
	}
	//--------------------------------------------------------------------------------------------------------------
}
