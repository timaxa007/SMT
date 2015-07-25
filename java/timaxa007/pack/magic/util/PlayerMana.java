package timaxa007.pack.magic.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import timaxa007.smt.util.UtilSMT;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PlayerMana implements IExtendedEntityProperties {

	public final static String MANA_NAME = "ManaPlayer";
	//private EntityPlayer player;
	//private World world;
	private int mana, mana_max;

	public PlayerMana(EntityPlayer player) {
		//this.player = player;
		mana = mana_max = 0;
	}

	public static final void reg(EntityPlayer player) {
		player.registerExtendedProperties(PlayerMana.MANA_NAME, new PlayerMana(player));
	}

	public static final PlayerMana get(EntityPlayer player) {
		return (PlayerMana)player.getExtendedProperties(MANA_NAME);
	}
	//------------------------------------
	public void addMana(int mana) {
		this.mana += mana;
	}

	public void setMana(int mana) {
		this.mana = (mana >= 0 ? mana : 0);
	}

	public int getMana() {return mana;}
	//------------------------------------
	public void addManaMax(int mana_max) {
		this.mana_max += mana_max;
	}

	public void setManaMax(int mana_max) {
		this.mana_max = (mana_max >= 0 ? mana_max : 0);
	}

	public int getManaMax() {return mana_max;}
	//------------------------------------
	public void quicklyManaMax() {mana = mana_max;}
	//------------------------------------
	@SideOnly(Side.CLIENT)
	public static void setClientPlayer(int mana, int mana_max) {
		net.minecraft.client.entity.EntityClientPlayerMP player = UtilSMT.getPlayerClient();
		if (player != null && PlayerMana.get(player) != null) {
			PlayerMana.get(player).setMana(mana);
			PlayerMana.get(player).setManaMax(mana_max);
		}
	}
	//------------------------------------
	@Override
	public void init(Entity entity, World world) {
		//this.world = world;
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = new NBTTagCompound();
		nbt_tag.setInteger("Mana", mana);
		nbt_tag.setInteger("ManaMax", mana_max);
		nbt.setTag(MANA_NAME, nbt_tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = (NBTTagCompound)nbt.getTag(MANA_NAME);
		if (nbt_tag != null) {
			mana = nbt_tag.getInteger("Mana");
			mana_max = nbt_tag.getInteger("ManaMax");
		}
	}

}
