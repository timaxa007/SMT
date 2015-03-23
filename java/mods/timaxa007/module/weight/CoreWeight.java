package mods.timaxa007.module.weight;

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

@Mod (modid = CoreWeight.MODID, name = CoreWeight.MODNAME, version = CoreWeight.VERSION)

public class CoreWeight {

	public static final String MODID = "weight";
	public static final String MODNAME = "SystemWeight";
	public static final String VERSION = "0.2a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	@Instance(CoreWeight.MODID) public static CoreWeight instance;
	public static SimpleNetworkWrapper network;

	public static Item upgradeWeight;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		upgradeWeight = new ItemUpgradeWeight();
		GameRegistry.registerItem(upgradeWeight, "ItemUpgradeWeight");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(CoreWeight.MODID);
		network.registerMessage(MessageWeight.Handler.class, MessageWeight.class, 0, Side.CLIENT);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new EventWeight.Player());
		FMLCommonHandler.instance().bus().register(new EventWeight.Common());
	}

}
