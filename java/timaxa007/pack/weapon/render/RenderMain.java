package timaxa007.pack.weapon.render;

import timaxa007.pack.weapon.PackWeapons;
import timaxa007.pack.weapon.render.block.*;
import timaxa007.pack.weapon.render.item.*;
import timaxa007.pack.weapon.tile.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderMain {

	public static int
	block_claymore_modelID
	;

	public static void preInit() {

		block_claymore_modelID = -1;

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		/**Useless. Need for RenderingRegistry.registerBlockHandler**/
		//Blocks
		/*block_claymore_modelID = RenderingRegistry.getNextAvailableRenderId();*/

		//Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityClaymore.class, new BlockRenderClaymore());

		//Blocks
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackWeapons.block.claymore), new ItemRendererClaymore());

		//Item
		MinecraftForgeClient.registerItemRenderer(PackWeapons.item.weapon, new ItemRendererWeapons());

		//Entity
		//RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderEntityBullet());

	}

}
