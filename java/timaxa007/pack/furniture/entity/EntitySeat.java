package timaxa007.pack.furniture.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySeat extends Entity {

	public EntitySeat(World world) {
		super(world);
	}

	@Override
	public void entityInit() {

	}

	public void onUpdate() {
		super.onUpdate();
		if (this.riddenByEntity == null) this.setDead();
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {

	}

}
