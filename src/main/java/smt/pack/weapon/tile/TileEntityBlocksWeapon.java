package smt.pack.weapon.tile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBlocksWeapon extends TileEntity {

	private int ticks;

	public TileEntityBlocksWeapon() {
		ticks = 0;
	}

	@Override
	public void updateEntity() {
		++ticks;
		ticks %= 20 * 3;
		if (!worldObj.isRemote) {
			if (ticks == 0) {
				//double radius = 10.0D;
				//double x_d = (double)xCoord + ((worldObj.rand.nextDouble() * radius) + (-worldObj.rand.nextDouble() * radius));
				//double y_d = (double)yCoord + ((worldObj.rand.nextDouble() * radius)/* + (-worldObj.rand.nextDouble() * radius)*/);
				//double z_d = (double)zCoord + ((worldObj.rand.nextDouble() * radius) + (-worldObj.rand.nextDouble() * radius));
				/*EntityItem ei = new EntityItem(worldObj,
						(double)xCoord + 0.5D, (double)yCoord - 0.5D, (double)zCoord + 0.5D,
						new ItemStack(Blocks.cobblestone));
				ei.delayBeforeCanPickup = 20;
				worldObj.spawnEntityInWorld(ei);*/
			}
		}
	}

}
