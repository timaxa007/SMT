package mods.timaxa007.pack.magic.util;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerMana implements IExtendedEntityProperties {

	private int mana;
	private int mana_max;

	public PlayerMana(Entity entity) {
		mana = 0;
		mana_max = 32;
	}

	public static final PlayerMana get(Entity entity) {
		return (PlayerMana)entity.getExtendedProperties("PlayerMana");
	}

	public static void set(Entity entity) {
		entity.registerExtendedProperties("PlayerMana", new PlayerMana(entity));
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		nbt.setInteger("Mana", mana);
		nbt.setInteger("ManaMax", mana_max);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		mana = nbt.getInteger("Mana");
		mana_max = nbt.getInteger("ManaMax");
	}

	@Override
	public void init(Entity entity, World world) {
		mana = 0;
		mana_max = 32;
	}

}
