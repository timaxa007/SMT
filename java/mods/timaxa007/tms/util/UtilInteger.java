package mods.timaxa007.tms.util;

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

}
