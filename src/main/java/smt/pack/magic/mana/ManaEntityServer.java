package smt.pack.magic.mana;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.network.MessageMana;
import smt.pack.magic.network.MessageManaMax;

public class ManaEntityServer extends ManaEntity {

	public int
	mana_last = mana,
	mana_max_last = mana_max
	;

	public ManaEntityServer() {}

	@Override
	public void update(EntityLivingBase entity) {
		super.update(entity);

		if (entity instanceof EntityPlayerMP) {
			if (mana_last != mana) SMTMagic.network.sendTo(new MessageMana(mana), (EntityPlayerMP)entity);
			if (mana_max_last != mana_max) SMTMagic.network.sendTo(new MessageManaMax(mana_max), (EntityPlayerMP)entity);
		}

		if (mana_last != mana) mana_last = mana;
		if (mana_max_last != mana_max) mana_max_last = mana_max;
	}
/*
	public static void reg(Entity entity) {
		entity.registerExtendedProperties(ManaEntity.TAG, new ManaEntityServer());
	}

	public static ManaEntityServer get(Entity entity) {
		return entity != null ? (ManaEntityServer)entity.getExtendedProperties(TAG) : null;
	}
*/
}
