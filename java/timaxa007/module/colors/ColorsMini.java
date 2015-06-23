package timaxa007.module.colors;

import timaxa007.smt.CoreSMT;

public class ColorsMini {

	public static ColorsMini[] list = new ColorsMini[0xFFF];

	//public static final ColorsMini not_use_black = new ColorsMini(0x000, "1");
	//public static final ColorsMini not_use_white = new ColorsMini(0xFFF, "0");

	public static final ColorsMini black = new ColorsMini(0x111, "Black");
	public static final ColorsMini blue = new ColorsMini(0x00F, "Blue");
	public static final ColorsMini brown = new ColorsMini(0x840, "Brown");
	public static final ColorsMini cyan = new ColorsMini(0x088, "Cyan");
	public static final ColorsMini gray = new ColorsMini(0x444, "Gray");
	public static final ColorsMini green = new ColorsMini(0x080, "Green");
	public static final ColorsMini light_blue = new ColorsMini(0x0FF, "Light_Blue");
	public static final ColorsMini light_gray = new ColorsMini(0xBBB, "Light_Gray");
	public static final ColorsMini light_green = new ColorsMini(0x0F0, "Light_Green");
	public static final ColorsMini magenta = new ColorsMini(0xF0F, "Magenta");
	public static final ColorsMini orange = new ColorsMini(0xF80, "Orange");
	public static final ColorsMini pink = new ColorsMini(0xF88, "Pink");
	public static final ColorsMini purple = new ColorsMini(0x80F, "Purple");
	public static final ColorsMini red = new ColorsMini(0xF00, "Red");
	public static final ColorsMini white = new ColorsMini(0xEEE, "White");
	public static final ColorsMini yellow = new ColorsMini(0xFF0, "Yellow");

	private int hex;
	private String name;

	public ColorsMini(int red, int green, int blue, int alpha, String name) {
		int h = (int)alpha << 12 | (int)red << 8 | (int)green << 4 | (int)blue;
		if (CoreSMT.config.show_system_info_testing) checkHex(this, h);
		this.hex = h;
		list[hex] = this;
		this.name = name;
	}

	public ColorsMini(int hex, String name) {
		if (CoreSMT.config.show_system_info_testing) checkHex(this, hex);
		this.hex = hex;
		list[hex] = this;
		this.name = name;
	}

	public int getColor() {return hex;}
	public String getName() {return name;}
	public int getRed() {return (hex >> 8 & 0xF);}
	public int getGreen() {return (hex >> 4 & 0xF);}
	public int getBlue() {return (hex & 0xF);}
	public int getAlpha() {return (hex >> 12 & 0xF);}
	//--------------------------------------------------------
	public static int getColor(ColorsMini color) {
		for (ColorsMini clr : list)
			if (clr != null && clr == color)
				return clr.hex;
		return -1;
	}

	public static String getName(ColorsMini color) {
		for (ColorsMini clr : list)
			if (clr != null && clr == color)
				return clr.name;
		return null;
	}

	private static void checkHex(ColorsMini color, int hex) {
		if (list[hex] != null)
			throw new IllegalArgumentException("Duplicate: " + hex + ".");
	}

	public static ColorsMini get(int hex) {
		if (list[hex] != null) return list[hex];
		return null;
	}
	//--------------------------------------------------------
}
