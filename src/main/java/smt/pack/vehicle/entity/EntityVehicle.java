package smt.pack.vehicle.entity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityVehicle extends Entity {

	public VehiclePartEntity[] parts = null;
	private float
	speed = 0F,
	speedMultiplier;

	public EntityVehicle(World world) {
		super(world);
		setSize(0.5F, 0.5F);
		this.speedMultiplier = 0.07F;
		VehiclePartEntity part1 = new VehiclePartEntity(this, worldObj).setOffsetX(1F).setOffsetZ(1F);
		VehiclePartEntity part2 = new VehiclePartEntity(this, worldObj).setOffsetX(-1F).setOffsetZ(1F);

		this.parts = new VehiclePartEntity[] {
				part1,
				part2
		};
	}

	@Override
	public void entityInit() {
	}

	@Override
	public boolean interactFirst(EntityPlayer player) {
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != player) {
			return true;
		} else {
			if (!this.worldObj.isRemote) {
				//player.mountEntity(this);
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
		return entity.boundingBox;
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return this.boundingBox;
	}

	@Override
	public void setDead() {
		super.setDead();
		if (parts != null) {
			for (VehiclePartEntity part : parts) part.setDead();
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource ds, float dmg) {
		setDead();
		return !this.isEntityInvulnerable();
	}

	@Override
	public void onUpdate() {
		//super.onUpdate();
		if (worldObj.isRemote) return;

		float r = this.rotationYaw * (float)Math.PI / 180.0F;
		float sinR = MathHelper.sin(r);
		float cosR = MathHelper.cos(r);

		float f = this.rotationYaw;

		if (parts != null) {
			//System.out.println(parts.length);
			for (VehiclePartEntity part : parts) {

				if (part.riddenByEntity != null && part.riddenByEntity instanceof EntityLivingBase) {
					EntityLivingBase entitylivingbase = (EntityLivingBase)part.riddenByEntity;
					if (this.speed != 0) {
						this.rotationYaw -= entitylivingbase.moveStrafing;
						this.rotationYaw %= 360.0F;
					}
					//System.out.println(this.rotationYaw);


					this.speed += entitylivingbase.moveForward * 0.05000000074505806F;

					//this.motionX += entitylivingbase.moveForward * 0.1F;
					//this.motionZ += entitylivingbase.moveStrafing * 0.1F;
					//System.out.println(entitylivingbase.moveStrafing);

				}

				if (part.riddenByEntity != null && part.riddenByEntity.isDead) part.riddenByEntity = null;

				part.setPosition(
						this.posX + part.getOffsetX() + (double)(sinR),
						this.posY + 1D + part.getYOffset(),
						this.posZ + part.getOffsetZ() - (double)(cosR));
				//part.onUpdate();
			}
		}

		this.motionX += -sinR * this.speed;
		this.motionZ += cosR * this.speed;

		//System.out.println(this.speed);
		this.moveEntity(this.motionX, this.motionY, this.motionZ);

		this.motionX *= 0.4D;
		this.motionZ *= 0.4D;
		this.speed *= speed;

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
	private boolean destroyBlocksInAABB(AxisAlignedBB aabb) {
		int i = MathHelper.floor_double(aabb.minX);
		int j = MathHelper.floor_double(aabb.minY);
		int k = MathHelper.floor_double(aabb.minZ);
		int l = MathHelper.floor_double(aabb.maxX);
		int i1 = MathHelper.floor_double(aabb.maxY);
		int j1 = MathHelper.floor_double(aabb.maxZ);
		boolean flag = false;
		boolean flag1 = false;

		for (int k1 = i; k1 <= l; ++k1) {
			for (int l1 = j; l1 <= i1; ++l1) {
				for (int i2 = k; i2 <= j1; ++i2) {
					Block block = this.worldObj.getBlock(k1, l1, i2);

					if (!block.isAir(worldObj, k1, l1, i2)) {
						if (block.canEntityDestroy(worldObj, k1, l1, i2, this) && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
							flag1 = this.worldObj.setBlockToAir(k1, l1, i2) || flag1;
						} else {
							flag = true;
						}
					}
				}
			}
		}

		if (flag1) {
			double d1 = aabb.minX + (aabb.maxX - aabb.minX) * (double)this.rand.nextFloat();
			double d2 = aabb.minY + (aabb.maxY - aabb.minY) * (double)this.rand.nextFloat();
			double d0 = aabb.minZ + (aabb.maxZ - aabb.minZ) * (double)this.rand.nextFloat();
			this.worldObj.spawnParticle("largeexplode", d1, d2, d0, 0.0D, 0.0D, 0.0D);
		}

		return flag;
	}

	@Override
	public Entity[] getParts() {
		return parts;
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {

	}

}
