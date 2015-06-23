package timaxa007.pack.techno.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityElectricRobot extends EntityLiving {

	private static int tier;

	static {
		tier = 0;
	}

	public EntityElectricRobot(World world) {
		super(world);
		//setSize(2.0F, 2.0F);
	}

	public EntityElectricRobot setTier(int tier) {
		this.tier = tier;
		return this;
	}

	public int getTier() {return tier;}

	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);
		nbt.setByte("TierRobot", (byte)tier);
	}

	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);
		tier = (int)nbt.getByte("TierRobot");
	}

}
