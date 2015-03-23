package mods.timaxa007.tms.lib;

import mods.timaxa007.tms.util.UtilString;
import net.minecraft.util.StatCollector;
/**
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class FluidFake {

	public static final FluidFake[] list = new FluidFake[4096];
	//private static Map hashMap = new HashMap();

	public static final FluidFake empty = new FluidFake(0);

	public int id;
	public String tag;
	private String name;
	private FluidFake.TypeFluid type;
	private int color_hex;
	private float temperature;
	private String texture;

	/**It is not recommended to use this method.**/@Deprecated
	public FluidFake() {
		id = nextID();
		list[id] = this;
		tag = "";
		color_hex = 0;
		temperature = 0.0F;
	}

	/**It is not recommended to use this method.**/@Deprecated
	public FluidFake(int id) {
		this.id = id;
		list[id] = this;
		tag = "";
		color_hex = 0;
		temperature = 0.0F;
	}

	/**It is not recommended to use this method.**/@Deprecated
	public FluidFake(int id, String tag) {
		checkTag(this, tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
		color_hex = 0;
		temperature = 0.0F;
	}

	public FluidFake(String tag) {
		checkTag(this, tag);
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

	public static boolean hasTag(String tag) {
		if (UtilString.hasString(tag))
			for (FluidFake fluid : list)
				if (fluid != null && tag.equalsIgnoreCase(fluid.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (FluidFake fluid : list)
				if (fluid != null && tag.equalsIgnoreCase(fluid.tag))
					return fluid.id;
		return empty.id;
	}

	private static void checkTag(FluidFake fluid, String tag) {
		for (FluidFake fluid2 : list)
			if (fluid2 != null && fluid2.tag == tag)
				throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + fluid + ".");
	}

	public static FluidFake get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(FluidFake fluid) {
		return fluid == null || fluid == empty;
	}
	//--------------------------------------------------------
	public FluidFake setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
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
		public static final TypeFluid liquid = new TypeFluid("liquid").setIgniter(-8);
		public static final TypeFluid air = new TypeFluid("air").setIgniter(1);
		public static final TypeFluid gas = new TypeFluid("gas").setIgniter(10);
		public static final TypeFluid smoke = new TypeFluid("smoke").setIgniter(-1);
		public static final TypeFluid oil = new TypeFluid("oil").setIgniter(3);
		public static final TypeFluid magic = new TypeFluid("magic").setIgniter(0);
		public static final TypeFluid energy = new TypeFluid("energy").setIgniter(0);
		public static final TypeFluid molten = new TypeFluid("molten").setIgniter(0);
		public static final TypeFluid dust = new TypeFluid("dust").setIgniter(0);

		public int id;
		public String type;
		private float temperature_min;
		private float temperature_max;
		private int igniter;

		/**It is not recommended to use this method.**/@Deprecated
		public TypeFluid(int id) {
			this.id = id;
			list_type[id] = this;
			type = "";
			temperature_min = 0.0F;
			temperature_max = 0.0F;
			igniter = 0;
		}

		public TypeFluid(String type) {
			id = nextID();
			list_type[id] = this;
			this.type = type;
			temperature_min = 0.0F;
			temperature_max = 0.0F;
			igniter = 0;
		}

		public static int nextID() {
			for (int i = 0; i < list_type.length; i++)
				if (list_type[i] == null)
					return i;
			return list_type.length - 1;
		}

		public static boolean hasType(String str) {
			for (TypeFluid type_fluid : list_type)
				if (str.equalsIgnoreCase(type_fluid.type))
					return true;
			return false;
		}

		public static int getID_type(String tag) {
			if (UtilString.hasString(tag))
				for (TypeFluid type_fluid : list_type)
					if (tag.equalsIgnoreCase(type_fluid.type))
						return type_fluid.id;
			return 0;
		}

		public static TypeFluid get(String tag) {
			return getID_type(tag) != 0 ? list_type[getID_type(tag)] : none;
		}
		public String getName() {
			return UtilString.hasString(type) ? type : "untype";
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

		/**If <b>zero</b>, then nothing. <br>
		 * If less than <b>zero</b>, it does not give ignite near flame or even extinguish. (<i>WIP</i>) <br>
		 * If greater than <b>zero</b>, then this object (block/entity/item) will burn. (<i>Half-WIP</i>)**/
		public TypeFluid setIgniter(int igniter) {
			this.igniter = igniter;
			return this;
		}

		public int getIgniter() {
			return igniter;
		}

	}
	//-------------------------------------------------------------------------------------------
}

