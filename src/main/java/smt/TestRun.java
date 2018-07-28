package smt;

public class TestRun {

	public static void main(String[] args) {
		System.out.println(0 << 1 | 0);
		System.out.println(0 << 1 | 1);
		System.out.println(0 << 1 | 2);
		
		System.out.println(1 << 1 | 0);
		System.out.println(1 << 1 | 1);
		System.out.println(1 << 1 | 2);
		
		System.out.println(2 << 1 | 0);
		System.out.println(2 << 1 | 1);
		System.out.println(2 << 1 | 2);
	}
	/*
	public static void main(String[] args) {
		System.out.println((char)27 + "[31mThis text would show up red" + (char)27 + "[0m");
	    System.out.println("\033[31;1mHello\033[0m, \033[32;1;2mworld!\033[0m");
	    System.out.println("\033[31mRed\033[32m, Green\033[33m, Yellow\033[34m, Blue\033[0m");
	    System.out.println((char)27 + "[31mTest red color");
	    System.out.println("\u001B[32m" + "Я пробовал это.");
	}
	 */
	/*
	static int money = 1000000;
	public static void main(String[] args) {
		System.out.println("money = " + money);
		
		setMoney(money + money);
		System.out.println("money = " + money);
		
		addMoney(1000);
		System.out.println("money = " + money);

	}
	public static void addMoney(int money) {
		//int copper = money & 1023;
		//int silver = money >> 10 & 1023;
		//int gold = money >> 20 & 1023;

		int copper = money % 1000;
		int silver = (money / 1000) % 1000;
		int gold = money / 1000000;

		copper += getCopper();
		if (copper >= 1000) {
			silver += copper / 1000;
			copper %= 1000;
		}

		silver += getSilver();
		if (silver >= 1000) {
			gold += silver / 1000;
			silver %= 1000;
		}

		gold += getGold();

		setMoney((gold * 1000000) + (silver * 1000) + copper);
	}

	public static void setMoney(int money2) {
		money = money2;
	}

	public static int getMoney() {
		return money;
	}

	public static int getCopper() {
		//return money & 1023;
		return money % 1000;
	}

	public static int getSilver() {
		//return money >> 10 & 1023;
		return (money / 1000) % 1000;
	}

	public static int getGold() {
		//return money >> 20 & 1023;
		return money / 1000000;
	}
*/
	/*
	public static void main(String[] args) {
		int money = 0x7FFFFFFF & 0xFFFFFFFF;
		System.out.println("money = " + money);

		System.out.println();

		int gold1 = money / 1000000;
		System.out.println("gold = " + gold1);

		int silver1 = (money / 1000) % 1000;
		System.out.println("silver = " + silver1);

		int copper1 = money % 1000;
		System.out.println("copper = " + copper1);

		System.out.println();

		int gold2 = money >> 20;
		System.out.println("gold = " + gold2);

		int silver2 = money >> 10 & 1023;
		System.out.println("silver = " + silver2);

		int copper2 = money & 1023;
		System.out.println("copper = " + copper2);

	}
	*/
	/*
	public static void main(String[] args) {
		int dir = 8;
		int dirShift = (int)Math.round(Math.sqrt(dir));
		System.out.println(dirShift);

		int all = (7 << 3 << dirShift << dirShift | 5 << 3 << dirShift | 8 << 3 | 5);
		int a1 = (all >> 3 >> dirShift >> dirShift) & (dir - 1);
		int a2 = (all >> 3 >> dirShift) & (dir - 1);
		int a3 = (all >> 3) & (dir - 1);
		int b = all & 5;
		System.out.println(a1 + " - " + a2 + " - " + a3 + " - " + b);
	}
	 */
	/*
	public static void main(String[] args) {
		byte b = 0;
		for (int i = 0; i < 10; ++i) {
			a();
			b();
		}
	}
	 */
	/*
	private static void a() {
		int all = 8 << 3 | 5;
		Date before = new Date();
		for (int j = 1; j < Integer.MAX_VALUE; j++) {
			int a = 0;
			for (int i = 0; i< 10; i++){
				a = all & 5;
			}
		}
		Date after = new Date();
		System.out.println("Multiplying " + (after.getTime()-before.getTime()) + " milliseconds");
	}

	private static void b() {
		int all = 8 << 3 | 5;
		Date before = new Date();
		for (int j = 1; j < Integer.MAX_VALUE; j++) {
			int a = 0;
			for (int i = 0; i< 10; i++){
				a = all % 5;
			}
		}
		Date after = new Date();
		System.out.println("Shifting " + (after.getTime()-before.getTime()) + " milliseconds");
	}
	 */
	/*
	private static void a() {
		Date before = new Date();
		for (int j = 1; j < Integer.MAX_VALUE; j++) {
			int a = 1 ;
			for (int i = 0; i< 10; i++){
				a *=2;
			}
		}
		Date after = new Date();
		System.out.println("Multiplying " + (after.getTime()-before.getTime()) + " milliseconds");
	}

	private static void b() {
		Date before = new Date();
		for (int j = 1; j < Integer.MAX_VALUE; j++) {
			int a = 1 ;
			for (int i = 0; i< 10; i++){
				a <<= 1;
			}
		}
		Date after = new Date();
		System.out.println("Shifting " + (after.getTime()-before.getTime()) + " milliseconds");
	}
	 */
}
