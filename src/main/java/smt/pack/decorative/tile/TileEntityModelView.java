package smt.pack.decorative.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants.NBT;

public class TileEntityModelView extends TileEntity {

	public float
	translateX, translateY, translateZ,
	rotateX, rotateY, rotateZ,
	scaleX = 1F, scaleY = 1F, scaleZ = 1F;

	@SideOnly(Side.CLIENT)
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1D, yCoord + 1D, zCoord + 1D);
		if (translateX != 0F) {
			aabb.minX += translateX;
			aabb.maxX += translateX;
		}
		if (translateY != 0F) {
			aabb.minY += translateY;
			aabb.maxY += translateY;
		}
		if (translateZ != 0F) {
			aabb.minZ += translateZ;
			aabb.maxZ += translateZ;
		}
		if (scaleX != 1F) {
			aabb.minX -= (scaleX - 1F) / 2F;
			aabb.maxX += (scaleX - 1F) / 2F;
		}
		if (scaleY != 1F) {
			aabb.minY -= 0;
			aabb.maxY += (scaleY - 1F);
		}
		if (scaleZ != 1F) {
			aabb.minZ -= (scaleZ - 1F) / 2F;
			aabb.maxZ += (scaleZ - 1F) / 2F;
		}
		return aabb;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		if (nbt.hasKey("tX", NBT.TAG_FLOAT)) translateX = nbt.getFloat("tX");
		if (nbt.hasKey("tY", NBT.TAG_FLOAT)) translateY = nbt.getFloat("tY");
		if (nbt.hasKey("tZ", NBT.TAG_FLOAT)) translateZ = nbt.getFloat("tZ");

		if (nbt.hasKey("rX", NBT.TAG_FLOAT)) rotateX = nbt.getFloat("rX");
		if (nbt.hasKey("rY", NBT.TAG_FLOAT)) rotateY = nbt.getFloat("rY");
		if (nbt.hasKey("rZ", NBT.TAG_FLOAT)) rotateZ = nbt.getFloat("rZ");

		if (nbt.hasKey("sX", NBT.TAG_FLOAT)) scaleX = nbt.getFloat("sX");
		if (nbt.hasKey("sY", NBT.TAG_FLOAT)) scaleY = nbt.getFloat("sY");
		if (nbt.hasKey("sZ", NBT.TAG_FLOAT)) scaleZ = nbt.getFloat("sZ");

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		if (translateX != 0) nbt.setFloat("tX", translateX);
		if (translateY != 0) nbt.setFloat("tY", translateY);
		if (translateZ != 0) nbt.setFloat("tZ", translateZ);

		if (rotateX != 0) nbt.setFloat("rX", rotateX);
		if (rotateY != 0) nbt.setFloat("rY", rotateY);
		if (rotateZ != 0) nbt.setFloat("rZ", rotateZ);

		if (scaleX != 1) nbt.setFloat("sX", scaleX);
		if (scaleY != 1) nbt.setFloat("sY", scaleY);
		if (scaleZ != 1) nbt.setFloat("sZ", scaleZ);

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
