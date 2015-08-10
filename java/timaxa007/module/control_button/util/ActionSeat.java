package timaxa007.module.control_button.util;

import net.minecraft.entity.player.EntityPlayer;
import timaxa007.pack.furniture.entity.EntitySeat;

public class ActionSeat {

	int tick_shift = 0;

	public void actionSeat(EntityPlayer player) {
		if (player != null) {
			if (player.isSneaking()) tick_shift = 1;
			if (tick_shift > 0 && !player.isSneaking()) ++tick_shift;
			if (tick_shift <= 20 && tick_shift > 4) {
				spawnSeat(player);
			}
			if (tick_shift > 20) tick_shift = 0;
		}
	}

	public void spawnSeat(EntityPlayer player) {
		player.setSneaking(false);
		EntitySeat entity = new EntitySeat(player.worldObj);
		entity.setPosition(player.posX, player.posY, player.posZ);
		player.worldObj.spawnEntityInWorld(entity);
		player.mountEntity(entity);
		entity.riddenByEntity = player;
	}

}
