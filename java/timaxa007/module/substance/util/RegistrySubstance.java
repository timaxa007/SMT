package timaxa007.module.substance.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import timaxa007.smt.util.UtilString;

/**Аналог <b>SubstanceRegistry</b>, но сделано по-своему.<br>
 * The analogue <b>SubstanceRegistry</b>, but I have done differently.
 * @author timaxa007**/
public class RegistrySubstance {

	private static HashMap<String, Substance> fluids_map = new HashMap<String, Substance>();
	private static ArrayList<String> fluids_list = new ArrayList<String>();

	public static final Substance EMPTY = new Substance("empty");

	static {
		RegistrySubstance.registerSubstance(EMPTY);
	}

	public static void registerSubstance(Substance[] fluids) {
		for (Substance fluid : fluids) if (fluid != null) registerSubstance(fluid);
	}

	public static void registerSubstance(Substance fluid) {
		registerSubstance(fluid, fluid.getTag());
	}

	public static void registerSubstance(Substance fluid, String tag) {
		if (fluid != null && UtilString.hasString(tag))
			if (fluids_map.get(tag) == null) {
				fluids_map.put(tag, fluid);
				fluids_list.add(tag);
			}
			else throw new IllegalArgumentException("Duplicate " + fluid);
		else throw new IllegalArgumentException("Error " + fluid);
	}

	public static Substance getSubstance(String tag) {
		return (fluids_map.get(tag) != null ? fluids_map.get(tag) : EMPTY);
	}
	/*
	public static List getTagSubstance() {
		//List list = Lists.newArrayList();
		ArrayList<String> list = new ArrayList<String>();
		for (Entry<String, Substance> entry : fluids_map.entrySet())
			list.add(entry.getKey().toString());
		return list;
	}
	 */
	public static List getListSubstance() {
		return fluids_list;
	}

	public static boolean hasSubstance(Substance fluid) {
		return !(fluid == null || fluid == EMPTY);
	}

	public static boolean hasSubstance(String tag) {
		return UtilString.hasString(tag) && hasSubstance(RegistrySubstance.getSubstance(tag));
	}
	//-------------------------------------------------------------------------------------------
	public static HashMap<String, SubstanceType> fluid_type_map = new HashMap<String, SubstanceType>();

	public static final SubstanceType NONE = new SubstanceType("none");

	static {
		RegistrySubstance.registerSubstanceType(NONE);
	}

	public static void registerSubstanceType(SubstanceType[] fluid_types) {
		for (SubstanceType fluid_type : fluid_types) if (fluid_type != null) registerSubstanceType(fluid_type);
	}

	public static void registerSubstanceType(SubstanceType fluid_type) {
		if (fluid_type != null && UtilString.hasString(fluid_type.getType()))
			if (fluid_type_map.get(fluid_type.getType()) == null)
				fluid_type_map.put(fluid_type.getType(), fluid_type);
			else throw new IllegalArgumentException("Duplicate " + fluid_type);
		else throw new IllegalArgumentException("Error " + fluid_type);
	}

	public static SubstanceType getSubstanceType(String tag) {
		return (fluid_type_map.get(tag) != null ? fluid_type_map.get(tag) : NONE);
	}

	public static List getTypeSubstanceType() {
		//List list = Lists.newArrayList();
		ArrayList<String> list = new ArrayList<String>();
		for (Entry<String, SubstanceType> entry : fluid_type_map.entrySet())
			list.add(entry.getKey().toString());
		return list;
	}

	public static boolean hasSubstanceType(SubstanceType fluid_type) {
		return !(fluid_type == null || fluid_type == NONE);
	}

	public static boolean hasSubstanceType(String tag) {
		return UtilString.hasString(tag) && hasSubstanceType(RegistrySubstance.getSubstanceType(tag));
	}
	//-------------------------------------------------------------------------------------------
}
