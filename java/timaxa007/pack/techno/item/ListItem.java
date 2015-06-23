package timaxa007.pack.techno.item;

import net.minecraft.item.Item;
import timaxa007.smt.util.UtilSMT;

public class ListItem {

	public static boolean
	items_for_techno_be,
	tool_electric_wrench_be,
	tool_electric_drill_be,
	tool_electric_saw_be,
	electric_detector_be,
	electric_jetpack_be,
	electric_robot_be
	;

	public static Item
	items_for_techno,
	tool_electric_wrench,
	tool_electric_drill,
	tool_electric_saw,
	electric_detector,
	electric_jetpack,
	electric_robot
	;

	public static Item[] list_item;

	public static void preInit() {

		if (items_for_techno_be) items_for_techno = new ItemsTechno("items_for_techno");
		if (tool_electric_wrench_be) tool_electric_wrench = new ToolElectricWrench("tool_electric_wrench");
		if (tool_electric_drill_be) tool_electric_drill = new ToolElectricDrill("tool_electric_drill");
		if (tool_electric_saw_be) tool_electric_saw = new ToolElectricSaw("tool_electric_saw");
		if (electric_detector_be) electric_detector = new ElectricDetector("electric_detector");
		if (electric_jetpack_be) electric_jetpack = new ElectricJetpack("electric_jetpack");
		if (electric_robot_be) electric_robot = new ElectricRobot("robot");

		list_item = new Item[] {
				items_for_techno,
				tool_electric_wrench,
				tool_electric_drill,
				tool_electric_saw,
				electric_detector,
				electric_jetpack,
				electric_robot
		};

		UtilSMT.UtilItem.RegItem(list_item);

	}

}
