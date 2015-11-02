package smt.core.substance;

import smt.core.SMTContainer;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstanceRegistry {
	//-----------------------------------------------------------------------------------------------
	private static HashMap<String, Substance> substance_map = new HashMap<>();
	private static ArrayList<String> substance_list = new ArrayList<String>();
	public static final Substance EMPTY = new Substance("empty");

	static {
		SubstanceRegistry.registerSubstance(EMPTY);
	}
	//-----------------------------------------------------------------------------------------------
	public static void registerSubstance(Substance... substances) {
		for (Substance substance : substances)
			registerSubstance(substance.getTag(), substance);
	}

	public static void registerSubstance(String tag, Substance substance) {
		if (tag != null && tag.length() > 0 && substance != null) {
			if (substance_map.get(tag) == null) {
				substance_map.put(tag, substance);
				substance_list.add(tag);
			} SMTContainer.log.error("[SubstanceRegistry] Such a Substance exists.");
		} else SMTContainer.log.error("[SubstanceRegistry] Substance " + (substance == null ? "equal null." :
			("tag " + (tag == null ? "equal null" : tag.length() <= 0 ? "size equal or less than zero" : "[ERROR]") + ".")));
	}
	//-----------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------
	private static HashMap<String, SubstanceType> substance_type_map = new HashMap<>();
	private static ArrayList<String> substance_type_list = new ArrayList<String>();
	public static final SubstanceType NONE = new SubstanceType("none");

	static {
		SubstanceRegistry.registerSubstanceType(NONE);
	}
	//-----------------------------------------------------------------------------------------------
	public static void registerSubstanceType(SubstanceType... substance_types) {
		for (SubstanceType substance_type : substance_types)
			registerSubstanceType(substance_type.getTag(), substance_type);
	}

	public static void registerSubstanceType(String tag, SubstanceType substance_type) {
		if (tag != null && tag.length() > 0 && substance_type != null) {
			if (substance_type_map.get(tag) == null) {
				substance_type_map.put(tag, substance_type);
				substance_type_list.add(tag);
			} SMTContainer.log.error("[SubstanceRegistry] Such a SubstanceType exists.");
		} else SMTContainer.log.error("[SubstanceRegistry] SubstanceType " + (substance_type == null ? "equal null." :
			("tag " + (tag == null ? "equal null" : tag.length() <= 0 ? "size equal or less than zero" : "[ERROR]") + ".")));
	}
	//-----------------------------------------------------------------------------------------------
}
