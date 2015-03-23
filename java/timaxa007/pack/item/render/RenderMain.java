package timaxa007.pack.item.render;

import timaxa007.pack.item.PackItems;
import timaxa007.pack.item.render.block.*;
import timaxa007.pack.item.render.item.*;
import timaxa007.pack.item.tile.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderMain {

	//public static int block_magic_cauldron_modelID;

	public static void preInit() {

		//block_magic_cauldron_modelID = -1;

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		/**Useless. Need for RenderingRegistry.registerBlockHandler**/
		//Block
		/*block_magic_cauldron_modelID = RenderingRegistry.getNextAvailableRenderId();*/

		//Block
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicCauldron.class, new BlockRenderMagicCauldron());

		//Block
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackMagic.proxy.block.magic_cauldron), new ItemRenderMagicCauldron());

		//Item
		//MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.item.wands, new ItemRenderWands());

		//RenderingRegistry.addNewArmourRendererPrefix("TestArmor");

		//Entity
		//RenderingRegistry.registerEntityRenderingHandler(EntityArrowMini.class, new RenderArrowMini());

	}

}
