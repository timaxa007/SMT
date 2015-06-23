package timaxa007.module.colors;

import timaxa007.smt.CoreSMT;

public class Colors {

	public static Colors[] list = new Colors[0xFFFFFF];

	public static final Colors not_use_black = new Colors(0x000000, "1");// int = 0
	public static final Colors not_use_white = new Colors(0xFFFFFF, "0");// int = 16777215

	public static final Colors black = new Colors(0x181818, "Black");// int = 1579032
	public static final Colors blue = new Colors(0x0000FF, "Blue");// int = 255
	public static final Colors brown = new Colors(0x884400, "Brown");// int = 8930304
	public static final Colors cyan = new Colors(0x008888, "Cyan");// int = 34952
	public static final Colors gray = new Colors(0x444444, "Gray");// int = 4473924
	public static final Colors green = new Colors(0x008800, "Green");// int = 34816
	public static final Colors light_blue = new Colors(0x00FFFF, "Light_Blue");// int = 65535
	public static final Colors light_gray = new Colors(0xBBBBBB, "Light_Gray");// int = 12303291
	public static final Colors light_green = new Colors(0x00FF00, "Light_Green");// int = 65280
	public static final Colors magenta = new Colors(0xFF00FF, "Magenta");// int = 16711935
	public static final Colors orange = new Colors(0xFF8800, "Orange");// int = 16746496
	public static final Colors pink = new Colors(0xFF8888, "Pink");// int = 16746632
	public static final Colors purple = new Colors(0x8800FF, "Purple");// int = 8913151
	public static final Colors red = new Colors(0xFF0000, "Red");// int = 16711680
	public static final Colors white = new Colors(0xF8F8F8, "White");// int = 16316664
	public static final Colors yellow = new Colors(0xFFFF00, "Yellow");// int = 16776960

	public static class MinecraftColors {
		public static final Colors black = new Colors(0x1E1B1B, "Black");// int = 1973019
		public static final Colors blue = new Colors(0x253192, "Blue");// int = 2437522
		public static final Colors brown = new Colors(0x51301A, "Brown");// int = 5320730
		public static final Colors cyan = new Colors(0x287697, "Cyan");// int = 2651799
		public static final Colors gray = new Colors(0x434343, "Gray");// int = 4408131
		public static final Colors green = new Colors(0x3B511A, "Green");// int = 3887386
		public static final Colors light_blue = new Colors(0x6689D3, "Light_Blue");// int = 6719955
		public static final Colors silver = new Colors(0xA0A0A0, "Silver");// int = 10526880
		public static final Colors lime = new Colors(0x41CD34, "Lime");// int = 4312372
		public static final Colors magenta = new Colors(0xC354CD, "Magenta");// int = 12801229
		public static final Colors orange = new Colors(0xEB8844, "Orange");// int = 15435844
		public static final Colors pink = new Colors(0xD88198, "Pink");// int = 14188952
		public static final Colors purple = new Colors(0x7B2FBE, "Purple");// int = 8073150
		public static final Colors red = new Colors(0xB3312C, "Red");// int = 11743532
		public static final Colors white = new Colors(0xF0F0F0, "White");// int = 15790320
		public static final Colors yellow = new Colors(0xDECF2A, "Yellow");// int = 14602026
	}

	private int hex;
	private String name;

	public Colors(int red, int green, int blue, int alpha, String name) {
		int h = (int)alpha << 24 | (int)red << 16 | (int)green << 8 | (int)blue;
		if (CoreSMT.config.show_system_info_testing) checkHex(this, h);
		this.hex = h;
		list[hex] = this;
		this.name = name;
	}

	public Colors(int hex, String name) {
		if (CoreSMT.config.show_system_info_testing) checkHex(this, hex);
		this.hex = hex;
		list[hex] = this;
		this.name = name;
	}

	public int getColor() {return hex;}
	public String getName() {return name;}
	public int getRed() {return (hex >> 16 & 0xFF);}
	public int getGreen() {return (hex >> 8 & 0xFF);}
	public int getBlue() {return (hex & 0xFF);}
	public int getAlpha() {return (hex >> 24 & 0xFF);}
	//--------------------------------------------------------
	public static int getColor(Colors color) {
		for (Colors clr : list)
			if (clr != null && clr == color)
				return clr.hex;
		return -1;
	}

	public static String getName(Colors color) {
		for (Colors clr : list)
			if (clr != null && clr == color)
				return clr.name;
		return null;
	}

	private static void checkHex(Colors color, int hex) {
		if (list[hex] != null)
			throw new IllegalArgumentException("Duplicate: " + hex + ".");
	}

	public static Colors get(int hex) {
		if (list[hex] != null) return list[hex];
		return null;
	}
	//--------------------------------------------------------
}
