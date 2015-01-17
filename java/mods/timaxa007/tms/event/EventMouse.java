package mods.timaxa007.tms.event;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.MessageMouseKey;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.BlockEvent;

import org.lwjgl.input.Mouse;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**Only Mouse. And we need him to take this action buttons of the game settings.**/
@Deprecated
public class EventMouse {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onLeftClick(MouseEvent m) {
		if (m.button == 0) {
			//if (Core.show_system_info_testing) System.out.println("onLeftClick");
			Core.network.sendToServer(new MessageMouseKey(1, m.buttonstate));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onRightClick(MouseEvent m) {
		if (m.button == 1) {
			//if (Core.show_system_info_testing) System.out.println("onRightClick");
			Core.network.sendToServer(new MessageMouseKey(2, m.buttonstate));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent(priority = EventPriority.LOW)
	public void onLeftClickTick(LivingUpdateEvent p) {
		if (Mouse.isButtonDown(0) && 
				(!(Minecraft.getMinecraft().currentScreen instanceof GuiScreen)) && 
				p.entityLiving instanceof EntityPlayer) {
			//if (Core.show_system_info_testing) System.out.println("onLeftClickTick");
			Core.network.sendToServer(new MessageMouseKey(3, true));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent(priority = EventPriority.LOW)
	public void onRightClickTick(LivingUpdateEvent p) {
		if (Mouse.isButtonDown(1) && 
				(!(Minecraft.getMinecraft().currentScreen instanceof GuiScreen)) && 
				p.entityLiving instanceof EntityPlayer) {
			//if (Core.show_system_info_testing) System.out.println("onRightClick");
			Core.network.sendToServer(new MessageMouseKey(4, true));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void hasPlayerTool(BlockEvent.BreakEvent e) {
		ItemStack current = e.getPlayer().getCurrentEquippedItem();
		if (current != null && current.getItem() == null) {
			System.out.println("isBreakBlock " + e.block.getUnlocalizedName() + ".");
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
