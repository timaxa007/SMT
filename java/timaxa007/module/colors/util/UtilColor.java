package timaxa007.module.colors.util;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import timaxa007.module.colors.Colors;
import timaxa007.smt.util.UtilRender;
import timaxa007.smt.util.UtilString;

public class UtilColor {
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
			return UtilString.getText("Color") + ": " + textNameColor(Colors.get(hex).getName(), suffix) + ".";
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
		return UtilString.getText("Color") + ": " + red + ", " + green + ", " + blue + ".";
	}
	//------------------------------------------------------------------------------------------------
}
