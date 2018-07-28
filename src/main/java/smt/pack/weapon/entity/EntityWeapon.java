package smt.pack.weapon.entity;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityWeapon extends Entity {

	int cooldown;

	public EntityWeapon(World world) {
		super(world);
		setSize(0.5F, 0.5F);
		cooldown = 0;
	}

	@Override
	public void onUpdate() {
		++cooldown;

		if (cooldown == 40) {
			cooldown = 0;
			if (!worldObj.isRemote) {
				double radius = 10.0D;

				AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(posX - 0.5D, posY - 0.5D, posZ - 0.5D, posX + 0.5D, posY + 0.5D, posZ + 0.5D).expand(radius, radius, radius);
				List list = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
				Iterator iterator = list.iterator();

				EntityLivingBase entity = null;

				Vec3 me = Vec3.createVectorHelper(posX, posY, posZ);
				Vec3 targer = null;
				Vec3 temp = null;

				while(iterator.hasNext()) {
					EntityLivingBase mark = (EntityLivingBase)iterator.next();
					if (!mark.isDead) {
						if (!(mark instanceof EntityPlayer)) {
							temp.createVectorHelper(mark.posX, mark.posY, mark.posZ);
							if (entity != null && targer != null) {
								if (me.distanceTo(temp) < me.distanceTo(targer)) {
									targer = temp;
									entity = mark;
								}
							} else {
								targer = temp;
								entity = mark;
							}
						}
					}
				}

				if (entity != null) {
					EntityBall ball = new EntityBall(worldObj);
					ball.setPosition(posX, posY, posZ);
					ball.motionX = -((posX - entity.posX) * 0.1D);
					ball.motionY = -((posY - entity.posY) * 0.1D) + (double)entity.getEyeHeight() * 0.15D;
					ball.motionZ = -((posZ - entity.posZ) * 0.1D);
					worldObj.spawnEntityInWorld(ball);
				}
			}
		}
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return entity.boundingBox;
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return boundingBox;
	}

	@Override
	public boolean canBeCollidedWith() {
		return !isDead;
	}

	@Override
	public boolean canBePushed() {
		return true;
	}

	@Override
	public void entityInit() {

	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {

	}

}
