package timaxa007.pack.techno.render;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import timaxa007.pack.techno.PackTechno;
import timaxa007.pack.techno.entity.*;
import timaxa007.pack.techno.render.block.*;
import timaxa007.pack.techno.render.entity.*;
import timaxa007.pack.techno.render.item.*;
import timaxa007.pack.techno.render.model.*;
import timaxa007.pack.techno.tile.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderMain {

	//Render Model ID
	public static int
	block_electric_wires_modelID,
	block_chip_modelID,
	block_module_movement_modelID
	;

	public static int[] list_render_id;

	public static void preInit() {

		block_electric_wires_modelID = -1;
		block_chip_modelID = -1;
		block_module_movement_modelID = -1;

		list_render_id = new int[] {
				block_electric_wires_modelID,
				block_chip_modelID,
				block_module_movement_modelID
		};

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		/**Useless. Need for RenderingRegistry.registerBlockHandler**/
		//for (int id : list_render_id) id = RenderingRegistry.getNextAvailableRenderId();

		//Blocks
		if (PackTechno.block.electric_wires_be) {
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectricWires.class, new BlockRenderElectricWires());
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.block.electric_wires), new ItemRenderBlockElectricWires());
		}
		if (PackTechno.block.module_movement_be) {
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityModuleMovement.class, new BlockRenderModuleMovement());
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.block.module_movement), new ItemRenderBlockModuleMovement());
		}
		//Items

		//Entity
		RenderingRegistry.registerEntityRenderingHandler(EntityElectricRobot.class, new RenderEntityElectricRobot(new ModelRobot(), 1.0F));

	}

}
