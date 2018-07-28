package smt.pack.magic.tile;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityTeleport extends TileEntity {

	private AxisAlignedBB aabb_main = null;
	private int cooldown = 0;
	public boolean isActive = false;
	private Entity entity = null;

	public TileEntityTeleport() {

	}

	@Override
	public void updateEntity() {

		if (cooldown > 0) --cooldown;

		if (cooldown <= 0) {

			if (aabb_main == null)
				aabb_main = AxisAlignedBB.getBoundingBox((double)xCoord, (double)yCoord + 0.5D, (double)zCoord, (double)(xCoord + 1), (double)(yCoord + 1), (double)(zCoord + 1));

			if (aabb_main != null) {
				List list = worldObj.getEntitiesWithinAABB(Entity.class, aabb_main);

				if (list.isEmpty()) {
					isActive = false;
					entity = null;
				} else {
					Iterator iterator = list.iterator();
					while(iterator.hasNext()) {
						entity = (Entity)iterator.next();
						if (entity != null) {
							//entity.setPosition((double)xCoord + 0.5D, (double)yCoord + 5, (double)zCoord + 0.5D);
							/*
							if (entity instanceof EntityItem) cooldown = 20;
							else if (entity instanceof EntityThrowable) cooldown = 35;
							else if (entity instanceof EntityLivingBase) cooldown = 60;
							else cooldown = 60;
							 */
							isActive = true;
							break;
						}
					}
				}
			}

		}

	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
