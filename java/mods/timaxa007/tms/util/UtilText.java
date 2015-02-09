package mods.timaxa007.tms.util;

import mods.timaxa007.lib.Colors;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

public class UtilText {
	//------------------------------------------------------------------------------------------------
	public static final String t_shift = EnumChatFormatting.AQUA + "SHIFT";
	public static final String inf = EnumChatFormatting.GRAY + UtilText.getText("for_ifo");

	public static final String prs = EnumChatFormatting.GRAY + UtilText.getText("pres_key");
	public static final String hld = EnumChatFormatting.GRAY + UtilText.getText("hol_key");

	public static final String prshiftinf = prs + " " + t_shift + " " + inf + EnumChatFormatting.RESET;
	public static final String hldshiftinf = hld + " " + t_shift + " " + inf + EnumChatFormatting.RESET;

	public static String getText(String txt) {
		return StatCollector.translateToLocal("text." + txt.toLowerCase());
	}

	public static boolean hasString(String str) {
		return str != null && str.length() > 0;
	}

	public static boolean isShiftKeyDown() {
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
	}

	public static boolean isControlKeyDown() {
		return Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public static boolean isAltKeyDown() {
		return Keyboard.isKeyDown(Keyboard.KEY_LMENU) || Keyboard.isKeyDown(Keyboard.KEY_RMENU);
	}
	//------------------------------------------------------------------------------------------------
	public static String textOnOff_gr(boolean b) {
		return (b ? EnumChatFormatting.GREEN : EnumChatFormatting.RED) + textOnOff(b);
	}

	public static String textOnOff_ag(boolean b) {
		return (b ? EnumChatFormatting.AQUA : EnumChatFormatting.GRAY) + textOnOff(b);
	}

	public static String textOnOff(boolean b) {
		return getText(isOnOff(b));
	}

	public static String isOnOff(boolean b) {
		return b ? "On" : "Off";
	}

	public static String textYesNo_gr(boolean b) {
		return (b ? EnumChatFormatting.GREEN : EnumChatFormatting.RED) + textYesNo(b);
	}

	public static String textYesNo_ag(boolean b) {
		return (b ? EnumChatFormatting.AQUA : EnumChatFormatting.GRAY) + textYesNo(b);
	}

	public static String textYesNo(boolean b) {
		return getText(isYesNo(b));
	}

	public static String isYesNo(boolean b) {
		return b ? "Yes" : "No";
	}

	public static String textYupNope_gr(boolean b) {
		return (b ? EnumChatFormatting.GREEN : EnumChatFormatting.RED) + textYupNope(b);
	}

	public static String textYupNope_ag(boolean b) {
		return (b ? EnumChatFormatting.AQUA : EnumChatFormatting.GRAY) + textYupNope(b);
	}

	public static String textYupNope(boolean b) {
		return getText(isYupNope(b));
	}

	public static String isYupNope(boolean b) {
		return b ? "Yup" : "Nope";
	}

	public static String textEnabledDisabled_gr(boolean b) {
		return (b ? EnumChatFormatting.GREEN : EnumChatFormatting.RED) + textEnabledDisabled(b);
	}

	public static String textEnabledDisabled_ag(boolean b) {
		return (b ? EnumChatFormatting.AQUA : EnumChatFormatting.GRAY) + textEnabledDisabled(b);
	}

	public static String textEnabledDisabled(boolean b) {
		return getText(isEnabledDisabled(b));
	}

	public static String isEnabledDisabled(boolean b) {
		return b ? "Enabled" : "Disabled";
	}
	//------------------------------------------------------------------------------------------------
	public static String textCordXYZ(int x, int y, int z) {
		return "X = " + y + ", Y = " + y + ", Z = " + z + ".";
	}

	public static String textCordXYZ(double x, double y, double z) {
		return "X = " + y + ", Y = " + y + ", Z = " + z + ".";
	}
	//------------------------------------------------------------------------------------------------
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
	//------------------------------------------------------------------------------------------------
}
