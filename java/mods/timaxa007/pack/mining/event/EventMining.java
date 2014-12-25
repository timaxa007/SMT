package mods.timaxa007.pack.mining.event;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventMining {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropCobblestone(BlockEvent.HarvestDropsEvent e) {
		if (e.block == Blocks.cobblestone) {
			e.drops.clear();
			if (e.world.rand.nextInt(100) < 60) {
				e.drops.add(new ItemStack(Blocks.cobblestone, 1 + e.world.rand.nextInt(5), 0));
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropMossyCobblestone(BlockEvent.HarvestDropsEvent e) {
		if (e.block == Blocks.mossy_cobblestone) {
			e.drops.clear();
			if (e.world.rand.nextInt(100) < 25) {
				e.drops.add(new ItemStack(Blocks.mossy_cobblestone, 1 + e.world.rand.nextInt(2), 0));
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropIronOre(BlockEvent.HarvestDropsEvent e) {
		if (e.block == Blocks.iron_ore) {
			e.drops.clear();
			if (e.world.rand.nextInt(100) < 3) {
				e.drops.add(new ItemStack(Blocks.iron_ore, 1 + e.world.rand.nextInt(1), 0));
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropCoalOre(BlockEvent.HarvestDropsEvent e) {
		if (e.block == Blocks.coal_ore) {
			e.drops.clear();
			if (e.world.rand.nextInt(100) < 7) {
				e.drops.add(new ItemStack(Blocks.coal_ore, 1 + e.world.rand.nextInt(2), 0));
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropLapisOre(BlockEvent.HarvestDropsEvent e) {
		if (e.block == Blocks.lapis_ore) {
			e.drops.clear();
			if (e.world.rand.nextInt(100) < 2) {
				e.drops.add(new ItemStack(Blocks.lapis_ore, 3 + e.world.rand.nextInt(5), 0));
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropGoldOre(BlockEvent.HarvestDropsEvent e) {
		if (e.block == Blocks.gold_ore) {
			e.drops.clear();
			if (e.world.rand.nextInt(1000) < 8) {
				e.drops.add(new ItemStack(Blocks.gold_ore, 1 + e.world.rand.nextInt(1), 0));
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
