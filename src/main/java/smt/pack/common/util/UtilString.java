package smt.pack.common.util;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;

public class UtilString {

	@SideOnly(Side.CLIENT)
	public static List<String> unname1(String text, FontRenderer font, int width) {
		char[] cr = text.toCharArray();
		List<String> sb = new ArrayList<String>();
		String blank = "";
		int row = 0;
		for (int i = 0; i < cr.length; ++i) {

			if (cr[i] == '\n') {
				sb.add(blank);
				blank = "";
				row = 0;
			} else if (cr[i] == '\t') {
				blank += "   ";
				row += font.getStringWidth("   ");
			} else {
				blank += cr[i];
				row += font.getCharWidth(cr[i]);
			}

			if (row > width) {
				sb.add(blank);
				blank = "";
				row = 0;
			}
		}
		//if (cr.length - ((cr.length / width) * width) <= width)
		if (blank.length() > 0) {
			sb.add(blank);
			blank = "";
			row = 0;
		}
		return sb;
	}

	@SideOnly(Side.CLIENT)
	public static List<String> unname2(String text, FontRenderer font, int width) {
		String[] ss = text.split(" ");
		List<String> sb = new ArrayList<String>();
		String blank = "";
		int row = 0;
		for (int j = 0; j < ss.length; ++j) {
			char[] cr = ss[j].toCharArray();
			for (int k = 0; k < cr.length; ++k) {
				if (cr[k] == '\n') {
					sb.add(blank);
					blank = "";
					row = 0;
				} else if (cr[k] == '\t') {
					blank += "   ";
					row += font.getStringWidth("   ");
				} else {
					blank += cr[k];
					row += font.getCharWidth(cr[k]);
				}
			}

			blank += " ";
			row += font.getStringWidth(" ");

			if (j < ss.length - 1 && row + getStringWidth2(ss[j + 1], font) > width) {
				sb.add(blank);
				blank = "";
				row = 0;
			} else if (row > width) {
				sb.add(blank);
				blank = "";
				row = 0;
			}
		}

		//if (cr.length - ((cr.length / width) * width) <= width)
		if (blank.length() > 0) {
			sb.add(blank);
			blank = "";
			row = 0;
		}

		return sb;
	}

	@SideOnly(Side.CLIENT)
	public static int getStringWidth2(String text, FontRenderer font) {
		char[] cr = text.toCharArray();
		int row = 0;
		for (int i = 0; i < cr.length; ++i) {
			if (cr[i] == '\n') {
				return row;
			} else if (cr[i] == '\t') {
				row += font.getStringWidth("   ");
			} else {
				row += font.getCharWidth(cr[i]);
			}
		}
		return row;
	}

}
