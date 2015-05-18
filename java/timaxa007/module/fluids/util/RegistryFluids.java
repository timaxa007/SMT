package timaxa007.module.fluids.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import timaxa007.smt.util.UtilString;

/**Аналог <b>FluidRegistry</b>, но сделано по-своему.<br>
 * The analogue <b>FluidRegistry</b>, but I have done differently.
 * @author timaxa007**/
public class RegistryFluids {

	private static HashMap<String, Fluid> fluids_map = new HashMap<String, Fluid>();
	private static ArrayList<String> fluids_list = new ArrayList<String>();

	public static final Fluid EMPTY = new Fluid("empty");

	static {
		RegistryFluids.registerFluid(EMPTY);
	}

	public static void registerFluid(Fluid[] fluids) {
		for (Fluid fluid : fluids) if (fluid != null) registerFluid(fluid);
	}

	public static void registerFluid(Fluid fluid) {
		registerFluid(fluid, fluid.getTag());
	}

	public static void registerFluid(Fluid fluid, String tag) {
		if (fluid != null && UtilString.hasString(tag))
			if (fluids_map.get(tag) == null) {
				fluids_map.put(tag, fluid);
				fluids_list.add(tag);
			}
			else throw new IllegalArgumentException("Duplicate " + fluid);
		else throw new IllegalArgumentException("Error " + fluid);
	}

	public static Fluid getFluid(String tag) {
		return (fluids_map.get(tag) != null ? fluids_map.get(tag) : EMPTY);
	}
	/*
	public static List getTagFluids() {
		//List list = Lists.newArrayList();
		ArrayList<String> list = new ArrayList<String>();
		for (Entry<String, Fluid> entry : fluids_map.entrySet())
			list.add(entry.getKey().toString());
		return list;
	}
	 */
	public static List getListFluids() {
		return fluids_list;
	}

	public static boolean hasFluid(Fluid fluid) {
		return !(fluid == null || fluid == EMPTY);
	}

	public static boolean hasFluid(String tag) {
		return UtilString.hasString(tag) && hasFluid(RegistryFluids.getFluid(tag));
	}
	//-------------------------------------------------------------------------------------------
	public static HashMap<String, FluidType> fluid_type_map = new HashMap<String, FluidType>();

	public static final FluidType NONE = new FluidType("none");

	static {
		RegistryFluids.registerFluidType(NONE);
	}

	public static void registerFluidType(FluidType[] fluid_types) {
		for (FluidType fluid_type : fluid_types) if (fluid_type != null) registerFluidType(fluid_type);
	}

	public static void registerFluidType(FluidType fluid_type) {
		if (fluid_type != null && UtilString.hasString(fluid_type.getType()))
			if (fluid_type_map.get(fluid_type.getType()) == null)
				fluid_type_map.put(fluid_type.getType(), fluid_type);
			else throw new IllegalArgumentException("Duplicate " + fluid_type);
		else throw new IllegalArgumentException("Error " + fluid_type);
	}

	public static FluidType getFluidType(String tag) {
		return (fluid_type_map.get(tag) != null ? fluid_type_map.get(tag) : NONE);
	}

	public static List getTypeFluidType() {
		//List list = Lists.newArrayList();
		ArrayList<String> list = new ArrayList<String>();
		for (Entry<String, FluidType> entry : fluid_type_map.entrySet())
			list.add(entry.getKey().toString());
		return list;
	}

	public static boolean hasFluidType(FluidType fluid_type) {
		return !(fluid_type == null || fluid_type == NONE);
	}

	public static boolean hasFluidType(String tag) {
		return UtilString.hasString(tag) && hasFluidType(RegistryFluids.getFluidType(tag));
	}
	//-------------------------------------------------------------------------------------------
}
