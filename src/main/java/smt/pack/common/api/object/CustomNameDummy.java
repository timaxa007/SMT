package smt.pack.common.api.object;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants.NBT;

public class CustomNameDummy implements smt.pack.common.api.ICustomName {

	final String finalName;
	String customName;

	public CustomNameDummy(String name) {
		finalName = name;
	}

	@Override
	public boolean hasCustomName() {
		return customName != null && customName.length() > 0;
	}

	@Override
	public void setName(String name) {
		customName = name;

	}

	@Override
	public String getName() {
		return hasCustomName() ? customName : finalName;
	}

	public void readFromNBT(NBTTagCompound nbt) {
		if (nbt.hasKey("CustomName", NBT.TAG_STRING)) setName(nbt.getString("CustomName"));

	}

	public void writeToNBT(NBTTagCompound nbt) {
		if (hasCustomName()) nbt.setString("CustomName", getName());
	}

}
