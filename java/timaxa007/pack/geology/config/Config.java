package timaxa007.pack.geology.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import timaxa007.pack.geology.PackGeology;

public class Config {

	public static boolean isTest = false;

	public static void main() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackGeology.PACK_TAG, "main.cfg"));
		cfg.load();
		String catMain = "main";
		isTest = cfg.get(catMain, "test", true, "Testing").getBoolean();
		cfg.save();
	}

}
