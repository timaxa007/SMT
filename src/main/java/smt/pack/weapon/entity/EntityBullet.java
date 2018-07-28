package smt.pack.weapon.entity;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import smt.pack.weapon.client.entity.BulletHoleFX;
import smt.pack.weapon.registry.Bullet;

public class EntityBullet extends Entity implements IProjectile {

	private final EntityLivingBase thrower;
	private final Bullet bullet;
	private int ticksInAir;

	public EntityBullet(final World world) {
		super(world);
		this.thrower = null;
		this.bullet = null;
	}

	public EntityBullet(final World world, final EntityLivingBase entity, final Bullet bullet) {
		super(world);
		this.thrower = entity;
		this.bullet = bullet;
		setSize(bullet.getSize(), bullet.getSize());
		setLocationAndAngles(entity.posX, entity.posY + (double)entity.getEyeHeight(), entity.posZ, entity.rotationYaw, entity.rotationPitch);
		posX -= (double)(MathHelper.cos(rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
		posY -= 0.10000000149011612D;
		posZ -= (double)(MathHelper.sin(rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
		setPosition(posX, posY, posZ);
		yOffset = 0.0F;
		float f = 0.4F;
		motionX = (double)(-MathHelper.sin(rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(rotationPitch / 180.0F * (float)Math.PI) * f);
		motionZ = (double)(MathHelper.cos(rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(rotationPitch / 180.0F * (float)Math.PI) * f);
		motionY = (double)(-MathHelper.sin((rotationPitch + 0.0F) / 180.0F * (float)Math.PI) * f);
		setThrowableHeading(motionX, motionY, motionZ, bullet.getSpeed(), 1.0F);
	}

	@Override
	protected void entityInit() {}

	public void onImpact(MovingObjectPosition mop) {
		System.out.println("EntityBullet onImpact");
		switch(mop.typeOfHit) {
		case ENTITY:
			if (mop.entityHit != null && bullet != null)
				mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), bullet.getDamage());
			break;
		case BLOCK:
			if (worldObj.getBlock(mop.blockX, mop.blockY, mop.blockZ) == Blocks.glass) {
				if (!worldObj.isRemote)
					worldObj.func_147480_a(mop.blockX, mop.blockY, mop.blockZ, true);
				break;
			}
			if (worldObj.isRemote) {
				Minecraft.getMinecraft().effectRenderer.addEffect(new BulletHoleFX(worldObj,
						mop.hitVec.xCoord,
						mop.hitVec.yCoord,
						mop.hitVec.zCoord,
						mop.sideHit));
			}
			break;
		default:break;
		}
		setDead();
	}

	@Override
	public void setThrowableHeading(double motionX, double motionY, double motionZ, float speed, float scatter) {
		float f2 = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
		motionX /= (double)f2;
		motionY /= (double)f2;
		motionZ /= (double)f2;
		if (scatter != 0) {
			motionX += rand.nextGaussian() * 0.007499999832361937D * (double)scatter;
			motionY += rand.nextGaussian() * 0.007499999832361937D * (double)scatter;
			motionZ += rand.nextGaussian() * 0.007499999832361937D * (double)scatter;
		}
		motionX *= (double)speed;
		motionY *= (double)speed;
		motionZ *= (double)speed;
		this.motionX = motionX;
		this.motionY = motionY;
		this.motionZ = motionZ;
		float f3 = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
		prevRotationYaw = rotationYaw = (float)(Math.atan2(motionX, motionZ) * 180.0D / Math.PI);
		prevRotationPitch = rotationPitch = (float)(Math.atan2(motionY, (double)f3) * 180.0D / Math.PI);
	}

	@Override
	public void onUpdate() {
		if (thrower == null) setDead();
		if (bullet == null) setDead();
		if (isDead) return;
		lastTickPosX = posX;
		lastTickPosY = posY;
		lastTickPosZ = posZ;
		super.onUpdate();
		//if (ticksInGround == 1200) setDead();

		++ticksInAir;

		Vec3 vec3 = Vec3.createVectorHelper(posX, posY, posZ);
		Vec3 vec31 = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);
		MovingObjectPosition mop = worldObj.rayTraceBlocks(vec3, vec31);
		vec3 = Vec3.createVectorHelper(posX, posY, posZ);
		vec31 = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);

		if (mop != null) {
			vec31 = Vec3.createVectorHelper(mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord);
		}

		if (!worldObj.isRemote) {
			Entity entity = null;
			List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D));
			double d0 = 0.0D;
			EntityLivingBase entitylivingbase = getThrower();

			for (int j = 0; j < list.size(); ++j) {
				Entity entity1 = (Entity)list.get(j);

				if (entity1.canBeCollidedWith() && entity1 != entitylivingbase) {
					float f = 0.3F;
					AxisAlignedBB axisalignedbb = entity1.boundingBox.expand((double)f, (double)f, (double)f);
					MovingObjectPosition mop1 = axisalignedbb.calculateIntercept(vec3, vec31);

					if (mop1 != null) {
						double d1 = vec3.distanceTo(mop1.hitVec);

						if (d1 < d0 || d0 == 0.0D) {
							entity = entity1;
							d0 = d1;
						}
					}
				}
			}

			if (entity != null) {
				mop = new MovingObjectPosition(entity);
			}
		}

		if (mop != null) {
			if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && worldObj.getBlock(mop.blockX, mop.blockY, mop.blockZ) == Blocks.portal) {
				setInPortal();
			} else {
				onImpact(mop);
			}
		}

		posX += motionX;
		posY += motionY;
		posZ += motionZ;
		float f1 = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
		rotationYaw = (float)(Math.atan2(motionX, motionZ) * 180.0D / Math.PI);

		for (rotationPitch = (float)(Math.atan2(motionY, (double)f1) * 180.0D / Math.PI); rotationPitch - prevRotationPitch < -180.0F; prevRotationPitch -= 360.0F){;}

		while (rotationPitch - prevRotationPitch >= 180.0F) prevRotationPitch += 360.0F;
		while (rotationYaw - prevRotationYaw < -180.0F) prevRotationYaw -= 360.0F;
		while (rotationYaw - prevRotationYaw >= 180.0F) prevRotationYaw += 360.0F;

		rotationPitch = prevRotationPitch + (rotationPitch - prevRotationPitch) * 0.2F;
		rotationYaw = prevRotationYaw + (rotationYaw - prevRotationYaw) * 0.2F;
		float f2 = 0.99F;

		if (isInWater()) {
			for (int i = 0; i < 4; ++i) {
				float f4 = 0.25F;
				worldObj.spawnParticle("bubble", posX - motionX * (double)f4, posY - motionY * (double)f4, posZ - motionZ * (double)f4, motionX, motionY, motionZ);
			}

			f2 = 0.8F;
		}

		motionX *= (double)f2;
		motionY *= (double)f2;
		motionZ *= (double)f2;
		motionY -= (double)bullet.getWeight();//getGravityVelocity
		setPosition(posX, posY, posZ);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void setVelocity(double motionX, double motionY, double motionZ) {
		this.motionX = motionX;
		this.motionY = motionY;
		this.motionZ = motionZ;

		if (prevRotationPitch == 0.0F && prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
			prevRotationYaw = rotationYaw = (float)(Math.atan2(motionX, motionZ) * 180.0D / Math.PI);
			prevRotationPitch = rotationPitch = (float)(Math.atan2(motionY, (double)f) * 180.0D / Math.PI);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isInRangeToRenderDist(double p_70112_1_) {
		double d1 = boundingBox.getAverageEdgeLength() * 4.0D;
		d1 *= 64.0D;
		return p_70112_1_ < d1 * d1;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public float getShadowSize() {
		return 0.0F;
	}

	public EntityLivingBase getThrower() {
		return thrower;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {

	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {

	}

}
