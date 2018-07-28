package smt.pack.technology.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityRobot extends Entity {

	public EntityRobot(World world) {
		super(world);
		setSize(0.5F, 0.5F);
	}

	@Override
	public void entityInit() {

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
	public void readEntityFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {

	}

}
