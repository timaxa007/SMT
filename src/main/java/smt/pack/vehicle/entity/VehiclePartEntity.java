package smt.pack.vehicle.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class VehiclePartEntity extends Entity {

	final EntityVehicle theEntity;
	float
	offsetX = 0F,
	offsetZ = 0F;

	public VehiclePartEntity(World world) {
		super(world);
		theEntity = null;
		setSize(0.5F, 0.5F);
	}

	public VehiclePartEntity(EntityVehicle theEntity, World world) {
		super(world);
		this.theEntity = theEntity;
		setSize(0.5F, 0.5F);
	}

	@Override
	public void entityInit() {}

	public VehiclePartEntity setOffsetX(float offsetX) {
		this.offsetX = offsetX;
		return this;
	}

	public VehiclePartEntity setOffsetZ(float offsetY) {
		this.offsetZ = offsetY;
		return this;
	}

	public float getOffsetX() {
		return offsetX;
	}

	public float getOffsetZ() {
		return offsetZ;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
	}
/*
	@Override
	public void updateRiderPosition() {
		if (this.riddenByEntity != null) {
			double d0 = Math.cos((double)this.rotationYaw * Math.PI / 180.0D) * 0.4D;
			double d1 = Math.sin((double)this.rotationYaw * Math.PI / 180.0D) * 0.4D;
			this.riddenByEntity.setPosition(this.posX + d0, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + d1);
		}
	}
*/
	@Override
	public boolean interactFirst(EntityPlayer player) {
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != player) {
			return true;
		} else {
			if (!this.worldObj.isRemote) {
				player.mountEntity(this);
			}
			return true;
		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return null;
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return this.boundingBox;
	}

	@Override
	public boolean attackEntityFrom(DamageSource ds, float dmg) {
		setDead();
		return !this.isEntityInvulnerable();
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {}

}
