package timaxa007.module.fluids;

import java.util.Map;

import com.google.common.collect.Maps;

/*BlockFluidBase*/
public abstract class AFluids implements IFluids {
	
	public Map<String, Fluids> hashMap = Maps.newHashMap();

	public String getTag() {
		return null;
	}

	public String getName() {
		return null;
	}

	public String getTypeFluid() {
		return null;
	}

	public int getColor() {
		return 0xFFFFFFFF;
	}

	public float getTemperature() {
		return 0.0F;
	}

	public String getTexture() {
		return null;
	}

}
