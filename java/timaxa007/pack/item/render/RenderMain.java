package timaxa007.pack.item.render;

import timaxa007.pack.item.render.block.RenderBlockRockBlocks;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderMain {

	public static int rock_blocks_renderID;

	public static void preInit() {

		rock_blocks_renderID = -1;

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		//Block
		rock_blocks_renderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(rock_blocks_renderID, new RenderBlockRockBlocks(rock_blocks_renderID));
		
		//Block
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicCauldron.class, new BlockRenderMagicCauldron());

		//Block
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackMagic.block.magic_cauldron), new ItemRenderMagicCauldron());

		//Item
		//MinecraftForgeClient.registerItemRenderer(PackMagic.item.wands, new ItemRenderWands());

		//RenderingRegistry.addNewArmourRendererPrefix("TestArmor");

		//Entity
		//RenderingRegistry.registerEntityRenderingHandler(EntityArrowMini.class, new RenderArrowMini());

	}

}
