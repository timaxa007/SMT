package mods.timaxa007.pack.weapon;

import mods.timaxa007.pack.weapon.PackWeapon;
import mods.timaxa007.pack.weapon.ProxyServer;
import mods.timaxa007.pack.weapon.render.block.*;
import mods.timaxa007.pack.weapon.render.item.*;
import mods.timaxa007.pack.weapon.event.EventWeaponsClient;
import mods.timaxa007.pack.weapon.tile.*;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyServer {

	//Blocks
	public static int renderBlockClaymoreModelID;
	Minecraft mc = Minecraft.getMinecraft();

	@Override
	public void init() {
		super.init();

		//Blocks
		renderBlockClaymoreModelID = RenderingRegistry.getNextAvailableRenderId();

		//Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityClaymore.class, new BlockRenderClaymore());

		//Blocks
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackWeapon.proxy.block.claymore), new ItemRendererClaymore());
		
		//Item
		MinecraftForgeClient.registerItemRenderer(PackWeapon.proxy.item.weapons, new ItemRendererWeapons());

		//Entity
		//RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderEntityBullet());

		MinecraftForge.EVENT_BUS.register(new EventWeaponsClient());

	}

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

	}

}
