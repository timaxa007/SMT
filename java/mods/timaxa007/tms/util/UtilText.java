package mods.timaxa007.tms.util;

import mods.timaxa007.lib.Colors;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

public class UtilText {

	public static final String t_shift = EnumChatFormatting.AQUA + "SHIFT";
	public static final String inf = EnumChatFormatting.GRAY + " " + UtilText.getText("for_ifo");

	public static final String prs = EnumChatFormatting.GRAY + UtilText.getText("pres_key");
	public static final String hld = EnumChatFormatting.GRAY + UtilText.getText("hol_key");

	public static final String prshiftinf = prs + " " + t_shift + " " + inf;
	public static final String hldshiftinf = hld + " " + t_shift + " " + inf;

	public static String getText(String txt) {
		return StatCollector.translateToLocal("text." + txt.toLowerCase());
	}

	public static boolean isShiftKeyDown() {
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
	}

	public static String textYesNo(boolean b) {
		return b ? "Yes" : "No";
	}

	public static String textYesNo_gr(boolean b) {
		return b ? (EnumChatFormatting.GREEN + "Yes") : (EnumChatFormatting.RED + "No");
	}

	public static String textYesNo_ag(boolean b) {
		return b ? (EnumChatFormatting.AQUA + "Yes") : (EnumChatFormatting.GRAY + "No");
	}

	public static String textOnOff(boolean b) {
		return b ? "On" : "Off";
	}

	public static String textOnOff_gr(boolean b) {
		return b ? (EnumChatFormatting.GREEN + "On") : (EnumChatFormatting.RED + "Off");
	}

	public static String textOnOff_ag(boolean b) {
		return b ? (EnumChatFormatting.AQUA + "On") : (EnumChatFormatting.GRAY + "Off");
	}

	public static String textCordXYZ(int x, int y, int z) {
		return "X = " + y + ", Y = " + y + ", Z = " + z + ".";
	}

	public static String textCordXYZ_bold(int x, int y, int z) {
		return "" + EnumChatFormatting.BOLD + EnumChatFormatting.WHITE + "X" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.BOLD + y + EnumChatFormatting.RESET + ", " + 
				EnumChatFormatting.BOLD + EnumChatFormatting.WHITE + "Y" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.BOLD + y + EnumChatFormatting.RESET + ", " + 
				EnumChatFormatting.BOLD + EnumChatFormatting.WHITE + "Z" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.BOLD + z + EnumChatFormatting.RESET + ".";
	}

	public static String textCordXYZ_gb(int x, int y, int z) {
		return "" + EnumChatFormatting.GOLD + "X" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.AQUA + y + EnumChatFormatting.RESET + ", " + 
				EnumChatFormatting.GOLD + "Y" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.AQUA + y + EnumChatFormatting.RESET + ", " + 
				EnumChatFormatting.GOLD + "Z" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.AQUA + z + EnumChatFormatting.RESET + ".";
	}

	public static String textCordXYZ_bold(double x, double y, double z) {
		return "" + EnumChatFormatting.BOLD + EnumChatFormatting.WHITE + "X" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.BOLD + y + EnumChatFormatting.RESET + ", " + 
				EnumChatFormatting.BOLD + EnumChatFormatting.WHITE + "Y" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.BOLD + y + EnumChatFormatting.RESET + ", " + 
				EnumChatFormatting.BOLD + EnumChatFormatting.WHITE + "Z" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.BOLD + z + EnumChatFormatting.RESET + ".";
	}

	public static String textCordXYZ_gb(double x, double y, double z) {
		return "" + EnumChatFormatting.GOLD + "X" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.AQUA + y + EnumChatFormatting.RESET + ", " + 
				EnumChatFormatting.GOLD + "Y" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.AQUA + y + EnumChatFormatting.RESET + ", " + 
				EnumChatFormatting.GOLD + "Z" + 
				EnumChatFormatting.RESET + " = " + EnumChatFormatting.AQUA + z + EnumChatFormatting.RESET + ".";
	}

	public static String textColors(int hex) {
		return textColors(hex, "a");
	}

	public static String textColors(int hex, String suffix) {
		if (Colors.get(hex) != null) return textColorHex(hex, suffix);
		else return textColorRGB(hex);
	}

	public static String textColorHex(int hex) {
		return textColorHex(hex, "a");
	}

	public static String textColorHex(int hex, String suffix) {
		if (Colors.get(hex) != null)
			return UtilText.getText("Color") + ": " + textNameColor(Colors.get(hex).getName(), suffix) + ".";
		return null;
	}

	/**@param suffix - <br>
	 * suffix "<b>a</b>" - man's face, <br>
	 * suffix "<b>b</b>" - woman's face, <br>
	 * suffix "<b>c</b>" - average's face, <br>
	 * suffix "<b>s</b>" - plural.
	 * @param name - Will be transformed into a <b>name.toLowerCase()</b>.**/
	public static String textNameColor(String name, String suffix) {
		return StatCollector.translateToLocal("color." + name.toLowerCase() + "." + suffix);
	}

	public static String textColorRGB(int hex) {
		int[] colors = UtilRender.getRGB_i(hex);
		String red = EnumChatFormatting.RED + "Red: " + Integer.toString(colors[0]) + EnumChatFormatting.RESET;
		String green = EnumChatFormatting.GREEN + "Green: " + Integer.toString(colors[1]) + EnumChatFormatting.RESET;
		String blue = EnumChatFormatting.BLUE + "Blue: " + Integer.toString(colors[2]) + EnumChatFormatting.RESET;
		return UtilText.getText("Color") + ": " + red + ", " + green + ", " + blue + ".";
	}

}
