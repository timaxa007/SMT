package smt.pack.meteorology.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public static void main(File modConfigurationDirectory) {
		Configuration config = new Configuration(new File(modConfigurationDirectory, "/smt/meteorology/Meteorology.cfg"));
		config.load();

		config.save();
	}

}
