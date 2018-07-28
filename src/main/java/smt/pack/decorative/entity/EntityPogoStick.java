package smt.pack.decorative.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityPogoStick extends Entity {
	
	int springTension = 0;//натяжение пружины
	//boolean isJumping = false;

	public EntityPogoStick(World world) {
		super(world);
	}

	@Override
	public void entityInit() {
		setSize(0.5F, 1F);
	}

	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		
		if (canJump() && onGround) {
			motionY = 1F;
		}
		
		//if (riddenByEntity == null) setDead();
		//if (!(worldObj.getBlock((int)posX, (int)posY, (int)posZ) instanceof BlockSit)) setDead();
	}

	public boolean canJump() {
		return false;
	}

	/*
	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public float getShadowSize() {
		return 0.0F;
	}
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {

	}

}
