package timaxa007.pack.techno.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import timaxa007.pack.techno.PackTechno;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class EventDetector {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void tickDetector(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START) {
			if (event.player != null) actionDetector(event.player);
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public void actionDetector(EntityPlayer player) {
		for (ItemStack is : player.inventory.mainInventory) {
			if (is != null && is.getItem() == PackTechno.item.electric_detector) {

				if (player.worldObj.getWorldTime() % 14 == 0) {

					double posX = player.posX;
					double posY = player.posY;
					double posZ = player.posZ;
					Vec3 player_pos = player.getPosition(1.0F);
					//boolean beep = false;
					int r = 25;

					for (int x = (int)posX - r; x <= (int)posX + r; x++) {
						for (int y = (int)posY - r; y <= (int)posY + r; y++) {
							for (int z = (int)posZ - r; z <= (int)posZ + r; z++) {
								if (!player.worldObj.isAirBlock(x, y, z)) {
									if (player.worldObj.getBlock(x, y, z) == Blocks.diamond_ore) {
										double dis = distanceTo(player, x, y, z);
										//if (player.worldObj.getWorldTime() % 14 == 0) {
										//player.worldObj.playSoundAtEntity(player, "mob.zombie.say", 0.5F, 1.0F);
										float fac = (float)r - (float)dis;
										if (fac > 0.0F) {
											int note = ((int)fac / (r / 5)) + 1;
											float vol = fac / (float)r;
											if (!player.worldObj.isRemote) {
												System.out.println(note);
												player.worldObj.playSoundAtEntity(
														player, ("timaxa007:beep-" + note), (vol / 2.0F) + 0.2F, vol + 0.5F);
											}
										}
									}

								}
							}
						}
					}
				}

				break;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public double distanceTo(EntityPlayer player, int x, int y, int z) {
		double d0 = ((double)x + 0.5F) - player.posX;
		double d1 = ((double)y + 0.5F) - player.posY;
		double d2 = ((double)z + 0.5F) - player.posZ;
		return Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
	}
	//--------------------------------------------------------------------------------------------------------------
}
