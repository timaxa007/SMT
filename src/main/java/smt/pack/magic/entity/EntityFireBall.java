package smt.pack.magic.entity;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFireBall extends EntityThrowable {

	public EntityFireBall(World world) {
		super(world);
	}

	public EntityFireBall(World world, EntityLivingBase player) {
		super(world, player);
	}

	//private int life_time = 0;
	/*
	public EntityFireBall(World world) {
		super(world);
		//life_time = 20 * 10;
		setSize(0.5F, 0.5F);
	}
	 */
	@Override
	public void entityInit() {
		//life_time = 20 * 10;
		setSize(0.5F, 0.5F);
	}

	@Override
	public void onImpact(MovingObjectPosition mop) {
		if (mop != null) {
			double r = 7.5D;//Радиус
			//Создаём куб, центром будет координаты этого Entity, расширяем во все стороны по переменной r
			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(this.posX, this.posY, this.posZ, this.posX, this.posY, this.posZ).expand(r, r, r);
			//Достаём из куба находящийся в нём Entity
			List list = this.worldObj.getEntitiesWithinAABB(Entity.class, aabb);
			Iterator iterator = list.iterator();
			Entity entity = null;
			while (iterator.hasNext()) {
				entity = (Entity)iterator.next();
				double disEnE = this.getDistance(entity.posX, entity.posY, entity.posZ);//Дистанция от этого Entity до Entity из листа куба
				if (entity != null && disEnE <= r) {
					double velX = entity.posX - this.posX;//Отолкновение по X координате
					double velY = entity.posY - this.posY;//Отолкновение по Y координате
					double velZ = entity.posZ - this.posZ;//Отолкновение по Z координате
					double vr = (r - disEnE) / r;//Чем ближе тем больше скорость отолкновения будет
					vr *= 1.1D;//Усилить отолкновение
					velX *= vr;
					velY *= vr;
					velZ *= vr;
					entity.motionX += velX;//Даём отолкновение для Entity из листа куба в переменную motionX
					entity.motionY += velY;//Даём отолкновение для Entity из листа куба в переменную motionY
					entity.motionZ += velZ;//Даём отолкновение для Entity из листа куба в переменную motionZ
					entity.setFire((int)(vr * r));
				}
			}
			this.setDead();
		}
	}
	/*
	@Override
	public void onUpdate() {
		super.onUpdate();
		System.out.println(life_time);
		--life_time;
		if (life_time <= 0) this.setDead();
	}
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {

	}

}
