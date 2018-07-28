package smt.pack.weapon.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBall extends EntityThrowable {

	float durability;

	public EntityBall(World world) {
		super(world);
		durability = 1024;
	}

	public EntityBall(World world, EntityLivingBase entity) {
		super(world, entity);
		durability = 1024;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		durability -= 0.01F;
		if (durability < 0) setDead();
	}

	@Override
	public void onImpact(MovingObjectPosition mop) {
		if (mop != null) {
			switch(mop.typeOfHit) {
			case BLOCK:{
				Block block = worldObj.getBlock(mop.blockX, mop.blockY, mop.blockZ);
				int metadata = worldObj.getBlockMetadata(mop.blockX, mop.blockY, mop.blockZ);
				if (!worldObj.isRemote) {
					float blockHardness = block.getBlockHardness(worldObj, mop.blockX, mop.blockY, mop.blockZ);
					//if (block.getHarvestLevel(metadata) != -1)
					if (blockHardness != -1) {
						durability -= blockHardness;
						worldObj.func_147480_a(mop.blockX, mop.blockY, mop.blockZ, (durability > 0));
					} else setDead();
				}
				break;
			}
			case ENTITY:{
				mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 6.0F);
				setDead();
				break;
			}
			default:{
				setDead();
				break;}
			}

		}
	}

}
