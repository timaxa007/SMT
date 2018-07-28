package smt.pack.magic.mana;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.network.MessageMana;
import smt.pack.magic.network.MessageManaMax;

public class ManaEntity implements IExtendedEntityProperties {

	public final static String TAG = SMTMagic.MODID + ":mana";

	public int
	level = 0,
	mana = 0,
	mana_max = 0
	;

	public ManaEntity() {}

	@Override
	public void init(Entity entity, World world) {

	}

	public void update(EntityLivingBase entity) {
		if (mana < mana_max) ++mana;
		else if (mana > mana_max) --mana;
	}
/*
	public static void reg(Entity entity) {
		entity.registerExtendedProperties(ManaEntity.TAG, new ManaEntity());
	}

	public static ManaEntity get(Entity entity) {
		return entity != null ? (ManaEntity)entity.getExtendedProperties(TAG) : null;
	}
*/
	public ManaEntity levelUP() {
		addLevel(1);
		return this;
	}

	public ManaEntity addLevel(int level) {
		this.level += level;
		return this;
	}

	public ManaEntity setLevel(int level) {
		this.level = level;
		return this;
	}

	public int getLevel() {
		return this.level;
	}

	public boolean hasMana(int mana) {
		if (mana > 0) return this.mana + mana <= this.mana_max;
		else if (mana < 0) return this.mana + mana >= 0;
		else return hasMana();
	}

	public boolean hasMana() {
		return this.mana <= this.mana_max && this.mana > 0;
	}

	public ManaEntity addMana(int mana) {
		this.mana += mana;
		return this;
	}

	public ManaEntity setMana(int mana) {
		this.mana = mana;
		return this;
	}

	public int getMana() {
		return this.mana;
	}

	public ManaEntity setManaMax(int mana_max) {
		this.mana_max = mana_max;
		return this;
	}

	public int getManaMax() {
		return this.mana_max;
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setShort("Level", (short)level);
		compound.setInteger("Mana", mana);
		compound.setInteger("ManaMax", mana_max);
		nbt.setTag(TAG, compound);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		if (nbt.hasKey(TAG)) {
			NBTTagCompound compound = (NBTTagCompound)nbt.getTag(TAG);

			if (compound.hasKey("Level", NBT.TAG_SHORT))
				level = (int)compound.getShort("Level");

			if (compound.hasKey("Mana", NBT.TAG_INT))
				mana = compound.getInteger("Mana");

			if (compound.hasKey("ManaMax", NBT.TAG_INT))
				mana_max = compound.getInteger("ManaMax");

		}
	}

}
