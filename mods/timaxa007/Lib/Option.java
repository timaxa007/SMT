package mods.timaxa007.Lib;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class Option {

public static final Object prshift = EnumChatFormatting.GRAY + Option.getText("hol_key") + " " + EnumChatFormatting.AQUA + "SHIFT" + EnumChatFormatting.GRAY + " " + Option.getText("for_ifo");

public static String getText(String txt) {
return StatCollector.translateToLocal("text." + txt.toLowerCase());
}

public static String GetColors(int i, String t) {
return StatCollector.translateToLocal("color." + GetColors.getNameColors[i] + "." + t);
}

}
