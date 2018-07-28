package smt.pack.weapon.config;

import smt.pack.weapon.registry.Reg;
import smt.pack.weapon.registry.FireMode;
import smt.pack.weapon.registry.MagazineDummy;
import timaxa007.config_tlx.IProcessConfig;

public class MagazinePC implements IProcessConfig<MagazineDummy> {

	@Override
	public MagazineDummy newInstance(final String id) {
		return new MagazineDummy();
	}

	@Override
	public void process(final String key, final String value, final MagazineDummy item) {
		MagazineDummy wpn = (MagazineDummy)item;
		if ("name".equals(key)) wpn.name = value;
		else if ("description".equals(key)) wpn.description = value;
		else if ("amount".equals(key)) wpn.amount = Integer.parseInt(value);
		else if ("bullets".equals(key)) {
			wpn.bullets = value.split(":");
			for (int i = 0; i < wpn.bullets.length; ++i)
				wpn.bullets[i] = wpn.bullets[i].trim();
		}
		
	}

	@Override
	public void finish(final MagazineDummy magazine, final String id) {
		Reg.magazines.put(id, magazine.toMagazine());
	}

}
