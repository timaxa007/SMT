package timaxa007.module.environment.util;

public class UtilTemperature {

	public static String textTemperature(float temperature) {
		if (temperature >= 0.0F) {
			return "Normal";
		} else if (temperature > 45.0F) {
			return "Hot";
		} else if (temperature > 60.0F) {
			return "Very Hot";
		} else if (temperature > 120.0F) {
			return "Very Very Hot";
		} else if (temperature < 0.0F) {
			return "Cool";
		} else if (temperature < -45.0F) {
			return "Very Cool";
		} else if (temperature < -80.0F) {
			return "Very Very Cool";
		} else {
			return "" + temperature;
		}
	}

}
