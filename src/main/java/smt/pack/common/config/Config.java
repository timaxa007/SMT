package smt.pack.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public static void main(File modConfigurationDirectory) {
		Configuration config = new Configuration(new File(modConfigurationDirectory, "/smt/common/Common.cfg"));
		config.load();

		config.save();
	}

}
