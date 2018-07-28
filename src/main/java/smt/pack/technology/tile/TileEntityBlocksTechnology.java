package smt.pack.technology.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.technology.SMTTechnology;
import smt.pack.technology.network.MessageSyncTile;

public class TileEntityBlocksTechnology extends TileEntity {

	public int posX, posY, posZ;
	public int last_posX, last_posY, last_posZ;

	public TileEntityBlocksTechnology() {}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			if (worldObj.getWorldTime() % 10 == 0) {

				if (last_posX != posX || last_posY != posY || last_posZ != posZ) {
					MessageSyncTile message = new MessageSyncTile();
					message.x = xCoord;
					message.y = yCoord;
					message.z = zCoord;
					message.nbt = new NBTTagCompound();
					if (last_posX != posX) {
						last_posX = posX;
						message.nbt.setInteger("posX", posX);
					}
					if (last_posY != posY) {
						last_posY = posY;
						message.nbt.setInteger("posY", posY);
					}
					if (last_posZ != posZ) {
						last_posZ = posZ;
						message.nbt.setInteger("posZ", posZ);
					}
					SMTTechnology.network.sendToDimension(message, worldObj.provider.dimensionId);
				}

				++posX;

				if (posX > 2) {
					posX = 0;
					++posZ;
				}

				if (posZ > 2) {
					posZ = 0;
					++posY;
				}

				if (posY > 2) posY = 0;

			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("posX", NBT.TAG_INT)) posX = nbt.getInteger("posX");
		if (nbt.hasKey("posY", NBT.TAG_INT)) posY = nbt.getInteger("posY");
		if (nbt.hasKey("posZ", NBT.TAG_INT)) posZ = nbt.getInteger("posZ");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (posX != 0) nbt.setInteger("posX", posX);
		if (posY != 0) nbt.setInteger("posY", posY);
		if (posZ != 0) nbt.setInteger("posZ", posZ);
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
