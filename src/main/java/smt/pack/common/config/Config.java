package smt.pack.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import smt.pack.common.SMTCommon;

public final class Config {

	public static Configuration main;
	public static boolean status;

	public static final void main(File modConfigurationDirectory) {
		main = new Configuration(new File(modConfigurationDirectory, "/smt/common/Common.cfg"));
		main.load();
		status = main.get("main", "test", false).getBoolean();

		main.save();
	}

}
