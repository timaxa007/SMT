package timaxa007.pack.techno.tile;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
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

	private String owner = null;

	public TileEntityElectricMachines(World world) {
		this.worldObj = world;
	}

	public TileEntityElectricMachines() {
	}
	/*
	public void setType(int i) {type = i;}
	public int getType() {return type;}
	 */

	public void setOwner(EntityPlayer player) {owner = player.getCommandSenderName();}
	public EntityPlayer getOwner() {
		return worldObj.getPlayerEntityByName(owner);
	}

	public void setOwnerName(String player) {owner = player;}
	public void setOwner(String player) {owner = player;}
	public String getOwnerName() {return owner;}

	public void updateEntity() {

		double d0 = 1.0D;

		AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1.0D, yCoord + 1.0D, zCoord + 1.0D).expand(d0, d0, d0);
		List list = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		Iterator iterator = list.iterator();
		EntityLivingBase entity;

		while(iterator.hasNext()) {
			entity = (EntityLivingBase)iterator.next();
			if (getOwner() != null && !(entity instanceof EntityPlayer)) {
				DamageSource dmg = DamageSource.magic;
				//dmg.causePlayerDamage(getOwner());
				entity.attackEntityFrom(dmg, 1.0F);
				//entity.onKillEntity(getOwner());
				//entity.onDeath(dmg);
				//entity.setDead();
				if (entity.getHealth() <= 0.0F) {
					EntityXPOrb xp = new EntityXPOrb(worldObj, entity.posX, entity.posY, entity.posZ, 1);
					if (!worldObj.isRemote)
						if (worldObj.getWorldTime() % (20 * 1) == 0)
							worldObj.spawnEntityInWorld(xp);
				}
			}
			break;
		}

	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Owner")) setOwnerName(nbt.getString("Owner"));
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("Owner", getOwnerName());
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
