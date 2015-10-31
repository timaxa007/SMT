package timaxa007.module.craft_table.event;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import timaxa007.core.CoreSMT;
import timaxa007.gui.HandlerGui;
import timaxa007.module.craft_table.CraftTable;
import timaxa007.module.craft_table.ModuleCraftTable;
import timaxa007.module.craft_table.packet.MessageCraftTableClient;
import timaxa007.module.craft_table.packet.MessageCraftTableOpenContainer;
import timaxa007.module.craft_table.packet.MessageCraftTableOpenGui;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;

public class EventCraftTable {

	@SubscribeEvent
	public void checkCraftTable(WorldEvent.Load e) {
		CraftTable.check(e.world);
		CraftTable.get(e.world).setWorld(e.world);
	}

	@SubscribeEvent
	public void breakCraftTable(BlockEvent.BreakEvent e) {
		if (e.block == Blocks.crafting_table) {
			if (CraftTable.get(e.world) != null) CraftTable.get(e.world).removeCraftTable(e.x, e.y, e.z);
		}
	}

	@SubscribeEvent
	public void addCraftTable(BlockEvent.PlaceEvent e) {
		if (e.placedBlock == Blocks.crafting_table) {
			if (CraftTable.get(e.world) != null) CraftTable.get(e.world).addCraftTable(e.x, e.y, e.z);
		}
	}

	@SubscribeEvent
	public void container(PlayerOpenContainerEvent e) {
		Container container = e.entityPlayer.openContainer;
		if (container != null && container instanceof net.minecraft.inventory.ContainerWorkbench) {
			//e.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void openCraftTable(PlayerInteractEvent e) {
		if (e.world.getBlock(e.x, e.y, e.z) == Blocks.crafting_table && 
				e.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			CraftTable ct = CraftTable.get(e.world);
			if (ct != null) {

				if (e.entityPlayer instanceof EntityPlayerMP) {
					CraftTable.BlockCraftTable bct = ct.getCraftTable(e.x, e.y, e.z);
					ModuleCraftTable.network.sendTo(new MessageCraftTableClient(bct), (EntityPlayerMP)e.entityPlayer);
				}

				e.entityPlayer.openGui(CoreSMT.instance, HandlerGui.guiID.CRAFT_TABLE.ordinal(), e.world, e.x, e.y, e.z);
				/*
				CraftTable.BlockCraftTable bct = ct.getCraftTable(e.x, e.y, e.z);
				if (bct != null) {

					if (e.entityPlayer instanceof EntityPlayerMP) {
						ModuleCraftTable.network.sendTo(new MessageCraftTableClient(bct), (EntityPlayerMP)e.entityPlayer);
						ModuleCraftTable.network.sendTo(new MessageCraftTableOpenGui(e.x, e.y, e.z), (EntityPlayerMP)e.entityPlayer);
					}

					Side side = FMLCommonHandler.instance().getEffectiveSide();
					if (side == Side.CLIENT)
						ModuleCraftTable.network.sendToServer(new MessageCraftTableOpenContainer(e.x, e.y, e.z));
				}
				*/
			}
		}
	}

}
