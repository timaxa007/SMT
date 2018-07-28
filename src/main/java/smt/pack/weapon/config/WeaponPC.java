package smt.pack.weapon.config;

import smt.pack.weapon.registry.FireMode;
import smt.pack.weapon.registry.Reg;
import smt.pack.weapon.registry.WeaponDummy;
import timaxa007.config_tlx.IProcessConfig;

public final class WeaponPC implements IProcessConfig<WeaponDummy> {

	@Override
	public WeaponDummy newInstance(final String id) {
		return new WeaponDummy();
	}

	@Override
	public void process(final String key, final String value, final WeaponDummy item) {
		WeaponDummy wpn = (WeaponDummy)item;
		if ("name".equals(key)) wpn.name = value;
		else if ("description".equals(key)) wpn.description = value;
		else if ("shooting".equals(key)) wpn.shooting = value;
		else if ("reloading".equals(key)) wpn.reloading = value;
		else if ("delay_fire".equals(key)) wpn.delay_fire = Integer.parseInt(value);
		else if ("delay_reload".equals(key)) wpn.delay_reload = Integer.parseInt(value);
		else if ("mode_fire".equals(key)) {
			final String[] split = value.split(":");
			wpn.mode_fire = new FireMode[split.length];
			for (int i = 0; i < wpn.mode_fire.length; ++i)
				wpn.mode_fire[i] = FireMode.getFireMode(split[i].trim());
		}
		else if ("ammunition".equals(key)) {
			wpn.ammunition = value.split(":");
			for (int i = 0; i < wpn.ammunition.length; ++i)
				wpn.ammunition[i] = wpn.ammunition[i].trim();
		}
	}

	@Override
	public void finish(final WeaponDummy weapon, final String id) {
		Reg.weapons.put(id, weapon.toWeapon());
	}

}
