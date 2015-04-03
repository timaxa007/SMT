package timaxa007.pack.techno.render;

import timaxa007.pack.techno.PackTechno;
import timaxa007.pack.techno.render.block.*;
import timaxa007.pack.techno.render.item.*;
import timaxa007.pack.techno.tile.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderMain {

	//Render Model ID
	public static int block_electric_wires_modelID;
	public static int block_chip_modelID;
	public static int block_module_movement_modelID;
	public static int block_farm_mashines_modelID;

	public static void preInit() {

		block_electric_wires_modelID = -1;
		block_chip_modelID = -1;
		block_module_movement_modelID = -1;
		block_farm_mashines_modelID = -1;

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		/**Useless. Need for RenderingRegistry.registerBlockHandler**/
		//Blocks
		/*block_electric_wires_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_chip_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_module_movement_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_farm_mashines_modelID = RenderingRegistry.getNextAvailableRenderId();*/

		//Blocks
		if (PackTechno.block.electric_wires_be) {
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectricWires.class, new BlockRenderElectricWires());
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.block.electric_wires), new ItemRenderBlockElectricWires());
		}
		if (PackTechno.block.chip_be) {
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChip.class, new BlockRenderChip());
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.block.chip), new ItemRenderBlockChip());
		}
		if (PackTechno.block.module_movement_be) {
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityModuleMovement.class, new BlockRenderModuleMovement());
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.block.module_movement), new ItemRenderBlockModuleMovement());
		}
		if (PackTechno.block.farm_mashines_be) {
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFarmMashines.class, new BlockRenderFarmMashines());
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.block.farm_mashines), new ItemRenderBlockFarmMashines());
		}

		//Items

		//Entity

	}

}
