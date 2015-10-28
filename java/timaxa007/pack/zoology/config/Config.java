package timaxa007.pack.zoology.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import timaxa007.pack.zoology.PackZoology;

public class Config {

	public static boolean isTest = false;

	public static void main() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackZoology.PACK_TAG, "main.cfg"));
		cfg.load();
		String catMain = "main";
		isTest = cfg.get(catMain, "test", true, "Testing").getBoolean();
		cfg.save();
	}

}
