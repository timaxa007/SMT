package smt.pack.technology.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.technology.SMTTechnology;

public final class Items {

	public static Item
	itemsTechnology,
	multiTool,
	//armorHelmet,
	//armorVest,
	//armorPants,
	//armorBoots,
	spawnEntity,
	capsule,
	electricEnergy,
	electricScanner,
	telephone,
	wire
	;

	public static final void init() {

		itemsTechnology = new ItemItemsTechnology().setUnlocalizedName("items_technology").setCreativeTab(SMTTechnology.tabTechnology);
		GameRegistry.registerItem(itemsTechnology, "item_items_technology");

		multiTool = new ItemMultiTool().setUnlocalizedName("multi_tool").setCreativeTab(SMTTechnology.tabTechnology);
		GameRegistry.registerItem(multiTool, "item_multi_tool");

		//armorHelmet = new ItemArmorTest(0).setUnlocalizedName("armor_helmet").setCreativeTab(SMTTechnology.tabTechnology);
		//GameRegistry.registerItem(armorHelmet, "item_armor_helmet");

		//armorVest = new ItemArmorTest(1).setUnlocalizedName("armor_vest").setCreativeTab(SMTTechnology.tabTechnology);
		//GameRegistry.registerItem(armorVest, "item_armor_vest");

		//armorPants = new ItemArmorTest(2).setUnlocalizedName("armor_pants").setCreativeTab(SMTTechnology.tabTechnology);
		//GameRegistry.registerItem(armorPants, "item_armor_pants");

		//armorBoots = new ItemArmorTest(3).setUnlocalizedName("armor_boots").setCreativeTab(SMTTechnology.tabTechnology);
		//GameRegistry.registerItem(armorBoots, "item_armor_boots");

		spawnEntity = new ItemSpawnEntity().setUnlocalizedName("spawn_entity").setCreativeTab(SMTTechnology.tabTechnology);
		GameRegistry.registerItem(spawnEntity, "item_spawn_entity");

		capsule = new ItemCapsule().setUnlocalizedName("capsule").setCreativeTab(SMTTechnology.tabTechnology);
		GameRegistry.registerItem(capsule, "item_capsule");

		electricEnergy = new ItemElectricPower().setUnlocalizedName("electric_energy").setCreativeTab(SMTTechnology.tabTechnology);
		GameRegistry.registerItem(electricEnergy, "item_electric_energy");

		electricScanner = new ItemElectricScanner().setUnlocalizedName("electric_scanner").setCreativeTab(SMTTechnology.tabTechnology);
		GameRegistry.registerItem(electricScanner, "item_electric_scanner");

		telephone = new ItemTelephone().setUnlocalizedName("telephone").setCreativeTab(SMTTechnology.tabTechnology);
		GameRegistry.registerItem(telephone, "item_telephone");

		wire = new ItemWire().setUnlocalizedName("wire").setCreativeTab(SMTTechnology.tabTechnology);
		GameRegistry.registerItem(wire, "item_wire");

	}

}
