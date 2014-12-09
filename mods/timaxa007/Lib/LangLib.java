package mods.timaxa007.Lib;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LangLib{
//private static final String LANGUAGE_PATH="/assets/timaxa007/Lib/";
public static String[] localeFiles={
"/assets/timaxa007/lib/en_US.xml", 
"/assets/timaxa007/lib/ru_RU.xml"
};

public static void registerLanguages() {
for(String localizationFile:localeFiles) {
LanguageRegistry.instance().loadLocalization(localizationFile, getLocaleFromFileName(localizationFile), isXMLLanguageFile(localizationFile));
}
}

public static boolean isXMLLanguageFile(String fileName) {
return fileName.endsWith(".xml");
}

public static String getLocaleFromFileName(String fileName) {
return fileName.substring(fileName.lastIndexOf('/')+1, fileName.lastIndexOf('.'));
}

public static String getLocalizedString(String key) {
return LanguageRegistry.instance().getStringLocalization(key);
}

}
