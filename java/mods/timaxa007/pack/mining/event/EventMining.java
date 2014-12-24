package mods.timaxa007.pack.mining.event;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventMining {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void drop(BlockEvent.HarvestDropsEvent e) {
		if (e.block == Blocks.iron_ore) {
			e.drops.clear();
			e.drops.add(new ItemStack(PackMining.proxy.item.items_for_mining, 1, 0));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
