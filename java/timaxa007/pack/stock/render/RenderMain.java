package timaxa007.pack.stock.render;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.entity.*;
import timaxa007.pack.stock.render.block.*;
import timaxa007.pack.stock.render.entity.*;
import timaxa007.pack.stock.render.item.*;
import timaxa007.pack.stock.tile.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderMain {

	public static int
	block_plants_modelID,
	block_foods_modelID,
	block_apiary_modelID
	;

	public static int[] list_render_id;

	public static void preInit() {

		block_plants_modelID = -1;
		block_foods_modelID = -1;
		block_apiary_modelID = -1;

		list_render_id = new int [] {
				block_plants_modelID,
				block_foods_modelID,
				block_apiary_modelID
		};

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		/**Useless. Need for RenderingRegistry.registerBlockHandler**/
		//for (int id : list_render_id) id = RenderingRegistry.getNextAvailableRenderId();

		//Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlants.class, new RenderBlockPlants());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFoods.class, new RenderBlockFoods());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityApiary.class, new RenderBlockApiary());

		//Blocks
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.block.plants), new ItemRenderBlockPlants());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.block.foods), new ItemRenderFoods());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.block.apiary), new ItemRenderBlockApiary());

		//Items

		//Entity
		RenderingRegistry.registerEntityRenderingHandler(EntityTest.class, new RenderEntityTest());

	}

}
