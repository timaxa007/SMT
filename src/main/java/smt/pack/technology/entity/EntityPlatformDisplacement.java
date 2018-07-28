package smt.pack.technology.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityPlatformDisplacement extends Entity {

	public EntityPlatformDisplacement(World world) {
		super(world);
		setSize(5F, 1F);
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

	@Override
	public boolean canTriggerWalking() {
		return false;
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
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	@Override
	public boolean canBePushed() {
		return true;
	}

	@Override
	public boolean attackEntityFrom(DamageSource dmg_src, float f) {
		this.setDead();
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public float getShadowSize() {
		return 0.0F;
	}

}
