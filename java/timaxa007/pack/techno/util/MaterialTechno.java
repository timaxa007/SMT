package timaxa007.pack.techno.util;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialTechno extends Material {

	public MaterialTechno() {
		super(MapColor.ironColor);
		setRequiresTool();
		setImmovableMobility();
	}

}
