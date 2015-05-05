package timaxa007.module.environment;

public class Hydrogenated {

	public float hydrogenated;
	public float hydrogenated_min;
	public float hydrogenated_max;

	public static Hydrogenated create(float hydrogenated, float hydrogenated_min, float hydrogenated_max) {
		return new Hydrogenated(hydrogenated, hydrogenated_min, hydrogenated_max);
	}

	public Hydrogenated(float hydrogenated, float hydrogenated_min, float hydrogenated_max) {
		this.hydrogenated = Float.isInfinite(hydrogenated) ? Float.MAX_VALUE : Float.isNaN(hydrogenated) ? 0.0F : 
			(hydrogenated == -0.0F ? 0.0F : hydrogenated);
		this.hydrogenated_min = Float.isInfinite(hydrogenated_min) ? Float.MAX_VALUE : Float.isNaN(hydrogenated_min) ? 0.0F : 
			(hydrogenated_min == -0.0F ? 0.0F : hydrogenated_min);
		this.hydrogenated_max = Float.isInfinite(hydrogenated_max) ? Float.MAX_VALUE : Float.isNaN(hydrogenated_max) ? 0.0F : 
			(hydrogenated_max == -0.0F ? 0.0F : hydrogenated_max);
	}

	public String toString() {
		return "(" + this.hydrogenated + ", " + this.hydrogenated_min + ", " + this.hydrogenated_max + ")";
	}

}
