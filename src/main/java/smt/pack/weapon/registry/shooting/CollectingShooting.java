package smt.pack.weapon.registry.shooting;

import net.minecraft.entity.player.EntityPlayer;
import smt.pack.weapon.entity.EntityBlast;
import smt.pack.weapon.registry.FireMode;
import smt.pack.weapon.registry.WeaponSystem;

public class CollectingShooting extends ShootingDummy {

	public CollectingShooting(final WeaponSystem wpn_sys, final EntityPlayer player) {
		super(wpn_sys, player);
	}

	@Override
	public void onUpdate() {
		if (isLeft && wpn_sys.getFireMode() == FireMode.AUTOMATIC) {
			delay_fire = wpn_sys.getWeapon().getDelayFire();
			shot();
		}
		if (isLeft && wpn_sys.getFireMode() == FireMode.COLLECTING) {
			if (delay_fire < wpn_sys.getWeapon().getDelayFire()) ++delay_fire;
		}
		if (!isLeft && delay_fire > 0) --delay_fire;
	}

	@Override
	public void leftClick(boolean isLeft) {
		super.isLeft = isLeft;
		if (isLeft && wpn_sys.getFireMode() == FireMode.SINGLE) {
			delay_fire = wpn_sys.getWeapon().getDelayFire();
			shot();
		}
		if (!isLeft && wpn_sys.getFireMode() == FireMode.COLLECTING) {
			shot();
		}
	}

	@Override
	public void shot() {
		if (delay_fire < 0) return;
		if (wpn_sys.getBullet() != null) {
			System.out.println("delay_fire - " + delay_fire);
			EntityBlast entity_bullet = new EntityBlast(player.worldObj, player, wpn_sys.getBullet(), delay_fire);
			player.worldObj.spawnEntityInWorld(entity_bullet);
			/*
			MessageSpawnBullet message = new MessageSpawnBullet();
			message.bullet = Reg.getBulletID(wpn_sys.getBullet());
			message.thowerID = player.getEntityId();
			message.entityID = entity_bullet.getEntityId();
			SMTWeapon.network.sendToDimension(message, entity_bullet.dimension);
			 */
		}
	}

	@Override
	public void breaking() {
		shot();
		delay_fire = -1;
	}

}
