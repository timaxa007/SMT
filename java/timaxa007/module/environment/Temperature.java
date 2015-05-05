package timaxa007.module.environment;

public class Temperature {

	public float temperature;
	public float temperature_min;
	public float temperature_max;

	public static Temperature create(float temperature, float temperature_min, float temperature_max) {
		return new Temperature(temperature, temperature_min, temperature_max);
	}

	public Temperature(float temperature, float temperature_min, float temperature_max) {
		this.temperature = Float.isInfinite(temperature) ? Float.MAX_VALUE : Float.isNaN(temperature) ? 0.0F : 
			(temperature == -0.0F ? 0.0F : temperature);
		this.temperature_min = Float.isInfinite(temperature_min) ? Float.MAX_VALUE : Float.isNaN(temperature_min) ? 0.0F : 
			(temperature_min == -0.0F ? 0.0F : temperature_min);
		this.temperature_max = Float.isInfinite(temperature_max) ? Float.MAX_VALUE : Float.isNaN(temperature_max) ? 0.0F : 
			(temperature_max == -0.0F ? 0.0F : temperature_max);
	}

	public String toString() {
		return "(" + this.temperature + ", " + this.temperature_min + ", " + this.temperature_max + ")";
	}

}
