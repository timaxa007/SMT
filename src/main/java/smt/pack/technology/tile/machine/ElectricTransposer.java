package smt.pack.technology.tile.machine;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.nbt.NBTTagCompound;

public class ElectricTransposer extends ElectricMachine {

	private InventoryBasic inventory = new InventoryBasic("ElectricTransposer", false, 1);

	public ElectricTransposer(smt.pack.technology.tile.TileEntityElectricMachine tile) {
		super(tile);
	}

	@Override
	public void update() {
		/*
		if (getInventory().isFreeSpace()) {
			int j = 0;
			boolean isBreak = false;
			double xd = (double)xCoord;
			double yd = (double)yCoord;
			double zd = (double)zCoord;

			AxisAlignedBB axisalignedbb;
			if (j == 0)
				axisalignedbb = AxisAlignedBB.getBoundingBox(xd, yd + 1D, zd, xd + 1D, yd + 1.0625D, zd + 1D);
			else if (j == 1)
				axisalignedbb = AxisAlignedBB.getBoundingBox(xd, yd - 0.0625D, zd, xd + 1D, yd, zd + 1D);
			else if (j == 2)
				axisalignedbb = AxisAlignedBB.getBoundingBox(xd, yd, zd, xd, yd + 1D, zd);
			else
				axisalignedbb = AxisAlignedBB.getBoundingBox(xd, yd, zd, xd + 1D, yd + 1D, zd + 1D).expand(0.0625D, 0.0625D, 0.0625D);

			List list = worldObj.getEntitiesWithinAABB(Entity.class, axisalignedbb);
			Iterator iterator = list.iterator();

			while(iterator.hasNext()) {
				Entity entity = (Entity)iterator.next();
				if (entity instanceof EntityItem) {

					for (int i = 0; i < getInventory().getSizeInventory(); ++i) {
						if (getInventory().getStackInSlot(i) == null) {
							getInventory().setInventorySlotContents(i, ((EntityItem)entity).getEntityItem());
							entity.setDead();
							isBreak = true;
							break;
						}
					}

					if (isBreak) break;

				}
			}

		}

		if (getInventory().isOccupiedSpace()) {
			IInventory inv = null;
			TileEntity tile = worldObj.getTileEntity(xCoord, yCoord - 1, zCoord);

			if (tile != null && tile instanceof IInventory)
				inv = (IInventory)tile;

			if (inv != null && inv.getSizeInventory() > 0) {
				for (int k = 0; k < inv.getSizeInventory(); ++k) {
					if (inv.getStackInSlot(k) == null) {
						for (int i = 0; i < getInventory().getSizeInventory(); ++i) {
							if (getInventory().getStackInSlot(i) != null) {
								inv.setInventorySlotContents(k, getInventory().getStackInSlot(i));
								getInventory().setInventorySlotContents(i, null);
								break;
							}
						}
					}
				}
			}

		}
		 */
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {

	}

}
