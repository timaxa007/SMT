package timaxa007.pack.mining.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import timaxa007.smt.util.UtilString;

public class RegistryOre {

	private static HashMap<String, Ore> ore_map = new HashMap<String, Ore>();

	public static final Ore EMPTY = new Ore("empty");

	static {
		RegistryOre.registerOre(EMPTY);
	}

	public static void registerOre(Ore[] ores) {
		for (Ore ore : ores) if (ore != null) registerOre(ore);
	}

	public static void registerOre(Ore ore) {
		if (ore != null && UtilString.hasString(ore.getTag()))
			if (ore_map.get(ore.getTag()) == null)
				ore_map.put(ore.getTag(), ore);
			else throw new IllegalArgumentException("Duplicate " + ore);
		else throw new IllegalArgumentException("Error " + ore);
	}

	public static Ore getOre(String tag) {
		return (ore_map.get(tag) != null ? ore_map.get(tag) : EMPTY);
	}

	public static List getTagOres() {
		ArrayList<String> list = new ArrayList<String>();
		for (Entry<String, Ore> entry : ore_map.entrySet())
			list.add(entry.getKey().toString());
		return list;
	}

	public static boolean hasOre(Ore ore) {
		return !(ore == null || ore == EMPTY);
	}

	public static boolean hasOre(String tag) {
		return UtilString.hasString(tag) && hasOre(RegistryOre.getOre(tag));
	}
	//-------------------------------------------------------------------------------------------
}
