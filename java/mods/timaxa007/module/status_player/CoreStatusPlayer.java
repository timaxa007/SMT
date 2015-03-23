package mods.timaxa007.module.status_player;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod (modid = CoreStatusPlayer.MODID, name = CoreStatusPlayer.MODNAME, version = CoreStatusPlayer.VERSION)

public class CoreStatusPlayer {

	public static final String MODID = "status_player";
	public static final String MODNAME = "StatusPlayer";
	public static final String VERSION = "0.2a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	@Instance(CoreStatusPlayer.MODID) public static CoreStatusPlayer instance;
	public static SimpleNetworkWrapper network;

	public static Item upgradeWeight;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		upgradeWeight = new ItemStatusPlayer();
		GameRegistry.registerItem(upgradeWeight, "ItemUpgradeWeight");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(CoreStatusPlayer.MODID);
		network.registerMessage(MessageEnvironment.Handler.class, MessageEnvironment.class, 0, Side.CLIENT);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new EventStatusPlayer.Player());
		FMLCommonHandler.instance().bus().register(new EventStatusPlayer.Common());
	}

}
