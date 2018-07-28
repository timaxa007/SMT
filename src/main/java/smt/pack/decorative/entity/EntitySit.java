package smt.pack.decorative.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntitySit extends Entity {

	private boolean outside;

	public EntitySit(World world) {
		super(world);
	}

	@Override
	public void entityInit() {
		setSize(0F, 0F);
		outside = true;
	}

	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		if (riddenByEntity == null) setDead();
		//if (!(worldObj.getBlock((int)posX, (int)posY, (int)posZ) instanceof BlockSit)) setDead();
	}

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

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {

	}

}
