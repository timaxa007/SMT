package mods.timaxa007.pack.magic;

import mods.timaxa007.pack.magic.entity.*;
import mods.timaxa007.pack.magic.rb.*;
import mods.timaxa007.pack.magic.ri.*;
import mods.timaxa007.pack.magic.te.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyServer {

@Override
public void init() {
super.init();

renderBlockMagicCauldronModelID = RenderingRegistry.getNextAvailableRenderId();

//RenderingRegistry.addNewArmourRendererPrefix("TestArmor");

ClientRegistry.bindTileEntitySpecialRenderer(TEMagicCauldron.class, new BlockRenderMagicCauldron());

MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackMagic.proxy.blockMagicCauldron), new ItemRenderMagicCauldron());
//MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.toolMagicSword, new ItemRenderMagicSword());
MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.itemWands, new ItemRenderWands());
MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.itemStuffs, new ItemRenderStuffs());

//RenderingRegistry.registerEntityRenderingHandler(EntityArrowMini.class, new RenderArrowMini());

MinecraftForge.EVENT_BUS.register(new EventSoundMagic());

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);

}

}
