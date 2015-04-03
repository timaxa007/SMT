package timaxa007.module.environment.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerEnvironment implements IExtendedEntityProperties {

	public static final String ENVIRO = "Environ";

	@Override
	public void init(Entity entity, World world) {

	}

	public PlayerEnvironment() {
	}

	public static void reg(EntityPlayer player) {
		player.registerExtendedProperties(ENVIRO, new PlayerEnvironment());
	}

	public static PlayerEnvironment get(EntityPlayer player) {
		return (PlayerEnvironment)player.getExtendedProperties(ENVIRO);
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = new NBTTagCompound();
		nbt.setTag(ENVIRO, nbt_tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = (NBTTagCompound)nbt.getTag(ENVIRO);
	}

}
