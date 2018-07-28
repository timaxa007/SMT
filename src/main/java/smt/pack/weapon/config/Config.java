package smt.pack.weapon.config;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.config.Configuration;
import timaxa007.config_tlx.HandlerConfig;
import timaxa007.config_tlx.SectionContainer;

public final class Config {

	public static void main(File modConfigurationDirectory) {
		//HandlerConfig.process(new File(modConfigurationDirectory, "/smt/weapon/item/items.tlx"), new HashMap<String, SectionContainer>(), new WeaponPC());
		HandlerConfig.process(new File(modConfigurationDirectory, "/smt/weapon/item/weapon/bullets.tlx"),
				new HashMap<String, SectionContainer>(), new BulletPC());
		HandlerConfig.process(new File(modConfigurationDirectory, "/smt/weapon/item/weapon/magazines.tlx"),
				new HashMap<String, SectionContainer>(), new MagazinePC());
		HandlerConfig.process(new File(modConfigurationDirectory, "/smt/weapon/item/weapon/weapons.tlx"),
				new HashMap<String, SectionContainer>(), new WeaponPC());

		Configuration config = new Configuration(new File(modConfigurationDirectory, "/smt/weapon/Weapon.cfg"));
		config.load();

		config.save();
	}

}
