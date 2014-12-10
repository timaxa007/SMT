package mods.timaxa007.pack.weapon;

import mods.timaxa007.pack.weapon.entity.EntityBullet;
import mods.timaxa007.pack.weapon.rb.*;
import mods.timaxa007.pack.weapon.ri.*;
import mods.timaxa007.pack.weapon.ri.*;
import mods.timaxa007.pack.weapon.te.TEClaymore;
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
MinecraftForgeClient.registerItemRenderer(PackWeapon.proxy.block_claymore, new ItemRendererClaymore());
//Item
MinecraftForgeClient.registerItemRenderer(PackWeapon.proxy.item_weapons.getItem(), new ItemRendererWeapons());

RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderEntityBullet());

MinecraftForge.EVENT_BUS.register(new EventGUI());
MinecraftForge.EVENT_BUS.register(new EventSoundWeapon());

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);

}

}
