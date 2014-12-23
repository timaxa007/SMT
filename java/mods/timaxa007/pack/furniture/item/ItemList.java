package mods.timaxa007.pack.furniture.item;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemList {

	public static ArmorMaterial CLOTHWOOL = EnumHelper.addArmorMaterial("CLOTHWOOL", 6, new int[] {2, 3, 2, 1}, 10);
	public static ArmorMaterial COSTUME = EnumHelper.addArmorMaterial("COSTUME", 0, new int[] {2, 2, 2, 1}, 3);
	public static ArmorMaterial METALSMATERIAL = EnumHelper.addArmorMaterial("METALSMATileEntityRIAL", 15, new int[] {3, 7, 5, 3}, 10);
	public static ArmorMaterial GEMSMATERIAL = EnumHelper.addArmorMaterial("GEMSMATileEntityRIAL", 15, new int[] {5, 10, 7, 4}, 12);

	public static final ToolMaterial TOOLGEMS = EnumHelper.addToolMaterial("TOOLGEMS", 3, 512, 7.0F, 3, 7);
	public static final ToolMaterial TOOLMETALS = EnumHelper.addToolMaterial("TOOLMETALS", 2, 300, 6.0F, 2, 11);

	public static Item items_for_furniture;
	public static ItemArmor armor_wool_colors_helmet;
	public static ItemArmor armor_wool_colors_chest;
	public static ItemArmor armor_wool_colors_leggin;
	public static ItemArmor armor_wool_colors_boot;
	public static Item colored;
	public static Item tool_brush;
	public static Item tool_airbrush;
	public static Item paint_can;
	public static Item backpack;
	public static Item filter_charcoal;
	public static Item kitchenware;
	public static ItemArmor armor_costumes_helmet;
	public static ItemArmor armor_costumes_chest;
	public static ItemArmor armor_costumes_leggin;
	public static ItemArmor armor_costumes_boot;
	public static ItemArmor armor_masks;
	public static ItemArmor armor_backpacks;
	public static Item particles_gun;
	public static ItemArmor armor_medieval_helmet;
	public static ItemArmor armor_medieval_chest;
	public static ItemArmor armor_medieval_leggin;
	public static ItemArmor armor_medieval_boot;
	public static ItemArmor armor_new_helmet;
	public static ItemArmor armor_new_chest;
	public static ItemArmor armor_new_leggin;
	public static ItemArmor armor_new_boot;
	public static Item tool_axe;
	public static Item tool_shovel;
	public static Item tool_pickaxe;
	public static Item tool_hoe;
	public static Item tool_hammer;
	public static Item tool_sickle;
	public static Item tool_scythe;
	public static Item tool_sword;
	public static Item tool_battle_axe;
	public static Item tool_battle_hammer;

	public static void list() {

		items_for_furniture = new ItemsFurniture();
		armor_wool_colors_helmet = (ItemArmor)(new ArmorWoolColors(CLOTHWOOL, 0, 0).setUnlocalizedName("ArmorWoolColorsHelmet"));
		armor_wool_colors_chest = (ItemArmor)(new ArmorWoolColors(CLOTHWOOL, 0, 1).setUnlocalizedName("ArmorWoolColorsChest"));
		armor_wool_colors_leggin = (ItemArmor)(new ArmorWoolColors(CLOTHWOOL, 0, 2).setUnlocalizedName("ArmorWoolColorsLeggin"));
		armor_wool_colors_boot = (ItemArmor)(new ArmorWoolColors(CLOTHWOOL, 0, 3).setUnlocalizedName("ArmorWoolColorsBoot"));
		colored = new ItemColored();
		tool_brush = new ToolBrush();
		tool_airbrush = new ToolAirBrush();
		paint_can = new ItemPaintCan();
		backpack = new ItemBackpack();
		filter_charcoal = new ItemFilterCharcoal();
		kitchenware = new ItemKitchenware();
		armor_costumes_helmet = (ItemArmor) new ArmorCostumes(COSTUME, 0, 0).setUnlocalizedName("armor_costumes_helmet");
		armor_costumes_chest = (ItemArmor) new ArmorCostumes(COSTUME, 0, 1).setUnlocalizedName("armor_costumes_chest");
		armor_costumes_leggin = (ItemArmor) new ArmorCostumes(COSTUME, 0, 2).setUnlocalizedName("armor_costumes_leggin");
		armor_costumes_boot = (ItemArmor) new ArmorCostumes(COSTUME, 0, 3).setUnlocalizedName("armor_costumes_boot");
		armor_masks = new ArmorMasks();
		armor_backpacks = new ArmorBackpacks();
		particles_gun = new ItemParticlesGun();
		armor_medieval_helmet = (ItemArmor) new ArmorMedieval(COSTUME, 0, 0).setUnlocalizedName("armor_medieval_helmet");
		armor_medieval_chest = (ItemArmor) new ArmorMedieval(COSTUME, 0, 1).setUnlocalizedName("armor_medieval_chest");
		armor_medieval_leggin = (ItemArmor) new ArmorMedieval(COSTUME, 0, 2).setUnlocalizedName("armor_medieval_leggin");
		armor_medieval_boot = (ItemArmor) new ArmorMedieval(COSTUME, 0, 3).setUnlocalizedName("armor_medieval_boot");
		armor_new_helmet = (ItemArmor) new ArmorNew(COSTUME, 0, 0).setUnlocalizedName("armor_new_helmet");
		armor_new_chest = (ItemArmor) new ArmorNew(COSTUME, 0, 1).setUnlocalizedName("armor_new_chest");
		armor_new_leggin = (ItemArmor) new ArmorNew(COSTUME, 0, 2).setUnlocalizedName("armor_new_leggin");
		armor_new_boot = (ItemArmor) new ArmorNew(COSTUME, 0, 3).setUnlocalizedName("armor_new_boot");
		tool_axe = new ToolAxe();
		tool_shovel = new ToolShovel();
		tool_pickaxe = new ToolPickaxe();
		tool_hoe = new ToolHoe();
		tool_hammer = new ToolHammer();
		tool_sickle = new ToolSickle();
		tool_scythe = new ToolScythe();
		tool_sword = new ToolSword();
		tool_battle_axe = new ToolBattleAxe();
		tool_battle_hammer = new ToolBattleHammer();

		GameRegistry.registerItem(items_for_furniture, "ItemsFurniture");
		GameRegistry.registerItem(armor_wool_colors_helmet, "ArmorWoolColorsHelmet");
		GameRegistry.registerItem(armor_wool_colors_chest, "ArmorWoolColorsChest");
		GameRegistry.registerItem(armor_wool_colors_leggin, "ArmorWoolColorsLeggin");
		GameRegistry.registerItem(armor_wool_colors_boot, "ArmorWoolColorsBoot");
		GameRegistry.registerItem(colored, "ItemColored");
		GameRegistry.registerItem(tool_brush, "IoolBrush");
		GameRegistry.registerItem(tool_airbrush, "ToolAirBrush");
		GameRegistry.registerItem(paint_can, "ItemPaintCan");
		GameRegistry.registerItem(backpack, "ItemBackpack");
		GameRegistry.registerItem(filter_charcoal, "ItemFilterCharcoal");
		GameRegistry.registerItem(kitchenware, "ItemKitchenware");
		GameRegistry.registerItem(armor_costumes_helmet, "ArmorCostumesHelmet");
		GameRegistry.registerItem(armor_costumes_chest, "ArmorCostumesChest");
		GameRegistry.registerItem(armor_costumes_leggin, "ArmorCostumesLeggin");
		GameRegistry.registerItem(armor_costumes_boot, "ArmorCostumesBoot");
		GameRegistry.registerItem(armor_masks, "ArmorMasks");
		GameRegistry.registerItem(armor_backpacks, "ArmorBackpacks");
		GameRegistry.registerItem(particles_gun, "ItemParticlesGun");
		GameRegistry.registerItem(armor_medieval_helmet, "ArmorMedievalHelmet");
		GameRegistry.registerItem(armor_medieval_chest, "ArmorMedievalChest");
		GameRegistry.registerItem(armor_medieval_leggin, "ArmorMedievalLeggin");
		GameRegistry.registerItem(armor_medieval_boot, "ArmorMedievalBoot");
		GameRegistry.registerItem(armor_new_helmet, "ArmorNewHelmet");
		GameRegistry.registerItem(armor_new_chest, "ArmorNewChest");
		GameRegistry.registerItem(armor_new_leggin, "ArmorNewLeggin");
		GameRegistry.registerItem(armor_new_boot, "ArmorNewBoot");
		GameRegistry.registerItem(tool_axe, "ToolAxe");
		GameRegistry.registerItem(tool_shovel, "ToolShovel");
		GameRegistry.registerItem(tool_pickaxe, "ToolPickaxe");
		GameRegistry.registerItem(tool_hoe, "ToolHoe");
		GameRegistry.registerItem(tool_hammer, "ToolHammer");
		GameRegistry.registerItem(tool_sickle, "ToolSickle");
		GameRegistry.registerItem(tool_scythe, "ToolScythe");
		GameRegistry.registerItem(tool_sword, "ToolSword");
		GameRegistry.registerItem(tool_battle_axe, "ToolBattleAxe");

	}

}
