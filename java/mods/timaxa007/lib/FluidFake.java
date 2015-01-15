package mods.timaxa007.lib;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.util.StatCollector;
/**
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class FluidFake {

	public static final FluidFake[] list = new FluidFake[4096];

	public static final FluidFake empty = new FluidFake(0);

	public int id;
	public String tag;
	private String name;
	private FluidFake.TypeFluid type;
	private int color_hex;
	private float temperature;
	private String texture;

	/**It is not recommended to use this method.**/
	@Deprecated
	public FluidFake() {
		id = nextID();
		list[id] = this;
		tag = "";
		color_hex = 0;
		temperature = 0.0F;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public FluidFake(int id) {
		this.id = id;
		list[id] = this;
		tag = "";
		color_hex = 0;
		temperature = 0.0F;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public FluidFake(int id, String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
		color_hex = 0;
		temperature = 0.0F;
	}

	public FluidFake(String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
		id = nextID();
		list[id] = this;
		this.tag = tag;
		color_hex = 0;
		temperature = 0.0F;
	}
	//--------------------------------------------------------
	public static int nextID() {
		for (int i = 0; i < list.length; i++)
			if (list[i] == null)
				return i;
		return list.length - 1;
	}

	public static boolean hasTag(String str) {
		for (int i = 0; i < list.length; i++)
			if (str.equalsIgnoreCase(list[i].tag))
				return true;
		return false;
	}

	public static int getID_tag(String str) {
		for (int i = 0; i < list.length; i++)
			if (str.equalsIgnoreCase(list[i].tag))
				return i;
		return 0;
	}

	private static void checkTag(String str) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i].tag == str)
				System.out.println("!Duplicate: " + str);
	}

	public static FluidFake get(String tag) {
		if (UtilTMS.hasString(tag))
			return list[getID_tag(tag)];
		return empty;
	}
	//--------------------------------------------------------
	public FluidFake setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilTMS.hasString(name) ? name : UtilTMS.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("fluid." + getName() + ".name");
	}

	public FluidFake setType(FluidFake.TypeFluid type) {
		this.type = type;
		return this;
	}

	public FluidFake setType(String type) {
		this.type = FluidFake.TypeFluid.get(type);
		return this;
	}

	public FluidFake.TypeFluid getType() {
		return type != null ? type : FluidFake.TypeFluid.none;
	}

	public String getTypeName() {
		return getType().getName();
	}

	public String getLocalizedType() {
		return getType().getLocalizedType();
	}

	public FluidFake setColor(int color) {
		color_hex = color;
		return this;
	}

	public FluidFake setColorMix(int color1, int color2) {
		color_hex = GetColors.getColorMix(color1, color2);
		return this;
	}

	public int getColor() {
		return color_hex == 0 ? 0xFFFFFF : color_hex;
	}

	public FluidFake setTemperature(float f) {
		temperature = f;
		return this;
	}

	public float getTemperature() {
		return temperature;
	}

	public FluidFake setTexture(String path) {
		texture = path;
		return this;
	}

	public String getTexture() {
		return texture == null ? getName() : texture;
	}
	//-------------------------------------------------------------------------------------------
	public static class TypeFluid {

		public static final TypeFluid[] list_type = new TypeFluid[512];

		public static final TypeFluid none = new TypeFluid(0);
		//public static final TypeFluid fluid = new TypeFluid("fluid");
		public static final TypeFluid liquid = new TypeFluid("liquid");
		public static final TypeFluid air = new TypeFluid("air");
		public static final TypeFluid gas = new TypeFluid("gas");
		public static final TypeFluid smoke = new TypeFluid("smoke");
		public static final TypeFluid oil = new TypeFluid("oil");
		public static final TypeFluid magic = new TypeFluid("magic");
		public static final TypeFluid energy = new TypeFluid("energy");
		public static final TypeFluid molten = new TypeFluid("molten");
		public static final TypeFluid dust = new TypeFluid("dust");

		public int id;
		public String type;
		private float temperature_min;
		private float temperature_max;

		/**It is not recommended to use this method.**/
		@Deprecated
		public TypeFluid(int id) {
			this.id = id;
			list_type[id] = this;
			type = "";
			temperature_min = 0.0F;
			temperature_max = 0.0F;
		}

		public TypeFluid(String type) {
			id = nextID();
			list_type[id] = this;
			this.type = type;
			temperature_min = 0.0F;
			temperature_max = 0.0F;
		}

		public static int nextID() {
			for (int i = 0; i < list_type.length; i++)
				if (list_type[i] == null)
					return i;
			return list_type.length - 1;
		}

		public static boolean hasType(String str) {
			for (int i = 0; i < list_type.length; i++)
				if (str.equalsIgnoreCase(list_type[i].type))
					return true;
			return false;
		}

		public static int getID_type(String str) {
			for (int i = 0; i < list_type.length; i++)
				if (str.equalsIgnoreCase(list_type[i].type))
					return i;
			return 0;
		}

		public static TypeFluid get(String tag) {
			if (UtilTMS.hasString(tag))
				return list_type[getID_type(tag)];
			return none;
		}
		public String getName() {
			return UtilTMS.hasString(type) ? type : "untype";
		}

		public String getLocalizedType() {
			return StatCollector.translateToLocal("type." + getName().toLowerCase() + ".name");
		}

		public TypeFluid setTemperatureMinMax(float min, float max) {
			temperature_min = min;
			temperature_max = max;
			return this;
		}

		public TypeFluid setTemperatureMin(float min) {
			temperature_min = min;
			return this;
		}

		public float getTemperatureMin() {
			return temperature_min;
		}

		public TypeFluid setTemperatureMax(float max) {
			temperature_max = max;
			return this;
		}

		public float getTemperatureMax() {
			return temperature_max;
		}

	}
	//-------------------------------------------------------------------------------------------
}

