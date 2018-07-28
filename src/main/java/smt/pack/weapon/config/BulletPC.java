package smt.pack.weapon.config;

import smt.pack.weapon.registry.Reg;
import smt.pack.weapon.registry.BulletDummy;
import smt.pack.weapon.registry.FireMode;
import timaxa007.config_tlx.IProcessConfig;

public class BulletPC implements IProcessConfig<BulletDummy> {

	@Override
	public BulletDummy newInstance(final String id) {
		return new BulletDummy();
	}

	@Override
	public void process(final String key, final String value, final BulletDummy item) {
		BulletDummy wpn = (BulletDummy)item;
		if ("name".equals(key)) wpn.name = value;
		else if ("description".equals(key)) wpn.description = value;
		else if ("damage".equals(key)) wpn.damage = Integer.parseInt(value);
		else if ("size".equals(key)) wpn.size = Float.parseFloat(value);
		else if ("speed".equals(key)) wpn.speed = Float.parseFloat(value);
		else if ("weight".equals(key)) wpn.weight = Float.parseFloat(value);
		else if ("effects".equals(key)) {
			wpn.effects = value.split(":");
			for (int i = 0; i < wpn.effects.length; ++i)
				wpn.effects[i] = wpn.effects[i].trim();
		}

	}

	@Override
	public void finish(final BulletDummy bullet, final String id) {
		Reg.bullets.put(id, bullet.toBullet());
	}

}
