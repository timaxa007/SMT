package mods.timaxa007.Pack.Magic;

import mods.timaxa007.Lib.LangLib;
import mods.timaxa007.Pack.Magic.Entity.*;
import mods.timaxa007.Pack.Magic.RendererBlocks.*;
import mods.timaxa007.Pack.Magic.RendererItems.*;
import mods.timaxa007.Pack.Magic.TE.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


public class ProxyClient extends ProxyServer {

@Override
public void init() {
super.init();
TickRegistry.registerTickHandler(new TickHandlerPackMagicClient(), Side.CLIENT);

renderBlockMagicCauldronModelID = RenderingRegistry.getNextAvailableRenderId();

//RenderingRegistry.addNewArmourRendererPrefix("TestArmor");

ClientRegistry.bindTileEntitySpecialRenderer(TEMagicCauldron.class, new BlockRenderMagicCauldron());

MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.blockMagicCauldron.blockID, new ItemRenderMagicCauldron());
MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.toolMagicSword.itemID, new ItemRenderMagicSword());
MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.itemWands.itemID, new ItemRenderWands());
MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.itemStuffs.itemID, new ItemRenderStuffs());

RenderingRegistry.registerEntityRenderingHandler(EntityArrowMini.class, new RenderArrowMini());

MinecraftForge.EVENT_BUS.register(new EventSoundMagic());

LangLib.registerLanguages();

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);

}

}
