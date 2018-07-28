package smt.pack.privacy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTerritory {

	//BufferedReader buffer = new BufferedReader(new InputStreamReader(YourCoreClass.class.getResourceAsStream(путь к файлу""), "UTF-8"));
	//Files.write(path, "hi".getBytes("UTF-8"));

	public static String readFromFile(String fileName) {
		String filePath = "./territory/" + fileName;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;

		if (new File(filePath).exists()) {
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
				String line;
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	            }
				br.close();
			}
			catch (FileNotFoundException e) {e.printStackTrace();}
			catch (IOException e) {e.printStackTrace();}
		} else {
			try {new File(filePath).createNewFile();}
			catch (IOException e) {e.printStackTrace();}
		}

		return sb.toString();
	}

	public static void writeToFile(String fileName, String text) {
		File folder = new File("./territory/");
		folder.mkdir();
		try {
			FileWriter writer = new FileWriter("./territory/" + fileName, false);
			writer.write(text);
			writer.close();
		}
		catch (IOException e) {e.printStackTrace();}
	}

}
