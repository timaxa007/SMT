package timaxa007.tms.lib;

import java.io.File;

import net.minecraft.client.Minecraft;

public class LangLib {

	private static File file;
	//private static final String LANGUAGE_PATH="/assets/timaxa007/Lib/";
	/*public static String[] localeFiles = {
		"/assets/timaxa007/lib/en_US.xml", 
		"/assets/timaxa007/lib/ru_RU.xml"
	};*/

	public static void init(String mod_id) {
		File preFile = new File("./assets/timaxa007/lang", mod_id + "." + Minecraft.getMinecraft().gameSettings.language);
		if (preFile.exists()) {
			file = preFile;
		}
		System.out.println(preFile.getAbsoluteFile());
		//LanguageRegistry.instance().
	}

	public static boolean is_File_en_US(String fileName) {
		return fileName.endsWith(".en_US");
	}

	public static boolean is_File_ru_RU(String fileName) {
		return fileName.endsWith(".ru_RU");
	}

	public static boolean isXML_File(String fileName) {
		return fileName.endsWith(".xml");
	}

}
