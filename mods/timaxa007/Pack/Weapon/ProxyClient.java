package mods.timaxa007.Pack.Weapon;

import mods.timaxa007.Lib.LangLib;
import mods.timaxa007.Pack.Weapon.Entity.EntityBullet;
import mods.timaxa007.Pack.Weapon.RenderBlocks.*;
import mods.timaxa007.Pack.Weapon.RenderItems.*;
import mods.timaxa007.Pack.Weapon.RenderItems.*;
import mods.timaxa007.Pack.Weapon.TE.TEClaymore;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ProxyClient extends ProxyServer {

//Blocks
public static int renderBlockClaymoreModelID;
Minecraft mc = Minecraft.getMinecraft();

@Override
public void init() {
super.init();
TickRegistry.registerTickHandler(new TickHandlerPackWeaponsClient(), Side.CLIENT);

renderBlockClaymoreModelID = RenderingRegistry.getNextAvailableRenderId();

//Blocks
ClientRegistry.bindTileEntitySpecialRenderer(TEClaymore.class, new BlockRenderClaymore());

//Blocks
MinecraftForgeClient.registerItemRenderer(PackWeapon.proxy.block_claymore.blockID, new ItemRendererClaymore());
//Item
MinecraftForgeClient.registerItemRenderer(PackWeapon.proxy.item_weapons.itemID, new ItemRendererWeapons());

RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderEntityBullet());

MinecraftForge.EVENT_BUS.register(new EventGUI());
MinecraftForge.EVENT_BUS.register(new EventSoundWeapon());

LangLib.registerLanguages();

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);

}

}
