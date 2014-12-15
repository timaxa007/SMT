package mods.timaxa007.pack.weapon;

import mods.timaxa007.pack.weapon.entity.*;
import mods.timaxa007.pack.weapon.rb.*;
import mods.timaxa007.pack.weapon.ri.*;
import mods.timaxa007.pack.weapon.ri.*;
import mods.timaxa007.pack.weapon.te.TEClaymore;
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

renderBlockClaymoreModelID = RenderingRegistry.getNextAvailableRenderId();

//Blocks
ClientRegistry.bindTileEntitySpecialRenderer(TEClaymore.class, new BlockRenderClaymore());

//Blocks
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackWeapon.proxy.block_claymore), new ItemRendererClaymore());
//Item
MinecraftForgeClient.registerItemRenderer(PackWeapon.proxy.item_weapons, new ItemRendererWeapons());

//RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderEntityBullet());

MinecraftForge.EVENT_BUS.register(new EventGUI());
MinecraftForge.EVENT_BUS.register(new EventSoundWeapon());

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);

}

}
