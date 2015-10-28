package timaxa007.pack.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import timaxa007.pack.common.PackCommon;

public class Config {

	public static boolean isTest = false;

	public static void main() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackCommon.PACK_TAG, "main.cfg"));
		cfg.load();
		String catMain = "main";
		isTest = cfg.get(catMain, "test", true, "Testing").getBoolean();
		cfg.save();
	}

}
