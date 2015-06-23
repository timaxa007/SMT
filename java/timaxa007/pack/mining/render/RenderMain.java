package timaxa007.pack.mining.render;

import timaxa007.pack.mining.PackMining;
import timaxa007.pack.mining.render.block.*;
import timaxa007.pack.mining.render.item.*;
import timaxa007.pack.mining.tile.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderMain {

	public static int block_cristals_modelID;
	public static int block_ore_modelID;

	public static void preInit() {

		block_cristals_modelID = -1;
		block_ore_modelID = -1;

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		/**Useless. Need for RenderingRegistry.registerBlockHandler**/
		//Block
		/*block_cristals_modelID = RenderingRegistry.getNextAvailableRenderId();*/

		//Block
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCristals.class, new RenderBlockCristals());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOreOres.class, new RenderBlockOreOres());

		//Block
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackMining.block.cristals), new ItemRenderBlockCristals());

		//Item

		//Entity

	}

}
