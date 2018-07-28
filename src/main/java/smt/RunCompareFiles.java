package smt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RunCompareFiles {

	public static void main(String[] args) {
		compareFiles(new File("text1.txt"), new File("text2.txt"));
	}

	public static void compareFiles(File file1, File file2) {

		FileReader fr1 = null;
		try {
			fr1 = new FileReader(file1);
		} catch (FileNotFoundException e) {e.printStackTrace();}

		FileReader fr2 = null;
		try {
			fr2 = new FileReader(file2);
		} catch (FileNotFoundException e) {e.printStackTrace();}

		if (fr1 != null && fr2 != null) {
			String line;

			BufferedReader br1 = new BufferedReader(fr1);
			ArrayList<String> list1 = new ArrayList<String>();
			try {while((line = br1.readLine()) != null) list1.add(line);}
			catch (IOException e1) {e1.printStackTrace();}

			BufferedReader br2 = new BufferedReader(fr2);
			ArrayList<String> list2 = new ArrayList<String>();
			try {while((line = br2.readLine()) != null) list2.add(line);}
			catch (IOException e2) {e2.printStackTrace();}

			for (int i = 0; i < Math.min(list1.size(), list2.size()); ++i) {
				String a = list1.get(i);
				String b = list2.get(i);
				if (!a.equals(b)) {
					System.out.println("\"" + a + "\" not equal \"" + b + "\"");
				}
			}

			try {fr1.close();} catch (IOException e) {e.printStackTrace();}
			try {fr2.close();} catch (IOException e) {e.printStackTrace();}
		}

	}

}
