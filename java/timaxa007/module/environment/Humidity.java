package timaxa007.module.environment;

public class Humidity {

	public float humidity;
	public float humidity_min;
	public float humidity_max;

	public static Humidity createHumidity(float humidity, float humidity_min, float humidity_max) {
		return new Humidity(humidity, humidity_min, humidity_max);
	}

	public Humidity(float humidity, float humidity_min, float humidity_max) {
		this.humidity = Float.isInfinite(humidity) ? Float.MAX_VALUE : Float.isNaN(humidity) ? 0.0F : 
			(humidity == -0.0F ? 0.0F : humidity);
		this.humidity_min = Float.isInfinite(humidity_min) ? Float.MAX_VALUE : Float.isNaN(humidity_min) ? 0.0F : 
			(humidity_min == -0.0F ? 0.0F : humidity_min);
		this.humidity_max = Float.isInfinite(humidity_max) ? Float.MAX_VALUE : Float.isNaN(humidity_max) ? 0.0F : 
			(humidity_max == -0.0F ? 0.0F : humidity_max);
	}

	public String toString() {
		return "(" + this.humidity + ", " + this.humidity_min + ", " + this.humidity_max + ")";
	}

}
