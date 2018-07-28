package smt.pack.technology.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.technology.SMTTechnology;

public final class Blocks {

	public static Block
	blocksTechnology,
	electricMachine
	;

	public static final void init() {

		blocksTechnology = new BlockBlocksTechnology().setBlockName("blocks_technology").setCreativeTab(SMTTechnology.tabTechnology);
		GameRegistry.registerBlock(blocksTechnology, "block_blocks_technology");

		electricMachine = new BlockElectricMachine().setBlockName("electric_machine").setCreativeTab(SMTTechnology.tabTechnology);
		GameRegistry.registerBlock(electricMachine, ItemBlockElectricMachine.class, "block_electric_machine");

	}

}
