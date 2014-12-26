package mods.timaxa007.pack.techno.render;

import mods.timaxa007.pack.techno.PackTechno;
import mods.timaxa007.pack.techno.render.block.*;
import mods.timaxa007.pack.techno.render.item.*;
import mods.timaxa007.pack.techno.tile.*;
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

	public static void preInit() {

		block_electric_wires_modelID = -1;
		block_chip_modelID = -1;
		block_module_movement_modelID = -1;

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		/**Useless. Need for RenderingRegistry.registerBlockHandler**/
		//Blocks
		/*block_electric_wires_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_chip_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_module_movement_modelID = RenderingRegistry.getNextAvailableRenderId();*/

		//Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectricWires.class, new BlockRenderElectricWires());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChip.class, new BlockRenderChip());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityModuleMovement.class, new BlockRenderModuleMovement());

		//Blocks
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.proxy.block.electric_wires), new ItemRenderBlockElectricWires());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.proxy.block.chip), new ItemRenderBlockChip());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.proxy.block.module_movement), new ItemRenderBlockModuleMovement());

		//Items

		//Entity

	}

}
