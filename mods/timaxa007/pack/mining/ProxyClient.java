package mods.timaxa007.pack.mining;

import mods.timaxa007.pack.mining.rb.*;
import mods.timaxa007.pack.mining.ri.*;
import mods.timaxa007.pack.mining.te.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ProxyClient extends ProxyServer{

@Override
public void init() {
super.init();
TickRegistry.registerTickHandler(new TickHandlerPackMiningClient(), Side.CLIENT);

MinecraftForge.EVENT_BUS.register(new EventSoundMining());

render_block_cristals_modelID = RenderingRegistry.getNextAvailableRenderId();

ClientRegistry.bindTileEntitySpecialRenderer(TEBlockCristals.class, new RenderBlockCristals());
ClientRegistry.bindTileEntitySpecialRenderer(TEOreOres.class, new RenderBlockOreOres());

MinecraftForgeClient.registerItemRenderer(PackMining.proxy.block_cristals.blockID, new ItemRenderBlockCristals());

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);

}

}
