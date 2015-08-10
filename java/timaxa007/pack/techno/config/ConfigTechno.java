package timaxa007.pack.techno.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import timaxa007.pack.techno.PackTechno;

public class ConfigTechno {
	//--------------------------------------------------------------------------------------------------------------
	public static void main() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackTechno.MODID, "main.cfg"));
		cfg.load();

		PackTechno.block.electric_machines_be = cfg.get("block", "electric_machines", true).getBoolean();
		PackTechno.block.electric_wires_be = cfg.get("block", "electric_wires", true).getBoolean();
		PackTechno.block.module_movement_be = cfg.get("block", "module_movement", true).getBoolean();

		PackTechno.item.items_for_techno_be = cfg.get("item", "items_for_techno", true).getBoolean();
		PackTechno.item.tool_electric_wrench_be = cfg.get("item", "tool_electric_wrench", true).getBoolean();
		PackTechno.item.tool_electric_drill_be = cfg.get("item", "tool_electric_drill", true).getBoolean();
		PackTechno.item.tool_electric_saw_be = cfg.get("item", "tool_electric_saw", true).getBoolean();
		PackTechno.item.electric_detector_be = cfg.get("item", "electric_detector", true).getBoolean();
		PackTechno.item.electric_jetpack_be = cfg.get("item", "electric_jetpack", true).getBoolean();
		PackTechno.item.electric_robot_be = cfg.get("item", "electric_robot", true).getBoolean();
		PackTechno.item.container_fluid_be = cfg.get("item", "container_fluid", true).getBoolean();

		cfg.save();
	}
	//--------------------------------------------------------------------------------------------------------------
}
