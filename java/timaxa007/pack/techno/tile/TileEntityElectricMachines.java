package timaxa007.pack.techno.tile;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class TileEntityElectricMachines extends TileEntity {

	//private int type;
	private EntityPlayer owner;

	public TileEntityElectricMachines(World world) {
		this.worldObj = world;
		owner = null;
		//type = 0;
	}
	/*
	public void setType(int i) {type = i;}
	public int getType() {return type;}
	 */

	public void setOwner(EntityPlayer player) {owner = player;}
	public EntityPlayer getOwner() {return owner;}

	public void updateEntity() {

		double d0 = 1.0D;

		AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1.0D, yCoord + 1.0D, zCoord + 1.0D).expand(d0, d0, d0);
		List list = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		Iterator iterator = list.iterator();
		EntityLivingBase entity;

		while(iterator.hasNext()) {
			entity = (EntityLivingBase)iterator.next();
			entity.attackEntityAsMob(owner);
			entity.attackEntityFrom(DamageSource.magic, 1.0F);
			break;
		}

	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		//if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		//nbt.setInteger("Type", type);
	}

	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
