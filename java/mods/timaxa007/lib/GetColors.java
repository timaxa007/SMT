package mods.timaxa007.lib;

public class GetColors {

	public static final String[] getNameColors = new String[] {
		"black", 		// 0 Black
		"blue", 		// 1 Blue
		"brown", 		// 2 Brown
		"cyan", 		// 3 Cyan
		"gray", 		// 4 Gray
		"green", 		// 5 Green
		"light_blue", 	// 6 Light_Blue
		"light_gray", 	// 7 Light_Gray
		"light_green", 	// 9 Light_Green
		"magenta", 		// 9 Magenta
		"orange", 		//10 Orange
		"pink", 		//11 Pink
		"purple", 		//12 Purple
		"red", 			//13 Red
		"white", 		//14 White
		"yellow"		//15 Yellow
	};

	@Deprecated
	public static final String[] getName2Colors = new String[] {
		"Black", 
		"Blue", 
		"Brown", 
		"Cyan", 
		"Gray", 
		"Green", 
		"Light-Blue", 
		"Light-Gray", 
		"Light-Green", 
		"Magenta", 
		"Orange", 
		"Pink", 
		"Purple", 
		"Red", 
		"White", 
		"Yellow"
	};

	public static final int[] getHexVanilaColors = new int[] {
		1973019, 	// 0 Black
		2437522, 	// 1 Blue
		5320730, 	// 2 Brown
		2651799, 	// 3 Cyan
		4408131, 	// 4 Gray
		3887386, 	// 5 Green
		6719955, 	// 6 Light-Blue
		10526880, 	// 7 Light-Gray
		4312372, 	// 8 Light-Green
		12801229, 	// 9 Magenta
		15435844, 	//10 Orange
		14188952, 	//11 Pink
		8073150, 	//12 Purple
		11743532, 	//13 Red
		15790320, 	//14 White
		14602026	//15 Yellow
	};

	public static final int[] getHexColors = new int[] {
		0x181818, 	// 0 Black
		0x0000FF, 	// 1 Blue
		0x884400, 	// 2 Brown
		0x008888, 	// 3 Cyan
		0x444444, 	// 4 Gray
		0x008800, 	// 5 Green
		0x00FFFF, 	// 6 Light-Blue
		0xBBBBBB, 	// 7 Light-Gray
		0x00FF00, 	// 8 Light-Green
		0xFF00FF, 	// 9 Magenta
		0xFF8800, 	//10 Orange
		0xFF8888, 	//11 Pink
		0x8800FF, 	//12 Purple
		0xFF0000, 	//13 Red
		0xFFFFFF, 	//14 White
		0xFFFF00	//15 Yellow
	};

	public enum color {
		BLACK(0, 0x222222, 1973019, "black"), 
		BLUE(1, 0x0000FF, 2437522, "blue"), 
		BROWN(2, 0x884400, 5320730, "brown"), 
		CYAN(3, 0x008888, 2651799, "cyan"), 
		GRAY(4, 0x444444, 4408131, "gray"), 
		GREEN(5, 0x008800, 3887386, "green"), 
		LIGHTBLUE(6, 0x00FFFF, 6719955, "light_blue"), 
		LIGHTGRAY(7, 0xBBBBBB, 10526880, "light_gray"), 
		LIGHTGREEN(8, 0x00FF00, 4312372, "light_green"), 
		MAGENTA(9, 0xFF00FF, 12801229, "magenta"), 
		ORANGE(10, 0xFF8800, 15435844, "orange"), 
		PINK(11, 0xFF8888, 14188952, "pink"), 
		PURPLE(12, 0x8800FF, 8073150, "purple"), 
		RED(13, 0xFF0000, 11743532, "red"), 
		WHITE(14, 0xFFFFFF, 15790320, "white"), 
		YELLOW(15, 0xFFFF00, 14602026, "yellow"), 
		NONE(16, 0x000000, 0x000000, "none");

		public int id;
		public int color_hex;
		public int color_hex_vanilla;
		public String name;

		static boolean hasStrCode(String str) {
			for (color j : color.values()) {
				if (str.equalsIgnoreCase(j.toString())) {
					return true;
				}
			}
			return false;
		}

		private color(int ids, int hex, int hexVn, String stg) {
			id = ids;
			color_hex = hex;
			color_hex_vanilla = hexVn;
			name = stg;
		}

	}

	@Deprecated
	public static final int[] getHexByteColor = new int[] {
		0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xAA, 0xBB, 0xCC, 0xDD, 0xEE, 0xFF
	};

	public static int convertME_MC(int i) {
		switch(i) {
		case 0:return 15;
		case 1:return 11;
		case 2:return 12;
		case 3:return 9;
		case 4:return 7;
		case 5:return 13;
		case 6:return 3;
		case 7:return 8;
		case 8:return 5;
		case 9:return 2;
		case 10:return 1;
		case 11:return 6;
		case 12:return 10;
		case 13:return 14;
		case 14:return 0;
		case 15:return 4;
		default:return i;
		}
	}

	public static int convertMC_ME(int i) {
		switch(i) {
		case 0:return 14;
		case 1:return 9;
		case 2:return 8;
		case 3:return 6;
		case 4:return 15;
		case 5:return 7;
		case 6:return 10;
		case 7:return 5;
		case 8:return 13;
		case 9:return 13;
		case 10:return 3;
		case 11:return 11;
		case 12:return 1;
		case 13:return 2;
		case 14:return 12;
		case 15:return 1;
		default:return i;
		}
	}

	public static int convertME_MCitem(int i) {
		switch(i) {
		case 0:return 0;
		case 1:return 4;
		case 2:return 3;
		case 3:return 6;
		case 4:return 8;
		case 5:return 2;
		case 6:return 12;
		case 7:return 7;
		case 8:return 10;
		case 9:return 13;
		case 10:return 14;
		case 11:return 9;
		case 12:return 5;
		case 13:return 1;
		case 14:return 15;
		case 15:return 11;
		default:return i;
		}
	}

	public static int convertMC_MEitem(int i) {
		switch(i) {
		case 0:return 0;
		case 1:return 13;
		case 2:return 5;
		case 3:return 2;
		case 4:return 1;
		case 5:return 12;
		case 6:return 3;
		case 7:return 7;
		case 8:return 4;
		case 9:return 11;
		case 10:return 8;
		case 11:return 15;
		case 12:return 6;
		case 13:return 9;
		case 14:return 10;
		case 15:return 14;
		default:return i;
		}
	}

	/*
public static int colorHex(String color) {
int clr = 16777215;
for(byte i = 0;i>16;i++) {if (getNameColors[i] =  = color) {clr = getHexColors[i];}}
return clr;
}
	 */
	@Deprecated
	public static int convertI_HEX(int r, int g, int b) {
		int ir = getHexByteColor[r];int ig = getHexByteColor[g];int ib = getHexByteColor[b];
		return (int)ir<<16|(int)ig<<8|(int)ib;
	}

	@Deprecated
	public static int convertF_HEX(float r, float g, float b) {
		float fr = r;if (fr<0.0F) {fr = 0.0F;}if (fr>255.0F) {fr = 255.0F;}
		float fg = g;if (fg<0.0F) {fg = 0.0F;}if (fg>255.0F) {fg = 255.0F;}
		float fb = b;if (fb<0.0F) {fb = 0.0F;}if (fb>255.0F) {fb = 255.0F;}
		return (int)fr<<16|(int)fg<<8|(int)fb;
	}

	public static int getColorMix(int clr1, int clr2) {
		int r1 = (int)(clr1 >> 16 & 255);int g1 = (int)(clr1 >> 8 & 255);int b1 = (int)(clr1 >> 0 & 255);
		int r2 = (int)(clr2 >> 16 & 255);int g2 = (int)(clr2 >> 8 & 255);int b2 = (int)(clr2 >> 0 & 255);
		int r3 = ((r1 + r2) / 2);int g3 = ((g1 + g2) / 2);int b3 = ((b1 + b2) / 2);
		return (int)r3 << 16 | (int)g3 << 8 | (int)b3;
	}

	public static int getColorMix(int clr1, int clr2, int i, boolean flag) {
		int r1 = (int)(clr1 >> 16 & 255);int g1 = (int)(clr1 >> 8 & 255);int b1 = (int)(clr1 >> 0 & 255);
		int r2 = (int)(clr2 >> 16 & 255);int g2 = (int)(clr2 >> 8 & 255);int b2 = (int)(clr2 >> 0 & 255);
		int r3 = 0;int g3 = 0;int b3 = 0;
		if (flag) {
			r3 = (((r1 * i) + r2) / (i + 1));g3 = (((g1 * i) + g2) / (i + 1));b3 = (((b1 * i) + b2) / (i + 1));
		} else {
			r3 = ((r1 + (r2 * i)) / (i + 1));g3 = ((g1 + (g2 * i)) / (i + 1));b3 = ((b1 + (b2 * i)) / (i + 1));
		}
		return (int)r3 << 16 | (int)g3 << 8 | (int)b3;
	}

}
