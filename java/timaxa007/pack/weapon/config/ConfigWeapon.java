package timaxa007.pack.weapon.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import timaxa007.pack.weapon.PackWeapon;

public class ConfigWeapon {
	//--------------------------------------------------------------------------------------------------------------
	public static void main() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackWeapon.MODID, "main.cfg"));
		cfg.load();

		PackWeapon.block.claymore_be = cfg.get("block", "claymore", true).getBoolean();

		PackWeapon.item.items_for_weapons_be = cfg.get("item", "items_for_weapons", true).getBoolean();
		PackWeapon.item.molotov_cocktail_be = cfg.get("item", "molotov_cocktail", true).getBoolean();
		PackWeapon.item.weapon_be = cfg.get("item", "weapon", true).getBoolean();
		PackWeapon.item.ammo_be = cfg.get("item", "ammo", true).getBoolean();
		PackWeapon.item.magazine_be = cfg.get("item", "magazine", true).getBoolean();

		cfg.save();
	}
	//--------------------------------------------------------------------------------------------------------------
}
