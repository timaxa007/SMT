package timaxa007.pack.stock.render;

import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.entity.EntityTest;
import timaxa007.pack.stock.render.block.*;
import timaxa007.pack.stock.render.entity.*;
import timaxa007.pack.stock.render.item.*;
import timaxa007.pack.stock.tile.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderMain {

	public static int block_germination_plants_modelID;
	public static int block_foods_modelID;
	public static int block_apiary_modelID;

	public static void preInit() {

		block_germination_plants_modelID = -1;
		block_foods_modelID = -1;
		block_apiary_modelID = -1;

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		/**Useless. Need for RenderingRegistry.registerBlockHandler**/
		//Blocks
		/*block_germination_plants_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_foods_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_apiary_modelID = RenderingRegistry.getNextAvailableRenderId();*/

		//Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGerminationPlants.class, new RenderBlockGerminationPlants());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFoods.class, new RenderBlockFoods());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityApiary.class, new RenderBlockApiary());

		//Blocks
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.proxy.block.germination_plants), new ItemRenderBlockGerminationPlants());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.proxy.block.foods), new ItemRenderFoods());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.proxy.block.apiary), new ItemRenderBlockApiary());

		//Items

		//Entity
		RenderingRegistry.registerEntityRenderingHandler(EntityTest.class, new RenderEntityTest());

	}

}
