package timaxa007.smt.util;

public class UtilInteger {

	public static int minuteToTick(int minute) {
		return 60 * secondToTick(minute);
	}

	public static int secondToTick(int second) {
		return second * 20;
	}

	public static int[] tickToMinute(int tick) {
		int i1 = tick / (20 * 60);
		int i2 = tick - (i1 * 20 * 60);
		return new int[] {i1, i2};
	}

	public static int[] tickToSecond(int tick) {
		//if (i < 20) System.out.println("Small for second, need adding " + (20 - i));
		int i1 = tick / 20;
		int i2 = tick - (i1 * 20);
		return new int[] {i1, i2};
	}

	public static int[] secondToMinute(int tick) {
		int i1 = tick / 60;
		int i2 = tick - (i1 * 60);
		return new int[] {i1, i2};
	}

	public static int setMaxByte(int byt) {
		return byt - 128;
	}

	public static int getMaxByte(int byt) {
		return byt + 128;
	}

	//for joke
	public static int[] getFormatTime(int time) {

		int a = -1;
		int a_ = -1;

		int b = -1;
		int b_ = -1;

		int c = -1;
		int c_ = -1;

		int d = -1;
		int d_ = -1;

		if (time >= (60 * 60 * 60)) {
			a = time / (60 * 60 * 60);
			//-------------------------
			if (a > (60 * 60)) {
				b = a / (60 * 60);
				//-------------------------
				if (b > 60) {
					c = b / 60;
					//-------------------------
					d = c;
					d_ = c - d;
					//-------------------------
				} else {
					b_ = a - b;
				}
				//-------------------------
			} else {
				a_ = time - a;
			}
			//-------------------------
		}

		else if (time > (60 * 60)) {
			b = time / (60 * 60);
			//-------------------------
			if (b > 60) {
				c = b / 60;
				//-------------------------
				d = c;
				d_ = c - d;
				//-------------------------
			} else {
				b_ = time - b;
			}
			//-------------------------
		}

		else if (time > 60) {
			c = time / 60;
			//-------------------------
			d = c;
			d_ = c - d;
			//-------------------------
		}

		else if (time < 60) {
			d = time / 60;
			d_ = time - b;
		}

		return new int[] {a, a_, b, b_, c, c_, d, d_};

		/*for test*//*String text_time = "" + 
				timer[0] + " : " + timer[1] + ", " + 
				timer[2] + " : " + timer[3] + ", " + 
				timer[4] + " : " + timer[5] + ", " + 
				timer[6] + " : " + timer[7] + "";*/
	}
	//-----------------------------------------------------
	public enum RomanNumeral {

		RomanNumeral1(0x0, 1, "I"),
		RomanNumeral2(0x1, 2, "II"),
		RomanNumeral3(0x2, 3, "III"),
		RomanNumeral4(0x3, 4, "IV"),
		RomanNumeral5(0x4, 5, "V"),
		RomanNumeral6(0x5, 6, "VI"),
		RomanNumeral7(0x6, 7, "VII"),
		RomanNumeral8(0x7, 8, "VIII"),
		RomanNumeral9(0x8, 9, "IX"),
		RomanNumeral10(0x9, 10, "X"),
		RomanNumeral11(0xA, 11, "XI"),
		RomanNumeral12(0xB, 12, "VII"),
		RomanNumeral50(0xC, 50, "L"),
		RomanNumeral100(0xD, 100, "C"),
		RomanNumeral500(0xE, 500, "D"),
		RomanNumeral1000(0xF, 1000, "M");

		int hex;
		int num;
		String name;

		RomanNumeral(int i, int j, String k) {
			hex = i;
			num = j;
			name = k;
		}

	}
	//-----------------------------------------------------
}
