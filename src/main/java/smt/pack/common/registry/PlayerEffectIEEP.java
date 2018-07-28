package smt.pack.common.registry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.common.SMTCommon;

public class PlayerEffectIEEP implements net.minecraftforge.common.IExtendedEntityProperties {

	private static final String TAG = SMTCommon.MODID + ":PlayerEffectIEEP";

	int tickEffect = 0;

	@Override
	public void init(Entity entity, World world) {

	}

	public void update(EntityPlayer player) {
		if (player.getActivePotionEffect(Potion.poison) != null) {
			if (tickEffect >= 20 * 20) {
				player.removePotionEffect(Potion.poison.id);
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 20 * 5));
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 20 * 10));
			}
			++tickEffect;
		} else tickEffect = 0;

	}

	public static void reg(EntityPlayer entity) {
		entity.registerExtendedProperties(TAG, new PlayerEffectIEEP());
	}

	public static PlayerEffectIEEP get(EntityPlayer entity) {
		return (PlayerEffectIEEP)entity.getExtendedProperties(TAG);
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = new NBTTagCompound();
		nbt_tag.setInteger("tickEffect", tickEffect);
		nbt.setTag(TAG, nbt_tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		if (nbt.hasKey(TAG)) return;
		NBTTagCompound nbt_tag = (NBTTagCompound)nbt.getTag(TAG);
		if (nbt_tag.hasKey("tickEffect", NBT.TAG_INT))
			tickEffect = nbt_tag.getInteger("tickEffect");
	}

}
