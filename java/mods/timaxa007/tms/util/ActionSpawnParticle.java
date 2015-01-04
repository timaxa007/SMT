package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ActionSpawnParticle {

	public static void on1(EntityPlayer player, World world, double cordX, double cordY, double cordZ) {

		//world.spawnParticle("reddust", (double)player.posX, (double)player.posY, (double)player.posZ, 0.0D, 0.0D, 0.0D);

		/*if (world.isRemote) world.spawnParticle("reddust", 
				((double)player.posX + (Math.cos(((double)player.rotationYaw + 90.0D) * Math.PI / 180.0D) * 2.0D)), 
				((double)player.posY + 0.0D), 
				((double)player.posZ + (Math.sin(((double)player.rotationYaw + 90.0D) * Math.PI / 180.0D) * 2.0D)), 
				0.0D, 0.0D, 0.0D);*/

		world.spawnParticle("reddust", cordX, cordY, cordZ, 0.0D, 0.0D, 0.0D);

	}

}
