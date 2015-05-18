package timaxa007.module.effect.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import timaxa007.smt.util.UtilString;

public class RegistryEffects {

	private static HashMap<String, Effects> effects_map = new HashMap<String, Effects>();

	public static final Effects EMPTY = new Effects("empty");

	static {
		RegistryEffects.registerEffect(EMPTY);
	}

	public static void registerEffect(Effects effect) {
		if (effect != null && UtilString.hasString(effect.getTag()))
			if (effects_map.get(effect.getTag()) == null)
				effects_map.put(effect.getTag(), effect);
			else throw new IllegalArgumentException("Duplicate " + effect);
		else throw new IllegalArgumentException("Error " + effect);
	}

	public static Effects getEffect(String tag) {
		return (effects_map.get(tag) != null ? effects_map.get(tag) : EMPTY);
	}

	public static List getTagEffects() {
		ArrayList<String> list = new ArrayList<String>();
		for (Entry<String, Effects> entry : effects_map.entrySet())
			list.add(entry.getKey().toString());
		return list;
	}

	public static boolean hasEffect(Effects effect) {
		return !(effect == null || effect == EMPTY);
	}

	public static boolean hasEffect(String tag) {
		return UtilString.hasString(tag) && hasEffect(RegistryEffects.getEffect(tag));
	}
	//-------------------------------------------------------------------------------------------
}
