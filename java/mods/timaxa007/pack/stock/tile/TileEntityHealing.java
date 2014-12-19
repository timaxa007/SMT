package mods.timaxa007.pack.stock.tile;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityHealing extends TileEntity {

	public void updateEntity() {
		if (worldObj.getTotalWorldTime() % 80L == 0L) {
			addEffectsToPlayers();
		}
	}

	private void addEffectsToPlayers() {
		if (!worldObj.isRemote) {/*
			double d0 = (double)(50);

			AxisAlignedBB axisalignedbb = AxisAlignedBB.getAABBPool().getAABB((double)xCoord, (double)yCoord, (double)zCoord, (double)(xCoord + 1), (double)(yCoord + 1), (double)(zCoord + 1)).expand(d0, d0, d0);
			axisalignedbb.maxY = (double)worldObj.getHeight();
			List list = worldObj.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
			Iterator iterator = list.iterator();
			EntityPlayer entityplayer;

			while(iterator.hasNext()) {
				entityplayer = (EntityPlayer)iterator.next();
				if (entityplayer.inventory.armorItemInSlot(3) != null && entityplayer.inventory.armorItemInSlot(3).getItem() instanceof ItemArmor) {

				} else {
					entityplayer.addPotionEffect(new PotionEffect(Potion.poison.id, 20 * 1, 0, true));
				}
			}
		 */
		}
	}

}
