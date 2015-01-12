package mods.timaxa007.pack.magic.render;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.pack.magic.render.block.*;
import mods.timaxa007.pack.magic.render.item.*;
import mods.timaxa007.pack.magic.tile.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderMain {

	public static int block_magic_cauldron_modelID;

	public static void preInit() {

		block_magic_cauldron_modelID = -1;

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		/**Useless. Need for RenderingRegistry.registerBlockHandler**/
		//Block
		/*block_magic_cauldron_modelID = RenderingRegistry.getNextAvailableRenderId();*/

		//Block
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicCauldron.class, new BlockRenderMagicCauldron());

		//Block
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackMagic.proxy.block.magic_cauldron), new ItemRenderMagicCauldron());

		//Item
		//MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.toolMagicSword, new ItemRenderMagicSword());
		MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.item.wands, new ItemRenderWands());
		MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.item.stuffs, new ItemRenderStuffs());

		//RenderingRegistry.addNewArmourRendererPrefix("TestArmor");

		//Entity
		//RenderingRegistry.registerEntityRenderingHandler(EntityArrowMini.class, new RenderArrowMini());

	}

}
