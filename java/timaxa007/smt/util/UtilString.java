package timaxa007.smt.util;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

public class UtilString {
	//------------------------------------------------------------------------------------------------
	public static final String t_shift = EnumChatFormatting.AQUA + "SHIFT";
	public static final String t_ctrl = EnumChatFormatting.AQUA + "Ctrl";

	public static final String prs = EnumChatFormatting.GRAY + UtilString.getText("pres_key");
	public static final String hld = EnumChatFormatting.GRAY + UtilString.getText("hol_key");
	public static final String inf = EnumChatFormatting.GRAY + UtilString.getText("for_ifo");
	public static final String infabt = EnumChatFormatting.GRAY + UtilString.getText("for_ifo_abt");

	public static final String prshiftinf = prs + " " + t_shift + " " + inf + EnumChatFormatting.RESET;
	public static final String hldshiftinf = hld + " " + t_shift + " " + inf + EnumChatFormatting.RESET;

	public static final String prshiftinfab = prs + " " + t_shift + " " + infabt + EnumChatFormatting.RESET;
	public static final String hldshiftinfab = hld + " " + t_shift + " " + infabt + EnumChatFormatting.RESET;

	public static final String prsctrltinf = prs + " " + t_ctrl + " " + inf + EnumChatFormatting.RESET;
	public static final String hldctrltinf = hld + " " + t_ctrl + " " + inf + EnumChatFormatting.RESET;

	public static final String prsctrltinfab = prs + " " + t_ctrl + " " + infabt + EnumChatFormatting.RESET;
	public static final String hldctrltinfab = hld + " " + t_ctrl + " " + infabt + EnumChatFormatting.RESET;

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

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
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
	public static String ticksToElapsedTime(int time) {
		int j = time / 20;
		int k = j / 60;
		j %= 60;
		return j < 10 ? k + ":0" + j : k + ":" + j;
	}
	//------------------------------------------------------------------------------------------------
}
