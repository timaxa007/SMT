package mods.timaxa007.tms.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class UtilNBT {
	//------------------------------------------------------------------------------------------------------
	public static NBTTagCompound setStyle(NBTTagCompound nbt, String style) {
		checkTag(nbt);
		nbt.setString("Style", style);
		return nbt;
	}

	public static String getStyle(NBTTagCompound nbt) {
		return nbt.hasKey("Style") ? nbt.getString("Style") : "";
	}

	public static boolean hasStyle(String style) {
		return style != null && style.length() > 0;
	}
	//-----------------------------------------------------------------------------
	public static NBTTagCompound setColorHex(NBTTagCompound nbt, int color_hex) {
		checkTag(nbt);
		nbt.setInteger("ColorHex", color_hex);
		return nbt;
	}

	public static int getColorHex(NBTTagCompound nbt) {
		return nbt.hasKey("ColorHex") ? nbt.getInteger("ColorHex") : -1;
	}

	public static boolean hasColorHex(int color_hex) {
		return color_hex != -1;
	}
	//-----------------------------------------------------------------------------
	public static NBTTagCompound setRotation(NBTTagCompound nbt, byte rotation) {
		checkTag(nbt);
		nbt.setByte("Rotation", rotation);
		return nbt;
	}

	public static byte getRotation(NBTTagCompound nbt) {
		return nbt.hasKey("Rotation") ? nbt.getByte("Rotation") : (byte)-1;
	}

	public static boolean hasRotation(byte rotation) {
		return rotation != (byte)-1;
	}
	//------------------------------------------------------------------------------------------------------
	public void saveNBTData(NBTTagCompound nbt) {

	}

	public void loadNBTData(NBTTagCompound nbt) {

	}

	public ItemStack saveNBTData(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt == null) {nbt = new NBTTagCompound();}
		return is;
	}

	public ItemStack loadNBTData(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt == null) {nbt = new NBTTagCompound();}
		return is;
	}

	public void readFromNBT(NBTTagCompound nbt) {

	}

	public void writeToNBT(NBTTagCompound nbt) {

	}

	public static void checkTag(NBTTagCompound nbt) {
		if (nbt == null) {nbt = new NBTTagCompound();}
	}
	//------------------------------------------------------------------------------------------------------
}
