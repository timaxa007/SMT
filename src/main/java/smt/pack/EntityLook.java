package smt.pack;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class EntityLook {
	/**side**/
	public static final int[]
			PITCH =		{-90,	90,		0,		0,		0,		0},
			YAW =		{0,		0,		360,	180,	270,	90},
			YAW_PITCH =	{-90,	90,		360,	180,	270,	90}
	;
	/**MathHelper**/
	public static final int[]
			PITCH2 =		{-90,	90,		0,		0,	0,		0},
			YAW2 =			{0,		0,		360,	90,	180,	270},
			YAW_PITCH2 =	{-90,	90,		360,	90,	180,	270}
	;
	//MovingObjectPosition mop = block(player, 1F, 16D * 16D, true);

	public static MovingObjectPosition block(EntityLivingBase entity_base, float fasc, double dist, boolean interact) {
		Vec3 vec3 = Vec3.createVectorHelper(entity_base.posX, entity_base.posY + entity_base.getEyeHeight(), entity_base.posZ);
		Vec3 vec31 = entity_base.getLook(fasc);
		Vec3 vec32 = vec3.addVector(vec31.xCoord * dist, vec31.yCoord * dist, vec31.zCoord * dist);
		MovingObjectPosition mop = entity_base.worldObj.rayTraceBlocks(vec3, vec32, interact);
		return mop;
	}

	public static MovingObjectPosition block(FakePlayer fake_player, Vec3 vec3, boolean interact) {
		Vec3 vec31 = Vec3.createVectorHelper(fake_player.posX, fake_player.posY, fake_player.posZ);
		MovingObjectPosition mop = fake_player.worldObj.rayTraceBlocks(vec3, vec3, interact);
		return mop;
	}

	public static MovingObjectPosition block(World world, Vec3 vec31, Vec3 vec32, boolean interact) {
		return world.rayTraceBlocks(vec31, vec32, interact);
	}

	//private Entity pointedEntity;
	//public EntityLivingBase renderViewEntity;
	//public MovingObjectPosition objectMouseOver;
	//MovingObjectPosition mop = EntityLook.getMouseOver(entity_base, 1F, 10D, true);

	public static MovingObjectPosition getMouseOver(EntityLivingBase entity_base, float fasc, double dist, boolean interact) {
		if (entity_base == null || entity_base.worldObj == null) return null;
		Entity pointedEntity = null;
		double d0 = dist;
		double d1 = d0;
		Vec3 vec3 = Vec3.createVectorHelper(entity_base.posX, 
				(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT ? entity_base.posY : entity_base.posY + entity_base.getEyeHeight()), 
				entity_base.posZ);
		Vec3 vec31 = entity_base.getLook(fasc);
		Vec3 vec32 = vec3.addVector(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0);
		Vec3 vec33 = null;
		MovingObjectPosition objectMouseOver = rayTrace(entity_base, dist, fasc);

		if (objectMouseOver != null)
			d1 = objectMouseOver.hitVec.distanceTo(vec3);

		float f1 = 1.0F;
		List list = entity_base.worldObj.getEntitiesWithinAABBExcludingEntity(entity_base, entity_base.boundingBox.addCoord(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0).expand((double)f1, (double)f1, (double)f1));
		double d2 = d1;

		for (int i = 0; i < list.size(); ++i) {
			Entity entity = (Entity)list.get(i);

			if (entity.canBeCollidedWith() || interact) {
				float f2 = entity.getCollisionBorderSize();
				AxisAlignedBB axisalignedbb = entity.boundingBox.expand((double)f2, (double)f2, (double)f2);
				MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);

				if (axisalignedbb.isVecInside(vec3)) {
					if (0.0D < d2 || d2 == 0.0D) {
						pointedEntity = entity;
						vec33 = movingobjectposition == null ? vec3 : movingobjectposition.hitVec;
						d2 = 0.0D;
					}
				} else if (movingobjectposition != null) {
					double d3 = vec3.distanceTo(movingobjectposition.hitVec);

					if (d3 < d2 || d2 == 0.0D) {
						if (entity == entity_base.ridingEntity && !entity.canRiderInteract()) {
							if (d2 == 0.0D) {
								pointedEntity = entity;
								vec33 = movingobjectposition.hitVec;
							}
						} else {
							pointedEntity = entity;
							vec33 = movingobjectposition.hitVec;
							d2 = d3;
						}
					}
				}
			}
		}

		if (pointedEntity != null && (d2 < d1 || objectMouseOver == null))
			return new MovingObjectPosition(pointedEntity, vec33);
		return null;
	}

	public static MovingObjectPosition rayTrace(EntityLivingBase entity, double dist, float fasc) {
		Vec3 vec3 = Vec3.createVectorHelper(entity.posX, 
				(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT ? entity.posY : entity.posY + entity.getEyeHeight()), 
				entity.posZ);
		Vec3 vec31 = entity.getLook(fasc);
		Vec3 vec32 = vec3.addVector(vec31.xCoord * dist, vec31.yCoord * dist, vec31.zCoord * dist);
		return entity.worldObj.func_147447_a(vec3, vec32, false, false, true);
	}
	/*
	public static MovingObjectPosition getMouseOver(EntityLivingBase entity_base, float fasc, double dist, boolean interact) {
		if (entity_base == null || entity_base.worldObj == null) return null;
		Entity pointedEntity = null;
		double d0 = dist;
		double d1 = d0;
		Vec3 vec3 = Vec3.createVectorHelper(entity_base.posX, 
				(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT ? entity_base.posY : entity_base.posY + entity_base.getEyeHeight()), 
				entity_base.posZ);
		Vec3 vec31 = entity_base.getLook(fasc);
		Vec3 vec32 = vec3.addVector(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0);
		Vec3 vec33 = null;
		MovingObjectPosition objectMouseOver = entity_base.worldObj.func_147447_a(vec3, vec32, false, false, true);

		if (objectMouseOver != null)
			d1 = objectMouseOver.hitVec.distanceTo(vec3);

		float f1 = 1.0F;
		List list = entity_base.worldObj.getEntitiesWithinAABBExcludingEntity(entity_base, entity_base.boundingBox.addCoord(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0).expand((double)f1, (double)f1, (double)f1));
		double d2 = d1;

		for (int i = 0; i < list.size(); ++i) {
			Entity entity = (Entity)list.get(i);

			if (entity.canBeCollidedWith() || interact) {
				float f2 = entity.getCollisionBorderSize();
				AxisAlignedBB axisalignedbb = entity.boundingBox.expand((double)f2, (double)f2, (double)f2);
				MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);

				if (axisalignedbb.isVecInside(vec3)) {
					if (0.0D < d2 || d2 == 0.0D) {
						pointedEntity = entity;
						vec33 = movingobjectposition == null ? vec3 : movingobjectposition.hitVec;
						d2 = 0.0D;
					}
				} else if (movingobjectposition != null) {
					double d3 = vec3.distanceTo(movingobjectposition.hitVec);

					if (d3 < d2 || d2 == 0.0D) {
						if (entity == entity_base.ridingEntity && !entity.canRiderInteract()) {
							if (d2 == 0.0D) {
								pointedEntity = entity;
								vec33 = movingobjectposition.hitVec;
							}
						} else {
							pointedEntity = entity;
							vec33 = movingobjectposition.hitVec;
							d2 = d3;
						}
					}
				}
			}
		}

		if (pointedEntity != null && (d2 < d1 || objectMouseOver == null))
			return new MovingObjectPosition(pointedEntity, vec33);
		return null;
	}
	 */
}
