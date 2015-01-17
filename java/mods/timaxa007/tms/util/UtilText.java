package mods.timaxa007.tms.util;

import org.lwjgl.input.Keyboard;

import mods.timaxa007.lib.GetColors;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class UtilText {

	public static final String t_shift = EnumChatFormatting.AQUA + "SHIFT";
	public static final String inf = EnumChatFormatting.GRAY + " " + UtilText.getText("for_ifo");

	public static final String prs = EnumChatFormatting.GRAY + UtilText.getText("pres_key");
	public static final String hld = EnumChatFormatting.GRAY + UtilText.getText("hol_key");

	public static final String prshiftinf = prs + " " + t_shift + " " + " " + inf;
	public static final String hldshiftinf = hld + " " + t_shift + " " + " " + inf;

	public static String getText(String txt) {
		return StatCollector.translateToLocal("text." + txt.toLowerCase());
	}

	public static String getColors(int i, String t) {
		return StatCollector.translateToLocal("color." + GetColors.getNameColors[i] + "." + t);
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

}
