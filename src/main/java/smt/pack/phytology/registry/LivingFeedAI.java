package smt.pack.phytology.registry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class LivingFeedAI implements net.minecraftforge.common.IExtendedEntityProperties {

	private static final String TAG = "SMT_PHY_LivingFeedAI";

	private boolean isAIfeed = false;

	@Override
	public void init(Entity entity, World world) {

	}

	public static void reg(EntityLivingBase entity) {
		entity.registerExtendedProperties(TAG, new LivingFeedAI());
	}

	public static LivingFeedAI get(EntityLivingBase entity) {
		return (LivingFeedAI)entity.getExtendedProperties(TAG);
	}

	public void setTrueAIfeed() {
		isAIfeed = true;
	}

	public boolean isAIfeed() {
		return isAIfeed;
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = new NBTTagCompound();
		//nbt_tag.setBoolean("isAIfeed", isAIfeed);
		nbt.setTag(TAG, nbt_tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = (NBTTagCompound)nbt.getTag(TAG);
		//isAIfeed = nbt_tag.getBoolean("isAIfeed");
	}

}
