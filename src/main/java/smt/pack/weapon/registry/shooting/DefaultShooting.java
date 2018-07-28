package smt.pack.weapon.registry.shooting;

import net.minecraft.entity.player.EntityPlayer;
import smt.pack.weapon.SMTWeapon;
import smt.pack.weapon.entity.EntityBullet;
import smt.pack.weapon.network.MessageSpawnBullet;
import smt.pack.weapon.registry.FireMode;
import smt.pack.weapon.registry.Reg;
import smt.pack.weapon.registry.WeaponSystem;

public class DefaultShooting extends ShootingDummy {

	public DefaultShooting(final WeaponSystem wpn_sys, final EntityPlayer player) {
		super(wpn_sys, player);
	}

	@Override
	public void onUpdate() {
		if (isLeft && wpn_sys.getFireMode() == FireMode.AUTOMATIC) shot();
		if (delay_fire > 0) --delay_fire;
	}

	@Override
	public void leftClick(boolean isLeft) {
		System.out.println("leftClick");
		super.isLeft = isLeft;
		if (isLeft && wpn_sys.getFireMode() == FireMode.SINGLE) shot();
	}

	@Override
	public void shot() {
		if (wpn_sys.getNumerCourse() < 0) return;
		if (delay_fire < 0) return;
		if (wpn_sys.getBullet() == null) return;
		EntityBullet entity_bullet = new EntityBullet(player.worldObj, player, wpn_sys.getBullet());
		player.worldObj.spawnEntityInWorld(entity_bullet);

		delay_fire = wpn_sys.getWeapon().getDelayFire();
		if (wpn_sys.getNumerCourse() <= 0)
			wpn_sys.setBullet(null);
		else
			wpn_sys.setBullet(wpn_sys.getCourse()[wpn_sys.getNumerCourse()]);
		wpn_sys.setNumerCourse(wpn_sys.getNumerCourse() - 1);
		/*
		MessageSpawnBullet message = new MessageSpawnBullet();
		message.bullet = Reg.getBulletID(wpn_sys.getBullet());
		message.thowerID = player.getEntityId();
		message.entityID = entity_bullet.getEntityId();
		SMTWeapon.network.sendToDimension(message, entity_bullet.dimension);
		 */
		System.out.println("shot");
	}

	@Override
	public void breaking() {
		delay_fire = -1;
	}

}
