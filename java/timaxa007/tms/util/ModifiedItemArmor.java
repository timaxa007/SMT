package timaxa007.tms.util;


public class ModifiedItemArmor extends ModifiedItem {
	/*ItemArmor does not work well.*/

	public int part_armor;
	public String armor_material;

	public ModifiedItemArmor(String tag, int armor_type) {
		super(tag);
		this.part_armor = armor_type;
		this.armor_material = "";
	}

	public ModifiedItemArmor(String tag, int armor_type, String armor_material) {
		super(tag);
		this.part_armor = armor_type;
		this.armor_material = armor_material;
	}

	public static class MaterialPartArmor {

	}

	public static class MaterialArmorAll {

	}

}
