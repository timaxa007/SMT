package mods.timaxa007.tms.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBT_Helper {
	//------------------------------------------------------------------------------------------------------
	public static NBTTagCompound setStyle(NBTTagCompound tag, String style) {
		checkTag(tag);
		tag.setString("Style", style);
		return tag;
	}

	public static String getStyle(NBTTagCompound tag) {
		return tag.hasKey("Style") ? tag.getString("Style") : "";
	}

	public static boolean hasStyle(String style) {
		return style != null && style.length() > 0;
	}
	//-----------------------------------------------------------------------------
	public static NBTTagCompound setColorHex(NBTTagCompound tag, int color_hex) {
		checkTag(tag);
		tag.setInteger("ColorHex", color_hex);
		return tag;
	}

	public static int getColorHex(NBTTagCompound tag) {
		return tag.hasKey("ColorHex") ? tag.getInteger("ColorHex") : -1;
	}

	public static boolean hasColorHex(int color_hex) {
		return color_hex != -1;
	}
	//-----------------------------------------------------------------------------
	public static NBTTagCompound setRotation(NBTTagCompound tag, byte rotation) {
		checkTag(tag);
		tag.setByte("Rotation", rotation);
		return tag;
	}

	public static byte getRotation(NBTTagCompound tag) {
		return tag.hasKey("Rotation") ? tag.getByte("Rotation") : (byte)-1;
	}

	public static boolean hasRotation(byte rotation) {
		return rotation != (byte)-1;
	}
	//------------------------------------------------------------------------------------------------------
	public void saveNBTData(NBTTagCompound tag) {

	}

	public void loadNBTData(NBTTagCompound tag) {

	}

	public ItemStack saveNBTData(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag == null) {tag = new NBTTagCompound();}
		return is;
	}

	public ItemStack loadNBTData(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag == null) {tag = new NBTTagCompound();}
		return is;
	}

	public void readFromNBT(NBTTagCompound nbt) {

	}

	public void writeToNBT(NBTTagCompound nbt) {

	}

	public static void checkTag(NBTTagCompound tag) {
		if (tag == null) {tag = new NBTTagCompound();}
	}
	//------------------------------------------------------------------------------------------------------
}
