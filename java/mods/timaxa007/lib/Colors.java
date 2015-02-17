package mods.timaxa007.lib;

import mods.timaxa007.tms.Core;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

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

	public Colors(int hex, String name) {
		if (Core.show_system_info_testing) checkHex(this, hex);
		this.hex = hex;
		list[hex] = this;
		this.name = name;
	}

	public int getColor() {
		return hex;
	}

	public String getName() {
		return name;
	}
	//--------------------------------------------------------
	public static int getColor(Colors clr) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i] == clr)
				return i;
		return 0;
	}

	public static String getName(Colors clr) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i] == clr)
				return list[i].name;
		return null;
	}

	private static void checkHex(Colors colors, int hex) {
		if (list[hex] != null)
			throw new IllegalArgumentException("Duplicate: " + hex + " in " + colors.getClass() + ".");
	}

	public static Colors get(int hex) {
		if (list[hex] != null) return list[hex];
		return null;
	}
	//--------------------------------------------------------
	@Deprecated
	public static final int[] getHexByteColor = new int[] {
		0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xAA, 0xBB, 0xCC, 0xDD, 0xEE, 0xFF
	};

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

	public static void render(EntityPlayer player) {
		ItemStack is = player.getCurrentEquippedItem();
		RenderBlocks rb = new RenderBlocks(player.getEntityWorld());
	}

}
