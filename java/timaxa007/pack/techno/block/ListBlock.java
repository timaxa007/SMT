package timaxa007.pack.techno.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import timaxa007.pack.techno.tile.TileEntityElectricMachines;
import timaxa007.pack.techno.tile.TileEntityElectricWires;
import timaxa007.pack.techno.tile.TileEntityFarmMashines;
import timaxa007.pack.techno.tile.TileEntityModuleMovement;
import timaxa007.pack.techno.util.MaterialTechno;
import timaxa007.smt.util.UtilSMT;

public class ListBlock {

	public static boolean
	electric_machines_be,
	electric_wires_be,
	module_movement_be,
	farm_mashines_be
	;

	public static Block
	electric_machines,
	electric_wires,
	module_movement,
	farm_mashines
	;

	public static Class
	te_electric_machines,
	te_electric_wires,
	te_module_movement,
	te_farm_mashines
	;

	public static Material techno_block = new MaterialTechno();

	public static final Block.SoundType soundElectricMachines = new Block.SoundType("stone", 1.0F, 1.0F) {
		//public String getBreakSound() {return "dig.stone";}
		public String getStepResourcePath() {return "step.gravel";}
		//public String func_150496_b() {return "dig.wood";}
	};

	public static Block[] list_block;

	public static Class[] list_te;

	public static void preInit() {

		if (electric_machines_be) {
			electric_machines = new BlockElectricMachines("electric_machines").setStepSound(soundElectricMachines);
			te_electric_machines = TileEntityElectricMachines.class;
		}

		if (electric_wires_be) {
			electric_wires = new BlockElectricWires("electric_wires");
			te_electric_wires = TileEntityElectricWires.class;
		}

		if (module_movement_be) {
			module_movement = new BlockModuleMovement("module_movement");
			te_module_movement = TileEntityModuleMovement.class;
		}

		if (farm_mashines_be) {
			farm_mashines = new BlockFarmMashines("farm_mashines");
			te_farm_mashines = TileEntityFarmMashines.class;
		}

		//transporter belt

		list_block = new Block[] {
				electric_machines,
				electric_wires,
				module_movement,
				farm_mashines
		};

		UtilSMT.UtilBlock.RegBlock(list_block);

		list_te = new Class[] {
				te_electric_machines,
				te_electric_wires,
				te_module_movement,
				te_farm_mashines
		};

		UtilSMT.UtilBlock.RegTE(list_te);

	}

}
