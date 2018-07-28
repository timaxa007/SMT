package smt.pack.magic.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public final class Config {

	public static void main(File modConfigurationDirectory) {
		Configuration config = new Configuration(new File(modConfigurationDirectory, "/smt/magic/Magic.cfg"));
		config.load();

		config.save();
	}

}
